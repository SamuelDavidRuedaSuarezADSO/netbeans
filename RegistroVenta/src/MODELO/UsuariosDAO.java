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

public class UsuariosDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List<UsuariosClase> Listar() {
        List<UsuariosClase> Lista = new ArrayList<>();
        String sqlList = "SELECT * FROM tb_usuario";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlList);
            rs = ps.executeQuery();
            while (rs.next()) {
                UsuariosClase us = new UsuariosClase();
                us.setCod_user(rs.getInt("cod_user"));
                us.setNom_user(rs.getString("nom_user"));
                us.setEmail_user(rs.getString("email_user"));
                us.setContra_user(rs.getString("contra_user"));
                us.setCod_rol_fk(rs.getInt("cod_rol_fk"));
                Lista.add(us);
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
    
    public String nomRol(int cod){
        String sql = "SELECT nom_rol FROM tb_rol WHERE cod_rol = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            if(rs.next()){
                String nom = rs.getString("nom_rol");
                return nom;
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
    
    public void ConsultarRol(JComboBox<String> UsuariosClase) {
        String sql = "SELECT cod_rol, nom_rol FROM tb_rol";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                UsuariosClase.addItem(rs.getString("cod_rol") + " - " + rs.getString("nom_rol"));
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
    
    public UsuariosClase Buscar(int cod){
        String sql = "SELECT * FROM tb_usuario WHERE cod_user = ?";
        UsuariosClase users = null;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            
            if(rs.next()){
                users = new UsuariosClase(
                    rs.getInt("cod_user"),
                    rs.getString("nom_user"),
                    rs.getString("email_user"),
                    rs.getString("contra_user"),
                    rs.getInt("cod_rol_fk")
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
        return users;
    }
    
    public boolean exist(int cod) {
        String sql = "SELECT * FROM tb_usuario WHERE cod_user = ?";

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

    public boolean Registrar(UsuariosClase us){
        String sql = "INSERT INTO tb_usuario(cod_user, nom_user, email_user, contra_user, cod_rol_fk) VALUES (?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,us.getCod_user());
            ps.setString(2, us.getNom_user());
            ps.setString(3, us.getEmail_user());
            ps.setString(4, us.getContra_user());
            ps.setInt(5,us.getCod_rol_fk());
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
        String sql = "DELETE FROM tb_usuario WHERE cod_user = ?";
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
    
    public boolean Modificar(UsuariosClase us) {
        String sql = "UPDATE tb_usuario SET nom_user = ?, email_user = ?, contra_user = ?, cod_rol_fk = ? WHERE cod_user = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getNom_user());
            ps.setString(2, us.getEmail_user());
            ps.setString(3, us.getContra_user());
            ps.setInt(4, us.getCod_rol_fk());
            ps.setInt(5, us.getCod_user());
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
