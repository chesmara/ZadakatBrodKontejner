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
public class Zadatak3IzmenaVrednosti {


    static Dao<Kontejner, Integer> kontejnerDao ;


    public static void main(String[] args){
        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:brodKontejner.db");


            kontejnerDao= DaoManager.createDao(connectionSource, Kontejner.class);

            List<Kontejner> kontejneri = kontejnerDao.queryForAll();

            for(Kontejner k: kontejneri){
                System.out.println(k);
            }

   //----------------------izmena kontejnera------------------------------------

            Kontejner izmeni= kontejnerDao.queryForEq(Kontejner.POLJE_OPIS, "Morski proizvodi").get(0);

                izmeni.setOpis("Plodovi mora");
                kontejnerDao.update(izmeni);

            List<Kontejner> kontejneriNew= kontejnerDao.queryForAll();
            for(Kontejner kk: kontejneriNew){
                System.out.println(kk);
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
