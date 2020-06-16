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
public class Lise_ogrenci extends Ogrenci {
    
    private String lise_adi;  //öğrencinin çalıştığı lisenin adı

    public Lise_ogrenci() {
    }

    public Lise_ogrenci(String lise_adi) {
        this.lise_adi = lise_adi;
    }

    public Lise_ogrenci(int id, String ad_soyad, String tc, int yas, String tel, String email, int ucret) {
        super(id, ad_soyad, tc, yas, tel, email, ucret);
    }
    

    public Lise_ogrenci( int id, String ad_soyad, String tc, int yas, String tel, String email, int ucret,String lise_adi) {
        super(id, ad_soyad, tc, yas, tel, email, ucret);
        this.lise_adi = lise_adi;
    }

    public String getLise_adi() {
        return lise_adi;
    }

    public void setLise_adi(String lise_adi) {
        this.lise_adi = lise_adi;
    }
   
    @Override
    public String toString() {
        return "@" + this.getId() + "#" + this.getYas() + "$" + this.getAd_soyad() + "%" + this.getUcret() + "^" + this.getTel()+ "&" + this.getTc()+ "*"
                + this.getLise_adi()+ "@@" + this.getEmail()+ "##";
    }
    
}
