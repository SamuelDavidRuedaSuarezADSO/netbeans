/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import Controlador.Conexion;
import MODELO.LoginClase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginVali {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cx = new Conexion();
   
    public  LoginClase log(String nom_user, String contra_user){
        LoginClase l = new LoginClase();
        String sql = "SELECT * FROM tb_usuario WHERE nom_user = ? AND contra_user = ?";
        try {
            con = cx.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nom_user);
            ps.setString(2, contra_user);
            ps.executeQuery();
            rs= ps.executeQuery();
            if (rs.next()) {
                l.setUser(rs.getString("nom_user"));
                l.setContra(rs.getString("contra_user"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return l;
    }    
}
