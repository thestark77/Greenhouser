package Model;

public class Process {
    
    //Attributes
    private int id;
    private String name;
    private int hours;
    private int cost;
    private int total;
    private float percent; 
    private Labor labor = new Labor();
    
    //Methods    
    //Constructor
    public Process(int id, String name, int hours, int cost, int total, float percent) {
        this.id = id;
        this.name = name;
        this.hours = hours;
        this.cost = cost;
        this.total = total;
        this.percent = percent;
    }

    public Process(int pruneFrequency, int lastPrune) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public Labor getLabor() {
        return labor;
    }

    public void setLabor(Labor labor) {
        this.labor = labor;
    }
    
}
