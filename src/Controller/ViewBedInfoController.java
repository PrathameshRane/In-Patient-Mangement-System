package Controller;

import DAO.BedDAO;
import DAOImpl.BedDAOImpl;
import List.ListBed;
import Model.Bed;
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

public class ViewBedInfoController implements Initializable {
    
    Bed B = new Bed();
    
    ObservableList<ListBed> BedDetails = FXCollections.observableArrayList();

    @FXML
    private TableView<ListBed> BedInfoTable;
    @FXML
    private TableColumn<Object, Object> BEDNO;
    @FXML
    private TableColumn<Object, Object> STATUS;
    @FXML
    private TableColumn<Object, Object> ENAME;
    
    @FXML
    private TextField SearchBedNo;   
    @FXML
    private Button Search;
    @FXML
    private Button Update;
    @FXML
    private Button ViewAll;    
    @FXML
    public Button Refresh;
    
    public BedDAO BDAO = new BedDAOImpl();
    
    @FXML
    private void btnSearchBed(ActionEvent event){
        
        BedDetails.clear();
        
        B.setBED_NO(Integer.parseInt(SearchBedNo.getText()));     
        int Bedno = B.getBED_NO();
        BedDetails = BDAO.getBed(Bedno);
        
        showBed(BedDetails);
    }
    
    @FXML
    private void btnUpdateBed(ActionEvent event){
        
        if(BedInfoTable.getSelectionModel().getSelectedItem() != null){
          
            ListBed selectedBed = BedInfoTable.getSelectionModel().getSelectedItem();
            
                int items = selectedBed.getBED_NO();               
                if (items != 0) {
                    
        BedController Updatebedcontroller = new BedController();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/View/Bed.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            BedController bedController = fxmlLoader.getController();          
            bedController.Updatebtn.setVisible(true);
            bedController.bedno = selectedBed.getBED_NO();
            bedController.showDetails();
            Stage nStage = new Stage();
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.setTitle("Update Bed");
            nStage.show();
        } 
        catch (IOException e) {
            
           }
                           
         }
      }
        else {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Select Bed");
        alert.setHeaderText("Please Select One Bed.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Bed2.png").toString()));
        alert.showAndWait();
        }
        
    }
      
    @FXML
    private void btnViewAllBed(ActionEvent event){
        
        BedDetails.clear();
       
        BedDetails = BDAO.getAllBed();
        
        showBed(BedDetails);
        
    }
    
    @FXML
    private void btnRefresh(ActionEvent event){
        
        BedDetails.clear();
       
        BedDetails = BDAO.getAllBed();
        
        showBed(BedDetails);
        
    }
    
    public void showBed(ObservableList<ListBed> BedDetails){
        
        BedInfoTable.setItems(BedDetails);
        BEDNO.setCellValueFactory(new PropertyValueFactory<>("BED_NO"));
        STATUS.setCellValueFactory(new PropertyValueFactory<>("STATUS"));
        ENAME.setCellValueFactory(new PropertyValueFactory<>("E_NAME"));
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
