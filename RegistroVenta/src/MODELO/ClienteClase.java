
package MODELO;

import java.time.LocalDate;

public class ClienteClase {
    private int cod_client;
    private int dni_client;
    private String nom_client;
    private String direcc_client;
    private int telef_client;
    private LocalDate fechaCrea_client;

    public ClienteClase() {
    }

    public ClienteClase(int cod_client, int dni_client, String nom_client, String apell_client, String direcc_client, int telef_client) {
        this.cod_client = cod_client;
        this.dni_client = dni_client;
        this.nom_client = nom_client;
        this.direcc_client = direcc_client;
        this.telef_client = telef_client;
    }

    public LocalDate getFechaCrea_client() {
        return fechaCrea_client;
    }

    public void setFechaCrea_client(LocalDate fechaCrea_client) {
        this.fechaCrea_client = fechaCrea_client;
    }

    public int getCod_client() {
        return cod_client;
    }

    public void setCod_client(int cod_client) {
        this.cod_client = cod_client;
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

    public int getTelef_client() {
        return telef_client;
    }

    public void setTelef_client(int telef_client) {
        this.telef_client = telef_client;
    }
    
    
    
}
