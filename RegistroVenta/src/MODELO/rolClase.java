package MODELO;

public class rolClase {
    private int cod_rol;
    private String nom_rol;

    public rolClase(int cod_rol, String nom_rol) {
        this.cod_rol = cod_rol;
        this.nom_rol = nom_rol;
    }

    public int getCodRol() {
        return cod_rol;
    }

    public String getNomRol() {
        return nom_rol;
    }
}
