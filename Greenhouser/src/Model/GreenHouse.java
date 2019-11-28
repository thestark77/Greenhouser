package Model;

import java.util.ArrayList;

public class GreenHouse {
    //Attributes
    private int code;
    private String name;
    private String department;
    private String township;
    private ArrayList <Process> processesArray = new ArrayList<>();
    
    //Methods
    //Constructor
    public GreenHouse(int code, String name, String department, String township) {
        this.code = code;
        this.name = name;
        this.department = department;
        this.township = township;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public ArrayList<Process> getProcessesArray() {
        return processesArray;
    }

    public void setProcessesArray(ArrayList<Process> processesArray) {
        this.processesArray = processesArray;
    }
    
}
