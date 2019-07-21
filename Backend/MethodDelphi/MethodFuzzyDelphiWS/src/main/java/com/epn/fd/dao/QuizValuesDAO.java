/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.entities.Quizvalues;
import com.epn.exception.AppException;
import javax.ejb.Stateless;

/**
 *
 * @author david
 */
@Stateless
public class QuizValuesDAO extends GenericDAO<Quizvalues> {

    public QuizValuesDAO() {
        super(Quizvalues.class);
    }

    public void savequizvalues(Quizvalues quiz) {
        try {
            em.merge(quiz);
        } catch (Exception e) {
            throw new AppException(e.toString(), "ENCUESTA YA INGRESADA");
        }
    }

}
