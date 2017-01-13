package DAOImpl;

import DAO.Urine_ReportDAO;
import Database.DBConnection;
import List.ListUrine_Report;
import Model.Urine_Report;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;

public class Urine_ReportDAOImpl implements Urine_ReportDAO {
    
    DBConnection dbCon = new DBConnection();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public ObservableList<ListUrine_Report> Urine_ReportDetails = FXCollections.observableArrayList();
    Urine_Report UR = new Urine_Report(); 

    @Override
    public void addReport(Urine_Report UR) {
       
        try {
            con = dbCon.geConnection();
            pst = con.prepareStatement("insert into Urine_Report(P_ID,Acetone) values(?,?)");
                
            pst.setInt(1, UR.getP_ID());
            pst.setString(2, UR.getAcetone());         
          
            pst.executeUpdate();
            pst.close();
            con.close();
            
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Urine Report Added Succesfully.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Report2.png").toString()));
        alert.setContentText("Patient ID :" + "  " + UR.getP_ID() + " " );
        alert.showAndWait();
      }
         catch (SQLException ex) {
           
         }
    }

    @Override
    public ObservableList<ListUrine_Report> getReport(int R_ID) {
       
        Urine_ReportDetails.clear();
        try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select * from Urine_Report where R_ID = ? ORDER BY R_ID");
                    pst.setInt(1, R_ID);
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        UR.setR_ID(rs.getInt(1));
                        UR.setP_ID(rs.getInt(2));
                        UR.setAcetone(rs.getString(3));
                                         
                        
                        Urine_ReportDetails.add(new ListUrine_Report(UR.getR_ID(),UR.getP_ID(),UR.getAcetone()));
                        
                    }
                    
                     pst.close();
                    con.close();
                    rs.close();
                 }
            catch (SQLException ex) {
              
            }
        
        return Urine_ReportDetails;
        
    }
  
    @Override
    public ObservableList<ListUrine_Report> getAllReport() {
        
        Urine_ReportDetails.clear();
        try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select * from CBC_Report");                   
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        UR.setR_ID(rs.getInt(1));
                        UR.setP_ID(rs.getInt(2));
                        UR.setAcetone(rs.getString(3));        
                        
                        Urine_ReportDetails.add(new ListUrine_Report(UR.getR_ID(),UR.getP_ID(),UR.getAcetone()));
                        
                    }
                    
                     pst.close();
                    con.close();
                    rs.close();
                 }
            catch (SQLException ex) {
              
            }
        return Urine_ReportDetails;
        
    } 
    
    @Override
    public ListUrine_Report selectedReport(ListUrine_Report LUR) {
        
         try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select * from Urine_Report where R_ID=?");
                    pst.setInt(1, LUR.getR_ID());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        LUR.setR_ID(rs.getInt(1));
                        LUR.setP_ID(rs.getInt(2));
                        LUR.setAcetone(rs.getString(3));                                                   
                        
                          }
                    
                     pst.close();
                    con.close();
                    rs.close();
                 }
            catch (SQLException ex) {
              
            }
               
            return LUR;
        
    }

    @Override
    public void updateReport(Urine_Report UR) {
       
        try {
            con = dbCon.geConnection();
            pst = con.prepareStatement("update Urine_Report set P_ID=?,Acetone=? where R_ID=?");
           
            pst.setInt(1, UR.getP_ID());
            pst.setString(2, UR.getAcetone());
          
            pst.setInt(3, UR.getR_ID());
           
            
            pst.executeUpdate();
            pst.close();
            con.close();
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Urine Report Updated Succesfully.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Report2.png").toString()));
        alert.setContentText("Patient ID :" + "  " + UR.getP_ID() + " " );
        alert.showAndWait();
      }
         catch (SQLException ex) {
           
         } 
        
    }

    @Override
    public void deleteReport(int R_ID) {
        
        try {
               con = dbCon.geConnection();            
                
               pst = con.prepareStatement("delete from Urine_Report where R_ID="+R_ID);
                pst.executeUpdate();               
                pst.close();
                con.close();
               
            } 
             catch (SQLException ex) {
             
             }
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Selected Urine Report Deleted Succesfully.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Report2.png").toString()));     
        alert.showAndWait();
        
    } 
        
 }