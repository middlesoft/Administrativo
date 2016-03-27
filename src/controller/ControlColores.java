/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import com.mysql.jdbc.Connection;
import connection.conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import view.inventario.fr_colores;

/**
 *
 * @author Kel
 */
public class ControlColores implements ActionListener {
    Connection cn = null;
    int filaPulsada;
    
    ControlColores (fr_colores col){
        
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        //Objeto para ejecutar los procedimientos almacenados
        //   en la base de datos
        CallableStatement cs;
        //COMANDO EJECTUADO
        String comando  = arg0.getActionCommand();
        //Deberá coincidir con alguno de los parámetros
        //  indicados en setActionCommand invocado en la
        //  clase View
        switch (comando) {
            case "guardar":
                try{                    
                    //Preparar la llamada
                    cs  = conexion.getConexion().prepareCall("{CALL insertColores(?,?)}");
                    //Indicar qué información se pasa al
                    //  procedimiento
                    cs.setString(1, fr_colores.txt_codigo.getText());
                    cs.setString(2, fr_colores.txt_descripcion.getText());
                    //Ejecutar el procedimiento
                    cs.execute();
                }catch (SQLException e) {
                    System.err.println("Error al insertar el registro");
                }
 
            break;
 
            case "eliminar":
                //Recoger qué fila se ha pulsado
               //Recoger qué fila se ha pulsadao en la tabla
                filaPulsada = fr_colores.Tabla.getSelectedRow();
                //Si se ha pulsado una fila
                if(filaPulsada>=0){
                    //Se recoge el id de la fila marcada
                    int identificador   = (int)fr_colores.dtm.getValueAt(filaPulsada, 0);
                    try{
                        //Preparar la llamada
                        cs  = conexion.getConexion().prepareCall(
                            "{CALL borrarCliente(?)}");
                        //Indicar qué información se pasa al procedimiento
                        cs.setInt(1, identificador);
                        //Ejecutar el procedimiento
                        cs.execute();
                        //System.out.println(this.view.dtm.getValueAt(filaPulsada, 0));
                    }catch (SQLException e) {
                        System.err.println("Error al borrar el registro");
                    }
                }
 
            break;
 
            case "modificar":
                //Recoger qué fila se ha pulsadao en la tabla
                filaPulsada = fr_colores.Tabla.getSelectedRow();
                //Si se ha pulsado una fila
                if(filaPulsada>=0){
                    //Se recoge el id de la fila marcada
                    int identificador   = (int)fr_colores.dtm.getValueAt(filaPulsada, 0);
                    try{
                        //Preparar la llamada
                        cs  = conexion.getConexion().prepareCall(
                            "{CALL modificarCliente(?,?)}");
                        //Indicar qué información se pasa al procedimiento
                        cs.setInt(1, identificador);
                        cs.setString(1, fr_colores.txt_codigo.getText());
                        cs.setString(2, fr_colores.txt_descripcion.getText());
                        //Ejecutar el procedimiento
                        cs.execute();
                        //System.out.println(this.view.dtm.getValueAt(filaPulsada, 0));
                    }catch (SQLException e) {
                        System.err.println("Error en la MODIFICACION");
                    }
                }
            break;
 
            default:
                System.err.println("Comando no definido");
            break;
        }
        
    }
    
    //Método que recarga los datos de la tabla de la base de datos
    // en la tabla de la clase View
    protected void cargarTabla(){
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        CallableStatement cs;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;
        //Objeto para recorrer el resultado del procedimiento almacenado y
        //  añadirlo a la tabla definida en la clase View
        Vector<Object> fila;
 
        //Limpiar los datos de la tabla
        for(int i=fr_colores.dtm.getRowCount(); i>0; i--){
            fr_colores.dtm.removeRow(i-1);
        }
 
        //Cargar datos en la tabla
        try {
            //Preparar la llamada
            cs  = conexion.getConexion().prepareCall(
                            "{CALL getClientes()}");
            //Ejecutarla y recoger el resultado
            rs  = cs.executeQuery();
            //Recorrer el resultado
            while(rs.next()){
                //Añadir registro a registro en el vector
                fila    = new Vector<Object>();
                fila.add(rs.getInt("id"));
                fila.add(rs.getString("nombre"));
                fila.add(rs.getString("nif"));
                //Añadir el vector a la tabla de la clase View
                fr_colores.dtm.addRow(fila);
            }
 
        } catch (SQLException e) {
            System.err.println("Error al CARGAR DATOS");
        }
    }
    
    public void limpiar(){
        fr_colores.txt_codigo.setText("");
        fr_colores.txt_descripcion.setText("");
    }
    
}
