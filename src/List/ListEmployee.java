package List;

public class ListEmployee {
    
      private int E_ID;
      private String NAME;
      private String ADDRESS;
      private String MOBILE_NO;
      private String ROLE;

    public ListEmployee(int E_ID, String NAME, String ADDRESS, String MOBILE_NO, String ROLE) {
        this.E_ID = E_ID;
        this.NAME = NAME;
        this.ADDRESS = ADDRESS;
        this.MOBILE_NO = MOBILE_NO;
        this.ROLE = ROLE;  
    }

    public ListEmployee() {
   
    }

    public int getE_ID() {
        return E_ID;
    }

    public void setE_ID(int E_ID) {
        this.E_ID = E_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getMOBILE_NO() {
        return MOBILE_NO;
    }

    public void setMOBILE_NO(String MOBILE_NO) {
        this.MOBILE_NO = MOBILE_NO;
    }

    public String getROLE() {
        return ROLE;
    }

    public void setROLE(String ROLE) {
        this.ROLE = ROLE;
    }

      
}
