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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TUSHAR MUHAMMAD
 */
public class addNewBooks extends javax.swing.JFrame {
    
    public boolean supplyRunning = bookSupplies.supplyRunning;
    
    public static String bookisbn;
    public static String bookname;
    public static String bookauthor;
    public static String bookpublisher;
    public static String bookcategory;
    public static String buyingprice;
    public static String sellingprice;
    public static String stocks;
    
    public static boolean addTable=true;

    /**
     * Creates new form addNewBooks
     */
    public addNewBooks() {
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

        booksPanel = new javax.swing.JPanel();
        booksLabel = new javax.swing.JLabel();
        booksExitButton = new javax.swing.JButton();
        backButtonBooks = new javax.swing.JButton();
        isbnT = new javax.swing.JTextField();
        addBook_notice = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bookNameT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        bookAuthorT = new javax.swing.JTextField();
        bookPublisherT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        buyingPriceT = new javax.swing.JTextField();
        addBook = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        sellingPriceT = new javax.swing.JTextField();
        bookCategoryT = new javax.swing.JTextField();
        checkBook = new javax.swing.JButton();
        backButtonAccount = new javax.swing.JButton();
        stocksT = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);

        booksPanel.setBackground(new java.awt.Color(85, 104, 138));
        booksPanel.setPreferredSize(new java.awt.Dimension(1017, 704));
        booksPanel.setLayout(null);

        booksLabel.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        booksLabel.setForeground(new java.awt.Color(255, 255, 255));
        booksLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        booksLabel.setText("ADD NEW BOOK");
        booksPanel.add(booksLabel);
        booksLabel.setBounds(170, 10, 326, 40);

        booksExitButton.setBackground(new java.awt.Color(255, 255, 255));
        booksExitButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        booksExitButton.setText("X");
        booksExitButton.setMaximumSize(new java.awt.Dimension(10, 19));
        booksExitButton.setMinimumSize(new java.awt.Dimension(10, 19));
        booksExitButton.setPreferredSize(new java.awt.Dimension(10, 19));
        booksExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                booksExitButtonActionPerformed(evt);
            }
        });
        booksPanel.add(booksExitButton);
        booksExitButton.setBounds(580, 10, 50, 30);

        backButtonBooks.setBackground(new java.awt.Color(255, 255, 255));
        backButtonBooks.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        backButtonBooks.setText("Book List");
        backButtonBooks.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backButtonBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonBooksActionPerformed(evt);
            }
        });
        booksPanel.add(backButtonBooks);
        backButtonBooks.setBounds(230, 600, 100, 32);

        isbnT.setFont(new java.awt.Font("Adobe Gothic Std B", 0, 18)); // NOI18N
        isbnT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isbnTActionPerformed(evt);
            }
        });
        isbnT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                isbnTKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                isbnTKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                isbnTKeyTyped(evt);
            }
        });
        booksPanel.add(isbnT);
        isbnT.setBounds(230, 130, 290, 30);

        addBook_notice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addBook_notice.setForeground(new java.awt.Color(204, 0, 51));
        booksPanel.add(addBook_notice);
        addBook_notice.setBounds(90, 620, 260, 30);

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Book Name:");
        booksPanel.add(jLabel2);
        jLabel2.setBounds(30, 190, 130, 30);

        bookNameT.setFont(new java.awt.Font("Adobe Gothic Std B", 0, 18)); // NOI18N
        bookNameT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookNameTActionPerformed(evt);
            }
        });
        booksPanel.add(bookNameT);
        bookNameT.setBounds(230, 190, 390, 30);

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Author:");
        booksPanel.add(jLabel3);
        jLabel3.setBounds(80, 250, 80, 30);

        bookAuthorT.setFont(new java.awt.Font("Adobe Gothic Std B", 0, 18)); // NOI18N
        bookAuthorT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookAuthorTActionPerformed(evt);
            }
        });
        booksPanel.add(bookAuthorT);
        bookAuthorT.setBounds(230, 250, 390, 30);

        bookPublisherT.setFont(new java.awt.Font("Adobe Gothic Std B", 0, 18)); // NOI18N
        bookPublisherT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookPublisherTActionPerformed(evt);
            }
        });
        booksPanel.add(bookPublisherT);
        bookPublisherT.setBounds(230, 310, 390, 30);

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Publisher:");
        booksPanel.add(jLabel5);
        jLabel5.setBounds(60, 310, 110, 30);

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Category:");
        booksPanel.add(jLabel6);
        jLabel6.setBounds(60, 370, 110, 30);

        buyingPriceT.setFont(new java.awt.Font("Adobe Gothic Std B", 0, 18)); // NOI18N
        buyingPriceT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyingPriceTActionPerformed(evt);
            }
        });
        booksPanel.add(buyingPriceT);
        buyingPriceT.setBounds(230, 430, 390, 30);

        addBook.setText("SUBMIT");
        addBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookActionPerformed(evt);
            }
        });
        booksPanel.add(addBook);
        addBook.setBounds(510, 600, 100, 30);

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ISBN:");
        booksPanel.add(jLabel4);
        jLabel4.setBounds(100, 130, 60, 30);

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Buying Price:");
        booksPanel.add(jLabel7);
        jLabel7.setBounds(20, 430, 150, 30);

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Selling Price:");
        booksPanel.add(jLabel8);
        jLabel8.setBounds(20, 490, 150, 30);

        sellingPriceT.setFont(new java.awt.Font("Adobe Gothic Std B", 0, 18)); // NOI18N
        sellingPriceT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellingPriceTActionPerformed(evt);
            }
        });
        booksPanel.add(sellingPriceT);
        sellingPriceT.setBounds(230, 490, 390, 30);

        bookCategoryT.setFont(new java.awt.Font("Adobe Gothic Std B", 0, 18)); // NOI18N
        bookCategoryT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookCategoryTActionPerformed(evt);
            }
        });
        booksPanel.add(bookCategoryT);
        bookCategoryT.setBounds(230, 370, 390, 30);

        checkBook.setText("CHECK");
        checkBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBookActionPerformed(evt);
            }
        });
        booksPanel.add(checkBook);
        checkBook.setBounds(530, 130, 90, 30);

        backButtonAccount.setBackground(new java.awt.Color(255, 255, 255));
        backButtonAccount.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        backButtonAccount.setText("Home");
        backButtonAccount.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backButtonAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonAccountActionPerformed(evt);
            }
        });
        booksPanel.add(backButtonAccount);
        backButtonAccount.setBounds(20, 10, 80, 32);

        stocksT.setFont(new java.awt.Font("Adobe Gothic Std B", 0, 18)); // NOI18N
        stocksT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stocksTActionPerformed(evt);
            }
        });
        booksPanel.add(stocksT);
        stocksT.setBounds(230, 540, 390, 30);

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Stocks:");
        booksPanel.add(jLabel9);
        jLabel9.setBounds(80, 540, 90, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(booksPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(booksPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(658, 676));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void booksExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booksExitButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_booksExitButtonActionPerformed

    private void backButtonBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonBooksActionPerformed
        // TODO add your handling code here:

        books books = new books();
        books.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_backButtonBooksActionPerformed

    private void isbnTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isbnTActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_isbnTActionPerformed

    private void bookNameTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookNameTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookNameTActionPerformed

    private void bookAuthorTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookAuthorTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookAuthorTActionPerformed

    private void bookPublisherTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookPublisherTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookPublisherTActionPerformed

    private void buyingPriceTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyingPriceTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buyingPriceTActionPerformed

    private void addBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookActionPerformed
        bookisbn = isbnT.getText();
        bookname= bookNameT.getText();
        bookauthor = bookAuthorT.getText();
        bookpublisher = bookPublisherT.getText();
        bookcategory = bookCategoryT.getText();
        buyingprice = buyingPriceT.getText();
        sellingprice = sellingPriceT.getText();
        stocks = stocksT.getText();
        
        if(bookisbn.isEmpty() || bookname.isEmpty() || bookauthor.isEmpty() || bookpublisher.isEmpty() ||
                bookcategory.isEmpty() || buyingprice.isEmpty() || sellingprice.isEmpty() || stocks.isEmpty()){
            
            JOptionPane.showMessageDialog(null,"Please fill all fields");
        }
        else{
            float buyingPrice=Float.parseFloat(buyingprice);
            float sellingPrice=Float.parseFloat(sellingprice);
            int Stocks=Integer.parseInt(stocks);
            try {

                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
                        + "databaseName=dbBOPMS;selectMethod=cursor", "sa", "123456");
                
                String sql = "Insert into books(bookISBN,bookName,bookAuthor,"
                        + "bookPublisher,bookCategory,"
                        + "buyingPrice,sellingPrice,stocks) "
                        + "values(?,?,?,?,?,?,?,?)";

                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setString(1, bookisbn);
                pst.setString(2, bookname);
                pst.setString(3, bookauthor);
                pst.setString(4, bookpublisher);
                pst.setString(5, bookcategory);
                pst.setFloat(6, buyingPrice);
                pst.setFloat(7, sellingPrice);
                pst.setInt(8, Stocks);

                pst.executeUpdate();
                
             

                addBook_notice.setText("Book is added Successfully");
                //dispose();
                isbnT.setText("");
                bookNameT.setText("");
                bookAuthorT.setText("");
                bookPublisherT.setText("");
                bookCategoryT.setText("");
                buyingPriceT.setText("");
                sellingPriceT.setText("");
                stocksT.setText("");
                
                if(supplyRunning==true) {
                    bookSupplies bookSupplies = new bookSupplies();
                    bookSupplies.setVisible(true);
                    this.setVisible(false);
                }

            } catch (ClassNotFoundException | SQLException e) {
            }
            
        }

    }//GEN-LAST:event_addBookActionPerformed

    private void sellingPriceTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellingPriceTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sellingPriceTActionPerformed

    private void bookCategoryTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookCategoryTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookCategoryTActionPerformed

    private void isbnTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_isbnTKeyReleased
        
            
            
        
    }//GEN-LAST:event_isbnTKeyReleased

    private void isbnTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_isbnTKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_isbnTKeyTyped

    private void checkBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBookActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String bookisbn = isbnT.getText();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
                    + "databaseName=dbBOPMS;selectMethod=cursor", "sa", "123456");
            
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT bookISBN FROM books");
            int check=0;
            while (resultSet.next()) {
                
                if(resultSet.getString("bookISBN").equalsIgnoreCase(bookisbn)){
                addBook_notice.setText("Book already exists");
                isbnT.setText("");
                check = 1;
            }
            
            } 
            if(check==0){
                addBook_notice.setText("Enter All Info And Submit");
            }
            
        }
        catch (ClassNotFoundException | SQLException e) {
            }
    }//GEN-LAST:event_checkBookActionPerformed

    private void isbnTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_isbnTKeyPressed
        // TODO add your handling code here:
        addBook_notice.setText("");
    }//GEN-LAST:event_isbnTKeyPressed

    private void backButtonAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonAccountActionPerformed
        // TODO add your handling code here:
        homePage homePage = new homePage();
        homePage . setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backButtonAccountActionPerformed

    private void stocksTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stocksTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stocksTActionPerformed

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
            java.util.logging.Logger.getLogger(addNewBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addNewBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addNewBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addNewBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addNewBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBook;
    private javax.swing.JLabel addBook_notice;
    private javax.swing.JButton backButtonAccount;
    private javax.swing.JButton backButtonBooks;
    private javax.swing.JTextField bookAuthorT;
    private javax.swing.JTextField bookCategoryT;
    private javax.swing.JTextField bookNameT;
    private javax.swing.JTextField bookPublisherT;
    private javax.swing.JButton booksExitButton;
    private javax.swing.JLabel booksLabel;
    private javax.swing.JPanel booksPanel;
    private javax.swing.JTextField buyingPriceT;
    private javax.swing.JButton checkBook;
    private javax.swing.JTextField isbnT;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField sellingPriceT;
    private javax.swing.JTextField stocksT;
    // End of variables declaration//GEN-END:variables
}