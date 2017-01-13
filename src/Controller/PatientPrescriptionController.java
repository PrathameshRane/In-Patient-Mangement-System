/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Patient_PrescriptionDAO;
import DAOImpl.Patient_PrescriptionDAOImpl;
import List.ListPatient_Prescription;
import Model.Patient_Prescription;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PRATHAMESH
 */
public class PatientPrescriptionController implements Initializable {

    @FXML
    private TextField patient_ID;
       
     @FXML
    private ComboBox<String> given_by;

      @FXML
    public void GivenBySelect(MouseEvent event) {
         given_by.getItems().clear();
         given_by.getItems().addAll("Dr.KulKarni","Dr.Dave");
    }
     
     @FXML
    private TextField medication;
         
     @FXML
    private TextField dose;
     
    @FXML
    private TextField test;
          
    @FXML
    public Button Savebtn; 
     
     public Patient_Prescription PP = new Patient_Prescription();
     public ListPatient_Prescription LPP = new ListPatient_Prescription();
     public Patient_PrescriptionDAO PPDAO = new Patient_PrescriptionDAOImpl();
     
     
     @FXML
    public void btnSavePatientPrescription(ActionEvent event) throws SQLException{
        
        PP.setP_ID(Integer.parseInt(patient_ID.getText()));
        PP.setD_NAME(given_by.getValue());
        PP.setMEDICATION(medication.getText());
        PP.setDOSE(dose.getText());
        PP.setTEST(test.getText());
        
        PPDAO.addPrescription(PP);
        Stage  stage = (Stage) Savebtn.getScene().getWindow();
        stage.close();
    }
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
