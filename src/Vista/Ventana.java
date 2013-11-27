package Vista;

import Controlador.AbrirArchivos;
import Controlador.Metodos;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.awt.Image;
import java.io.*;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.media.CannotRealizeException;
import javax.media.NoPlayerException;
import javax.swing.table.DefaultTableModel;

public class Ventana extends javax.swing.JFrame implements Runnable{    
    public static DefaultTableModel modelo = new DefaultTableModel();
    public static boolean reproduciendo = false;
    
    public Ventana(){
        Image icono = null;
        try {
            icono = ImageIO.read(getClass().getResource("/Iconos/16x16/music.png"));
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        modelo.addColumn("Título");
        modelo.addColumn("Duración");
        setIconImage(icono);
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        slider = new javax.swing.JSlider();
        botonRetroceder = new javax.swing.JButton();
        botonDetener = new javax.swing.JButton();
        botonReproducir = new javax.swing.JButton();
        botonPausar = new javax.swing.JButton();
        botonAdelantar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaReproduccion = new javax.swing.JTable();
        panelEstado = new javax.swing.JPanel();
        tagTitulo = new javax.swing.JLabel();
        tagDuracion = new javax.swing.JLabel();
        tagAutor = new javax.swing.JLabel();
        infoDuracion = new javax.swing.JLabel();
        infoAutor = new javax.swing.JLabel();
        infoTitulo = new javax.swing.JLabel();
        tabAlbum = new javax.swing.JLabel();
        infoAlbum = new javax.swing.JLabel();
        tiempo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        botonMenuAbrir = new javax.swing.JMenuItem();
        botonMenuAgregar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        botonMenuSalir = new javax.swing.JMenuItem();
        edicion = new javax.swing.JMenu();
        javax.swing.JMenuItem botonMenuReproducir = new javax.swing.JMenuItem();
        botonMenuDetener = new javax.swing.JMenuItem();
        botonMenuSiguiente = new javax.swing.JMenuItem();
        botonMenuAnterior = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        botonMenuIrA = new javax.swing.JMenuItem();

        jButton5.setText("jButton5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        slider.setSnapToTicks(true);
        slider.setValue(0);
        slider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sliderMouseReleased(evt);
            }
        });
        slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderStateChanged(evt);
            }
        });

        botonRetroceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/16x16/retroceder.png"))); // NOI18N
        botonRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRetrocederActionPerformed(evt);
            }
        });

        botonDetener.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/16x16/stop.png"))); // NOI18N
        botonDetener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDetenerActionPerformed(evt);
            }
        });

        botonReproducir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/16x16/play.png"))); // NOI18N
        botonReproducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReproducirActionPerformed(evt);
            }
        });

        botonPausar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/16x16/pausa.png"))); // NOI18N
        botonPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPausarActionPerformed(evt);
            }
        });

        botonAdelantar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/16x16/adelantar.png"))); // NOI18N
        botonAdelantar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAdelantarActionPerformed(evt);
            }
        });

        listaReproduccion.setModel(modelo);
        jScrollPane1.setViewportView(listaReproduccion);

        panelEstado.setBackground(new java.awt.Color(255, 255, 255));

        tagTitulo.setText("Título:");

        tagDuracion.setText("Duración:");

        tagAutor.setText("Autor:");

        tabAlbum.setText("Albúm:");

        javax.swing.GroupLayout panelEstadoLayout = new javax.swing.GroupLayout(panelEstado);
        panelEstado.setLayout(panelEstadoLayout);
        panelEstadoLayout.setHorizontalGroup(
            panelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEstadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelEstadoLayout.createSequentialGroup()
                        .addGroup(panelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tagTitulo)
                            .addComponent(tagAutor)
                            .addComponent(tagDuracion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(infoDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(infoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(infoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelEstadoLayout.createSequentialGroup()
                        .addComponent(tabAlbum)
                        .addGap(18, 18, 18)
                        .addComponent(infoAlbum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        panelEstadoLayout.setVerticalGroup(
            panelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEstadoLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tagTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(infoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tagAutor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tagDuracion, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(infoDuracion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tabAlbum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoAlbum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tiempo.setText("00:00:00");

        menuArchivo.setMnemonic('a');
        menuArchivo.setText("Archivo");

        botonMenuAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
        botonMenuAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/16x16/lista.png"))); // NOI18N
        botonMenuAbrir.setText("Abrir");
        botonMenuAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuAbrirActionPerformed(evt);
            }
        });
        menuArchivo.add(botonMenuAbrir);

        botonMenuAgregar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK));
        botonMenuAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/16x16/favoritos.png"))); // NOI18N
        botonMenuAgregar.setText("Agregar a la lista");
        botonMenuAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuAgregarActionPerformed(evt);
            }
        });
        menuArchivo.add(botonMenuAgregar);
        menuArchivo.add(jSeparator1);

        botonMenuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_MASK));
        botonMenuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/16x16/apagar.png"))); // NOI18N
        botonMenuSalir.setText("Salir");
        botonMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(botonMenuSalir);

        barraMenu.add(menuArchivo);

        edicion.setMnemonic('r');
        edicion.setText("Reproducción");

        botonMenuReproducir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SPACE, java.awt.event.InputEvent.ALT_MASK));
        botonMenuReproducir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/16x16/reproducir_pausa.png"))); // NOI18N
        botonMenuReproducir.setText("Reproducir/Pausar");
        botonMenuReproducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuReproducirActionPerformed(evt);
            }
        });
        edicion.add(botonMenuReproducir);

        botonMenuDetener.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        botonMenuDetener.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/16x16/stop.png"))); // NOI18N
        botonMenuDetener.setText("Detener");
        botonMenuDetener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuDetenerActionPerformed(evt);
            }
        });
        edicion.add(botonMenuDetener);

        botonMenuSiguiente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        botonMenuSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/16x16/adelantar.png"))); // NOI18N
        botonMenuSiguiente.setText("Siguiente");
        botonMenuSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuSiguienteActionPerformed(evt);
            }
        });
        edicion.add(botonMenuSiguiente);

        botonMenuAnterior.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK));
        botonMenuAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/16x16/retroceder.png"))); // NOI18N
        botonMenuAnterior.setText("Anterior");
        botonMenuAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuAnteriorActionPerformed(evt);
            }
        });
        edicion.add(botonMenuAnterior);
        edicion.add(jSeparator2);

        botonMenuIrA.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK));
        botonMenuIrA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/16x16/ir.png"))); // NOI18N
        botonMenuIrA.setText("Ir a");
        botonMenuIrA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuIrAActionPerformed(evt);
            }
        });
        edicion.add(botonMenuIrA);

        barraMenu.add(edicion);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tiempo))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(botonRetroceder, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonDetener, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonReproducir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonPausar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonAdelantar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(botonRetroceder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonDetener, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonReproducir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonPausar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonAdelantar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonMenuSalirActionPerformed

    private void botonMenuDetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuDetenerActionPerformed
        Metodos.s.stop();
    }//GEN-LAST:event_botonMenuDetenerActionPerformed

    private void botonMenuSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuSiguienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonMenuSiguienteActionPerformed

    private void botonMenuAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuAnteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonMenuAnteriorActionPerformed

    private void botonMenuAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuAgregarActionPerformed
        try {
            AbrirArchivos.abrirMultiples();
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedTagException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidDataException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonMenuAgregarActionPerformed

    private void botonReproducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReproducirActionPerformed
        try {
            Metodos.iniciarReproduccion();
            if(!reproduciendo)
                reproduciendo = true;
            
        } catch (NoPlayerException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CannotRealizeException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedTagException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidDataException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonReproducirActionPerformed

    private void botonMenuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuAbrirActionPerformed
        try {
            AbrirArchivos.abrirArchivo();
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedTagException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidDataException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoPlayerException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CannotRealizeException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonMenuAbrirActionPerformed

    private void botonPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPausarActionPerformed
        Metodos.s.pause();
        if(reproduciendo)
            reproduciendo = false;
    }//GEN-LAST:event_botonPausarActionPerformed

    private void botonDetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDetenerActionPerformed
        Metodos.s.stop();
        if(reproduciendo)
            reproduciendo = false;
    }//GEN-LAST:event_botonDetenerActionPerformed

    private void botonAdelantarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAdelantarActionPerformed
        int indice = (listaReproduccion.getSelectedRow() + 1) % listaReproduccion.getRowCount();
        listaReproduccion.setRowSelectionInterval(indice, indice);
        try {
            Metodos.iniciarReproduccion();
            if(!reproduciendo)
                reproduciendo = true;
            
        } catch (NoPlayerException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CannotRealizeException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedTagException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidDataException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }//GEN-LAST:event_botonAdelantarActionPerformed

    private void sliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sliderMouseReleased
        System.out.println(slider.getValue());
        Metodos.irA(slider.getValue());      
    }//GEN-LAST:event_sliderMouseReleased

    private void botonMenuReproducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuReproducirActionPerformed
        try {
            if(!reproduciendo){
                Metodos.iniciarReproduccion();
                reproduciendo = true;
            }
            if(reproduciendo){
                reproduciendo = false;
                Metodos.s.pause();
            }
            
        } catch (NoPlayerException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CannotRealizeException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedTagException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidDataException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonMenuReproducirActionPerformed

    private void botonRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRetrocederActionPerformed
        int indice = (listaReproduccion.getSelectedRow() - 1) % listaReproduccion.getRowCount();
        listaReproduccion.setRowSelectionInterval(indice, indice);
        try {
            Metodos.iniciarReproduccion();
            if(!reproduciendo)
                reproduciendo = true;
            
        } catch (NoPlayerException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CannotRealizeException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedTagException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidDataException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonRetrocederActionPerformed

    private void sliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_sliderStateChanged

    private void botonMenuIrAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuIrAActionPerformed
        VentanaIr ventanaIr = new VentanaIr();
        ventanaIr.setVisible(true);
    }//GEN-LAST:event_botonMenuIrAActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton botonAdelantar;
    private javax.swing.JButton botonDetener;
    private javax.swing.JMenuItem botonMenuAbrir;
    private javax.swing.JMenuItem botonMenuAgregar;
    private javax.swing.JMenuItem botonMenuAnterior;
    private javax.swing.JMenuItem botonMenuDetener;
    private javax.swing.JMenuItem botonMenuIrA;
    private javax.swing.JMenuItem botonMenuSalir;
    private javax.swing.JMenuItem botonMenuSiguiente;
    private javax.swing.JButton botonPausar;
    private javax.swing.JButton botonReproducir;
    private javax.swing.JButton botonRetroceder;
    private javax.swing.JMenu edicion;
    public static javax.swing.JLabel infoAlbum;
    public static javax.swing.JLabel infoAutor;
    public static javax.swing.JLabel infoDuracion;
    public static javax.swing.JLabel infoTitulo;
    private javax.swing.JButton jButton5;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    public static javax.swing.JTable listaReproduccion;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JPanel panelEstado;
    public static javax.swing.JSlider slider;
    private javax.swing.JLabel tabAlbum;
    private javax.swing.JLabel tagAutor;
    private javax.swing.JLabel tagDuracion;
    private javax.swing.JLabel tagTitulo;
    public static javax.swing.JLabel tiempo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
    }
}
