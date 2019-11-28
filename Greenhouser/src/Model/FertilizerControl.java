package Model;

public class FertilizerControl extends ProductControl{
    private int dateOfLastApplication[];

    public FertilizerControl(int dateOfLastApplication[], int ICA, String productName, int applicationFrequencyDays) {
        super(ICA, productName, applicationFrequencyDays);
        this.dateOfLastApplication = dateOfLastApplication;
    }

    public int[] getDateOfLastApplication() {
        return dateOfLastApplication;
    }

    public void setDateOfLastApplication(int[] dateOfLastApplication) {
        this.dateOfLastApplication = dateOfLastApplication;
    }

}
