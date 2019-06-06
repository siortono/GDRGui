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

public class Eroe extends Personaggio{
    public String nome;
    public BufferedImage myPicture;
    
    public Eroe(String nome){
        super();
        isHero=true;
        if(nome.equals("Anakin")){ fazione=true; squadra="Buono";}
        energia=10;
        forza=50*exp+50*energia;
        this.nome=nome;
        try {
            myPicture = ImageIO.read(getClass().getResource("/images/Eroe.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Nano.class.getName()).log(Level.SEVERE, null, ex);
        }
        immagine = myPicture.getScaledInstance(150,90, Image.SCALE_SMOOTH);
    }
    
}
