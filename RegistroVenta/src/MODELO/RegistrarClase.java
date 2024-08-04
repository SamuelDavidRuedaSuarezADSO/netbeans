package MODELO;

public class RegistrarClase {
    private String nom_user;
    private String email_user;
    private String contra_user;
    private int cod_rol_fk;

    public RegistrarClase() {
    }

    public RegistrarClase(String nom_user, String email_user, String contra_user, int cod_rol_fk) {
        this.nom_user = nom_user;
        this.email_user = email_user;
        this.contra_user = contra_user;
        this.cod_rol_fk = cod_rol_fk;
    }

    public String getNom_user() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public String getContra_user() {
        return contra_user;
    }

    public void setContra_user(String contra_user) {
        this.contra_user = contra_user;
    }

    public int getCod_rol_fk() {
        return cod_rol_fk;
    }

    public void setCod_rol_fk(int cod_rol_fk) {
        this.cod_rol_fk = cod_rol_fk;
    }
    
    
}
