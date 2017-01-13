package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;


public class PatientController implements Initializable {
    
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private TabPane patientTabPane;
    @FXML
    private Tab tabPatientDetails;
    @FXML
    private Tab tabPatientTest;
    @FXML
    private Tab tabTest_Report;
    @FXML
    private Tab tabPatientPrescription;
    @FXML
    private Tab tabPatientDischarge;
  
    
    @FXML
    private StackPane pdContent;   
    @FXML
    private StackPane pdContent2;   
    @FXML
    private StackPane pdContent3;    
    @FXML
    private StackPane pdContent4;
    @FXML
    private StackPane pdContent5;
    
    @FXML
    private AnchorPane ppacpane;
    @FXML
    private AnchorPane ppacpane2;
    @FXML
    private AnchorPane ppacpane3;
    @FXML
    private AnchorPane ppacpane4;   
    @FXML
    private AnchorPane ppacpane5;

    @FXML
    public void tabSelectPatientDetails(Event event) throws IOException {
        
        ViewPatientInfoController VP = new ViewPatientInfoController();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/View/ViewPatientInfo.fxml").openStream());
        ViewPatientInfoController viewpatientinfoController = fXMLLoader.getController();
        AnchorPane acPane = fXMLLoader.getRoot();

        pdContent.getChildren().clear();
        pdContent.getChildren().add(acPane); 
        
    }
    
    @FXML
    public void tabSelectPatientTest(Event event) throws IOException {
        
        ViewTestInfoController VT = new ViewTestInfoController();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/View/ViewTestInfo.fxml").openStream());
        ViewTestInfoController viewTestInfoController = fXMLLoader.getController();
        AnchorPane acPane = fXMLLoader.getRoot();

        pdContent2.getChildren().clear();
        pdContent2 .getChildren().add(acPane);
        
    }
    
    @FXML
    public void tabSelectTest_Report(Event event) throws IOException {
       
        ViewTest_ReportController VTR = new ViewTest_ReportController();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/View/ViewTest_Report.fxml").openStream());
        ViewTest_ReportController viewTest_ReportController = fXMLLoader.getController();
        AnchorPane acPane = fXMLLoader.getRoot();

        pdContent3.getChildren().clear();
        pdContent3 .getChildren().add(acPane);
        
    }
    
    @FXML
    public void tabSelectPatientPrescription(Event event) throws IOException {
        
        ViewPatientPrescriptionController VPP = new ViewPatientPrescriptionController();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/View/ViewPatientPrescription.fxml").openStream());
        ViewPatientPrescriptionController viewPatientPrescriptionController = fXMLLoader.getController();
        AnchorPane acPane = fXMLLoader.getRoot();

        pdContent4.getChildren().clear();
        pdContent4.getChildren().add(acPane); 
        
    }
    
    @FXML
    public void tabSelectPatientDischargeSummary(Event event) throws IOException {
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
