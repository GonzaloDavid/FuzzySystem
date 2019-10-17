/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.CriteriaMatrixValueContainer;
import com.epn.dtos.CriteriabycodefahpContainer;
import com.epn.dtos.ProcessConsistencyContainer1;
import com.epn.dtos.ProcessConsitencyContainer;
import com.epn.dtos.ProcessFahpconsistencybycriteriaContainer;
import com.epn.entities.FilterTypes;
import com.epn.entities.ProcessFahpconsistencybycriteria;
import com.epn.entities.ProcessFahpconsistencybycriteriaPK;
import com.epn.entities.SearchObject;
import com.epn.mapper.ProcessFahpconsistencybycriteriaMapper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
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
public class ProcessFahpconsistencybycriteriaDAO extends GenericDAO<ProcessFahpconsistencybycriteria> {

    @Inject()
    ProcessFahpweightbycriteriaDAO processFahpweightbycriteriaDAO;
    private final ProcessFahpconsistencybycriteriaMapper mapper = Mappers.getMapper(ProcessFahpconsistencybycriteriaMapper.class);

    private HashMap<Long, Double> randomConsistencyList = new HashMap<Long, Double>();

    public ProcessFahpconsistencybycriteriaDAO() {
        super(ProcessFahpconsistencybycriteria.class);
    }

    public List<ProcessFahpconsistencybycriteriaContainer> getconsistencybycodefahp(Long codefahp) {
        SearchObject search = new SearchObject("processFahpconsistencybycriteriaPK");
        search.addParameter("processFahpconsistencybycriteriaPK.codefahp", FilterTypes.EQUAL, codefahp);
        search.setOrderPropertyName("processFahpconsistencybycriteriaPK.codefahp");
        search.asc();

        List<ProcessFahpconsistencybycriteria> resultList = search(search);
        List<ProcessFahpconsistencybycriteriaContainer> container = mapper.sourceListToDestination(resultList);
        return container;
    }

    public boolean processConsistency(
            List<CriteriaMatrixValueContainer> criteriadatabyperson,
            List<CriteriabycodefahpContainer> criteriaList,
            Long codeperson,
            Long codefahp) {
        boolean isconsistent;
        List<ProcessConsitencyContainer> consitencyContainer = new ArrayList();
        //Crear un contenerdor con atributos de normalizacion
        criteriadatabyperson.forEach(datacriteria -> {
            ProcessConsitencyContainer consitencyObj = new ProcessConsitencyContainer();
            consitencyObj.setCriteriaMatrixValuePK(datacriteria.getCriteriaMatrixValuePK());
            consitencyObj.setValuecriteriaFAHP(datacriteria.getValuecriteriaFAHP());
            consitencyContainer.add(consitencyObj);
        });
        //Normalizar la matriz
        criteriaList.forEach(criteria -> {
            List<CriteriaMatrixValueContainer> datacriteriafiltered = criteriadatabyperson.stream().filter(datacriteria -> datacriteria.getCriteriaMatrixValuePK().getCodeCriteriaCouple() == criteria.getCriteriabycodefahpPK().getCodeCriteria()).collect(Collectors.toList());
            List<Double> totales = calculate_diffuseTriangularNumber(datacriteriafiltered);
            consitencyContainer.forEach(datacriteria -> {
                if (datacriteria.getCriteriaMatrixValuePK().getCodeCriteriaCouple() == criteria.getCriteriabycodefahpPK().getCodeCriteria()) {
                    // consitencyObj.setCriteriaMatrixValuePK(datacriteria.getCriteriaMatrixValuePK());

                    String valueCat = datacriteria.getValuecriteriaFAHP();
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
                    List<Double> normalized = new ArrayList();
                    double lowervalue = (processFahpweightbycriteriaDAO.stringtoDouble(part1) / totales.get(0));
                    double media = (processFahpweightbycriteriaDAO.stringtoDouble(part2) / totales.get(1));
                    double upper = (processFahpweightbycriteriaDAO.stringtoDouble(part3) / totales.get(2));

                    normalized.add(lowervalue);
                    normalized.add(media);
                    normalized.add(upper);

                    datacriteria.setValuenormalized(normalized);
                }
            });
        });
        // Calcular totales por fila
        List<ProcessConsistencyContainer1> consistencyContainer1 = new ArrayList();
        criteriaList.forEach(criteria -> {
            ProcessConsistencyContainer1 container1 = new ProcessConsistencyContainer1();
            List<ProcessConsitencyContainer> datacriteriafiltered = consitencyContainer.stream().filter(datacriteria -> datacriteria.getCriteriaMatrixValuePK().getCodeCriteria() == criteria.getCriteriabycodefahpPK().getCodeCriteria()).collect(Collectors.toList());
            List<Double> totales = calculate_averagebyrow(datacriteriafiltered);
            container1.setTotales(totales);
            consistencyContainer1.add(container1);
        });
        //Calcular total de suma por filas
        List<Double> lowersum = new ArrayList();
        List<Double> mediumsum = new ArrayList();
        List<Double> uppersum = new ArrayList();
        List<Double> totalSumbyRow = new ArrayList();
        consistencyContainer1.forEach(averagebyrow -> {
            lowersum.add(averagebyrow.getTotales().get(0));
            mediumsum.add(averagebyrow.getTotales().get(1));
            uppersum.add(averagebyrow.getTotales().get(2));
        });

        double lower = (lowersum.stream().reduce(0.0, (a, b) -> a + b));
        double medium = (mediumsum.stream().reduce(0.0, (a, b) -> a + b));
        double upper = (uppersum.stream().reduce(0.0, (a, b) -> a + b));

        totalSumbyRow.add(lower);
        totalSumbyRow.add(medium);
        totalSumbyRow.add(upper);

        //Calcular promedios 
        List<ProcessConsistencyContainer1> averageVector = new ArrayList();
        consistencyContainer1.forEach(averagebyrow -> {
            List<Double> average = new ArrayList();
            ProcessConsistencyContainer1 container1 = new ProcessConsistencyContainer1();
            double lowervalue = (averagebyrow.getTotales().get(0) / totalSumbyRow.get(0));
            double mediumvalue = (averagebyrow.getTotales().get(1) / totalSumbyRow.get(1));
            double uppervalue = (averagebyrow.getTotales().get(2) / totalSumbyRow.get(2));
            average.add(lowervalue);
            average.add(mediumvalue);
            average.add(uppervalue);
            container1.setTotales(average);
            averageVector.add(container1);
        });

        //Vector fila total
        List<ProcessConsistencyContainer1> vectorFilatotal = new ArrayList();
        criteriaList.forEach(criteria -> {
            List<CriteriaMatrixValueContainer> datacriteriafiltered = criteriadatabyperson.stream().filter(datacriteria -> datacriteria.getCriteriaMatrixValuePK().getCodeCriteria() == criteria.getCriteriabycodefahpPK().getCodeCriteria()).collect(Collectors.toList());
            ProcessConsistencyContainer1 container1 = new ProcessConsistencyContainer1();
            List<Double> resultmultiply = MultiplyMatrix(datacriteriafiltered, averageVector);
            container1.setTotales(resultmultiply);
            vectorFilatotal.add(container1);
        });
        //Calculamos el cociente
        List<ProcessConsistencyContainer1> cociente = calculate_cociente(
                vectorFilatotal,
                averageVector);

        //Calculamos lambdaMaximo
        double LambdaMax = calculate_LambdaMax(cociente);

        //Calculamos el CI
        double CI = (LambdaMax - criteriaList.size()) / (criteriaList.size() - 1);
        //Calculamos CR
        setRandomConsistency();
        double ramdomConsistency = randomConsistencyList.get(new Long(criteriaList.size()));
        double CR = (CI / ramdomConsistency);
        CR = CR * 100;
        //Guardar la consistencia por persona
        ProcessFahpconsistencybycriteriaPK processFahpconsistencybycriteriaPK = new ProcessFahpconsistencybycriteriaPK();
        processFahpconsistencybycriteriaPK.setCodePerson(codeperson);
        processFahpconsistencybycriteriaPK.setCodefahp(codefahp);
        ProcessFahpconsistencybycriteria fahpconsistencybycriteria = new ProcessFahpconsistencybycriteria(processFahpconsistencybycriteriaPK);
        fahpconsistencybycriteria.setConsistency(new BigDecimal(LambdaMax));
        fahpconsistencybycriteria.setIndexConsistency(new BigDecimal(CI));
        fahpconsistencybycriteria.setRatioConsistency(new BigDecimal(CR));

        save(fahpconsistencybycriteria);

        //verificar cr
        if (CR > 0.1) {
            isconsistent = false;
        } else {
            isconsistent = true;
        }

        return isconsistent;
    }

    public void setRandomConsistency() {

        randomConsistencyList.put(new Long(1), 0.0);
        randomConsistencyList.put(new Long(2), 0.0);
        randomConsistencyList.put(new Long(3), 0.52);
        randomConsistencyList.put(new Long(4), 0.89);
        randomConsistencyList.put(new Long(5), 1.11);
        randomConsistencyList.put(new Long(6), 1.25);
        randomConsistencyList.put(new Long(7), 1.35);
        randomConsistencyList.put(new Long(8), 1.40);
        randomConsistencyList.put(new Long(9), 1.45);
        randomConsistencyList.put(new Long(10), 1.49);
        randomConsistencyList.put(new Long(11), 1.52);
        randomConsistencyList.put(new Long(12), 1.54);
        randomConsistencyList.put(new Long(13), 1.56);
        randomConsistencyList.put(new Long(14), 1.58);
        randomConsistencyList.put(new Long(15), 1.59);
    }

    public double calculate_LambdaMax(List<ProcessConsistencyContainer1> cociente) {
        List<Double> lowerArray = new ArrayList();
        List<Double> mediaArray = new ArrayList();
        List<Double> upperArray = new ArrayList();

        cociente.forEach(cocienteByRow -> {
            lowerArray.add(cocienteByRow.getTotales().get(0));
            mediaArray.add(cocienteByRow.getTotales().get(1));
            upperArray.add(cocienteByRow.getTotales().get(2));
        });
        double LambdaLower = lowerArray.stream().reduce(0.0, (a, b) -> a + b);
        double LambdaMedium = mediaArray.stream().reduce(0.0, (a, b) -> a + b);
        double LambdaUpper = upperArray.stream().reduce(0.0, (a, b) -> a + b);

        LambdaLower = (LambdaLower / lowerArray.size());
        LambdaMedium = (LambdaMedium / mediaArray.size());
        LambdaUpper = (LambdaUpper / upperArray.size());

        double LamdaMax = ((LambdaLower + LambdaMedium + LambdaUpper) / 3);

        return LamdaMax;

    }

    public List<ProcessConsistencyContainer1> calculate_cociente(List<ProcessConsistencyContainer1> vectorFilatotal,
            List<ProcessConsistencyContainer1> averageVector) {
        int indexi = 0;
        int indexj = 0;
        List<ProcessConsistencyContainer1> cociente = new ArrayList();
        for (ProcessConsistencyContainer1 filatotal : vectorFilatotal) {
            indexi++;
            ProcessConsistencyContainer1 container1 = new ProcessConsistencyContainer1();
            List<Double> cocienteRow = new ArrayList();
            indexj = 0;
            for (ProcessConsistencyContainer1 averageRow : averageVector) {
                indexj++;
                if (indexi == indexj) {

                    double lower = filatotal.getTotales().get(0) / averageRow.getTotales().get(0);
                    double medium = filatotal.getTotales().get(1) / averageRow.getTotales().get(1);
                    double upper = filatotal.getTotales().get(2) / averageRow.getTotales().get(2);

                    cocienteRow.add(lower);
                    cocienteRow.add(medium);
                    cocienteRow.add(upper);
                }
            }
            container1.setTotales(cocienteRow);
            cociente.add(container1);
        }
        return cociente;
    }

    public List<Double> MultiplyMatrix(
            List<CriteriaMatrixValueContainer> criteriaValue,
            List<ProcessConsistencyContainer1> consistencyContainer) {

//        List<Double> vectorFilatotalbyrow = new ArrayList();
        double addmultiplylower = 0.0;
        double addmultiplyMedium = 0.0;
        double addmultiplyUpper = 0.0;
        List<Double> fuzzyNumber = new ArrayList();
        int indexi = 0;
        int indexj = 0;
        for (CriteriaMatrixValueContainer matrixValueOriginal : criteriaValue) {
            indexi++;
            List<Double> tfn = convertStringtoTFN(matrixValueOriginal.getValuecriteriaFAHP());
            indexj = 0;
            for (ProcessConsistencyContainer1 average : consistencyContainer) {
                indexj++;
                if (indexi == indexj) {
                    addmultiplylower += (average.getTotales().get(0) * tfn.get(0));
                    addmultiplyMedium += (average.getTotales().get(1) * tfn.get(1));
                    addmultiplyUpper += (average.getTotales().get(2) * tfn.get(2));
                }
            }
        }
        fuzzyNumber.add(addmultiplylower);
        fuzzyNumber.add(addmultiplyMedium);
        fuzzyNumber.add(addmultiplyUpper);

        return fuzzyNumber;
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

        tfn.add(processFahpweightbycriteriaDAO.stringtoDouble(part1));
        tfn.add(processFahpweightbycriteriaDAO.stringtoDouble(part2));
        tfn.add(processFahpweightbycriteriaDAO.stringtoDouble(part3));
        return tfn;
    }

    public List<Double> calculate_averagebyrow(List<ProcessConsitencyContainer> datacriteriafiltered) {
        List<Double> lowersum = new ArrayList();
        List<Double> mediumsum = new ArrayList();
        List<Double> uppersum = new ArrayList();
        List<Double> total = new ArrayList();
        datacriteriafiltered.forEach(datafiltered -> {
            lowersum.add(datafiltered.getValuenormalized().get(0));
            mediumsum.add(datafiltered.getValuenormalized().get(1));
            uppersum.add(datafiltered.getValuenormalized().get(2));
        });

        double lower = lowersum.stream().reduce(0.0, (a, b) -> a + b);
        double medium = mediumsum.stream().reduce(0.0, (a, b) -> a + b);
        double upper = uppersum.stream().reduce(0.0, (a, b) -> a + b);

        total.add(lower);
        total.add(medium);
        total.add(upper);
        return total;
    }

    public List<Double> calculate_diffuseTriangularNumber(List<CriteriaMatrixValueContainer> datacriteriafiltered) {
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

            lowerArray.add(processFahpweightbycriteriaDAO.stringtoDouble(part1));
            mediaArray.add(processFahpweightbycriteriaDAO.stringtoDouble(part2));
            upperArray.add(processFahpweightbycriteriaDAO.stringtoDouble(part3));
        });
        double lowervalue = lowerArray.stream().reduce(0.0, (a, b) -> a + b);
        double mediavalue = mediaArray.stream().reduce(0.0, (a, b) -> a + b);
        double uppervalue = upperArray.stream().reduce(0.0, (a, b) -> a + b);

        triangularNumber.add(lowervalue);
        triangularNumber.add(mediavalue);
        triangularNumber.add(uppervalue);
        return triangularNumber;
    }

    public void save(ProcessFahpconsistencybycriteria fahpconsistencybycriteria) {
        update(fahpconsistencybycriteria);
    }
}
