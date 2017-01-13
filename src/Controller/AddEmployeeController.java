package Controller;

import DAO.EmployeeDAO;
import DAOImpl.EmployeeDAOImpl;
import List.ListEmployee;
import Model.Employee;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AddEmployeeController implements Initializable {

    public int eid;
    
    @FXML
    private TextField E_NAME;
    @FXML
    private TextField ADDRESS;
    @FXML
    private TextField MOBILENO; 
    @FXML
    private TextField ROLE; 
     
    @FXML
    public Button Savebtn;
    @FXML
    public Button Updatebtn;
    
    public Employee E = new Employee();
    public ListEmployee LE = new ListEmployee();
    public EmployeeDAO EDAO = new EmployeeDAOImpl();
    
    @FXML
    public void btnSaveEmployee(ActionEvent event) throws SQLException{
        
        E.setNAME(E_NAME.getText());
        E.setADDRESS(ADDRESS.getText());
        E.setMOBILE_NO(MOBILENO.getText());
        E.setROLE(ROLE.getText());
        
        EDAO.addEmployee(E);
        Stage  stage = (Stage) Savebtn.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    public void btnUpdateEmployee(ActionEvent event) throws SQLException{
        
        E.setE_ID(eid);
        E.setNAME(E_NAME.getText());
        E.setADDRESS(ADDRESS.getText());
        E.setMOBILE_NO(MOBILENO.getText());
        E.setROLE(ROLE.getText());
        
        EDAO.updateEmployee(E);
        Stage  stage = (Stage) Savebtn.getScene().getWindow();
        stage.close();       
    }
    
    public void showDetails() {     
        LE.setE_ID(eid);
        ListEmployee LE2 = EDAO.selectedEmployee(LE);
        E_NAME.setText(LE2.getNAME());
        ADDRESS.setText(LE2.getADDRESS());
        MOBILENO.setText(LE2.getMOBILE_NO());
        ROLE.setText(LE2.getROLE());
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
