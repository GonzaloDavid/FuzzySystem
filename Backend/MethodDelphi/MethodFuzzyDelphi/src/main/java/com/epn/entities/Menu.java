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
@Table(name = "Menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")
    , @NamedQuery(name = "Menu.findBySeqMenu", query = "SELECT m FROM Menu m WHERE m.seqMenu = :seqMenu")
    , @NamedQuery(name = "Menu.findByNameMenu", query = "SELECT m FROM Menu m WHERE m.nameMenu = :nameMenu")
    , @NamedQuery(name = "Menu.findByDescription", query = "SELECT m FROM Menu m WHERE m.description = :description")
    , @NamedQuery(name = "Menu.findByGroup", query = "SELECT m FROM Menu m WHERE m.group = :group")
    , @NamedQuery(name = "Menu.findByDateCreate", query = "SELECT m FROM Menu m WHERE m.dateCreate = :dateCreate")
    , @NamedQuery(name = "Menu.findByDateLastModify", query = "SELECT m FROM Menu m WHERE m.dateLastModify = :dateLastModify")
    , @NamedQuery(name = "Menu.findByUserCreate", query = "SELECT m FROM Menu m WHERE m.userCreate = :userCreate")
    , @NamedQuery(name = "Menu.findByUserLastModify", query = "SELECT m FROM Menu m WHERE m.userLastModify = :userLastModify")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seqMenu")
    private Long seqMenu;
    @Basic(optional = false)
    @Column(name = "nameMenu")
    private String nameMenu;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "group")
    private boolean group;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
    private List<Menu> menuList;
    @JoinColumn(name = "parent", referencedColumnName = "seqMenu")
    @ManyToOne(optional = false)
    private Menu parent;

    public Menu() {
    }

    public Menu(Long seqMenu) {
        this.seqMenu = seqMenu;
    }

    public Menu(Long seqMenu, String nameMenu, String description, boolean group, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.seqMenu = seqMenu;
        this.nameMenu = nameMenu;
        this.description = description;
        this.group = group;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public Long getSeqMenu() {
        return seqMenu;
    }

    public void setSeqMenu(Long seqMenu) {
        this.seqMenu = seqMenu;
    }

    public String getNameMenu() {
        return nameMenu;
    }

    public void setNameMenu(String nameMenu) {
        this.nameMenu = nameMenu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getGroup() {
        return group;
    }

    public void setGroup(boolean group) {
        this.group = group;
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
    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqMenu != null ? seqMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.seqMenu == null && other.seqMenu != null) || (this.seqMenu != null && !this.seqMenu.equals(other.seqMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.Menu[ seqMenu=" + seqMenu + " ]";
    }
    
}
