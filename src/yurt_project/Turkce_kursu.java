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
public class Turkce_kursu extends Course{
    private String seviye;             //kursun seviye ileri mi başlangıç mı?
    private String kitap_adi;          //kursta öğretilecek kitabın adı

    public Turkce_kursu() {
    }

    public Turkce_kursu(String seviye, String kitap_adi) {
        this.seviye = seviye;
        this.kitap_adi = kitap_adi;
    }

    public Turkce_kursu(int id, String course_adi, String ogrenci_sayisi, String tarih) {
        super(id, course_adi, ogrenci_sayisi, tarih);
    }

    public Turkce_kursu(String seviye, String kitap_adi, int id, String course_adi, String ogrenci_sayisi, String tarih) {
        super(id, course_adi, ogrenci_sayisi, tarih);
        this.seviye = seviye;
        this.kitap_adi = kitap_adi;
    }

    public String getSeviye() {
        return seviye;
    }

    public void setSeviye(String seviye) {
        this.seviye = seviye;
    }

    public String getKitap_adi() {
        return kitap_adi;
    }

    public void setKitap_adi(String kitap_adi) {
        this.kitap_adi = kitap_adi;
    }
    
    @Override
    public String toString() {
        return "@" + this.getId() + "#" + this.getCourse_adi() + "$" + this.getOgrenci_sayisi()+ "%" + this.getTarih() + "^" + this.getSeviye()+ "&"+this.getKitap_adi()+"*";
    } 
    
    
}
