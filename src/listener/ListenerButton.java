/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import java.awt.event.ActionEvent;
import view.fr_ppal;
import view.inventario.fr_productos;

/**
 *
 * @author Kel
 */
public class ListenerButton implements java.awt.event.ActionListener {
    private static boolean lAgregar=true, lbuscar=true, lsalir=true;
    
    //View
    private fr_ppal p = null;
    private fr_productos pro = null;
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()){
            case "bt_buscar":
                lbuscar=true;
            break;
            case "bt_salir":
                lsalir=true;
      
            break;
        }
    }
    
}
