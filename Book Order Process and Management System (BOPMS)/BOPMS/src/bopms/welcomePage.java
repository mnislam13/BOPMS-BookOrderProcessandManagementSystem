/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdummy;

/**
 *
 * @author user
 */
public class welcomePage extends javax.swing.JFrame {

    /**
     * Creates new form welcomePage
     */
    public welcomePage() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomePanel = new javax.swing.JPanel();
        welcomeNextButton = new javax.swing.JButton();
        welcomeLable = new javax.swing.JLabel();
        toLable = new javax.swing.JLabel();
        welcomeExitButton = new javax.swing.JButton();
        titleLable1 = new javax.swing.JLabel();
        titleLable2 = new javax.swing.JLabel();
        wolcomePanelWhite = new javax.swing.JPanel();
        homePicLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("welcomePage");
        setUndecorated(true);
        setResizable(false);

        welcomePanel.setBackground(new java.awt.Color(85, 104, 138));
        welcomePanel.setLayout(null);

        welcomeNextButton.setBackground(new java.awt.Color(255, 255, 255));
        welcomeNextButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        welcomeNextButton.setText(">");
        welcomeNextButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        welcomeNextButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        welcomeNextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                welcomeNextButtonActionPerformed(evt);
            }
        });
        welcomePanel.add(welcomeNextButton);
        welcomeNextButton.setBounds(540, 440, 60, 32);

        welcomeLable.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        welcomeLable.setForeground(new java.awt.Color(255, 255, 255));
        welcomeLable.setText("Welcome");
        welcomePanel.add(welcomeLable);
        welcomeLable.setBounds(410, 120, 113, 47);

        toLable.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        toLable.setForeground(new java.awt.Color(255, 255, 255));
        toLable.setText("TO");
        welcomePanel.add(toLable);
        toLable.setBounds(444, 178, 42, 46);

        welcomeExitButton.setBackground(new java.awt.Color(255, 255, 255));
        welcomeExitButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        welcomeExitButton.setText("X");
        welcomeExitButton.setMaximumSize(new java.awt.Dimension(10, 19));
        welcomeExitButton.setMinimumSize(new java.awt.Dimension(10, 19));
        welcomeExitButton.setPreferredSize(new java.awt.Dimension(10, 19));
        welcomeExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                welcomeExitButtonActionPerformed(evt);
            }
        });
        welcomePanel.add(welcomeExitButton);
        welcomeExitButton.setBounds(583, 0, 50, 30);

        titleLable1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        titleLable1.setForeground(new java.awt.Color(255, 255, 255));
        titleLable1.setText("BOOK ORDER PROCESS");
        welcomePanel.add(titleLable1);
        titleLable1.setBounds(330, 230, 280, 46);

        titleLable2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        titleLable2.setForeground(new java.awt.Color(255, 255, 255));
        titleLable2.setText("MANAGEMENT SYSTEM");
        welcomePanel.add(titleLable2);
        titleLable2.setBounds(330, 290, 280, 46);

        wolcomePanelWhite.setBackground(new java.awt.Color(255, 255, 255));

        homePicLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.jpg"))); // NOI18N
        homePicLabel.setToolTipText("");

        javax.swing.GroupLayout wolcomePanelWhiteLayout = new javax.swing.GroupLayout(wolcomePanelWhite);
        wolcomePanelWhite.setLayout(wolcomePanelWhiteLayout);
        wolcomePanelWhiteLayout.setHorizontalGroup(
            wolcomePanelWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wolcomePanelWhiteLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(homePicLabel)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        wolcomePanelWhiteLayout.setVerticalGroup(
            wolcomePanelWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wolcomePanelWhiteLayout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(homePicLabel)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        welcomePanel.add(wolcomePanelWhite);
        wolcomePanelWhite.setBounds(0, 0, 290, 520);

        jLabel1.setFont(new java.awt.Font("Sitka Display", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(85, 104, 138));
        jLabel1.setText("Happy Birthday Sir :D");
        welcomePanel.add(jLabel1);
        jLabel1.setBounds(340, 380, 240, 30);

        jLabel2.setFont(new java.awt.Font("Stencil Std", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(85, 104, 138));
        jLabel2.setText("&");
        welcomePanel.add(jLabel2);
        jLabel2.setBounds(450, 350, 20, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(welcomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(welcomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(634, 497));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void welcomeNextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_welcomeNextButtonActionPerformed
        // TODO add your handling code here:
        loginAdmin loginAdmin = new loginAdmin();
        loginAdmin . setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_welcomeNextButtonActionPerformed

    private void welcomeExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_welcomeExitButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_welcomeExitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(welcomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(welcomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(welcomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(welcomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new welcomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel homePicLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel titleLable1;
    private javax.swing.JLabel titleLable2;
    private javax.swing.JLabel toLable;
    private javax.swing.JButton welcomeExitButton;
    private javax.swing.JLabel welcomeLable;
    private javax.swing.JButton welcomeNextButton;
    private javax.swing.JPanel welcomePanel;
    private javax.swing.JPanel wolcomePanelWhite;
    // End of variables declaration//GEN-END:variables
}
