package MODELO;

public class PedidosClase {
    private int cod_pedido;
    private int cod_user_fk;
    private int dni_client_fk;
    private double total_pedido;

    public PedidosClase() {
    }

    public PedidosClase(int cod_pedido, int cod_user_fk, int dni_client_fk, double total_pedido) {
        this.cod_pedido = cod_pedido;
        this.cod_user_fk = cod_user_fk;
        this.dni_client_fk = dni_client_fk;
        this.total_pedido = total_pedido;
    }

    public int getCod_pedido() {
        return cod_pedido;
    }

    public void setCod_pedido(int cod_pedido) {
        this.cod_pedido = cod_pedido;
    }

    public int getCod_user_fk() {
        return cod_user_fk;
    }

    public void setCod_user_fk(int cod_user_fk) {
        this.cod_user_fk = cod_user_fk;
    }

    public int getDni_client_fk() {
        return dni_client_fk;
    }

    public void setDni_client_fk(int dni_client_fk) {
        this.dni_client_fk = dni_client_fk;
    }

    public double getTotal_pedido() {
        return total_pedido;
    }

    public void setTotal_pedido(double total_pedido) {
        this.total_pedido = total_pedido;
    }
    
    
}
