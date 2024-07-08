/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;


public class LoginClase {
    private String user;
    private String contra;
    
   
    public LoginClase() {
        
    }
    
    public LoginClase(String user, String contra) {
        this.user = user;
        this.contra = contra;
    }

    public String getUser() {
        return user;
    }

    public String getContra() {
        return contra;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    

    
}
