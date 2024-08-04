package MODELO;

public class ClienteClase {
    private int dni_client;
    private String nom_client;
    private String apell_client;
    private String direcc_client;
    private String telef_client;

    public ClienteClase() {
    }

    public ClienteClase(int dni_client, String nom_client, String direcc_client, String telef_client, String apell_client) {
        this.dni_client = dni_client;
        this.nom_client = nom_client;
        this.apell_client = apell_client;
        this.direcc_client = direcc_client;
        this.telef_client = telef_client;
    }

    public String getApell_client() {
        return apell_client;
    }

    public void setApell_client(String apell_client) {
        this.apell_client = apell_client;
    }

    public int getDni_client() {
        return dni_client;
    }

    public void setDni_client(int dni_client) {
        this.dni_client = dni_client;
    }

    public String getNom_client() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public String getDirecc_client() {
        return direcc_client;
    }

    public void setDirecc_client(String direcc_client) {
        this.direcc_client = direcc_client;
    }

    public String getTelef_client() {
        return telef_client;
    }

    public void setTelef_client(String telef_client) {
        this.telef_client = telef_client;
    }   
    
}
