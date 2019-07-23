/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import java.util.Date;

/**
 *
 * @author desarrollador
 */
public class PersonContainer {

    private Long codePerson;
    private String identify;
    private String names;
    private String lastNames;
    private String name;
    private String email;
    private Date birthday;
    private String sexCat;
    private String sex;
    private Date dateCreate;
    private Date dateLastModify;
    private long userCreate;
    private long userLastModify;
    private String workArea;
//    private List<AdminisEmail> adminisEmailList;
    private String typePersonCat;
    private String typePerson;
    private String typeIdentifyCat;
    private String typeIdentify;
    private String academicDegreeCat;
    private String academicDegree;
    private String country;
    private String statusCat;
    private String status;

    public PersonContainer() {
    }

    public PersonContainer(Long codePerson, String identify, String names, String lastNames, String name, String email, Date birthday, String sexCat, String sex, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify, String typePersonCat, String typePerson, String typeIdentifyCat, String typeIdentify, String academicDegreeCat, String academicDegree, String country, String statusCat, String status) {
        this.codePerson = codePerson;
        this.identify = identify;
        this.names = names;
        this.lastNames = lastNames;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.sexCat = sexCat;
        this.sex = sex;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
        this.typePersonCat = typePersonCat;
        this.typePerson = typePerson;
        this.typeIdentifyCat = typeIdentifyCat;
        this.typeIdentify = typeIdentify;
        this.academicDegreeCat = academicDegreeCat;
        this.academicDegree = academicDegree;
        this.country = country;
        this.statusCat = statusCat;
        this.status = status;
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

    public String getTypePersonCat() {
        return typePersonCat;
    }

    public void setTypePersonCat(String typePersonCat) {
        this.typePersonCat = typePersonCat;
    }

    public String getTypePerson() {
        return typePerson;
    }

    public void setTypePerson(String typePerson) {
        this.typePerson = typePerson;
    }

    public String getTypeIdentifyCat() {
        return typeIdentifyCat;
    }

    public void setTypeIdentifyCat(String typeIdentifyCat) {
        this.typeIdentifyCat = typeIdentifyCat;
    }

    public String getTypeIdentify() {
        return typeIdentify;
    }

    public void setTypeIdentify(String typeIdentify) {
        this.typeIdentify = typeIdentify;
    }

    public String getAcademicDegreeCat() {
        return academicDegreeCat;
    }

    public void setAcademicDegreeCat(String academicDegreeCat) {
        this.academicDegreeCat = academicDegreeCat;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCodePerson() {
        return codePerson;
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

    public String getSexCat() {
        return sexCat;
    }

    public void setSexCat(String sexCat) {
        this.sexCat = sexCat;
    }

    public String getWorkArea() {
        return workArea;
    }

    public void setWorkArea(String workArea) {
        this.workArea = workArea;
    }
    
}
