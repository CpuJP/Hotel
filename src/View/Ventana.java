/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.google.zxing.WriterException;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Controller.GenerarQR;

/**
 *
 * @author David
 */
public class Ventana extends JFrame {
    
    public Ventana(String cadena) throws WriterException {
        GenerarQR generaQR = new GenerarQR();
        BufferedImage imagen = generaQR.crearQR(cadena, 300, 300);
        ImageIcon icono = new ImageIcon(imagen);
        JLabel etiqueta = new JLabel("");
        
        etiqueta.setIcon(icono);
        
        this.setIconImage(imagen);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Ejemplo de codigo QR");
        this.getContentPane().add(etiqueta);
        this.pack();        
    }
}