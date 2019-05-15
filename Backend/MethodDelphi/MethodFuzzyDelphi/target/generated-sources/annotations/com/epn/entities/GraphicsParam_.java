package com.epn.entities;

import com.epn.entities.GraphicsData;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-14T17:06:06")
@StaticMetamodel(GraphicsParam.class)
public class GraphicsParam_ { 

    public static volatile SingularAttribute<GraphicsParam, String> codeGraphicsParam;
    public static volatile SingularAttribute<GraphicsParam, Long> codeQuiz;
    public static volatile SingularAttribute<GraphicsParam, Long> userCreate;
    public static volatile SingularAttribute<GraphicsParam, String> yAxis;
    public static volatile SingularAttribute<GraphicsParam, String> xAxis;
    public static volatile SingularAttribute<GraphicsParam, Long> userLastModify;
    public static volatile SingularAttribute<GraphicsParam, Date> dateLastModify;
    public static volatile ListAttribute<GraphicsParam, GraphicsData> graphicsDataList;
    public static volatile SingularAttribute<GraphicsParam, Date> dateCreate;

}