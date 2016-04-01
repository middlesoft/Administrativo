/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.main;

import controller.ControlColores;
import view.inventario.fr_colores;
import view.inventario.fr_productos;
import view.inventario.fr_categoria;
import view.inventario.fr_unidades;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.inventario.fr_almacenes;
import view.inventario.fr_departamento;
import view.inventario.fr_grupos;
import view.inventario.fr_sucursal;
import view.inventario.fr_tallas;
import view.inventario.fr_ubicacion;

/**
 *
 * @author Kel
 */
public class fr_ppal extends javax.swing.JFrame implements Runnable {
    private Dimension dim;
    String hora, minutos, segundos, ampm;
     Calendar calendario;
      Thread h1;
    /**
     * Creates new form fr_ppal
     */
    public fr_ppal() {
        initComponents();
        dim = super.getToolkit().getScreenSize();
        super.setExtendedState(MAXIMIZED_BOTH);
        super.setVisible(true);
        jToolBar1.setVisible(false);
        iniciarreloj();
        
              
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/middlesoftlogo.png"));
        setIconImage(icon);
        setVisible(true);
    }
    
    public void iniciarreloj(){
        h1 = new Thread(this);
        h1.start();
    }
        
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            calcula();
            lbHora.setText(hora + ":" + minutos + ":" + segundos + " " + ampm);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();

        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

        if (ampm.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
            hora = h > 9 ? "" + h : "0" + h;
        } else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        escritorio = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbHora = new javax.swing.JLabel();
        MenuPrincipal = new javax.swing.JMenuBar();
        Archivo = new javax.swing.JMenu();
        Salir = new javax.swing.JMenuItem();
        Edicion = new javax.swing.JMenu();
        Modulos = new javax.swing.JMenu();
        Inventario = new javax.swing.JMenu();
        Procesos_Inv = new javax.swing.JMenu();
        Entrada_Salida = new javax.swing.JMenuItem();
        Tabla_Inv = new javax.swing.JMenu();
        Articulo = new javax.swing.JMenuItem();
        Colores = new javax.swing.JMenuItem();
        Unidades = new javax.swing.JMenuItem();
        Categoria = new javax.swing.JMenuItem();
        SubCategoria = new javax.swing.JMenuItem();
        Almacenes = new javax.swing.JMenuItem();
        Ubicacion = new javax.swing.JMenuItem();
        Departamento = new javax.swing.JMenuItem();
        SubGrupos = new javax.swing.JMenuItem();
        Sucursal = new javax.swing.JMenuItem();
        Tallas = new javax.swing.JMenuItem();
        Grupos = new javax.swing.JMenuItem();
        Reporte_Inv = new javax.swing.JMenu();
        Compras = new javax.swing.JMenu();
        Procesos_CxC = new javax.swing.JMenu();
        Tabla_CxC = new javax.swing.JMenu();
        Reporte_CxC = new javax.swing.JMenu();
        Ventas = new javax.swing.JMenu();
        Procesos_CxP = new javax.swing.JMenu();
        Tabla_CxP = new javax.swing.JMenu();
        Reporte_CxP = new javax.swing.JMenu();
        Contabilidad = new javax.swing.JMenu();
        Soporte = new javax.swing.JMenu();
        Ayuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        bt_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search44.png"))); // NOI18N
        bt_buscar.setFocusable(false);
        bt_buscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_buscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(bt_buscar);

        bt_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_add.png"))); // NOI18N
        bt_agregar.setFocusable(false);
        bt_agregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_agregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(bt_agregar);

        bt_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        bt_modificar.setFocusable(false);
        bt_modificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_modificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(bt_modificar);

        bt_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3floppy_unmount.png"))); // NOI18N
        bt_guardar.setFocusable(false);
        bt_guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(bt_guardar);

        bt_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_cancel.png"))); // NOI18N
        bt_cancelar.setFocusable(false);
        bt_cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(bt_cancelar);

        bt_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_remove.png"))); // NOI18N
        bt_eliminar.setFocusable(false);
        bt_eliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_eliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(bt_eliminar);

        bt_inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2leftarrow.png"))); // NOI18N
        bt_inicio.setFocusable(false);
        bt_inicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_inicio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(bt_inicio);

        bt_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1leftarrow.png"))); // NOI18N
        bt_atras.setFocusable(false);
        bt_atras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_atras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(bt_atras);

        bt_adelante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1rightarrow.png"))); // NOI18N
        bt_adelante.setFocusable(false);
        bt_adelante.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_adelante.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(bt_adelante);

        bt_fin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2rightarrow.png"))); // NOI18N
        bt_fin.setFocusable(false);
        bt_fin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_fin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(bt_fin);

        bt_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/kfm_home.png"))); // NOI18N
        bt_salir.setFocusable(false);
        bt_salir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_salir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salirActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_salir);

        escritorio.setOpaque(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/middlesoft.png"))); // NOI18N

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MySQL2.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 0, 173, 110));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/JAVA2.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, 89));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/netbeans2.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 172, 110));

        lbHora.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        lbHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHora.setText("jLabel1");

        escritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(lbHora, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Archivo.setText("Archivo");
        Archivo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArchivoActionPerformed(evt);
            }
        });

        Salir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        Archivo.add(Salir);

        MenuPrincipal.add(Archivo);

        Edicion.setText("Edicion");
        Edicion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        MenuPrincipal.add(Edicion);

        Modulos.setText("Modulos");
        Modulos.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Modulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ModulosMouseClicked(evt);
            }
        });

        Inventario.setText("Inventario");
        Inventario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        Procesos_Inv.setText("Procesos");
        Procesos_Inv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        Entrada_Salida.setText("Entrada y Salida");
        Procesos_Inv.add(Entrada_Salida);

        Inventario.add(Procesos_Inv);

        Tabla_Inv.setText("Tablas");
        Tabla_Inv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        Articulo.setText("Articulos o Productos");
        Articulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArticuloActionPerformed(evt);
            }
        });
        Tabla_Inv.add(Articulo);

        Colores.setText("Colores");
        Colores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColoresActionPerformed(evt);
            }
        });
        Tabla_Inv.add(Colores);

        Unidades.setText("Unidades");
        Unidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnidadesActionPerformed(evt);
            }
        });
        Tabla_Inv.add(Unidades);

        Categoria.setText("Categoria o Linea");
        Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoriaActionPerformed(evt);
            }
        });
        Tabla_Inv.add(Categoria);

        SubCategoria.setText("SubCategoria o Sublinea");
        Tabla_Inv.add(SubCategoria);

        Almacenes.setText("Almacenes");
        Almacenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlmacenesActionPerformed(evt);
            }
        });
        Tabla_Inv.add(Almacenes);

        Ubicacion.setText("Ubicación");
        Ubicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UbicacionActionPerformed(evt);
            }
        });
        Tabla_Inv.add(Ubicacion);

        Departamento.setText("Departamento");
        Departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepartamentoActionPerformed(evt);
            }
        });
        Tabla_Inv.add(Departamento);

        SubGrupos.setText("SubGrupos");
        Tabla_Inv.add(SubGrupos);

        Sucursal.setText("Sucursal");
        Sucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SucursalActionPerformed(evt);
            }
        });
        Tabla_Inv.add(Sucursal);

        Tallas.setText("Tallas");
        Tallas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TallasActionPerformed(evt);
            }
        });
        Tabla_Inv.add(Tallas);

        Grupos.setText("Grupos");
        Grupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GruposActionPerformed(evt);
            }
        });
        Tabla_Inv.add(Grupos);

        Inventario.add(Tabla_Inv);

        Reporte_Inv.setText("Reportes");
        Reporte_Inv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Inventario.add(Reporte_Inv);

        Modulos.add(Inventario);

        Compras.setText("CxC");

        Procesos_CxC.setText("Procesos");
        Compras.add(Procesos_CxC);

        Tabla_CxC.setText("Tablas");
        Compras.add(Tabla_CxC);

        Reporte_CxC.setText("Reportes");
        Compras.add(Reporte_CxC);

        Modulos.add(Compras);

        Ventas.setText("CxP");

        Procesos_CxP.setText("Procesos");
        Ventas.add(Procesos_CxP);

        Tabla_CxP.setText("Tablas");
        Ventas.add(Tabla_CxP);

        Reporte_CxP.setText("Reportes");
        Ventas.add(Reporte_CxP);

        Modulos.add(Ventas);

        Contabilidad.setText("Contabilidad");
        Modulos.add(Contabilidad);

        MenuPrincipal.add(Modulos);

        Soporte.setText("Soporte");
        Soporte.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        MenuPrincipal.add(Soporte);

        Ayuda.setText("Ayuda");
        Ayuda.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        MenuPrincipal.add(Ayuda);

        setJMenuBar(MenuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1358, Short.MAX_VALUE)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(escritorio))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArchivoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ArchivoActionPerformed

    private void ModulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModulosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ModulosMouseClicked

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        // TODO add your handling code here:
        int salir = JOptionPane.showConfirmDialog(null,"Desea Salir del Sistema?");
        
        if(salir==0){
            System.exit(0);
        }
    }//GEN-LAST:event_SalirActionPerformed

    private void ArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArticuloActionPerformed
        // TODO add your handling code here:
        fr_productos prod = new fr_productos();
        escritorio.add(prod);
        prod.show();
    }//GEN-LAST:event_ArticuloActionPerformed

    private void bt_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salirActionPerformed
        // TODO add your handling code here:
       
        
        
    }//GEN-LAST:event_bt_salirActionPerformed

    private void UnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnidadesActionPerformed
        // TODO add your handling code here:
        fr_unidades und = new fr_unidades();
        escritorio.add(und);
        und.show();
    }//GEN-LAST:event_UnidadesActionPerformed

    private void ColoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColoresActionPerformed
        try {
            // TODO add your handling code here:
            fr_colores col = new fr_colores();
            escritorio.add(col);
            col.show();
        } catch (SQLException ex) {
            Logger.getLogger(fr_ppal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ColoresActionPerformed

    private void CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriaActionPerformed
        try {
            // TODO add your handling code here:
            fr_categoria cat = new fr_categoria();
            escritorio.add(cat);
            cat.show();
        } catch (SQLException ex) {
            Logger.getLogger(fr_ppal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CategoriaActionPerformed

    private void AlmacenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlmacenesActionPerformed
        try {
            // TODO add your handling code here:
            fr_almacenes alm = new fr_almacenes();
            escritorio.add(alm);
            alm.show();
        } catch (SQLException ex) {
            Logger.getLogger(fr_ppal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AlmacenesActionPerformed

    private void UbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UbicacionActionPerformed
        // TODO add your handling code here:
        fr_ubicacion ub = new fr_ubicacion();
        escritorio.add(ub);
        ub.show();
    }//GEN-LAST:event_UbicacionActionPerformed

    private void DepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepartamentoActionPerformed
        // TODO add your handling code here:
        fr_departamento dp = new fr_departamento();
        escritorio.add(dp);
        dp.show();
    }//GEN-LAST:event_DepartamentoActionPerformed

    private void GruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GruposActionPerformed
        // TODO add your handling code here:
        fr_grupos gp;
        try {
            gp = new fr_grupos();
            escritorio.add(gp);
            gp.show();
        } catch (SQLException ex) {
            Logger.getLogger(fr_ppal.class.getName()).log(Level.SEVERE, null, ex);
        }
     
       
    }//GEN-LAST:event_GruposActionPerformed

    private void TallasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TallasActionPerformed
        // TODO add your handling code here:
        fr_tallas talla = new fr_tallas();
        escritorio.add(talla);
        talla.show();
    }//GEN-LAST:event_TallasActionPerformed

    private void SucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SucursalActionPerformed
        // TODO add your handling code here:
        fr_sucursal suc = new fr_sucursal();
        escritorio.add(suc);
        suc.show();
    }//GEN-LAST:event_SucursalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fr_ppal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fr_ppal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fr_ppal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fr_ppal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fr_ppal().setVisible(true);
                
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenuItem Almacenes;
    public static javax.swing.JMenu Archivo;
    public static javax.swing.JMenuItem Articulo;
    public static javax.swing.JMenu Ayuda;
    public static javax.swing.JMenuItem Categoria;
    public static javax.swing.JMenuItem Colores;
    public static javax.swing.JMenu Compras;
    public static javax.swing.JMenu Contabilidad;
    public static javax.swing.JMenuItem Departamento;
    public static javax.swing.JMenu Edicion;
    public static javax.swing.JMenuItem Entrada_Salida;
    public static javax.swing.JMenuItem Grupos;
    public static javax.swing.JMenu Inventario;
    public static javax.swing.JMenuBar MenuPrincipal;
    public static javax.swing.JMenu Modulos;
    public static javax.swing.JMenu Procesos_CxC;
    public static javax.swing.JMenu Procesos_CxP;
    public static javax.swing.JMenu Procesos_Inv;
    public static javax.swing.JMenu Reporte_CxC;
    public static javax.swing.JMenu Reporte_CxP;
    public static javax.swing.JMenu Reporte_Inv;
    public static javax.swing.JMenuItem Salir;
    public static javax.swing.JMenu Soporte;
    public static javax.swing.JMenuItem SubCategoria;
    public static javax.swing.JMenuItem SubGrupos;
    public static javax.swing.JMenuItem Sucursal;
    public static javax.swing.JMenu Tabla_CxC;
    public static javax.swing.JMenu Tabla_CxP;
    public static javax.swing.JMenu Tabla_Inv;
    public static javax.swing.JMenuItem Tallas;
    public static javax.swing.JMenuItem Ubicacion;
    public static javax.swing.JMenuItem Unidades;
    public static javax.swing.JMenu Ventas;
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
    public static javax.swing.JDesktopPane escritorio;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JToolBar jToolBar1;
    public static javax.swing.JLabel lbHora;
    // End of variables declaration//GEN-END:variables
}
