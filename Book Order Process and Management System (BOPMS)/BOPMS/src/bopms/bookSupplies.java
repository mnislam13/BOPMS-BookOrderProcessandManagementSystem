package dbdummy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author user
 */
public class bookSupplies extends javax.swing.JFrame {
    
    
    Connection connection;
    public static boolean supplyRunning;
    
    public String adminID = loginAdmin.adminId;
    public String adminname = loginAdmin.adminname;
    
    public String bookisbn = addNewBooks.bookisbn;
    public String bookname = addNewBooks.bookname;
    public String bookauthor = addNewBooks.bookauthor;
    public String bookpublisher = addNewBooks.bookpublisher;
    public String bookcategory = addNewBooks.bookcategory;
    public String buyingprice = addNewBooks.buyingprice;
    public String sellingprice = addNewBooks.sellingprice;
    public String stocks = addNewBooks.stocks;
    
    int pieces;
    public static float totalprice;
    public static String supplyid;
    String totalPrice;
    int Stocks;
    float cost;
    public boolean addTable=addNewBooks.addTable;
    boolean cart;
    Date date;
    SimpleDateFormat formatter;
    Timer timer;
    boolean flagGen;
    

    /**
     * Creates new form perSupplies
     */
    public bookSupplies() {
        initComponents();
        flagGen=false;
        
        showadminT.setText(adminname);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formatter = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
                date = new Date();
                datetimeL.setText(formatter.format(date));
            }
            
        };
        timer = new Timer(1000, actionListener);
        timer.setInitialDelay(0);
        timer.start();
        
        if(addTable==true){
            isbnT.setText("");
            bookNameT.setText(bookname);
            bookAuthorT.setText(bookauthor);
            bookPublisherT.setText(bookpublisher);
            bookCategoryT.setText(bookcategory);
            buyingPriceT.setText(buyingprice);
            
            sellingPriceT.setText(sellingprice);
            stockT.setText(stocks);
            
        }
        
    }
    
    
    
    
    public void CancelSell(int a){
        if(supplyid!=""){

                
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection = DriverManager
                .getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=dbBOPMS;"
                            + "selectMethod=cursor", "sa", "123456");

                DefaultTableModel model2 = (DefaultTableModel) bookSupply.getModel(); 

                int rc = bookSupply.getRowCount();
                for(int i=rc-1; i>=a;i--){
                
                
                bookisbn = (String) model2.getValueAt(i, 0);
                String P = (String) model2.getValueAt(i, 2);
                model2.removeRow(i);
                JOptionPane.showMessageDialog(null, supplyid);
                pieces = Integer.parseInt(P);
                String sql = "DELETE FROM perSbooks WHERE supplyId='"+supplyid+"' AND bookISBN='"+bookisbn+"'";
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Deleted from db!");


                String sql2 = "UPDATE books SET stocks=(SELECT stocks FROM books WHERE bookISBN ='"+bookisbn+"')-"+pieces+
                            " WHERE bookISBN = '"+bookisbn+"'";
                pst = connection.prepareStatement(sql2);
                pst.executeUpdate();
                }
                
                if(a==0){

                    String sql = "DELETE FROM perSupplies WHERE supplyId='"+supplyid+"'"; 
                    PreparedStatement pst = connection.prepareStatement(sql);
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Emptied Successfully!");

                    supplyid="";
                    cart = false;

                }



            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
             
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

        persuppliesPanel = new javax.swing.JPanel();
        persuppliesLabel = new javax.swing.JLabel();
        persuppliesExitButton = new javax.swing.JButton();
        backButtonpersupplies = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        subtotalT = new javax.swing.JTextField();
        removeList = new javax.swing.JButton();
        emptylist = new javax.swing.JButton();
        confirmBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        isbnT = new javax.swing.JTextField();
        checkBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        bookNameT = new javax.swing.JTextField();
        bookAuthorT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bookPublisherT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bookCategoryT = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        buyingPriceT = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        sellingPriceT = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        stockT = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        addbookBtn = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        piecesT = new javax.swing.JSpinner();
        datetimeL = new javax.swing.JLabel();
        showadminT = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bookSupply = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        persuppliesPanel.setBackground(new java.awt.Color(85, 104, 138));
        persuppliesPanel.setLayout(null);

        persuppliesLabel.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        persuppliesLabel.setForeground(new java.awt.Color(255, 255, 255));
        persuppliesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        persuppliesLabel.setText("Book Supply");
        persuppliesPanel.add(persuppliesLabel);
        persuppliesLabel.setBounds(430, 0, 326, 48);

        persuppliesExitButton.setBackground(new java.awt.Color(255, 255, 255));
        persuppliesExitButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        persuppliesExitButton.setText("X");
        persuppliesExitButton.setMaximumSize(new java.awt.Dimension(10, 19));
        persuppliesExitButton.setMinimumSize(new java.awt.Dimension(10, 19));
        persuppliesExitButton.setPreferredSize(new java.awt.Dimension(10, 19));
        persuppliesExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                persuppliesExitButtonActionPerformed(evt);
            }
        });
        persuppliesPanel.add(persuppliesExitButton);
        persuppliesExitButton.setBounds(1150, 0, 50, 30);

        backButtonpersupplies.setBackground(new java.awt.Color(255, 255, 255));
        backButtonpersupplies.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        backButtonpersupplies.setText("<");
        backButtonpersupplies.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backButtonpersupplies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonpersuppliesActionPerformed(evt);
            }
        });
        persuppliesPanel.add(backButtonpersupplies);
        backButtonpersupplies.setBounds(0, 0, 60, 32);

        jLabel11.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Admin:");
        persuppliesPanel.add(jLabel11);
        jLabel11.setBounds(600, 70, 90, 20);

        jLabel10.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Date-Time:");
        persuppliesPanel.add(jLabel10);
        jLabel10.setBounds(600, 100, 130, 30);

        jLabel13.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("SUB TOTAL:");
        persuppliesPanel.add(jLabel13);
        jLabel13.setBounds(600, 470, 140, 40);

        subtotalT.setFont(new java.awt.Font("Adobe Gothic Std B", 0, 18)); // NOI18N
        subtotalT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subtotalTActionPerformed(evt);
            }
        });
        persuppliesPanel.add(subtotalT);
        subtotalT.setBounds(750, 470, 410, 40);

        removeList.setText("REMOVE FROM LIST");
        removeList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeListActionPerformed(evt);
            }
        });
        persuppliesPanel.add(removeList);
        removeList.setBounds(600, 540, 260, 30);

        emptylist.setText("EMPTY LIST");
        emptylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emptylistActionPerformed(evt);
            }
        });
        persuppliesPanel.add(emptylist);
        emptylist.setBounds(910, 540, 250, 30);

        confirmBtn.setText("CONFIRM");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });
        persuppliesPanel.add(confirmBtn);
        confirmBtn.setBounds(600, 590, 560, 70);

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("ISBN:");
        persuppliesPanel.add(jLabel4);
        jLabel4.setBounds(20, 140, 150, 30);

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
        persuppliesPanel.add(isbnT);
        isbnT.setBounds(180, 140, 280, 30);

        checkBtn.setText("CHECK");
        checkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBtnActionPerformed(evt);
            }
        });
        persuppliesPanel.add(checkBtn);
        checkBtn.setBounds(480, 140, 100, 30);

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Book Name:");
        persuppliesPanel.add(jLabel2);
        jLabel2.setBounds(20, 230, 150, 30);

        bookNameT.setEditable(false);
        bookNameT.setBackground(new java.awt.Color(204, 204, 204));
        bookNameT.setFont(new java.awt.Font("Adobe Gothic Std B", 0, 18)); // NOI18N
        bookNameT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookNameTActionPerformed(evt);
            }
        });
        persuppliesPanel.add(bookNameT);
        bookNameT.setBounds(180, 230, 400, 30);

        bookAuthorT.setEditable(false);
        bookAuthorT.setBackground(new java.awt.Color(204, 204, 204));
        bookAuthorT.setFont(new java.awt.Font("Adobe Gothic Std B", 0, 18)); // NOI18N
        bookAuthorT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookAuthorTActionPerformed(evt);
            }
        });
        persuppliesPanel.add(bookAuthorT);
        bookAuthorT.setBounds(180, 270, 400, 30);

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Author:");
        persuppliesPanel.add(jLabel5);
        jLabel5.setBounds(20, 270, 150, 30);

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Publisher:");
        persuppliesPanel.add(jLabel6);
        jLabel6.setBounds(20, 310, 150, 30);

        bookPublisherT.setEditable(false);
        bookPublisherT.setBackground(new java.awt.Color(204, 204, 204));
        bookPublisherT.setFont(new java.awt.Font("Adobe Gothic Std B", 0, 18)); // NOI18N
        bookPublisherT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookPublisherTActionPerformed(evt);
            }
        });
        persuppliesPanel.add(bookPublisherT);
        bookPublisherT.setBounds(180, 310, 400, 30);

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Category:");
        persuppliesPanel.add(jLabel8);
        jLabel8.setBounds(20, 350, 150, 30);

        bookCategoryT.setEditable(false);
        bookCategoryT.setBackground(new java.awt.Color(204, 204, 204));
        bookCategoryT.setFont(new java.awt.Font("Adobe Gothic Std B", 0, 18)); // NOI18N
        bookCategoryT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookCategoryTActionPerformed(evt);
            }
        });
        persuppliesPanel.add(bookCategoryT);
        bookCategoryT.setBounds(180, 350, 400, 30);

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Buying Price:");
        persuppliesPanel.add(jLabel9);
        jLabel9.setBounds(20, 470, 150, 30);

        buyingPriceT.setEditable(false);
        buyingPriceT.setBackground(new java.awt.Color(204, 204, 204));
        buyingPriceT.setFont(new java.awt.Font("Adobe Gothic Std B", 0, 18)); // NOI18N
        buyingPriceT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyingPriceTActionPerformed(evt);
            }
        });
        persuppliesPanel.add(buyingPriceT);
        buyingPriceT.setBounds(180, 470, 400, 30);

        jLabel12.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Selling Price:");
        persuppliesPanel.add(jLabel12);
        jLabel12.setBounds(20, 530, 150, 30);

        sellingPriceT.setEditable(false);
        sellingPriceT.setBackground(new java.awt.Color(204, 204, 204));
        sellingPriceT.setFont(new java.awt.Font("Adobe Gothic Std B", 0, 18)); // NOI18N
        sellingPriceT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellingPriceTActionPerformed(evt);
            }
        });
        persuppliesPanel.add(sellingPriceT);
        sellingPriceT.setBounds(180, 530, 390, 30);

        addBtn.setText("ADD TO LIST");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        persuppliesPanel.add(addBtn);
        addBtn.setBounds(330, 600, 240, 60);

        jLabel14.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("pieces:");
        persuppliesPanel.add(jLabel14);
        jLabel14.setBounds(20, 600, 110, 50);

        stockT.setEditable(false);
        stockT.setBackground(new java.awt.Color(204, 204, 204));
        stockT.setFont(new java.awt.Font("Adobe Gothic Std B", 0, 18)); // NOI18N
        stockT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockTActionPerformed(evt);
            }
        });
        persuppliesPanel.add(stockT);
        stockT.setBounds(180, 410, 400, 30);

        jLabel15.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Stocked:");
        persuppliesPanel.add(jLabel15);
        jLabel15.setBounds(20, 410, 150, 30);

        addbookBtn.setText("ADD NEW book");
        addbookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbookBtnActionPerformed(evt);
            }
        });
        persuppliesPanel.add(addbookBtn);
        addbookBtn.setBounds(430, 180, 150, 23);

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 51));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        persuppliesPanel.add(jLabel16);
        jLabel16.setBounds(180, 180, 230, 30);

        piecesT.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        piecesT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        persuppliesPanel.add(piecesT);
        piecesT.setBounds(160, 600, 130, 60);

        datetimeL.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        datetimeL.setForeground(new java.awt.Color(255, 255, 255));
        persuppliesPanel.add(datetimeL);
        datetimeL.setBounds(750, 100, 280, 30);

        showadminT.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        showadminT.setForeground(new java.awt.Color(255, 255, 255));
        persuppliesPanel.add(showadminT);
        showadminT.setBounds(720, 60, 210, 30);

        bookSupply.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Book Name", "Piece/s", "Unit Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookSupply.setColumnSelectionAllowed(true);
        bookSupply.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookSupplyMouseClicked(evt);
            }
        });
        bookSupply.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bookSupplyKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(bookSupply);
        bookSupply.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        persuppliesPanel.add(jScrollPane2);
        jScrollPane2.setBounds(600, 150, 560, 300);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(persuppliesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(persuppliesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1200, 685));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void persuppliesExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_persuppliesExitButtonActionPerformed
        // TODO add your handling code here:
        CancelSell(0);
        this.dispose();
    }//GEN-LAST:event_persuppliesExitButtonActionPerformed

    private void backButtonpersuppliesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonpersuppliesActionPerformed
        // TODO add your handling code here:
        homePage homePage = new homePage();
        homePage . setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backButtonpersuppliesActionPerformed

    private void subtotalTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subtotalTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subtotalTActionPerformed

    private void emptylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emptylistActionPerformed
        // TODO add your handling code here:
        CancelSell(0);
    }//GEN-LAST:event_emptylistActionPerformed

    private void isbnTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isbnTActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_isbnTActionPerformed

    private void isbnTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_isbnTKeyPressed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_isbnTKeyPressed

    private void isbnTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_isbnTKeyReleased

    }//GEN-LAST:event_isbnTKeyReleased

    private void isbnTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_isbnTKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_isbnTKeyTyped

    private void checkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBtnActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            bookisbn = isbnT.getText();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
                + "databaseName=dbBOPMS;selectMethod=cursor", "sa", "123456");
            int check=0;
            

            String sql = "SELECT * FROM books" +
                        " WHERE bookISBN='"+bookisbn+"'";

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                bookNameT.setText(rs.getString("bookName"));
                bookAuthorT.setText(rs.getString("bookAuthor"));
                bookPublisherT.setText(rs.getString("bookPublisher"));
                bookCategoryT.setText(rs.getString("bookCategory"));
                cost = rs.getFloat("buyingPrice");
                buyingPriceT.setText(Float.toString(cost));
                sellingPriceT.setText(rs.getString("sellingPrice"));
                Stocks = rs.getInt("stocks");
                
                stockT.setText(Integer.toString(Stocks));



                check=1;
            }

            if(check==0){

                jLabel16.setText("NOT FOUND");
            }

        }
        catch (ClassNotFoundException | SQLException e) {
        }
    }//GEN-LAST:event_checkBtnActionPerformed

    private void bookNameTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookNameTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookNameTActionPerformed

    private void bookAuthorTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookAuthorTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookAuthorTActionPerformed

    private void bookPublisherTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookPublisherTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookPublisherTActionPerformed

    private void bookCategoryTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookCategoryTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookCategoryTActionPerformed

    private void buyingPriceTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyingPriceTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buyingPriceTActionPerformed

    private void sellingPriceTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellingPriceTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sellingPriceTActionPerformed

    private void stockTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockTActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        // TODO add your handling code here:
        SupplyFinish SupplyFinish = new SupplyFinish();
        SupplyFinish.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void addbookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbookBtnActionPerformed
        // TODO add your handling code here:
        supplyRunning=true;
        addNewBooks addNewBooks = new addNewBooks();
        addNewBooks.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addbookBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        cart = true;
        DefaultTableModel model2 = (DefaultTableModel) bookSupply.getModel();
        pieces = (Integer) piecesT.getValue();
        
        Object[] row = new Object[4];
        //for(int i = 0; i < indexs.length; i++)
        //{
            row[0] = bookisbn;
            row[1] = bookNameT.getText();
            row[2] = pieces;
            row[3] = cost;

            model2.addRow(row);
            
            totalprice = totalprice + (pieces*cost);
            totalPrice = Float.toString(totalprice);
            subtotalT.setText(totalPrice);

            bookNameT.setText("");
            bookAuthorT.setText("");
            bookPublisherT.setText("");
            bookCategoryT.setText("");
            buyingPriceT.setText("");
            sellingPriceT.setText("");
            stockT.setText("");
            
            
            try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
                    + "databaseName=dbBOPMS;selectMethod=cursor", "sa", "123456");
            
                if(flagGen==false){
                    flagGen=true;
                    float ini = 1;
                    

                    generateID obj = new generateID();
                    supplyid = obj.generator("perSupplies", "supplyId", "S");                        

                    String sql = "Insert into perSupplies(supplyId, adminId, payment) "
                            + "values(?,?,?)";
                        
                    PreparedStatement pst = connection.prepareStatement(sql);
                    pst.setString(1, supplyid);
                    pst.setString(2, "A02");      
                    JOptionPane.showMessageDialog(null, "oh!");
                    pst.setFloat(3, ini);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "oh!");
                    
                }
            //dispose();
            
            String sql1 = "Insert into perSbooks (bookISBN, bookPieces, supplyId) "
                    + "values(?,?,?)";

            PreparedStatement pst = connection.prepareStatement(sql1);
            pst.setString(1, bookisbn);
            pst.setInt(2, pieces);
            pst.setString(3, supplyid);
            pst.executeUpdate();

            
            //stock = stock - pieces;
            //JOptionPane.showMessageDialog(null, stock);
            String sql2 =  "UPDATE books SET stocks=(SELECT stocks FROM books WHERE bookISBN ='"+bookisbn+"')+"+pieces+
                                " WHERE bookISBN = '"+bookisbn+"'";
            pst = connection.prepareStatement(sql2);
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_addBtnActionPerformed

    private void removeListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeListActionPerformed
        // TODO add your handling code here:
        
        if(supplyid!=""){
            int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?",
                "Delete",JOptionPane.YES_NO_OPTION);
            if(opt == 0){
 
            DefaultTableModel model2 = (DefaultTableModel) bookSupply.getModel(); 

            int r = bookSupply.getRowCount();
            CancelSell(r-1);
            if(r==1){
                cart = false;    
            }
            
        } else{
                
            }
        }
    }//GEN-LAST:event_removeListActionPerformed

    private void bookSupplyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookSupplyMouseClicked
        // TODO add your handling code here:
        //int row = bookCart.getSelectedRow();
        TableModel model = bookSupply.getModel();
    }//GEN-LAST:event_bookSupplyMouseClicked

    private void bookSupplyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bookSupplyKeyPressed
        // TODO add your handling code here:

        //JOptionPane.showMessageDialog(null, "check!");
    }//GEN-LAST:event_bookSupplyKeyPressed

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
            java.util.logging.Logger.getLogger(bookSupplies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bookSupplies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bookSupplies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bookSupplies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bookSupplies().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton addbookBtn;
    private javax.swing.JButton backButtonpersupplies;
    private javax.swing.JTextField bookAuthorT;
    private javax.swing.JTextField bookCategoryT;
    private javax.swing.JTextField bookNameT;
    private javax.swing.JTextField bookPublisherT;
    private javax.swing.JTable bookSupply;
    private javax.swing.JTextField buyingPriceT;
    private javax.swing.JButton checkBtn;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JLabel datetimeL;
    private javax.swing.JButton emptylist;
    private javax.swing.JTextField isbnT;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton persuppliesExitButton;
    private javax.swing.JLabel persuppliesLabel;
    private javax.swing.JPanel persuppliesPanel;
    private javax.swing.JSpinner piecesT;
    private javax.swing.JButton removeList;
    private javax.swing.JTextField sellingPriceT;
    private javax.swing.JLabel showadminT;
    private javax.swing.JTextField stockT;
    private javax.swing.JTextField subtotalT;
    // End of variables declaration//GEN-END:variables
}
