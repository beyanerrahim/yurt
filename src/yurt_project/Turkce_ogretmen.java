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
public class Turkce_ogretmen extends Ogretmen{
    
    private String milliyet;           //öğretmenin milliyeti

    public Turkce_ogretmen() {
    }

    public Turkce_ogretmen(String milliyet) {
        this.milliyet = milliyet;
    }

    public Turkce_ogretmen(String milliyet, int id, String ad_soyad, String tel, int mezuniyet_yili, String uzmanlik) {
        super(id, ad_soyad, tel, mezuniyet_yili, uzmanlik);
        this.milliyet = milliyet;
    }

    public String getMilliyet() {
        return milliyet;
    }

    public void setMilliyet(String milliyet) {
        this.milliyet = milliyet;
    }
    
   @Override
    public String toString() {
        return "@" + this.getId() + "#" + this.getAd_soyad() + "$" + this.getTel() + "%" + this.getMezuniyet_yili() + "^" + this.getUzmanlik()+ "&" + this.getMilliyet()+ "*";
              
    } 
    
}
