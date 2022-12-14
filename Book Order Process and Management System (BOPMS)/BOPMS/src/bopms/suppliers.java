package dbdummy;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author user
 */
public class suppliers extends javax.swing.JFrame {

    public static String suplrid;
    public static String suplrname;
    public static String suplrmail;
    public static String suplrphn;
  
    
    /**
     * Creates new form suppliers
     */
    public suppliers() {
        initComponents();
        DefaultTableModel model;
        model = (DefaultTableModel)suplrInfo.getModel();
        model.setRowCount(0);  
        show_suplr();
    }
    
    public ArrayList<supplierDisplay> suplrList()
    {
        ArrayList<supplierDisplay> suplrList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
            .getConnection(
             "jdbc:sqlserver://localhost:1433;databaseName=dbBOPMS;"
               + "selectMethod=cursor", "sa", "123456");


            String sql = "Select * from supplier";  
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            supplierDisplay suplr;
            while(rs.next()){
                suplr = new supplierDisplay (rs.getString("supplierId"),
                        rs.getString("supplierName"),
                        rs.getString("supplierEmail"),
                        rs.getString("supplierPhone")); 
                   suplrList.add(suplr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return suplrList;
    }
    
     public void show_suplr(){
    ArrayList<supplierDisplay> list = suplrList();
    DefaultTableModel model = (DefaultTableModel)suplrInfo.getModel();
    Object[] row = new Object[4];
    for(int i = 0; i < list.size(); i++)
        {
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getname();
            row[2] = list.get(i).getmail();
            row[3] = list.get(i).getphn();
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

        suppliersPanel = new javax.swing.JPanel();
        suppliersLabel = new javax.swing.JLabel();
        suppliersExitButton = new javax.swing.JButton();
        backButtonSuppliers = new javax.swing.JButton();
        suplrlistBtn = new javax.swing.JButton();
        searchsuplrT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        suplrInfo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        suppliersPanel.setBackground(new java.awt.Color(85, 104, 138));
        suppliersPanel.setLayout(null);

        suppliersLabel.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        suppliersLabel.setForeground(new java.awt.Color(255, 255, 255));
        suppliersLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        suppliersLabel.setText("SUPPLIERS");
        suppliersPanel.add(suppliersLabel);
        suppliersLabel.setBounds(170, 10, 326, 70);

        suppliersExitButton.setBackground(new java.awt.Color(255, 255, 255));
        suppliersExitButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        suppliersExitButton.setText("X");
        suppliersExitButton.setMaximumSize(new java.awt.Dimension(10, 19));
        suppliersExitButton.setMinimumSize(new java.awt.Dimension(10, 19));
        suppliersExitButton.setPreferredSize(new java.awt.Dimension(10, 19));
        suppliersExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppliersExitButtonActionPerformed(evt);
            }
        });
        suppliersPanel.add(suppliersExitButton);
        suppliersExitButton.setBounds(590, 20, 50, 30);

        backButtonSuppliers.setBackground(new java.awt.Color(255, 255, 255));
        backButtonSuppliers.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        backButtonSuppliers.setText("<");
        backButtonSuppliers.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backButtonSuppliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonSuppliersActionPerformed(evt);
            }
        });
        suppliersPanel.add(backButtonSuppliers);
        backButtonSuppliers.setBounds(10, 10, 60, 32);

        suplrlistBtn.setText("Add Supplier");
        suplrlistBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suplrlistBtnActionPerformed(evt);
            }
        });
        suppliersPanel.add(suplrlistBtn);
        suplrlistBtn.setBounds(290, 410, 130, 50);

        searchsuplrT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchsuplrTActionPerformed(evt);
            }
        });
        searchsuplrT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchsuplrTKeyReleased(evt);
            }
        });
        suppliersPanel.add(searchsuplrT);
        searchsuplrT.setBounds(130, 420, 120, 30);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search Here:");
        suppliersPanel.add(jLabel1);
        jLabel1.setBounds(10, 420, 120, 30);

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        suppliersPanel.add(update);
        update.setBounds(470, 410, 110, 50);

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        suplrInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier ID", "Supplier Name", "Supplier Email", "Supplier Phone No."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        suplrInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suplrInfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(suplrInfo);
        if (suplrInfo.getColumnModel().getColumnCount() > 0) {
            suplrInfo.getColumnModel().getColumn(0).setResizable(false);
            suplrInfo.getColumnModel().getColumn(1).setResizable(false);
            suplrInfo.getColumnModel().getColumn(2).setResizable(false);
            suplrInfo.getColumnModel().getColumn(3).setResizable(false);
        }

        suppliersPanel.add(jScrollPane1);
        jScrollPane1.setBounds(40, 130, 540, 230);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(suppliersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(suppliersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(661, 497));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void suppliersExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppliersExitButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_suppliersExitButtonActionPerformed

    private void backButtonSuppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonSuppliersActionPerformed
        // TODO add your handling code here:
        homePage homePage = new homePage();
        homePage . setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backButtonSuppliersActionPerformed

    private void suplrlistBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suplrlistBtnActionPerformed
        // TODO add your handling code here:
        addSupplier addSupplier = new addSupplier();
        addSupplier.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_suplrlistBtnActionPerformed

    private void searchsuplrTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchsuplrTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchsuplrTActionPerformed

    private void searchsuplrTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchsuplrTKeyReleased
        // TODO add your handling code here:
       /* DefaultTableModel table = (DefaultTableModel)suplrInfo.getModel();
        String search = searchsuplrT.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        suplrInfo.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));*/
    }//GEN-LAST:event_searchsuplrTKeyReleased

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        TableModel model = suplrInfo.getModel();
        int i = suplrInfo.getSelectedRow();
        
        suplrid = (String) model.getValueAt(i, 0);
        suplrname = (String) model.getValueAt(i, 1);
        suplrmail = (String) model.getValueAt(i, 2);
        suplrphn = (String) model.getValueAt(i, 3);
        
        updateSupplier updateSupplier = new updateSupplier();
        updateSupplier.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_updateActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void suplrInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suplrInfoMouseClicked
        // TODO add your handling code here:
        int row = suplrInfo.getSelectedRow();
        TableModel model = suplrInfo.getModel();
    }//GEN-LAST:event_suplrInfoMouseClicked

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
            java.util.logging.Logger.getLogger(suppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(suppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(suppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(suppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new suppliers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButtonSuppliers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchsuplrT;
    private javax.swing.JTable suplrInfo;
    private javax.swing.JButton suplrlistBtn;
    private javax.swing.JButton suppliersExitButton;
    private javax.swing.JLabel suppliersLabel;
    private javax.swing.JPanel suppliersPanel;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
