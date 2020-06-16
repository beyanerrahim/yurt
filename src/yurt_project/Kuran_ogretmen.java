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
public class Kuran_ogretmen extends Ogretmen{
    
    private String Kur_ezber;   //kurani ezberleyen mi?

    public Kuran_ogretmen() {
    }
    

    public Kuran_ogretmen(String Kur_ezber) {
        this.Kur_ezber = Kur_ezber;
    }

    public Kuran_ogretmen(String Kur_ezber, int id, String ad_soyad, String tel, int mezuniyet_yili, String uzmanlik) {
        super(id, ad_soyad, tel, mezuniyet_yili, uzmanlik);
        this.Kur_ezber = Kur_ezber;
    }

    public String getKur_ezber() {
        return Kur_ezber;
    }

    public void setKur_ezber(String Kur_ezber) {
        this.Kur_ezber = Kur_ezber;
    }
    @Override
    public String toString() {
        return "@" + this.getId() + "#" + this.getAd_soyad() + "$" + this.getTel() + "%" + this.getMezuniyet_yili() + "^" + this.getUzmanlik()+ "&" + this.getKur_ezber()+ "*";
              
    }
}
