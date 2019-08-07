/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.QuizValuesContainer;
import com.epn.dtos.TriangularFuzzyNumber;
import com.epn.entities.DelphiCalculations;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ka
 */
@Stateless
public class DelphiCalculationDAO extends GenericDAO<DelphiCalculations> {

    @Inject() QuizValuesDAO quizValuesDAO;

    public DelphiCalculationDAO() {
        super(DelphiCalculations.class);
    }

    public List<TriangularFuzzyNumber> getTriangularFuzzyNumbers(Long codeQuiz, Long roundNumber) {
        List<TriangularFuzzyNumber> fuzzyNumbersarray = new ArrayList();
        List<QuizValuesContainer> quizvaluebyquiz = quizValuesDAO.getquizvalues(codeQuiz, null, null, null, roundNumber);
        quizvaluebyquiz.forEach(itemValues -> {
            List<QuizValuesContainer> quizValuesContainers = quizValuesDAO.getquizvalues(
                    itemValues.getQuizvaluesPK().getCodeQuiz(),
                    itemValues.getQuizvaluesPK().getCodeQuestions(),
                    itemValues.getQuizvaluesPK().getCodeQuizItem(),
                    null,
                    roundNumber);
            TriangularFuzzyNumber triangularFuzzyNumber = calculateTriangularFuzzyNumber(quizValuesContainers);
            fuzzyNumbersarray.add(triangularFuzzyNumber);
        });
        return fuzzyNumbersarray;
    }

    public TriangularFuzzyNumber calculateTriangularFuzzyNumber(List<QuizValuesContainer> quizValuesContainers) {
        ArrayList<Double> menores = new ArrayList();
        ArrayList<Double> medios = new ArrayList();
        ArrayList<Double> maximos = new ArrayList();

        TriangularFuzzyNumber triangularFuzzyNumber = new TriangularFuzzyNumber();

        
        quizValuesContainers.forEach(itemValues -> {
            menores.add(new Double(itemValues.getMinimumValue()));
            medios.add(new Double(itemValues.getAverageValue()));
            maximos.add(new Double(itemValues.getMaximunValue()));
        });
      TriangularFuzzyNumber triangularFuzzyNumberArray = new TriangularFuzzyNumber(
              new Long(1),
              getNumeroMenor(menores),
              getNumeroMedio(medios),
              getNumeroMaximo(maximos)
      );

        return triangularFuzzyNumberArray;

    }

    private Double getNumeroMenor(ArrayList<Double> numeros) {
        Double menor = Collections.min(numeros);
        return menor;
    }

    private Double getNumeroMedio(ArrayList<Double> numeros) {
        int total = numeros.size();
        Double producto = 1.0;

        for (Double med : numeros) {
            producto = producto * med;
        }
        return Math.pow(producto, (1.0 / total));
    }

    private double getNumeroMaximo(ArrayList<Double> numeros) {
        double mayor = Collections.max(numeros);
        return mayor;
    }
}
