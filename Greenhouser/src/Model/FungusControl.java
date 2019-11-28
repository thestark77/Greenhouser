package Model;

public class FungusControl  extends ProductControl{
    private String name;
    private int frequency;
    private int FugusICA;
    private int LackPeriodDays;

    public FungusControl(String name, int frequency, int FugusICA, int LackPeriodDays, int ICA, String productName, int applicationFrequencyDays) {
        super(ICA, productName, applicationFrequencyDays);
        this.name = name;
        this.frequency = frequency;
        this.FugusICA = FugusICA;
        this.LackPeriodDays = LackPeriodDays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getFugusICA() {
        return FugusICA;
    }

    public void setFugusICA(int FugusICA) {
        this.FugusICA = FugusICA;
    }

    public int getLackPeriodDays() {
        return LackPeriodDays;
    }

    public void setLackPeriodDays(int LackPeriodDays) {
        this.LackPeriodDays = LackPeriodDays;
    }
    
}
