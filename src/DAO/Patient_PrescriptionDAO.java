
package DAO;


import List.ListPatient_Prescription;
import Model.Patient_Prescription;
import javafx.collections.ObservableList;


public interface Patient_PrescriptionDAO {
    
    public void addPrescription(Patient_Prescription PP);
    
    public ObservableList<ListPatient_Prescription> getPrescription(int p_id);
    
    
}
