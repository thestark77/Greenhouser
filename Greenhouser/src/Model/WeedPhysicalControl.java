package Model;

public class WeedPhysicalControl extends Labor{
    private int pruneFrequency;
    private int lastPrune;

    public WeedPhysicalControl(int pruneFrequency, int lastPrune) {
        this.pruneFrequency = pruneFrequency;
        this.lastPrune = lastPrune;
    }

}
