package Model;

import java.util.ArrayList;

public class Labor {
    //Attributes
    private ArrayList <ProductControl> productControlArray = new ArrayList<>();
    private ArrayList <WeedPhysicalControl> weedPhysicalControlArray = new ArrayList<>();   

    public ArrayList<ProductControl> getProductControlArray() {
        return productControlArray;
    }

    public void setProductControlArray(ArrayList<ProductControl> productControlArray) {
        this.productControlArray = productControlArray;
    }

    public ArrayList<WeedPhysicalControl> getWeedPhysicalControlArray() {
        return weedPhysicalControlArray;
    }

    public void setWeedPhysicalControlArray(ArrayList<WeedPhysicalControl> weedPhysicalControlArray) {
        this.weedPhysicalControlArray = weedPhysicalControlArray;
    }

}