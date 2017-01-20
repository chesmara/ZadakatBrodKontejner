package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by androiddevelopment on 20.1.17..
 */
@DatabaseTable(tableName = "kontejner")
public class Kontejner {

    private static final String POLJE_OZNAKA = "oznaka";
    private static final String POLJE_OPIS = "opis";
    private static final String POLJE_TEZINA = "tezina";

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = POLJE_OZNAKA , canBeNull = false)
    private String oznaka;
    @DatabaseField(columnName = POLJE_OPIS, canBeNull = false)
    private String opis;
    @DatabaseField(columnName = POLJE_TEZINA, canBeNull = false)
    private double tezina;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, canBeNull = false)
    private Brod brod;

    //----------------------------------konstruktori---------------------------------------
    public Kontejner(){}

    public Kontejner(String oznaka, String opis, String tezina){
        this.oznaka=oznaka;
        this.opis=opis;
        this.tezina=tezina;
    }

    //------------------------------get i set metode -----------------------------------------


    public int getId() {
        return id;
    }
       public void setId(int id) {
        this.id = id;
    }

    public String getOznaka() {
        return oznaka;
    }
       public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public String getOpis() {
        return opis;
    }
       public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getTezina() {
        return tezina;
    }
       public void setTezina(double tezina) {
        this.tezina = tezina;
    }

    public Brod getBrod() {
        return brod;
    }
       public void setBrod(Brod brod) {
        this.brod = brod;
    }


    //---------------------------------toString redef.------------------------------------------------------+


    @Override
    public String toString() {
        return "Kontejner{" +
                "id=" + id +
                ", oznaka='" + oznaka + '\'' +
                ", opis='" + opis + '\'' +
                ", tezina=" + tezina +
                '}';
    }
}
