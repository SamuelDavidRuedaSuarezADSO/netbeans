
package MODELO;

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import MODELO.ClienteClase;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClienteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    
    public boolean RegistrarCliente(ClienteClase cl){
        String sql = "INSERT INT tb_clientes(cod_client, dni_client, nom_client, direcc_client, telef_client, fechCrea_client) VALUES (?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,cl.getDni_client());
            ps.setString(2, cl.getNom_client());
            ps.setString(3, cl.getDirecc_client());
            ps.setInt(4,cl.getTelef_client());
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
}
