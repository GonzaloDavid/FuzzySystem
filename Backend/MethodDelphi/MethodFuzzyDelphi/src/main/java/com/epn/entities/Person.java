/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author desarrollador
 */
@Entity
@Table(name = "Person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
    , @NamedQuery(name = "Person.findByCodePerson", query = "SELECT p FROM Person p WHERE p.codePerson = :codePerson")
    , @NamedQuery(name = "Person.findByIdentify", query = "SELECT p FROM Person p WHERE p.identify = :identify")
    , @NamedQuery(name = "Person.findByFirstName", query = "SELECT p FROM Person p WHERE p.firstName = :firstName")
    , @NamedQuery(name = "Person.findByMiddleName", query = "SELECT p FROM Person p WHERE p.middleName = :middleName")
    , @NamedQuery(name = "Person.findByLastName", query = "SELECT p FROM Person p WHERE p.lastName = :lastName")
    , @NamedQuery(name = "Person.findByLastNameMatern", query = "SELECT p FROM Person p WHERE p.lastNameMatern = :lastNameMatern")
    , @NamedQuery(name = "Person.findByName", query = "SELECT p FROM Person p WHERE p.name = :name")
    , @NamedQuery(name = "Person.findByEmail", query = "SELECT p FROM Person p WHERE p.email = :email")
    , @NamedQuery(name = "Person.findByBirthday", query = "SELECT p FROM Person p WHERE p.birthday = :birthday")
    , @NamedQuery(name = "Person.findBySex", query = "SELECT p FROM Person p WHERE p.sex = :sex")
    , @NamedQuery(name = "Person.findByDateCreate", query = "SELECT p FROM Person p WHERE p.dateCreate = :dateCreate")
    , @NamedQuery(name = "Person.findByDateLastModify", query = "SELECT p FROM Person p WHERE p.dateLastModify = :dateLastModify")
    , @NamedQuery(name = "Person.findByUserCreate", query = "SELECT p FROM Person p WHERE p.userCreate = :userCreate")
    , @NamedQuery(name = "Person.findByUserLastModify", query = "SELECT p FROM Person p WHERE p.userLastModify = :userLastModify")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codePerson")
    private Long codePerson;
    @Basic(optional = false)
    @Column(name = "identify")
    private String identify;
    @Basic(optional = false)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "middleName")
    private String middleName;
    @Basic(optional = false)
    @Column(name = "lastName")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "lastNameMatern")
    private String lastNameMatern;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Basic(optional = false)
    @Column(name = "sex")
    private String sex;
    @Column(name = "typePersonCat")
    private String typePersonCat;
    @Column(name = "typePerson")
    private String typePerson;
    @Column(name = "typeIdentifyCat")
    private String typeIdentifyCat;
    @Column(name = "typeIdentify")
    private String typeIdentify;
    @Column(name = "academicDegreeCat")
    private String academicDegreeCat;
    @Column(name = "academicDegree")
    private String academicDegree;
    @Column(name = "countryCat")
    private String countryCat;
    @Column(name = "country")
    private String country;
    @Column(name = "statusCat")
    private String statusCat;
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "dateCreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    @Basic(optional = false)
    @Column(name = "dateLastModify")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLastModify;
    @Basic(optional = false)
    @Column(name = "userCreate")
    private long userCreate;
    @Basic(optional = false)
    @Column(name = "userLastModify")
    private long userLastModify;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<AdminisEmail> adminisEmailList;
    @JoinColumns({
        @JoinColumn(name = "typePersonCat", referencedColumnName = "codeCatalogue", insertable = false, updatable = false)
        , @JoinColumn(name = "typePerson", referencedColumnName = "codeItem", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Catalogueitem catalogueitem;
    @JoinColumns({
        @JoinColumn(name = "typeIdentifyCat", referencedColumnName = "codeCatalogue", insertable = false, updatable = false)
        , @JoinColumn(name = "typeIdentify", referencedColumnName = "codeItem", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Catalogueitem catalogueitem1;
    @JoinColumns({
        @JoinColumn(name = "academicDegreeCat", referencedColumnName = "codeCatalogue", insertable = false, updatable = false)
        , @JoinColumn(name = "academicDegree", referencedColumnName = "codeItem", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Catalogueitem catalogueitem2;
    @JoinColumns({
        @JoinColumn(name = "countryCat", referencedColumnName = "codeCatalogue", insertable = false, updatable = false)
        , @JoinColumn(name = "country", referencedColumnName = "codeItem", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Catalogueitem catalogueitem3;
    @JoinColumns({
        @JoinColumn(name = "statusCat", referencedColumnName = "codeCatalogue", insertable = false, updatable = false)
        , @JoinColumn(name = "status", referencedColumnName = "codeItem", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Catalogueitem catalogueitem4;

    public Person() {
    }

    public Person(Long codePerson) {
        this.codePerson = codePerson;
    }

    public Person(Long codePerson, String identify, String firstName, String middleName, String lastName, String lastNameMatern, String name, String email, String sex, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.codePerson = codePerson;
        this.identify = identify;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.lastNameMatern = lastNameMatern;
        this.name = name;
        this.email = email;
        this.sex = sex;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public Long getCodePerson() {
        return codePerson;
    }

    public String getTypePersonCat() {
        return typePersonCat;
    }

    public void setTypePersonCat(String typePersonCat) {
        this.typePersonCat = typePersonCat;
    }

    public String getTypeIdentifyCat() {
        return typeIdentifyCat;
    }

    public void setTypeIdentifyCat(String typeIdentifyCat) {
        this.typeIdentifyCat = typeIdentifyCat;
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    public String getCountryCat() {
        return countryCat;
    }

    public void setCountryCat(String countryCat) {
        this.countryCat = countryCat;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatusCat() {
        return statusCat;
    }

    public void setStatusCat(String statusCat) {
        this.statusCat = statusCat;
    }

    public String getTypeIdentify() {
        return typeIdentify;
    }

    public void setTypeIdentify(String typeIdentify) {
        this.typeIdentify = typeIdentify;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCodePerson(Long codePerson) {
        this.codePerson = codePerson;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastNameMatern() {
        return lastNameMatern;
    }

    public void setLastNameMatern(String lastNameMatern) {
        this.lastNameMatern = lastNameMatern;
    }

    public String getName() {
        return name;
    }

    public String getTypePerson() {
        return typePerson;
    }

    public void setTypePerson(String typePerson) {
        this.typePerson = typePerson;
    }

    public String getAcademicDegreeCat() {
        return academicDegreeCat;
    }

    public void setAcademicDegreeCat(String academicDegreeCat) {
        this.academicDegreeCat = academicDegreeCat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateLastModify() {
        return dateLastModify;
    }

    public void setDateLastModify(Date dateLastModify) {
        this.dateLastModify = dateLastModify;
    }

    public long getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(long userCreate) {
        this.userCreate = userCreate;
    }

    public long getUserLastModify() {
        return userLastModify;
    }

    public void setUserLastModify(long userLastModify) {
        this.userLastModify = userLastModify;
    }

    @XmlTransient
    public List<AdminisEmail> getAdminisEmailList() {
        return adminisEmailList;
    }

    public void setAdminisEmailList(List<AdminisEmail> adminisEmailList) {
        this.adminisEmailList = adminisEmailList;
    }

    public Catalogueitem getCatalogueitem() {
        return catalogueitem;
    }

    public void setCatalogueitem(Catalogueitem catalogueitem) {
        this.catalogueitem = catalogueitem;
    }

    public Catalogueitem getCatalogueitem1() {
        return catalogueitem1;
    }

    public void setCatalogueitem1(Catalogueitem catalogueitem1) {
        this.catalogueitem1 = catalogueitem1;
    }

    public Catalogueitem getCatalogueitem2() {
        return catalogueitem2;
    }

    public void setCatalogueitem2(Catalogueitem catalogueitem2) {
        this.catalogueitem2 = catalogueitem2;
    }

    public Catalogueitem getCatalogueitem3() {
        return catalogueitem3;
    }

    public void setCatalogueitem3(Catalogueitem catalogueitem3) {
        this.catalogueitem3 = catalogueitem3;
    }

    public Catalogueitem getCatalogueitem4() {
        return catalogueitem4;
    }

    public void setCatalogueitem4(Catalogueitem catalogueitem4) {
        this.catalogueitem4 = catalogueitem4;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codePerson != null ? codePerson.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.codePerson == null && other.codePerson != null) || (this.codePerson != null && !this.codePerson.equals(other.codePerson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.Person[ codePerson=" + codePerson + " ]";
    }

}
