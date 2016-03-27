/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Kel
 */
public class correlativo extends conexion{
    public String numconsecutivo(String Sql){
       
        Connection Conn = null;
        ResultSet rs = null;
        Statement consulta = null;
        String registros = null;
    
        String sql=(Sql);
        //System.out.println(Sql);
        try{
            this.conectar(sql);
            this.consulta = this.conn.prepareStatement(sql);
            rs = this.consulta.executeQuery();
  
            while(rs.next()) {
                registros = rs.getString("CODIGO");
                
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No hay Conexion con el Servidor de Base de datos");
            }

        return registros;
    }
    
}
