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
public class Kuran_kursu extends Course{
    
    private int parca_sayisi;    //kuranın kursta verilen kısım(parça) sayısı

    public Kuran_kursu() {
    }

    public Kuran_kursu(int parca_sayisi) {
        this.parca_sayisi = parca_sayisi;
    }

    public Kuran_kursu(int id, String course_adi, String ogrenci_sayisi, String tarih) {
        super(id, course_adi, ogrenci_sayisi, tarih);
    }

    public Kuran_kursu(int parca_sayisi, int id, String course_adi, String ogrenci_sayisi, String tarih) {
        super(id, course_adi, ogrenci_sayisi, tarih);
        this.parca_sayisi = parca_sayisi;
    }

    public int getParca_sayisi() {
        return parca_sayisi;
    }

    public void setParca_sayisi(int parca_sayisi) {
        this.parca_sayisi = parca_sayisi;
    }
    
    @Override
    public String toString() {
        return "@" + this.getId() + "#" + this.getCourse_adi() + "$" + this.getOgrenci_sayisi()+ "%" + this.getTarih() + "^" + this.getParca_sayisi()+ "&";
    } 
    
    
}
