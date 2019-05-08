package com.epn.entities;

import com.epn.entities.AdminisEmail;
import com.epn.entities.Catalogueitem;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-08T16:08:15")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, Date> birthday;
    public static volatile SingularAttribute<Person, String> lastName;
    public static volatile SingularAttribute<Person, Long> codePerson;
    public static volatile SingularAttribute<Person, String> identify;
    public static volatile SingularAttribute<Person, Catalogueitem> catalogueitem;
    public static volatile SingularAttribute<Person, String> sex;
    public static volatile SingularAttribute<Person, Date> dateCreate;
    public static volatile SingularAttribute<Person, String> firstName;
    public static volatile SingularAttribute<Person, Long> userCreate;
    public static volatile SingularAttribute<Person, Catalogueitem> catalogueitem2;
    public static volatile SingularAttribute<Person, Catalogueitem> catalogueitem3;
    public static volatile SingularAttribute<Person, Long> userLastModify;
    public static volatile SingularAttribute<Person, Catalogueitem> catalogueitem1;
    public static volatile SingularAttribute<Person, String> name;
    public static volatile SingularAttribute<Person, String> lastNameMatern;
    public static volatile SingularAttribute<Person, Date> dateLastModify;
    public static volatile ListAttribute<Person, AdminisEmail> adminisEmailList;
    public static volatile SingularAttribute<Person, String> middleName;
    public static volatile SingularAttribute<Person, Catalogueitem> catalogueitem4;
    public static volatile SingularAttribute<Person, String> email;

}