/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.Quiz;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */
public class QuizSave {
    Quiz quiz=new Quiz();
    List<QuestionContainer> questions=new ArrayList();
    
}
