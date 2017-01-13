package DAOImpl;

import DAO.CBC_ReportDAO;
import Database.DBConnection;
import List.ListCBC_Report;
import Model.CBC_Report;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;

public class CBC_ReportDAOImpl implements CBC_ReportDAO  {

    DBConnection dbCon = new DBConnection();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public ObservableList<ListCBC_Report> CBCReportDetails = FXCollections.observableArrayList();
    CBC_Report CR = new CBC_Report(); 
    
    
    @Override
    public void addReport(CBC_Report CR) {
       
        try {
            con = dbCon.geConnection();
            pst = con.prepareStatement("insert into CBC_Report(P_ID,Haemoglobin,RBC_Count,PCV,MCV,MCH,MCHC,RDW,Total_WBC_Count,Neutrophils,Lymphocytes,Eosinophils,Monocytes,Basophils,Platelet_Count) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                
            pst.setInt(1, CR.getP_ID());
            pst.setString(2, CR.getHaemoglobin());
            pst.setString(3, CR.getRBC_Count());
            pst.setString(4, CR.getPCV());
            pst.setString(5, CR.getMCV());
            pst.setString(6, CR.getMCH());
            pst.setString(7, CR.getMCHC());
            pst.setString(8, CR.getRDW());
            pst.setString(9, CR.getTotal_WBC_Count());
            pst.setString(10, CR.getNeutrophils());
            pst.setString(11, CR.getLymphocytes());
            pst.setString(12, CR.getEosinophils());
            pst.setString(13, CR.getMonocytes());
            pst.setString(14, CR.getBasophils());
            pst.setString(15, CR.getPlatelet_Count());
            pst.executeUpdate();
            pst.close();
            con.close();
            
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("CBC Report Added Succesfully.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Report2.png").toString()));
        alert.setContentText("Patient ID :" + "  " + CR.getP_ID() + " " );
        alert.showAndWait();
      }
         catch (SQLException ex) {
           
         }
        
    }

    @Override
    public ObservableList<ListCBC_Report> getReport(int R_ID) {
    
        CBCReportDetails.clear();
        try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select * from CBC_Report where R_ID = ? ORDER BY R_ID");
                    pst.setInt(1, R_ID);
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        CR.setR_ID(rs.getInt(1));
                        CR.setP_ID(rs.getInt(2));
                        CR.setHaemoglobin(rs.getString(3));
                        CR.setRBC_Count(rs.getString(4));
                        CR.setPCV(rs.getString(5));
                        CR.setMCV(rs.getString(6));
                        CR.setMCH(rs.getString(7));
                        CR.setMCHC(rs.getString(8));
                        CR.setRDW(rs.getString(9));
                        CR.setTotal_WBC_Count(rs.getString(10));
                        CR.setNeutrophils(rs.getString(11));
                        CR.setLymphocytes(rs.getString(12));
                        CR.setEosinophils(rs.getString(13));
                        CR.setMonocytes(rs.getString(14));
                        CR.setBasophils(rs.getString(15));
                        CR.setPlatelet_Count(rs.getString(16));
                        
                        
                        CBCReportDetails.add(new ListCBC_Report(CR.getR_ID(),CR.getP_ID(), CR.getHaemoglobin(), CR.getRBC_Count(), CR.getPCV(), CR.getMCV(), CR.getMCH(), CR.getMCHC(), CR.getRDW(), CR.getTotal_WBC_Count(), CR.getNeutrophils(), CR.getLymphocytes(), CR.getEosinophils(), CR.getMonocytes(), CR.getBasophils(), CR.getPlatelet_Count()));
                        
                    }
                    
                     pst.close();
                    con.close();
                    rs.close();
                 }
            catch (SQLException ex) {
              
            }
        
        return CBCReportDetails;
    
    }
    
    @Override
    public ObservableList<ListCBC_Report> getAllReport() {
    
        CBCReportDetails.clear();
        try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select * from CBC_Report");                   
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        CR.setR_ID(rs.getInt(1));
                        CR.setP_ID(rs.getInt(2));
                        CR.setHaemoglobin(rs.getString(3));
                        CR.setRBC_Count(rs.getString(4));
                        CR.setPCV(rs.getString(5));
                        CR.setMCV(rs.getString(6));
                        CR.setMCH(rs.getString(7));
                        CR.setMCHC(rs.getString(8));
                        CR.setRDW(rs.getString(9));
                        CR.setTotal_WBC_Count(rs.getString(10));
                        CR.setNeutrophils(rs.getString(11));
                        CR.setLymphocytes(rs.getString(12));
                        CR.setEosinophils(rs.getString(13));
                        CR.setMonocytes(rs.getString(14));
                        CR.setBasophils(rs.getString(15));
                        CR.setPlatelet_Count(rs.getString(16));                
                        
                        CBCReportDetails.add(new ListCBC_Report(CR.getR_ID(),CR.getP_ID(), CR.getHaemoglobin(), CR.getRBC_Count(), CR.getPCV(), CR.getMCV(), CR.getMCH(), CR.getMCHC(), CR.getRDW(), CR.getTotal_WBC_Count(), CR.getNeutrophils(), CR.getLymphocytes(), CR.getEosinophils(), CR.getMonocytes(), CR.getBasophils(), CR.getPlatelet_Count()));
                        
                    }
                    
                     pst.close();
                    con.close();
                    rs.close();
                 }
            catch (SQLException ex) {
              
            }
        return CBCReportDetails;
    
    }
    
    @Override
    public ListCBC_Report selectedReport(ListCBC_Report LCR) {
    
        try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select * from CBC_Report where R_ID=?");
                    pst.setInt(1, LCR.getR_ID());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        LCR.setR_ID(rs.getInt(1));
                        LCR.setP_ID(rs.getInt(2));
                        LCR.setHaemoglobin(rs.getString(3));
                        LCR.setRBC_Count(rs.getString(4));
                        LCR.setPCV(rs.getString(5));
                        LCR.setMCV(rs.getString(6));
                        LCR.setMCH(rs.getString(7));
                        LCR.setMCHC(rs.getString(8));
                        LCR.setRDW(rs.getString(9));
                        LCR.setTotal_WBC_Count(rs.getString(10));
                        LCR.setNeutrophils(rs.getString(11));
                        LCR.setLymphocytes(rs.getString(12));
                        LCR.setEosinophils(rs.getString(13));
                        LCR.setMonocytes(rs.getString(14));
                        LCR.setBasophils(rs.getString(15));
                        LCR.setPlatelet_Count(rs.getString(16));
                                             
                        
                          }
                    
                     pst.close();
                    con.close();
                    rs.close();
                 }
            catch (SQLException ex) {
              
            }
               
            return LCR;
     
    }
    

    @Override
    public void updateReport(CBC_Report CR) {
          
         try {
            con = dbCon.geConnection();
            pst = con.prepareStatement("update CBC_Report set P_ID=?,Haemoglobin=?,RBC_Count=?,PCV=?,MCV=?,MCH=?,MCHC=?,RDW=?,Total_WBC_Count=?,Neutrophils=?,Lymphocytes=?,Eosinophils=?,Monocytes=?,Basophils=?,Platelet_Count=? where R_ID=?");
           
            pst.setInt(1, CR.getP_ID());
            pst.setString(2, CR.getHaemoglobin());
            pst.setString(3, CR.getRBC_Count());
            pst.setString(4, CR.getPCV());
            pst.setString(5, CR.getMCV());
            pst.setString(6, CR.getMCH());
            pst.setString(7, CR.getMCHC());
            pst.setString(8, CR.getRDW());
            pst.setString(9, CR.getTotal_WBC_Count());
            pst.setString(10, CR.getNeutrophils());
            pst.setString(11, CR.getLymphocytes());
            pst.setString(12, CR.getEosinophils());
            pst.setString(13, CR.getMonocytes());
            pst.setString(14, CR.getBasophils());
            pst.setString(15, CR.getPlatelet_Count());
            
            pst.setInt(16, CR.getR_ID());
           
            
            pst.executeUpdate();
            pst.close();
            con.close();
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("CBC Report Updated Succesfully.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Report2.png").toString()));
        alert.setContentText("Patient ID :" + "  " + CR.getP_ID() + " " );
        alert.showAndWait();
      }
         catch (SQLException ex) {
           
         } 
    
    }

    
    @Override
    public void deleteReport(int R_ID) {
    
        try {
               con = dbCon.geConnection();            
                
               pst = con.prepareStatement("delete from CBC_Report where R_ID="+R_ID);
                pst.executeUpdate();               
                pst.close();
                con.close();
               
            } 
             catch (SQLException ex) {
             
             }
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Selected CBC Report Deleted Succesfully.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Report2.png").toString()));     
        alert.showAndWait();
        
    } 

}
