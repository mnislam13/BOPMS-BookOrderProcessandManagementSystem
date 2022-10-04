/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdummy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author TUSHAR MUHAMMAD
 */

public class DBdummy {
    
    public Connection connection;
    /*
    String sql = "Update books set buyingPrice="+buyingPrice+
                        " where bookISBN = '"+isbn+"'";
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.executeUpdate();
                sql = "Update books set sellingPrice="+sellingPrice+" where bookISBN = '"+isbn+"'";
                pst = connection.prepareStatement(sql);
                pst.executeUpdate();
    
    *//////////////////////////////for prepared statement execution////////////////////////
            
    public void connectDB() {
        
        
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=ProjectDB;selectMethod=cursor", "sa", "123456");

            System.out.println("DATABASE NAME IS:" + connection.getMetaData().getDatabaseProductName());
               
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT IDENT_CURRENT('books')");
            
            
            while (resultSet.next()) {
                
                System.out.println("Books NAME:" + resultSet.getString("bookISBN"));
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public String generator(String table, String id, String x) {
        String gid="";
        try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
            .getConnection(
             "jdbc:sqlserver://localhost:1433;databaseName=dbBOPMS;"
               + "selectMethod=cursor", "sa", "123456");


            //String query = "SELECT MAX(CAST(SUBSTRING("+id+",2,LEN("+id")-1) AS INT)) FROM "+table+" WHERE "+id+" LIKE '"+x+"%'";
            
            String query = "SELECT MAX(CAST(SUBSTRING(";
            query = query +id+",2,LEN(";
            query = query +id+")-1) AS INT)) as id FROM "+table+" WHERE '"+id+"' LIKE '"+x+"%'";
            
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            JOptionPane.showMessageDialog(null, "Successful!");
            while (rs.next()){
                gid = rs.getString("id");
                int tempid = Integer.parseInt(gid);
                tempid = tempid + 1;
                gid = Integer.toString(tempid);
                gid = x+gid;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gid;
}
    
    public static void main(String[] args) {
        DBdummy cnObj = new DBdummy();
        cnObj.connectDB();
        
        String genid = cnObj.generator("books", "bookISBN", "B");
        System.out.println("gid NAME:" +genid);
    }
    
}
