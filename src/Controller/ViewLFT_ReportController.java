package Controller;

import DAO.LFT_ReportDAO;
import DAOImpl.LFT_ReportDAOImpl;
import List.ListLFT_Report;
import Model.LFT_Report;
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

public class ViewLFT_ReportController implements Initializable {

    LFT_Report L = new LFT_Report();
    
    ObservableList<ListLFT_Report> LFTReportDetails = FXCollections.observableArrayList();
     
    @FXML
    private TableView<ListLFT_Report> LFTReportTable;
    @FXML
    private TableColumn<Object, Object> RID;
    @FXML
    private TableColumn<Object, Object> PID;    
    @FXML
    private TableColumn<Object, Object> Bilirubin_Total;
    @FXML
    private TableColumn<Object, Object> SGOT;
    @FXML
    private TableColumn<Object, Object> SGPT;
    @FXML
    private TableColumn<Object, Object> Alkaline_Phosphatase;
    @FXML
    private TableColumn<Object, Object> Proteins;
    @FXML
    private TableColumn<Object, Object> Albumin;
    @FXML
    private TableColumn<Object, Object> Globulin;
    @FXML
    private TableColumn<Object, Object> AG_Ratio;
    @FXML
    private TableColumn<Object, Object> GGTP;
  
    
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
    
    public LFT_ReportDAO LDAO = new LFT_ReportDAOImpl();
    
    @FXML
    private void btnSearchReport(ActionEvent event){
          
        LFTReportDetails.clear();
        
        L.setR_ID(Integer.parseInt(SearchReport.getText()));
        int rid = L.getR_ID();
     
        LFTReportDetails = LDAO.getReport(rid);
         
        showReport(LFTReportDetails);
                              
    }
    
    @FXML
    private void btnAddNewReport(ActionEvent event){
        
        AddLFTReportController addLFTReportController = new AddLFTReportController();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/View/AddLFTReport.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            AddLFTReportController LFTReportController = fxmlLoader.getController();
            LFTReportController.Savebtn.setVisible(true);
            LFTReportController.Updatebtn.setVisible(false);
            Stage nStage = new Stage();
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.setTitle("Add LFT Report");
            nStage.show();
        } catch (IOException e) {
        
      }
    }
    
    @FXML
    private void btnUpdateReport(ActionEvent event){
        
        if(LFTReportTable.getSelectionModel().getSelectedItem() != null){
          
            ListLFT_Report selectedReport = LFTReportTable.getSelectionModel().getSelectedItem();
            
                int r = selectedReport.getR_ID();
                if (r != 0) {
        AddLFTReportController LFTReportController = new AddLFTReportController();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/View/AddLFTReport.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            AddLFTReportController ReportController = fxmlLoader.getController();  
            ReportController.Savebtn.setVisible(false);
            ReportController.Updatebtn.setVisible(true);
            ReportController.rid = selectedReport.getR_ID();
            ReportController.showDetails();
            Stage nStage = new Stage();
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.setTitle("Update LFT Report");
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
        
        if(LFTReportTable.getSelectionModel().getSelectedItem() != null){
          
            ListLFT_Report selectedReport = LFTReportTable.getSelectionModel().getSelectedItem();
            
                int r = selectedReport.getR_ID();
                if (r != 0) {
                    
                    LDAO.deleteReport(selectedReport.getR_ID());
                    
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
     
        LFTReportDetails.clear();
        
        LFTReportDetails = LDAO.getAllReport();
        
        showReport(LFTReportDetails);
        
    }
    
    @FXML
    private void btnRefresh(ActionEvent event){
        
        LFTReportDetails.clear();
        
        LFTReportDetails = LDAO.getAllReport();
        
        showReport(LFTReportDetails);
        
    }
    
     public void showReport(ObservableList<ListLFT_Report> LFTReportDetails){
        
        LFTReportTable.setItems(LFTReportDetails);
        RID.setCellValueFactory(new PropertyValueFactory<>("R_ID"));
        PID.setCellValueFactory(new PropertyValueFactory<>("P_ID"));
        Bilirubin_Total.setCellValueFactory(new PropertyValueFactory<>("Bilirubin_Total"));
        SGOT.setCellValueFactory(new PropertyValueFactory<>("SGOT"));
        SGPT.setCellValueFactory(new PropertyValueFactory<>("SGPT"));
        Alkaline_Phosphatase.setCellValueFactory(new PropertyValueFactory<>("Alkaline_Phosphatase"));
        Proteins.setCellValueFactory(new PropertyValueFactory<>("Proteins"));
        Albumin.setCellValueFactory(new PropertyValueFactory<>("Albumin"));
        Globulin.setCellValueFactory(new PropertyValueFactory<>("Globulin"));
        AG_Ratio.setCellValueFactory(new PropertyValueFactory<>("AG_Ratio"));
        GGTP.setCellValueFactory(new PropertyValueFactory<>("GGTP"));
        
    }
    
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
