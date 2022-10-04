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
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author user
 */
public class customers extends javax.swing.JFrame {

    public static String cusid;
    public static String cusname;
    public static String cusmail;
    public static String cusaddrss;
    public static String custyp;
    public static String cusphn;
    


   

    /**
     * Creates new form customers
     */
    public customers() {
        initComponents();
        DefaultTableModel model = (DefaultTableModel)cusInfo.getModel();
        model.setRowCount(0);  
        show_cus();
    }
    
    public ArrayList<customerDisplay> cusList()
    {
        ArrayList<customerDisplay> cusList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
            .getConnection(
             "jdbc:sqlserver://localhost:1433;databaseName=dbBOPMS;"
               + "selectMethod=cursor", "sa", "123456");


            //String sql = "SELECT customerId, customerName, customerEmail, customerAddress, customerPhone, customerType, SUM(totalIncome) FROM perPerchaseOrder AS P JOIN customer AS C ON P.customerId=C.customerId GROUP BY C.customerId" ;  
            
            String sql = "SELECT b.customerId,b.customerName,b.customerEmail,b.customerAddress,b.customerPhone,b.customerType,"+
            "SUM(a.totalIncome) as totalIncome "+ 
            "FROM perPerchaseOrder AS a INNER JOIN customer As b ON a.customerId=b.customerId "+
            "GROUP BY b.customerId,b.customerName, b.customerEmail, b.customerAddress, b.customerPhone, b.customerType";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            customerDisplay cus;
            while(rs.next()){
                cus = new customerDisplay(rs.getString("customerId"),
                    rs.getString("customerName"),
                    rs.getString("customerEmail"),
                    rs.getString("customerAddress"),
                    rs.getString("customerPhone"),
                    rs.getString("customerType"),
                    rs.getFloat("totalIncome"));
                   cusList.add(cus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cusList;
    }
        
    public void show_cus(){
    ArrayList<customerDisplay> list = cusList();
    DefaultTableModel model = (DefaultTableModel)cusInfo.getModel();
    Object[] row = new Object[7];
    for(int i = 0; i < list.size(); i++)
    {
        row[0] = list.get(i).getid();
        row[1] = list.get(i).getname();
        row[2] = list.get(i).getmail();
        row[3] = list.get(i).getaddrss();
        row[4] = list.get(i).getphn();
        row[5] = list.get(i).gettyp();
        row[6] = list.get(i).getincome();
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

        customersPanel = new javax.swing.JPanel();
        customersLabel = new javax.swing.JLabel();
        customersExitButton = new javax.swing.JButton();
        backButtonCustomers = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cusInfo = new javax.swing.JTable();
        updatCusBtn = new javax.swing.JButton();
        deleteCusBtn = new javax.swing.JButton();
        searchCusT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(634, 497));
        setResizable(false);

        customersPanel.setBackground(new java.awt.Color(85, 104, 138));
        customersPanel.setLayout(null);

        customersLabel.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        customersLabel.setForeground(new java.awt.Color(255, 255, 255));
        customersLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        customersLabel.setText("CUSTOMER LIST");
        customersPanel.add(customersLabel);
        customersLabel.setBounds(360, 30, 310, 48);

        customersExitButton.setBackground(new java.awt.Color(255, 255, 255));
        customersExitButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        customersExitButton.setText("X");
        customersExitButton.setMaximumSize(new java.awt.Dimension(10, 19));
        customersExitButton.setMinimumSize(new java.awt.Dimension(10, 19));
        customersExitButton.setPreferredSize(new java.awt.Dimension(10, 19));
        customersExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customersExitButtonActionPerformed(evt);
            }
        });
        customersPanel.add(customersExitButton);
        customersExitButton.setBounds(960, 0, 50, 30);

        backButtonCustomers.setBackground(new java.awt.Color(255, 255, 255));
        backButtonCustomers.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        backButtonCustomers.setText("<");
        backButtonCustomers.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backButtonCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonCustomersActionPerformed(evt);
            }
        });
        customersPanel.add(backButtonCustomers);
        backButtonCustomers.setBounds(10, 0, 60, 32);

        cusInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Email", "Address", "Phone No.", "Type", "Income"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cusInfo.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(cusInfo);
        cusInfo.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        customersPanel.add(jScrollPane1);
        jScrollPane1.setBounds(20, 150, 980, 440);

        updatCusBtn.setText("Update");
        updatCusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatCusBtnActionPerformed(evt);
            }
        });
        customersPanel.add(updatCusBtn);
        updatCusBtn.setBounds(760, 650, 73, 30);

        deleteCusBtn.setText("Delete");
        deleteCusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCusBtnActionPerformed(evt);
            }
        });
        customersPanel.add(deleteCusBtn);
        deleteCusBtn.setBounds(880, 650, 70, 30);

        searchCusT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCusTActionPerformed(evt);
            }
        });
        searchCusT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchCusTKeyReleased(evt);
            }
        });
        customersPanel.add(searchCusT);
        searchCusT.setBounds(150, 650, 350, 30);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search Here:");
        customersPanel.add(jLabel1);
        jLabel1.setBounds(20, 650, 130, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1017, 745));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void customersExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customersExitButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_customersExitButtonActionPerformed

    private void backButtonCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonCustomersActionPerformed
        // TODO add your handling code here:
        homePage homePage = new homePage();
        homePage . setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backButtonCustomersActionPerformed

    private void searchCusTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCusTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchCusTActionPerformed

    private void deleteCusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCusBtnActionPerformed
        // TODO add your handling code here:
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?",
                "Delete",JOptionPane.YES_NO_OPTION);
        if(opt == 0){
            try {
                
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection connection = DriverManager
                .getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=dbBOPMS;"
                            + "selectMethod=cursor", "sa", "123456");

                TableModel model = cusInfo.getModel();
                int i = cusInfo.getSelectedRow();
                
                
                String cusId = (String) model.getValueAt(i, 0);
                String sql = "Delete From customer where customerId='"+cusId+"'";
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.executeUpdate();
                DefaultTableModel Model = (DefaultTableModel)cusInfo.getModel();
                Model.setRowCount(0);
                show_cus();
                JOptionPane.showMessageDialog(null, "Deleted Successfully!");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_deleteCusBtnActionPerformed

    private void searchCusTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchCusTKeyReleased
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)cusInfo.getModel();
        String search = searchCusT.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        cusInfo.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_searchCusTKeyReleased

    private void updatCusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatCusBtnActionPerformed
        // TODO add your handling code here:
        TableModel model = cusInfo.getModel();
        int i = cusInfo.getSelectedRow();
        cusid = (String) model.getValueAt(i, 0);
        cusname = (String) model.getValueAt(i, 1);
        cusmail = (String) model.getValueAt(i, 2);
        cusaddrss = (String) model.getValueAt(i, 3);
        cusphn = (String) model.getValueAt(i, 4);
        custyp = (String) model.getValueAt(i, 5);
        
        
        
        updateCustomer updateCustomer = new updateCustomer();
        updateCustomer . setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_updatCusBtnActionPerformed

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
            java.util.logging.Logger.getLogger(customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new customers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButtonCustomers;
    private javax.swing.JTable cusInfo;
    private javax.swing.JButton customersExitButton;
    private javax.swing.JLabel customersLabel;
    private javax.swing.JPanel customersPanel;
    private javax.swing.JButton deleteCusBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchCusT;
    private javax.swing.JButton updatCusBtn;
    // End of variables declaration//GEN-END:variables
}
