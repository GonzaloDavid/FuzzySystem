package com.epn.entities;

import com.epn.entities.AdminisEmail;
import com.epn.entities.Catalogueitem;
import com.epn.entities.DelphiCalculations;
import com.epn.entities.GraphicsData;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-14T17:06:06")
@StaticMetamodel(Quiz.class)
public class Quiz_ { 

    public static volatile SingularAttribute<Quiz, Long> codeQuiz;
    public static volatile SingularAttribute<Quiz, Long> userCreate;
    public static volatile SingularAttribute<Quiz, String> nameQuiz;
    public static volatile SingularAttribute<Quiz, Catalogueitem> catalogueitem;
    public static volatile SingularAttribute<Quiz, Long> userLastModify;
    public static volatile SingularAttribute<Quiz, String> shortNameQuiz;
    public static volatile SingularAttribute<Quiz, String> description;
    public static volatile SingularAttribute<Quiz, Date> dateLastModify;
    public static volatile ListAttribute<Quiz, AdminisEmail> adminisEmailList;
    public static volatile ListAttribute<Quiz, GraphicsData> graphicsDataList;
    public static volatile SingularAttribute<Quiz, Date> dateCreate;
    public static volatile ListAttribute<Quiz, DelphiCalculations> delphiCalculationsList;

}