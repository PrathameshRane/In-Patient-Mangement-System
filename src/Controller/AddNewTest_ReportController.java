package Controller;

import DAO.Test_ReportDAO;
import DAOImpl.Test_ReportDAOImpl;
import List.ListTest_Report;
import Model.Test_Report;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddNewTest_ReportController implements Initializable {

    public int tr_id;
    public String rname;
    public String rdate;
    
    @FXML
    private TextField P_ID;
    @FXML
    private TextField T_ID;
    @FXML
    private TextField R_ID;
    
    @FXML
    private ComboBox Report_Name;
    
    
    @FXML
    public void TestSelect(MouseEvent event) {
        
        
        Report_Name.getItems().clear();
        Report_Name.getItems().addAll("CBC Report","LFT Report","Blood Sugar Report","Stool Routine Report","Urine Report");
    }
    
    @FXML
    private DatePicker Report_Date;
    
    @FXML
    public Button Savebtn;
    @FXML
    public Button Updatebtn;
    
    public Test_Report TR = new Test_Report();
    public ListTest_Report LTR = new ListTest_Report();
    public Test_ReportDAO TRDAO = new Test_ReportDAOImpl();
    
    @FXML
    public void btnSaveTest_Report(ActionEvent event) throws SQLException{
        
        TR.setP_ID(Integer.parseInt(P_ID.getText()));
        TR.setT_ID(Integer.parseInt(T_ID.getText()));
        TR.setR_ID(Integer.parseInt(R_ID.getText()));
        TR.setR_NAME((String) Report_Name.getValue());
        TR.setR_DATE(Report_Date.getValue().toString());

        TRDAO.addReport(TR);
        
        Stage  stage = (Stage) Savebtn.getScene().getWindow();
        stage.close();
        
    }
 
     @FXML
    public void btnUpdateTest_Report(ActionEvent event) throws SQLException{
        
        TR.setTR_ID(tr_id);
        TR.setP_ID(Integer.parseInt(P_ID.getText()));
        TR.setT_ID(Integer.parseInt(T_ID.getText()));
        TR.setR_ID(Integer.parseInt(R_ID.getText()));
        
        if(Report_Name.getValue()!=null){
        TR.setR_NAME((String) Report_Name.getValue());
        }
        else{
        TR.setR_NAME(rname);
        }
        
        if(Report_Date.getValue()!=null){
        TR.setR_DATE(Report_Date.getValue().toString());
        }
        else{
        TR.setR_DATE(rdate);
        }
        
        TRDAO.updateReport(TR);
       
        Stage  stage = (Stage) Updatebtn.getScene().getWindow();
        stage.close();
    }
    
    public void showDetails() {
        
        LTR.setTR_ID(tr_id);
        ListTest_Report LTR2 = TRDAO.selectedReport(LTR);
        P_ID.setText((Integer.toString(LTR2.getP_ID())));
        T_ID.setText((Integer.toString(LTR2.getT_ID())));
        R_ID.setText((Integer.toString(LTR2.getR_ID())));
         
        
        Report_Name.setValue(LTR2.getR_NAME());
        rname=LTR.getR_NAME();
        Report_Date.setPromptText(LTR2.getR_DATE());
        rdate=LTR.getR_DATE();
          
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
