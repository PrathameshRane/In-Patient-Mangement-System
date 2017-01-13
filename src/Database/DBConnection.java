package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    
    Connection con =null;
    
public Connection geConnection() throws SQLException{
        try {
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             con=DriverManager.getConnection("jdbc:sqlserver://localhost:49160;user=sa;password=9969440818;databaseName=IMS");   
            } 
        catch (ClassNotFoundException ex1) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex1);
            }
        catch (SQLException ex2) {
            System.out.println("Too Many Connection");
            }
        return con;
    }
}
