package MODELO;

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarCliente(ClienteClase cl){
        String sql = "INSERT INTO tb_clientes(dni_client, nom_client, apell_client, direcc_client, telef_client) VALUES (?, ?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,cl.getDni_client());
            ps.setString(2, cl.getNom_client());
            ps.setString(3, cl.getApell_client());
            ps.setString(4, cl.getDirecc_client());
            ps.setString(5,cl.getTelef_client());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
        finally{
            try {
                if(con != null) con.close();
            } catch (SQLException e) {
                System.out.print(e.toString());
            }
        }
    }
    
    public List ListarCliente(){
       List<ClienteClase> ListaCl = new ArrayList();
       String sqlList = "SELECT * FROM tb_clientes";
        try {
            con = cn .getConnection();
            ps = con.prepareStatement(sqlList);
            rs =ps.executeQuery();
            while(rs.next()){
                ClienteClase cl = new ClienteClase();
                cl.setDni_client(rs.getInt("dni_client"));
                cl.setNom_client(rs.getString("nom_client"));
                cl.setApell_client(rs.getString("apell_client"));
                cl.setTelef_client(rs.getString("telef_client"));
                cl.setDirecc_client(rs.getString("direcc_client"));
                ListaCl.add(cl);
            }
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally {
            try {
                if(ps !=null) ps.close();
                if(con != null) con.close();
                if(rs !=null) rs.close();
            } catch (SQLException e) {
                System.out.print(e.toString());
            }
        }
        
        return ListaCl;
    }  
    
    public boolean EliminarCliente(int dni){
        String sql = "DELETE FROM tb_clientes WHERE dni_client = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                if(ps !=null) ps.close();
                if(con != null) con.close();
                
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
            
        }
        
    }
    public boolean ModificarCliente(ClienteClase cl) {
        String sql = "UPDATE tb_clientes SET nom_client = ?, apell_client = ?, direcc_client = ?, telef_client = ? WHERE dni_client = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getNom_client());
            ps.setString(2, cl.getApell_client());
            ps.setString(3, cl.getDirecc_client());
            ps.setString(4, cl.getTelef_client());
            ps.setInt(5, cl.getDni_client());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    public ClienteClase Buscar(int cod){
        String sql = "SELECT * FROM tb_clientes WHERE dni_client = ?";
        ClienteClase cliente = null;
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            
            if(rs.next()){
                cliente = new ClienteClase(
                    rs.getInt("dni_client"),
                    rs.getString("nom_client"),
                    rs.getString("apell_client"),
                    rs.getString("direcc_client"),
                    rs.getString("telef_client")
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
        return cliente;
    }

    public boolean Exist(int cod) {
        String sql = "SELECT * FROM tb_clientes WHERE dni_client = ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            return rs.next(); // Retorna true si hay al menos una fila
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
        return false;
    }
    
    public boolean esNumero (String p){
        try{
            Integer.parseInt(p);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
            
    public int codFact(int cod) {
        String sql = "SELECT cod_factu FROM tb_factura WHERE cod_pedido_fk = ?";
        int codigoFactura = 0;

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();

            if (rs.next()) {
                codigoFactura = rs.getInt("cod_factu");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el código de la factura: " + e.toString());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar los recursos: " + e.toString());
            }
        }
        return codigoFactura;
    }
    
}
