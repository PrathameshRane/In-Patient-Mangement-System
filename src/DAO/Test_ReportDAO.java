package DAO;

import List.ListTest_Report;
import Model.Test_Report;
import javafx.collections.ObservableList;

public interface Test_ReportDAO {

    public ObservableList<ListTest_Report> getAllReport();
    
    public void addReport(Test_Report R);
       
    public ObservableList<ListTest_Report> getReport(int P_id);        
    
    public void updateReport(Test_Report R);
    
    public void deleteReport(int TR_ID);
    
    public ListTest_Report selectedReport(ListTest_Report LR);
    
}
