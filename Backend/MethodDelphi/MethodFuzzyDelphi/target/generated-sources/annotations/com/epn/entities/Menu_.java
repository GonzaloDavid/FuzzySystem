package com.epn.entities;

import com.epn.entities.Menu;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-14T17:06:06")
@StaticMetamodel(Menu.class)
public class Menu_ { 

    public static volatile SingularAttribute<Menu, Long> userCreate;
    public static volatile SingularAttribute<Menu, Menu> parent;
    public static volatile ListAttribute<Menu, Menu> menuList;
    public static volatile SingularAttribute<Menu, Long> userLastModify;
    public static volatile SingularAttribute<Menu, String> description;
    public static volatile SingularAttribute<Menu, Date> dateLastModify;
    public static volatile SingularAttribute<Menu, String> nameMenu;
    public static volatile SingularAttribute<Menu, Long> seqMenu;
    public static volatile SingularAttribute<Menu, Date> dateCreate;
    public static volatile SingularAttribute<Menu, Boolean> group;

}