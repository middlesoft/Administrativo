/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.inventario;

import connection.cargaCombo;
import connection.correlativo;
import java.awt.Dimension;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import static view.inventario.fr_colores.bt_adelante;
import static view.inventario.fr_colores.bt_agregar;
import static view.inventario.fr_colores.bt_atras;
import static view.inventario.fr_colores.bt_buscar;
import static view.inventario.fr_colores.bt_cancelar;
import static view.inventario.fr_colores.bt_eliminar;
import static view.inventario.fr_colores.bt_fin;
import static view.inventario.fr_colores.bt_guardar;
import static view.inventario.fr_colores.bt_inicio;
import static view.inventario.fr_colores.bt_modificar;
import static view.main.fr_ppal.escritorio;

/**
 *
 * @author Kel
 */
public class fr_almacenes extends javax.swing.JInternalFrame {

    /**
     * Creates new form fr_almacenes
     */
    public fr_almacenes() throws SQLException {
        initComponents();
        deshabilitar();
        this.setTitle("Almacenes");
        //correlativo();
        combo();
        centrar();
    }
    
     public void centrar(){
        Dimension desktopSize = escritorio.getSize();
        Dimension jInternalFrameSize = this.getSize();
        this.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
    }
    
    
    public void insertar() throws SQLException{
        CallableStatement cs = null;
        Connection conn =  null;
        ResultSet rs = null;
        
        try{
            
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo","root","");
            //String sql = "INSERT INTO COLORES(codigo, descripcion)VALUES("+txt_codigo+","+txt_descripcion+")"; 
            String codigo = txt_codigo.getText();
            String descri = txt_descripcion.getText();
            String sucur = (String) cbo_sucursal.getSelectedItem();
            
            cs = conn.prepareCall("{call insertSucursal(?,?,?)}");

            cs.setString(1, codigo);
            cs.setString(2, descri);
            cs.setString(3, sucur);
            
            System.out.println("Capturamos la insercion del registro 1: "+codigo);
            System.out.println("Capturamos la insercion del registro 2: "+descri);
            System.out.println("Capturamos la insercion del registro 2: "+sucur);
            cs.execute();
            System.out.println("Finaliza el store procedure");

                       
        }catch(Exception e){
            e.printStackTrace();
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
    
    public void combo() throws SQLException {
        
        int contar = (int) cbo_sucursal.countComponents();

        String sql = "SELECT CODIGO AS DATO1 FROM DEPARTAMENTO";
        DefaultComboBoxModel mdl = new DefaultComboBoxModel(cargaCombo.Elementos(sql));
        this.cbo_sucursal.setModel(mdl);
        this.cbo_sucursal.addItem("Seleccione...");
        //System.out.println(mdl);
        this.cbo_sucursal.setSelectedIndex(1);
        
    }
    
    public void correlativo(){
        String Consecutivo = null;
        
        correlativo codigo = new correlativo();
        Consecutivo = codigo.numconsecutivo("SELECT CONCAT(REPEAT('0',6-LENGTH(CONVERT(MAX(CODIGO)+1,CHAR(6)))),CONVERT(MAX(CODIGO)+1,CHAR(6))) AS CODIGO FROM ALMACEN");
        if (Consecutivo==null) {
            Consecutivo="000001";
        }
              
        this.txt_codigo.setText(Consecutivo);
    }
    
    public void deshabilitar(){
        txt_codigo.setEnabled(false);
        txt_descripcion.setEnabled(false);
        cbo_sucursal.setEnabled(false);
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
                
    }
    
    public void habilitar(){
        txt_codigo.setEnabled(true);
        txt_descripcion.setEnabled(true);
        cbo_sucursal.setEnabled(true);
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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        cbo_sucursal = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
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
        bt_salir = new javax.swing.JButton();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información de Almacenes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 11))); // NOI18N

        jLabel1.setText("Codigo");

        jLabel2.setText("Descripción");

        jLabel3.setText("Sucursal");

        cbo_sucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(230, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbo_sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Descripción", "Sucursal"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setOpaque(false);

        bt_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search32.png"))); // NOI18N
        bt_buscar.setFocusable(false);
        bt_buscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_buscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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
        jToolBar1.add(bt_modificar);

        bt_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3floppy_unmount32.png"))); // NOI18N
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
        jToolBar1.add(bt_inicio);

        bt_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1leftarrow32.png"))); // NOI18N
        bt_atras.setFocusable(false);
        bt_atras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_atras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(bt_atras);

        bt_adelante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1rightarrow32.png"))); // NOI18N
        bt_adelante.setFocusable(false);
        bt_adelante.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_adelante.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(bt_adelante);

        bt_fin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2rightarrow32.png"))); // NOI18N
        bt_fin.setFocusable(false);
        bt_fin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_fin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(bt_fin);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_eliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_eliminarActionPerformed

    private void bt_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_agregarActionPerformed
        // TODO add your handling code here:
        habilitar();
    }//GEN-LAST:event_bt_agregarActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        // TODO add your handling code here:
        deshabilitar();
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void bt_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_bt_salirActionPerformed

    private void bt_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_guardarActionPerformed
        try {
            // TODO add your handling code here:
            insertar();
        } catch (SQLException ex) {
            Logger.getLogger(fr_almacenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_guardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bt_adelante;
    public static javax.swing.JButton bt_agregar;
    public static javax.swing.JButton bt_atras;
    public static javax.swing.JButton bt_buscar;
    public static javax.swing.JButton bt_cancelar;
    public static javax.swing.JButton bt_eliminar;
    public static javax.swing.JButton bt_fin;
    public static javax.swing.JButton bt_guardar;
    public static javax.swing.JButton bt_inicio;
    public static javax.swing.JButton bt_modificar;
    public static javax.swing.JButton bt_salir;
    private javax.swing.JComboBox<String> cbo_sucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public static javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_descripcion;
    // End of variables declaration//GEN-END:variables
}
