package Controlador;

import Modelo.Cancion;
import Vista.Ventana;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.io.*;
import java.net.MalformedURLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.CannotRealizeException;
import javax.media.NoPlayerException;

public class Metodos {
    public static SonidoNativo s = null;
    public static Thread hiloReproduccion;
    public static ArrayList<Cancion> lista = new ArrayList<Cancion>();
    private static Thread hiloToolTip;
       
    public static void iniciarReproduccion() throws NoPlayerException, CannotRealizeException, MalformedURLException, IOException, InstantiationException, IllegalAccessException, UnsupportedTagException, InvalidDataException {
        if (s != null)
            s.stop();
        
        int pista = Ventana.listaReproduccion.getSelectedRow();
        File f = lista.get(pista).getArchivo();
        
        s = new SonidoNativo(f);
        Ventana.slider.setMinimum(0);
        Ventana.slider.setMaximum((int) LeerTag.duracion(f.getCanonicalPath()));
        LeerTag.leer(f.getCanonicalPath());

        s.start();       
        hiloReproduccion = new Thread() {
            @Override
            public void run() {
                while(s.tiempoActual() <= s.tiempoTotal()){
                    Ventana.tiempo.setText(segundosHHMMSS(s.tiempoActual()));
                    Ventana.slider.setValue(s.tiempoActual());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
 
        hiloReproduccion.start();
    }
    
    public static String segundosHHMMSS(long tTotal){
        int tiempo = (int) tTotal;
        int hrs = tiempo/3600;
        int min =(tiempo-(3600*hrs))/60;
        int seg = tiempo-((hrs*3600)+(min*60));
        
        String horas, minutos, segundos;
        
        if(seg < 10){
            segundos = "0"+seg;
        }
        else{
            segundos = seg+"";
        }
        if(min < 10){
            minutos = "0"+min;
        }
        else{
            minutos = min+"";
        }
        if(hrs < 10){
            horas = "0"+hrs;
        }
        else{
            horas = hrs+"";
        }
        
        String str = horas+":"+minutos+":"+segundos;           
        return str; 
    }

    public static void irA(int value) {
        s.setTime((double)value);
    }

    static void agregarLista(File[] archivo) throws IOException, UnsupportedTagException, InvalidDataException {
        for (File file : archivo) {
            Cancion c = LeerTag.getInfo(file);
            Object row[] = {c.getTitulo(), c.getDuracion()};
            lista.add(c);
            Ventana.modelo.addRow(row);
        }
        Ventana.listaReproduccion.setRowSelectionInterval(0, 0);
    }

    static void agregarListaM3u(File archivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}