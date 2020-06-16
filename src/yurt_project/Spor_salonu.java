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
public class Spor_salonu extends Salonlar{
    private String spor_tipi;             //spor tipi
    private int uye_sayisi;               //üye sayısı

    public Spor_salonu() {
    }

    public Spor_salonu(String spor_tipi, int uye_sayisi) {
        this.spor_tipi = spor_tipi;
        this.uye_sayisi = uye_sayisi;
    }

    public Spor_salonu(String spor_tipi, int uye_sayisi, int id, String salon_tipi, String alan) {
        super(id, salon_tipi, alan);
        this.spor_tipi = spor_tipi;
        this.uye_sayisi = uye_sayisi;
    }

    public String getSpor_tipi() {
        return spor_tipi;
    }

    public void setSpor_tipi(String spor_tipi) {
        this.spor_tipi = spor_tipi;
    }

    public int getUye_sayisi() {
        return uye_sayisi;
    }

    public void setUye_sayisi(int uye_sayisi) {
        this.uye_sayisi = uye_sayisi;
    }
    
    @Override
    public String toString() {
        return "@" + this.getId()+ "#" + this.getSalon_tipi()+ "$" + this.getAlan()+ "%" + this.getSpor_tipi()+ "^" + this.getUye_sayisi()+ "&";
              
    }
    
    
}
