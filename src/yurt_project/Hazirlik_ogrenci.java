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
public class Hazirlik_ogrenci extends Ogrenci{
    
    private String  dil_adi;    //hazırlık öğrencisinin okuduğu dil

    public Hazirlik_ogrenci() {
    }

    public Hazirlik_ogrenci(String dil_adi) {
        this.dil_adi = dil_adi;
    }

    public Hazirlik_ogrenci(int id, String ad_soyad, String tc, int yas, String tel, String email, int ucret) {
        super(id, ad_soyad, tc, yas, tel, email, ucret);
    }

    public Hazirlik_ogrenci(String dil_adi, int id, String ad_soyad, String tc, int yas, String tel, String email, int ucret) {
        super(id, ad_soyad, tc, yas, tel, email, ucret);
        this.dil_adi = dil_adi;
    }
    
    public String getDil_adi() {
        return dil_adi;
    }

    public void setDil_adi(String dil_adi) {
        this.dil_adi = dil_adi;
    }
    
   
    @Override
    public String toString() {
        return "@" + this.getId() + "#" + this.getYas() + "$" + this.getAd_soyad() + "%" + this.getUcret() + "^" + this.getTel()+ "&" + this.getTc()+ "*"
                + this.getDil_adi()+ "@@" + this.getEmail()+ "##";
    }
    
    
}
