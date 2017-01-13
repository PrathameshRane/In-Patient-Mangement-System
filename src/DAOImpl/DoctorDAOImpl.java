package DAOImpl;

import DAO.DoctorDAO;
import Database.DBConnection;
import List.ListDoctor_Info;
import Model.Doctor_Info;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;

public class DoctorDAOImpl implements DoctorDAO {
    
    DBConnection dbCon = new DBConnection();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    ObservableList<ListDoctor_Info> DoctorDetails = FXCollections.observableArrayList();
    Doctor_Info D = new Doctor_Info();
    

    @Override
    public void addDoctor(Doctor_Info D) {
    
        try {
            con = dbCon.geConnection();
            pst = con.prepareStatement("insert into Doctor_Info(D_NAME,ADDRESS,MOBILE_NO,SPECIALITY) values(?,?,?,?)");
           
            pst.setString(1, D.getD_NAME());
            pst.setString(2, D.getADDRESS());
            pst.setString(3, D.getMOBILE_NO());
            pst.setString(4, D.getSPECIALITY());
            pst.executeUpdate();
            pst.close();
            con.close();
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Doctor Added Succesfully.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Doctor2.png").toString()));
        alert.setContentText("Doctor Name :" + "  " + D.getD_NAME() + " " );
        alert.showAndWait();
      }
         catch (SQLException ex) {
           
         }
    }
      
    @Override
    public ObservableList<ListDoctor_Info> getAllDoctors() {
        
        DoctorDetails.clear();
        try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select * from Doctor_Info");
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        D.setD_ID(rs.getInt(1));
                        D.setD_NAME(rs.getString(2));
                        D.setADDRESS(rs.getString(3));
                        D.setMOBILE_NO(rs.getString(4));
                        D.setSPECIALITY(rs.getString(5));
                        
                        DoctorDetails.add(new ListDoctor_Info(D.getD_ID(),D.getD_NAME(),D.getADDRESS(),D.getMOBILE_NO(),D.getSPECIALITY()));
                        
                    }
                    
                     pst.close();
                    con.close();
                    rs.close();
                 }
            catch (SQLException ex) {
              
            }
               
            return DoctorDetails;
                         
    }

    @Override
    public ObservableList<ListDoctor_Info> getDoctor(String Dname) {
        DoctorDetails.clear();
        try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select * from Doctor_Info where D_NAME like ? ORDER BY D_ID");
                    pst.setString(1, "%" + Dname + "%");
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        D.setD_ID(rs.getInt(1));
                        D.setD_NAME(rs.getString(2));
                        D.setADDRESS(rs.getString(3));
                        D.setMOBILE_NO(rs.getString(4));
                        D.setSPECIALITY(rs.getString(5));
                        
                        DoctorDetails.add(new ListDoctor_Info(D.getD_ID(),D.getD_NAME(),D.getADDRESS(),D.getMOBILE_NO(),D.getSPECIALITY()));
                        
                    }
                    
                     pst.close();
                    con.close();
                    rs.close();
                 }
            catch (SQLException ex) {
              
            }
               
            return DoctorDetails;
    
    }
    
    @Override
    public ListDoctor_Info selectedDoctor(ListDoctor_Info LD) {
    
        try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select * from Doctor_Info where D_ID=?");
                    pst.setInt(1, LD.getD_ID());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        LD.setD_ID(rs.getInt(1));
                        LD.setD_NAME(rs.getString(2));
                        LD.setADDRESS(rs.getString(3));
                        LD.setMOBILE_NO(rs.getString(4));
                        LD.setSPECIALITY(rs.getString(5));
                    }
            pst.close();
            con.close();
            rs.close();
        } 
        catch (SQLException e) {
        }
            
        return LD;
    }

    @Override
    public void updateDoctor(Doctor_Info D) {
    
        try {
            con = dbCon.geConnection();
            pst = con.prepareStatement("update Doctor_Info set D_NAME=?,ADDRESS=?,MOBILE_NO=?,SPECIALITY=? where D_ID=?");
 
            pst.setString(1, D.getD_NAME());
            pst.setString(2, D.getADDRESS());
            pst.setString(3, D.getMOBILE_NO());
            pst.setString(4, D.getSPECIALITY());
            pst.setInt(5, D.getD_ID());
            pst.executeUpdate();
            pst.close();
            con.close();
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Doctor Updated Succesfully.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Doctor2.png").toString()));
        alert.setContentText("Doctor Name :" + "  " + D.getD_NAME() + " " );
        alert.showAndWait();
      }
         catch (SQLException ex) {
           
         }
        
    
    }

    @Override
    public void deleteDoctor(int D_ID) {
    
    
        try {
               con = dbCon.geConnection();            
                
               pst = con.prepareStatement("delete from Doctor_Info where D_ID="+D_ID);
                pst.executeUpdate();               
                pst.close();
                con.close();
               
            } 
             catch (SQLException ex) {
             
             }
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Selected Doctor Deleted Succesfully.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Doctor2.png").toString()));     
        alert.showAndWait();
        
    }

    @Override
    public ArrayList<String> getdoctorname() {    
        
        ArrayList<String> Dnames = new ArrayList();
        
        try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select distinct D_NAME from Doctor_Info");
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        Dnames.add(rs.getString(1));
                    }
                    
                     pst.close();
                    con.close();
                    rs.close();
                 }
            catch (SQLException ex) {
              
            }
               
            return Dnames;
    
    }
       
}
