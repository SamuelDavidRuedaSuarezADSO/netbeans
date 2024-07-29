/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author SAMUEL DAVID
 */
public class MueblesColor {
    private int cod_mueble_fk;
    private int cod_color_fk;

    public MueblesColor() {
    }

    public MueblesColor(int cod_mueble_fk, int cod_color_fk) {
        this.cod_mueble_fk = cod_mueble_fk;
        this.cod_color_fk = cod_color_fk;
    }

    public int getCod_mueble_fk() {
        return cod_mueble_fk;
    }

    public void setCod_mueble_fk(int cod_mueble_fk) {
        this.cod_mueble_fk = cod_mueble_fk;
    }

    public int getCod_color_fk() {
        return cod_color_fk;
    }

    public void setCod_color_fk(int cod_color_fk) {
        this.cod_color_fk = cod_color_fk;
    }
    
    @Override
    public String toString() {
        return "MueblesColor{" +
               "cod_mueble_fk=" + cod_mueble_fk +
               ", cod_color_fk=" + cod_color_fk +
               '}';
    }
}

