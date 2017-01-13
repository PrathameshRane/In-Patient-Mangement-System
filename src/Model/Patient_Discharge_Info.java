/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import List.ListPatient_Discharge_Info;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author PRATHAMESH
 */
public class Patient_Discharge_Info {
    
    private int P_ID;
    private String DISCHARGE_DATE;
    
    public ObservableList<ListPatient_Discharge_Info> PatientDischargeDetails = FXCollections.observableArrayList();

    public int getP_ID() {
        return P_ID;
    }

    public void setP_ID(int P_ID) {
        this.P_ID = P_ID;
    }

    public String getDISCHARGE_DATE() {
        return DISCHARGE_DATE;
    }

    public void setDISCHARGE_DATE(String DISCHARGE_DATE) {
        this.DISCHARGE_DATE = DISCHARGE_DATE;
    }
    
    
}
