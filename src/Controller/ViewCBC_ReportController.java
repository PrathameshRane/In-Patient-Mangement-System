package Controller;

import DAO.CBC_ReportDAO;
import DAOImpl.CBC_ReportDAOImpl;
import List.ListCBC_Report;
import Model.CBC_Report;
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

public class ViewCBC_ReportController implements Initializable {

     CBC_Report C = new CBC_Report();
    
    ObservableList<ListCBC_Report> CBCReportDetails = FXCollections.observableArrayList();
     
    @FXML
    private TableView<ListCBC_Report> CBCReportTable;
    @FXML
    private TableColumn<Object, Object> RID;
    @FXML
    private TableColumn<Object, Object> PID;    
    @FXML
    private TableColumn<Object, Object> Haemoglobin;
    @FXML
    private TableColumn<Object, Object> RBC_Count;
    @FXML
    private TableColumn<Object, Object> PCV;
    @FXML
    private TableColumn<Object, Object> MCV;
    @FXML
    private TableColumn<Object, Object> MCH;
    @FXML
    private TableColumn<Object, Object> MCHC;
    @FXML
    private TableColumn<Object, Object> RDW;
    @FXML
    private TableColumn<Object, Object> Total_WBC_Count;
    @FXML
    private TableColumn<Object, Object> Neutrophils;
    @FXML
    private TableColumn<Object, Object> Lymphocytes;
    @FXML
    private TableColumn<Object, Object> Eosinophils;
    @FXML
    private TableColumn<Object, Object> Monocytes;
    @FXML
    private TableColumn<Object, Object> Basophils;
    @FXML
    private TableColumn<Object, Object> Platelet_Count;
    
    @FXML
    private TextField SearchReport;   
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
    
    public CBC_ReportDAO CDAO = new CBC_ReportDAOImpl();
    
    @FXML
    private void btnSearchReport(ActionEvent event){
          
        CBCReportDetails.clear();
        
            C.setR_ID(Integer.parseInt(SearchReport.getText()));
        int rid = C.getR_ID();
     
        CBCReportDetails = CDAO.getReport(rid);
         
        showReport(CBCReportDetails);
                              
    }
    
    @FXML
    private void btnAddNewReport(ActionEvent event){
        
        AddCBCReportController addCBCReportController = new AddCBCReportController();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/View/AddCBCReport.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            AddCBCReportController CBCReportController = fxmlLoader.getController();
            CBCReportController.Savebtn.setVisible(true);
            CBCReportController.Updatebtn.setVisible(false);
            Stage nStage = new Stage();
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.setTitle("Add CBC Report");
            nStage.show();
        } catch (IOException e) {
        
      }
    }
    
    @FXML
    private void btnUpdateReport(ActionEvent event){
        
        if(CBCReportTable.getSelectionModel().getSelectedItem() != null){
          
            ListCBC_Report selectedReport = CBCReportTable.getSelectionModel().getSelectedItem();
            
                int r = selectedReport.getR_ID();
                if (r != 0) {
        AddCBCReportController CBCReportController = new AddCBCReportController();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/View/AddCBCReport.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            AddCBCReportController ReportController = fxmlLoader.getController();  
            ReportController.Savebtn.setVisible(false);
            ReportController.Updatebtn.setVisible(true);
            ReportController.rid = selectedReport.getR_ID();
            ReportController.showDetails();
            Stage nStage = new Stage();
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.setTitle("Update CBC Report");
            nStage.show();
            
        }
        catch (IOException e) {
        
                 }         
             }
         }
    
        else {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Select Report");
        alert.setHeaderText("Please Select One Report.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Report2.png").toString()));
        alert.showAndWait();
        }
    }
    
    
    
     @FXML
    private void btnDeleteReport(ActionEvent event){
        
        if(CBCReportTable.getSelectionModel().getSelectedItem() != null){
          
            ListCBC_Report selectedReport = CBCReportTable.getSelectionModel().getSelectedItem();
            
                int r = selectedReport.getR_ID();
                if (r != 0) {
                    
                    CDAO.deleteReport(selectedReport.getR_ID());
                    
                }
        }
        else {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Select Report");
        alert.setHeaderText("Please Select One Report.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Report2.png").toString()));
        alert.showAndWait();
        }
        
    }
    
    @FXML
    private void btnViewAllReport(ActionEvent event){    
      
        CBCReportDetails.clear();
        
        CBCReportDetails = CDAO.getAllReport();
        
        showReport(CBCReportDetails);
        
    }
    
    @FXML
    private void btnRefresh(ActionEvent event){
        
        CBCReportDetails.clear();
        
        CBCReportDetails = CDAO.getAllReport();
        
        showReport(CBCReportDetails);
    }
    
 
     public void showReport(ObservableList<ListCBC_Report> CBCReportDetails){
        
        CBCReportTable.setItems(CBCReportDetails);
        RID.setCellValueFactory(new PropertyValueFactory<>("R_ID"));
        PID.setCellValueFactory(new PropertyValueFactory<>("P_ID"));
        Haemoglobin.setCellValueFactory(new PropertyValueFactory<>("Haemoglobin"));
        RBC_Count.setCellValueFactory(new PropertyValueFactory<>("RBC_Count"));
        PCV.setCellValueFactory(new PropertyValueFactory<>("PCV"));
        MCV.setCellValueFactory(new PropertyValueFactory<>("MCV"));
        MCH.setCellValueFactory(new PropertyValueFactory<>("MCH"));
        MCHC.setCellValueFactory(new PropertyValueFactory<>("MCHC"));
        RDW.setCellValueFactory(new PropertyValueFactory<>("RDW"));
        Total_WBC_Count.setCellValueFactory(new PropertyValueFactory<>("Total_WBC_Count"));
        Neutrophils.setCellValueFactory(new PropertyValueFactory<>("Neutrophils"));
        Lymphocytes.setCellValueFactory(new PropertyValueFactory<>("Lymphocytes"));
        Eosinophils.setCellValueFactory(new PropertyValueFactory<>("Eosinophils"));
        Monocytes.setCellValueFactory(new PropertyValueFactory<>("Monocytes"));
        Basophils.setCellValueFactory(new PropertyValueFactory<>("Basophils"));
        Platelet_Count.setCellValueFactory(new PropertyValueFactory<>("Platelet_Count"));
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
