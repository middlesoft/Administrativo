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
import static view.inventario.fr_categoria.bt_adelante;
import static view.inventario.fr_categoria.bt_agregar;
import static view.inventario.fr_categoria.bt_atras;
import static view.inventario.fr_categoria.bt_buscar;
import static view.inventario.fr_categoria.bt_cancelar;
import static view.inventario.fr_categoria.bt_eliminar;
import static view.inventario.fr_categoria.bt_fin;
import static view.inventario.fr_categoria.bt_guardar;
import static view.inventario.fr_categoria.bt_inicio;
import static view.inventario.fr_categoria.bt_modificar;
import static view.main.fr_ppal.escritorio;

/**
 *
 * @author Kel
 */
public class fr_subcategoria extends javax.swing.JInternalFrame {

    /**
     * Creates new form fr_subcategoria
     */
    public fr_subcategoria() throws SQLException {
        initComponents();
        //correlativo();
        combo();
        deshabilitar();
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
            String categ = (String) cbo_categoria.getSelectedItem();
            
            cs = conn.prepareCall("{call insertSubcategoria(?,?,?)}");

            cs.setString(1, codigo);
            cs.setString(2, descri);
            cs.setString(3, categ);
            
            System.out.println("Capturamos la insercion del registro 1: "+codigo);
            System.out.println("Capturamos la insercion del registro 2: "+descri);
            System.out.println("Capturamos la insercion del registro 2: "+categ);
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
        
        int contar = (int) cbo_categoria.countComponents();

        String sql = "SELECT CODIGO AS DATO1 FROM CATEGORIA";
        DefaultComboBoxModel mdl = new DefaultComboBoxModel(cargaCombo.Elementos(sql));
        this.cbo_categoria.setModel(mdl);
        this.cbo_categoria.addItem("Seleccione...");
        //System.out.println(mdl);
        this.cbo_categoria.setSelectedIndex(1);
        
    }
    
    public void correlativo(){
        String Consecutivo = null;
        
        correlativo codigo = new correlativo();
        Consecutivo = codigo.numconsecutivo("SELECT CONCAT(REPEAT('0',6-LENGTH(CONVERT(MAX(CODIGO)+1,CHAR(6)))),CONVERT(MAX(CODIGO)+1,CHAR(6))) AS CODIGO FROM SUBCATEGORIA");   
        if (Consecutivo==null) {
            Consecutivo="000001";
        }
              
        this.txt_codigo.setText(Consecutivo);
    }
    
     public void deshabilitar(){
        txt_codigo.setEnabled(false);
        txt_descripcion.setEnabled(false);
        cbo_categoria.setEnabled(false);
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
        cbo_categoria.setEnabled(true);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_descripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbo_categoria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Información SubCategoria"));

        jLabel1.setText("Codigo");

        jLabel2.setText("Descripción");

        jLabel3.setText("Categoria");

        cbo_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbo_categoria, 0, 210, Short.MAX_VALUE)
                            .addComponent(txt_descripcion))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 58, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_agregarActionPerformed
        // TODO add your handling code here:
        habilitar();
    }//GEN-LAST:event_bt_agregarActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        // TODO add your handling code here:
        deshabilitar();
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void bt_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_guardarActionPerformed
        try {
            // TODO add your handling code here:
            insertar();
        } catch (SQLException ex) {
            Logger.getLogger(fr_subcategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_guardarActionPerformed

    private void bt_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_bt_salirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
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
    private javax.swing.JComboBox<String> cbo_categoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    public static javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_descripcion;
    // End of variables declaration//GEN-END:variables
}
