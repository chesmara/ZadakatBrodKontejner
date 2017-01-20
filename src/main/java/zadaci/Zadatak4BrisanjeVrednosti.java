package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Kontejner;

import java.io.IOException;
import java.util.List;

/**
 * Created by androiddevelopment on 20.1.17..
 */
public class Zadatak4BrisanjeVrednosti {

    static Dao<Kontejner, Integer> kontejnerDao ;



    public static void main(String[] args){
        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:brodKontejner.db");

            kontejnerDao= DaoManager.createDao(connectionSource, Kontejner.class);

   //--------------------------ispis pre brisanja---------------------------------
            List<Kontejner> kontejneri = kontejnerDao.queryForAll();

            for(Kontejner k: kontejneri){
                System.out.println(k);
            }


    //----------------------------brisanje kontejnera sa oznakom KP2----------------
            Kontejner brisanje = kontejnerDao.queryForEq(Kontejner.POLJE_OZNAKA, "KP2").get(0);

            kontejnerDao.delete(brisanje);


    //--------------------------------ispis posle brisanja---------------------------------------

            kontejneri=kontejnerDao.queryForAll();
            for(Kontejner k: kontejneri){
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
