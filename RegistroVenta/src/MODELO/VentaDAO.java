package MODELO;

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class VentaDAO {
    
// Clase para gestionar la conexión a la base de datos
Conexion cn = new Conexion();
Connection con; // Variable para almacenar la conexión a la base de datos
PreparedStatement ps; // Variable para ejecutar consultas SQL precompiladas
ResultSet rs; // Variable para almacenar el resultado de la consulta

/**
 * Método para buscar un mueble en la base de datos por su código.
 * @param cod El código del mueble a buscar.
 * @return Un objeto MueblesClase que contiene los datos del mueble encontrado, o null si no se encuentra.
 */
    public MueblesClase Buscar(int cod) {
        // Consulta SQL para buscar un mueble por su código
        String sql = "SELECT * FROM tb_mueble WHERE cod_mueble = ?";
        MueblesClase mueble = null; // Inicializa el objeto mueble como null

        try {
            // Obtiene la conexión a la base de datos
            con = cn.getConnection();

            // Prepara la consulta SQL con parámetros
            ps = con.prepareStatement(sql);

            // Establece el valor del primer parámetro (código del mueble)
            ps.setInt(1, cod);

            // Ejecuta la consulta y almacena el resultado en 'rs'
            rs = ps.executeQuery();

            // Si se encuentra un resultado, crea un nuevo objeto MueblesClase con los datos obtenidos
            if(rs.next()) {
                mueble = new MueblesClase(
                    rs.getInt("cod_mueble"),       // Código del mueble
                    rs.getString("nom_mueble"),    // Nombre del mueble
                    rs.getString("cod_categ_fk"),  // Código de la categoría (clave foránea)
                    rs.getString("mater_mueble"),  // Material del mueble
                    rs.getString("color_mueble"),  // Color del mueble
                    rs.getDouble("presi_mueble"),  // Precio del mueble
                    rs.getInt("stok_mueble")       // Stock del mueble
                );
            }

        } catch (SQLException e) {
            // Manejo de errores SQL: imprime el error en la consola
            System.out.println(e.toString());
        } finally {
            // Bloque finally para asegurar que los recursos se cierran correctamente
            try {
                if (rs != null) rs.close(); // Cierra el ResultSet
                if (ps != null) ps.close(); // Cierra el PreparedStatement
                if (con != null) con.close(); // Cierra la conexión
            } catch (SQLException e) {
                // Manejo de errores al cerrar los recursos
                System.out.println(e.toString());
            }
    }
    
    // Devuelve el objeto mueble encontrado, o null si no se encontró
    return mueble;
}
    
    public void ConsultarEmpleado(JComboBox<String> UsuariosClase) {
        String sql = "SELECT cod_user, nom_user FROM tb_usuario";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                UsuariosClase.addItem(rs.getString("cod_user") + " - " + rs.getString("nom_user"));
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
    
    public void ConsultarCliente(JComboBox<String> ClienteClase) {
        String sql = "SELECT dni_client, nom_client, apell_client FROM tb_clientes";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ClienteClase.addItem(rs.getString("dni_client") + " - " + rs.getString("nom_client") + " " + rs.getString("apell_client"));
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
    
    public int RegistrarPedido(VentaPClase vt) {
        String sql = "INSERT INTO tb_pedido(cod_user_fk, dni_client_fk, total_pedido) VALUES (?,?,?)";
        int cod_pedido = -1; // Inicializar con un valor por defecto

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, vt.getCod_user_fk());
            ps.setInt(2, vt.getCod_client_fk());
            ps.setDouble(3, vt.getTotal_pedido());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                cod_pedido = rs.getInt(1); // Obtener el valor de la clave generada
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.print(e.toString());
            }
        }

        return cod_pedido;
    }
    
    public boolean RegistrarDetalles(VentaPMClase vp){
        String sql = "INSERT INTO tb_mueble_pedido(cod_mueble_fk, cod_pedido_fk, cant_mueble, press_mueble) VALUES (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, vp.getCod_mueble_fk());
            ps.setInt(2, vp.getCod_pedido_fk());
            ps.setInt(3, vp.getCant_mueble());
            ps.setDouble(4, vp.getPress_mueble());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.print(e.toString());
            }
        }
    }
    
    public boolean actualizarStock(int codigoMueble, int nuevoStock) {
        String sql = "UPDATE tb_mueble SET stok_mueble = ? WHERE cod_mueble = ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, nuevoStock);
            ps.setInt(2, codigoMueble);
            ps.execute();
            return true;
          
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.print(e.toString());
            }
        }
    }
    
    public boolean registrarFactu(VentaFactu vf){
        String sql = "INSERT INTO tb_factura(cod_pedido_fk, total_factu, cambio_factu) VALUES (?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, vf.getCod_pedido_fk());
            ps.setDouble(2, vf.getTotal_factu());
            ps.setDouble(3, vf.getCambio_factu());
            ps.execute();
            return true;
          
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.print(e.toString());
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
