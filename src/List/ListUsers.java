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
public class ListUsers {
    
    private int U_ID;
    private String USERNAME;
    private String PASSWORD;

    public ListUsers(int U_ID, String USERNAME, String PASSWORD) {
        this.U_ID = U_ID;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
    }

    public int getU_ID() {
        return U_ID;
    }

    public void setU_ID(int U_ID) {
        this.U_ID = U_ID;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
    
    
}
