package DAOImpl;

import DAO.TestDAO;
import Database.DBConnection;
import List.ListPatient_Test;
import Model.Patient_Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;

public class TestDAOImpl implements TestDAO {

    DBConnection dbCon = new DBConnection();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public ObservableList<ListPatient_Test> TestDetails = FXCollections.observableArrayList();
    Patient_Test T = new Patient_Test();  

    @Override
    public void addTest(Patient_Test T) {
        
        try {
            con = dbCon.geConnection();
            pst = con.prepareStatement("insert into Patient_Test(P_ID,T_NAME,T_DATE,REF_BY) values(?,?,?,?)");
           
            pst.setInt(1, T.getP_ID());
            pst.setString(2, T.getT_NAME());
            pst.setString(3, T.getT_DATE());
            pst.setString(4, T.getREF_BY());
            pst.executeUpdate();
            pst.close();
            con.close();
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Patient Test Added Succesfully.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Test2.png").toString()));
        alert.setContentText("Test Name :" + "  " + T.getT_NAME() + " " );
        alert.showAndWait();
      }
         catch (SQLException ex) {
           
         }
    
    }

    @Override
    public ObservableList<ListPatient_Test> getTest(int P_id) {
    
        TestDetails.clear();
        try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select * from Patient_Test where P_ID like ? ORDER BY T_ID");
                    pst.setInt(1, P_id);
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        T.setT_ID(rs.getInt(1));
                        T.setP_ID(rs.getInt(2));
                        T.setT_NAME(rs.getString(3));
                        T.setT_DATE(rs.getString(4));
                        T.setREF_BY(rs.getString(5));
                        
                        TestDetails.add(new ListPatient_Test(T.getT_ID(), T.getP_ID(), T.getT_NAME(), T.getT_DATE(), T.getREF_BY()));
                        
                    }
                    
                     pst.close();
                    con.close();
                    rs.close();
                 }
            catch (SQLException ex) {
              
            }
        
        return TestDetails;
    }
    
    @Override
    public ObservableList<ListPatient_Test> getAllTest() {
       
        TestDetails.clear();
        try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select * from Patient_Test");                   
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        T.setT_ID(rs.getInt(1));
                        T.setP_ID(rs.getInt(2));
                        T.setT_NAME(rs.getString(3));
                        T.setT_DATE(rs.getString(4));                
                        T.setREF_BY(rs.getString(5));
                        
                        TestDetails.add(new ListPatient_Test(T.getT_ID(), T.getP_ID(), T.getT_NAME(), T.getT_DATE(), T.getREF_BY()));
                        
                    }
                    
                     pst.close();
                    con.close();
                    rs.close();
                 }
            catch (SQLException ex) {
              
            }
        return TestDetails;
        
    }
    
    @Override
    public ListPatient_Test selectedTest(ListPatient_Test LT) {
    
        try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select * from Patient_Test where T_ID=?");
                    pst.setInt(1, LT.getT_ID());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        LT.setT_ID(rs.getInt(1));
                        LT.setP_ID(rs.getInt(2));
                        LT.setT_NAME(rs.getString(3));
                        LT.setT_DATE(rs.getString(4));
                        LT.setREF_BY(rs.getString(5));
                        
                          }
                    
                     pst.close();
                    con.close();
                    rs.close();
                 }
            catch (SQLException ex) {
              
            }
               
            return LT;
        
    }

    @Override
    public void updateTest(Patient_Test T) {
        
        try {
            con = dbCon.geConnection();
            pst = con.prepareStatement("update Patient_Test set P_ID=?,T_NAME=?,T_DATE=?,REF_BY=? where T_ID=?");
           
            pst.setInt(1, T.getP_ID());
            pst.setString(2, T.getT_NAME());
            pst.setString(3, T.getT_DATE());
             pst.setString(4, T.getREF_BY());
            pst.setInt(5, T.getT_ID());
           
            pst.executeUpdate();
            pst.close();
            con.close();
            
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Patient Test Updated Succesfully.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Test2.png").toString()));
        alert.setContentText("Test Name :" + "  " + T.getT_NAME() + " " );
        alert.showAndWait();
      }
         catch (SQLException ex) {
           
         }     
        
    }

    @Override
    public void deleteTest(int T_ID) {
    
        try {
               con = dbCon.geConnection();            
                
               pst = con.prepareStatement("delete from Patient_Test where T_ID="+T_ID);
                pst.executeUpdate();               
                pst.close();
                con.close();
               
            } 
             catch (SQLException ex) {
             
             }
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Selected Patient Test Deleted Succesfully.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Test2.png").toString()));     
        alert.showAndWait();
        
    }

    

}
