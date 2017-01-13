package List;

public class ListPatient_Test {

    private int T_ID;
    private int P_ID;
    private String T_NAME;
    private String T_DATE;
    private String REF_BY;

    public ListPatient_Test(int T_ID, int P_ID, String T_NAME, String T_DATE, String REF_BY) {
        this.T_ID = T_ID;
        this.P_ID = P_ID;
        this.T_NAME = T_NAME;
        this.T_DATE = T_DATE;
        this.REF_BY = REF_BY;
    }

    public ListPatient_Test() {
            
    }

    public int getT_ID() {
        return T_ID;
    }

    public void setT_ID(int T_ID) {
        this.T_ID = T_ID;
    }

    public int getP_ID() {
        return P_ID;
    }

    public void setP_ID(int P_ID) {
        this.P_ID = P_ID;
    }

    public String getT_NAME() {
        return T_NAME;
    }

    public void setT_NAME(String T_NAME) {
        this.T_NAME = T_NAME;
    }

    public String getT_DATE() {
        return T_DATE;
    }

    public void setT_DATE(String T_DATE) {
        this.T_DATE = T_DATE;
    }

    public String getREF_BY() {
        return REF_BY;
    }

    public void setREF_BY(String REF_BY) {
        this.REF_BY = REF_BY;
    }

       
    
}
