/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Kel
 */
public class conexion {
    
    public static Connection con_mysql;
    Connection conn = null;
    
    public static Connection conectar(String host, String user, String pass, String database) throws Exception{
        try{
            String databaseUrl = "jdbc:mysql://"+ host + "/" + database;
            Class.forName("com.mysql.jdbc.Driver");
            con_mysql = (Connection) java.sql.DriverManager.getConnection(databaseUrl, user, pass);
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception(e);
        }
        return con_mysql;
    }
    
   
}
