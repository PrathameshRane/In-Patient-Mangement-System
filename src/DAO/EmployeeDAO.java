package DAO;

import List.ListEmployee;
import Model.Employee;
import java.util.ArrayList;
import javafx.collections.ObservableList;

public interface EmployeeDAO {  

    public ObservableList<ListEmployee> getAllEmployee();
    
    public void addEmployee(Employee E);
    
    public ObservableList<ListEmployee> getEmployee(String name);
    
    public void updateEmployee(Employee E);
    
    public void deleteEmployee(int E_ID);
    
    public ListEmployee selectedEmployee(ListEmployee LE);
    
    public ArrayList<String> getemployeename();
    
}
