/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author SAMUEL DAVID
 */
public class ColorClase {
    private int cod_color;
    private String nom_color;

    public ColorClase() {
    }

    public ColorClase(int cod_color, String nom_color) {
        this.cod_color = cod_color;
        this.nom_color = nom_color;
    }

    public int getCod_color() {
        return cod_color;
    }

    public void setCod_color(int cod_color) {
        this.cod_color = cod_color;
    }

    public String getNom_color() {
        return nom_color;
    }

    public void setNom_color(String nom_color) {
        this.nom_color = nom_color;
    }
    
    
}
