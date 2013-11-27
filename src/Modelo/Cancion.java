/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.io.File;

/**
 *
 * @author Santiago
 */
public class Cancion {
    private String titulo;
    private String duracion;
    private String autor;
    private String album;
    private File archivo;

    public Cancion(String titulo, String duracion, String autor, String album, File archivo) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.autor = autor;
        this.album = album;
        this.archivo = archivo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getAutor() {
        return autor;
    }

    public String getAlbum() {
        return album;
    }
    
    public File getArchivo(){
        return archivo;
    }
}
