
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class form extends javax.swing.JFrame {

    /**
     * Creates new form form
     */
    public form() {
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

        jPanel1 = new javax.swing.JPanel();
        registerL = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        phnT = new javax.swing.JTextField();
        idT = new javax.swing.JTextField();
        nameT = new javax.swing.JTextField();
        mailT = new javax.swing.JTextField();
        addrssT = new javax.swing.JTextField();
        submitBtn = new javax.swing.JButton();
        requiredphn = new javax.swing.JLabel();
        requiredId = new javax.swing.JLabel();
        requiredname = new javax.swing.JLabel();
        requiredpass = new javax.swing.JLabel();
        exitBtn = new javax.swing.JButton();
        passT = new javax.swing.JPasswordField();
        listBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(null);

        registerL.setBackground(new java.awt.Color(0, 0, 0));
        registerL.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 36)); // NOI18N
        registerL.setForeground(new java.awt.Color(255, 255, 255));
        registerL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registerL.setText("Register");
        jPanel1.add(registerL);
        registerL.setBounds(350, 30, 256, 60);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Admin Phone No:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(200, 440, 140, 40);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Admin ID:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(220, 160, 140, 40);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Admin Name:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(210, 210, 140, 40);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Admin Email:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(210, 260, 140, 40);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Admin Password:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(200, 320, 140, 40);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Admin Address:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(200, 380, 140, 40);

        phnT.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        phnT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(phnT);
        phnT.setBounds(370, 440, 280, 30);

        idT.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        idT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(idT);
        idT.setBounds(370, 160, 280, 30);

        nameT.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        nameT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(nameT);
        nameT.setBounds(370, 210, 280, 30);

        mailT.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        mailT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(mailT);
        mailT.setBounds(370, 260, 280, 30);

        addrssT.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        addrssT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(addrssT);
        addrssT.setBounds(370, 380, 280, 30);

        submitBtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        submitBtn.setText("Submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        jPanel1.add(submitBtn);
        submitBtn.setBounds(380, 490, 120, 40);

        requiredphn.setBackground(new java.awt.Color(0, 0, 0));
        requiredphn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        requiredphn.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(requiredphn);
        requiredphn.setBounds(660, 440, 110, 30);

        requiredId.setBackground(new java.awt.Color(0, 0, 0));
        requiredId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        requiredId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(requiredId);
        requiredId.setBounds(660, 160, 110, 30);

        requiredname.setBackground(new java.awt.Color(0, 0, 0));
        requiredname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        requiredname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(requiredname);
        requiredname.setBounds(660, 210, 110, 30);

        requiredpass.setBackground(new java.awt.Color(0, 0, 0));
        requiredpass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        requiredpass.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(requiredpass);
        requiredpass.setBounds(660, 320, 100, 30);

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));
        exitBtn.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        exitBtn.setText("X");
        exitBtn.setMaximumSize(new java.awt.Dimension(10, 19));
        exitBtn.setMinimumSize(new java.awt.Dimension(10, 19));
        exitBtn.setPreferredSize(new java.awt.Dimension(10, 19));
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });
        jPanel1.add(exitBtn);
        exitBtn.setBounds(870, 10, 50, 30);

        passT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passTActionPerformed(evt);
            }
        });
        jPanel1.add(passT);
        passT.setBounds(370, 320, 280, 30);

        listBtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        listBtn.setText("List");
        listBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listBtnActionPerformed(evt);
            }
        });
        jPanel1.add(listBtn);
        listBtn.setBounds(520, 490, 120, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(934, 561));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        // TODO add your handling code here:
        if (idT.getText().trim().isEmpty() &&
            nameT.getText().trim().isEmpty() &&
            passT.getText().trim().isEmpty() &&
            phnT.getText().trim().isEmpty())
        {
            requiredId.setText("**Required");
            requiredname.setText("**Required");
            requiredpass.setText("**Required");
            requiredphn.setText("**Required");
        }
        else if (nameT.getText().trim().isEmpty() &&
            passT.getText().trim().isEmpty() &&
            phnT.getText().trim().isEmpty())
        {
            requiredname.setText("**Required");
            requiredpass.setText("**Required");
            requiredphn.setText("**Required");
            requiredId.setText("");
        }
        else if(nameT.getText().trim().isEmpty() &&
            idT.getText().trim().isEmpty() &&
            phnT.getText().trim().isEmpty())
        {
            requiredId.setText("**Required");
            requiredname.setText("**Required");
            requiredpass.setText("");
            requiredphn.setText("**Required");
        }
        else if(nameT.getText().trim().isEmpty() &&
            passT.getText().trim().isEmpty() &&
            idT.getText().trim().isEmpty())
        {
            requiredId.setText("**Required");
            requiredname.setText("**Required");
            requiredpass.setText("**Required");
            requiredphn.setText("");
        }
        else if (idT.getText().trim().isEmpty() &&
            passT.getText().trim().isEmpty() &&
            phnT.getText().trim().isEmpty())
        {
            requiredId.setText("**Required");
            requiredname.setText("");
            requiredpass.setText("**Required");
            requiredphn.setText("**Required");
        }
        else if (idT.getText().trim().isEmpty() &&
            nameT.getText().trim().isEmpty())
        {
            requiredId.setText("**Required");
            requiredname.setText("**Required");
            requiredpass.setText("");
            requiredphn.setText("");
        }
        else if (idT.getText().trim().isEmpty() &&
            passT.getText().trim().isEmpty() )
        {
            requiredId.setText("**Required");
            requiredpass.setText("**Required");
            requiredname.setText("");
            requiredphn.setText("");
        }
        else if (idT.getText().trim().isEmpty() &&
            phnT.getText().trim().isEmpty())
        {
            requiredId.setText("");
            requiredname.setText("**Required");
            requiredpass.setText("**Required");
            requiredphn.setText("");
        }
        else if (nameT.getText().trim().isEmpty() &&
            idT.getText().trim().isEmpty())
        {
            requiredname.setText("**Required");
            requiredpass.setText("");
            requiredId.setText("**Required");
            requiredphn.setText("");
        }
        else if (nameT.getText().trim().isEmpty() &&
            passT.getText().trim().isEmpty())
        {
            requiredname.setText("**Required");
            requiredpass.setText("**Required");
            requiredId.setText("");
            requiredphn.setText("");
        }

        else if (passT.getText().trim().isEmpty() &&
            phnT.getText().trim().isEmpty())
        {
            requiredId.setText("");
            requiredname.setText("");
            requiredpass.setText("**Required");
            requiredphn.setText("**Required");
        }
        else if(nameT.getText().trim().isEmpty() &&
            phnT.getText().trim().isEmpty())
        {
            requiredId.setText("");
            requiredname.setText("**Required");
            requiredpass.setText("");
            requiredphn.setText("**Required");
        }
        else if(idT.getText().trim().isEmpty() &&
            phnT.getText().trim().isEmpty())
        {
            requiredId.setText("");
            requiredname.setText("**Required");
            requiredpass.setText("**Required");
            requiredphn.setText("");
        }
        else if (idT.getText().trim().isEmpty())
        {
            requiredId.setText("**Required");
            requiredname.setText("");
            requiredpass.setText("");
            requiredphn.setText("");
        }
        else if (nameT.getText().trim().isEmpty())
        {
            requiredId.setText("");
            requiredname.setText("**Required");
            requiredpass.setText("");
            requiredphn.setText("");
        }
        else if (passT.getText().trim().isEmpty())
        {
            requiredId.setText("");
            requiredname.setText("");
            requiredpass.setText("**Required");
            requiredphn.setText("");
        }
        else if (phnT.getText().trim().isEmpty())
        {
            requiredId.setText("");
            requiredname.setText("");
            requiredpass.setText("");
            requiredphn.setText("**Required");
        }
        else
        {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection connection = DriverManager
                .getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=BOPMS;"
                    + "selectMethod=cursor", "sa", "123456");

                String sql = "Insert into admin(adminId,adminName,adminEmail,"
                + "adminPassword,adminAddress,"
                + "adminPhone) "
                + "values(?,?,?,?,?,?)";
                
                PreparedStatement pst = connection.prepareStatement(sql);
                
                pst.setString(1, idT.getText());
                pst.setString(2, nameT.getText());
                pst.setString(3, mailT.getText());
                pst.setString(4, passT.getText());
                pst.setString(5, addrssT.getText());
                pst.setString(6, phnT.getText());
                
                
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Added Successfully");

                idT.setText("");
                nameT.setText("");
                mailT.setText("");
                passT.setText("");
                addrssT.setText("");
                phnT.setText("");

            }
            catch (ClassNotFoundException | SQLException e) {
                
            }
        }
    }//GEN-LAST:event_submitBtnActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_exitBtnActionPerformed

    private void passTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passTActionPerformed

    private void listBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBtnActionPerformed
        // TODO add your handling code here:
        adminList adminList = new adminList();
        adminList.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_listBtnActionPerformed

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
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addrssT;
    private javax.swing.JButton exitBtn;
    private javax.swing.JTextField idT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton listBtn;
    private javax.swing.JTextField mailT;
    private javax.swing.JTextField nameT;
    private javax.swing.JPasswordField passT;
    private javax.swing.JTextField phnT;
    private javax.swing.JLabel registerL;
    private javax.swing.JLabel requiredId;
    private javax.swing.JLabel requiredname;
    private javax.swing.JLabel requiredpass;
    private javax.swing.JLabel requiredphn;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
}