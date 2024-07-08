package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    Connection con;
       public Connection getConnection(){
           try {
               String myBD = "jdbc:mysql://localhost:3306/bd_proyectofinal";
               con = DriverManager.getConnection(myBD, "root", "");
               return con;
           } catch (SQLException e) {
                System.out.print(e.toString());
           }
           return con;
   }
   
   public void desconectar(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
}

