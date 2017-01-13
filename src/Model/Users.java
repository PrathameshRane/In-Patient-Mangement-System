/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import List.ListUsers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author PRATHAMESH
 */
public class Users extends Employee {
    
    private String USERNAME;
    private String PASSWORD;
    
    public ObservableList<ListUsers> UsersDetails = FXCollections.observableArrayList();

    
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
