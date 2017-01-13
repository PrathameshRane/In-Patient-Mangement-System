package Controller;

import DAO.DoctorDAO;
import DAOImpl.DoctorDAOImpl;
import List.ListDoctor_Info;
import Model.Doctor_Info;
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

public class ViewDoctorInfoController implements Initializable {

    Doctor_Info D = new Doctor_Info();
    
    ObservableList<ListDoctor_Info> DoctorDetails = FXCollections.observableArrayList();
    
    @FXML
    private TableView<ListDoctor_Info> DoctorInfoTable;
    @FXML
    private TableColumn<Object, Object> DID;
    @FXML
    private TableColumn<Object, Object> DNAME;
    @FXML
    private TableColumn<Object, Object> ADDRESS;
    @FXML
    private TableColumn<Object, Object> MOBILENO;
    @FXML
    private TableColumn<Object, Object> SPECIALITY;
    
    @FXML
    private TextField SearchDoctor;   
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
    
    public DoctorDAO DDAO = new DoctorDAOImpl();
    
     @FXML
    private void btnSearchDoctor(ActionEvent event){
        
        DoctorDetails.clear();
        
        D.setD_NAME(SearchDoctor.getText());
        String name=D.getD_NAME();
        
        DoctorDetails = DDAO.getDoctor(name);
        
        showDoctor(DoctorDetails);
        
    }
    
    @FXML
    private void btnAddNewDoctor(ActionEvent event){
        
        AddDoctorController addDoctorController = new AddDoctorController();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/View/AddDoctor.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            AddDoctorController DoctorController = fxmlLoader.getController();
            DoctorController.Savebtn.setVisible(true);
            DoctorController.Updatebtn.setVisible(false);
            Stage nStage = new Stage();
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.setTitle("Add Doctor");
         
            nStage.show();
        }
            catch (IOException e) {
        }
    }
    
     @FXML
    private void btnUpdateDoctor(ActionEvent event){
        
        if(DoctorInfoTable.getSelectionModel().getSelectedItem() != null){
          
            ListDoctor_Info selectedPatient = DoctorInfoTable.getSelectionModel().getSelectedItem();
            
                int items = selectedPatient.getD_ID();
                if (items != 0) {
                    
        AddDoctorController addDoctorController = new AddDoctorController();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/View/AddDoctor.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            AddDoctorController DoctorController = fxmlLoader.getController();
            DoctorController.Savebtn.setVisible(false);
            DoctorController.Updatebtn.setVisible(true);
            DoctorController.did = selectedPatient.getD_ID();
            DoctorController.showDetails();
            Stage nStage = new Stage();
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.setTitle("Update Doctor");
            nStage.show();
        } 
        catch (IOException e) {
            
           }
                           
         }
      }
        else {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Select Doctor");
        alert.setHeaderText("Please Select One Doctor.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Doctor2.png").toString()));
        alert.showAndWait();
        }
        
    }
    
    @FXML
    private void btnDeleteDoctor(ActionEvent event){
        
         if(DoctorInfoTable.getSelectionModel().getSelectedItem() != null){
          
            ListDoctor_Info selectedPatient = DoctorInfoTable.getSelectionModel().getSelectedItem();
            
                int items = selectedPatient.getD_ID();
                if (items != 0) {
                    
                    DDAO.deleteDoctor(selectedPatient.getD_ID());
                }
                else {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Select Doctor");
        alert.setHeaderText("Please Select One Doctor.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Doctort2.png").toString()));
        alert.showAndWait();
        }
       }
        
    }
    
    @FXML
    private void btnViewAllDoctor(ActionEvent event){
        
        DoctorDetails.clear();
        
        DoctorDetails = DDAO.getAllDoctors();
        
        showDoctor(DoctorDetails);
        
    }
    
    @FXML
    private void btnRefresh(ActionEvent event){
        
        DoctorDetails.clear();
        
        DoctorDetails = DDAO.getAllDoctors();
        
        showDoctor(DoctorDetails);
        
    }
    
    public void showDoctor(ObservableList<ListDoctor_Info> DoctorDetails){
        
        DoctorInfoTable.setItems(DoctorDetails);
        DID.setCellValueFactory(new PropertyValueFactory<>("D_ID"));
        DNAME.setCellValueFactory(new PropertyValueFactory<>("D_NAME"));
        ADDRESS.setCellValueFactory(new PropertyValueFactory<>("ADDRESS"));
        MOBILENO.setCellValueFactory(new PropertyValueFactory<>("MOBILE_NO"));
        SPECIALITY.setCellValueFactory(new PropertyValueFactory<>("SPECIALITY"));
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
}
