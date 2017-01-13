package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class MainApplicationController implements Initializable {

   @FXML
    private StackPane acContent;
    
    @FXML
    private ScrollPane leftSideBarScroolPan;
    @FXML
    private BorderPane appContent;
    @FXML
    private AnchorPane acDashBord;
    @FXML
    private AnchorPane acHead;
     @FXML
    private AnchorPane acMain;
     @FXML
    private Button btnHome;
    @FXML
    private ImageView imgHomeBtn;
     @FXML
    private Button btnPatient;
    @FXML
    private ImageView imgPatientBtn;
    @FXML
    private Button btnDoctor;
    @FXML
    private ImageView imgDoctorBtn;
    @FXML
    private Button btnEmployee;
    @FXML
    private ImageView imgEmployeeBtn;
    @FXML
    private Button btnBed;
    @FXML
    private ImageView imgBedBtn;
    @FXML
    private Button btnReport;
    @FXML
    private ImageView imgReportBtn;
    
    
    @FXML
    public void btnHomeOnClick(ActionEvent event) throws IOException{
        
        HomeController HC = new HomeController();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/View/Home.fxml").openStream());
        HomeController homeController = fXMLLoader.getController();
 
        
        AnchorPane acPane = fXMLLoader.getRoot();
        

        acContent.getChildren().clear();

        acContent.getChildren().add(acPane); 
    
    }
    
    @FXML
    public void btnPatientOnClick(ActionEvent event) throws IOException {
        
        PatientController PC = new PatientController();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/View/Patient.fxml").openStream());
        PatientController patientController = fXMLLoader.getController();
        
        AnchorPane acPane = fXMLLoader.getRoot();
        

        acContent.getChildren().clear();

        acContent.getChildren().add(acPane); 
    }   
    
    @FXML
    public void btnDoctorOnClick(ActionEvent event) throws IOException {
        
        ViewDoctorInfoController DC = new ViewDoctorInfoController();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/View/ViewDoctorInfo.fxml").openStream());
        ViewDoctorInfoController viewDoctorInfoController = fXMLLoader.getController();
        AnchorPane acPane = fXMLLoader.getRoot();
        

        acContent.getChildren().clear();

        acContent.getChildren().add(acPane); 
    }
    
     @FXML
    public void btnEmployeeOnClick(ActionEvent event) throws IOException{
        
        ViewEmployeeInfoController DC = new ViewEmployeeInfoController();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/View/ViewEmployeeInfo.fxml").openStream());
        ViewEmployeeInfoController viewEmployeeInfoController = fXMLLoader.getController();
        AnchorPane acPane = fXMLLoader.getRoot();
        

        acContent.getChildren().clear();

        acContent.getChildren().add(acPane);
    }
    
     @FXML
    public void btnBedOnClick(ActionEvent event) throws IOException{
        
        ViewBedInfoController BC = new ViewBedInfoController();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/View/ViewBedInfo.fxml").openStream());
        ViewBedInfoController viewBedInfoController = fXMLLoader.getController();
        AnchorPane acPane = fXMLLoader.getRoot();
        

        acContent.getChildren().clear();

        acContent.getChildren().add(acPane);
        
    }
    
    @FXML
    public void btnReportOnClick(ActionEvent event) throws IOException{
        
        ReportController RC = new ReportController();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/View/Report.fxml").openStream());
        ReportController reportController = fXMLLoader.getController();
        AnchorPane acPane = fXMLLoader.getRoot();
        

        acContent.getChildren().clear();

        acContent.getChildren().add(acPane);       
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
