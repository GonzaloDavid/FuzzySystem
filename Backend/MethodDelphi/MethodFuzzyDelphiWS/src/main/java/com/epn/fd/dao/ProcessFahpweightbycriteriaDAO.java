            /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.CriteriaMatrixValueContainer;
import com.epn.dtos.CriteriabycodefahpContainer;
import com.epn.dtos.CriteriaprocessContainer;
import com.epn.dtos.ProcessFahpweightbycriteriaContainer;
import com.epn.dtos.SentemailbycodefahpContainer;
import com.epn.entities.CriteriaMatrixAverageValue;
import com.epn.entities.CriteriaMatrixAverageValuePK;
import com.epn.entities.FilterTypes;
import com.epn.entities.ProcessFahpweightbycriteria;
import com.epn.entities.ProcessFahpweightbycriteriaPK;
import com.epn.entities.SearchObject;
import com.epn.mapper.ProcessFahpweightbycriteriaMapper;
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
public class ProcessFahpweightbycriteriaDAO extends GenericDAO<ProcessFahpweightbycriteria> {

    @Inject()
    CriteriaMatrixValueDAO matrixValueDAO;

    @Inject()
    SentemailbycodefahpDAO sentemailbycodefahpDAO;

    @Inject()
    CriteriabycodefahpDAO criteriabycodefahpDAO;

    @Inject()
    CriteriaMatrixAverageValueDAO criteriaMatrixAverageValueDAO;

    @Inject()
    ProcessFahpconsistencybycriteriaDAO fahpconsistencybycriteriaDAO;

    @Inject()
    ProcessFahpatributebycriteriaDAO fahpatributebycriteriaDAO;
    private final ProcessFahpweightbycriteriaMapper mapper = Mappers.getMapper(ProcessFahpweightbycriteriaMapper.class);

    public ProcessFahpweightbycriteriaDAO() {
        super(ProcessFahpweightbycriteria.class);
    }

    public List<ProcessFahpweightbycriteriaContainer> getprocesslistbycodefahp(Long codefahp) {
        SearchObject search = new SearchObject("processFahpweightbycriteriaPK");
        search.addParameter("processFahpweightbycriteriaPK.codefahp", FilterTypes.EQUAL, codefahp);
        search.setOrderPropertyName("processFahpweightbycriteriaPK.codefahp");
        search.asc();

        List<ProcessFahpweightbycriteria> resultList = search(search);
        List<ProcessFahpweightbycriteriaContainer> processcontainer = mapper.sourceListToDestination(resultList);
        return processcontainer;
    }
    public List<ProcessFahpweightbycriteria> getcriteriaWeightbycodefahp(Long codefahp) {
        SearchObject search = new SearchObject("processFahpweightbycriteriaPK");
        search.addParameter("processFahpweightbycriteriaPK.codefahp", FilterTypes.EQUAL, codefahp);
        search.setOrderPropertyName("processFahpweightbycriteriaPK.codefahp");
        search.asc();

        List<ProcessFahpweightbycriteria> resultList = search(search);
        return resultList;
    }

    public void save(ProcessFahpweightbycriteria fahpweightbycriteria) {
        update(fahpweightbycriteria);
    }

    public void executeFAHP(Long codefahp) {
        //obtenemos los criterios utilizados en este proceso
        List<CriteriabycodefahpContainer> criteriaList = criteriabycodefahpDAO.getcriteriabycodefahp(codefahp);
        //obtener personas que respondieron a la encuesta
        List<SentemailbycodefahpContainer> personListanswered = sentemailbycodefahpDAO.searchbycodefahp(codefahp, "STATUSSENTFAHPCAT", "answered");
        List<CriteriaMatrixValueContainer> criteriadatabypersonList = new ArrayList();

        //Realiza los promedios de las personas
        personListanswered.forEach(personanswered -> {
            Long codeperson = personanswered.getSentemailbycodefahpPK().getCodePerson();
            List<CriteriaMatrixValueContainer> criteriadatabyperson = matrixValueDAO.getMatrixvaluelist(codefahp, codeperson);

            boolean isConsistency = fahpconsistencybycriteriaDAO.processConsistency(
                    criteriadatabyperson,
                    criteriaList,
                    codeperson,
                    codefahp);
            //Verifica la consistencia y se añade solo si es consistente
            //if     (isConsistency == true) {
            criteriadatabyperson.forEach(data -> {
                criteriadatabypersonList.add(data);
            });
            // }
        });
        criteriaList.forEach(criteria -> {
            criteriaList.forEach(criteriaaux -> {
                List<CriteriaMatrixValueContainer> filtered = criteriadatabypersonList.stream().filter(datafilter -> datafilter.getCriteriaMatrixValuePK().getCodeCriteria() == criteria.getCriteriabycodefahpPK().getCodeCriteria() && datafilter.getCriteriaMatrixValuePK().getCodeCriteriaCouple() == criteriaaux.getCriteriabycodefahpPK().getCodeCriteria()).collect(Collectors.toList());
                if (personListanswered.size() > 0 && filtered.size() > 0) {
                    //calcula promedios
                    CriteriaMatrixAverageValue averageValue = getAverageTriangleNumber(filtered, personListanswered.size());
                    //guarda en la tabla de promedios
                    criteriaMatrixAverageValueDAO.save(averageValue);
                }
            });
        });
        //Calcular los pesos de los criterios
        List<CriteriaprocessContainer> criteriaWeigth = calculate_criteriadatabyperson(criteriaList, codefahp);
        //Insertar los pesos calculados
        buildProcessFahpweightbycriteria(criteriaWeigth);
        //Calcular los fahp de atributos
        fahpatributebycriteriaDAO.calculate_attributeAverage(criteriaList, personListanswered, codefahp);

    }

    public List<CriteriaprocessContainer> calculate_criteriadatabyperson(List<CriteriabycodefahpContainer> criteriaList, Long codefahp) {
        List<CriteriaprocessContainer> container = new ArrayList();
        //obtenemos la data de los criterios por codefahp y persona
        List<CriteriaMatrixAverageValue> criteriaAverageValues = criteriaMatrixAverageValueDAO.getAverageData(codefahp);

        criteriaList.forEach(criteria -> {
            CriteriaprocessContainer criteriaprocessContainer = new CriteriaprocessContainer();

            List<CriteriaMatrixAverageValue> datacriteriafiltered = criteriaAverageValues.stream().
                    filter(datacriteria -> datacriteria.getCriteriaMatrixAverageValuePK().getCodeCriteria() == criteria.getCriteriabycodefahpPK().getCodeCriteria())
                    .collect(Collectors.toList());
            
            criteriaprocessContainer.setCodecriteria(criteria.getCriteriabycodefahpPK().getCodeCriteria());
            criteriaprocessContainer.setCodefahp(criteria.getCriteriabycodefahpPK().getCodefahp());

            List<Double> triangularNumber = calculate_diffuseTriangularNumber(datacriteriafiltered);
            criteriaprocessContainer.setTriangularNumber(triangularNumber);

            container.add(criteriaprocessContainer);
        });

        //obtener los totales de la matriz de numeros traingulares difusos
        List<Double> lowertotal = new ArrayList();
        List<Double> mediumtotal = new ArrayList();
        List<Double> uppertotal = new ArrayList();

        container.forEach(item -> {
            lowertotal.add(item.getTriangularNumber().get(0));
            mediumtotal.add(item.getTriangularNumber().get(1));
            uppertotal.add(item.getTriangularNumber().get(2));
        });
        double lowertotalsum = lowertotal.stream().reduce(0.0, (a, b) -> a + b);
        double mediumtotalsum = mediumtotal.stream().reduce(0.0, (a, b) -> a + b);
        double uppertotalsum = uppertotal.stream().reduce(0.0, (a, b) -> a + b);

        List<Double> triangularNumberTotal = new ArrayList();
        triangularNumberTotal.add(lowertotalsum);
        triangularNumberTotal.add(mediumtotalsum);
        triangularNumberTotal.add(uppertotalsum);

        //dividir para los totales
        container.forEach(item -> {
            List<Double> normalized1 = new ArrayList();
            double lowervalue = (item.getTriangularNumber().get(0) / (1 / triangularNumberTotal.get(2)));
            double mediumvalue = (item.getTriangularNumber().get(1) / (1 / triangularNumberTotal.get(1)));
            double uppervalue = (item.getTriangularNumber().get(2) / (1 / triangularNumberTotal.get(0)));
            normalized1.add(lowervalue);
            normalized1.add(mediumvalue);
            normalized1.add(uppervalue);
            item.setTriangularNumberNormalized(normalized1);
        });

        //defusificacion reducir l+m+u/3
        List<Double> defusificationtotalArray = new ArrayList();
        container.forEach(item -> {
            double defusification = ((item.getTriangularNumberNormalized().get(0) + item.getTriangularNumberNormalized().get(1) + item.getTriangularNumberNormalized().get(2)) / 3);
            item.setDefusification(defusification);
            defusificationtotalArray.add(defusification);
        });

        //sumar los pesos defusificados
        double totaldefusificationvalue = defusificationtotalArray.stream().reduce(0.0, (a, b) -> a + b);

        //Normalizar los Pesos
        container.forEach(item -> {
            double weigth = item.getDefusification() / totaldefusificationvalue;
            item.setWeigth(weigth);
        });
        return container;
    }

    public void buildProcessFahpweightbycriteria(List<CriteriaprocessContainer> criteriaWeigth) {

        criteriaWeigth.forEach(criteriacalculated -> {
            ProcessFahpweightbycriteriaPK fahpweightbycriteriaPK = new ProcessFahpweightbycriteriaPK();
            fahpweightbycriteriaPK.setCodeCriteria(criteriacalculated.getCodecriteria());
            //fahpweightbycriteriaPK.setCodePerson(criteriacalculated.getCodeperson());
            fahpweightbycriteriaPK.setCodefahp(criteriacalculated.getCodefahp());

            ProcessFahpweightbycriteria fahpweightbycriteria = new ProcessFahpweightbycriteria(fahpweightbycriteriaPK);
            fahpweightbycriteria.setWeight(new BigDecimal(criteriacalculated.getWeigth() * 100));
            save(fahpweightbycriteria);
        });
    }

    public List<Double> calculate_diffuseTriangularNumber(List<CriteriaMatrixAverageValue> datacriteriafiltered) {
        List<Double> lowerArray = new ArrayList();
        List<Double> mediaArray = new ArrayList();
        List<Double> upperArray = new ArrayList();
        List<Double> triangularNumber = new ArrayList();
        datacriteriafiltered.forEach(databycriteria -> {

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

        double exponent = (1.0 / datacriteriafiltered.size());
        double lowervaluepow = Math.pow(lowervalue, exponent);
        double mediavaluepow = Math.pow(mediavalue, exponent);
        double uppervaluepow = Math.pow(uppervalue, exponent);

        triangularNumber.add(lowervaluepow);
        triangularNumber.add(mediavaluepow);
        triangularNumber.add(uppervaluepow);
        return triangularNumber;
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

    public CriteriaMatrixAverageValue getAverageTriangleNumber(List<CriteriaMatrixValueContainer> criteriaMatrixValue, int numberofExpert) {

        List<Double> lowerArray = new ArrayList();
        List<Double> mediaArray = new ArrayList();
        List<Double> upperArray = new ArrayList();
        CriteriaMatrixAverageValuePK criteriaMatrixAverageValuePK = new CriteriaMatrixAverageValuePK();
        criteriaMatrixAverageValuePK.setCodefahp(criteriaMatrixValue.get(0).getCriteriaMatrixValuePK().getCodefahp());
        criteriaMatrixAverageValuePK.setCodeCriteria(criteriaMatrixValue.get(0).getCriteriaMatrixValuePK().getCodeCriteria());
        criteriaMatrixAverageValuePK.setCodeCriteriaCouple(criteriaMatrixValue.get(0).getCriteriaMatrixValuePK().getCodeCriteriaCouple());
        CriteriaMatrixAverageValue averageValue = new CriteriaMatrixAverageValue(criteriaMatrixAverageValuePK);
        criteriaMatrixValue.forEach(databycriteria -> {

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

        double exponent = (1.0 / numberofExpert);
        double lowervaluepow = Math.pow(lowervalue, exponent);
        double mediavaluepow = Math.pow(mediavalue, exponent);
        double uppervaluepow = Math.pow(uppervalue, exponent);

        String newvalueCat = lowervaluepow + "," + mediavaluepow + "," + uppervaluepow;
        averageValue.setValuecriteriaFAHP(newvalueCat);
        averageValue.setValuecriteriaFAHPCatt("VALUEFAHPCAT");
        return averageValue;
    }
}
