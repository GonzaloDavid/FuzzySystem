/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.AdminisEmail;
import java.util.Date;
import java.util.List;

/**
 *
 * @author desarrollador
 */
public class PersonContainer {

    private Long codePerson;
    private String identify;
    private String firstName;
    private String middleName;
    private String lastName;
    private String lastNameMatern;
    private String name;
    private String email;
    private Date birthday;
    private String sex;
    private Date dateCreate;
    private Date dateLastModify;
    private long userCreate;
    private long userLastModify;
    private List<AdminisEmail> adminisEmailList;
    private String typePersonCat;
    private String typePerson;
    private String typeIdentifyCat;
    private String typeIdentify;
    private String academicDegreeCat;
    private String academicDegree;
    private String countryCat;
    private String country;
    private String statusCat;
    private String status;

    public PersonContainer() {
    }

    public PersonContainer(Long codePerson, String identify, String firstName, String middleName, String lastName, String lastNameMatern, String name, String email, Date birthday, String sex, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify, List<AdminisEmail> adminisEmailList, String typePersonCat, String typePerson, String typeIdentifyCat, String typeIdentify, String academicDegreeCat, String academicDegree, String countryCat, String country, String statusCat, String status) {
        this.codePerson = codePerson;
        this.identify = identify;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.lastNameMatern = lastNameMatern;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.sex = sex;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
        this.adminisEmailList = adminisEmailList;
        this.typePersonCat = typePersonCat;
        this.typePerson = typePerson;
        this.typeIdentifyCat = typeIdentifyCat;
        this.typeIdentify = typeIdentify;
        this.academicDegreeCat = academicDegreeCat;
        this.academicDegree = academicDegree;
        this.countryCat = countryCat;
        this.country = country;
        this.statusCat = statusCat;
        this.status = status;
    }

    public List<AdminisEmail> getAdminisEmailList() {
        return adminisEmailList;
    }

    public void setAdminisEmailList(List<AdminisEmail> adminisEmailList) {
        this.adminisEmailList = adminisEmailList;
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

}
