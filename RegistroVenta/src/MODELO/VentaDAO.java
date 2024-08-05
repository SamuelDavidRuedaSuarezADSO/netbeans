package MODELO;

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

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
    
    public int RegistrarPedido(VentaPClase vt) {
        String sql = "INSERT INTO tb_pedido(cod_user_fk, dni_client_fk, total_pedido) VALUES (?,?,?)";
        int cod_pedido = -1; // Inicializar con un valor por defecto

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, vt.getCod_user_fk());
            ps.setInt(2, vt.getCod_client_fk());
            ps.setDouble(3, vt.getTotal_pedido());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                cod_pedido = rs.getInt(1); // Obtener el valor de la clave generada
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.print(e.toString());
            }
        }

        return cod_pedido;
    }
    
    public boolean RegistrarDetalles(VentaPMClase vp){
        String sql = "INSERT INTO tb_mueble_pedido(cod_mueble_fk, cod_pedido_fk, cant_mueble, press_mueble) VALUES (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, vp.getCod_mueble_fk());
            ps.setInt(2, vp.getCod_pedido_fk());
            ps.setInt(3, vp.getCant_mueble());
            ps.setDouble(4, vp.getPress_mueble());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.print(e.toString());
            }
        }
    }
    
    public boolean actualizarStock(int codigoMueble, int nuevoStock) {
        String sql = "UPDATE tb_mueble SET stok_mueble = ? WHERE cod_mueble = ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, nuevoStock);
            ps.setInt(2, codigoMueble);
            ps.execute();
            return true;
          
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.print(e.toString());
            }
        }
    }
    
    public boolean registrarFactu(VentaFactu vf){
        String sql = "INSERT INTO tb_factura(cod_pedido_fk, total_factu, cambio_factu) VALUES (?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, vf.getCod_pedido_fk());
            ps.setDouble(2, vf.getTotal_factu());
            ps.setDouble(3, vf.getCambio_factu());
            ps.execute();
            return true;
          
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.print(e.toString());
            }
        }
    }

}
