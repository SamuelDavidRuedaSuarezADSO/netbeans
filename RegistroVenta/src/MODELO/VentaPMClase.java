package MODELO;

public class VentaPMClase {
    private int cod_mueble_fk;
    private int cod_pedido_fk;
    private int cant_mueble;
    private double press_mueble;

    public VentaPMClase() {
    }

    public VentaPMClase(int cod_mueble_fk, int cod_pedido_fk, int cant_mueble, double press_mueble) {
        this.cod_mueble_fk = cod_mueble_fk;
        this.cod_pedido_fk = cod_pedido_fk;
        this.cant_mueble = cant_mueble;
        this.press_mueble = press_mueble;
    }

    public int getCod_mueble_fk() {
        return cod_mueble_fk;
    }

    public void setCod_mueble_fk(int cod_mueble_fk) {
        this.cod_mueble_fk = cod_mueble_fk;
    }

    public int getCod_pedido_fk() {
        return cod_pedido_fk;
    }

    public void setCod_pedido_fk(int cod_pedido_fk) {
        this.cod_pedido_fk = cod_pedido_fk;
    }

    public int getCant_mueble() {
        return cant_mueble;
    }

    public void setCant_mueble(int cant_mueble) {
        this.cant_mueble = cant_mueble;
    }

    public double getPress_mueble() {
        return press_mueble;
    }

    public void setPress_mueble(double press_mueble) {
        this.press_mueble = press_mueble;
    }
    
    
}
