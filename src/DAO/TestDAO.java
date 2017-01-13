package DAO;

import List.ListPatient_Test;
import Model.Patient_Test;
import javafx.collections.ObservableList;

public interface TestDAO {

    public ObservableList<ListPatient_Test> getAllTest();
    
    public void addTest(Patient_Test T);
    
    public ObservableList<ListPatient_Test> getTest(int P_id);
    
    public void updateTest(Patient_Test T);
    
    public void deleteTest(int T_ID);
    
    public ListPatient_Test selectedTest(ListPatient_Test LT);
    
}
