package MODELO;

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

public class VentaDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public MueblesClase Buscar(int cod){
        String sql = "SELECT * FROM tb_mueble WHERE cod_mueble = ?";
        MueblesClase mueble = null;
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            
            if(rs.next()){
                mueble = new MueblesClase(
                    rs.getInt("cod_mueble"),
                    rs.getString("nom_mueble"),
                    rs.getString("cod_categ_fk"),
                    rs.getString("mater_mueble"),
                    rs.getString("color_mueble"),
                    rs.getDouble("presi_mueble"),
                    rs.getInt("stok_mueble")
                );
            }
            
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return mueble;
    }
    
    public void ConsultarEmpleado(JComboBox<String> UsuariosClase) {
        String sql = "SELECT cod_user, nom_user FROM tb_usuario";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                UsuariosClase.addItem(rs.getString("cod_user") + " - " + rs.getString("nom_user"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public void ConsultarCliente(JComboBox<String> ClienteClase) {
        String sql = "SELECT dni_client, nom_client, apell_client FROM tb_clientes";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ClienteClase.addItem(rs.getString("dni_client") + " - " + rs.getString("nom_client") + " " + rs.getString("apell_client"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
}
