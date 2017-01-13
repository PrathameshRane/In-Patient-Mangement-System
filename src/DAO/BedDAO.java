package DAO;

import List.ListBed;
import Model.Bed;
import java.util.ArrayList;
import javafx.collections.ObservableList;

public interface BedDAO {

    public ObservableList<ListBed> getAllBed();
    
    public ObservableList<ListBed> getBed(int Bedno);
    
    public ListBed selectedBed(ListBed LB);
    
    public void updateBed(Bed B);
    
    public void updateBedStatus(int bno);
    
    public ArrayList<Integer> getbedno();
    
}
