package com.epn.entities;

import com.epn.entities.AdminisEmail;
import com.epn.entities.Catalogue;
import com.epn.entities.CatalogueitemPK;
import com.epn.entities.DelphiCalculations;
import com.epn.entities.Person;
import com.epn.entities.Quiz;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-08T16:08:15")
@StaticMetamodel(Catalogueitem.class)
public class Catalogueitem_ { 

    public static volatile ListAttribute<Catalogueitem, Person> personList;
    public static volatile SingularAttribute<Catalogueitem, Date> dateCreate;
    public static volatile ListAttribute<Catalogueitem, DelphiCalculations> delphiCalculationsList;
    public static volatile SingularAttribute<Catalogueitem, String> nameItem;
    public static volatile SingularAttribute<Catalogueitem, Catalogue> catalogue;
    public static volatile ListAttribute<Catalogueitem, Person> personList2;
    public static volatile ListAttribute<Catalogueitem, Person> personList1;
    public static volatile ListAttribute<Catalogueitem, Person> personList4;
    public static volatile SingularAttribute<Catalogueitem, Long> userCreate;
    public static volatile ListAttribute<Catalogueitem, Person> personList3;
    public static volatile ListAttribute<Catalogueitem, Quiz> quizList;
    public static volatile SingularAttribute<Catalogueitem, Long> userLastModify;
    public static volatile SingularAttribute<Catalogueitem, Date> dateLastModify;
    public static volatile ListAttribute<Catalogueitem, AdminisEmail> adminisEmailList;
    public static volatile SingularAttribute<Catalogueitem, CatalogueitemPK> catalogueitemPK;

}