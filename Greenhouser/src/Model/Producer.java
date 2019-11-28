package Model;

import java.util.ArrayList;

public class Producer {
    
    //Attributes
    private int id;
    private String name;
    private String lastName;
    private ArrayList <GreenHouse> greenHousesArray = new ArrayList<>();
    
    //Methods    
    //Constructor
    public Producer(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public Producer() {
    }
    
    //Getters
    public ArrayList<GreenHouse> getgreenHousesArray() {
        return greenHousesArray;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<GreenHouse> getGreenHousesArray() {
        return greenHousesArray;
    }

    public void setGreenHousesArray(ArrayList<GreenHouse> greenHousesArray) {
        this.greenHousesArray = greenHousesArray;
    }

}
