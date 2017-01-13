package DAOImpl;

import DAO.EmployeeDAO;
import Database.DBConnection;
import List.ListEmployee;
import Model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;

public class EmployeeDAOImpl implements EmployeeDAO {
    
    DBConnection dbCon = new DBConnection();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    ObservableList<ListEmployee> EmployeeDetails = FXCollections.observableArrayList();
    Employee E = new Employee();

    @Override
    public void addEmployee(Employee E) {
        
        try {
            con = dbCon.geConnection();
            pst = con.prepareStatement("insert into Employee_Info(NAME,ADDRESS,MOBILE_NO,ROLE) values(?,?,?,?)");
           
            pst.setString(1, E.getNAME());
            pst.setString(2, E.getADDRESS());
            pst.setString(3, E.getMOBILE_NO());
            pst.setString(4, E.getROLE());
            pst.executeUpdate();
            pst.close();
            con.close();
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Employee Added Succesfully.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Employee2.png").toString()));
        alert.setContentText("Employee Name :" + "  " + E.getNAME() + " " );
        alert.showAndWait();
      }
         catch (SQLException ex) {
           
         }
    
    }
    
    @Override
    public ObservableList<ListEmployee> getEmployee(String Ename) {
        
        EmployeeDetails.clear();
        
        try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select * from Employee_Info where NAME like ? ORDER BY E_ID");
                    pst.setString(1, "%" + Ename + "%");
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        E.setE_ID(rs.getInt(1));
                        E.setNAME(rs.getString(2));
                        E.setADDRESS(rs.getString(3));
                        E.setMOBILE_NO(rs.getString(4));
                        E.setROLE(rs.getString(5));
                        
                        EmployeeDetails.add(new ListEmployee(E.getE_ID(),E.getNAME(),E.getADDRESS(),E.getMOBILE_NO(),E.getROLE()));
                        
                    }
                    
                     pst.close();
                    con.close();
                    rs.close();
                 }
            catch (SQLException ex) {
              
            }
               
            return EmployeeDetails;   
    
    }
    
    @Override
    public ObservableList<ListEmployee> getAllEmployee() {
       
        EmployeeDetails.clear();
        
        try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select * from Employee_Info");
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        E.setE_ID(rs.getInt(1));
                        E.setNAME(rs.getString(2));
                        E.setADDRESS(rs.getString(3));
                        E.setMOBILE_NO(rs.getString(4));
                        E.setROLE(rs.getString(5));
                        
                        EmployeeDetails.add(new ListEmployee(E.getE_ID(),E.getNAME(),E.getADDRESS(),E.getMOBILE_NO(),E.getROLE()));
                        
                    }
                    
                     pst.close();
                    con.close();
                    rs.close();
                 }
            catch (SQLException ex) {
              
            }
               
            return EmployeeDetails;
        
    }
    
     @Override
    public ListEmployee selectedEmployee(ListEmployee LE) {

        try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select * from Employee_Info where E_ID=?");
                    pst.setInt(1, LE.getE_ID());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        LE.setE_ID(rs.getInt(1));
                        LE.setNAME(rs.getString(2));
                        LE.setADDRESS(rs.getString(3));
                        LE.setMOBILE_NO(rs.getString(4));
                        LE.setROLE(rs.getString(5));
                        
                          }
                    
                     pst.close();
                    con.close();
                    rs.close();
                 }
            catch (SQLException ex) {
              
            }
               
            return LE;
        
    }

    @Override
    public void updateEmployee(Employee E) {
    
        
        try {
            con = dbCon.geConnection();
            pst = con.prepareStatement("update Employee_Info set NAME=?,ADDRESS=?,MOBILE_NO=?,ROLE=? where E_ID=?");
           
            pst.setString(1, E.getNAME());
            pst.setString(2, E.getADDRESS());
            pst.setString(3, E.getMOBILE_NO());
            pst.setString(4, E.getROLE());
            pst.setInt(5, E.getE_ID());
            pst.executeUpdate();
            pst.close();
            con.close();
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Employee Updated Succesfully.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Employee2.png").toString()));
        alert.setContentText("Employee Name :" + "  " + E.getNAME() + " " );
        alert.showAndWait();
      }
         catch (SQLException ex) {
           
         }
   
    }

    @Override
    public void deleteEmployee(int E_ID) {
    
           try {
               con = dbCon.geConnection();            
                
               pst = con.prepareStatement("delete from Employee_Info where E_ID="+E_ID);
                pst.executeUpdate();               
                pst.close();
                con.close();
               
            } 
             catch (SQLException ex) {
             
             }
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Selected Employee Deleted Succesfully.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Employee2.png").toString()));     
        alert.showAndWait();
    }

    @Override
    public ArrayList<String> getemployeename() {
      
    
        ArrayList<String> Enames = new ArrayList();
        
        try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select distinct NAME from Employee_Info WHERE ROLE = 'Nurse'");
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        Enames.add(rs.getString(1));
                    }
                    
                     pst.close();
                    con.close();
                    rs.close();
                 }
            catch (SQLException ex) {
              
            }
               
            return Enames;
    
    
        
    }
    
}
