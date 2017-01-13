package DAOImpl;

import Controller.AddPatientController;
import DAO.PatientDAO;
import Database.DBConnection;
import List.ListPatient;
import Model.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;

public class PatientDAOImpl implements PatientDAO {
    
      DBConnection dbCon = new DBConnection();
      Connection con;
      PreparedStatement pst;
      ResultSet rs;
      
      ObservableList<ListPatient> PatientDetails = FXCollections.observableArrayList();
      Patient P = new Patient();

    @Override
    public void addPatient(Patient P){
       
        try {
            con = dbCon.geConnection();
            pst = con.prepareStatement("insert into Patient_Info(NAME,DOB,GENDER,AGE,WEIGHT,BLOOD_GRP,ADDRESS,MOBILE_NO,GUARDIAN_NAME,GUARDIAN_MOB_NO,ADMISSION_DATE,BED_NO,D_NAME,ILLNESS) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            pst.setString(1, P.getNAME());
            pst.setString(2, P.getDOB());
            pst.setString(3, P.getGENDER());
            pst.setInt(4, P.getAGE());
            pst.setInt(5, P.getWEIGHT());
            pst.setString(6, P.getBLOOD_GRP());
            pst.setString(7, P.getADDRESS());
            pst.setString(8, P.getMOBILE_NO());
            pst.setString(9, P.getGUARDIAN_NAME());
            pst.setString(10, P.getGUARDIAN_MOB_NO());
            pst.setString(11, P.getADMISSION_DATE());
            pst.setInt(12, P.getBED_NO());
            pst.setString(13, P.getD_NAME());
            pst.setString(14, P.getILLNESS());
            pst.executeUpdate();
            pst.close();
            con.close();
  
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Patient Added Succesfully.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Patient2.png").toString()));
        alert.setContentText("Patient Name :" + "  " + P.getNAME() + " " );
        alert.showAndWait();
    }
         catch (SQLException ex) {
            Logger.getLogger(AddPatientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ObservableList<ListPatient> getAllPatient() {
   
        PatientDetails.clear();
            try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select * from Patient_Info");
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        P.setP_ID(rs.getInt(1));
                        P.setNAME(rs.getString(2));
                        P.setDOB(rs.getString(3));
                        P.setGENDER(rs.getString(4));
                        P.setAGE(rs.getInt(5));
                        P.setWEIGHT(rs.getInt(6));
                        P.setBLOOD_GRP(rs.getString(7));
                        P.setADDRESS(rs.getString(8));
                        P.setMOBILE_NO(rs.getString(9));
                        P.setGUARDIAN_NAME(rs.getString(10));
                        P.setGUARDIAN_MOB_NO(rs.getString(11));
                        P.setADMISSION_DATE(rs.getString(12));
                        P.setBED_NO(rs.getInt(13));
                        P.setD_NAME(rs.getString(14));
                        P.setILLNESS(rs.getString(15));
                        
                        
                        PatientDetails.add( new ListPatient(P.getP_ID(),P.getNAME(),P.getDOB(),P.getGENDER(),P.getAGE(),P.getWEIGHT(),P.getBLOOD_GRP(),P.getADDRESS(),P.getMOBILE_NO(),P.getGUARDIAN_NAME(),P.getGUARDIAN_MOB_NO(),P.getADMISSION_DATE(),P.getBED_NO(),P.getD_NAME(),P.getILLNESS()));
                        
                    }
                    pst.close();
                    con.close();
                    rs.close();
                
            }
            catch (SQLException ex) {
              Logger.getLogger(PatientDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
               
            return PatientDetails;
   
    }

    @Override
    public ObservableList<ListPatient> getPatient(String pname) {
      
          PatientDetails.clear();
          
          try {
               con = dbCon.geConnection();            
                
               pst = con.prepareStatement("select * from Patient_Info where NAME like ? ORDER BY P_ID");
                         
                pst.setString(1, "%" + pname + "%");
                rs = pst.executeQuery();
                while (rs.next()) {
                    P.setP_ID(rs.getInt(1));
                    P.setNAME(rs.getString(2));
                    P.setDOB(rs.getString(3));
                    P.setGENDER(rs.getString(4));
                    P.setAGE(rs.getInt(5));
                    P.setWEIGHT(rs.getInt(6));
                    P.setBLOOD_GRP(rs.getString(7));
                    P.setADDRESS(rs.getString(8));
                    P.setMOBILE_NO(rs.getString(9));
                    P.setGUARDIAN_NAME(rs.getString(10));
                    P.setGUARDIAN_MOB_NO(rs.getString(11));
                    P.setADMISSION_DATE(rs.getString(12));
                    P.setBED_NO(rs.getInt(13));
                    P.setD_NAME(rs.getString(14));
                    P.setILLNESS(rs.getString(15));
                        
                        
                    PatientDetails.add( new ListPatient(P.getP_ID(),P.getNAME(),P.getDOB(),P.getGENDER(),P.getAGE(),P.getWEIGHT(),P.getBLOOD_GRP(),P.getADDRESS(),P.getMOBILE_NO(),P.getGUARDIAN_NAME(),P.getGUARDIAN_MOB_NO(),P.getADMISSION_DATE(),P.getBED_NO(),P.getD_NAME(),P.getILLNESS()));
                        
                }
                pst.close();
                con.close();
                rs.close();
            } catch (SQLException ex) {
              Logger.getLogger(PatientDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
          }
    
     return PatientDetails;
    
    }

    @Override
    public ListPatient selectedPatient(ListPatient LP) {
        
        try {
            con = dbCon.geConnection();
            
            pst = con.prepareStatement("select * from Patient_Info where P_ID=?");
            pst.setInt(1, LP.getP_ID());
            rs = pst.executeQuery();
            while (rs.next()) {
            
                LP.setP_ID(rs.getInt(1));
                LP.setNAME(rs.getString(2));
                LP.setDOB(rs.getString(3));
                LP.setGENDER(rs.getString(4));
                LP.setAGE(rs.getInt(5));
                LP.setWEIGHT(rs.getInt(6));
                LP.setBLOOD_GRP(rs.getString(7));
                LP.setADDRESS(rs.getString(8));
                LP.setMOBILE_NO(rs.getString(9));
                LP.setGUARDIAN_NAME(rs.getString(10));
                LP.setGUARDIAN_MOB_NO(rs.getString(11));
                LP.setADMISSION_DATE(rs.getString(12));
                LP.setBED_NO(rs.getInt(13));
                LP.setD_NAME(rs.getString(14));
                LP.setILLNESS(rs.getString(15));
            }
            pst.close();
            con.close();
            rs.close();
        } 
        catch (SQLException e) {
        }
        
        return LP;
   }

    @Override
    public void updatePatient(Patient P) {
        try {
            con = dbCon.geConnection();
            pst = con.prepareStatement("update Patient_Info set NAME=?,DOB=?,GENDER=?,AGE=?,WEIGHT=?,BLOOD_GRP=?,ADDRESS=?,MOBILE_NO=?,GUARDIAN_NAME=?,GUARDIAN_MOB_NO=?,ADMISSION_DATE=?,BED_NO=?,D_NAME=?,ILLNESS=? where P_ID=?");
            
            pst.setString(1, P.getNAME());
            pst.setString(2, P.getDOB());
            pst.setString(3, P.getGENDER());
            pst.setInt(4, P.getAGE());
            pst.setInt(5, P.getWEIGHT());
            pst.setString(6, P.getBLOOD_GRP());
            pst.setString(7, P.getADDRESS());
            pst.setString(8, P.getMOBILE_NO());
            pst.setString(9, P.getGUARDIAN_NAME());
            pst.setString(10, P.getGUARDIAN_MOB_NO());
            pst.setString(11, P.getADMISSION_DATE());
            pst.setInt(12, P.getBED_NO());
            pst.setString(13, P.getD_NAME());
            pst.setString(14, P.getILLNESS());
            pst.setInt(15, P.getP_ID());
            pst.executeUpdate();
            pst.close();
            con.close();     
    }
         catch (SQLException ex) {
            Logger.getLogger(AddPatientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Patient Updated Succesfully.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Patient2.png").toString()));
        alert.setContentText("Patient Name :" + "  " + P.getNAME() + " " );
        alert.showAndWait();
    }

    @Override
    public void deletePatient(int P_ID) {
    
        try {
               con = dbCon.geConnection();            
                
               pst = con.prepareStatement("delete from Patient_Info where P_ID="+P_ID);
                pst.executeUpdate();               
                pst.close();
                con.close();
               
            } 
             catch (SQLException ex) {
              Logger.getLogger(PatientDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
          }
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Selected Patient Deleted Succesfully.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Patient2.png").toString()));     
        alert.showAndWait();
        
    }
    
}