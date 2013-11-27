package Controlador;

import Modelo.Cancion;
import Vista.Ventana;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class LeerTag {
    public static void leer(String archivo) throws IOException, UnsupportedTagException, InvalidDataException{
        Mp3File file = new Mp3File(archivo);         
        if(file.hasId3v2Tag()){
            ID3v2 tag = file.getId3v2Tag();

            Ventana.infoTitulo.setText(tag.getTitle());
            Ventana.infoAutor.setText(tag.getArtist());
            Ventana.infoAlbum.setText(tag.getAlbum());
            Ventana.infoDuracion.setText(Metodos.segundosHHMMSS(file.getLengthInSeconds())); 

            byte imagen[] = tag.getAlbumImage();
            if(imagen != null){
                InputStream in = new ByteArrayInputStream(imagen);
                BufferedImage bImagen = ImageIO.read(in);
                bImagen = resize(bImagen, Ventana.jLabel1.getWidth(), Ventana.jLabel1.getHeight());
                Ventana.jLabel1.setIcon(new ImageIcon(bImagen));
            }
        }
    }
    
    public static long duracion(String archivo) throws IOException, UnsupportedTagException, InvalidDataException{
        Mp3File file = new Mp3File(archivo);
        
        return file.getLengthInSeconds();
    }
    
    public static BufferedImage resize(BufferedImage img, int widht, int height) {  
        int ancho = img.getWidth();  
        int alto = img.getHeight();  
        BufferedImage imagen = new BufferedImage(widht, height, img.getType());  
        Graphics2D g = imagen.createGraphics();  
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);  
        g.drawImage(img, 0, 0, widht, height, 0, 0, ancho, alto, null);  
        g.dispose();  
        return imagen;  
    }  

    public static Cancion getInfo(File f) throws IOException, UnsupportedTagException, InvalidDataException {
        Mp3File file = new Mp3File(f.getCanonicalPath()); 
        String titulo, autor, album, duracion;
        Cancion c = null;
        
        if(file.hasId3v2Tag()){
            ID3v2 tag = file.getId3v2Tag();

            titulo = tag.getTitle();
            autor = tag.getArtist();
            album = tag.getAlbum();
            duracion = Metodos.segundosHHMMSS(file.getLengthInSeconds());
            
                c = new Cancion(titulo, duracion, autor, album, f);
        }
        else{
            titulo = f.getName();
            duracion = Metodos.segundosHHMMSS(file.getLengthInSeconds());
            
            c = new Cancion(titulo, duracion, "", "", f);
        }
        
        return c;
    }

}
