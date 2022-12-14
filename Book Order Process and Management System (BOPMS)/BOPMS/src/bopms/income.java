package dbdummy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author user
 */
public class income extends javax.swing.JFrame {
    
    public String tframe="DAY";

    /**
     * Creates new form income
     */
    public income() {
        initComponents();
        DefaultTableModel model = (DefaultTableModel)incomeInfo.getModel();
        model.setRowCount(0);  
        show_income();
    }
    
    public ArrayList<incomeDisplay> incomeList()
    {
        ArrayList<incomeDisplay> incomeList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
            .getConnection(
             "jdbc:sqlserver://localhost:1433;databaseName=dbBOPMS;"
               + "selectMethod=cursor", "sa", "123456");
            

            String sql = "SELECT DATEPART("+tframe+",poDate) AS PERDAY, SUM(totalIncome) AS INCOME FROM perPerchaseOrder GROUP BY DATEPART("+tframe+",poDate)";

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            incomeDisplay income;
            while(rs.next()){
                income = new incomeDisplay(rs.getInt("PERDAY"),
                    rs.getFloat("INCOME")); 
                    incomeList.add(income);
                   
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return incomeList;
    }
        
    public void show_income(){
    ArrayList<incomeDisplay> list = incomeList();
    DefaultTableModel model = (DefaultTableModel)incomeInfo.getModel();
    Object[] row = new Object[2];
    for(int i = 0; i < list.size(); i++)
    {
        row[0] = list.get(i).gettimeframe();
        row[1] = list.get(i).getamount();
        
        model.addRow(row); 
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

        incomePanel = new javax.swing.JPanel();
        incomeLabel = new javax.swing.JLabel();
        incomeExitButton = new javax.swing.JButton();
        backButtonIncome = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        incomeInfo = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        abc = new javax.swing.JComboBox<>();
        okBtnincome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        incomePanel.setBackground(new java.awt.Color(85, 104, 138));
        incomePanel.setLayout(null);

        incomeLabel.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        incomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        incomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        incomeLabel.setText("INCOME");
        incomePanel.add(incomeLabel);
        incomeLabel.setBounds(230, 10, 326, 40);

        incomeExitButton.setBackground(new java.awt.Color(255, 255, 255));
        incomeExitButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        incomeExitButton.setText("X");
        incomeExitButton.setMaximumSize(new java.awt.Dimension(10, 19));
        incomeExitButton.setMinimumSize(new java.awt.Dimension(10, 19));
        incomeExitButton.setPreferredSize(new java.awt.Dimension(10, 19));
        incomeExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incomeExitButtonActionPerformed(evt);
            }
        });
        incomePanel.add(incomeExitButton);
        incomeExitButton.setBounds(680, 0, 50, 30);

        backButtonIncome.setBackground(new java.awt.Color(255, 255, 255));
        backButtonIncome.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        backButtonIncome.setText("<");
        backButtonIncome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backButtonIncome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonIncomeActionPerformed(evt);
            }
        });
        incomePanel.add(backButtonIncome);
        backButtonIncome.setBounds(0, 0, 60, 32);

        incomeInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TimeFrame", "Total Sell Amount"
            }
        ));
        jScrollPane1.setViewportView(incomeInfo);

        incomePanel.add(jScrollPane1);
        jScrollPane1.setBounds(50, 150, 630, 370);

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Total Sell Amount PER");
        incomePanel.add(jLabel4);
        jLabel4.setBounds(50, 80, 350, 30);

        abc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DAY", "MONTH", "YEAR" }));
        abc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                abcItemStateChanged(evt);
            }
        });
        abc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abcMouseClicked(evt);
            }
        });
        abc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abcActionPerformed(evt);
            }
        });
        incomePanel.add(abc);
        abc.setBounds(430, 80, 240, 30);

        okBtnincome.setText("OK");
        okBtnincome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnincomeActionPerformed(evt);
            }
        });
        incomePanel.add(okBtnincome);
        okBtnincome.setBounds(300, 560, 130, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(incomePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(incomePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(731, 621));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void incomeExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incomeExitButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_incomeExitButtonActionPerformed

    private void backButtonIncomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonIncomeActionPerformed
        // TODO add your handling code here:
        homePage homePage = new homePage();
        homePage . setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backButtonIncomeActionPerformed

    private void okBtnincomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnincomeActionPerformed
        // TODO add your handling code here:
        homePage homePage = new homePage();
        homePage.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_okBtnincomeActionPerformed

    private void abcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abcActionPerformed
        // TODO add your handling code here:
         tframe = (String) abc.getSelectedItem().toString();
         DefaultTableModel table = (DefaultTableModel)incomeInfo.getModel();
        table.setRowCount(0);
        show_income();
    }//GEN-LAST:event_abcActionPerformed

    private void abcItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_abcItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_abcItemStateChanged

    private void abcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abcMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_abcMouseClicked

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
            java.util.logging.Logger.getLogger(income.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(income.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(income.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(income.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new income().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> abc;
    private javax.swing.JButton backButtonIncome;
    private javax.swing.JButton incomeExitButton;
    private javax.swing.JTable incomeInfo;
    private javax.swing.JLabel incomeLabel;
    private javax.swing.JPanel incomePanel;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okBtnincome;
    // End of variables declaration//GEN-END:variables
}
