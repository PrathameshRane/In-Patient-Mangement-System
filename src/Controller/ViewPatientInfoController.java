package Controller;

import DAO.PatientDAO;
import DAOImpl.PatientDAOImpl;
import List.ListPatient;
import Model.Patient;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class ViewPatientInfoController implements Initializable {
    
    Patient P = new Patient();
    
    ObservableList<ListPatient> PatientDetails = FXCollections.observableArrayList();
     
    @FXML
    private TableView<ListPatient> PatientInfoTable;
    @FXML
    private TableColumn<Object, Object> PID;
    @FXML
    private TableColumn<Object, Object> PNAME;
    @FXML
    private TableColumn<Object, Object> DOB;
    @FXML
    private TableColumn<Object, Object> GENDER;
    @FXML
    private TableColumn<Object, Object> AGE;
    @FXML
    private TableColumn<Object, Object> WEIGHT;
    @FXML
    private TableColumn<Object, Object> BLOOD_GRP;
    @FXML
    private TableColumn<Object, Object> ADDRESS;
    @FXML
    private TableColumn<Object, Object> MOBILE_NO;
    @FXML
    private TableColumn<Object, Object> GUARDIAN_NAME;
    @FXML
    private TableColumn<Object, Object> GUARDIAN_MOB_NO;
    @FXML
    private TableColumn<Object, Object> ADMISSION_DATE;
    @FXML
    private TableColumn<Object, Object> BED_NO;
    @FXML
    private TableColumn<Object, Object> D_NAME;
    @FXML
    private TableColumn<Object, Object> ILLNESS;
    
    @FXML
    private TextField SearchPatient;   
    @FXML
    private Button Search;
    @FXML
    private Button AddNew;
    @FXML
    private Button Update;
    @FXML
    private Button Delete;
    @FXML
    private Button ViewAll;    
    @FXML
    public Button Refresh;
    
    public PatientDAO PDAO = new PatientDAOImpl();
   
    
     @FXML
    private void btnSearchPatient(ActionEvent event){
          
        PatientDetails.clear();
        
        P.setNAME(SearchPatient.getText());
        String name = P.getNAME();
     
        PatientDetails = PDAO.getPatient(name);
         
        showPatient(PatientDetails);
                              
    }
    
    @FXML
    private void btnAddNewPatient(ActionEvent event){
        
        AddPatientController addPatientController = new AddPatientController();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/View/AddPatient.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            AddPatientController patientController = fxmlLoader.getController();
            patientController.Savebtn.setVisible(true);
            patientController.Updatebtn.setVisible(false);
            Stage nStage = new Stage();
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.setTitle("Add Patient");
            nStage.show();
        } catch (IOException e) {
        }
    }
    
    @FXML
    private void btnUpdatePatient(ActionEvent event){
        
        if(PatientInfoTable.getSelectionModel().getSelectedItem() != null){
          
            ListPatient selectedPatient = PatientInfoTable.getSelectionModel().getSelectedItem();
            
                int p = selectedPatient.getP_ID();
                if (p != 0) {
        AddPatientController addPatientController = new AddPatientController();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/View/AddPatient.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            AddPatientController patientController = fxmlLoader.getController();  
            patientController.Savebtn.setVisible(false);
            patientController.Updatebtn.setVisible(true);
            patientController.pid = selectedPatient.getP_ID();
            patientController.showDetails();
            Stage nStage = new Stage();
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.setTitle("Update Patient");
            nStage.show();
            
        } catch (IOException e) {
        }
                    
                }
        }
        else {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Select Patient");
        alert.setHeaderText("Please Select One Patient.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Patient2.png").toString()));
        alert.showAndWait();
        }
        
    }
    
     @FXML
    private void btnDeletePatient(ActionEvent event){
        
        if(PatientInfoTable.getSelectionModel().getSelectedItem() != null){
          
            ListPatient selectedPatient = PatientInfoTable.getSelectionModel().getSelectedItem();
            
                int items = selectedPatient.getP_ID();
                if (items != 0) {
                    
                    PDAO.deletePatient(selectedPatient.getP_ID());
                    
                }
        }
        else {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Select Patient");
        alert.setHeaderText("Please Select One Patient.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Patient2.png").toString()));
        alert.showAndWait();
        }
        
    }
    
    @FXML
    private void btnViewAllPatient(ActionEvent event){    
      
        PatientDetails.clear();
        
        PatientDetails = PDAO.getAllPatient();
        
        showPatient(PatientDetails);
    }
    
    @FXML
    private void btnRefresh(ActionEvent event){
        
        PatientDetails.clear();
        
        PatientDetails = PDAO.getAllPatient();
        
        showPatient(PatientDetails);
    }
    
 
     public void showPatient(ObservableList<ListPatient> PatientDetails){
        
        PatientInfoTable.setItems(PatientDetails);
        PID.setCellValueFactory(new PropertyValueFactory<>("P_ID"));
        PNAME.setCellValueFactory(new PropertyValueFactory<>("NAME"));
        DOB.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        GENDER.setCellValueFactory(new PropertyValueFactory<>("GENDER"));
        AGE.setCellValueFactory(new PropertyValueFactory<>("AGE"));
        WEIGHT.setCellValueFactory(new PropertyValueFactory<>("WEIGHT"));
        BLOOD_GRP.setCellValueFactory(new PropertyValueFactory<>("BLOOD_GRP"));
        ADDRESS.setCellValueFactory(new PropertyValueFactory<>("ADDRESS"));
        MOBILE_NO.setCellValueFactory(new PropertyValueFactory<>("MOBILE_NO"));
        GUARDIAN_NAME.setCellValueFactory(new PropertyValueFactory<>("GUARDIAN_NAME"));
        GUARDIAN_MOB_NO.setCellValueFactory(new PropertyValueFactory<>("GUARDIAN_MOB_NO"));
        ADMISSION_DATE.setCellValueFactory(new PropertyValueFactory<>("ADMISSION_DATE"));
        BED_NO.setCellValueFactory(new PropertyValueFactory<>("BED_NO"));
        D_NAME.setCellValueFactory(new PropertyValueFactory<>("D_NAME"));
        ILLNESS.setCellValueFactory(new PropertyValueFactory<>("ILLNESS"));
        
    }

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
 
    
     
}
