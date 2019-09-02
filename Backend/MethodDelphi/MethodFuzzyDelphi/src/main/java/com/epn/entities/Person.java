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
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByCodePerson", query = "SELECT p FROM Person p WHERE p.codePerson = :codePerson"),
    @NamedQuery(name = "Person.findByIdentify", query = "SELECT p FROM Person p WHERE p.identify = :identify"),
    @NamedQuery(name = "Person.findByName", query = "SELECT p FROM Person p WHERE p.name = :name"),
    @NamedQuery(name = "Person.findByEmail", query = "SELECT p FROM Person p WHERE p.email = :email"),
    @NamedQuery(name = "Person.findByBirthday", query = "SELECT p FROM Person p WHERE p.birthday = :birthday"),
    @NamedQuery(name = "Person.findBySex", query = "SELECT p FROM Person p WHERE p.sex = :sex"),
    @NamedQuery(name = "Person.findByDateCreate", query = "SELECT p FROM Person p WHERE p.dateCreate = :dateCreate"),
    @NamedQuery(name = "Person.findByDateLastModify", query = "SELECT p FROM Person p WHERE p.dateLastModify = :dateLastModify"),
    @NamedQuery(name = "Person.findByUserCreate", query = "SELECT p FROM Person p WHERE p.userCreate = :userCreate"),
    @NamedQuery(name = "Person.findByUserLastModify", query = "SELECT p FROM Person p WHERE p.userLastModify = :userLastModify")})
public class Person implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Rounds> roundsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Quizvalues> quizvaluesList;

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
    @Column(name = "names")
    private String names;
    @Basic(optional = false)
    @Column(name = "lastNames")
    private String lastNames;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "workArea")
    private String workArea;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Column(name = "sexCat")
    private String sexCat;
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
    @Basic(optional = false)
    @Column(name = "bibliography")
    private String bibliography;
    
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    // private List<AdminisEmail> adminisEmailList;
    @JoinColumns({
        @JoinColumn(name = "typePersonCat", referencedColumnName = "codeCatalogue", insertable = false, updatable = false),
        @JoinColumn(name = "typePerson", referencedColumnName = "codeItem", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Catalogueitem catalogueitem;
    @JoinColumns({
        @JoinColumn(name = "typeIdentifyCat", referencedColumnName = "codeCatalogue", insertable = false, updatable = false),
        @JoinColumn(name = "typeIdentify", referencedColumnName = "codeItem", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Catalogueitem catalogueitem1;
    @JoinColumns({
        @JoinColumn(name = "academicDegreeCat", referencedColumnName = "codeCatalogue", insertable = false, updatable = false),
        @JoinColumn(name = "academicDegree", referencedColumnName = "codeItem", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Catalogueitem catalogueitem2;
    @JoinColumns({
        @JoinColumn(name = "statusCat", referencedColumnName = "codeCatalogue", insertable = false, updatable = false),
        @JoinColumn(name = "status", referencedColumnName = "codeItem", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Catalogueitem catalogueitem4;

    public Person() {
    }

    public Person(Long codePerson) {
        this.codePerson = codePerson;
    }

    public Person(Long codePerson, String identify, String names, String lastNames, String name, String email, Date birthday, String sexCat, String sex, String typePersonCat, String typePerson, String typeIdentifyCat, String typeIdentify, String academicDegreeCat, String academicDegree, String country, String statusCat, String status, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify, Catalogueitem catalogueitem, Catalogueitem catalogueitem1, Catalogueitem catalogueitem2, Catalogueitem catalogueitem4) {
        this.codePerson = codePerson;
        this.identify = identify;
        this.names = names;
        this.lastNames = lastNames;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.sexCat = sexCat;
        this.sex = sex;
        this.typePersonCat = typePersonCat;
        this.typePerson = typePerson;
        this.typeIdentifyCat = typeIdentifyCat;
        this.typeIdentify = typeIdentify;
        this.academicDegreeCat = academicDegreeCat;
        this.academicDegree = academicDegree;
        this.country = country;
        this.statusCat = statusCat;
        this.status = status;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
        this.catalogueitem = catalogueitem;
        this.catalogueitem1 = catalogueitem1;
        this.catalogueitem2 = catalogueitem2;
        this.catalogueitem4 = catalogueitem4;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
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

    public String getSexCat() {
        return sexCat;
    }

    public void setSexCat(String sexCat) {
        this.sexCat = sexCat;
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

    public String getWorkArea() {
        return workArea;
    }

    public void setWorkArea(String workArea) {
        this.workArea = workArea;
    }

    public String getBibliography() {
        return bibliography;
    }

    public void setBibliography(String bibliography) {
        this.bibliography = bibliography;
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

    @XmlTransient
    public List<Rounds> getRoundsList() {
        return roundsList;
    }

    public void setRoundsList(List<Rounds> roundsList) {
        this.roundsList = roundsList;
    }

    @XmlTransient
    public List<Quizvalues> getQuizvaluesList() {
        return quizvaluesList;
    }

    public void setQuizvaluesList(List<Quizvalues> quizvaluesList) {
        this.quizvaluesList = quizvaluesList;
    }

}
