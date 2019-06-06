/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gdrgui;

import java.awt.Image;

/**
 *
 * @author Mattia Tonolini
 */
public abstract class Personaggio {
    public int forza;
    public int exp;
    public boolean fazione;
    public Image immagine;
    public boolean isHero;
    public int energia;
    public String squadra;
    
    public Personaggio(){
        exp=1;
        squadra="Nemico";
    }
}
