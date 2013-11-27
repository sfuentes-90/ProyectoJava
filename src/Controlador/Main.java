/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Ventana;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author Santiago
 */
public class Main {
    public static Ventana principal;

    public static void main(String args[]) { 
        
        // Hilo de la UI
        Thread interfaz = new Thread() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }

                // Atributos de la ventana
                Ventana principal = new Ventana();
                principal.setLocationRelativeTo(null);
                principal.setResizable(false);
                principal.setTitle("Reproductor");
                principal.setVisible(true);
            }
        };
        
        // Ejecutamos el hilo
        interfaz.start();

    
    }
}
