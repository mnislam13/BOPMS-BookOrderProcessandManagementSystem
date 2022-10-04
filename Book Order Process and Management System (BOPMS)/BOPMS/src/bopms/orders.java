/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdummy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class orders extends javax.swing.JFrame {

    Connection connection;
    
    /**
     * Creates new form perOrder
     */
    public orders() {
        initComponents();
        show_o();
    }
    
    
    public ArrayList<ordersDisplay> oList()
    {
        ArrayList<ordersDisplay> oList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
            .getConnection(
             "jdbc:sqlserver://localhost:1433;databaseName=dbBOPMS;"
               + "selectMethod=cursor", "sa", "123456");


            //String sql = "SELECT customerId, customerName, customerEmail, customerAddress, customerPhone, customerType, SUM(totalIncome) FROM perPerchaseOrder AS P JOIN customer AS C ON P.customerId=C.customerId GROUP BY C.customerId" ;  
            String sql = "SELECT * FROM perPerchaseOrder AS P INNER JOIN customer AS C ON "
                    + "P.customerId=C.customerId WHERE P.poId LIKE 'P%' AND deliveredOrNot="+0;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ordersDisplay od;
            while(rs.next()){
                od = new ordersDisplay(rs.getString("poId"),
                    rs.getString("customerName"),
                    rs.getString("customerEmail"),
                    rs.getDate("poDate"),
                    rs.getDate("deliveryDate"));
                   oList.add(od);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oList;
    }
        
    public void show_o(){
    ArrayList<ordersDisplay> list = oList();
    DefaultTableModel model = (DefaultTableModel)ordersInfo.getModel();
    Object[] row = new Object[7];
    for(int i = 0; i < list.size(); i++)
    {
        row[0] = list.get(i).getoid();
        row[1] = list.get(i).getcusname();
        row[2] = list.get(i).getcusphn();
        row[3] = list.get(i).getodate();
        row[4] = list.get(i).getddate();

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

        jButton1 = new javax.swing.JButton();
        peroerderPanel = new javax.swing.JPanel();
        perorderLabel = new javax.swing.JLabel();
        perorderExitButton = new javax.swing.JButton();
        backButtonperorder = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ordersInfo = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        peroerderPanel.setBackground(new java.awt.Color(85, 104, 138));
        peroerderPanel.setLayout(null);

        perorderLabel.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        perorderLabel.setForeground(new java.awt.Color(255, 255, 255));
        perorderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        perorderLabel.setText("ORDERS");
        peroerderPanel.add(perorderLabel);
        perorderLabel.setBounds(240, 10, 160, 40);

        perorderExitButton.setBackground(new java.awt.Color(255, 255, 255));
        perorderExitButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        perorderExitButton.setText("X");
        perorderExitButton.setMaximumSize(new java.awt.Dimension(10, 19));
        perorderExitButton.setMinimumSize(new java.awt.Dimension(10, 19));
        perorderExitButton.setPreferredSize(new java.awt.Dimension(10, 19));
        perorderExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perorderExitButtonActionPerformed(evt);
            }
        });
        peroerderPanel.add(perorderExitButton);
        perorderExitButton.setBounds(584, 0, 50, 30);

        backButtonperorder.setBackground(new java.awt.Color(255, 255, 255));
        backButtonperorder.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        backButtonperorder.setText("<");
        backButtonperorder.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backButtonperorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonperorderActionPerformed(evt);
            }
        });
        peroerderPanel.add(backButtonperorder);
        backButtonperorder.setBounds(570, 580, 60, 32);

        ordersInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Customer Name", "Customer Phone", "Ordered Date", "Delivery Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ordersInfo);

        peroerderPanel.add(jScrollPane1);
        jScrollPane1.setBounds(30, 110, 570, 330);

        jButton2.setText("Deliver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        peroerderPanel.add(jButton2);
        jButton2.setBounds(450, 500, 140, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(peroerderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(peroerderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(634, 617));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void perorderExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perorderExitButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_perorderExitButtonActionPerformed

    private void backButtonperorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonperorderActionPerformed
        // TODO add your handling code here:
        homePage homePage = new homePage();
        homePage . setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backButtonperorderActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel)ordersInfo.getModel();
        Object[] row = new Object[7];
        
        int index = ordersInfo.getSelectedRow();
        
        String order = (String) ordersInfo.getValueAt(index, 0);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager
            .getConnection(
             "jdbc:sqlserver://localhost:1433;databaseName=dbBOPMS;"
               + "selectMethod=cursor", "sa", "123456");
            
                String sql = "UPDATE perPerchaseOrder SET deliveredOrNot="+1+
                            " WHERE poId = '"+order+"'";
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Delivered!");
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(orders.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(orders.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new orders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButtonperorder;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable ordersInfo;
    private javax.swing.JPanel peroerderPanel;
    private javax.swing.JButton perorderExitButton;
    private javax.swing.JLabel perorderLabel;
    // End of variables declaration//GEN-END:variables
}