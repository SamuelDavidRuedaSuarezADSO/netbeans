/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author SAMUEL DAVID
 */
public class VentaPClase {
    private int cod_user_fk;
    private int cod_client_fk;
    private double total_pedido;

    public VentaPClase() {
    }

    public VentaPClase(int cod_user_fk, int cod_client_fk, double total_pedido) {
        this.cod_user_fk = cod_user_fk;
        this.cod_client_fk = cod_client_fk;
        this.total_pedido = total_pedido;
    }
    
    public int getCod_user_fk() {
        return cod_user_fk;
    }

    public void setCod_user_fk(int cod_user_fk) {
        this.cod_user_fk = cod_user_fk;
    }

    public int getCod_client_fk() {
        return cod_client_fk;
    }

    public void setCod_client_fk(int cod_client_fk) {
        this.cod_client_fk = cod_client_fk;
    }

    public double getTotal_pedido() {
        return total_pedido;
    }

    public void setTotal_pedido(double total_pedido) {
        this.total_pedido = total_pedido;
    }
    
    
    
}
