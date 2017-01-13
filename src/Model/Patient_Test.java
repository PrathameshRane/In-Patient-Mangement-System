package Model;

import List.ListPatient_Test;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Patient_Test {

    private int T_ID;
    private int P_ID;
    private String T_NAME;
    private String T_DATE;
    private String REF_BY;
    
    public ObservableList<ListPatient_Test> TestDetails = FXCollections.observableArrayList();

    public int getT_ID() {
        return T_ID;
    }

    public void setT_ID(int T_ID) {
        this.T_ID = T_ID;
    }

    public int getP_ID() {
        return P_ID;
    }

    public void setP_ID(int P_ID) {
        this.P_ID = P_ID;
    }

    public String getT_NAME() {
        return T_NAME;
    }

    public void setT_NAME(String T_NAME) {
        this.T_NAME = T_NAME;
    }

    public String getT_DATE() {
        return T_DATE;
    }

    public void setT_DATE(String T_DATE) {
        this.T_DATE = T_DATE;
    }

    public String getREF_BY() {
        return REF_BY;
    }

    public void setREF_BY(String REF_BY) {
        this.REF_BY = REF_BY;
    }

         
    
}
