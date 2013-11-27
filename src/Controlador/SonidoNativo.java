package Controlador;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.*;
import javax.media.bean.playerbean.MediaPlayer;
import javax.media.format.AudioFormat;


public class SonidoNativo {
    MediaPlayer player;
    File file;

    public SonidoNativo (File f) throws NoPlayerException, CannotRealizeException, MalformedURLException, IOException, InstantiationException, IllegalAccessException {
        try {
            
            String jffmpegAudioDecoder = "net.sourceforge.jffmpeg.AudioDecoder";
            /* Cargamos el codec y lo guardamos en un objeto de tipo Codec */
            Codec codecAudio = (Codec) Class.forName(jffmpegAudioDecoder).newInstance();
            /* Agregamos los codec al PlugInManager */
            PlugInManager.addPlugIn(jffmpegAudioDecoder, codecAudio.getSupportedInputFormats(), new Format[]{new AudioFormat("LINEAR")}, PlugInManager.CODEC);
            
            file = f;
            
            // get a player
            player = new MediaPlayer();
            String ruta = "file:///" + file.getPath();
            player.setMediaLocation(ruta);
            player.setPlaybackLoop(false);
            player.prefetch();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SonidoNativo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void start(){
        player.start();
    }
    
    public void stop(){
        player.stop();
        player.setMediaTime(new Time(0));
    }

    public void pause() {
        player.stop();
    }
    
    public void setTime(double seg){
        Time t = new Time(seg);
        player.setMediaTime(t);
    }
    
    public int tiempoActual() {
        Time t = player.getMediaTime();
        return (int) t.getSeconds();
    }
    
    public int tiempoTotal(){
        Time t = player.getDuration();        
        return (int) t.getSeconds();
    }
}