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
public class Konferens_salonu extends Salonlar{
    
    private String kon_gunu;      //Konferens yapıldığı gün
    private String kon_saati;     //Konferens yapıldığı saati

    public Konferens_salonu() {
    }

    public Konferens_salonu(String kon_gunu, String kon_saati) {
        this.kon_gunu = kon_gunu;
        this.kon_saati = kon_saati;
    }

    public Konferens_salonu(String kon_gunu, String kon_saati, int id, String salon_tipi, String alan) {
        super(id, salon_tipi, alan);
        this.kon_gunu = kon_gunu;
        this.kon_saati = kon_saati;
    }

    public String getKon_gunu() {
        return kon_gunu;
    }

    public void setKon_gunu(String kon_gunu) {
        this.kon_gunu = kon_gunu;
    }

    public String getKon_saati() {
        return kon_saati;
    }

    public void setKon_saati(String kon_saati) {
        this.kon_saati = kon_saati;
    }
    @Override
    public String toString() {
        return "@" + this.getId()+ "#" + this.getSalon_tipi()+ "$" + this.getAlan()+ "%" + this.getKon_gunu()+ "^" + this.getKon_saati()+ "&";
              
    }
    
    
}
