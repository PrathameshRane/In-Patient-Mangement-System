package DAO;

import List.ListCBC_Report;
import Model.CBC_Report;
import javafx.collections.ObservableList;

public interface CBC_ReportDAO {

    public ObservableList<ListCBC_Report> getAllReport();
    
    public void addReport(CBC_Report CR);
       
    public ObservableList<ListCBC_Report> getReport(int R_ID);        
    
    public void updateReport(CBC_Report CR);
    
    public void deleteReport(int R_ID);
    
    public ListCBC_Report selectedReport(ListCBC_Report LCR);
    
}
