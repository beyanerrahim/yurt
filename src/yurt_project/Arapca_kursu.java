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
public class Arapca_kursu extends Course{
    
    private String seviye;       //kurs seviyesi

    public Arapca_kursu() {
    }

    public Arapca_kursu(int id, String course_adi, String ogrenci_sayisi, String tarih) {
        super(id, course_adi, ogrenci_sayisi, tarih);
    }

    public Arapca_kursu(String seviye, int id, String course_adi, String ogrenci_sayisi, String tarih) {
        super(id, course_adi, ogrenci_sayisi, tarih);
        this.seviye = seviye;
    }

    public String getSeviye() {
        return seviye;
    }

    public void setSeviye(String seviye) {
        this.seviye = seviye;
    }  
    
    
    @Override
    public String toString() {
        return "@" + this.getId() + "#" + this.getCourse_adi() + "$" + this.getOgrenci_sayisi()+ "%" + this.getTarih() + "^" + this.getSeviye()+ "&";
    } 
    
    
}
