package Controller;

import DAO.BedDAO;
import DAO.DoctorDAO;
import DAO.PatientDAO;
import DAOImpl.BedDAOImpl;
import DAOImpl.DoctorDAOImpl;
import DAOImpl.PatientDAOImpl;
import List.ListBed;
import List.ListPatient;
import Model.Patient;

import java.sql.SQLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class AddPatientController implements Initializable {

    public int pid;
    public String Dob;
    public String AdmissionDate;
    public int BedNo;
    public int bno;
    public String DoctorName;
    
    ObservableList<ListBed> BedDetails = FXCollections.observableArrayList();
    public BedDAO BDAO = new BedDAOImpl();
     
    @FXML
    private TextField pname;
      
     @FXML
    private DatePicker dob;
       
     @FXML
    private ComboBox<String> gender;

      @FXML
    public void GenderSelect(MouseEvent event) {
         gender.getItems().clear();
         gender.getItems().addAll("Male","Female");
    }
     
     @FXML
    private TextField age;
         
     @FXML
    private TextField weight;
          
     @FXML
    private TextField bloodgrp;
     
      @FXML
    private TextField address;
    
      @FXML
    private TextField mobileno;
      
     @FXML
    private TextField guardian_name;  
    
      @FXML
    private TextField guardian_mobno;
      
      @FXML
    private DatePicker admissiondate;
      
    @FXML
    private ComboBox<Integer> bedno;
        
    @FXML
    private ComboBox<String> doctor_name;   
              
     @FXML
    private TextField illness;    
   
      
     @FXML
    public Button Savebtn;
             
     @FXML
    public Button Updatebtn;     
     
   
     public Patient P = new Patient();
     public ListPatient LP = new ListPatient();
     public PatientDAO PDAO = new PatientDAOImpl();
     public DoctorDAO DDAO = new DoctorDAOImpl();
     
     
     
     @FXML
    public void BedSelect(MouseEvent event) {
        
        ArrayList<Integer> Bednos = new ArrayList();
        Bednos = BDAO.getbedno();
        ObservableList<Integer> bednos = FXCollections.observableArrayList(Bednos);
        bedno.getItems().clear();
        bedno.getItems().addAll(bednos);
    }
     
     @FXML
    public void DoctorSelect(MouseEvent event) {
        
        ArrayList<String> Dnames = new ArrayList();
        Dnames = DDAO.getdoctorname();
        ObservableList<String> Doctors = FXCollections.observableArrayList(Dnames);
        doctor_name.getItems().clear();
        doctor_name.getItems().addAll(Doctors);
    }
      
     
     @FXML
    public void btnSavePatient(ActionEvent event) throws SQLException{
       
        
        P.setNAME(pname.getText());
        P.setDOB(dob.getValue().toString());
        P.setGENDER(gender.getValue());
        P.setAGE(Integer.parseInt(age.getText()));
        P.setWEIGHT(Integer.parseInt(weight.getText()));
        P.setBLOOD_GRP(bloodgrp.getText());
        P.setADDRESS(address.getText());
        P.setMOBILE_NO(mobileno.getText());
        P.setGUARDIAN_NAME(guardian_name.getText());
        P.setGUARDIAN_MOB_NO(guardian_mobno.getText());
        P.setADMISSION_DATE(admissiondate.getValue().toString());
        P.setBED_NO(bedno.getValue());
        
        bno =bedno.getValue();
        P.setD_NAME(doctor_name.getValue());
        P.setILLNESS(illness.getText());
        
        PDAO.addPatient(P);
        BDAO.updateBedStatus(bno);
        
        Stage  stage = (Stage) Savebtn.getScene().getWindow();
        stage.close();
        
    }
    
    @FXML
    public void btnUpdatePatient(ActionEvent event){
         
        P.setP_ID(pid);
        P.setNAME(pname.getText());
        
        if(dob.getValue()!=null){
        P.setDOB(dob.getValue().toString());
        }
        else{
            P.setDOB(Dob);
        }
        
        P.setGENDER(gender.getValue());
        P.setAGE(Integer.parseInt(age.getText()));
        P.setWEIGHT(Integer.parseInt(weight.getText()));
        P.setBLOOD_GRP(bloodgrp.getText());
        P.setADDRESS(address.getText());
        P.setMOBILE_NO(mobileno.getText());
        P.setGUARDIAN_NAME(guardian_name.getText());
        P.setGUARDIAN_MOB_NO(guardian_mobno.getText());
        
        if(admissiondate.getValue()!=null){
        P.setADMISSION_DATE(admissiondate.getValue().toString());
        }
        else{
            P.setADMISSION_DATE(AdmissionDate);
        }  
        
        if(bedno.getValue()!=null){
        P.setBED_NO(bedno.getValue());
        bno =bedno.getValue();
        }
        else{
            P.setBED_NO(BedNo);
            bno =BedNo;
        }
        
        if(doctor_name.getValue()!=null){
        P.setD_NAME(doctor_name.getValue());
        }
        else{
            P.setD_NAME(DoctorName);
        }  
        
        P.setILLNESS(illness.getText());      
   
        PDAO.updatePatient(P);
        BDAO.updateBedStatus(bno);
        Stage  stage = (Stage) Updatebtn.getScene().getWindow();
        stage.close();
        
               
    }
      
    public void showDetails() {
        LP.setP_ID(pid);      
        ListPatient LP2 = PDAO.selectedPatient(LP);
        pname.setText(LP2.getNAME());
        dob.setPromptText(LP2.getDOB());
        Dob=LP.getDOB();
        gender.setValue(LP2.getGENDER());
        String Age = Integer.toString(LP2.getAGE());
        age.setText(Age);
        String Weight = Integer.toString(LP2.getWEIGHT());
        weight.setText(Weight);
        bloodgrp.setText(LP2.getBLOOD_GRP());
        address.setText(LP2.getADDRESS());
        mobileno.setText(LP2.getMOBILE_NO());
        guardian_name.setText(LP2.getGUARDIAN_NAME());
        guardian_mobno.setText(LP2.getGUARDIAN_MOB_NO());
        admissiondate.setPromptText(LP2.getADMISSION_DATE());
        AdmissionDate=LP.getADMISSION_DATE();
        String Bed_no=Integer.toString(LP.getBED_NO());
        bedno.setPromptText(Bed_no);
        BedNo=LP.getBED_NO();
        doctor_name.setPromptText(LP.getD_NAME());
        DoctorName=LP.getD_NAME();
        illness.setText(LP2.getILLNESS());
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }   
    
}
