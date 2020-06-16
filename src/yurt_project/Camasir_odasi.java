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
public class Camasir_odasi extends Odalar{
    
    private int makine_sayisi;           //çamaşır odasındaki makine sayısı
    private String makine_rengi;         //çamaşır odası rengi

    public Camasir_odasi() {
    }

    public Camasir_odasi(int makine_sayisi, String makine_rengi) {
        this.makine_sayisi = makine_sayisi;
        this.makine_rengi = makine_rengi;
    }

    public Camasir_odasi(int makine_sayisi, String makine_rengi, int oda_no, String oda_tip, String rengi) {
        super(oda_no, oda_tip, rengi);
        this.makine_sayisi = makine_sayisi;
        this.makine_rengi = makine_rengi;
    }

    public int getMakine_sayisi() {
        return makine_sayisi;
    }

    public void setMakine_sayisi(int makine_sayisi) {
        this.makine_sayisi = makine_sayisi;
    }

    public String getMakine_rengi() {
        return makine_rengi;
    }

    public void setMakine_rengi(String makine_rengi) {
        this.makine_rengi = makine_rengi;
    }
    
    @Override
    public String toString() {
        return "@" + this.getOda_no()+ "#" + this.getOda_tip()+ "$" + this.getRengi()+ "%" + this.getMakine_sayisi()+ "^" 
        + this.getMakine_rengi()+ "&";
    }   
    
}
