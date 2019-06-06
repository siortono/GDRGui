/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gdrgui;

import javax.swing.JButton;

/**
 *
 * @author Mattia Tonolini
 */

public class Casella extends JButton{
    private int x,y;
    Personaggio p;
    boolean last;
    
    public Casella(int x, int y) {
        super();
        this.x=x;   
        this.y=y;
        p=null;
        
    }
    
    public void setPersonaggio(Personaggio p1){
        p=p1;
    }
    
    public Personaggio getPersonaggio(){
        return p;
    }
    
    public int getI() {
        return x;
    }
    
    public int getJ(){
        return y;
    }

}
