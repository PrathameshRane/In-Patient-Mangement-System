package Controller;

import DAO.DoctorDAO;
import DAOImpl.DoctorDAOImpl;
import List.ListDoctor_Info;
import Model.Doctor_Info;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AddDoctorController implements Initializable {

    public int did;
    
    @FXML
    private TextField D_NAME;
    @FXML
    private TextField ADDRESS;
    @FXML
    private TextField MOBILE_NO; 
    @FXML
    private TextField SPECIALITY; 
     
    @FXML
    public Button Savebtn;
    @FXML
    public Button Updatebtn;
    
    public Doctor_Info D = new Doctor_Info();
    public ListDoctor_Info LD = new ListDoctor_Info();
    public DoctorDAO DDAO = new DoctorDAOImpl();
    
    @FXML
    public void btnSaveDoctor(ActionEvent event) throws SQLException{
        
        D.setD_NAME(D_NAME.getText());
        D.setADDRESS(ADDRESS.getText());
        D.setMOBILE_NO(MOBILE_NO.getText());
        D.setSPECIALITY(SPECIALITY.getText());
        
        DDAO.addDoctor(D);
        Stage  stage = (Stage) Savebtn.getScene().getWindow();
        stage.close();
        
    }
 
     @FXML
    public void btnUpdateDoctor(ActionEvent event) throws SQLException{
        
        D.setD_ID(did);
        D.setD_NAME(D_NAME.getText());
        D.setADDRESS(ADDRESS.getText());
        D.setMOBILE_NO(MOBILE_NO.getText());
        D.setSPECIALITY(SPECIALITY.getText());
        
        DDAO.updateDoctor(D);
        Stage  stage = (Stage) Updatebtn.getScene().getWindow();
        stage.close();
    }
    
    public void showDetails() {
        
        LD.setD_ID(did);
        ListDoctor_Info LD2 = DDAO.selectedDoctor(LD);
        D_NAME.setText(LD.getD_NAME());
        ADDRESS.setText(LD.getADDRESS());
        MOBILE_NO.setText(LD.getMOBILE_NO());
        SPECIALITY.setText(LD.getSPECIALITY());
          
    }
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
