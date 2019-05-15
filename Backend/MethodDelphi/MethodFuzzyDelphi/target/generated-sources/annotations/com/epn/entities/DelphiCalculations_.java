package com.epn.entities;

import com.epn.entities.Catalogueitem;
import com.epn.entities.QuestionItem;
import com.epn.entities.Questions;
import com.epn.entities.Quiz;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-14T17:06:06")
@StaticMetamodel(DelphiCalculations.class)
public class DelphiCalculations_ { 

    public static volatile SingularAttribute<DelphiCalculations, Quiz> codeQuiz;
    public static volatile SingularAttribute<DelphiCalculations, Long> userCreate;
    public static volatile SingularAttribute<DelphiCalculations, Double> convergenceIndex;
    public static volatile SingularAttribute<DelphiCalculations, Long> roundNumber;
    public static volatile SingularAttribute<DelphiCalculations, Catalogueitem> catalogueitem;
    public static volatile SingularAttribute<DelphiCalculations, Long> seqdelphicalculation;
    public static volatile SingularAttribute<DelphiCalculations, Long> userLastModify;
    public static volatile SingularAttribute<DelphiCalculations, Date> dateLastModify;
    public static volatile SingularAttribute<DelphiCalculations, Questions> codeQuestions;
    public static volatile SingularAttribute<DelphiCalculations, Date> dateCreate;
    public static volatile SingularAttribute<DelphiCalculations, QuestionItem> codeQuizItem;
    public static volatile SingularAttribute<DelphiCalculations, Double> discriminator;

}