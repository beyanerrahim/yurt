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
public class Calisma_salonu extends Salonlar{
    private int masa_sayisi;         //çalışma odasındaki masa sayısı
    private int sandalye_sayisi;     //çalışma odasındaki sandalye sayısı
    private String salon_rengi;      ///çalışma odası rengi

    public Calisma_salonu() {
    }

    public Calisma_salonu(int masa_sayisi, int sandalye_sayisi, String salon_rengi) {
        this.masa_sayisi = masa_sayisi;
        this.sandalye_sayisi = sandalye_sayisi;
        this.salon_rengi = salon_rengi;
    }

    public Calisma_salonu(int masa_sayisi, int sandalye_sayisi, String salon_rengi, int id, String salon_tipi, String alan) {
        super(id, salon_tipi, alan);
        this.masa_sayisi = masa_sayisi;
        this.sandalye_sayisi = sandalye_sayisi;
        this.salon_rengi = salon_rengi;
    }
    
    public Calisma_salonu(int id, String salon_tipi, String alan) {
        super(id, salon_tipi, alan);
    }

    public int getMasa_sayisi() {
        return masa_sayisi;
    }

    public void setMasa_sayisi(int masa_sayisi) {
        this.masa_sayisi = masa_sayisi;
    }

    public int getSandalye_sayisi() {
        return sandalye_sayisi;
    }

    public void setSandalye_sayisi(int sandalye_sayisi) {
        this.sandalye_sayisi = sandalye_sayisi;
    }

    public String getSalon_rengi() {
        return salon_rengi;
    }

    public void setSalon_rengi(String salon_rengi) {
        this.salon_rengi = salon_rengi;
    }
    
    @Override
    public String toString() {
        return "@" + this.getId()+ "#" + this.getSalon_tipi()+ "$" + this.getAlan()+ "%" + this.getMasa_sayisi()+ "^" + this.getSandalye_sayisi()+ "&" + this.getSalon_rengi()+ "*";
              
    }
    
}
