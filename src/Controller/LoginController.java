package Controller;

import DAO.UsersDAO;
import DAOImpl.UsersDAOImpl;
import Model.Users;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class LoginController implements Initializable {

    @FXML
    private TextField Username;
       
    @FXML
    private PasswordField Password;
    
    @FXML
    private Button btnLogin;
    
    public Users U = new Users();
    
    public UsersDAO UDAO= new UsersDAOImpl();
    
    
    @FXML
    private void btnLoginAction(ActionEvent event){
        
        U.setUSERNAME(Username.getText());
        U.setPASSWORD(Password.getText());
        
        UDAO.ValidateUser(U);

        
        if(UDAO.ValidateUser(U) == false)
        {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("In-correct Username or Password.");
        alert.setHeaderText("In-correct Username or Password.");     
        alert.setContentText("Please Enter Correct Username & Password." );
        alert.showAndWait(); 
        }
        else
         {
             Stage  stage = (Stage) btnLogin.getScene().getWindow();
             stage.close();
         
        MainApplicationController mainApplicationController = new MainApplicationController();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/View/MainApplication.fxml"));
        try {
            fxmlLoader.load();
            Parent parent = fxmlLoader.getRoot();
            Scene scene = new Scene(parent,1020,610);
            scene.setFill(new Color(0, 0, 0, 0));
            MainApplicationController MainApplication = fxmlLoader.getController();
            MainApplication.btnHomeOnClick(event);
            Stage nStage = new Stage();
            nStage.setScene(scene);
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.setTitle("In-Patient Management System");
            nStage.setResizable(false);
            nStage.show();
            
        }  
        catch (IOException e) {
            
           }
        
       }
    
    } 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
