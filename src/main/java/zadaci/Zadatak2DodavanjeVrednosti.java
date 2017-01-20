package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Brod;
import model.Kontejner;

import java.io.IOException;
import java.util.List;

/**
 * Created by androiddevelopment on 20.1.17..
 */
public class Zadatak2DodavanjeVrednosti {

            static Dao<Brod, Integer> brodDao ;
            static Dao<Kontejner, Integer> kontejnerDao ;



    public static void main(String[] args){
        ConnectionSource connectionSource = null;

        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:brodKontejner.db");


      //-----------------deo za brodove-----------------------------------
            Brod B1 = new Brod("Brod1", "Transporter1");
            Brod B2 = new Brod("Brod2", "Transporter2");

            brodDao= DaoManager.createDao(connectionSource,Brod.class);

            brodDao.create(B1);
            brodDao.create(B2);

      //----------------deo za kontejnere--------------------------------------
            Kontejner K1=new Kontejner("KP1", "Namestaj", 100 );
                    K1.setBrod(B1);
            Kontejner K2=new Kontejner("KP2", "Banane", 1000.5);
                    K2.setBrod(B1);
            Kontejner K3=new Kontejner("KP3", "Morski proizvodi", 200.7);
                    K3.setBrod(B1);
            Kontejner K4=new Kontejner("KP4", "Mercedes", 500.4);
                    K4.setBrod(B2);
            Kontejner K5=new Kontejner("KP5", "Klavir", 100);
                    K5.setBrod(B2);


            kontejnerDao= DaoManager.createDao(connectionSource,Kontejner.class);

            kontejnerDao.create(K1);
            kontejnerDao.create(K2);
            kontejnerDao.create(K3);
            kontejnerDao.create(K4);
            kontejnerDao.create(K5);

       //--------------------------prikaz iz baze-------------------------

            //----------brodovi----------------------------
            List<Brod> brodovi = brodDao.queryForAll();

            for(Brod b: brodovi){
                System.out.println(b);
                }



            //---------kontejneri---------------------------
            List<Kontejner> kontejneri = kontejnerDao.queryForAll();

            for(Kontejner k : kontejneri){
                System.out.println(k);
            }



        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connectionSource != null) {
                try {
                    connectionSource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
