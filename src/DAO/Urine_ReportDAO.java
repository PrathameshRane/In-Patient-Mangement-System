package DAO;

import List.ListUrine_Report;
import Model.Urine_Report;
import javafx.collections.ObservableList;

public interface Urine_ReportDAO {

    
    public ObservableList<ListUrine_Report> getAllReport();
    
    public void addReport(Urine_Report UR);
       
    public ObservableList<ListUrine_Report> getReport(int R_ID);        
    
    public void updateReport(Urine_Report UR);
    
    public void deleteReport(int R_ID);
    
    public ListUrine_Report selectedReport(ListUrine_Report LUR);
    
    
}
