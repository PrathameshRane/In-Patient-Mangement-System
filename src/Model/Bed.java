
package Model;

import List.ListBed;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Bed {
    
    private int BED_NO;
    private String STATUS; 
    private String E_NAME;

    
    
    public ObservableList<ListBed> BedDetails = FXCollections.observableArrayList();
    
    public int getBED_NO() {
        return BED_NO;
    }

    public void setBED_NO(int BED_NO) {
        this.BED_NO = BED_NO;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }
    public String getE_NAME() {
        return E_NAME;
    }

    public void setE_NAME(String E_NAME) {
        this.E_NAME = E_NAME;
    }
    
}
