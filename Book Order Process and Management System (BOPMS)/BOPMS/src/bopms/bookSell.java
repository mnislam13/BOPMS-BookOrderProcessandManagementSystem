package dbdummy;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



/**
 *
 * @author
 */
public class bookSell extends javax.swing.JFrame {
    
    public String adminID = loginAdmin.adminId;
    public String adminname = loginAdmin.adminname;
    String bookisbn;
    String bookname;
    String bookauthor;
    String bookpublisher;
    float price;
    String Price;
    int pieces=1;
    String Pieces;
    public static float totalprice = 0;
    String totalPrice;
    public static String poid="";
    String gid;
    boolean flagGen;
    //public static boolean cart=false;
    int stock;
    String src;
    public static boolean forOrder;
    Date date;
    SimpleDateFormat formatter;
    Timer timer;
    boolean cart;
    String srcOn="bookName";
    

    /**
     * Creates new form bookSale
     */
    public bookSell() {
        initComponents();
        DefaultTableModel model = (DefaultTableModel)bookSellInfo.getModel();
        model.setRowCount(0);
        show_book();
        flagGen=false;
        forOrder=false;
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
        
        //System.out.println(formatter.format(date));  
        
    }
    
    
    
    public ArrayList<bookDisplay> bookList()
    {
        ArrayList<bookDisplay> bookList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
            .getConnection(
             "jdbc:sqlserver://localhost:1433;databaseName=dbBOPMS;"
               + "selectMethod=cursor", "sa", "123456");


            src = searchT.getText();
            String sql = "Select * from books where "+srcOn+" LIKE '"+src+"%' ORDER BY "+srcOn; 
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            bookDisplay book;
            while(rs.next()){
                book = new bookDisplay(rs.getString("bookISBN"),
                    rs.getString("bookName"),
                    rs.getString("bookAuthor"),
                    rs.getString("bookPublisher"),
                    rs.getString("bookCategory"),
                    rs.getFloat("buyingPrice"),
                    rs.getFloat("sellingPrice"),
                    rs.getInt("stocks")); 
                   bookList.add(book);
                   
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }
        
    public void show_book(){
    ArrayList<bookDisplay> list = bookList();
    DefaultTableModel model = (DefaultTableModel)bookSellInfo.getModel();
    Object[] row = new Object[3];
    for(int i = 0; i < list.size(); i++)
    {
        row[0] = list.get(i).getisbn();
        row[1] = list.get(i).getname();
        row[2] = list.get(i).getstocks();
        model.addRow(row); 
    }
    }
    
    
    
    
    public void CancelSell(int a){
        if(poid!=""){
                int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel without finishing?",
                    "CANCEL",JOptionPane.YES_NO_OPTION);
                if(opt == 0){
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    Connection connection = DriverManager
                    .getConnection(
                        "jdbc:sqlserver://localhost:1433;databaseName=dbBOPMS;"
                                + "selectMethod=cursor", "sa", "123456");

                    DefaultTableModel model2 = (DefaultTableModel) bookCart.getModel(); 
                    
                    int rc = bookCart.getRowCount();
                    
                    for (int i = rc - 1; i >= a; i--) {
                        
                    bookisbn = (String) model2.getValueAt(i, 0);
                    String P = (String) model2.getValueAt(i, 2);
                    pieces = Integer.parseInt(P);
                    String sql = "DELETE FROM perPObooks WHERE poId='"+poid+"' AND bookISBN='"+bookisbn+"'";
                    PreparedStatement pst = connection.prepareStatement(sql);
                    pst.executeUpdate();
                    
                    //JOptionPane.showMessageDialog(null, "Deleted from db!");
                
                    model2.removeRow(i);

                    String sql2 = "UPDATE books SET stocks=(SELECT stocks FROM books WHERE bookISBN ='"+bookisbn+"')+"+pieces+
                                " WHERE bookISBN = '"+bookisbn+"'";
                    pst = connection.prepareStatement(sql2);
                    pst.executeUpdate();

                    }
                    if(a==0){
                        
                        String sql = "DELETE FROM perPerchaseOrder WHERE poId='"+poid+"'";
                        PreparedStatement pst = connection.prepareStatement(sql);
                        pst.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Emptied Successfully!");
                        DefaultTableModel table = (DefaultTableModel)bookSellInfo.getModel();
                        
                        searchT.setText("");
                        table.setRowCount(0);
                        show_book();
                        poid="";
                        cart = false;
                        orderC.setEnabled(true);
                    }
                    
                    

                } catch (Exception e) {
                    e.printStackTrace();
                }
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

        bookSalePanel = new javax.swing.JPanel();
        bookSaleLabel = new javax.swing.JLabel();
        bookSaleExitButton = new javax.swing.JButton();
        backButtonbookSale = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        showadminT = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bookAuthorT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        bookPublisherT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        subtotalT = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        piecesT = new javax.swing.JSpinner();
        confirmBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        bookNameT = new javax.swing.JTextField();
        datetimeL = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        priceT = new javax.swing.JTextField();
        emptycartBtn = new javax.swing.JButton();
        removecartBtn = new javax.swing.JButton();
        addcartBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookSellInfo = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        bookCart = new javax.swing.JTable();
        orderC = new javax.swing.JRadioButton();
        searchT = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        filterbycombo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        bookSalePanel.setBackground(new java.awt.Color(85, 104, 138));
        bookSalePanel.setLayout(null);

        bookSaleLabel.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        bookSaleLabel.setForeground(new java.awt.Color(255, 255, 255));
        bookSaleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookSaleLabel.setText("Books Sell");
        bookSalePanel.add(bookSaleLabel);
        bookSaleLabel.setBounds(680, 10, 210, 30);

        bookSaleExitButton.setBackground(new java.awt.Color(255, 255, 255));
        bookSaleExitButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        bookSaleExitButton.setText("X");
        bookSaleExitButton.setMaximumSize(new java.awt.Dimension(10, 19));
        bookSaleExitButton.setMinimumSize(new java.awt.Dimension(10, 19));
        bookSaleExitButton.setPreferredSize(new java.awt.Dimension(10, 19));
        bookSaleExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookSaleExitButtonActionPerformed(evt);
            }
        });
        bookSalePanel.add(bookSaleExitButton);
        bookSaleExitButton.setBounds(1370, 0, 50, 30);

        backButtonbookSale.setBackground(new java.awt.Color(255, 255, 255));
        backButtonbookSale.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        backButtonbookSale.setText("<");
        backButtonbookSale.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backButtonbookSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonbookSaleActionPerformed(evt);
            }
        });
        bookSalePanel.add(backButtonbookSale);
        backButtonbookSale.setBounds(0, 0, 50, 32);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search By");
        bookSalePanel.add(jLabel1);
        jLabel1.setBounds(40, 100, 80, 30);

        showadminT.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        showadminT.setForeground(new java.awt.Color(255, 255, 255));
        bookSalePanel.add(showadminT);
        showadminT.setBounds(940, 50, 210, 30);

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Author:");
        bookSalePanel.add(jLabel4);
        jLabel4.setBounds(20, 530, 130, 30);

        bookAuthorT.setEditable(false);
        bookAuthorT.setBackground(new java.awt.Color(204, 204, 204));
        bookAuthorT.setFont(new java.awt.Font("Adobe Gothic Std B", 0, 18)); // NOI18N
        bookAuthorT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookAuthorTActionPerformed(evt);
            }
        });
        bookSalePanel.add(bookAuthorT);
        bookAuthorT.setBounds(160, 530, 630, 30);

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Publisher:");
        bookSalePanel.add(jLabel5);
        jLabel5.setBounds(20, 570, 130, 30);

        bookPublisherT.setEditable(false);
        bookPublisherT.setBackground(new java.awt.Color(204, 204, 204));
        bookPublisherT.setFont(new java.awt.Font("Adobe Gothic Std B", 0, 18)); // NOI18N
        bookPublisherT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookPublisherTActionPerformed(evt);
            }
        });
        bookSalePanel.add(bookPublisherT);
        bookPublisherT.setBounds(160, 570, 630, 30);

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Price:");
        bookSalePanel.add(jLabel8);
        jLabel8.setBounds(20, 620, 130, 30);

        subtotalT.setEditable(false);
        subtotalT.setBackground(new java.awt.Color(204, 204, 204));
        subtotalT.setFont(new java.awt.Font("Adobe Gothic Std B", 0, 18)); // NOI18N
        subtotalT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subtotalTActionPerformed(evt);
            }
        });
        bookSalePanel.add(subtotalT);
        subtotalT.setBounds(990, 550, 410, 40);

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("pieces:");
        bookSalePanel.add(jLabel9);
        jLabel9.setBounds(530, 620, 80, 30);

        piecesT.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        piecesT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bookSalePanel.add(piecesT);
        piecesT.setBounds(630, 620, 160, 30);

        confirmBtn.setText("CONFIRM");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });
        bookSalePanel.add(confirmBtn);
        confirmBtn.setBounds(840, 670, 560, 70);

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Book Name:");
        bookSalePanel.add(jLabel6);
        jLabel6.setBounds(20, 490, 130, 30);

        bookNameT.setEditable(false);
        bookNameT.setBackground(new java.awt.Color(204, 204, 204));
        bookNameT.setFont(new java.awt.Font("Adobe Gothic Std B", 0, 18)); // NOI18N
        bookNameT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookNameTActionPerformed(evt);
            }
        });
        bookSalePanel.add(bookNameT);
        bookNameT.setBounds(160, 490, 630, 30);

        datetimeL.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        datetimeL.setForeground(new java.awt.Color(255, 255, 255));
        bookSalePanel.add(datetimeL);
        datetimeL.setBounds(980, 100, 280, 30);

        jLabel11.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Admin:");
        bookSalePanel.add(jLabel11);
        jLabel11.setBounds(840, 60, 80, 20);

        jLabel13.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("SUB TOTAL:");
        bookSalePanel.add(jLabel13);
        jLabel13.setBounds(840, 550, 140, 40);

        priceT.setEditable(false);
        priceT.setBackground(new java.awt.Color(204, 204, 204));
        priceT.setFont(new java.awt.Font("Adobe Gothic Std B", 0, 18)); // NOI18N
        priceT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTActionPerformed(evt);
            }
        });
        bookSalePanel.add(priceT);
        priceT.setBounds(160, 620, 240, 30);

        emptycartBtn.setText("EMPTY CART");
        emptycartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emptycartBtnActionPerformed(evt);
            }
        });
        bookSalePanel.add(emptycartBtn);
        emptycartBtn.setBounds(1160, 620, 240, 30);

        removecartBtn.setText("REMOVE FROM CART");
        removecartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removecartBtnActionPerformed(evt);
            }
        });
        bookSalePanel.add(removecartBtn);
        removecartBtn.setBounds(840, 620, 250, 30);

        addcartBtn.setText("ADD TO CART");
        addcartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addcartBtnActionPerformed(evt);
            }
        });
        bookSalePanel.add(addcartBtn);
        addcartBtn.setBounds(20, 680, 760, 60);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );

        bookSalePanel.add(jPanel1);
        jPanel1.setBounds(810, 50, 5, 690);

        bookSellInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Book Name", "Stocks"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookSellInfo.setColumnSelectionAllowed(true);
        bookSellInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookSellInfoMouseClicked(evt);
            }
        });
        bookSellInfo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bookSellInfoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(bookSellInfo);
        bookSellInfo.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        bookSalePanel.add(jScrollPane1);
        jScrollPane1.setBounds(40, 160, 750, 300);

        bookCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Book Name", "Piece/s", "Unit Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookCart.setColumnSelectionAllowed(true);
        bookCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookCartMouseClicked(evt);
            }
        });
        bookCart.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bookCartKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(bookCart);
        bookCart.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        bookSalePanel.add(jScrollPane2);
        jScrollPane2.setBounds(840, 150, 560, 370);

        orderC.setText("FOR ORDER");
        orderC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderCActionPerformed(evt);
            }
        });
        bookSalePanel.add(orderC);
        orderC.setBounds(680, 100, 110, 30);

        searchT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTActionPerformed(evt);
            }
        });
        searchT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTKeyReleased(evt);
            }
        });
        bookSalePanel.add(searchT);
        searchT.setBounds(310, 100, 350, 30);

        jLabel12.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Date-Time:");
        bookSalePanel.add(jLabel12);
        jLabel12.setBounds(840, 100, 130, 30);

        filterbycombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "bookName", "bookAuthor", "bookCategory" }));
        filterbycombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterbycomboActionPerformed(evt);
            }
        });
        bookSalePanel.add(filterbycombo);
        filterbycombo.setBounds(150, 100, 130, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bookSalePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1418, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bookSalePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1418, 769));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonbookSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonbookSaleActionPerformed
        // TODO add your handling code here:
        homePage homePage = new homePage();
        homePage . setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backButtonbookSaleActionPerformed

    private void bookAuthorTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookAuthorTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookAuthorTActionPerformed

    private void bookPublisherTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookPublisherTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookPublisherTActionPerformed

    private void subtotalTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subtotalTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subtotalTActionPerformed

    private void bookNameTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookNameTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookNameTActionPerformed

    private void priceTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceTActionPerformed

    private void emptycartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emptycartBtnActionPerformed
        // TODO add your handling code here:
        CancelSell(0);
    }//GEN-LAST:event_emptycartBtnActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        // TODO add your handling code here:

        //String t = subtotalT.getText();
        //totalprice = Float.parseFloat(t);
        
        
        if(cart==true){
            sellFinish sellFinish = new sellFinish();
            sellFinish.setVisible(true);
            this.setVisible(false);
        }
        
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void bookSellInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookSellInfoMouseClicked
        // TODO add your handling code here:
        //int row = bookSellInfo.getSelectedRow();
        //TableModel model = bookSellInfo.getModel();
        
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection connection = DriverManager
                .getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=dbBOPMS;"
                            + "selectMethod=cursor", "sa", "123456");

            TableModel model = bookSellInfo.getModel();
            int i = bookSellInfo.getSelectedRow();    
            String bookisbn = (String) model.getValueAt(i, 0);

            String sql = "SELECT bookName, bookAuthor, bookPublisher, sellingPrice FROM books" +
                            " WHERE bookISBN='"+bookisbn+"'";

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
                bookname = rs.getString("bookName");
                bookauthor = rs.getString("bookAuthor");
                bookpublisher = rs.getString("bookPublisher");
                price = rs.getFloat("sellingPrice");  
            }
            Price = Float.toString(price);
            bookNameT.setText(bookname);
            bookAuthorT.setText(bookauthor);
            bookPublisherT.setText(bookpublisher);
            priceT.setText(Price);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_bookSellInfoMouseClicked

    private void bookSellInfoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bookSellInfoKeyPressed
        // TODO add your handling code here:
        
        //JOptionPane.showMessageDialog(null, "check!");
    }//GEN-LAST:event_bookSellInfoKeyPressed

    private void bookCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookCartMouseClicked
        // TODO add your handling code here:
        int row = bookCart.getSelectedRow();
        TableModel model = bookCart.getModel();

    }//GEN-LAST:event_bookCartMouseClicked

    private void bookCartKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bookCartKeyPressed
        // TODO add your handling code here:

        //JOptionPane.showMessageDialog(null, "check!");
    }//GEN-LAST:event_bookCartKeyPressed

    private void addcartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addcartBtnActionPerformed
        // TODO add your handling code here:
        if(!orderC.isSelected()){
            orderC.setEnabled(false);      
        }    
        cart = true;
        TableModel model1 = bookSellInfo.getModel();
        int index = bookSellInfo.getSelectedRow();
        
        Object[] row = new Object[4];
        
        DefaultTableModel model2 = (DefaultTableModel) bookCart.getModel();
        pieces = (Integer) piecesT.getValue();
        Pieces = Integer.toString(pieces);
        
        stock = (Integer) model1.getValueAt(index, 2);
        bookisbn = (String) model1.getValueAt(index, 0);
        
        //for(int i = 0; i < indexs.length; i++)
        //{
            row[0] = model1.getValueAt(index, 0);
            row[1] = model1.getValueAt(index, 1);
            row[2] = Pieces;
            row[3] = Price;

            model2.addRow(row);
            
            totalprice = totalprice + pieces*price;
            totalPrice = Float.toString(totalprice);
            subtotalT.setText(totalPrice);
            
            bookNameT.setText("");
            bookAuthorT.setText("");
            bookPublisherT.setText("");
            priceT.setText("");
        //}
        
        
        
            
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
                    + "databaseName=dbBOPMS;selectMethod=cursor", "sa", "123456");
            
                if(flagGen==false){
                    flagGen=true;
                    float ini = 1;
                    
                    if(forOrder==false){
                        generateID obj = new generateID();
                        poid = obj.generator("perPerchaseOrder", "poId", "P");                        
                    } else {
                        generateID obj = new generateID();
                        poid = obj.generator("perPerchaseOrder", "poId", "P");
                    }
                    String sql = "Insert into perPerchaseOrder(poId, adminId, totalIncome) "
                            + "values(?,?,?)";
                        
                    PreparedStatement pst = connection.prepareStatement(sql);
                    pst.setString(1, poid);
                    pst.setString(2, "A03");
                    pst.setFloat(3, ini);
                    pst.executeUpdate();
                    
                }
            //dispose();
            
            String sql1 = "Insert into perPObooks (bookISBN, bookPieces, poId) "
                    + "values(?,?,?)";

            PreparedStatement pst = connection.prepareStatement(sql1);
            pst.setString(1, bookisbn);
            pst.setInt(2, pieces);
            pst.setString(3, poid);
            pst.executeUpdate();
            
            
            //stock = stock - pieces;
            //JOptionPane.showMessageDialog(null, stock);
            String sql2 =  "UPDATE books SET stocks=(SELECT stocks FROM books WHERE bookISBN ='"+bookisbn+"')-"+pieces+
                                " WHERE bookISBN = '"+bookisbn+"'";
            pst = connection.prepareStatement(sql2);
            pst.executeUpdate();
            DefaultTableModel table = (DefaultTableModel)bookSellInfo.getModel();

            table.setRowCount(0);
            show_book();
            

        } catch (Exception e) {
            e.printStackTrace();
        }
  
        
    }//GEN-LAST:event_addcartBtnActionPerformed

    private void bookSaleExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookSaleExitButtonActionPerformed
        // TODO add your handling code here:
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?",
                "EXIT",JOptionPane.YES_NO_OPTION);
        
        if(opt == 0){
            CancelSell(0);
            dispose();
        }
    }//GEN-LAST:event_bookSaleExitButtonActionPerformed

    private void removecartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removecartBtnActionPerformed
        // TODO add your handling code here:
        
        if(poid!=""){
            int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?",
                "Delete",JOptionPane.YES_NO_OPTION);
            if(opt == 0){
 
            DefaultTableModel model2 = (DefaultTableModel) bookCart.getModel(); 

            int r = bookCart.getRowCount();
            CancelSell(r-1);
            if(r==1){
                cart = false;
                orderC.setEnabled(true);      
            }

            
        } else{
                
            }
        }
        
    }//GEN-LAST:event_removecartBtnActionPerformed

    private void orderCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderCActionPerformed
        // TODO add your handling code here:   
            if(orderC.isSelected()){
                forOrder = true;    
            }        
    }//GEN-LAST:event_orderCActionPerformed

    private void searchTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTActionPerformed

    private void searchTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTKeyReleased
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)bookSellInfo.getModel();
        table.setRowCount(0);
        show_book();
    }//GEN-LAST:event_searchTKeyReleased

    private void filterbycomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterbycomboActionPerformed
        // TODO add your handling code here:
        srcOn = (String) filterbycombo.getSelectedItem().toString();
        
        
    }//GEN-LAST:event_filterbycomboActionPerformed

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
            java.util.logging.Logger.getLogger(bookSell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bookSell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bookSell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bookSell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bookSell().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addcartBtn;
    private javax.swing.JButton backButtonbookSale;
    private javax.swing.JTextField bookAuthorT;
    private javax.swing.JTable bookCart;
    private javax.swing.JTextField bookNameT;
    private javax.swing.JTextField bookPublisherT;
    private javax.swing.JButton bookSaleExitButton;
    private javax.swing.JLabel bookSaleLabel;
    private javax.swing.JPanel bookSalePanel;
    private javax.swing.JTable bookSellInfo;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JLabel datetimeL;
    private javax.swing.JButton emptycartBtn;
    private javax.swing.JComboBox<String> filterbycombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton orderC;
    private javax.swing.JSpinner piecesT;
    private javax.swing.JTextField priceT;
    private javax.swing.JButton removecartBtn;
    private javax.swing.JTextField searchT;
    private javax.swing.JLabel showadminT;
    private javax.swing.JTextField subtotalT;
    // End of variables declaration//GEN-END:variables
}
