/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veritabaniyönetimsistemi;

/**
 *
 * @author merve
 */
public class Musteri {
    private String musteriNo;
    private String ad;
    private String soyAd;
    private String telefon;
    private String adres;

    public Musteri(String ad) {
        this.ad = ad;
    }

    public Musteri(String musteriNo, String ad, String soyAd, String telefon, String adres) {
        this.musteriNo=musteriNo;
        this.ad=ad;
        this.soyAd=soyAd;
        this.telefon=telefon;
        this.adres=adres;
    }
 
    public String getMusteriNo() {
        return musteriNo;
    }

    public String getAd() {
        return ad;
    }
    
    public String getSoyAd() {
        return soyAd;
    }
    
    public String getTelefon() {
        return telefon;
    }
    
    public String getAdres() {
        return adres;
    }
    public String setAd(String ad) {
        return this.ad = ad;
        
    }

    public String setSoyAd(String soyAd) {
        return this.soyAd=soyAd;
    }

    public String setTelefon(String telefon) {
        return this.telefon=telefon;
    }
    public String setAdres(String adres) {
        return this.adres=adres;
    }
   
    
    @Override
    public String toString() {
        return "Musteri{" +
                "musteriNo=" + musteriNo +
                ", adi: '" + ad + "\"" +
                ", soyadi: '" + soyAd + "\"" +
                ", telefon='" + telefon + "\"" +
                ", adres='" + adres + "\"" +
                "}";
    }

}
