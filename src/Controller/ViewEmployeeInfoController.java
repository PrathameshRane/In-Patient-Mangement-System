package Controller;

import DAO.EmployeeDAO;
import DAOImpl.EmployeeDAOImpl;
import List.ListEmployee;
import Model.Employee;
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

public class ViewEmployeeInfoController implements Initializable {
    
    Employee E = new Employee();
    
    ObservableList<ListEmployee> EmployeeDetails = FXCollections.observableArrayList();

    @FXML
    private TableView<ListEmployee> EmployeeInfoTable;
    @FXML
    private TableColumn<Object, Object> EID;
    @FXML
    private TableColumn<Object, Object> ENAME;
    @FXML
    private TableColumn<Object, Object> ADDRESS;
    @FXML
    private TableColumn<Object, Object> MOBILENO;
    @FXML
    private TableColumn<Object, Object> ROLE;
    
    @FXML
    private TextField SearchEmployee;   
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
    
    public EmployeeDAO EDAO = new EmployeeDAOImpl();
    
    @FXML
    private void btnSearchEmployee(ActionEvent event){
        
        EmployeeDetails.clear();
        
        E.setNAME(SearchEmployee.getText());
        String name=E.getNAME();
        
        EmployeeDetails = EDAO.getEmployee(name);
        
        showEmployee(EmployeeDetails);
        
    }
    
    @FXML
    private void btnAddNewEmployee(ActionEvent event){
        
        AddEmployeeController addEmployeeController = new AddEmployeeController();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/View/AddEmployee.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            AddEmployeeController EmployeeController = fxmlLoader.getController();
            EmployeeController.Savebtn.setVisible(true);
            EmployeeController.Updatebtn.setVisible(false);
            Stage nStage = new Stage();
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.setTitle("Add Employee");
            nStage.show();
        }
            catch (IOException e) {
        }
    }
    
     @FXML
    private void btnUpdateEmployee(ActionEvent event){
        
        if(EmployeeInfoTable.getSelectionModel().getSelectedItem() != null){
          
            ListEmployee selectedEmployee = EmployeeInfoTable.getSelectionModel().getSelectedItem();
            
                int items = selectedEmployee.getE_ID();                
                if (items != 0) {
                    
        AddEmployeeController addEmployeeController = new AddEmployeeController();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/View/AddEmployee.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            AddEmployeeController EmployeeController = fxmlLoader.getController();
            EmployeeController.Savebtn.setVisible(false);
            EmployeeController.Updatebtn.setVisible(true);
            EmployeeController.eid = selectedEmployee.getE_ID();
            EmployeeController.showDetails();
            Stage nStage = new Stage();
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.setTitle("Update Employee");
            nStage.show();
        } 
        catch (IOException e) {
            
           }
                           
         }
      }
        else {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Select Employee");
        alert.setHeaderText("Please Select One Employee.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Employee2.png").toString()));
        alert.showAndWait();
        }
        
    }
    
    @FXML
    private void btnDeleteEmployee(ActionEvent event){
        
         if(EmployeeInfoTable.getSelectionModel().getSelectedItem() != null){
          
            ListEmployee selectedEmployee = EmployeeInfoTable.getSelectionModel().getSelectedItem();
            
                int items = selectedEmployee.getE_ID();
                if (items != 0) {
                    
                    EDAO.deleteEmployee(selectedEmployee.getE_ID());
                }
                else {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Select Employee");
        alert.setHeaderText("Please Select One Employee.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Employee2.png").toString()));
        alert.showAndWait();
        }
       }
        
    }
    
    @FXML
    private void btnViewAllEmployee(ActionEvent event){
        
        EmployeeDetails.clear();
        
        EmployeeDetails = EDAO.getAllEmployee();
        
        showEmployee(EmployeeDetails);
        
    }
    
    @FXML
    private void btnRefresh(ActionEvent event){
        
        EmployeeDetails.clear();
        
        EmployeeDetails = EDAO.getAllEmployee();
        
        showEmployee(EmployeeDetails);
        
    }
    
    public void showEmployee(ObservableList<ListEmployee> EmployeeDetails){
        
        EmployeeInfoTable.setItems(EmployeeDetails);
        EID.setCellValueFactory(new PropertyValueFactory<>("E_ID"));
        ENAME.setCellValueFactory(new PropertyValueFactory<>("NAME"));
        ADDRESS.setCellValueFactory(new PropertyValueFactory<>("ADDRESS"));
        MOBILENO.setCellValueFactory(new PropertyValueFactory<>("MOBILE_NO"));
        ROLE.setCellValueFactory(new PropertyValueFactory<>("ROLE"));
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
