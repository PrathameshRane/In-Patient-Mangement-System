package Model;

import List.ListBlood_Sugar_Report;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Blood_Sugar_Report {

    private int R_ID;
    private int P_ID;
    private String Urine_Sugar;
    private String Urine_Acetone;
    private String Random_Blood_Sugar;

    public ObservableList<ListBlood_Sugar_Report> Blood_Sugar_ReportDetails = FXCollections.observableArrayList();
    
    public int getR_ID() {
        return R_ID;
    }

    public void setR_ID(int R_ID) {
        this.R_ID = R_ID;
    }

    public int getP_ID() {
        return P_ID;
    }

    public void setP_ID(int P_ID) {
        this.P_ID = P_ID;
    }

    public String getUrine_Sugar() {
        return Urine_Sugar;
    }

    public void setUrine_Sugar(String Urine_Sugar) {
        this.Urine_Sugar = Urine_Sugar;
    }

    public String getUrine_Acetone() {
        return Urine_Acetone;
    }

    public void setUrine_Acetone(String Urine_Acetone) {
        this.Urine_Acetone = Urine_Acetone;
    }

    public String getRandom_Blood_Sugar() {
        return Random_Blood_Sugar;
    }

    public void setRandom_Blood_Sugar(String Random_Blood_Sugar) {
        this.Random_Blood_Sugar = Random_Blood_Sugar;
    }
    
}
