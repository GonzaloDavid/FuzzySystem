package com.epn.entities;

import com.epn.entities.DelphiCalculations;
import com.epn.entities.GraphicsData;
import com.epn.entities.QuestionItem;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-09T17:38:51")
@StaticMetamodel(Questions.class)
public class Questions_ { 

    public static volatile SingularAttribute<Questions, Long> codeQuiz;
    public static volatile SingularAttribute<Questions, String> question;
    public static volatile SingularAttribute<Questions, String> description;
    public static volatile ListAttribute<Questions, GraphicsData> graphicsDataList;
    public static volatile SingularAttribute<Questions, Date> dateCreate;
    public static volatile ListAttribute<Questions, DelphiCalculations> delphiCalculationsList;
    public static volatile ListAttribute<Questions, QuestionItem> questionItemList;
    public static volatile SingularAttribute<Questions, Long> userCreate;
    public static volatile SingularAttribute<Questions, Long> userLastModify;
    public static volatile SingularAttribute<Questions, Long> codeQuestions;
    public static volatile SingularAttribute<Questions, Date> dateLastModify;
    public static volatile SingularAttribute<Questions, String> statusCat;
    public static volatile SingularAttribute<Questions, String> status;

}