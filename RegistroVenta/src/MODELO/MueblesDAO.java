package MODELO;

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class MueblesDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List<MueblesClase> Listar() {
        List<MueblesClase> Lista = new ArrayList<>();
        String sqlList = "SELECT * FROM tb_mueble";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlList);
            rs = ps.executeQuery();
            while (rs.next()) {
                MueblesClase mb = new MueblesClase();
                mb.setCod_mueble(rs.getInt("cod_mueble"));
                mb.setNom_mueble(rs.getString("nom_mueble"));
                mb.setCod_categ_fk(rs.getString("cod_categ_fk"));
                mb.setMater_mueble(rs.getString("mater_mueble"));
                mb.setColor_mueble(rs.getString("color_mueble"));
                mb.setPresi_mueble(rs.getInt("presi_mueble"));
                mb.setStok_mueble(rs.getInt("stok_mueble"));
                Lista.add(mb);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.print(e.toString());
            }
        }
        return Lista;
    }
    
    public boolean Registrar(MueblesClase mb){
        String sql = "INSERT INTO tb_mueble(cod_mueble, nom_mueble, cod_categ_fk, mater_mueble, color_mueble, presi_mueble, stok_mueble) VALUES (?,?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,mb.getCod_mueble());
            ps.setString(2, mb.getNom_mueble());
            ps.setString(3, mb.getCod_categ_fk());
            ps.setString(4, mb.getMater_mueble());
            ps.setString(5, mb.getColor_mueble());
            ps.setDouble(6,mb.getPresi_mueble());
            ps.setInt(7,mb.getStok_mueble());
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
    
    public boolean Eliminar(int cod){
        String sql = "DELETE FROM tb_mueble WHERE cod_mueble = ?";
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
    
    public boolean Modificar(MueblesClase mt) {
        String sql = "UPDATE tb_mueble SET nom_mueble = ?, cod_categ_fk = ?, mater_mueble = ?, color_mueble = ?, presi_mueble = ?, stok_mueble =? WHERE cod_mueble = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, mt.getNom_mueble());
            ps.setString(2, mt.getCod_categ_fk());
            ps.setString(3, mt.getMater_mueble());
            ps.setString(4, mt.getColor_mueble());
            ps.setDouble(5, mt.getPresi_mueble());
            ps.setInt(6, mt.getStok_mueble());
            ps.setInt(7, mt.getCod_mueble());
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
    
    public void ConsultarCategoria(JComboBox<String> MueblesClase) {
        String sql = "SELECT cod_categ, nom_categ FROM tb_categoria";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MueblesClase.addItem(rs.getString("cod_categ") + " - " + rs.getString("nom_categ"));
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
    
    public boolean ValidarExistencia(int cod){
        String sql = "SELECT cod_mueble FROM tb_mueble WHERE cod_mueble = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            ps.execute();
            if(ps.execute()){
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException e){
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
    
    public String nomCateg(int cod){
        String sql = "SELECT nom_categ FROM tb_categoria WHERE cod_categ = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            if(rs.next()){
                String categ = rs.getString("nom_categ");
                return categ;
            }
            else{
                return null;
            }
        } catch (SQLException e){
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
        return null;
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
}   
