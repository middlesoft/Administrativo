/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.inventario;

 
import connection.conexion;
import connection.correlativo;
import controller.ControlColores;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.HeadlessException;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import static view.main.fr_ppal.MenuPrincipal;
import view.main.fr_ppal;
import static view.main.fr_ppal.escritorio;
   
/**
 *
 * @author Kel
 */
public class fr_colores extends javax.swing.JInternalFrame {
    public static DefaultTableModel dtm;
    public boolean agrego = false, modifico = false, eliminar=false, cancelar=false,  buscar=false;
    private int i;
    public String [] columnas;
    public String [] filas;
    CallableStatement cs = null;
    Connection conn =  null;
    ResultSet rs = null;
         
    /**
     * Creates new form fr_colores
     */
    public fr_colores() throws SQLException {
        initComponents();
        iniciar();
        centrar();
    }
    
    public void centrar(){
        Dimension desktopSize = escritorio.getSize();
        Dimension jInternalFrameSize = this.getSize();
        this.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
    }
    
    public void iniciar() throws SQLException{
         this.setTitle("Colores");
         deshabilitar(); 
         setearText();
         llenarTabla();
         agrego=false; modifico=false; eliminar=false; cancelar=false; buscar=false;
         habilitarBuscar();
    }
    
    public void habilitarBuscar(){
        if(buscar==false){
            pBuscar.setVisible(false);
            lbl_buscar.setVisible(false);
            txt_buscar.setVisible(false);
            txt_buscar.setText("");
        }else{
            pBuscar.setVisible(true);
            lbl_buscar.setVisible(true);
            txt_buscar.setVisible(true);
            Tabla.setEnabled(true);
        }
    }
    
    public void setearText() throws SQLException{
        CallableStatement cs = null;
        Connection conn =  null;
        ResultSet rs = null;
        String cod, des;
        
        try{
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo","root","");
            DefaultTableModel dtm = new DefaultTableModel(null,columnas);
                       
            cs = conn.prepareCall("{call getColores(?,?)}");
            rs = cs.executeQuery();
            
            while(rs.next()){
                 cod = rs.getString("CODIGO");
                 des = rs.getString("DESCRIPCION");
                 txt_codigo.setText(cod);
                 txt_descripcion.setText(des);
            }   
        }catch(Exception e){
            System.out.println("Error al llenar la tabla Metodo setearText"+e);
        }       
    }

    public void llenarTabla() throws SQLException{
        CallableStatement cs = null;
        Connection conn =  null;
        ResultSet rs = null;
                
        try{
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo","root","");
            DefaultTableModel dtm = new DefaultTableModel(null,columnas);
            
            cs = conn.prepareCall("{call getColores(?,?)}");
            rs = cs.executeQuery();
            
            cs.registerOutParameter(2, Types.VARCHAR);
 
            dtm.addColumn("Codigo");
            dtm.addColumn("Descripcion");
            Object fila[] = new Object[2];      
            while(rs.next()){
                  for(i=0; i<fila.length;i++){
                    fila[i] = rs.getObject(i+1);
                  }         
              Tabla.updateUI();
              dtm.addRow(fila);
              Tabla.setModel(dtm);
            }
        }catch(Exception e){
            System.out.println("Error al llenar la tabla metodo llenarTabla"+e);
        } 
    }
     
    public void insertar() throws SQLException{
        CallableStatement cs = null;
        Connection conn =  null;
        ResultSet rs = null;
        agrego=true;
        try{
            
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo","root","");
            String codigo = txt_codigo.getText();
            String descri = txt_descripcion.getText();
            
            cs = conn.prepareCall("{call insertColores(?,?)}");

            cs.setString(1, codigo);
            cs.setString(2, descri);
            cs.execute();          
 
        }catch(Exception e){
            e.printStackTrace();
            agrego=false;
            JOptionPane.showMessageDialog(null, "Su Registro no pudo ser agregado");
        }finally{
            close(conn, cs);
        }   
        
        if(agrego==true){
                JOptionPane.showMessageDialog(null, "Su Registro fue agregado exitosamente");
                setearText();
                llenarTabla();
                deshabilitar();
                agrego=false;
        }   
    }
    
    public void modificar() throws SQLException{
        CallableStatement cs = null;
        Connection conn =  null;
        ResultSet rs = null;
        modifico = true;
        
        try{
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo","root","");
            String codigo = txt_codigo.getText();
            String descri = txt_descripcion.getText();
            
            cs = conn.prepareCall("{call updatColores(?,?)}");

            cs.setString(1, codigo);
            cs.setString(2, descri);           
            cs.execute();              
            
        }catch(Exception e){
            e.printStackTrace();
            modifico=false;
            JOptionPane.showMessageDialog(null, "Su Registro no pudo ser modificado");
        }finally{
            close(conn, cs);
        }
        
        if(modifico==true){
                JOptionPane.showMessageDialog(null, "Su Registro fue modificado exitosamente");
                setearText();
                llenarTabla();
                deshabilitar();
                modifico=false; 
        }
    }
    
    public void eliminar() throws SQLException {
        CallableStatement cs = null;
        Connection conn =  null;
        ResultSet rs = null;
        eliminar=true;
      
        try{
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo","root","");
            DefaultTableModel dtm = new DefaultTableModel(null,columnas);
            String codigo = txt_codigo.getText();
                       
            cs = conn.prepareCall("{call deletColores(?)}");
            cs.setString(1, codigo);
            rs = cs.executeQuery();

        }catch(Exception e){
            e.printStackTrace();
            eliminar=false;
            System.out.println("Error al eliminar registro en Metodo eliminar"+e);
        }  finally{
            close(conn, cs);
        }
        if(eliminar==true){
           setearText();
            llenarTabla();           
            JOptionPane.showMessageDialog(null, "Su Registro fue eliminado exitosamente"); 
        }
        
    }
    
    public void buscar() throws SQLException{
        CallableStatement cs = null;
        Connection conn =  null;
        ResultSet rs = null;
        String cod, des;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo","root","");
            DefaultTableModel dtm = new DefaultTableModel(null,columnas);
            
            String codigo = txt_buscar.getText();
            cs = conn.prepareCall("{call findColores(?,?,?)}");            
            cs.setString(1, codigo);
            rs = cs.executeQuery();
           
            while(rs.next()){
                 cod = rs.getString("CODIGO");
                 des = rs.getString("DESCRIPCION");
                 txt_codigo.setText(cod);
                 txt_descripcion.setText(des); 
            }
            buscar=false;
            habilitarBuscar();     
        }catch(Exception e){
            System.out.println("Error al buscar registro Metodo buscar"+e);
        }finally{
            close(conn, cs);
        }       
    }
       
    private static void close(Connection conn, Statement cs) throws SQLException {		
        if (cs != null) {
                cs.close();
        }
        if (conn != null) {
                conn.close();
        }
    }
    
    public void correlativo(){
        String Consecutivo = null;
        
        correlativo codigo = new correlativo();
        Consecutivo = codigo.numconsecutivo("SELECT CONCAT(REPEAT('0',6-LENGTH(CONVERT(MAX(CODIGO)+1,CHAR(6)))),CONVERT(MAX(CODIGO)+1,CHAR(6))) AS CODIGO FROM COLORES");
        if (Consecutivo==null) {
            Consecutivo="000001";
        }      
        this.txt_codigo.setText(Consecutivo);
    }
    
    public void limpiarText() throws SQLException{
        txt_codigo.setText("");
        txt_descripcion.setText("");
        setearText();
    }
      
    public void deshabilitar() throws SQLException{
        txt_codigo.setEnabled(false);
        txt_descripcion.setEnabled(false);
        bt_buscar.setEnabled(true);
        bt_eliminar.setEnabled(true);
        bt_guardar.setEnabled(false);
        bt_modificar.setEnabled(true);
        bt_adelante.setEnabled(true);
        bt_atras.setEnabled(true);
        bt_fin.setEnabled(true);
        bt_inicio.setEnabled(true);
        bt_cancelar.setEnabled(false);
        bt_agregar.setEnabled(true);
        Tabla.setEnabled(false);
        
        if(cancelar==false){
            llenarTabla();
        }else{
           limpiarText();
        }    
    }
    
    public void habilitar(){
        txt_codigo.setEnabled(true);
        txt_descripcion.setEnabled(true);
        bt_buscar.setEnabled(false);
        bt_eliminar.setEnabled(false);
        bt_guardar.setEnabled(true);
        bt_modificar.setEnabled(false);
        bt_adelante.setEnabled(false);
        bt_atras.setEnabled(false);
        bt_fin.setEnabled(false);
        bt_inicio.setEnabled(false);
        bt_cancelar.setEnabled(true);
        bt_agregar.setEnabled(false);
        Tabla.setEnabled(true);
        
        if(agrego==true){
            txt_codigo.setText("");
            txt_descripcion.setText("");
        }else{
            modifico=true;
        }
    }

    public void imprimir(java.awt.event.ActionEvent evt) {
        String codigo=(txt_codigo.getText().toString());
        System.out.println("Codigo Color: "+codigo);
        //JOptionPane.showMessageDialog(null, "EN CONSTRUCCION");
       /*Quitar comentario cuando se vaya a ejecutar el reporte*/
        startReport(codigo);
        
    }
    
    public void startReport(String codigo){
        try{
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo","root","");
            File jasper = new File(System.getProperty("user.dir")+"\\src\\reportes\\"+"listadecolores.jasper");
            System.out.println("Jasper: "+jasper);
            
            JasperReport reporte=null;
            reporte=(JasperReport) JRLoader.loadObject(jasper);

            Map param=new HashMap();
            param.put("codigo", codigo);

            System.out.println("Codigo Color:"+codigo);
            JasperPrint jasperprinter = JasperFillManager.fillReport(reporte,param,conn);
            System.out.println(jasperprinter);
            JasperViewer vista = new JasperViewer(jasperprinter,false);
            vista.setTitle("Reporte de Colores");
            vista.setExtendedState(MAXIMIZED_BOTH);
            vista.setVisible(true);
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null, e);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        bt_buscar = new javax.swing.JButton();
        bt_agregar = new javax.swing.JButton();
        bt_modificar = new javax.swing.JButton();
        bt_guardar = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();
        bt_eliminar = new javax.swing.JButton();
        bt_inicio = new javax.swing.JButton();
        bt_atras = new javax.swing.JButton();
        bt_adelante = new javax.swing.JButton();
        bt_fin = new javax.swing.JButton();
        bt_imprimir = new javax.swing.JButton();
        bt_salir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbl_codigo = new javax.swing.JLabel();
        lbl_descripcion = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        pBuscar = new javax.swing.JPanel();
        lbl_buscar = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setOpaque(false);

        bt_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search32.png"))); // NOI18N
        bt_buscar.setFocusable(false);
        bt_buscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_buscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_buscarActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_buscar);

        bt_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_add32.png"))); // NOI18N
        bt_agregar.setFocusable(false);
        bt_agregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_agregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_agregarActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_agregar);

        bt_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit32.png"))); // NOI18N
        bt_modificar.setFocusable(false);
        bt_modificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_modificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_modificarActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_modificar);

        bt_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3floppy_unmount32.png"))); // NOI18N
        bt_guardar.setActionCommand("guardar");
        bt_guardar.setFocusable(false);
        bt_guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_guardarActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_guardar);

        bt_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_cancel32.png"))); // NOI18N
        bt_cancelar.setFocusable(false);
        bt_cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_cancelar);

        bt_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_remove32.png"))); // NOI18N
        bt_eliminar.setFocusable(false);
        bt_eliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_eliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_eliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_eliminar);

        bt_inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2leftarrow32.png"))); // NOI18N
        bt_inicio.setFocusable(false);
        bt_inicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_inicio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_inicioActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_inicio);

        bt_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1leftarrow32.png"))); // NOI18N
        bt_atras.setFocusable(false);
        bt_atras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_atras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_atrasActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_atras);

        bt_adelante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1rightarrow32.png"))); // NOI18N
        bt_adelante.setFocusable(false);
        bt_adelante.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_adelante.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_adelante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_adelanteActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_adelante);

        bt_fin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2rightarrow32.png"))); // NOI18N
        bt_fin.setFocusable(false);
        bt_fin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_fin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_fin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_finActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_fin);

        bt_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print32.png"))); // NOI18N
        bt_imprimir.setFocusable(false);
        bt_imprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_imprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_imprimirActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_imprimir);

        bt_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/kfm_home32.png"))); // NOI18N
        bt_salir.setFocusable(false);
        bt_salir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_salir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salirActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_salir);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información de Colores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        lbl_codigo.setText("Codigo");

        lbl_descripcion.setText("Descripción");

        lbl_buscar.setText("Buscar Registro");

        txt_buscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_buscarFocusLost(evt);
            }
        });
        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pBuscarLayout = new javax.swing.GroupLayout(pBuscar);
        pBuscar.setLayout(pBuscarLayout);
        pBuscarLayout.setHorizontalGroup(
            pBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBuscarLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lbl_buscar)
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(pBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_buscar)
                .addContainerGap())
        );
        pBuscarLayout.setVerticalGroup(
            pBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_buscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_descripcion)
                    .addComponent(lbl_codigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_codigo)
                            .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_descripcion)
                            .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salirActionPerformed
        // TODO add your handling code here:
        if(txt_codigo.getText().equals("")||txt_descripcion.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Formulario no puede ser cerrado, existe algun proceso abierto");
        }else{
            dispose();
            MenuPrincipal.setEnabled(true);
            MenuPrincipal.setVisible(true);
        }
       
    }//GEN-LAST:event_bt_salirActionPerformed

    private void bt_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_agregarActionPerformed
        // TODO add your handling code here:
        agrego=true;
        habilitar();
    }//GEN-LAST:event_bt_agregarActionPerformed

    private void bt_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_guardarActionPerformed
            // TODO add your handling code here:
        if(txt_codigo.getText().equals("")||txt_descripcion.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Los campos no pueden estar en blanco");
        }else{
            try {
               if(agrego==true){
                insertar();
               }else{
                modificar();
               }
            } catch (SQLException ex) {
                Logger.getLogger(fr_colores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bt_guardarActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        // TODO add your handling code here:
        try {           
            cancelar=true; agrego=false; modifico=false; eliminar=false;
            deshabilitar();
        } catch (SQLException ex) {
            Logger.getLogger(fr_colores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void bt_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_modificarActionPerformed
        // TODO add your handling code here:
        modifico=true;
        habilitar();
    }//GEN-LAST:event_bt_modificarActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        // TODO add your handling code here:
        /*
        int filaseleccionada;
        try{
            filaseleccionada = Tabla.getSelectedRow();
            
                if(filaseleccionada == -1){
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
                }else{
                    DefaultTableModel modelotabla=(DefaultTableModel) Tabla.getModel();
                    String codigo = (String)modelotabla.getValueAt(filaseleccionada, 1);
                    String descri = (String) modelotabla.getValueAt(filaseleccionada, 2);
                    txt_codigo.setText(codigo);
                    txt_codigo.setText(descri);
                }
            }catch (HeadlessException ex){
             JOptionPane.showMessageDialog(null, "Error: "+ex+"\nInténtelo nuevamente", " .::Error En la Operacion::." ,JOptionPane.ERROR_MESSAGE);
       }    
       */
    }//GEN-LAST:event_TablaMouseClicked

    private void bt_adelanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_adelanteActionPerformed
        // TODO add your handling code here:
        CallableStatement cs = null;
        Connection conn =  null;
        ResultSet rs = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo","root","");
            cs = conn.prepareCall("{call getColores(?,?)}");
            rs = cs.executeQuery();
            
            if(rs.isLast()){
                 JOptionPane.showMessageDialog(null, "Registro Final");
            }else{
                rs.next();
                txt_codigo.setText(rs.getString(1));
                txt_descripcion.setText(rs.getString(2));
            }   
        }catch(Exception e){
            System.out.println("Error en Metodo Adelante"+e);
        }       
    }//GEN-LAST:event_bt_adelanteActionPerformed

    private void bt_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_atrasActionPerformed
        // TODO add your handling code here:
        CallableStatement cs = null;
        Connection conn =  null;
        ResultSet rs = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo","root","");
            cs = conn.prepareCall("{call getColores(?,?)}");
            rs = cs.executeQuery();
            
            if(rs.isFirst()){
                 JOptionPane.showMessageDialog(null, "Registro Inicial");
            }else{
                rs.previous();
                txt_codigo.setText(rs.getString(1));
                txt_descripcion.setText(rs.getString(2));
            }   
        }catch(Exception e){
            System.out.println("Error en Metodo Adelante"+e);
        }         
    }//GEN-LAST:event_bt_atrasActionPerformed

    private void bt_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_eliminarActionPerformed
        // TODO add your handling code here:
        int ax = JOptionPane.showConfirmDialog(null, "Desea Eliminar este Registro?");
            if(ax == JOptionPane.YES_OPTION){
            try {
                eliminar();
            } catch (SQLException ex) {
                Logger.getLogger(fr_colores.class.getName()).log(Level.SEVERE, null, ex);
            }
            }           
    }//GEN-LAST:event_bt_eliminarActionPerformed

    private void bt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_buscarActionPerformed
        // TODO add your handling code here:
       buscar=true;
       habilitarBuscar();
    }//GEN-LAST:event_bt_buscarActionPerformed

    private void txt_buscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_buscarFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarFocusLost

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        try {
            // TODO add your handling code here:
            buscar();
        } catch (SQLException ex) {
            Logger.getLogger(fr_colores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void bt_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_inicioActionPerformed
        // TODO add your handling code here:
        CallableStatement cs = null;
        Connection conn =  null;
        ResultSet rs = null;
       
        try{
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo","root","");
            cs = conn.prepareCall("{call getColores(?,?)}");
            rs = cs.executeQuery();
            
            if(rs.first()){
                 txt_codigo.setText(rs.getString("codigo"));
                 txt_descripcion.setText(rs.getString("descripcion"));
            }   
        }catch(Exception e){
            System.out.println("Error en Metodo Adelante"+e);
        }       
    }//GEN-LAST:event_bt_inicioActionPerformed

    private void bt_finActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_finActionPerformed
         // TODO add your handling code here:
        CallableStatement cs = null;
        Connection conn =  null;
        ResultSet rs = null;
       
        try{
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo","root","");
            cs = conn.prepareCall("{call getColores(?,?)}");
            rs = cs.executeQuery();
            
            if(rs.last()){
                 txt_codigo.setText(rs.getString("codigo"));
                 txt_descripcion.setText(rs.getString("descripcion"));
            }   
        }catch(Exception e){
            System.out.println("Error en Metodo Adelante"+e);
        }       
    }//GEN-LAST:event_bt_finActionPerformed

    private void bt_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_imprimirActionPerformed
        // TODO add your handling code here:
        imprimir(evt);
    }//GEN-LAST:event_bt_imprimirActionPerformed

    private void TablaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_TablaMousePressed
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable Tabla;
    public static javax.swing.JButton bt_adelante;
    public static javax.swing.JButton bt_agregar;
    public static javax.swing.JButton bt_atras;
    public static javax.swing.JButton bt_buscar;
    public static javax.swing.JButton bt_cancelar;
    public static javax.swing.JButton bt_eliminar;
    public static javax.swing.JButton bt_fin;
    public static javax.swing.JButton bt_guardar;
    private javax.swing.JButton bt_imprimir;
    public static javax.swing.JButton bt_inicio;
    public static javax.swing.JButton bt_modificar;
    public static javax.swing.JButton bt_salir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbl_buscar;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_descripcion;
    private javax.swing.JPanel pBuscar;
    private javax.swing.JTextField txt_buscar;
    public static javax.swing.JTextField txt_codigo;
    public static javax.swing.JTextField txt_descripcion;
    // End of variables declaration//GEN-END:variables
}
