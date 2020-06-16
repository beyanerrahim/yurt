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
public class Yatak_odasi extends Odalar {
    private int yatak_sayisi ;       //Yatak odasındaki yatak sayısı
    private int kisi_sayisi;         //Yatak odasındaki kişi sayısı
    private String hali_rengi;       //Yatak odasındaki halının rengi

    public Yatak_odasi() {
    }

    public Yatak_odasi(int yatak_sayisi, int kisi_sayisi, String hali_rengi) {
        this.yatak_sayisi = yatak_sayisi;
        this.kisi_sayisi = kisi_sayisi;
        this.hali_rengi = hali_rengi;
    }

    public Yatak_odasi(int yatak_sayisi, int kisi_sayisi, String hali_rengi, int oda_no, String oda_tip, String rengi) {
        super(oda_no, oda_tip, rengi);
        this.yatak_sayisi = yatak_sayisi;
        this.kisi_sayisi = kisi_sayisi;
        this.hali_rengi = hali_rengi;
    }

    public int getYatak_sayisi() {
        return yatak_sayisi;
    }

    public void setYatak_sayisi(int yatak_sayisi) {
        this.yatak_sayisi = yatak_sayisi;
    }

    public int getKisi_sayisi() {
        return kisi_sayisi;
    }

    public void setKisi_sayisi(int kisi_sayisi) {
        this.kisi_sayisi = kisi_sayisi;
    }

    public String getHali_rengi() {
        return hali_rengi;
    }

    public void setHali_rengi(String hali_rengi) {
        this.hali_rengi = hali_rengi;
    }
      @Override
    public String toString() {
        return "@" + this.getOda_no()+ "#" + this.getOda_tip()+ "$" + this.getRengi()+ "%" + this.getYatak_sayisi()+ "^" + this.getKisi_sayisi()+ "&" + this.getHali_rengi()+ "*";
              
    }
    
            
}
