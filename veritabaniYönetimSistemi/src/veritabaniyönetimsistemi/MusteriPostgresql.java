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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MusteriPostgresql {
    

    private Connection baglan(){

        Connection conn=null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/b171210069",
                    "postgres", "1836948");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public Musteri ara(String musteriNo){
        System.out.println("ürün aranıyor...");
        Musteri musteri=null;

        String sql= "SELECT *  FROM \"Musteri\" WHERE \"musteriNo\"="+musteriNo;

        Connection conn=this.baglan();
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            //***** Bağlantı sonlandırma *****
            conn.close();

             
             String ad;
             String soyAd;
             String telefon;
             String adres;


            

            while(rs.next())
            {
                musteriNo  = rs.getString("musteriNo");
                ad = rs.getString("ad");
                soyAd = rs.getString("soyAd");
                telefon = rs.getString("telefon");
                adres = rs.getString("adres");

                musteri=new Musteri(musteriNo, ad, soyAd, telefon, adres);
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return musteri;
    }



    public List<Musteri> tumMusteriler(){

        System.out.println("musteri kayitlari getiriliyor...");
        List<Musteri> musteriler=new ArrayList<Musteri>();
        String sql= "SELECT *  FROM \"Musteri\"";

        Connection conn=this.baglan();

        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            //***** Bağlantı sonlandırma *****
            conn.close();

            String musteriNo;
            String ad;
            String soyAd;
            String telefon;
            String adres;

            
            while(rs.next())
            {
                musteriNo  = rs.getString("musteriNo");
                ad = rs.getString("ad");
                soyAd = rs.getString("soyAd");
                telefon = rs.getString("telefon");
                adres = rs.getString("adres");

                musteriler.add(new Musteri(musteriNo, ad, soyAd, telefon, adres));
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return musteriler;
    }


    public void kaydet(Musteri musteri){
       
        String sql= "INSERT INTO  \"Musteri\" (\"ad\",\"soyAd\",\"telefon\",\"adres\") VALUES(\""+musteri.getAd()+"\","+musteri.getSoyAd()+"\","+musteri.getTelefon()+"\","+musteri.getAdres()+")";

        Connection conn=this.baglan();

        try
        {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            //***** Bağlantı sonlandırma *****
            conn.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sil(String musteriNo){
        System.out.println("musteri kaydi siliniyor...");

        String sql= "DELETE FROM \"Musteri\" WHERE \"musteriNo\"="+musteriNo;

        Connection conn=this.baglan();
        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            //***** Bağlantı sonlandırma *****
            conn.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void degistir(Musteri musteri) {

        String sql= "UPDATE \"Musteri\" SET \"ad\"=\""+musteri.getAd()+
                "\", \"soyAd\"="+musteri.getSoyAd()+
                ",\"telefon\"="+musteri.getTelefon()+
                ",\"adres\"="+musteri.getAdres()+
                " WHERE \"musteriNo\"="+musteri.getMusteriNo();

        Connection conn=this.baglan();

        try
        {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            //***** Bağlantı sonlandırma *****
            conn.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
