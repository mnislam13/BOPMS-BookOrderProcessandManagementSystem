/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class connectMSSQL {
    public Connection connection;
    public void connectdb() throws ClassNotFoundException, SQLException
    {
         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
                    .getConnection(
                            "jdbc:sqlserver://localhost:1433;databaseName=BOPMS;"
                                    + "selectMethod=cursor","sa", "123456");
            System.out.println("DATABASE NAME IS:"
                    + connection.getMetaData().getDatabaseProductName());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM admin");
            while (resultSet.next()) {
                System.out.println("Admin NAME: "
                        + resultSet.getString("adminName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public static void main(String[] args) throws ClassNotFoundException, SQLException {
        connectMSSQL cnObj = new connectMSSQL();
        cnObj.connectdb();
    }
}
