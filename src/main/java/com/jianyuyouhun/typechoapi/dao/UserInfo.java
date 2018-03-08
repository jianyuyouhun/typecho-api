package com.jianyuyouhun.typechoapi.dao;

import javax.persistence.*;

@Entity
@Table(name = "typecho_users")
public class UserInfo {

    @Id
    @Column(name = "uid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", columnDefinition = "varchar(32)")
    private String userName;

    @Column(name = "password", columnDefinition = "varchar(64)")
    private String password;

    @Column(name = "mail", columnDefinition = "varchar(200)")
    private String mail;

    @Column(name = "url", columnDefinition = "varchar(200)")
    private String url;

    @Column(name = "screenName", columnDefinition = "varchar(32)")
    private String screenName;

    @Column(name = "created", columnDefinition = "int(10)")
    private int createDt;

    @Column(name = "activated", columnDefinition = "int(10)")
    private int activeDt;

    @Column(name = "logged", columnDefinition = "int(10)")
    private int logged;

    @Column(name = "group", columnDefinition = "varchar(16) default 'visitor'")
    private String group;

    @Column(name = "authCode", columnDefinition = "varchar(64)")
    private String authCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public int getCreateDt() {
        return createDt;
    }

    public void setCreateDt(int createDt) {
        this.createDt = createDt;
    }

    public int getActiveDt() {
        return activeDt;
    }

    public void setActiveDt(int activeDt) {
        this.activeDt = activeDt;
    }

    public int getLogged() {
        return logged;
    }

    public void setLogged(int logged) {
        this.logged = logged;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
}
