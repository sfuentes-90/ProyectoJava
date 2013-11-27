/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.media.CannotRealizeException;
import javax.media.NoPlayerException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Martii
 */
public class AbrirArchivos {
    static JFileChooser fc;
    
    public static void abrirArchivo() throws IOException, UnsupportedTagException, InvalidDataException, NoPlayerException, CannotRealizeException, MalformedURLException, InstantiationException, IllegalAccessException{
        File archivo = null;
        fc = new JFileChooser();
        
        fc.setCurrentDirectory(new File(System.getProperty("user.home")));
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setFileFilter(new FileNameExtensionFilter("Audio", "wav", "mp3", "ogg", "aiff"));
        fc.setAcceptAllFileFilterUsed(false);
        
        int opcion = fc.showOpenDialog(null);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            archivo = fc.getSelectedFile();
            File archivos[] = {archivo};
            // Agregamos el archivo a la lista
            Metodos.agregarLista(archivos);
        }
    }
    
    public static void abrirMultiples() throws IOException, UnsupportedTagException, InvalidDataException{
        File archivo[] = null;
        fc = new JFileChooser();
        
        fc.setCurrentDirectory(new File(System.getProperty("user.home")));
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setMultiSelectionEnabled(true);
        fc.setFileFilter(new FileNameExtensionFilter("Audio", "wav", "mp3", "ogg", "aiff"));
        fc.setAcceptAllFileFilterUsed(false);
        
        int opcion = fc.showOpenDialog(null);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            archivo = fc.getSelectedFiles();       
            // Agregamos el archivo a la lista
            Metodos.agregarLista(archivo);
        }
    }
    
    public static void abrirLista(){
        File archivo = null;
        fc = new JFileChooser();
        
        fc.setCurrentDirectory(new File(System.getProperty("user.home")));
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setFileFilter(new FileNameExtensionFilter("Audio", "wav", "mp3", "ogg", "aiff"));
        fc.setAcceptAllFileFilterUsed(false);
        
        int opcion = fc.showOpenDialog(null);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            archivo = fc.getSelectedFile();
            // Agregamos el archivo a la lista
            Metodos.agregarListaM3u(archivo);
        }
    }
}
