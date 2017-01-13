package Model;

import List.ListCBC_Report;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CBC_Report {

    private int R_ID;
    private int P_ID;
    private String Haemoglobin;
    private String RBC_Count;
    private String PCV;
    private String MCV;
    private String MCH;
    private String MCHC;
    private String RDW;
    private String Total_WBC_Count;
    private String Neutrophils;
    private String Lymphocytes;
    private String Eosinophils;
    private String Monocytes;
    private String Basophils;
    private String Platelet_Count;
    
    public ObservableList<ListCBC_Report> CBCReportDetails = FXCollections.observableArrayList();

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

    public String getHaemoglobin() {
        return Haemoglobin;
    }

    public void setHaemoglobin(String Haemoglobin) {
        this.Haemoglobin = Haemoglobin;
    }

    public String getRBC_Count() {
        return RBC_Count;
    }

    public void setRBC_Count(String RBC_Count) {
        this.RBC_Count = RBC_Count;
    }

    public String getPCV() {
        return PCV;
    }

    public void setPCV(String PCV) {
        this.PCV = PCV;
    }

    public String getMCV() {
        return MCV;
    }

    public void setMCV(String MCV) {
        this.MCV = MCV;
    }

    public String getMCH() {
        return MCH;
    }

    public void setMCH(String MCH) {
        this.MCH = MCH;
    }

    public String getMCHC() {
        return MCHC;
    }

    public void setMCHC(String MCHC) {
        this.MCHC = MCHC;
    }

    public String getRDW() {
        return RDW;
    }

    public void setRDW(String RDW) {
        this.RDW = RDW;
    }

    public String getTotal_WBC_Count() {
        return Total_WBC_Count;
    }

    public void setTotal_WBC_Count(String Total_WBC_Count) {
        this.Total_WBC_Count = Total_WBC_Count;
    }

    public String getNeutrophils() {
        return Neutrophils;
    }

    public void setNeutrophils(String Neutrophils) {
        this.Neutrophils = Neutrophils;
    }

    public String getLymphocytes() {
        return Lymphocytes;
    }

    public void setLymphocytes(String Lymphocytes) {
        this.Lymphocytes = Lymphocytes;
    }

    public String getEosinophils() {
        return Eosinophils;
    }

    public void setEosinophils(String Eosinophils) {
        this.Eosinophils = Eosinophils;
    }

    public String getMonocytes() {
        return Monocytes;
    }

    public void setMonocytes(String Monocytes) {
        this.Monocytes = Monocytes;
    }

    public String getBasophils() {
        return Basophils;
    }

    public void setBasophils(String Basophils) {
        this.Basophils = Basophils;
    }

    public String getPlatelet_Count() {
        return Platelet_Count;
    }

    public void setPlatelet_Count(String Platelet_Count) {
        this.Platelet_Count = Platelet_Count;
    }

     

}