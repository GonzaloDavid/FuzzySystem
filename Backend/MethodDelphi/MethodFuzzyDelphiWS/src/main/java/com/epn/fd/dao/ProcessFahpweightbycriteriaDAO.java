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

    public void save(ProcessFahpweightbycriteria fahpweightbycriteria) {
        update(fahpweightbycriteria);
    }

    public void buildProcessFahpweightbycriteria(List<CriteriaprocessContainer> criteriaWeigth) {

        criteriaWeigth.forEach(criteriacalculated -> {
            ProcessFahpweightbycriteriaPK fahpweightbycriteriaPK = new ProcessFahpweightbycriteriaPK();
            fahpweightbycriteriaPK.setCodeCriteria(criteriacalculated.getCodecriteria());
            fahpweightbycriteriaPK.setCodePerson(criteriacalculated.getCodeperson());
            fahpweightbycriteriaPK.setCodefahp(criteriacalculated.getCodefahp());

            ProcessFahpweightbycriteria fahpweightbycriteria = new ProcessFahpweightbycriteria(fahpweightbycriteriaPK);
            BigDecimal weigth = new BigDecimal(criteriacalculated.getWeigth());
            fahpweightbycriteria.setWeight(weigth);
            save(fahpweightbycriteria);
        });
    }

    public void executeFAHP(Long codefahp) {
        List<SentemailbycodefahpContainer> personListanswered = sentemailbycodefahpDAO.searchbycodefahp(codefahp, "STATUSSENTFAHPCAT", "answered");
        personListanswered.forEach(personanswered -> {
            long codeperson = personanswered.getSentemailbycodefahpPK().getCodePerson();
            List<CriteriaprocessContainer> criteriaWeigth = calculate_criteriadatabyperson(codefahp, codeperson);
            //Insertar los pesos calculados
            buildProcessFahpweightbycriteria(criteriaWeigth);
        });
    }

    public List<CriteriaprocessContainer> calculate_criteriadatabyperson(Long codefahp, long codeperson) {
        List<CriteriaprocessContainer> container = new ArrayList();
        List<CriteriaMatrixValueContainer> criteriadatalist = matrixValueDAO.getMatrixvaluelist(codefahp, codeperson);
        List<CriteriabycodefahpContainer> criteriaList = criteriabycodefahpDAO.getcriteriabycodefahp(codefahp);
        criteriaList.forEach(criteria -> {
            CriteriaprocessContainer criteriaprocessContainer = new CriteriaprocessContainer();

            List<CriteriaMatrixValueContainer> datacriteriafiltered = criteriadatalist.stream().filter(datacriteria -> datacriteria.getCriteriaMatrixValuePK().getCodeCriteria() == criteria.getCriteriabycodefahpPK().getCodeCriteria()).collect(Collectors.toList());
            criteriaprocessContainer.setCodecriteria(criteria.getCriteriabycodefahpPK().getCodeCriteria());
            criteriaprocessContainer.setCodeperson(codeperson);
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
}
