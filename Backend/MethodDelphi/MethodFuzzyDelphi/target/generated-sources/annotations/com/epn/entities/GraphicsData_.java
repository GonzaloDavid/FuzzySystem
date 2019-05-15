package com.epn.entities;

import com.epn.entities.GraphicsParam;
import com.epn.entities.QuestionItem;
import com.epn.entities.Questions;
import com.epn.entities.Quiz;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-14T17:06:06")
@StaticMetamodel(GraphicsData.class)
public class GraphicsData_ { 

    public static volatile SingularAttribute<GraphicsData, String> xAxisvalues;
    public static volatile SingularAttribute<GraphicsData, GraphicsParam> codeGraphicsParam;
    public static volatile SingularAttribute<GraphicsData, Quiz> codeQuiz;
    public static volatile SingularAttribute<GraphicsData, Long> userCreate;
    public static volatile SingularAttribute<GraphicsData, String> yAxisvalues;
    public static volatile SingularAttribute<GraphicsData, Long> userLastModify;
    public static volatile SingularAttribute<GraphicsData, Date> dateLastModify;
    public static volatile SingularAttribute<GraphicsData, Questions> codeQuestions;
    public static volatile SingularAttribute<GraphicsData, Long> seqgraphicsdata;
    public static volatile SingularAttribute<GraphicsData, Date> dateCreate;
    public static volatile SingularAttribute<GraphicsData, QuestionItem> codeQuizItem;

}