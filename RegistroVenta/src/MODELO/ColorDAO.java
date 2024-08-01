/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author SAMUEL DAVID
 */
public class ColorDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List Listar(){
        List<ColorClase> Lista = new ArrayList();
       String sqlList = "SELECT * FROM tb_color";
        try {
            con = cn .getConnection();
            ps = con.prepareStatement(sqlList);
            rs =ps.executeQuery();
            while(rs.next()){
                ColorClase cl = new ColorClase();
                cl.setCod_color(rs.getInt("cod_color"));
                cl.setNom_color(rs.getString("nom_color"));
                Lista.add(cl);
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
    
    public boolean Registrar (ColorClase cc){
        String sql = "INSERT INTO tb_color(cod_color, nom_color) VALUES (?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,cc.getCod_color());
            ps.setString(2, cc.getNom_color());
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
        String sql = "DELETE FROM tb_color WHERE cod_color = ?";
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
    
    public boolean Modificar(ColorClase cc){
        String sql = "UPDATE tb_color SET nom_color = ? WHERE cod_color = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cc.getNom_color());
            ps.setInt(2, cc.getCod_color());
            
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
    
    public ColorClase Buscar(int cod){
        String sql = "SELECT * FROM tb_color WHERE cod_color = ?";
        ColorClase color = null;
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            
            if(rs.next()){
                color = new ColorClase(
                    rs.getInt("cod_color"),
                    rs.getString("nom_color")
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
        return color;
    }
    
    public String MostrarC (int cod){
        String sql = "SELECT nom_color FROM tb_color WHERE cod_color = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            if(rs.next()){
                String nomColor = rs.getString("nom_color");
                return nomColor;
            }
            
        } catch (Exception e) {
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
}
