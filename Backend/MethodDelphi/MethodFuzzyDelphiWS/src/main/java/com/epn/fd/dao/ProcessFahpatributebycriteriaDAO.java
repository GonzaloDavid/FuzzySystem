/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.AttributeProcessContainer;
import com.epn.dtos.AttributeProcessContainer1;
import com.epn.dtos.AttributesMatrixValueContainer;
import com.epn.dtos.CriteriabycodefahpContainer;
import com.epn.dtos.ProcessAttributeContainer;
import com.epn.dtos.ProcessFahpatributebycriteriaContainer;
import com.epn.dtos.SentemailbycodefahpContainer;
import com.epn.dtos.SurveybycodefahpContainer;
import com.epn.entities.AttributesMatrixAverageValue;
import com.epn.entities.AttributesMatrixAverageValuePK;
import com.epn.entities.AttributesMatrixValuePK;
import com.epn.entities.FilterTypes;
import com.epn.entities.ProcessFahpatributebycriteria;
import com.epn.entities.ProcessFahpatributebycriteriaPK;
import com.epn.entities.ProcessFahpweightbycriteria;
import com.epn.entities.ResultFAHP;
import com.epn.entities.ResultFAHPPK;
import com.epn.entities.SearchObject;
import com.epn.mapper.ProcessFahpatributebycriteriaMapper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author david
 */
@Stateless
public class ProcessFahpatributebycriteriaDAO extends GenericDAO<ProcessFahpatributebycriteria> {

    @Inject()
    AttributesMatrixValueDAO matrixValueDAO;

    @Inject()
    SurveybycodefahpDAO surveybycodefahpDAO;

    @Inject()
    AttributesMatrixAverageValueDAO attributesMatrixAverageValueDAO;

    @Inject()
    ProcessFahpweightbycriteriaDAO fahpweightbycriteriaDAO;

    @Inject()
    ResultFAHPDAO resultFAHPDAO;

    private final ProcessFahpatributebycriteriaMapper mapper = Mappers.getMapper(ProcessFahpatributebycriteriaMapper.class);

    public ProcessFahpatributebycriteriaDAO() {
        super(ProcessFahpatributebycriteria.class);
    }

    public List<ProcessFahpatributebycriteriaContainer> getprocesslistbycodefahp(Long codefahp) {
        SearchObject search = new SearchObject("processFahpatributebycriteriaPK");
        search.addParameter("processFahpatributebycriteriaPK.codefahp", FilterTypes.EQUAL, codefahp);
        search.setOrderPropertyName("processFahpatributebycriteriaPK.codefahp");
        search.asc();

        List<ProcessFahpatributebycriteria> resultList = search(search);
        List<ProcessFahpatributebycriteriaContainer> processcontainer = mapper.sourceListToDestination(resultList);
        return processcontainer;
    }

    public void save(ProcessFahpatributebycriteria processFahpatributebycriteria) {
        update(processFahpatributebycriteria);
    }

    public void calculate_attributeAverage(
            List<CriteriabycodefahpContainer> criteriaList,
            List<SentemailbycodefahpContainer> personListanswered,
            Long codefahp) {
        List<AttributesMatrixValueContainer> attibutedataList = new ArrayList();
        //Unir los datos de atributos 
        personListanswered.forEach(personanswered -> {
            Long codeperson = personanswered.getSentemailbycodefahpPK().getCodePerson();
            List<AttributesMatrixValueContainer> attibutedatabyperson = matrixValueDAO.getMatrixvaluelist(codefahp, codeperson);
            attibutedatabyperson.forEach(attibutedata -> {
                attibutedataList.add(attibutedata);
            });
        });
        //Obtener el promedio
        List<SurveybycodefahpContainer> survey = surveybycodefahpDAO.getquizbycodefahp(codefahp);
        criteriaList.forEach(criteria -> {
            survey.forEach(question -> {
                question.getItemquestioncontainer().forEach(item -> {
                    question.getItemquestioncontainer().forEach(itemcouple -> {
                        List<AttributesMatrixValueContainer> attibutefilteredbyRow = attibutedataList.stream()
                                .filter(filterAttributeData -> filterAttributeData.getAttributesMatrixValuePK().getCodeCriteria() == criteria.getCriteriabycodefahpPK().getCodeCriteria()
                                        && filterAttributeData.getAttributesMatrixValuePK().getCodeQuestions() == question.getSurveybycodefahpPK().getCodeQuestions()
                                        && filterAttributeData.getAttributesMatrixValuePK().getItemLabel() == item.getQuestionItemPK().getCodeQuizItem()
                                        && filterAttributeData.getAttributesMatrixValuePK().getItemLabelCouple() == itemcouple.getQuestionItemPK().getCodeQuizItem())
                                .collect(Collectors.toList());
                        if (attibutefilteredbyRow.size() > 0) {
                            //Guardar en Tabla promedio de atributos
                            AttributesMatrixAverageValue averageValue = calculate_Average(attibutefilteredbyRow);
                            attributesMatrixAverageValueDAO.save(averageValue);
                        }
                    });
                });
            });
        });
        //Calcular pesos de atributos
        List<AttributeProcessContainer> attributeweigthAux = new ArrayList();
        List<AttributesMatrixAverageValue> attributeValueAverage = attributesMatrixAverageValueDAO.getAverageData(codefahp);
        criteriaList.forEach(criteria -> {
            survey.forEach(question -> {
                List<AttributeProcessContainer> attributeProcessList = new ArrayList();
                question.getItemquestioncontainer().forEach(item -> {
                    //question.getItemquestioncontainer().forEach(itemcouple -> {
                    List<AttributesMatrixAverageValue> attibutedatafiltered = attributeValueAverage.stream()
                            .filter(attributeAverage -> attributeAverage.getAttributesMatrixAverageValuePK().getItemLabel() == item.getQuestionItemPK().getCodeQuizItem()
                                    && attributeAverage.getAttributesMatrixAverageValuePK().getCodeQuestions() == item.getQuestionItemPK().getCodeQuestions()
                                    && attributeAverage.getAttributesMatrixAverageValuePK().getCodeCriteria() == criteria.getCriteriabycodefahpPK().getCodeCriteria()
                                    && attributeAverage.getAttributesMatrixAverageValuePK().getCodefahp() == codefahp)
                            .collect(Collectors.toList());
                    List<Double> tfnbyAttribute = calculate_diffuseTriangularNumber(attibutedatafiltered);

                    AttributeProcessContainer attributeProcessContainer = new AttributeProcessContainer();
                    attributeProcessContainer.setCodeItem(item.getQuestionItemPK().getCodeQuizItem());
                    attributeProcessContainer.setCodefahp(codefahp);
                    attributeProcessContainer.setCodeQuiz(item.getQuestionItemPK().getCodeQuiz());
                    attributeProcessContainer.setCodeQuestion(question.getSurveybycodefahpPK().getCodeQuestions());
                    attributeProcessContainer.setCodecriteria(criteria.getCriteriabycodefahpPK().getCodeCriteria());
                    attributeProcessContainer.setTriangularNumber(tfnbyAttribute);
                    attributeProcessList.add(attributeProcessContainer);// }); 

                });
                //CALCULANDO TOTALES
                List<Double> lowerarray = new ArrayList();
                List<Double> mediumarray = new ArrayList();
                List<Double> upperarray = new ArrayList();

                attributeProcessList.forEach(attribut -> {
                    lowerarray.add(attribut.getTriangularNumber().get(0));
                    mediumarray.add(attribut.getTriangularNumber().get(1));
                    upperarray.add(attribut.getTriangularNumber().get(2));
                });

                double lowertotalsum = lowerarray.stream().reduce(0.0, (a, b) -> a + b);
                double mediumtotalsum = mediumarray.stream().reduce(0.0, (a, b) -> a + b);
                double uppertotalsum = upperarray.stream().reduce(0.0, (a, b) -> a + b);

                //NORMALIZANDO LOS TFN
                attributeProcessList.forEach(attribut -> {
                    double lower = (attribut.getTriangularNumber().get(0)) / (1 / uppertotalsum);
                    double medium = (attribut.getTriangularNumber().get(1)) / (1 / mediumtotalsum);
                    double upper = (attribut.getTriangularNumber().get(2)) / (1 / lowertotalsum);

                    List<Double> normalizedTFN = new ArrayList();
                    normalizedTFN.add(lower);
                    normalizedTFN.add(medium);
                    normalizedTFN.add(upper);
                    attribut.setTriangularNumberNormalized(normalizedTFN);
                });
                //defusificacion
                attributeProcessList.forEach(attribut -> {
                    double defuzzy = ((attribut.getTriangularNumberNormalized().get(0) + attribut.getTriangularNumberNormalized().get(1) + attribut.getTriangularNumberNormalized().get(2)) / 3);
                    attribut.setDefusification(defuzzy);
                });
                //total defusificacion
                List<Double> totalDefuzzyList = new ArrayList();
                attributeProcessList.forEach(attribut -> {
                    totalDefuzzyList.add(attribut.getDefusification());
                });
                double totaldefuzzy = totalDefuzzyList.stream().reduce(0.0, (a, b) -> a + b);
                //Calculando pesos
                attributeProcessList.forEach(attribut -> {
                    double weigth = (attribut.getDefusification() / totaldefuzzy);
                    attribut.setWeigth(weigth);
                    //Guardar pesos
                    ProcessFahpatributebycriteriaPK processFahpatributebycriteriaPK = new ProcessFahpatributebycriteriaPK();
                    processFahpatributebycriteriaPK.setCodeCriteria(attribut.getCodecriteria());
                    processFahpatributebycriteriaPK.setCodeQuestions(attribut.getCodeQuestion());
                    processFahpatributebycriteriaPK.setCodeQuiz(attribut.getCodeQuiz());
                    processFahpatributebycriteriaPK.setCodeQuizItem(attribut.getCodeItem());
                    processFahpatributebycriteriaPK.setCodefahp(attribut.getCodefahp());
                    ProcessFahpatributebycriteria attributeweigth = new ProcessFahpatributebycriteria(processFahpatributebycriteriaPK);
                    attributeweigth.setWeight(new BigDecimal(weigth));

                    save(attributeweigth);
                    attributeweigthAux.add(attribut);
                });
            });
        });
        //Multiplicacion entre matriz de criterios y pesos de atributos por criterios
        List<ProcessFahpweightbycriteria> criteriaweigthList = fahpweightbycriteriaDAO.getcriteriaWeightbycodefahp(codefahp);

        survey.forEach(question -> {
            question.getItemquestioncontainer().forEach(item -> {

                List<AttributeProcessContainer> weightbyAttribute = attributeweigthAux.stream()
                        .filter(filteredWeight -> filteredWeight.getCodeQuestion() == question.getSurveybycodefahpPK().getCodeQuestions()
                                && filteredWeight.getCodeQuiz() == question.getSurveybycodefahpPK().getCodeQuiz()
                                && filteredWeight.getCodeItem() == item.getQuestionItemPK().getCodeQuizItem())
                        .collect(Collectors.toList());

                List<Double> sumList = new ArrayList();
                weightbyAttribute.forEach(attibutebycriteria -> {
                    criteriaweigthList.forEach(criteriaweigth -> {
                        if (attibutebycriteria.getCodecriteria() == criteriaweigth.getProcessFahpweightbycriteriaPK().getCodeCriteria()) {
                            double weightcriteria = (criteriaweigth.getWeight().doubleValue() / 100);
                            double suma = (weightcriteria * attibutebycriteria.getWeigth());
                            sumList.add(suma);
                        }
                    });
                });
                if (weightbyAttribute.size() > 0) {
                    ResultFAHPPK resultFAHPPK = new ResultFAHPPK();
                    resultFAHPPK.setCodeQuestions(weightbyAttribute.get(0).getCodeQuestion());
                    resultFAHPPK.setCodeQuiz(weightbyAttribute.get(0).getCodeQuiz());
                    resultFAHPPK.setCodeQuizItem(weightbyAttribute.get(0).getCodeItem());
                    resultFAHPPK.setCodefahp(weightbyAttribute.get(0).getCodefahp());
                    double calculatesum = sumList.stream().reduce(0.0, (a, b) -> a + b);
                    calculatesum=(calculatesum*100);
                    ResultFAHP resultFAHP = new ResultFAHP(resultFAHPPK);
                    resultFAHP.setWeight(new BigDecimal(calculatesum));
                    resultFAHPDAO.save(resultFAHP);
                }
            });
        });
    }

    public List<Double> calculate_diffuseTriangularNumber(List<AttributesMatrixAverageValue> attibutedatafiltered) {
        List<Double> lowerArray = new ArrayList();
        List<Double> mediaArray = new ArrayList();
        List<Double> upperArray = new ArrayList();
        List<Double> triangularNumber = new ArrayList();
        attibutedatafiltered.forEach(databycriteria -> {

            String valueCat = databycriteria.getValuecriteriaFAHP();
            String[] parts = valueCat.split(",");
            String part1 = parts[0].trim();
            String part2 = "";
            String part3 = "";
            if (parts.length > 1) {
                part2 = parts[1].trim();
                part3 = parts[2].trim();
            } else {
                part2 = "1";
                part3 = "1";
            }

            lowerArray.add(stringtoDouble(part1));
            mediaArray.add(stringtoDouble(part2));
            upperArray.add(stringtoDouble(part3));
        });
        double lowervalue = lowerArray.stream().reduce(1.0, (a, b) -> a * b);
        double mediavalue = mediaArray.stream().reduce(1.0, (a, b) -> a * b);
        double uppervalue = upperArray.stream().reduce(1.0, (a, b) -> a * b);

        double exponent = (1.0 / attibutedatafiltered.size());
        double lowervaluepow = Math.pow(lowervalue, exponent);
        double mediavaluepow = Math.pow(mediavalue, exponent);
        double uppervaluepow = Math.pow(uppervalue, exponent);

        triangularNumber.add(lowervaluepow);
        triangularNumber.add(mediavaluepow);
        triangularNumber.add(uppervaluepow);
        return triangularNumber;
    }

    public AttributesMatrixAverageValue calculate_Average(List<AttributesMatrixValueContainer> attibutefilteredbyRow) {
        List<ProcessAttributeContainer> attributeContainerList = new ArrayList();
        attibutefilteredbyRow.forEach(attributtebyRow -> {
            ProcessAttributeContainer attributeContainer = new ProcessAttributeContainer();
            List<Double> tfn = convertStringtoTFN(attributtebyRow.getValuecriteriaFAHP());
            attributeContainer.setAttributesMatrixValuePK(attributtebyRow.getAttributesMatrixValuePK());
            attributeContainer.setTfn(tfn);
            attributeContainerList.add(attributeContainer);
        });
        //Calcular los promedios de bajo, medio y alto

        List<Double> lowerarray = new ArrayList();
        List<Double> mediumarray = new ArrayList();
        List<Double> upperarray = new ArrayList();

        attributeContainerList.forEach(attribute -> {
            lowerarray.add(attribute.getTfn().get(0));
            mediumarray.add(attribute.getTfn().get(1));
            upperarray.add(attribute.getTfn().get(2));
        });

        double lowertotalsum = lowerarray.stream().reduce(0.0, (a, b) -> a + b);
        double mediumtotalsum = mediumarray.stream().reduce(0.0, (a, b) -> a + b);
        double uppertotalsum = upperarray.stream().reduce(0.0, (a, b) -> a + b);

        double lower = (lowertotalsum / lowerarray.size());
        double medium = (mediumtotalsum / mediumarray.size());
        double upper = (uppertotalsum / upperarray.size());

        String newvalueFahp = lower + "," + medium + "," + upper;
        AttributesMatrixValuePK attributesMatrixValuePK = attributeContainerList.get(0).getAttributesMatrixValuePK();
        AttributesMatrixAverageValuePK attributesMatrixAverageValuePK = new AttributesMatrixAverageValuePK();
        attributesMatrixAverageValuePK.setCodeCriteria(attributesMatrixValuePK.getCodeCriteria());
        attributesMatrixAverageValuePK.setCodeQuestions(attributesMatrixValuePK.getCodeQuestions());
        attributesMatrixAverageValuePK.setCodeQuiz(attributesMatrixValuePK.getCodeQuiz());
        attributesMatrixAverageValuePK.setCodefahp(attributesMatrixValuePK.getCodefahp());
        attributesMatrixAverageValuePK.setItemLabel(attributesMatrixValuePK.getItemLabel());
        attributesMatrixAverageValuePK.setItemLabelCouple(attributesMatrixValuePK.getItemLabelCouple());

        AttributesMatrixAverageValue attributesMatrixAverageValue = new AttributesMatrixAverageValue(attributesMatrixAverageValuePK);
        attributesMatrixAverageValue.setValuecriteriaFAHP(newvalueFahp);
        attributesMatrixAverageValue.setValuecriteriaFAHPCatt("VALUEFAHPCAT");
        return attributesMatrixAverageValue;
    }

    public List<Double> convertStringtoTFN(String valuefahpCat) {
        List<Double> tfn = new ArrayList();
        String valueCat = valuefahpCat;
        String[] parts = valueCat.split(",");
        String part1 = parts[0].trim();
        String part2 = "";
        String part3 = "";
        if (parts.length > 1) {
            part2 = parts[1].trim();
            part3 = parts[2].trim();
        } else {
            part2 = "1";
            part3 = "1";
        }

        tfn.add(stringtoDouble(part1));
        tfn.add(stringtoDouble(part2));
        tfn.add(stringtoDouble(part3));
        return tfn;
    }

    public double stringtoDouble(String value) {
        double valueconvert = 0.0;
        int intIndex = value.indexOf("/");
        if (intIndex != - 1) {
            String[] parts = value.split("/");
            String part1 = parts[0].trim();
            String part2 = parts[1].trim();
            double numerator = Double.parseDouble(part1);
            double denominator = Double.parseDouble(part2);
            valueconvert = (numerator / denominator);
        } else {
            valueconvert = Double.parseDouble(value);
        }
        return valueconvert;
    }
}
