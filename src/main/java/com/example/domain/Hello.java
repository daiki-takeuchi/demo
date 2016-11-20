package com.example.domain;

/**
 * Created by DaikiTakeuchi on 2016/11/19.
 */
public class Hello {
    private String name;
    private String mail;
    private String tel;

    public Hello(String name, String mail, String tel){
        this.name = name;
        this.mail = mail;
        this.tel = tel;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getMail() { return mail; }

    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
}
