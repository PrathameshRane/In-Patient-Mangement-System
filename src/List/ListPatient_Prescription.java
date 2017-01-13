/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

/**
 *
 * @author PRATHAMESH
 */
public class ListPatient_Prescription {
    
    private int P_ID;
    private String D_NAME;
    private String MEDICATION;
    private String DOSE;
    private String TEST;

    public ListPatient_Prescription(int P_ID, String D_NAME, String MEDICATION, String DOSE, String TEST) {
        this.P_ID = P_ID;
        this.D_NAME = D_NAME;
        this.MEDICATION = MEDICATION;
        this.DOSE = DOSE;
        this.TEST = TEST;
    }

    public ListPatient_Prescription() {
    
    
    }

   

    public int getP_ID() {
        return P_ID;
    }

    public void setP_ID(int P_ID) {
        this.P_ID = P_ID;
    }

    public String getD_NAME() {
        return D_NAME;
    }

    public void setD_NAME(String D_NAME) {
        this.D_NAME = D_NAME;
    }

    public String getMEDICATION() {
        return MEDICATION;
    }

    public void setMEDICATION(String MEDICATION) {
        this.MEDICATION = MEDICATION;
    }

    public String getDOSE() {
        return DOSE;
    }

    public void setDOSE(String DOSE) {
        this.DOSE = DOSE;
    }
    
    public String getTEST() {
        return TEST;
    }

    public void setTEST(String TEST) {
        this.TEST = TEST;
    }
    
}
