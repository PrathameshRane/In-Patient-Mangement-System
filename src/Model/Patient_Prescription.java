/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import List.ListDoctor_Info;
import List.ListPatient_Prescription;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author PRATHAMESH
 */
public class Patient_Prescription {
    
    private int P_ID;
    private String D_NAME;
    private String MEDICATION;
    private String DOSE;
    private String TEST;

    public ObservableList<ListPatient_Prescription> PrescriptionDetails = FXCollections.observableArrayList();
    
    public int getP_ID() {
        return P_ID;
    }

    public void setP_ID(int P_ID) {
        this.P_ID = P_ID;
    }

    public String getD_NAME() {
        return D_NAME;
    }

    public void setD_NAME(String D_NAME) {
        this.D_NAME = D_NAME;
    }

    public String getMEDICATION() {
        return MEDICATION;
    }

    public void setMEDICATION(String MEDICATION) {
        this.MEDICATION = MEDICATION;
    }

    public String getDOSE() {
        return DOSE;
    }

    public void setDOSE(String DOSE) {
        this.DOSE = DOSE;
    }
    
     public String getTEST() {
        return TEST;
    }

    public void setTEST(String TEST) {
        this.TEST = TEST;
    }
    
}
