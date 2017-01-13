package DAO;

import List.ListBlood_Sugar_Report;
import Model.Blood_Sugar_Report;
import javafx.collections.ObservableList;

public interface Blood_Sugar_ReportDAO {

    public ObservableList<ListBlood_Sugar_Report> getAllReport();
    
    public void addReport(Blood_Sugar_Report BSR);
       
    public ObservableList<ListBlood_Sugar_Report> getReport(int R_ID);        
    
    public void updateReport(Blood_Sugar_Report BSR);
    
    public void deleteReport(int R_ID);
    
    public ListBlood_Sugar_Report selectedReport(ListBlood_Sugar_Report LBSR);
    
}
