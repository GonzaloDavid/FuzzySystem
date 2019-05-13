package com.epn.entities;

import com.epn.entities.AdminisEmailPK;
import com.epn.entities.Catalogueitem;
import com.epn.entities.Person;
import com.epn.entities.Quiz;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-09T17:38:51")
@StaticMetamodel(AdminisEmail.class)
public class AdminisEmail_ { 

    public static volatile SingularAttribute<AdminisEmail, Quiz> quiz;
    public static volatile SingularAttribute<AdminisEmail, Long> userCreate;
    public static volatile SingularAttribute<AdminisEmail, Person> person;
    public static volatile SingularAttribute<AdminisEmail, Catalogueitem> catalogueitem;
    public static volatile SingularAttribute<AdminisEmail, Long> userLastModify;
    public static volatile SingularAttribute<AdminisEmail, AdminisEmailPK> adminisEmailPK;
    public static volatile SingularAttribute<AdminisEmail, Date> dateLastModify;
    public static volatile SingularAttribute<AdminisEmail, Date> dateCreate;

}