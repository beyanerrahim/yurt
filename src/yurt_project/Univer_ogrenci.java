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
public class Univer_ogrenci extends Ogrenci{
    
    private String fakulte_adi;       //öğrenci okuduğu fakültenin  adı
    private String bolum_adi;         //öğrenci okuduğu bölümün adı

    public Univer_ogrenci() {
    }
    
    public Univer_ogrenci(String fakulte_adi, String bolum_adi) {
        this.fakulte_adi = fakulte_adi;
        this.bolum_adi = bolum_adi;
    }

    public Univer_ogrenci(String fakulte_adi, String bolum_adi, int id, String ad_soyad, String tc, int yas, String tel, String email, int ucret) {
        super(id, ad_soyad, tc, yas, tel, email, ucret);
        this.fakulte_adi = fakulte_adi;
        this.bolum_adi = bolum_adi;
    }

    
    
    public String getFakulte_adi() {
        return fakulte_adi;
    }

    public void setFakulte_adi(String fakulte_adi) {
        this.fakulte_adi = fakulte_adi;
    }

    public String getBolum_adi() {
        return bolum_adi;
    }

    public void setBolum_adi(String bolum_adi) {
        this.bolum_adi = bolum_adi;
    }
    
    @Override
    public String toString() {
        return "@" + this.getId() + "#" + this.getYas() + "$" + this.getAd_soyad() + "%" + this.getUcret() + "^" + this.getTel()+ "&" + this.getTc()+ "*"
                + this.getFakulte_adi()+ "@@" + this.getEmail()+ "##"+this.getBolum_adi()+"$$";
    }
     
    
}
