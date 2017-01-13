package Model;

import List.ListStool_Routine_Report;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Stool_Routine_Report {

    private int R_ID;
    private int P_ID;
    private String Colour;
    private String Consistency;
    private String Mucus;
    private String Blood;
    private String Parasites;
    private String Reaction;
    private String Occult_Blood;
    private String Reducing_Substance;
    private String Ova;
    private String Cysts;
    private String Vegetative_Form;
    private String Red_Blood_Cell;
    private String Ephithelial_Cells;
    private String Pus_Cell;
    private String Macrophages;
    
     public ObservableList<ListStool_Routine_Report> Stool_Routine_ReportDetails = FXCollections.observableArrayList();

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

    public String getColour() {
        return Colour;
    }

    public void setColour(String Colour) {
        this.Colour = Colour;
    }

    public String getConsistency() {
        return Consistency;
    }

    public void setConsistency(String Consistency) {
        this.Consistency = Consistency;
    }

    public String getMucus() {
        return Mucus;
    }

    public void setMucus(String Mucus) {
        this.Mucus = Mucus;
    }

    public String getBlood() {
        return Blood;
    }

    public void setBlood(String Blood) {
        this.Blood = Blood;
    }

    public String getParasites() {
        return Parasites;
    }

    public void setParasites(String Parasites) {
        this.Parasites = Parasites;
    }

    public String getReaction() {
        return Reaction;
    }

    public void setReaction(String Reaction) {
        this.Reaction = Reaction;
    }

    public String getOccult_Blood() {
        return Occult_Blood;
    }

    public void setOccult_Blood(String Occult_Blood) {
        this.Occult_Blood = Occult_Blood;
    }

    public String getReducing_Substance() {
        return Reducing_Substance;
    }

    public void setReducing_Substance(String Reducing_Substance) {
        this.Reducing_Substance = Reducing_Substance;
    }

    public String getOva() {
        return Ova;
    }

    public void setOva(String Ova) {
        this.Ova = Ova;
    }

    public String getCysts() {
        return Cysts;
    }

    public void setCysts(String Cysts) {
        this.Cysts = Cysts;
    }

    public String getVegetative_Form() {
        return Vegetative_Form;
    }

    public void setVegetative_Form(String Vegetative_Form) {
        this.Vegetative_Form = Vegetative_Form;
    }

    public String getRed_Blood_Cell() {
        return Red_Blood_Cell;
    }

    public void setRed_Blood_Cell(String Red_Blood_Cell) {
        this.Red_Blood_Cell = Red_Blood_Cell;
    }

    public String getEphithelial_Cells() {
        return Ephithelial_Cells;
    }

    public void setEphithelial_Cells(String Ephithelial_Cells) {
        this.Ephithelial_Cells = Ephithelial_Cells;
    }

    public String getPus_Cell() {
        return Pus_Cell;
    }

    public void setPus_Cell(String Pus_Cell) {
        this.Pus_Cell = Pus_Cell;
    }

    public String getMacrophages() {
        return Macrophages;
    }

    public void setMacrophages(String Macrophages) {
        this.Macrophages = Macrophages;
    }
    
    
            
    
}
