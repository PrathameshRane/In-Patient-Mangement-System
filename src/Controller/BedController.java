package Controller;

import DAO.BedDAO;
import DAO.EmployeeDAO;
import DAOImpl.BedDAOImpl;
import DAOImpl.EmployeeDAOImpl;
import List.ListBed;
import Model.Bed;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BedController implements Initializable {
    
    public int bedno;
    public String status;
    public String ename;
    
    @FXML
    private TextField Bedno;
       
    @FXML
    private ComboBox<String> Status;

    @FXML
    public void StatusSelect(MouseEvent event) {
         Status.getItems().clear();
         Status.getItems().addAll("Full","Empty");
    }
    
    @FXML
    private ComboBox<String> Ename;      
    
    @FXML
    public Button Updatebtn;
    
    public Bed B = new Bed();
    public ListBed LB = new ListBed();
    public BedDAO BDAO= new BedDAOImpl();
    public EmployeeDAO EDAO= new EmployeeDAOImpl();
    
    @FXML
    public void EnameSelect(MouseEvent event) {
        ArrayList<String> Enames = new ArrayList();
        Enames = EDAO.getemployeename();
        ObservableList<String> enames = FXCollections.observableArrayList(Enames);
        Ename.getItems().clear();
        Ename.getItems().addAll(enames);        
    }
    
    
    @FXML
    public void btnUpdateBed(ActionEvent event) throws SQLException{
        
        B.setBED_NO(bedno);
        
        if(Status.getValue()!=null){
        B.setSTATUS(Status.getValue());
        }
        else{
            B.setSTATUS(status);
        }
        
        if(Ename.getValue()!=null){
        B.setE_NAME(Ename.getValue());
        }
        else{
            B.setE_NAME(ename);
        }
        
        
        BDAO.updateBed(B);
        Stage  stage = (Stage) Updatebtn.getScene().getWindow();
        stage.close();
        
    }
    
     public void showDetails() {
        
        LB.setBED_NO(bedno);        
        ListBed LB2 = BDAO.selectedBed(LB);               
        String Bno = Integer.toString(LB2.getBED_NO());
        Bedno.setText(Bno);        
        Status.setPromptText(LB2.getSTATUS());
        status=LB2.getSTATUS();        
        Ename.setPromptText(LB2.getE_NAME());
        ename=LB2.getE_NAME();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
