
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
                con.close();
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
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                System.out.print(e.toString());
            }
        }
        
        return ListaCl;
    }  
}
