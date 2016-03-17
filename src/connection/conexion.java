/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;



import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import javax.swing.JOptionPane;
import view.main.fr_inicio;
import view.main.fr_ppal;

/**
 *
 * @author Kel
 */
public class conexion { 
    public Connection conn;
    protected PreparedStatement consulta;
    protected ResultSet resultado;
    protected int registros;
    private String  maquina     = "localhost";
    private String  usuario     = "root";
    private String  clave       = "";
    private int puerto          = 3306;
    private String  servidor    = "";
    private static Connection conexion  = null;
    
    public void conectar(String sql) {
         Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo","root","");
        }
        catch (ClassNotFoundException |SQLException e) {
            JOptionPane.showMessageDialog(null, "No hay Conexion con el Servidor de Base de datos");
        }
        
       }
    
    public Connection conectado(){
      return conn;
}
    
    public void desconectar() throws SQLException {
        this.conn.close();
    }
    
     public int Count_Reg (String Sql) {
        try {
            this.conectar(Sql);
            this.consulta = this.conn.prepareStatement(Sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultado = this.consulta.executeQuery();
            System.out.println(Sql);

            while(resultado.next()) {
                if (resultado.getInt("REGISTROS") > 0){
                    registros = resultado.getInt("REGISTROS");
                }
                else{
                    registros = 0;
                }
            }
        } catch (Exception e) {
        }
        
        return registros;
    }
     
       public ResultSet consultar(String sql) throws ClassNotFoundException{
        java.sql.Connection Conn = null;
        java.sql.Statement consulta = null;   
        String Sql=(sql);
        System.out.println(Sql);
        
        try{
            this.conectar(sql);
            this.consulta = this.conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            resultado = this.consulta.executeQuery();
            resultado.last();
        }catch (SQLException e) {
            }

        return resultado;
    }
   
      
   public String procedure(String usuario, int password){
       String resultado=null;
       try {            
            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            CallableStatement proc = (CallableStatement) conn.prepareCall(" CALL usuario(?,?) ");
            //se cargan los parametros de entrada
            proc.setString("usuario", usuario);//Tipo String
            proc.setInt("password", password);//Tipo entero
            // parametros de salida
            proc.registerOutParameter("resultado", Types.VARCHAR);//Tipo String
            // Se ejecuta el procedimiento almacenado
            proc.execute();            
            // devuelve el valor del parametro de salida del procedimiento
            resultado = proc.getString("resultado");
        } 
       catch (Exception e) {                  
            System.out.println(e);
       }
       return resultado;
   }   
   
   public void access (String txt_user, String txt_pass) {    
        //***** Se declaran las variables de conexion en null
        Connection Conn = null;
        ResultSet rs = null;
        Statement consulta = null;   
    
        //Guardo la Consulta en una variable String en este caso la llamo "sql"
    
        String sql=("SELECT usuario, password FROM usuarios WHERE usuario='"+txt_user+"' AND password='"+txt_pass+"'");
        System.out.println(sql);
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo","root","");
            consulta=(Statement) Conn.createStatement();
            rs = consulta.executeQuery(sql);
     
            if(rs.next()){      
                
                 JOptionPane.showMessageDialog(null, "Usted ha iniciado sesión");
                 fr_ppal principal = new fr_ppal();
                 principal.setExtendedState(fr_ppal.MAXIMIZED_BOTH);
                 principal.show(); 
                
                          
             }
            
            else { 
                
                 JOptionPane.showMessageDialog(null, "Ingrese su nombre de usuario y contraseña");
                 
             }
                          
            while(rs.next()) { 
                System.out.println(rs.getString(1));
            }            
        }catch (ClassNotFoundException |SQLException e) {
            JOptionPane.showMessageDialog(null, "No hay Conexion con el Servidor de Base de datos");
            }
        }   
}
