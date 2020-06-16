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
public class Course {
    
    private int id;                     //kurs numarası
    private String course_adi;          //kurs ismi
    private String ogrenci_sayisi;      //kurstaki öğrenci sayısı
    private String tarih;               //kursun başlangıç tarihi

    public Course() {
    }

    public Course(int id, String course_adi, String ogrenci_sayisi, String tarih) {
        this.id = id;
        this.course_adi = course_adi;
        this.ogrenci_sayisi = ogrenci_sayisi;
        this.tarih = tarih;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse_adi() {
        return course_adi;
    }

    public void setCourse_adi(String course_adi) {
        this.course_adi = course_adi;
    }

    public String getOgrenci_sayisi() {
        return ogrenci_sayisi;
    }

    public void setOgrenci_sayisi(String ogrenci_sayisi) {
        this.ogrenci_sayisi = ogrenci_sayisi;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }
    
    
    
    
    
}
