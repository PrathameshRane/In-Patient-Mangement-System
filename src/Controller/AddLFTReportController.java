package Controller;

import DAO.LFT_ReportDAO;
import DAOImpl.LFT_ReportDAOImpl;
import List.ListLFT_Report;
import Model.LFT_Report;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddLFTReportController implements Initializable {

    @FXML
    private TextField P_ID;     
     @FXML
    private TextField Bilirubin_Total;
     @FXML
    private TextField SGOT;
     @FXML
    private TextField SGPT;
     @FXML
    private TextField Alkaline_Phosphatase;
     @FXML
    private TextField Proteins;
     @FXML
    private TextField Albumin;
     @FXML
    private TextField Globulin;
     @FXML
    private TextField AG_Ratio;
     @FXML
    private TextField GGTP;
    
    
    @FXML
    public Button Savebtn;
             
    @FXML
    public Button Updatebtn; 
    
       public int rid;
   
     public LFT_Report L = new LFT_Report();
     public ListLFT_Report LF = new ListLFT_Report();
     public LFT_ReportDAO LDAO = new LFT_ReportDAOImpl();
    
             
     @FXML
    public void btnSaveReport(ActionEvent event) throws SQLException{
        
        L.setP_ID(Integer.parseInt(P_ID.getText()));
        L.setBilirubin_Total(Bilirubin_Total.getText());
        L.setSGOT(SGOT.getText());
        L.setSGPT(SGPT.getText());
        L.setAlkaline_Phosphatase(Alkaline_Phosphatase.getText());
        L.setProteins(Proteins.getText());
        L.setAlbumin(Albumin.getText());
        L.setGlobulin(Globulin.getText());
        L.setAG_Ratio(AG_Ratio.getText());
        L.setGGTP(GGTP.getText());
        
        LDAO.addReport(L);
        
        Stage  stage = (Stage) Savebtn.getScene().getWindow();
        stage.close();
        
    }
    
     @FXML
    public void btnUpdateReport(ActionEvent event) throws SQLException{
        
        L.setR_ID(rid);
        L.setP_ID(Integer.parseInt(P_ID.getText()));
        L.setBilirubin_Total(Bilirubin_Total.getText());
        L.setSGOT(SGOT.getText());
        L.setSGPT(SGPT.getText());
        L.setAlkaline_Phosphatase(Alkaline_Phosphatase.getText());
        L.setProteins(Proteins.getText());
        L.setAlbumin(Albumin.getText());
        L.setGlobulin(Globulin.getText());
        L.setAG_Ratio(AG_Ratio.getText());
        L.setGGTP(GGTP.getText());
        
        
        LDAO.updateReport(L);
        
        Stage  stage = (Stage) Savebtn.getScene().getWindow();
        stage.close();
        
    }
    
    public void showDetails() {
        LF.setR_ID(rid);      
        ListLFT_Report LF2 = LDAO.selectedReport(LF);
        
        String pid = Integer.toString(LF2.getP_ID());
        P_ID.setText(pid);
        Bilirubin_Total.setText(LF2.getBilirubin_Total());
        SGOT.setText(LF2.getSGOT());
        SGPT.setText(LF2.getSGPT());
        Alkaline_Phosphatase.setText(LF2.getAlkaline_Phosphatase());
        Proteins.setText(LF2.getProteins());
        Albumin.setText(LF2.getAlbumin());
        Globulin.setText(LF2.getGlobulin());
        AG_Ratio.setText(LF2.getAG_Ratio());
        GGTP.setText(LF2.getGGTP());
                        
       }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
