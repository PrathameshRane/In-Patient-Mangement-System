package List;

public class ListPatient {
    
    private int P_ID;
    private String NAME;
    private String DOB;
    private String GENDER;
    private int AGE;
    private int WEIGHT;
    private String BLOOD_GRP; 
    private String ADDRESS;
    private String MOBILE_NO;
    private String GUARDIAN_NAME;
    private String GUARDIAN_MOB_NO;
    private String ADMISSION_DATE; 
    private int BED_NO;
    private String D_NAME;
    private String ILLNESS;

   

    public ListPatient(int P_ID, String NAME, String DOB, String GENDER, int AGE, int WEIGHT, String BLOOD_GRP, String ADDRESS, String MOBILE_NO, String GUARDIAN_NAME, String GUARDIAN_MOB_NO, String ADMISSION_DATE, int BED_NO, String D_NAME, String ILLNESS) {
        this.P_ID = P_ID;
        this.NAME = NAME;
        this.DOB = DOB;
        this.GENDER = GENDER;
        this.AGE = AGE;
        this.WEIGHT = WEIGHT;
        this.BLOOD_GRP = BLOOD_GRP;
        this.ADDRESS = ADDRESS;
        this.MOBILE_NO = MOBILE_NO;
        this.GUARDIAN_NAME = GUARDIAN_NAME;
        this.GUARDIAN_MOB_NO = GUARDIAN_MOB_NO;
        this.ADMISSION_DATE = ADMISSION_DATE;
        this.BED_NO = BED_NO;
        this.D_NAME = D_NAME;
        this.ILLNESS = ILLNESS;
    }


    public ListPatient() {
  
    }


    public int getP_ID() {
        return P_ID;
    }

    public void setP_ID(int P_ID) {
        this.P_ID = P_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGENDER() {
        return GENDER;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    public int getAGE() {
        return AGE;
    }

    public void setAGE(int AGE) {
        this.AGE = AGE;
    }

    public int getWEIGHT() {
        return WEIGHT;
    }

    public void setWEIGHT(int WEIGHT) {
        this.WEIGHT = WEIGHT;
    }

    public String getBLOOD_GRP() {
        return BLOOD_GRP;
    }

    public void setBLOOD_GRP(String BLOOD_GRP) {
        this.BLOOD_GRP = BLOOD_GRP;
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

    public String getGUARDIAN_NAME() {
        return GUARDIAN_NAME;
    }

    public void setGUARDIAN_NAME(String GUARDIAN_NAME) {
        this.GUARDIAN_NAME = GUARDIAN_NAME;
    }

    public String getGUARDIAN_MOB_NO() {
        return GUARDIAN_MOB_NO;
    }

    public void setGUARDIAN_MOB_NO(String GUARDIAN_MOB_NO) {
        this.GUARDIAN_MOB_NO = GUARDIAN_MOB_NO;
    }

    public String getADMISSION_DATE() {
        return ADMISSION_DATE;
    }

    public void setADMISSION_DATE(String ADMISSION_DATE) {
        this.ADMISSION_DATE = ADMISSION_DATE;
    }

    public int getBED_NO() {
        return BED_NO;
    }

    public void setBED_NO(int BED_NO) {
        this.BED_NO = BED_NO;
    }

     public String getD_NAME() {
        return D_NAME;
    }

    public void setD_NAME(String D_NAME) {
        this.D_NAME = D_NAME;
    }

    public String getILLNESS() {
        return ILLNESS;
    }

    public void setILLNESS(String ILLNESS) {
        this.ILLNESS = ILLNESS;
    }


    
}
