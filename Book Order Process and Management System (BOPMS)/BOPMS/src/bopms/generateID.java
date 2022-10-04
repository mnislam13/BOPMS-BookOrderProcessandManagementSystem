/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdummy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author TUSHAR MUHAMMAD
 */
public class generateID {
    
    public String generator(String table, String id, String x) throws SQLException {
        String gid="0";
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
            
            while (rs.next()){
                gid = rs.getString("id");

                int tempid = Integer.parseInt(gid);
                tempid = tempid + 1;
                gid = Integer.toString(tempid);
                gid = x+gid;
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(generateID.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gid;
        
}
}


