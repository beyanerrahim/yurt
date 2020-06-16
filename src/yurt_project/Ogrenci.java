/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yurt_project;


public class Ogrenci {
    private int id;                   //öğrencinin numarası
    private String ad_soyad;          //öğrencinin adı soyadı
    private String tc;                //kimlik numarası
    private int yas;                  //öğrencinin yaşı
    private String tel;               //öğrencinin telefon numarası
    private String email;             //email adresi
    private int ucret;                //yurt ücreti

    public Ogrenci() {
    }

    public Ogrenci(int id, String ad_soyad, String tc, int yas, String tel, String email, int ucret) {
        this.id = id;
        this.ad_soyad = ad_soyad;
        this.tc = tc;
        this.yas = yas;
        this.tel = tel;
        this.email = email;
        this.ucret = ucret;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd_soyad() {
        return ad_soyad;
    }

    public void setAd_soyad(String ad_soyad) {
        this.ad_soyad = ad_soyad;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUcret() {
        return ucret;
    }

    public void setUcret(int ucret) {
        this.ucret = ucret;
    }
    
    
    
}
