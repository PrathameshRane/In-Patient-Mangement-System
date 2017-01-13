package DAO;

import List.ListDoctor_Info;
import Model.Doctor_Info;
import java.util.ArrayList;
import javafx.collections.ObservableList;

public interface DoctorDAO {

    public ObservableList<ListDoctor_Info> getAllDoctors();
    
    public void addDoctor(Doctor_Info D);
    
    public ObservableList<ListDoctor_Info> getDoctor(String name);
    
    public void updateDoctor(Doctor_Info D);
    
    public void deleteDoctor(int D_ID);
    
    public ListDoctor_Info selectedDoctor(ListDoctor_Info D);
    
    public ArrayList<String> getdoctorname();
}
