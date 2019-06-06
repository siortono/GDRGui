/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gdrgui;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Mattia Tonolini
 */
public class Uomo extends Personaggio{
    public BufferedImage myPicture;
    
    public Uomo(){
        super();
        fazione=true;
        squadra="Buono";
        forza=30+6*exp;
        
                 try {
            myPicture = ImageIO.read(getClass().getResource("/images/Uomo.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Nano.class.getName()).log(Level.SEVERE, null, ex);
        }
        immagine = myPicture.getScaledInstance(150,90, Image.SCALE_SMOOTH);
    }
}