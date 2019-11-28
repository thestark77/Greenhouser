package Model;

public class PestControl extends ProductControl{
    private int periodOfLackDays;

    public PestControl(int periodOfLackDays, int ICA, String productName, int applicationFrequencyDays) {
        super(ICA, productName, applicationFrequencyDays);
        this.periodOfLackDays = periodOfLackDays;
    }

    public int getPeriodOfLackDays() {
        return periodOfLackDays;
    }

    public void setPeriodOfLackDays(int periodOfLackDays) {
        this.periodOfLackDays = periodOfLackDays;
    }
    
}
