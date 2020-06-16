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
public class Salonlar {
    
    private int id;                    //salon numarası
    private String salon_tipi;         //salon tipi
    private String alan;               //salonun alanı

    public Salonlar() {
    }

    
    public Salonlar(int id, String salon_tipi, String alan) {
        this.id = id;
        this.salon_tipi = salon_tipi;
        this.alan = alan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalon_tipi() {
        return salon_tipi;
    }

    public void setSalon_tipi(String salon_tipi) {
        this.salon_tipi = salon_tipi;
    }

    public String getAlan() {
        return alan;
    }

    public void setAlan(String alan) {
        this.alan = alan;
    }
     
}
