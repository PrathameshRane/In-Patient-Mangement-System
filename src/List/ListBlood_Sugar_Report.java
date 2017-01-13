package List;

public class ListBlood_Sugar_Report {
    
    private int R_ID;
    private int P_ID;
    private String Urine_Sugar;
    private String Urine_Acetone;
    private String Random_Blood_Sugar;

    public ListBlood_Sugar_Report(int R_ID, int P_ID, String Urine_Sugar, String Urine_Acetone, String Random_Blood_Sugar) {
        this.R_ID = R_ID;
        this.P_ID = P_ID;
        this.Urine_Sugar = Urine_Sugar;
        this.Urine_Acetone = Urine_Acetone;
        this.Random_Blood_Sugar = Random_Blood_Sugar;
    }
    
    public ListBlood_Sugar_Report()
    {
    
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

    public String getUrine_Sugar() {
        return Urine_Sugar;
    }

    public void setUrine_Sugar(String Urine_Sugar) {
        this.Urine_Sugar = Urine_Sugar;
    }

    public String getUrine_Acetone() {
        return Urine_Acetone;
    }

    public void setUrine_Acetone(String Urine_Acetone) {
        this.Urine_Acetone = Urine_Acetone;
    }

    public String getRandom_Blood_Sugar() {
        return Random_Blood_Sugar;
    }

    public void setRandom_Blood_Sugar(String Random_Blood_Sugar) {
        this.Random_Blood_Sugar = Random_Blood_Sugar;
    }
    
      
    
}
