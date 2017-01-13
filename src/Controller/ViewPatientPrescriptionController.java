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
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ViewPatientPrescriptionController implements Initializable {

    Patient_Prescription PP = new Patient_Prescription();
    
    ObservableList<ListPatient_Prescription> PatientPrescription = FXCollections.observableArrayList();
    
    @FXML
    private TableView<ListPatient_Prescription> PatientPrescriptionTable;
    @FXML
    private TableColumn<Object, Object> PID;
    @FXML
    private TableColumn<Object, Object> DNAME;
    @FXML
    private TableColumn<Object, Object> MEDICATION;
    @FXML
    private TableColumn<Object, Object> DOSE;
     @FXML
    private TableColumn<Object, Object> TEST;
     
    @FXML
    private TextField SearchPatientID;   
    @FXML
    private Button Search;
    @FXML
    private Button AddNew;   
    
    public Patient_PrescriptionDAO PPDAO = new Patient_PrescriptionDAOImpl();
    
    
    @FXML
    private void btnSearchPatientID(ActionEvent event){
        
        PatientPrescription.clear();
        
        PP.setP_ID(Integer.parseInt(SearchPatientID.getText()));
        int ID = PP.getP_ID();
        
        PatientPrescription = PPDAO.getPrescription(ID);
        
        showPatient(PatientPrescription);
        
    }
    
    @FXML
    private void btnAddNewPatientPrescription(ActionEvent event){
        
       PatientPrescriptionController patientPrescriptionController = new PatientPrescriptionController();
       FXMLLoader fxmlLoader = new FXMLLoader();
       fxmlLoader.setLocation(getClass().getResource("/View/PatientPrescription.fxml"));
       try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            PatientPrescriptionController patientprescriptioncontroller = fxmlLoader.getController();
            patientprescriptioncontroller.Savebtn.setVisible(true);
            Stage nStage = new Stage();
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.setTitle("Add Patient Prescription");
            nStage.show();
        } catch (IOException e) {
        }
        
    }
    
    
    public void showPatient(ObservableList<ListPatient_Prescription> PatientPrescription){
        
        PatientPrescriptionTable.setItems(PatientPrescription);
        PID.setCellValueFactory(new PropertyValueFactory<>("P_ID"));
        DNAME.setCellValueFactory(new PropertyValueFactory<>("D_NAME"));
        MEDICATION.setCellValueFactory(new PropertyValueFactory<>("MEDICATION"));
        DOSE.setCellValueFactory(new PropertyValueFactory<>("DOSE"));
        TEST.setCellValueFactory(new PropertyValueFactory<>("TEST"));
    
    }
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
