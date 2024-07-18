
package MODELO;

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MueblesDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List Listar(){
        List<MueblesClase> Lista = new ArrayList();
       String sqlList = "SELECT * FROM tb_mueble";
        try {
            con = cn .getConnection();
            ps = con.prepareStatement(sqlList);
            rs =ps.executeQuery();
            while(rs.next()){
                MueblesClase mb = new MueblesClase();
                mb.setCod_mueble(rs.getInt("cod_mueble"));
                mb.setNom_mueble(rs.getString("nom_mueble"));
                mb.setCod_categ_fk(rs.getInt("cod_categ_fk"));
                mb.setPresi_mueble(rs.getInt("presi_mueble"));
                mb.setStok_mueble(rs.getInt("stok_mueble"));
                Lista.add(mb);
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
        
        return Lista;
    }
}
