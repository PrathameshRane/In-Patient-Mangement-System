package Model;

import List.ListTest_Report;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Test_Report {

    private int TR_ID;
    private int P_ID;
    private int T_ID;
    private int R_ID;
    private String R_NAME;
    private String R_DATE;

    public ObservableList<ListTest_Report> ReportDetails = FXCollections.observableArrayList();  

    public int getTR_ID() {
        return TR_ID;
    }

    public void setTR_ID(int TR_ID) {
        this.TR_ID = TR_ID;
    }

    public int getP_ID() {
        return P_ID;
    }

    public void setP_ID(int P_ID) {
        this.P_ID = P_ID;
    }

    public int getT_ID() {
        return T_ID;
    }

    public void setT_ID(int T_ID) {
        this.T_ID = T_ID;
    }

    public int getR_ID() {
        return R_ID;
    }

    public void setR_ID(int R_ID) {
        this.R_ID = R_ID;
    }

    public String getR_NAME() {
        return R_NAME;
    }

    public void setR_NAME(String R_NAME) {
        this.R_NAME = R_NAME;
    }

    public String getR_DATE() {
        return R_DATE;
    }

    public void setR_DATE(String R_DATE) {
        this.R_DATE = R_DATE;
    }
    
   
    
}
