package DAO;

import List.ListPatient;
import Model.Patient;
import javafx.collections.ObservableList;


public interface PatientDAO {
    
    public ObservableList<ListPatient> getAllPatient();
    
    public void addPatient(Patient P);
    
    public ObservableList<ListPatient> getPatient(String name);
    
    public void updatePatient(Patient P);
    
    public void deletePatient(int P_ID);
    
    public ListPatient selectedPatient(ListPatient P);
   
}
