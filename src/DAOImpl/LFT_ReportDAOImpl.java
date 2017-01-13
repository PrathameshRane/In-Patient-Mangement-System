package DAOImpl;

import DAO.LFT_ReportDAO;
import Database.DBConnection;
import List.ListLFT_Report;
import Model.LFT_Report;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;


public class LFT_ReportDAOImpl implements LFT_ReportDAO {

    DBConnection dbCon = new DBConnection();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public ObservableList<ListLFT_Report> LFTReportDetails = FXCollections.observableArrayList();
    LFT_Report LR = new LFT_Report(); 
    
    
    @Override
    public void addReport(LFT_Report LR) {
    
        try {
            con = dbCon.geConnection();
            pst = con.prepareStatement("insert into LFT_Report(P_ID,Bilirubin_Total,SGOT,SGPT,Alkaline_Phosphatase,Proteins,Albumin,Globulin,AG_Ratio,GGTP) values(?,?,?,?,?,?,?,?,?,?)");
             
            pst.setInt(1, LR.getP_ID());
            pst.setString(2, LR.getBilirubin_Total());
            pst.setString(3, LR.getSGOT());
            pst.setString(4, LR.getSGPT());
            pst.setString(5, LR.getAlkaline_Phosphatase());
            pst.setString(6, LR.getProteins());
            pst.setString(7, LR.getAlbumin());
            pst.setString(8, LR.getGlobulin());
            pst.setString(9, LR.getAG_Ratio());
            pst.setString(10, LR.getGGTP());
            
            pst.executeUpdate();
            pst.close();
            con.close();
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("LFT Report Added Succesfully.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Report2.png").toString()));
        alert.setContentText("Patient ID :" + "  " + LR.getP_ID() + " " );
        alert.showAndWait();
      }
         catch (SQLException ex) {
           
         }
    
    }

    @Override
    public ObservableList<ListLFT_Report> getReport(int R_ID) {
    
        LFTReportDetails.clear();
        try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select * from LFT_Report where R_ID = ? ORDER BY R_ID");
                    pst.setInt(1, R_ID);
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        LR.setR_ID(rs.getInt(1));
                        LR.setP_ID(rs.getInt(2));
                        LR.setBilirubin_Total(rs.getString(3));
                        LR.setSGOT(rs.getString(4));
                        LR.setSGPT(rs.getString(5));
                        LR.setAlkaline_Phosphatase(rs.getString(6));
                        LR.setProteins(rs.getString(7));
                        LR.setAlbumin(rs.getString(8));
                        LR.setGlobulin(rs.getString(9));
                        LR.setAG_Ratio(rs.getString(10));
                        LR.setGGTP(rs.getString(11));
                                              
                        
                        LFTReportDetails.add(new ListLFT_Report(LR.getR_ID(),LR.getP_ID(), LR.getBilirubin_Total(), LR.getSGOT(), LR.getSGPT(), LR.getAlkaline_Phosphatase(), LR.getProteins(), LR.getAlbumin(), LR.getGlobulin(), LR.getAG_Ratio(), LR.getGGTP()));
                        
                    }
                    
                     pst.close();
                    con.close();
                    rs.close();
                 }
            catch (SQLException ex) {
              
            }
        
        return LFTReportDetails;
    
    }

    @Override
    public ObservableList<ListLFT_Report> getAllReport() {
    
        LFTReportDetails.clear();
        try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select * from LFT_Report");                   
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        LR.setR_ID(rs.getInt(1));
                        LR.setP_ID(rs.getInt(2));
                        LR.setBilirubin_Total(rs.getString(3));
                        LR.setSGOT(rs.getString(4));
                        LR.setSGPT(rs.getString(5));
                        LR.setAlkaline_Phosphatase(rs.getString(6));
                        LR.setProteins(rs.getString(7));
                        LR.setAlbumin(rs.getString(8));
                        LR.setGlobulin(rs.getString(9));
                        LR.setAG_Ratio(rs.getString(10));
                        LR.setGGTP(rs.getString(11));
                                                
                        
                         LFTReportDetails.add(new ListLFT_Report(LR.getR_ID(),LR.getP_ID(), LR.getBilirubin_Total(), LR.getSGOT(), LR.getSGPT(), LR.getAlkaline_Phosphatase(), LR.getProteins(), LR.getAlbumin(), LR.getGlobulin(), LR.getAG_Ratio(), LR.getGGTP()));
                        
                    }
                    
                     pst.close();
                    con.close();
                    rs.close();
                 }
            catch (SQLException ex) {
              
            }
        return LFTReportDetails;
    
    }
    
     @Override
    public ListLFT_Report selectedReport(ListLFT_Report LLR) {
    
        try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select * from LFT_Report where R_ID=?");
                    pst.setInt(1, LLR.getR_ID());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        LLR.setR_ID(rs.getInt(1));
                        LLR.setP_ID(rs.getInt(2));
                        LLR.setBilirubin_Total(rs.getString(3));
                        LLR.setSGOT(rs.getString(4));
                        LLR.setSGPT(rs.getString(5));
                        LLR.setAlkaline_Phosphatase(rs.getString(6));
                        LLR.setProteins(rs.getString(7));
                        LLR.setAlbumin(rs.getString(8));
                        LLR.setGlobulin(rs.getString(9));
                        LLR.setAG_Ratio(rs.getString(10));
                        LLR.setGGTP(rs.getString(11));
                       
                          }
                    
                     pst.close();
                    con.close();
                    rs.close();
                 }
            catch (SQLException ex) {
              
            }
               
            return LLR;
    
    }
    
    @Override
    public void updateReport(LFT_Report LR) {
    
        try {
            con = dbCon.geConnection();
            pst = con.prepareStatement("update LFT_Report set P_ID=?,Haemoglobin=?,RBC_Count=?,PCV=?,MCV=?,MCH=?,MCHC=?,RDW=?,Total_WBC_Count=?,Neutrophils=?,Lymphocytes=?,Eosinophils=?,Monocytes=?,Basophils=?,Platelet_Count=? where R_ID=?");
           
            pst.setInt(1, LR.getP_ID());
            pst.setString(2, LR.getBilirubin_Total());
            pst.setString(3, LR.getSGOT());
            pst.setString(4, LR.getSGPT());
            pst.setString(5, LR.getAlkaline_Phosphatase());
            pst.setString(6, LR.getProteins());
            pst.setString(7, LR.getAlbumin());
            pst.setString(8, LR.getGlobulin());
            pst.setString(9, LR.getAG_Ratio());
            pst.setString(10, LR.getGGTP());

            
            pst.setInt(11, LR.getR_ID());
           
            
            pst.executeUpdate();
            pst.close();
            con.close();
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("LFT Report Updated Succesfully.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Report2.png").toString()));
        alert.setContentText("Patient ID :" + "  " + LR.getP_ID() + " " );
        alert.showAndWait();
      }
         catch (SQLException ex) {
           
         } 
    
    }

    @Override
    public void deleteReport(int R_ID) {
    
        try {
               con = dbCon.geConnection();            
                
               pst = con.prepareStatement("delete from LFT_Report where R_ID="+R_ID);
                pst.executeUpdate();               
                pst.close();
                con.close();
               
            } 
             catch (SQLException ex) {
             
             }
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Selected LFT Report Deleted Succesfully.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Report2.png").toString()));     
        alert.showAndWait();
        
    } 
    
}