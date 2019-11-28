package Model;

import java.util.ArrayList;

public class ProductControl extends Labor{
    private int ICA;
    private String productName;
    private int applicationFrequencyDays;
    private ArrayList <FungusControl> fungusControlArray = new ArrayList<>();
    private ArrayList <FertilizerControl> fertilizerControlArray = new ArrayList<>();
    private ArrayList <PestControl> pestControlArray = new ArrayList<>();

    public ProductControl(int ICA, String productName, int applicationFrequencyDays) {
        this.ICA = ICA;
        this.productName = productName;
        this.applicationFrequencyDays = applicationFrequencyDays;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getApplicationFrequencyDays() {
        return applicationFrequencyDays;
    }

    public void setApplicationFrequencyDays(int applicationFrequencyDays) {
        this.applicationFrequencyDays = applicationFrequencyDays;
    }

    public ArrayList<FungusControl> getFungusControlArray() {
        return fungusControlArray;
    }

    public void setFungusControlArray(ArrayList<FungusControl> fungusControlArray) {
        this.fungusControlArray = fungusControlArray;
    }

    public ArrayList<FertilizerControl> getFertilizerControlArray() {
        return fertilizerControlArray;
    }

    public void setFertilizerControlArray(ArrayList<FertilizerControl> fertilizerControlArray) {
        this.fertilizerControlArray = fertilizerControlArray;
    }

    public ArrayList<PestControl> getPestControlArray() {
        return pestControlArray;
    }

    public void setPestControlArray(ArrayList<PestControl> pestControlArray) {
        this.pestControlArray = pestControlArray;
    }

    public int getICA() {
        return ICA;
    }
    
}
