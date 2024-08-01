package MODELO;


public class MueblesClase {
    private int cod_mueble;
    private String nom_mueble;
    private String cod_categ_fk;
    private String mater_mueble;
    private double presi_mueble;
    private int stok_mueble;

    public MueblesClase() {
    }

    public MueblesClase(int cod_mueble, String nom_mueble, String cod_categ_fk, String mater_mueble, double presi_mueble, int stok_mueble) {
        this.cod_mueble = cod_mueble;
        this.nom_mueble = nom_mueble;
        this.cod_categ_fk = cod_categ_fk;
        this.mater_mueble = mater_mueble;
        this.presi_mueble = presi_mueble;
        this.stok_mueble = stok_mueble;
    }

    public int getCod_mueble() {
        return cod_mueble;
    }

    public void setCod_mueble(int cod_mueble) {
        this.cod_mueble = cod_mueble;
    }

    public String getNom_mueble() {
        return nom_mueble;
    }

    public void setNom_mueble(String nom_mueble) {
        this.nom_mueble = nom_mueble;
    }

    public String getCod_categ_fk() {
        return cod_categ_fk;
    }

    public void setCod_categ_fk(String cod_categ_fk) {
        this.cod_categ_fk = cod_categ_fk;
    }

    public String getMater_mueble() {
        return mater_mueble;
    }

    public void setMater_mueble(String mater_mueble) {
        this.mater_mueble = mater_mueble;
    }

    public double getPresi_mueble() {
        return presi_mueble;
    }

    public void setPresi_mueble(double presi_mueble) {
        this.presi_mueble = presi_mueble;
    }

    public int getStok_mueble() {
        return stok_mueble;
    }

    public void setStok_mueble(int stok_mueble) {
        this.stok_mueble = stok_mueble;
    }
    
    
}
