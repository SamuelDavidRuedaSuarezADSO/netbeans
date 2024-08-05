package MODELO;

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidosDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List<PedidosClase> Listar() {
        List<PedidosClase> Lista = new ArrayList<>();
        String sqlList = "SELECT * FROM tb_pedido";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlList);
            rs = ps.executeQuery();
            while (rs.next()) {
                PedidosClase pd = new PedidosClase();
                pd.setCod_pedido(rs.getInt("cod_pedido"));
                pd.setCod_user_fk(rs.getInt("cod_user_fk"));
                pd.setDni_client_fk(rs.getInt("dni_client_fk"));
                pd.setTotal_pedido(rs.getDouble("total_pedido"));
                Lista.add(pd);
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
    
    public String BuscarEmple(int cod){
        String sql = "SELECT nom_user FROM tb_usuario WHERE cod_user = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            if(rs.next()){
                String user = rs.getString("nom_user");
                return user;
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
    public String BuscarClient(int cod){
        String sql = "SELECT nom_client, apell_client FROM tb_clientes WHERE dni_client = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            if(rs.next()){
                String nom = rs.getString("nom_client");
                String apell = rs.getString("apell_client");
                String client = nom + " " +apell;
                return client;
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
    
    public List<PedidosClase> ListarBusca(int cod) {
        List<PedidosClase> Lista = new ArrayList<>();
        String sqlList = "SELECT * FROM tb_pedido WHERE dni_client_fk = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlList);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            while (rs.next()) {
                PedidosClase pd = new PedidosClase();
                pd.setCod_pedido(rs.getInt("cod_pedido"));
                pd.setCod_user_fk(rs.getInt("cod_user_fk"));
                pd.setDni_client_fk(rs.getInt("dni_client_fk"));
                pd.setTotal_pedido(rs.getDouble("total_pedido"));
                Lista.add(pd);
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
}
