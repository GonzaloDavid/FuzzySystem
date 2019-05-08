package com.epn.entities;

import com.epn.entities.Catalogueitem;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-08T16:08:15")
@StaticMetamodel(Catalogue.class)
public class Catalogue_ { 

    public static volatile SingularAttribute<Catalogue, String> descripcion;
    public static volatile SingularAttribute<Catalogue, Long> userCreate;
    public static volatile SingularAttribute<Catalogue, String> code;
    public static volatile ListAttribute<Catalogue, Catalogueitem> catalogueitemList;
    public static volatile SingularAttribute<Catalogue, Long> userLastModify;
    public static volatile SingularAttribute<Catalogue, String> name;
    public static volatile SingularAttribute<Catalogue, Date> dateLastModify;
    public static volatile SingularAttribute<Catalogue, Date> dateCreate;

}