/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;


public class LoginClase {
    private String user;
    private String contra;
    private int cod_rol_fk;

    public LoginClase() {
    }

    public LoginClase(String user, String contra, int cod_rol_fk) {
        this.user = user;
        this.contra = contra;
        this.cod_rol_fk = cod_rol_fk;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public int getCod_rol_fk() {
        return cod_rol_fk;
    }

    public void setCod_rol_fk(int cod_rol_fk) {
        this.cod_rol_fk = cod_rol_fk;
    }
        
}
