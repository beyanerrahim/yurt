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
public class Yemek {
    private int id;                 //yemek numarası
    private String gun;             //yemek günü
    private String tarih;           //yemek saati
    private String yemek_adi;       //yemek adı
    private String icecek_adi;      //içecek adı

    public Yemek() {
    } 

    public Yemek(int id, String gun, String tarih, String yemek_adi, String icecek_adi) {
        this.id = id;
        this.gun = gun;
        this.tarih = tarih;
        this.yemek_adi = yemek_adi;
        this.icecek_adi = icecek_adi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGun() {
        return gun;
    }

    public void setGun(String gun) {
        this.gun = gun;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getYemek_adi() {
        return yemek_adi;
    }

    public void setYemek_adi(String yemek_adi) {
        this.yemek_adi = yemek_adi;
    }

    public String getIcecek_adi() {
        return icecek_adi;
    }

    public void setIcecek_adi(String icecek_adi) {
        this.icecek_adi = icecek_adi;
    }
    
   @Override
    public String toString() {
        return "@" + this.getId() + "#" + this.getGun() + "$" + this.getTarih()+ "%" + this.getYemek_adi() + "^" + this.getIcecek_adi()+ "&";
    } 
    
    
}
