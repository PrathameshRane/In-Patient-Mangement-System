package DAO;

import List.ListLFT_Report;
import Model.LFT_Report;
import javafx.collections.ObservableList;

public interface LFT_ReportDAO {

    public ObservableList<ListLFT_Report> getAllReport();
    
    public void addReport(LFT_Report LR);
       
    public ObservableList<ListLFT_Report> getReport(int R_ID);        
    
    public void updateReport(LFT_Report LR);
    
    public void deleteReport(int R_ID);
    
    public ListLFT_Report selectedReport(ListLFT_Report LLR);
}
