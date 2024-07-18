/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author Propietario
 */
public class CategoriaClase {
    private int cod_categ;
    private String nom_categ;
    private String zona_mueble;

    public CategoriaClase() {
    }
    
    public CategoriaClase(int cod_categ, String nom_categ, String zona_mueble) {
        this.cod_categ = cod_categ;
        this.nom_categ = nom_categ;
        this.zona_mueble = zona_mueble;
    }

    
    public int getCod_categ() {
        return cod_categ;
    }

    public void setCod_categ(int cod_categ) {
        this.cod_categ = cod_categ;
    }

    public String getNom_categ() {
        return nom_categ;
    }

    public void setNom_categ(String nom_categ) {
        this.nom_categ = nom_categ;
    }

    public String getZona_mueble() {
        return zona_mueble;
    }

    public void setZona_mueble(String zona_mueble) {
        this.zona_mueble = zona_mueble;
    }
    
    
}
