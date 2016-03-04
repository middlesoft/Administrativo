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
public class database {
    private String host="localhost";
    private String user="root";
    private String pass="";
    private int port=3306;
    private String servidor="";
    private static Connection conexion = null;
    
    //Constructor
    public database(String bd){
        this.servidor="jdbc:mysql://"+this.host+":"+this.port+"/"+bd;
        
        //Registrar el Driver de Conexion 
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.err.println("Error al registrar el Driver");
            System.exit(0);//
        }
        
        //Establece conexion con el servidor
        try{
            conexion = (Connection) DriverManager.getConnection(this.host, this.user, this.pass);
        }catch (SQLException e){
           System.err.println("Error al registrar el Driver");
           System.exit(0);//  
        }
    }
    
    public static Connection getConnection(){
        return conexion;
    }
    
}
