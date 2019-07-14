/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.QuestionItem;
import com.epn.entities.Questions;
import com.epn.entities.Quiz;
import java.util.List;

/**
 *
 * @author david
 */
public class QuizSave {

    private Quiz quiz;
    private List<Questions> questiondeleted;
    private List<QuestionItem> questionItemdeleted;
 

    public QuizSave() {
    }

    public QuizSave(Quiz quiz, List<Questions> questiondeleted, List<QuestionItem> questionItemdeleted) {
        this.quiz = quiz;
        this.questiondeleted = questiondeleted;
        this.questionItemdeleted = questionItemdeleted;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
    
    public List<Questions> getQuestiondeleted() {
        return questiondeleted;
    }

    public void setQuestiondeleted(List<Questions> questiondeleted) {
        this.questiondeleted = questiondeleted;
    }

    public List<QuestionItem> getQuestionItemdeleted() {
        return questionItemdeleted;
    }

    public void setQuestionItemdeleted(List<QuestionItem> questionItemdeleted) {
        this.questionItemdeleted = questionItemdeleted;
    }
}
