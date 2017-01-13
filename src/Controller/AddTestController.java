package Controller;

import DAO.TestDAO;
import DAOImpl.TestDAOImpl;
import List.ListPatient_Test;
import Model.Patient_Test;
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


public class AddTestController implements Initializable {

    public int tid;
    public int pid;
    public String tname;
    public String tdate;
    public String ref_by;
  
    
    
    @FXML
    private TextField PID;
    @FXML
    private TextField REF_BY;
    
    @FXML
    private ComboBox Test_Name;
    
    
    @FXML
    public void TestSelect(MouseEvent event) {
        
        
        Test_Name.getItems().clear();
        Test_Name.getItems().addAll("CBC Test","LFT Test","Blood Sugar Test","Stool Routine Test","Urine Test");
    }
    
    @FXML
    private DatePicker Test_Date; 
   
     
    @FXML
    public Button Savebtn;
    @FXML
    public Button Updatebtn;
    
    public Patient_Test T = new Patient_Test();
    public ListPatient_Test LT = new ListPatient_Test();
    public TestDAO TDAO = new TestDAOImpl();
    
    @FXML
    public void btnSaveTest(ActionEvent event) throws SQLException{
        
        T.setP_ID(Integer.parseInt(PID.getText()));
        T.setREF_BY(REF_BY.getText());
        T.setT_NAME((String) Test_Name.getValue());
        T.setT_DATE(Test_Date.getValue().toString());
        
        TDAO.addTest(T);
        
        Stage  stage = (Stage) Savebtn.getScene().getWindow();
        stage.close();
        
    }
 
     @FXML
    public void btnUpdateTest(ActionEvent event) throws SQLException{
        
        T.setT_ID(tid);
        T.setP_ID(Integer.parseInt(PID.getText()));
        
        if(Test_Name.getValue()!=null){
        T.setT_NAME((String) Test_Name.getValue());
        }
        else{
        T.setT_NAME(tname);
        }
        
        if(Test_Date.getValue()!=null){
        T.setT_DATE(Test_Date.getValue().toString());
        }
        else{
        T.setT_DATE(tdate);
        }
         
        T.setREF_BY(REF_BY.getText());

        TDAO.updateTest(T);
        
        Stage  stage = (Stage) Updatebtn.getScene().getWindow();
        stage.close();
    }
    
    public void showDetails() {
        
        LT.setT_ID(tid);
        ListPatient_Test LT2 = TDAO.selectedTest(LT);
        PID.setText((Integer.toString(LT2.getP_ID())));
        Test_Name.setValue(LT2.getT_NAME());
        tname=LT.getT_NAME();
        Test_Date.setPromptText(LT2.getT_DATE());
        tdate=LT.getT_DATE();   
        REF_BY.setText(LT2.getREF_BY());
        ref_by=LT.getREF_BY();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
