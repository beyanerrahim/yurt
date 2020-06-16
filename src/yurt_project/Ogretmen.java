/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yurt_project;

/**
 *
 * @author Bayoon
 */
public class Ogretmen {
    
    private int id;                      //öğretmen numarası
    private String ad_soyad;             //öğretmenin adı soyadı
    private String tel;                  //öğretmenin telefon numarası
    private int mezuniyet_yili;          //öğretmenin mezun olduğu yıl
    private String uzmanlik;             //öğretmenin uzmanlığı(kaç yıldı çalışiyor)

    public Ogretmen() {
    }

    public Ogretmen(int id, String ad_soyad, String tel, int mezuniyet_yili, String uzmanlik) {
        this.id = id;
        this.ad_soyad = ad_soyad;
        this.tel = tel;
        this.mezuniyet_yili = mezuniyet_yili;
        this.uzmanlik = uzmanlik;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getMezuniyet_yili() {
        return mezuniyet_yili;
    }

    public void setMezuniyet_yili(int mezuniyet_yili) {
        this.mezuniyet_yili = mezuniyet_yili;
    }

    public String getUzmanlik() {
        return uzmanlik;
    }

    public void setUzmanlik(String uzmanlik) {
        this.uzmanlik = uzmanlik;
    }
       
    
}
