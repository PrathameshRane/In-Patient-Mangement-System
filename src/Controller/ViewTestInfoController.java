package Controller;

import DAO.TestDAO;
import DAOImpl.TestDAOImpl;
import List.ListPatient_Test;
import Model.Patient_Test;
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

public class ViewTestInfoController implements Initializable {
    
    Patient_Test T = new Patient_Test();
    
    ObservableList<ListPatient_Test > TestDetails = FXCollections.observableArrayList();
    
    @FXML
    private TableView<ListPatient_Test> TestTable;
    @FXML
    private TableColumn<Object, Object> TID;
    @FXML
    private TableColumn<Object, Object> PID;
    @FXML
    private TableColumn<Object, Object> TEST_NAME;
    @FXML
    private TableColumn<Object, Object> TEST_DATE;
    
    @FXML
    private TextField SearchPatientID;   
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

    public TestDAO TDAO = new TestDAOImpl();
    
    @FXML
    private void btnSearchPatientID(ActionEvent event){
        
        TestDetails.clear();
        
        T.setP_ID(Integer.parseInt(SearchPatientID.getText()));
        int pid = T.getP_ID();
        TestDetails = TDAO.getTest(pid);
        
        showTest(TestDetails);
     
    }
    
    @FXML
    private void btnAddNewTest(ActionEvent event){
        
        AddTestController addTestController = new AddTestController();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/View/AddTest.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            AddTestController TestController = fxmlLoader.getController();
            TestController.Savebtn.setVisible(true);
            TestController.Updatebtn.setVisible(false);
            Stage nStage = new Stage();
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.setTitle("Add Test");
         
            nStage.show();
        }
            catch (IOException e) {
        }
        
    }
    
    @FXML
    private void btnUpdateTest(ActionEvent event){
        
        if(TestTable.getSelectionModel().getSelectedItem() != null){
          
            ListPatient_Test selectedTest = TestTable.getSelectionModel().getSelectedItem();
            
                int items = selectedTest.getP_ID();
                if (items != 0) {
        AddTestController addTestController = new AddTestController();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/View/AddTest.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            AddTestController testController = fxmlLoader.getController();  
            testController.Savebtn.setVisible(false);
            testController.Updatebtn.setVisible(true);          
            testController.tid = selectedTest.getT_ID();
            testController.showDetails();
            Stage nStage = new Stage();
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.setTitle("Update Test");
            nStage.show();
            
        } catch (IOException e) {
        }
                    
                }
        }
        else {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Select Patient Test");
        alert.setHeaderText("Please Select One Patient Test.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Test2.png").toString()));
        alert.showAndWait();
        }
        
    }
    
    @FXML
    private void btnDeleteTest(ActionEvent event){
        
        if(TestTable.getSelectionModel().getSelectedItem() != null){
          
            ListPatient_Test selectedTest = TestTable.getSelectionModel().getSelectedItem();
            
                int items = selectedTest.getP_ID();
                if (items != 0) {
                    
                    TDAO.deleteTest(selectedTest.getP_ID());
                    
                }
        }
        else {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Select Patient Test");
        alert.setHeaderText("Please Select One Patient Test.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Test2.png").toString()));
        alert.showAndWait();
        }
        
    }
    
    @FXML
    private void btnViewAllTest(ActionEvent event){    
      
        TestDetails.clear();
        
        TestDetails = TDAO.getAllTest();
        
        showTest(TestDetails);
    }
    
    @FXML
    private void btnRefresh(ActionEvent event){
        
        TestDetails.clear();
        
        TestDetails = TDAO.getAllTest();
        
        
        showTest(TestDetails);
    }
    
    
    
    public void showTest(ObservableList<ListPatient_Test> testDetails){
       
        
        TestTable.setItems(testDetails);
        TID.setCellValueFactory(new PropertyValueFactory<>("T_ID"));
        PID.setCellValueFactory(new PropertyValueFactory<>("P_ID"));
        TEST_NAME.setCellValueFactory(new PropertyValueFactory<>("T_NAME"));
        TEST_DATE.setCellValueFactory(new PropertyValueFactory<>("T_DATE"));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
