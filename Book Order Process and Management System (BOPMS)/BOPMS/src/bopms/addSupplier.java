package dbdummy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class addSupplier extends javax.swing.JFrame {
    
    
    
    Connection connection;
    public static String rid;
    public static String sprname;
    public static String sprmail;
    public static String sprphn;
    String tempid;

    /**
     * Creates new form suppliers
     */
    public addSupplier()  {
        initComponents();
        
        generateID obj = new generateID();
        try {
            rid = obj.generator("supplier", "supplierId", "R");
        } catch (SQLException ex) {
            Logger.getLogger(addNewCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        suplridT.setText(rid);
        
    }
    
   
    
    
    public void connectDB() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager
            .getConnection(
             "jdbc:sqlserver://localhost:1433;databaseName=dbBOPMS;"
               + "selectMethod=cursor", "sa", "123456");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        addsuplrLabel = new javax.swing.JLabel();
        addsuplrExitButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        suplrnameT = new javax.swing.JTextField();
        suplrmailT = new javax.swing.JTextField();
        suplrphnT = new javax.swing.JTextField();
        suplrBtn = new javax.swing.JButton();
        addCus_notice = new javax.swing.JLabel();
        suplridT = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(85, 104, 138));
        jPanel1.setLayout(null);

        addsuplrLabel.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        addsuplrLabel.setForeground(new java.awt.Color(255, 255, 255));
        addsuplrLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addsuplrLabel.setText("ADD NEW SUPPLIER");
        jPanel1.add(addsuplrLabel);
        addsuplrLabel.setBounds(90, 10, 440, 40);

        addsuplrExitButton.setBackground(new java.awt.Color(255, 255, 255));
        addsuplrExitButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        addsuplrExitButton.setText("X");
        addsuplrExitButton.setMaximumSize(new java.awt.Dimension(10, 19));
        addsuplrExitButton.setMinimumSize(new java.awt.Dimension(10, 19));
        addsuplrExitButton.setPreferredSize(new java.awt.Dimension(10, 19));
        addsuplrExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addsuplrExitButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addsuplrExitButton);
        addsuplrExitButton.setBounds(560, 10, 60, 30);

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("NAME:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 170, 130, 30);

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("EMAIL:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 230, 130, 30);

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("PHONE NO:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(30, 290, 130, 30);

        suplrnameT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suplrnameTActionPerformed(evt);
            }
        });
        jPanel1.add(suplrnameT);
        suplrnameT.setBounds(170, 170, 420, 30);

        suplrmailT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suplrmailTActionPerformed(evt);
            }
        });
        jPanel1.add(suplrmailT);
        suplrmailT.setBounds(170, 230, 420, 30);
        jPanel1.add(suplrphnT);
        suplrphnT.setBounds(170, 290, 420, 30);

        suplrBtn.setText("DONE");
        suplrBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suplrBtnActionPerformed(evt);
            }
        });
        jPanel1.add(suplrBtn);
        suplrBtn.setBounds(30, 370, 560, 50);

        addCus_notice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addCus_notice.setForeground(new java.awt.Color(204, 0, 51));
        jPanel1.add(addCus_notice);
        addCus_notice.setBounds(400, 580, 260, 30);

        suplridT.setEditable(false);
        suplridT.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(suplridT);
        suplridT.setBounds(170, 110, 420, 30);

        jLabel10.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Supplier ID:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 110, 140, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(634, 497));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addsuplrExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addsuplrExitButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_addsuplrExitButtonActionPerformed

    private void suplrmailTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suplrmailTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suplrmailTActionPerformed

    private void suplrBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suplrBtnActionPerformed
        // TODO add your handling code here:
        sprname= suplrnameT.getText();
        sprmail = suplrmailT.getText();
        sprphn = suplrphnT.getText();
        
        if( sprname.isEmpty() || sprmail.isEmpty() || sprphn.isEmpty()){

            JOptionPane.showMessageDialog(null,"Please fill all fields");
        }
        else{
            try {

                connectDB();

                String sql = "Insert into supplier(supplierId,supplierName,"
                        + "supplierEmail,supplierPhone)"
                + "values(?,?,?,?)";

                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setString(1, rid);
                pst.setString(2, sprname);
                pst.setString(3, sprmail);
                pst.setString(4, sprphn);
               
                pst.executeUpdate();

                addCus_notice.setText("Supplier is added Successfully");
                
                suplridT.setText("");
                suplrnameT.setText("");
                suplrmailT.setText("");
                suplrphnT.setText("");
            } catch (SQLException e) {
            }
        }
    }//GEN-LAST:event_suplrBtnActionPerformed

    private void suplrnameTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suplrnameTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suplrnameTActionPerformed

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
            java.util.logging.Logger.getLogger(addSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addSupplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addCus_notice;
    private javax.swing.JButton addsuplrExitButton;
    private javax.swing.JLabel addsuplrLabel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton suplrBtn;
    private javax.swing.JTextField suplridT;
    private javax.swing.JTextField suplrmailT;
    private javax.swing.JTextField suplrnameT;
    private javax.swing.JTextField suplrphnT;
    // End of variables declaration//GEN-END:variables
}
