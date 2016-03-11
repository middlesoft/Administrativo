/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.CallableStatement;

/**
 *
 * @author Kel
 * Probando los store procedure
 */
public class CallProcedure {
    
    Connection conn = null;
    
    public CallProcedure(){
        
    }
    
    public void invocarUsuarios() throws Exception{
        try{
            //Creamos la conexion
            conn = conexion.conectar("localhost", "root", "", "demo");
            conn.setAutoCommit(false);
            CallableStatement storeprocedure = conn.prepareCall("{call getUsuarios(p_usuario, p_passwd}");
            storeprocedure.setString("p_usuario", "");
            storeprocedure.setString(" "," ");
            storeprocedure.executeQuery();
            conn.commit();
        }catch(Exception e){
            conn.rollback();
            e.printStackTrace();
        }
        finally {
            //Cerramos la conexion
            conn.close();
        }
    }
    
    
}
