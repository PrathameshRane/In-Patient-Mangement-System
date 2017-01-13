/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import List.ListDoctor_Info;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author PRATHAMESH
 */
public class Doctor_Info {
    
    private int D_ID;
    private String D_NAME;
    private String ADDRESS;
    private String MOBILE_NO;
    private String SPECIALITY;

    public ObservableList<ListDoctor_Info> DoctorDetails = FXCollections.observableArrayList();        

    public Doctor_Info() {
        
    }
      
    public int getD_ID() {
        return D_ID;
    }

    public void setD_ID(int D_ID) {
        this.D_ID = D_ID;
    }

    public String getD_NAME() {
        return D_NAME;
    }

    public void setD_NAME(String D_NAME) {
        this.D_NAME = D_NAME;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getMOBILE_NO() {
        return MOBILE_NO;
    }

    public void setMOBILE_NO(String MOBILE_NO) {
        this.MOBILE_NO = MOBILE_NO;
    }

    public String getSPECIALITY() {
        return SPECIALITY;
    }

    public void setSPECIALITY(String SPECIALITY) {
        this.SPECIALITY = SPECIALITY;
    }
    
    
  
    
}
