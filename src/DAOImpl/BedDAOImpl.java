package DAOImpl;

import DAO.BedDAO;
import Database.DBConnection;
import List.ListBed;
import Model.Bed;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;


public class BedDAOImpl implements BedDAO {
      
    DBConnection dbCon = new DBConnection();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    ObservableList<ListBed> BedDetails = FXCollections.observableArrayList();
    Bed B = new Bed();

    @Override
    public ObservableList<ListBed> getAllBed() {
       
        BedDetails.clear();
        
        try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select * from Bed_Info");
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        B.setBED_NO(rs.getInt(1));
                        B.setSTATUS(rs.getString(2));
                        B.setE_NAME(rs.getString(3));
                        
                        BedDetails.add(new ListBed(B.getBED_NO(), B.getSTATUS(), B.getE_NAME()));
                        
                    }
                    
                     pst.close();
                    con.close();
                    rs.close();
                 }
            catch (SQLException ex) {
              
            }
               
            return BedDetails;
        
    }

    

    @Override
    public void updateBed(Bed B) {
       
         try {
            con = dbCon.geConnection();
            pst = con.prepareStatement("update Bed_Info set STATUS=?,E_NAME=? where BED_NO=?");          
            pst.setString(1, B.getSTATUS());
            pst.setString(2, B.getE_NAME());
            pst.setInt(3, B.getBED_NO());
            pst.executeUpdate();
            pst.close();
            con.close();
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Bed Details Updated Succesfully.");
        alert.setGraphic(new ImageView(this.getClass().getResource("/Icons/Bed2.png").toString()));
        alert.setContentText("Bed NO :" + "  " + B.getBED_NO() + " " );
        alert.showAndWait();
      }
         catch (SQLException ex) {
           
         }
        
    }

    @Override
    public ListBed selectedBed(ListBed LB) {
       
        try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select * from Bed_Info where BED_NO=?");
                    pst.setInt(1, LB.getBED_NO());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        LB.setBED_NO(rs.getInt(1));
                        LB.setSTATUS(rs.getString(2));
                        LB.setE_NAME(rs.getString(3));
                                                 
                    }
                    
                     pst.close();
                    con.close();
                    rs.close();
                 }
            catch (SQLException ex) {
              
            }
               
            return LB;
    
    }

    @Override
    public ObservableList<ListBed> getBed(int Bedno) {
        
        BedDetails.clear();
        
        try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select * from Bed_Info where BED_NO = ? ");
                    pst.setInt(1, Bedno);
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        B.setBED_NO(rs.getInt(1));
                        B.setSTATUS(rs.getString(2));
                        B.setE_NAME(rs.getString(3));
                        
                        BedDetails.add(new ListBed(B.getBED_NO(), B.getSTATUS(), B.getE_NAME()));
                        
                    }
                    
                     pst.close();
                    con.close();
                    rs.close();
                 }
            catch (SQLException ex) {
              
            }
               
            return BedDetails;   
    
    }

    @Override
    public ArrayList<Integer> getbedno() {
    
        ArrayList<Integer> Bednos = new ArrayList();
        
        try {
                
                con = dbCon.geConnection();            

                    pst = con.prepareStatement("select BED_NO from Bed_Info where STATUS = 'Empty'");
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        
                        Bednos.add(rs.getInt(1));
                    }
                    
                     pst.close();
                    con.close();
                    rs.close();
                 }
            catch (SQLException ex) {
              
            }
               
            return Bednos;
    
    }

    @Override
    public void updateBedStatus(int bno) {
        
        try {
            con = dbCon.geConnection();
            pst = con.prepareStatement("update Bed_Info set STATUS= 'Full' where BED_NO=?");          
       
            pst.setInt(1, bno);
            pst.executeUpdate();
            pst.close();
            con.close();
                    
      }
         catch (SQLException ex) {
           
         }
    
    }

    
}
