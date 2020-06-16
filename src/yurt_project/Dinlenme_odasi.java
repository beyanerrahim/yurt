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
public class Dinlenme_odasi extends Odalar{
    
    private int koltuk_sayisi;         //Dinlenme odasindaki koltuk sayısı
    private String hali_rengi;         //Dinlenme odasindaki halının rengi

    public Dinlenme_odasi() {
    }

    public Dinlenme_odasi(int koltuk_sayisi, String hali_rengi) {
        this.koltuk_sayisi = koltuk_sayisi;
        this.hali_rengi = hali_rengi;
    }

    public Dinlenme_odasi(int koltuk_sayisi, String hali_rengi, int oda_no, String oda_tip, String rengi) {
        super(oda_no, oda_tip, rengi);
        this.koltuk_sayisi = koltuk_sayisi;
        this.hali_rengi = hali_rengi;
    }

    public int getKoltuk_sayisi() {
        return koltuk_sayisi;
    }

    public void setKoltuk_sayisi(int koltuk_sayisi) {
        this.koltuk_sayisi = koltuk_sayisi;
    }

    public String getHali_rengi() {
        return hali_rengi;
    }

    public void setHali_rengi(String hali_rengi) {
        this.hali_rengi = hali_rengi;
    }
    
    
      @Override
    public String toString() {
        return "@" + this.getOda_no()+ "#" + this.getOda_tip()+ "$" + this.getRengi()+ "%" + this.getKoltuk_sayisi()+ "^" 
        + this.getHali_rengi()+ "&";
    }
    
    
}
