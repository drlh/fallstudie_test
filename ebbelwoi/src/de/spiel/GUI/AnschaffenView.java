package de.spiel.GUI;


import de.spiel.Spiel;
import de.spiel.unternehmen.maschinen.Maschine;
import de.spiel.unternehmen.maschinen.MaschineM1;
import de.spiel.unternehmen.maschinen.MaschineM2;
import de.spiel.unternehmen.maschinen.MaschineM3;

/**
 *
 * @author PR050736
 */
public class AnschaffenView extends javax.swing.JFrame {

    /**
     * Creates new form AnschaffenView
     */
    public AnschaffenView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        comboAnschaffenMaschine = new javax.swing.JComboBox();
        lblAnschaffenMaschinenTyp_Beschriftung = new javax.swing.JLabel();
        lblAnschaffungKosten_beschriftung = new javax.swing.JLabel();
        lblAnschaffungKosten = new javax.swing.JLabel();
        btnAnschaffungMaschineAnschaffen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ebbelwoi Unternehmensplanspiel - Maschine anschaffen");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        comboAnschaffenMaschine.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Typ 1", "Typ 2", "Typ 3" }));
        comboAnschaffenMaschine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAnschaffenMaschineActionPerformed(evt);
            }
        });

        lblAnschaffenMaschinenTyp_Beschriftung.setText("Maschinentyp:");

        lblAnschaffungKosten_beschriftung.setText("Anschaffungskosten:");

        lblAnschaffungKosten.setText("0.00");

        btnAnschaffungMaschineAnschaffen.setText("Maschine anschaffen");
        btnAnschaffungMaschineAnschaffen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnschaffungMaschineAnschaffenActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(btnAnschaffungMaschineAnschaffen)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(lblAnschaffungKosten_beschriftung)
                            .add(lblAnschaffenMaschinenTyp_Beschriftung))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(comboAnschaffenMaschine, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(lblAnschaffungKosten))))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(comboAnschaffenMaschine, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblAnschaffenMaschinenTyp_Beschriftung))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblAnschaffungKosten_beschriftung)
                    .add(lblAnschaffungKosten))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(btnAnschaffungMaschineAnschaffen)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

                                                      

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AnschaffenView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnschaffenView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnschaffenView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnschaffenView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnschaffenView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAnschaffungMaschineAnschaffen;
    private javax.swing.JComboBox comboAnschaffenMaschine;
    private javax.swing.JLabel lblAnschaffenMaschinenTyp_Beschriftung;
    private javax.swing.JLabel lblAnschaffungKosten;
    private javax.swing.JLabel lblAnschaffungKosten_beschriftung;
    // End of variables declaration       
    
    
    ///CODE
    
    private void btnAnschaffungMaschineAnschaffenActionPerformed(java.awt.event.ActionEvent evt) {                                                                 
      /*  int select = comboAnschaffenMaschine.getSelectedIndex();
        int player = Spiel.getAktuelleRunde().getAktuellerSpielerNr();
        switch (select) {
		case 0:
			Spiel.getSpieler().get(player).getUnternehmen().getProduktion().getMaschinenpark().add(new MaschineM1());
			break;
		case 1:
			Spiel.getSpieler().get(player).getUnternehmen().getProduktion().getMaschinenpark().add(new MaschineM2());
			break;
		case 2:
			Spiel.getSpieler().get(player).getUnternehmen().getProduktion().getMaschinenpark().add(new MaschineM3());
			break;

		default:
			break;
		}*/
        this.setVisible(false);
    }                                                                

    private void comboAnschaffenMaschineActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        // TODO add your handling code here:
    }   
}
