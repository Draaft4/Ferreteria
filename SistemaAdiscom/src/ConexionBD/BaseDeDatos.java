/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class BaseDeDatos {
    public static 
         Connection getConnection()
            {
                try
                    {
                        Class.forName("oracle.jdbc.OracleDriver");
               
                        String ferreteria="jdbc:oracle:thin:@localhost:1521:XE";
                        Connection cnx = DriverManager.getConnection(ferreteria,"Ferreteria","ferreteria");
                        return cnx;
                        
                    }
                catch(SQLException ex)
                        {
                            System.out.println(ex.getMessage());
                            System.out.println("no hubo coneccion");
                        }
                catch (ClassNotFoundException ex) {
                     Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                      System.out.println("tenemos error");
                     }

                    return null;
                
                
            }
}
