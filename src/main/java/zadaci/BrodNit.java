package zadaci;

import com.j256.ormlite.dao.Dao;
import model.Brod;
import model.Kontejner;

import java.util.Random;

/**
 * Created by androiddevelopment on 20.1.17..
 */
public class BrodNit  extends  Thread {

    private Brod brod;
    private String imeBroda;


    static Dao<Kontejner, Integer> kontejnerDao;

    public BrodNit()

    public void run(String imeBroda){

        System.out.println("Brod "+  imeBroda + " je napustio luku") ;



        Random random = new Random();

        try {
            // Clan uzima knjigu na neki period od 0 do 5 sekundi
            // Zbog duzine moze delovati da je program stao, u tom slucaju smanjiti cekanje
            sleep(random.nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        System.out.println("Brod "+ imeBroda + " je stigao na odrediste");





    }


}
