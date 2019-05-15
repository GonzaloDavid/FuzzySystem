package com.epn.entities;

import com.epn.entities.DelphiCalculations;
import com.epn.entities.GraphicsData;
import com.epn.entities.Questions;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-14T17:06:06")
@StaticMetamodel(QuestionItem.class)
public class QuestionItem_ { 

    public static volatile SingularAttribute<QuestionItem, String> statusItemCat;
    public static volatile SingularAttribute<QuestionItem, String> jumpNext;
    public static volatile SingularAttribute<QuestionItem, String> statusItem;
    public static volatile ListAttribute<QuestionItem, GraphicsData> graphicsDataList;
    public static volatile SingularAttribute<QuestionItem, Date> dateCreate;
    public static volatile ListAttribute<QuestionItem, DelphiCalculations> delphiCalculationsList;
    public static volatile SingularAttribute<QuestionItem, String> minimumValue;
    public static volatile SingularAttribute<QuestionItem, String> maximunValue;
    public static volatile SingularAttribute<QuestionItem, Long> userCreate;
    public static volatile SingularAttribute<QuestionItem, Long> userLastModify;
    public static volatile SingularAttribute<QuestionItem, Date> dateLastModify;
    public static volatile SingularAttribute<QuestionItem, Questions> codeQuestions;
    public static volatile SingularAttribute<QuestionItem, Long> codeQuizItem;

}