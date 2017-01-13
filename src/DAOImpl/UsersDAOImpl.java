package DAOImpl;

import DAO.UsersDAO;
import Database.DBConnection;
import Model.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsersDAOImpl implements UsersDAO {
    
    DBConnection dbCon = new DBConnection();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    @Override
    public boolean ValidateUser(Users U) {
        
        try {
               con = dbCon.geConnection();
        
               pst = con.prepareStatement("select * from Users where USERNAME='"+U.getUSERNAME()+"'and PASSWORD='"+U.getPASSWORD()+"'");
            rs = pst.executeQuery();
                 
            if (rs.next()) {     
                   return true;         
               } 
            else{
                 return false;
               } 
        }
        catch (SQLException ex) {
            
        } 
        return true;
      }
           
    }
    
