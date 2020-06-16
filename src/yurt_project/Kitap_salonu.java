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
public class Kitap_salonu extends Salonlar{
    private int kitap_sayisi;       //Kitap salonudaki kitap sayısı 
    private String kitap_tipi;      //Kitap salonudaki kitap tipi
    private String durum;           //kitaplar durumu yeni mi eski mi?

    public Kitap_salonu() {
    }

    public Kitap_salonu(int kitap_sayisi, String kitap_tipi, String durum) {
        this.kitap_sayisi = kitap_sayisi;
        this.kitap_tipi = kitap_tipi;
        this.durum = durum;
    }

    public Kitap_salonu(int kitap_sayisi, String kitap_tipi, String durum, int id, String salon_tipi, String alan) {
        super(id, salon_tipi, alan);
        this.kitap_sayisi = kitap_sayisi;
        this.kitap_tipi = kitap_tipi;
        this.durum = durum;
    }

    public int getKitap_sayisi() {
        return kitap_sayisi;
    }

    public void setKitap_sayisi(int kitap_sayisi) {
        this.kitap_sayisi = kitap_sayisi;
    }

    public String getKitap_tipi() {
        return kitap_tipi;
    }

    public void setKitap_tipi(String kitap_tipi) {
        this.kitap_tipi = kitap_tipi;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }
    
    @Override
    public String toString() {
        return "@" + this.getId()+ "#" + this.getSalon_tipi()+ "$" + this.getAlan()+ "%" + this.getKitap_sayisi()+ "^" + this.getKitap_tipi()+ "&" + this.getDurum()+ "*";
              
    }
}
