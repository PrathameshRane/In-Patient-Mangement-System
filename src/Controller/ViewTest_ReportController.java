package Controller;

import DAO.Test_ReportDAO;
import DAOImpl.Test_ReportDAOImpl;
import List.ListTest_Report;
import Model.Test_Report;
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

public class ViewTest_ReportController implements Initializable {

    Test_Report TR = new Test_Report();
    
    ObservableList<ListTest_Report > TestReportDetails = FXCollections.observableArrayList();
    
    @FXML
    private TableView<ListTest_Report> TestReportTable;
    @FXML
    private TableColumn<Object, Object> TR_ID;
    @FXML
    private TableColumn<Object, Object> P_ID;
    @FXML
    private TableColumn<Object, Object> T_ID;
    @FXML
    private TableColumn<Object, Object> R_ID;
    @FXML
    private TableColumn<Object, Object> R_NAME;
    @FXML
    private TableColumn<Object, Object> R_DATE;
    
    @FXML
    private TextField SearchTR_ID;   
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

    public Test_ReportDAO TRDAO = new Test_ReportDAOImpl();
    
    @FXML
    private void btnSearchTestReport(ActionEvent event){
        
        TestReportDetails.clear();
        
        TR.setTR_ID(Integer.parseInt(SearchTR_ID.getText()));
        int trid = TR.getTR_ID();
        TestReportDetails = TRDAO.getReport(trid);
        
        showTestReport(TestReportDetails);
           
    }
    
    @FXML
    private void btnAddNewTestReport(ActionEvent event){
        
        AddNewTest_ReportController addNewTest_ReportController = new AddNewTest_ReportController();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/View/AddNewTest_Report.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            AddNewTest_ReportController NewTest_ReportController = fxmlLoader.getController();
            NewTest_ReportController.Savebtn.setVisible(true);
            NewTest_ReportController.Updatebtn.setVisible(false);
            Stage nStage = new Stage();
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.setTitle("Add Test Report");
         
            nStage.show();
        }
            catch (IOException e) {
        }
    }
    
    @FXML
    private void btnUpdateTestReport(ActionEvent event){
        
        if(TestReportTable.getSelectionModel().getSelectedItem() != null){
          
            ListTest_Report selectedTestReport = TestReportTable.getSelectionModel().getSelectedItem();
            
                int tr = selectedTestReport.getTR_ID();
                if (tr != 0) {
        AddNewTest_ReportController addNewTest_ReportController = new AddNewTest_ReportController();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/View/AddNewTest_Report.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            AddNewTest_ReportController NewTest_ReportController = fxmlLoader.getController();  
            NewTest_ReportController.Savebtn.setVisible(false);
            NewTest_ReportController.Updatebtn.setVisible(true);          
            NewTest_ReportController.tr_id = selectedTestReport.getTR_ID();           
            NewTest_ReportController.showDetails();
            Stage nStage = new Stage();
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.setTitle("Update Test Report");
            nStage.show();
            
        } catch (IOException e) {
        }
                    
                }
        }
        else {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Select Test Report");
        alert.setHeaderText("Please Select One Test Report.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Report2.png").toString()));
        alert.showAndWait();
        }
        
    }
    
    @FXML
    private void btnDeleteTestReport(ActionEvent event){
        
        if(TestReportTable.getSelectionModel().getSelectedItem() != null){
          
            ListTest_Report selectedTestReport = TestReportTable.getSelectionModel().getSelectedItem();
            
                int tr = selectedTestReport.getP_ID();
                if (tr != 0) {
                    
                    TRDAO.deleteReport(selectedTestReport.getTR_ID());
                    
                }
        }
        else {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Select Test Report");
        alert.setHeaderText("Please Select One Test Report.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Report2.png").toString()));
        alert.showAndWait();
        }
        
    }
    
    @FXML
    private void btnViewAllTestReport(ActionEvent event){
        
        TestReportDetails.clear();
        
        TestReportDetails = TRDAO.getAllReport();
        
        showTestReport(TestReportDetails);
        
    }
    
    @FXML
    private void btnRefresh(ActionEvent event){
        
        TestReportDetails.clear();
        
        TestReportDetails = TRDAO.getAllReport();
        
        
        showTestReport(TestReportDetails);
        
    }
    
    public void showTestReport(ObservableList<ListTest_Report> testreportDetails){
       
        
        TestReportTable.setItems(testreportDetails);
        TR_ID.setCellValueFactory(new PropertyValueFactory<>("TR_ID"));
        P_ID.setCellValueFactory(new PropertyValueFactory<>("P_ID"));
        T_ID.setCellValueFactory(new PropertyValueFactory<>("T_ID"));
        R_ID.setCellValueFactory(new PropertyValueFactory<>("R_ID"));
        R_NAME.setCellValueFactory(new PropertyValueFactory<>("R_NAME"));
        R_DATE.setCellValueFactory(new PropertyValueFactory<>("R_DATE"));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
