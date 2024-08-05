package MODELO;

public class VentaFactu {
    private int cod_pedido_fk;
    private double total_factu;
    private double cambio_factu;

    public VentaFactu() {
    }

    public VentaFactu(int cod_pedido_fk, double total_factu, double cambio_factu) {
        this.cod_pedido_fk = cod_pedido_fk;
        this.total_factu = total_factu;
        this.cambio_factu = cambio_factu;
    }

    public int getCod_pedido_fk() {
        return cod_pedido_fk;
    }

    public void setCod_pedido_fk(int cod_pedido_fk) {
        this.cod_pedido_fk = cod_pedido_fk;
    }

    public double getTotal_factu() {
        return total_factu;
    }

    public void setTotal_factu(double total_factu) {
        this.total_factu = total_factu;
    }

    public double getCambio_factu() {
        return cambio_factu;
    }

    public void setCambio_factu(double cambio_factu) {
        this.cambio_factu = cambio_factu;
    }
    
    
}
