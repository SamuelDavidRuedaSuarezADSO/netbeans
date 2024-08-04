package MODELO;

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CategoriaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarCategoria (CategoriaClase cg){
        String sql = "INSERT INTO tb_categoria(cod_categ, nom_categ, zona_mueble) VALUES (?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,cg.getCod_categ());
            ps.setString(2, cg.getNom_categ());
            ps.setString(3, cg.getZona_mueble());
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
    
    public List ListarCategoria(){
       List<CategoriaClase> ListaCt = new ArrayList();
       String sqlList = "SELECT * FROM tb_categoria";
        try {
            con = cn .getConnection();
            ps = con.prepareStatement(sqlList);
            rs =ps.executeQuery();
            while(rs.next()){
                CategoriaClase ct = new CategoriaClase();
                ct.setCod_categ(rs.getInt("cod_categ"));
                ct.setNom_categ(rs.getString("nom_categ"));
                ct.setZona_mueble(rs.getString("zona_mueble"));
                ListaCt.add(ct);
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
        
        return ListaCt;
    }  
    
    public boolean Eliminar(int cod){
        String sql = "DELETE FROM tb_categoria WHERE cod_categ = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
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
    
    public boolean Modificar(CategoriaClase cc){
        String sql = "UPDATE tb_categoria SET nom_categ = ?, zona_mueble = ? WHERE cod_categ = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cc.getNom_categ());
            ps.setString(2, cc.getZona_mueble());
            ps.setInt(3, cc.getCod_categ());
            
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
    
    public CategoriaClase Buscar(int cod){
        String sql = "SELECT * FROM tb_categoria WHERE cod_categ = ?";
        CategoriaClase categ = null;
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            
            if(rs.next()){
                categ = new CategoriaClase(
                    rs.getInt("cod_categ"),
                    rs.getString("nom_categ"),
                    rs.getString("zona_mueble")
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
        return categ;
    }


}
