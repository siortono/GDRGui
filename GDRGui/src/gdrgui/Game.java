/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gdrgui;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author 
 */
public class Game extends Thread {

    private Casella[][] bottoni;
    private ArrayList<Casella> giocatore;
    private ArrayList<Casella> avversario;
    private ArrayList<Casella> campo;
    private boolean turnoGiocatore;
    private Casella giocante;
    private JPanel contentPanel;
    private Casella destinazione;

    public Game(Casella[][] bottoni, ArrayList giocatore, ArrayList avversario, ArrayList campo, JPanel contentPanel) {
        this.bottoni = bottoni;
        this.campo = campo;
        this.giocatore = giocatore;
        this.avversario = avversario;
        turnoGiocatore = true;
        this.contentPanel = contentPanel;
    }

    synchronized void turnoCpu() {
        Random r = new Random();
        giocante = avversario.get(r.nextInt(avversario.size()));
        generaDestinazione();
        if (giocatore.contains(destinazione)) {
            combattimento(destinazione, giocante);
            turnoGiocatore=true;
            fineTurno();
        } else {
            sposta(giocante, destinazione);
            turnoGiocatore=true;
            fineTurno();
        }
    }

    public void generaDestinazione() {
        int x = 1;
        int i = giocante.getI();
        int j = giocante.getJ();
        Random r = new Random();
        while (x != 0) {
            switch (r.nextInt(5)) {
                case 1:
                    try {
                        if (bottoni[i + 1][j].getIcon() == null || bottoni[i + 1][j].p.fazione) {
                            destinazione = bottoni[i + 1][j];
                            x = 0;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                    }
                    break;
                case 2:
                    try {
                        if (bottoni[i][j - 1].getIcon() == null || bottoni[i][j-1].p.fazione) {
                            destinazione = bottoni[i][j - 1];
                            x = 0;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                    }
                    break;
                case 3:
                    try {
                        if (bottoni[i][j + 1].getIcon() == null || bottoni[i][j+1].p.fazione) {
                            destinazione = bottoni[i][j + 1];
                            x = 0;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                    }
                    break;
                case 4:
                    try {
                        if (bottoni[i + 1][j - 1].getIcon() == null || bottoni[i + 1][j-1].p.fazione) {
                            destinazione = bottoni[i + 1][j - 1];
                            x = 0;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                    }
                    break;
                case 5:

                    try {
                        if (bottoni[i + 1][j + 1].getIcon() == null || bottoni[i + 1][j+1].p.fazione) {
                            destinazione = bottoni[i + 1][j + 1];
                            x = 0;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                    }
                    break;
            }
        }
    }

    public Casella visualizza(Casella giocante) {
        this.giocante = giocante;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                bottoni[i][j].setEnabled(false);
            }
        }
        int i = giocante.getI();
        int j = giocante.getJ();
        bottoni[i][j].setEnabled(true);
        try {
            if (bottoni[i - 1][j].getIcon() == null || !bottoni[i - 1][j].p.fazione) {
                bottoni[i - 1][j].setEnabled(true);
            }
        } catch (IndexOutOfBoundsException ex) {
        }


        try {
            if (bottoni[i + 1][j].getIcon() == null || !bottoni[i + 1][j].p.fazione) {
                bottoni[i + 1][j].setEnabled(true);
            }
        } catch (IndexOutOfBoundsException ex) {
        }

        try {
            if (bottoni[i][j - 1].getIcon() == null || !bottoni[i][j - 1].p.fazione) {
                bottoni[i][j - 1].setEnabled(true);
            }
        } catch (IndexOutOfBoundsException ex) {
        }

        try {
            if (bottoni[i][j + 1].getIcon() == null || !bottoni[i][j + 1].p.fazione) {
                bottoni[i][j + 1].setEnabled(true);
            }
        } catch (IndexOutOfBoundsException ex) {
        }

        try {
            if (bottoni[i - 1][j - 1].getIcon() == null || !bottoni[i - 1][j - 1].p.fazione) {
                bottoni[i - 1][j - 1].setEnabled(true);
            }
        } catch (IndexOutOfBoundsException ex) {
        }

        try {
            if (bottoni[i + 1][j - 1].getIcon() == null || !bottoni[i + 1][j - 1].p.fazione) {
                bottoni[i + 1][j - 1].setEnabled(true);
            }
        } catch (IndexOutOfBoundsException ex) {
        }

        try {
            if (bottoni[i - 1][j + 1].getIcon() == null || !bottoni[i - 1][j + 1].p.fazione) {
                bottoni[i - 1][j + 1].setEnabled(true);
            }
        } catch (IndexOutOfBoundsException ex) {
        }

        try {
            if (bottoni[i + 1][j + 1].getIcon() == null || !bottoni[i + 1][j + 1].p.fazione) {
                bottoni[i + 1][j + 1].setEnabled(true);
            }
        } catch (IndexOutOfBoundsException ex) {
        }
        return null;
    }

    synchronized void turnoGiocatore(Casella destinazione) {
        turnoGiocatore = false;
        if (destinazione.p != null) {
            if (!destinazione.p.fazione) {
                combattimento(giocante, destinazione);
            }
            fineTurno();
        } else {
            sposta(giocante, destinazione);
            fineTurno();
        }

    }

    public void combattimento(Casella buono, Casella cattivo) {
        if (buono.p.forza > cattivo.p.forza) {
            cattivo.setIcon(null);
            cattivo.setPersonaggio(null);
            sposta(buono, cattivo);
            if (cattivo.p.exp < 10) {
                cattivo.p.exp++;
            }
            if (cattivo.p.isHero) {
                cattivo.p.energia--;
            }

        } else if (buono.p.forza == cattivo.p.forza) {
            giocatore.remove(buono);
            avversario.remove(cattivo);
            campo.add(buono);


            buono.setIcon(null);
            cattivo.setIcon(null);
            buono.setPersonaggio(null);
            cattivo.setPersonaggio(null);
        } else {
            giocatore.remove(buono);
            buono.setIcon(null);
            buono.setPersonaggio(null);
            campo.add(buono);
            sposta(cattivo, buono);
            if (buono.p.exp < 10) {
                buono.p.exp++;
            }
            if (buono.p.isHero) {
                buono.p.energia--;
            }
        }


    }

    public void sposta(Casella giocante, Casella destinazione) {
        destinazione.setPersonaggio(giocante.getPersonaggio());
        destinazione.setIcon(giocante.getIcon());

        if (giocatore.contains(giocante)) {
            giocatore.remove(giocante);
            giocatore.add(destinazione);
            campo.remove(destinazione);
        } else if (avversario.contains(giocante)) {
            avversario.remove(giocante);
            avversario.add(destinazione);

        }
        
        campo.add(giocante);
        giocante.setIcon(null);
        giocante.setPersonaggio(null);
    }

    public void fineTurno() {
        for (int i = 0; i < campo.size(); i++) {
            campo.get(i).setEnabled(true);
            if (campo.get(i).p == null) {
                campo.get(i).setEnabled(false);
            }
            if (i < giocatore.size()) {
                giocatore.get(i).setEnabled(true);
            }
            if(!turnoGiocatore)
                turnoCpu();
        }


    }
}
