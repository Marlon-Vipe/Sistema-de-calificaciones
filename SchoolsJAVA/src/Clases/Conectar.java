package Clases;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Marlon
 */
public class Conectar {
    
    Connection cn = null;
    Statement st;
    
    public Connection conexion(){
    
            try{
                Class.forName("com.mysql.jdbc.Driver");
                cn = DriverManager.getConnection("jdbc:mysql://localhost/escuela","root","");
                System.out.println("Conectado");
            
            } catch (Exception e) {
            
                System.err.println(e.getMessage());
                
            }
            
            return cn;
    }
    
}
