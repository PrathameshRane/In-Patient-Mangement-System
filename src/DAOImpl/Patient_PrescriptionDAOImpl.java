
package DAOImpl;

import DAO.Patient_PrescriptionDAO;
import Database.DBConnection;
import List.ListPatient_Prescription;
import Model.Patient_Prescription;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;



public class Patient_PrescriptionDAOImpl implements Patient_PrescriptionDAO {
    
    DBConnection dbCon = new DBConnection();
      Connection con;
      PreparedStatement pst;
      ResultSet rs;
      
      ObservableList<ListPatient_Prescription> PatientPrescription = FXCollections.observableArrayList();
      Patient_Prescription PP = new Patient_Prescription();   

    @Override
    public void addPrescription(Patient_Prescription PP) {
      
        try {
            con = dbCon.geConnection();
            pst = con.prepareStatement("insert into Prescription(P_ID, D_NAME, MEDICATION, DOSE,TEST ) values(?,?,?,?,?)");
           
            pst.setInt(1, PP.getP_ID());
            pst.setString(2, PP.getD_NAME());
            pst.setString(3, PP.getMEDICATION());
            pst.setString(4, PP.getDOSE());
            pst.setString(5, PP.getTEST());
            pst.executeUpdate();
            pst.close();
            con.close();
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Patient Prescription Added Succesfully.");
        alert.setContentText("Patient Prescription Added Succesfully." );
        alert.showAndWait();
    }
         catch (SQLException ex) {
       
         }
    
    }

    @Override
    public ObservableList<ListPatient_Prescription> getPrescription(int p_id) {
   
        PatientPrescription.clear();
        
        try {
               con = dbCon.geConnection();            
                
               pst = con.prepareStatement("select * from Prescription where P_ID like ?");
                pst.setInt(1, p_id  );                        
                rs = pst.executeQuery();
                while (rs.next()) {
                    PP.setP_ID(rs.getInt(1));
                    PP.setD_NAME(rs.getString(2));
                    PP.setMEDICATION(rs.getString(3));
                    PP.setDOSE(rs.getString(4));
                    PP.setTEST(rs.getString(5));
    
                    PatientPrescription.add(new ListPatient_Prescription(PP.getP_ID(),PP.getD_NAME(),PP.getMEDICATION(),PP.getDOSE(),PP.getTEST()));
                
                        }
                pst.close();
                con.close();
                rs.close();
            } catch (SQLException ex) {
              Logger.getLogger(Patient_PrescriptionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);           
          }
    
        return PatientPrescription;
    }
}  
