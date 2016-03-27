/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Kel
 */
public class cargaCombo extends conexion{
    
     public static Vector Elementos(String Sql) throws SQLException{
        Connection Conn = null;
        ResultSet rs = null;
        Statement consulta = null;
        int registros = 0;
    
        Vector elementos = new Vector();
        
        //Guardo la Consulta en una variable String en este caso la llamo "sql"
        String sql=(Sql);
        //System.out.println(sql);
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","");
            consulta = Conn.createStatement();
            rs = consulta.executeQuery(sql);
            
            while(rs.next()) {
                elementos.add(rs.getString("DATO1"));
            }
        }catch (ClassNotFoundException |SQLException e) {
            }
        
        return elementos;
    }
    
}
