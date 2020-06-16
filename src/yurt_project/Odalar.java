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
public class Odalar {
    
   private int oda_no;            //odanın numarası
   private String oda_tip;        //odanın tipi büyük küçük mü?
   private String rengi;

    public Odalar() {
    }

    public Odalar(int oda_no, String oda_tip, String rengi) {
        this.oda_no = oda_no;
        this.oda_tip = oda_tip;
        this.rengi = rengi;
    }

    public int getOda_no() {
        return oda_no;
    }

    public void setOda_no(int oda_no) {
        this.oda_no = oda_no;
    }

    public String getOda_tip() {
        return oda_tip;
    }

    public void setOda_tip(String oda_tip) {
        this.oda_tip = oda_tip;
    }

    public String getRengi() {
        return rengi;
    }

    public void setRengi(String rengi) {
        this.rengi = rengi;
    }
   
   
    
}
