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
public class Arabca_ogretmen extends Ogretmen{
    private String mezun_ulke;          //öğretmen mezuniyet ülkesi
    private String milliyet;           //öğretmenin milliyeti

    public Arabca_ogretmen() {
    }

    public Arabca_ogretmen(String mezun_ulke, String milliyet) {
        this.mezun_ulke = mezun_ulke;
        this.milliyet = milliyet;
    }

    public Arabca_ogretmen(String mezun_ulke, String milliyet, int id, String ad_soyad, String tel, int mezuniyet_yili, String uzmanlik) {
        super(id, ad_soyad, tel, mezuniyet_yili, uzmanlik);
        this.mezun_ulke = mezun_ulke;
        this.milliyet = milliyet;
    }

    public String getMezun_ulke() {
        return mezun_ulke;
    }

    public void setMezun_ulke(String mezun_ulke) {
        this.mezun_ulke = mezun_ulke;
    }

    public String getMilliyet() {
        return milliyet;
    }

    public void setMilliyet(String milliyet) {
        this.milliyet = milliyet;
    }
    
    @Override
    public String toString() {
        return "@" + this.getId() + "#" + this.getAd_soyad() + "$" + this.getTel() + "%" + this.getMezuniyet_yili() + "^" + this.getUzmanlik()+ "&" + this.getMezun_ulke()+ "*"
                + this.getMilliyet()+ "@@" ;
    }
    
    
}
