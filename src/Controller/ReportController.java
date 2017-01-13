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

public class ReportController implements Initializable {
    
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private TabPane reportTabPane;
    @FXML
    private Tab tabCBCReport;
    @FXML
    private Tab tabLFTReport;
    @FXML
    private Tab tabBloodSugarReport;
    @FXML
    private Tab tabStoolReport;
    @FXML
    private Tab tabUrineReport;
  
    
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
    public void tabSelectCBCReport(Event event) throws IOException {
    
        ViewCBC_ReportController CBC = new ViewCBC_ReportController();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/View/ViewCBC_Report.fxml").openStream());
        ViewCBC_ReportController viewCBC_ReportController = fXMLLoader.getController();
        AnchorPane acPane = fXMLLoader.getRoot();

        pdContent.getChildren().clear();
        pdContent.getChildren().add(acPane); 
    
    }
    
        @FXML
    public void tabSelectLFTReport(Event event) throws IOException {
    
        ViewLFT_ReportController LFT = new ViewLFT_ReportController();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/View/ViewLFT_Report.fxml").openStream());
        ViewLFT_ReportController viewLFT_ReportController = fXMLLoader.getController();
        AnchorPane acPane = fXMLLoader.getRoot();

        pdContent2.getChildren().clear();
        pdContent2 .getChildren().add(acPane);
    
    }
    
       @FXML
    public void tabSelectBloodSugarReport(Event event) throws IOException {
    
    
    }
    
        @FXML
    public void tabSelectStoolReport(Event event) throws IOException {
    
    
    }
    
            @FXML
    public void tabSelectUrineReport(Event event) throws IOException {
    
    
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
