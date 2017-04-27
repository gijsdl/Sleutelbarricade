
package sleutelbarricade;

import javax.swing.JOptionPane;

/**
 *
 * @author Chris Bruijn, Ruben Buijck, Gijs de Lange
 */
public class spelStart extends javax.swing.JFrame {

    /**
     * Creates new form spelStart
     */
    public spelStart() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        bRegels = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sleutel Barricade");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Nieuw Spel");
        jButton2.setPreferredSize(new java.awt.Dimension(128, 64));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, -1, -1));

        bRegels.setText("Regels");
        bRegels.setMaximumSize(new java.awt.Dimension(64, 64));
        bRegels.setMinimumSize(new java.awt.Dimension(64, 64));
        bRegels.setPreferredSize(new java.awt.Dimension(128, 64));
        bRegels.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegelsActionPerformed(evt);
            }
        });
        getContentPane().add(bRegels, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 510, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sleutelbarricade/pics/menu.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bRegelsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegelsActionPerformed
        //regels uitleggen
        JOptionPane.showMessageDialog(null ,"Probeer de eindtegel te bereiken door de juiste sleutels op te pakken.");
        JOptionPane.showMessageDialog(null ,"De speler kan maar 1 sleutel tegelijk vasthouden, en alleen de sleutel met de juiste waarde opent een barricade.");
        JOptionPane.showMessageDialog(null ,"Sleutel kwijt? Dan moet je opnieuw beginnen!");
    }//GEN-LAST:event_bRegelsActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Deze JFrame sluiten en die van die van level openen.
        String[] args = null;
        Level.main(args);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    
    public static void main(String args[]) {
      //start van het JFrame.
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new spelStart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bRegels;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

}
