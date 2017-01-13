package List;

public class ListLFT_Report {
    
    private int R_ID;
    private int P_ID;
    private String Bilirubin_Total;
    private String SGOT;
    private String SGPT;
    private String Alkaline_Phosphatase;
    private String Proteins;
    private String Albumin;
    private String Globulin;
    private String AG_Ratio;
    private String GGTP;

    public ListLFT_Report(int R_ID,int P_ID, String Bilirubin_Total, String SGOT, String SGPT, String Alkaline_Phosphatase, String Proteins, String Albumin, String Globulin, String AG_Ratio, String GGTP) {
        this.R_ID = R_ID;
        this.P_ID = P_ID;
        this.Bilirubin_Total = Bilirubin_Total;
        this.SGOT = SGOT;
        this.SGPT = SGPT;
        this.Alkaline_Phosphatase = Alkaline_Phosphatase;
        this.Proteins = Proteins;
        this.Albumin = Albumin;
        this.Globulin = Globulin;
        this.AG_Ratio = AG_Ratio;
        this.GGTP = GGTP;
    }
    
    
    public ListLFT_Report(){
        
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

    public String getBilirubin_Total() {
        return Bilirubin_Total;
    }

    public void setBilirubin_Total(String Bilirubin_Total) {
        this.Bilirubin_Total = Bilirubin_Total;
    }

    public String getSGOT() {
        return SGOT;
    }

    public void setSGOT(String SGOT) {
        this.SGOT = SGOT;
    }

    public String getSGPT() {
        return SGPT;
    }

    public void setSGPT(String SGPT) {
        this.SGPT = SGPT;
    }

    public String getAlkaline_Phosphatase() {
        return Alkaline_Phosphatase;
    }

    public void setAlkaline_Phosphatase(String Alkaline_Phosphatase) {
        this.Alkaline_Phosphatase = Alkaline_Phosphatase;
    }

    public String getProteins() {
        return Proteins;
    }

    public void setProteins(String Proteins) {
        this.Proteins = Proteins;
    }

    public String getAlbumin() {
        return Albumin;
    }

    public void setAlbumin(String Albumin) {
        this.Albumin = Albumin;
    }

    public String getGlobulin() {
        return Globulin;
    }

    public void setGlobulin(String Globulin) {
        this.Globulin = Globulin;
    }

    public String getAG_Ratio() {
        return AG_Ratio;
    }

    public void setAG_Ratio(String AG_Ratio) {
        this.AG_Ratio = AG_Ratio;
    }

    public String getGGTP() {
        return GGTP;
    }

    public void setGGTP(String GGTP) {
        this.GGTP = GGTP;
    }
       
      
        
}
