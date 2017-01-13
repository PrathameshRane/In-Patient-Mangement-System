package Controller;

import DAO.CBC_ReportDAO;
import DAOImpl.CBC_ReportDAOImpl;
import List.ListCBC_Report;
import Model.CBC_Report;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCBCReportController implements Initializable {

    @FXML
    private TextField P_ID;     
     @FXML
    private TextField Haemoglobin;
     @FXML
    private TextField RBC_Count;
     @FXML
    private TextField PCV;
     @FXML
    private TextField MCV;
     @FXML
    private TextField MCH;
     @FXML
    private TextField MCHC;
     @FXML
    private TextField RDW;
     @FXML
    private TextField Total_WBC_Count;
     @FXML
    private TextField Neutrophils;
     @FXML
    private TextField Lymphocytes;
     @FXML
    private TextField Eosinophils;
     @FXML
    private TextField Monocytes;
    @FXML
    private TextField Basophils;
    @FXML
    private TextField Platelet_Count;
    
    @FXML
    public Button Savebtn;
             
    @FXML
    public Button Updatebtn;  
    
     public int rid;
   
     public CBC_Report C = new CBC_Report();
     public ListCBC_Report LC = new ListCBC_Report();
     public CBC_ReportDAO CDAO = new CBC_ReportDAOImpl();
             
     @FXML
    public void btnSaveReport(ActionEvent event) throws SQLException{
        
        C.setP_ID(Integer.parseInt(P_ID.getText()));
        C.setHaemoglobin(Haemoglobin.getText());
        C.setRBC_Count(RBC_Count.getText());
        C.setPCV(PCV.getText());
        C.setMCV(MCV.getText());
        C.setMCH(MCH.getText());
        C.setMCHC(MCHC.getText());
        C.setRDW(RDW.getText());
        C.setTotal_WBC_Count(Total_WBC_Count.getText());
        C.setNeutrophils(Neutrophils.getText());
        C.setLymphocytes(Lymphocytes.getText());
        C.setEosinophils(Eosinophils.getText());
        C.setMonocytes(Monocytes.getText());
        C.setBasophils(Basophils.getText());
        C.setPlatelet_Count(Platelet_Count.getText());
        
        CDAO.addReport(C);
        
        Stage  stage = (Stage) Savebtn.getScene().getWindow();
        stage.close();
        
    }
    
     @FXML
    public void btnUpdateReport(ActionEvent event) throws SQLException{
        
        C.setR_ID(rid);
        C.setP_ID(Integer.parseInt(P_ID.getText()));
        C.setHaemoglobin(Haemoglobin.getText());
        C.setRBC_Count(RBC_Count.getText());
        C.setPCV(PCV.getText());
        C.setMCV(MCV.getText());
        C.setMCH(MCH.getText());
        C.setMCHC(MCHC.getText());
        C.setRDW(RDW.getText());
        C.setTotal_WBC_Count(Total_WBC_Count.getText());
        C.setNeutrophils(Neutrophils.getText());
        C.setLymphocytes(Lymphocytes.getText());
        C.setEosinophils(Eosinophils.getText());
        C.setMonocytes(Monocytes.getText());
        C.setBasophils(Basophils.getText());
        C.setPlatelet_Count(Platelet_Count.getText());
        
        CDAO.updateReport(C);
        
        Stage  stage = (Stage) Savebtn.getScene().getWindow();
        stage.close();
        
    }
     
    public void showDetails() {
        LC.setR_ID(rid);      
        ListCBC_Report LC2 = CDAO.selectedReport(LC);
        
        String pid = Integer.toString(LC2.getP_ID());
        P_ID.setText(pid);
        Haemoglobin.setText(LC2.getHaemoglobin());
        RBC_Count.setText(LC2.getRBC_Count());
        PCV.setText(LC2.getPCV());
        MCV.setText(LC2.getMCV());
        MCH.setText(LC2.getMCH());
        MCHC.setText(LC2.getMCHC());
        RDW.setText(LC2.getRDW());
        Total_WBC_Count.setText(LC2.getTotal_WBC_Count());
        Neutrophils.setText(LC2.getNeutrophils());
        Lymphocytes.setText(LC2.getLymphocytes());
        Eosinophils.setText(LC2.getEosinophils());
        Monocytes.setText(LC2.getMonocytes());
        Basophils.setText(LC2.getBasophils());
        Platelet_Count.setText(LC2.getPlatelet_Count());
                
       }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
