package DAOImpl;

import DAO.Test_ReportDAO;
import Database.DBConnection;
import List.ListTest_Report;
import Model.Test_Report;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;

public class Test_ReportDAOImpl implements Test_ReportDAO {

    DBConnection dbCon = new DBConnection();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public ObservableList<ListTest_Report> ReportDetails = FXCollections.observableArrayList();
    Test_Report R = new Test_Report(); 

    
    @Override
    public void addReport(Test_Report R) {
       
         try {
            con = dbCon.geConnection();
            pst = con.prepareStatement("insert into Test_Report(P_ID,T_ID,R_ID,R_NAME,R_DATE) values(?,?,?,?,?)");
            
            pst.setInt(1, R.getP_ID());
            pst.setInt(2, R.getT_ID());
            pst.setInt(3, R.getR_ID());
            pst.setString(4, R.getR_NAME());
            pst.setString(5, R.getR_DATE());
            pst.executeUpdate();
            
            pst.close();
            con.close();
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Patient Report Added Succesfully.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Report2.png").toString()));
        alert.setContentText("Report Name :" + "  " + R.getR_NAME() + " " );
        alert.showAndWait();
      }
         catch (SQLException ex) {
           
         }
    
    }
        

    @Override
    public ObservableList<ListTest_Report> getReport(int P_id) {
    
        ReportDetails.clear();
        try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select * from Test_Report where P_ID like ? ORDER BY TR_ID");
                    pst.setInt(1, P_id);
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        R.setTR_ID(rs.getInt(1));
                        R.setP_ID(rs.getInt(2));
                        R.setT_ID(rs.getInt(3));
                        R.setR_ID(rs.getInt(4));
                        R.setR_NAME(rs.getString(5));
                        R.setR_DATE(rs.getString(6));
                        
                        ReportDetails.add(new ListTest_Report(R.getTR_ID(), R.getP_ID(), R.getT_ID(), R.getR_ID(), R.getR_NAME(), R.getR_DATE()));
                        
                    }
                    
                     pst.close();
                    con.close();
                    rs.close();
                 }
            catch (SQLException ex) {
              
            }
        
        return ReportDetails;
    
    }
   
    @Override
    public ObservableList<ListTest_Report> getAllReport() {
      
        ReportDetails.clear();
        try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select * from Test_Report");                   
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        R.setTR_ID(rs.getInt(1));
                        R.setP_ID(rs.getInt(2));
                        R.setT_ID(rs.getInt(3));
                        R.setR_ID(rs.getInt(4));
                        R.setR_NAME(rs.getString(5));
                        R.setR_DATE(rs.getString(6));                
                        
                        ReportDetails.add(new ListTest_Report(R.getTR_ID(), R.getP_ID(), R.getT_ID(), R.getR_ID(), R.getR_NAME(), R.getR_DATE()));
                    }
                    
                     pst.close();
                    con.close();
                    rs.close();
                 }
            catch (SQLException ex) {
              
            }
        return ReportDetails;
    
    }
    
     @Override
    public ListTest_Report selectedReport(ListTest_Report LR) {
    
        try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select * from Test_Report where TR_ID=?");
                    pst.setInt(1, LR.getTR_ID());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        LR.setTR_ID(rs.getInt(1));
                        LR.setP_ID(rs.getInt(2));
                        LR.setT_ID(rs.getInt(3));
                        LR.setR_ID(rs.getInt(4));
                        LR.setR_NAME(rs.getString(5));
                        LR.setR_DATE(rs.getString(6));                     
                        
                          }
                    
                     pst.close();
                    con.close();
                    rs.close();
                 }
            catch (SQLException ex) {
              
            }
               
            return LR;
        
    }
          
    @Override
    public void updateReport(Test_Report R) {
    
        try {
            con = dbCon.geConnection();
            pst = con.prepareStatement("update Test_Report set P_ID=?,T_ID=?,R_ID=?,R_NAME=?,R_DATE=? where TR_ID=?");
          
            pst.setInt(1, R.getP_ID());
            pst.setInt(2, R.getT_ID());
            pst.setInt(3, R.getR_ID());
            pst.setString(4, R.getR_NAME());
            pst.setString(5, R.getR_DATE());
            
            pst.setInt(6, R.getTR_ID());
            
            pst.executeUpdate(); 
            
            pst.close();
            con.close();
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Patient Report Updated Succesfully.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Report2.png").toString()));
        alert.setContentText("Report Name :" + "  " + R.getR_NAME() + " " );
        alert.showAndWait();
      }
         catch (SQLException ex) {
           
         }  
    
    }

    @Override
    public void deleteReport(int TR_ID) {
    
         try {
               con = dbCon.geConnection();            
                
               pst = con.prepareStatement("delete from Test_Report where TR_ID="+TR_ID);
                pst.executeUpdate();               
                pst.close();
                con.close();
               
            } 
             catch (SQLException ex) {
             
             }
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Selected Patient Report Deleted Succesfully.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Report2.png").toString()));     
        alert.showAndWait();
        
    }
    
 }