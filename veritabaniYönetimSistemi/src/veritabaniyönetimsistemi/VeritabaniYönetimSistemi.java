/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veritabaniyönetimsistemi;
import java.sql.*;
import java.util.Scanner;
import java.util.List;
/**
 *
 * @author merve
 */



public class VeritabaniYönetimSistemi {

    public static void main(String args[]){

        Scanner giris = new Scanner(System.in);

        
        Musteri musteri=null;
        String musteriNo;
        String ad;
        String soyAd;
        String telefon;
        String adres;
        
        System.out.println("1. Arama");
        System.out.println("2. Siralama");
        System.out.println("3. Kayit ekleme");
        System.out.println("4. Silme");
        System.out.println("5. Guncelleme");
        
                //*****ürüne ait veritabanı işlemleri için kullanılacak nesne**************************

        MusteriPostgresql musteriRp=new MusteriPostgresql();

 // /*
 
        int secim;
        
        do{
            System.out.println("Yapmak istediginiz islemi secin.");
        Scanner sc = new Scanner(System.in);
        secim = sc.nextInt();
        switch(secim){
            case 1: 


                System.out.println("*********************Arama**************************");


                System.out.println("aradığınız ürünün numarasını giriniz");
                musteriNo=giris.nextLine();
                musteri= musteriRp.ara(musteriNo);
                if(musteriNo==musteri.getMusteriNo())
                    System.out.println("Aradığınız ürün:"+musteri);
                else
                    System.out.println("aradığınız ürün bulunamadı");

                
            break;
            case 2:
                
                 System.out.println("******************tüm musterileri sirala********************");

        List<Musteri> musterilerinListesi;

        musterilerinListesi= musteriRp.tumMusteriler();
        System.out.println(musterilerinListesi);
        System.out.println('\n');
        break;

            case 3:
        System.out.println("Kaydini eklemek istediğiniz musterinin adını giriniz:");
        final String musteriAdi=giris.nextLine();
        

        musterilerinListesi= musteriRp.tumMusteriler();
        // Liste içerisinden ürün adına göre arama yapıyor ve musteri nesnesini döndürüyor
        musteri = musterilerinListesi.stream()
                .filter(urunElementi -> musteriAdi.equalsIgnoreCase(urunElementi.getAd()))
                .findAny()
                .orElse(null);
        if(musteri!=null)
                System.out.println("Eklemek istediğiniz musteri:"+musteri);
            
            System.out.println("******************Kaydet********************");

            System.out.println("musteri numarasını giriniz");
            musteriNo=giris.nextLine();
            System.out.println("Musteri adını giriniz:");
            ad=giris.nextLine();

            System.out.println("musteri numarasi giriniz");
            
            musteriNo=giris.nextLine();
             System.out.println("soyad: ");
            soyAd=giris.nextLine();
             System.out.println("telefon:  ");
            telefon=giris.nextLine();
             System.out.println("adres: ");
             adres=giris.nextLine();

        //musteri=new Urun(musteriNo,ad,birimFiyati,stokMiktari);
        musteri=new Musteri(musteriNo, ad,soyAd,telefon, adres); // musteriNo değeri vt içerisinde sayıcıyla atanıyor (serial, auto increment)

        musteriRp.kaydet(musteri);
        break;

            case 4:

        System.out.println("******************Silme**************************");

        //List<Musteri> musterilerinListesi;

        musterilerinListesi= musteriRp.tumMusteriler();
        System.out.println(musterilerinListesi);

        System.out.println("Silmek istediğiniz musterinin musteriNo sunu giriniz:");
        musteriNo=giris.nextLine(); giris.nextLine();
        musteriRp.sil(musteriNo);

//*/    

        case 5:
            
        System.out.println("******************Değişiklik**************************");

        //List<Musteri> musterilerinListesi;

        musterilerinListesi= musteriRp.tumMusteriler();
        System.out.println(musterilerinListesi);

        System.out.println("Kaydini guncellemek istediginiz musterinin adını giriniz:");
        String guncellenecekMusterininAdi=giris.nextLine();

        //musteri= musteriRp.ara(musteriNo);

        musteri = musterilerinListesi.stream()
                .filter(musteriElement -> guncellenecekMusterininAdi.equalsIgnoreCase(musteriElement.getAd()))
                .findAny()
                .orElse(null);

        if(musteri!=null){

            System.out.println("Değiştirmek istediğiniz musteri: "+musteri);

            System.out.println("Yeni musteri adini giriniz:");
            ad=giris.nextLine();

            System.out.println("Yeni musteri kaydinin soyAd, telefon ve adres bilgilerini giriniz");
            soyAd=giris.nextLine();
            telefon=giris.nextLine();
            adres=giris.nextLine();

            musteri.setAd(ad);
            musteri.setSoyAd(soyAd);
            musteri.setTelefon(telefon);
            musteri.setAdres(adres);
            musteriRp.degistir(musteri);

        }
        else
            System.out.println("aradığınız musteri bilgisi bulunamadı");
        
        break;
        default:
            System.out.println("gecersiz secim");
        
        }
        }while(secim!=5);
        
        System.out.println("CLS");
        

    }
}