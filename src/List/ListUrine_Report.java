package List;

public class ListUrine_Report {

    private int R_ID;
    private int P_ID;
    private String Acetone;

    public ListUrine_Report(int R_ID, int P_ID, String Acetone) {
        this.R_ID = R_ID;
        this.P_ID = P_ID;
        this.Acetone = Acetone;
    }

    public ListUrine_Report() {
    }

    
    
    public int getR_ID() {
        return R_ID;
    }

    public void setR_ID(int R_ID) {
        this.R_ID = R_ID;
    }

    public int getP_ID() {
        return P_ID;
    }

    public void setP_ID(int P_ID) {
        this.P_ID = P_ID;
    }

    public String getAcetone() {
        return Acetone;
    }

    public void setAcetone(String Acetone) {
        this.Acetone = Acetone;
    }
    
    
    
}
