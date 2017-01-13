package Model;

import List.ListEmployee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Employee {
    
      private int E_ID;
      private String NAME;
      private String ADDRESS;
      private String MOBILE_NO;
      private String ROLE;
      
      public ObservableList<ListEmployee> EmployeeDetails = FXCollections.observableArrayList();

    public int getE_ID() {
        return E_ID;
    }

    public void setE_ID(int E_ID) {
        this.E_ID = E_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
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

    public String getROLE() {
        return ROLE;
    }

    public void setROLE(String ROLE) {
        this.ROLE = ROLE;
    }    
    
}
