package DAO;

import List.ListStool_Routine_Report;
import Model.Stool_Routine_Report;
import javafx.collections.ObservableList;

public interface Stool_Routine_ReportDAO {

    public ObservableList<ListStool_Routine_Report> getAllReport();
    
    public void addReport(Stool_Routine_Report SR);
       
    public ObservableList<ListStool_Routine_Report> getReport(int R_ID);        
    
    public void updateReport(Stool_Routine_Report SR);
    
    public void deleteReport(int R_ID);
    
    public ListStool_Routine_Report selectedReport(ListStool_Routine_Report LSR);
    
}
