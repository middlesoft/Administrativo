/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.inventario;

import connection.correlativo;
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
import static view.main.fr_ppal.MenuPrincipal;

/**
 *
 * @author Kelvin
 */
public class fr_ubicacion extends javax.swing.JInternalFrame {

    /**
     * Creates new form fr_ubicacion
     */
    public fr_ubicacion() {
        initComponents();
        deshabilitar();
        this.setTitle("Ubicación Fisica");
        //correlativo();
    }
    
    public void correlativo(){
        String Consecutivo = null;
        
        correlativo codigo = new correlativo();
        Consecutivo = codigo.numconsecutivo("SELECT CONCAT(REPEAT('0',6-LENGTH(CONVERT(MAX(CODIGO)+1,CHAR(6)))),CONVERT(MAX(CODIGO)+1,CHAR(6))) AS CODIGO FROM UBICACION");
        if (Consecutivo==null) {
            Consecutivo="000001";
        }
              
        this.txt_codigo.setText(Consecutivo);
    }
    
    public void deshabilitar(){
        txt_codigo.setEnabled(false);
        txt_descripcion.setEnabled(false);
        cbo_almacen.setEnabled(false);
        txt_pasillo.setEnabled(false);
        txt_anaquel.setEnabled(false);
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
        cbo_almacen.setEnabled(true);
        txt_pasillo.setEnabled(true);
        txt_anaquel.setEnabled(true);
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
        jPanel3 = new javax.swing.JPanel();
        lbl_codigo = new javax.swing.JLabel();
        lbl_descripcion = new javax.swing.JLabel();
        lbl_almacen = new javax.swing.JLabel();
        lbl_pasillo = new javax.swing.JLabel();
        lbl_anaquel = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        cbo_almacen = new javax.swing.JComboBox<>();
        txt_pasillo = new javax.swing.JTextField();
        txt_anaquel = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jToolBar2 = new javax.swing.JToolBar();
        bt_buscar1 = new javax.swing.JButton();
        bt_agregar1 = new javax.swing.JButton();
        bt_modificar1 = new javax.swing.JButton();
        bt_guardar1 = new javax.swing.JButton();
        bt_cancelar1 = new javax.swing.JButton();
        bt_eliminar1 = new javax.swing.JButton();
        bt_inicio1 = new javax.swing.JButton();
        bt_atras1 = new javax.swing.JButton();
        bt_adelante1 = new javax.swing.JButton();
        bt_fin1 = new javax.swing.JButton();
        bt_salir1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jToolBar1.setRollover(true);

        bt_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search32.png"))); // NOI18N
        bt_buscar.setFocusable(false);
        bt_buscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_buscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(bt_buscar);

        bt_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_add32.png"))); // NOI18N
        bt_agregar.setFocusable(false);
        bt_agregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_agregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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
        jToolBar1.add(bt_guardar);

        bt_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_cancel32.png"))); // NOI18N
        bt_cancelar.setFocusable(false);
        bt_cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion Ubicación"));

        lbl_codigo.setText("Codigo");

        lbl_descripcion.setText("Descripcion");

        lbl_almacen.setText("Almacen");

        lbl_pasillo.setText("Pasillo");

        lbl_anaquel.setText("Anaquel");

        cbo_almacen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_descripcion)
                    .addComponent(lbl_codigo)
                    .addComponent(lbl_almacen)
                    .addComponent(lbl_pasillo)
                    .addComponent(lbl_anaquel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbo_almacen, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_anaquel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(txt_pasillo, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_codigo)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_descripcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbo_almacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_almacen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_pasillo)
                    .addComponent(txt_pasillo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_anaquel)
                    .addComponent(txt_anaquel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion", "Almacen", "Pasillo", "Anaquel"
            }
        ));
        jScrollPane1.setViewportView(Tabla);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);
        jToolBar2.setOpaque(false);

        bt_buscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search32.png"))); // NOI18N
        bt_buscar1.setFocusable(false);
        bt_buscar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_buscar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(bt_buscar1);

        bt_agregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_add32.png"))); // NOI18N
        bt_agregar1.setFocusable(false);
        bt_agregar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_agregar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_agregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_agregar1ActionPerformed(evt);
            }
        });
        jToolBar2.add(bt_agregar1);

        bt_modificar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit32.png"))); // NOI18N
        bt_modificar1.setFocusable(false);
        bt_modificar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_modificar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(bt_modificar1);

        bt_guardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3floppy_unmount32.png"))); // NOI18N
        bt_guardar1.setFocusable(false);
        bt_guardar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_guardar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(bt_guardar1);

        bt_cancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_cancel32.png"))); // NOI18N
        bt_cancelar1.setFocusable(false);
        bt_cancelar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_cancelar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelar1ActionPerformed(evt);
            }
        });
        jToolBar2.add(bt_cancelar1);

        bt_eliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_remove32.png"))); // NOI18N
        bt_eliminar1.setFocusable(false);
        bt_eliminar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_eliminar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(bt_eliminar1);

        bt_inicio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2leftarrow32.png"))); // NOI18N
        bt_inicio1.setFocusable(false);
        bt_inicio1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_inicio1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(bt_inicio1);

        bt_atras1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1leftarrow32.png"))); // NOI18N
        bt_atras1.setFocusable(false);
        bt_atras1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_atras1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(bt_atras1);

        bt_adelante1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1rightarrow32.png"))); // NOI18N
        bt_adelante1.setFocusable(false);
        bt_adelante1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_adelante1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(bt_adelante1);

        bt_fin1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2rightarrow32.png"))); // NOI18N
        bt_fin1.setFocusable(false);
        bt_fin1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_fin1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(bt_fin1);

        bt_salir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/kfm_home32.png"))); // NOI18N
        bt_salir1.setFocusable(false);
        bt_salir1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_salir1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_salir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salir1ActionPerformed(evt);
            }
        });
        jToolBar2.add(bt_salir1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salirActionPerformed
        // TODO add your handling code here:
        dispose();
        MenuPrincipal.setEnabled(true);
        MenuPrincipal.setVisible(true);
    }//GEN-LAST:event_bt_salirActionPerformed

    private void bt_salir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salir1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_bt_salir1ActionPerformed

    private void bt_agregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_agregar1ActionPerformed
        // TODO add your handling code here:
        habilitar();
    }//GEN-LAST:event_bt_agregar1ActionPerformed

    private void bt_cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelar1ActionPerformed
        // TODO add your handling code here:
        deshabilitar();
    }//GEN-LAST:event_bt_cancelar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    public static javax.swing.JButton bt_adelante;
    public static javax.swing.JButton bt_adelante1;
    public static javax.swing.JButton bt_agregar;
    public static javax.swing.JButton bt_agregar1;
    public static javax.swing.JButton bt_atras;
    public static javax.swing.JButton bt_atras1;
    public static javax.swing.JButton bt_buscar;
    public static javax.swing.JButton bt_buscar1;
    public static javax.swing.JButton bt_cancelar;
    public static javax.swing.JButton bt_cancelar1;
    public static javax.swing.JButton bt_eliminar;
    public static javax.swing.JButton bt_eliminar1;
    public static javax.swing.JButton bt_fin;
    public static javax.swing.JButton bt_fin1;
    public static javax.swing.JButton bt_guardar;
    public static javax.swing.JButton bt_guardar1;
    public static javax.swing.JButton bt_inicio;
    public static javax.swing.JButton bt_inicio1;
    public static javax.swing.JButton bt_modificar;
    public static javax.swing.JButton bt_modificar1;
    public static javax.swing.JButton bt_salir;
    public static javax.swing.JButton bt_salir1;
    private javax.swing.JComboBox<String> cbo_almacen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JToolBar jToolBar1;
    public static javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lbl_almacen;
    private javax.swing.JLabel lbl_anaquel;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_descripcion;
    private javax.swing.JLabel lbl_pasillo;
    private javax.swing.JTextField txt_anaquel;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_pasillo;
    // End of variables declaration//GEN-END:variables
}
