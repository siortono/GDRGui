/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gdrgui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mattia Tonolini
 */

public class GdRGUI extends javax.swing.JFrame {

    /**
     * Creates new form GdRGUI
     */
    private int temp;
    private Personaggio[] buoni, cattivi;
    private Casella[][] bottoni;
    private ArrayList<Casella> giocatore;
    private ArrayList<Casella> avversario;
    private ArrayList<Casella> campo;
    private Casella giocante;
    private Game g;
    private BufferedImage sfondo;

    public GdRGUI() throws IOException {

        initComponents();
        
    
        temp = 0;
        winLabel.setText("HAI VINTO");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        winDialog.setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        GridLayout gl = new GridLayout(5, 5);
        contentPanel.setLayout(gl);
        giocatore = new ArrayList<>();
        campo = new ArrayList<>();
        avversario = new ArrayList<>();
        bottoni = new Casella[5][5];
        giocante = new Casella(10, 10);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                bottoni[i][j] = new Casella(i, j);
                bottoni[i][j].setEnabled(false);
            }
        }

        creaPersonaggi();
        creaCampo();
        g = new Game(bottoni, giocatore, avversario, campo, contentPanel);
       
        JFrame JPanel1 = new JFrame();
        JPanel1.getContentPane().setBackground(Color.red);
        
        GiocaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (temp == 1) {
                    g.visualizza(giocante);
                    temp = 2;
                }

            }
        });

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                bottoni[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        giocante = (Casella) e.getSource();
                        if (giocante.p != null) {
                            if (giocante.p.fazione) {
                                temp = 1;
                                giocante = (Casella) e.getSource();
                                }
                            imgLabel.setIcon(new ImageIcon(giocante.p.immagine));
                            statLabel.setText("<html>Razza:\t" + giocante.p.getClass().getSimpleName() +"<br />\nSquadra:\t"+giocante.p.squadra+ "<br />\nForza:\t" + giocante.p.forza + "<br />\nEsperienza:\t" + giocante.p.exp + "</html>");
                            
                        }
                        if (temp == 2) {
                            g.turnoGiocatore(giocante);
                            if(giocatore.isEmpty()){
                                winDialog.setVisible(true);
                                winLabel.setText("SEI MORTO");
                            }
                            if(avversario.isEmpty()){
                                winDialog.setVisible(true);
                                winLabel.setText("HAI VINTO");
                            }
                            temp = 0;
                        }
                    }
                });
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        winDialog = new javax.swing.JDialog();
        winLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jDialog2 = new javax.swing.JDialog();
        jinfo = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        GiocaButton = new javax.swing.JToggleButton();
        imgLabel = new javax.swing.JLabel();
        statLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblsfondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        winDialog.setAlwaysOnTop(true);
        winDialog.setMinimumSize(new java.awt.Dimension(250, 200));

        winLabel.setFont(new java.awt.Font("Charlemagne Std", 0, 24)); // NOI18N
        winLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton1.setText("Nuova");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout winDialogLayout = new javax.swing.GroupLayout(winDialog.getContentPane());
        winDialog.getContentPane().setLayout(winDialogLayout);
        winDialogLayout.setHorizontalGroup(
            winDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(winDialogLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, winDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(winLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        winDialogLayout.setVerticalGroup(
            winDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(winDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(winLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jinfoLayout = new javax.swing.GroupLayout(jinfo.getContentPane());
        jinfo.getContentPane().setLayout(jinfoLayout);
        jinfoLayout.setHorizontalGroup(
            jinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jinfoLayout.setVerticalGroup(
            jinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 700));

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GiocaButton.setText("Gioca");
        GiocaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GiocaButtonActionPerformed(evt);
            }
        });
        jPanel2.add(GiocaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 155, 43));

        imgLabel.setMinimumSize(new java.awt.Dimension(150, 90));
        imgLabel.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel2.add(imgLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 33, 148, -1));
        jPanel2.add(statLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 127, 148));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jMenu1.setText("Partita");

        jMenuItem1.setText("Nuova partita");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Informazioni");

        jMenuItem3.setText("Regolamento");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(102, Short.MAX_VALUE)
                    .addComponent(lblsfondo, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(262, Short.MAX_VALUE)
                    .addComponent(lblsfondo, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(108, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        dispose();
        winDialog.setVisible(false);
        try {
            new GdRGUI().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(GdRGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void GiocaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GiocaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GiocaButtonActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
          setVisible(false);
        dispose();
        winDialog.setVisible(false);
        try {
            new GdRGUI().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(GdRGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       jinfo.setVisible(true);
       jinfo.setSize(1600,400);
       jinfo.setTitle("Regolamento");
       jLabel2.setText("Il gioco è composto da due squadre avversari con cinque personaggi ciascuno. Lo scopo della partita è sconfiggere l'avversario. Ricorda che per muovere la casella devi cliccare su gioca e per battere il nemico la tua forza deve essere superiore");
              
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void creaPersonaggi() {
        Random rand = new Random();
        buoni = new Personaggio[5];
        cattivi = new Personaggio[5];
        for (int n, i = 0; i < 5; i++) {
            n = rand.nextInt(5);
            switch (n) {
                case 0:
                    bottoni[4][i].setPersonaggio(new Elfo());
                    bottoni[0][i].setPersonaggio(new Urukhai());
                    break;
                case 1:
                    bottoni[4][i].setPersonaggio(new Uomo());
                    bottoni[0][i].setPersonaggio(new Sudroni());
                    break;
                case 2:
                    bottoni[4][i].setPersonaggio(new Hobbit());
                    bottoni[0][i].setPersonaggio(new Orco());
                    break;
                case 3:
                    bottoni[4][i].setPersonaggio(new Nano());
                    bottoni[0][i].setPersonaggio(new Sudroni());
                    break;
                case 4:
                    bottoni[4][i].setPersonaggio(new Eroe("Anakin"));
                    bottoni[0][i].setPersonaggio(new Eroe("Darth Vader"));
                    break;
            }
        }

    }

    private void creaCampo() throws IOException {
        int i, j;
        for (i = 0; i < 5; i++) {
            bottoni[0][i].setIcon(new ImageIcon(bottoni[0][i].getPersonaggio().immagine));
            bottoni[0][i].setEnabled(true);
            avversario.add(bottoni[0][i]);
        }

        for (i = 0; i < 5; i++) {
            bottoni[4][i].setIcon(new ImageIcon(bottoni[4][i].getPersonaggio().immagine));
            bottoni[4][i].setEnabled(true);
            giocatore.add(bottoni[4][i]);

        }

        for (i = 0; i < 4; i++) {
            for (j = 0; j < 5; j++) {
                campo.add(bottoni[i][j]);
            }

        }


        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                contentPanel.add(bottoni[i][j]);

            }
        }
        
       
    }

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;














                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GdRGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GdRGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GdRGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GdRGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new GdRGUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(GdRGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton GiocaButton;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JDialog jinfo;
    private javax.swing.JLabel lblsfondo;
    private javax.swing.JLabel statLabel;
    private javax.swing.JDialog winDialog;
    private javax.swing.JLabel winLabel;
    // End of variables declaration//GEN-END:variables
}
