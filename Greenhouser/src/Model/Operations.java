package Model;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Operations {
        
    public void addProducer(ArrayList <Producer> producersArray, int id, String name, String lastName){
        Producer theProducer = new Producer(id, name, lastName);
        producersArray.add(theProducer);
        JOptionPane.showMessageDialog(null,"Producer has been added successfully!");
    }
    
    public void addGreenHouse(ArrayList <GreenHouse> GreenhousesArray, int code, String name, String department, String township){
        GreenHouse theGreenhouse = new GreenHouse(code, name, department, township);
        GreenhousesArray.add(theGreenhouse);
        JOptionPane.showMessageDialog(null,"Greenhouse has been added successfully!");
    }
    
    public void addProcess(ArrayList <Process> ProcessesArray, int id, String name, int hours, int cost, int total, float percent){
        Process theProcess = new Process(id, name, hours, cost, total, percent);
        ProcessesArray.add(theProcess);
        JOptionPane.showMessageDialog(null,"Process has been added successfully!");
    }
    
    public void addFertilizerControl(ArrayList <FertilizerControl> FertilizerControlArray, int dateOfLastApplication[], int ICA, String productName, int applicationFrequencyDays){
        FertilizerControl theFertilizerControl = new FertilizerControl(dateOfLastApplication, ICA, productName, applicationFrequencyDays);
        FertilizerControlArray.add(theFertilizerControl);
        JOptionPane.showMessageDialog(null,"Fertilizer Control has been added successfully!");
    }
    
    public void addPestControl(ArrayList <PestControl> PestControlArray, int periodOfLackDays, int ICA, String productName, int applicationFrequencyDays){
        PestControl thePestControl = new PestControl(periodOfLackDays, ICA, productName, applicationFrequencyDays);
        PestControlArray.add(thePestControl);
        JOptionPane.showMessageDialog(null,"Pest Control has been added successfully!");
    }
    
    public void addFungusControl(ArrayList <FungusControl> FungusControlArray, String name, int frequency, int FugusICA, int LackPeriodDays, int ICA, String productName, int applicationFrequencyDays){
        FungusControl theFungusControl = new FungusControl(name, frequency, FugusICA, LackPeriodDays, ICA, productName, applicationFrequencyDays);
        FungusControlArray.add(theFungusControl);
        JOptionPane.showMessageDialog(null,"Fungus Control has been added successfully!");
    }
    
    public void addWPC(Labor theLabor, int pruneFrequency, int lastPrune){
        WeedPhysicalControl theWPC = new WeedPhysicalControl(pruneFrequency, lastPrune);
        theLabor.getWeedPhysicalControlArray().add(theWPC);
        JOptionPane.showMessageDialog(null,"WPC has been added successfully!");
    }
    
    public void deleteProducer(ArrayList <Producer> producersArray, int id){
        boolean deleted = false;
        Producer theProducerForDelete = new Producer(1,"","");
        
        for(Producer i: producersArray){
            if (i.getId() == id) {
                theProducerForDelete = i;
                deleted = true;
            }
        }
        producersArray.remove(theProducerForDelete);
        
        if (deleted) {
            JOptionPane.showMessageDialog(null,"Producer has been removed successfully!");
        }else{
            JOptionPane.showMessageDialog(null,"The producer is not on the list...");
        }
    }
    
    public Producer ProducerIsAlreadyOnList(ArrayList <Producer> producersArray, int id){
        Producer theProducer = null;
        
        for(Producer i: producersArray){
            if (i.getId() == id) {
                theProducer = i;
            }
        }
        
        return theProducer;
    }
    
    public GreenHouse GreenhouseIsAlreadyOnList(ArrayList <GreenHouse> greenHousesArray, int code){
        GreenHouse theGreenhouse = null;
        
        for(GreenHouse i: greenHousesArray){
            if (i.getCode() == code) {
                theGreenhouse = i;
            }
        }
        
        return theGreenhouse;
    }
    
    public Process ProcessIsAlreadyOnList(ArrayList <Process> processesArray, int code){
        Process theProcess = null;
        
        for(Process i: processesArray){
            if (i.getId() == code) {
                theProcess = i;
            }
        }
        
        return theProcess;
    }
    
    public ProductControl ProductControlIsAlreadyOnList(ArrayList <ProductControl> ProductControlArray, int ICA){
        ProductControl theProductControl = null;
        
        for(ProductControl i: ProductControlArray){
            if (i.getICA() == ICA) {
                theProductControl = i;
            }
        }
        
        return theProductControl;
    }
    
    SimpleDateFormat Format = new SimpleDateFormat("dd-MM-yyyy");
    public String getFecha(JDateChooser jd) {
        if (jd.getDate() != null) {
            return Format.format(jd.getDate());
        } else {
            return null;
        }
    }
    
    public java.util.Date stringToDate(String date){
        SimpleDateFormat textFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dateE = null;
        try{
            dateE = textFormat.parse(date);
            return dateE;
        }catch(ParseException ex){
            return null;
        }
    }
//  if(getFecha(jDateChooser1)!=null){
//                                //Acciones
//                            }else {
//                             jLabel1.setText("Por favor ingrese una fecha correcta");
//                          }
    
    public void searchProducerListGreenHouses(ArrayList <Producer> producersArray){
        int id;
        id = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID you want to search..."));
        boolean foundId = false;
        String message = "";
        int counter = 1;
        
        for(Producer i: producersArray){
            if (i.getId() == id) {
                foundId = true;
                
                message = "Producer(+), Nursery(-)\n\n Producer " + counter + ": \n";
                message+="+id: " + Integer.toString(i.getId()) + " | Name: " + i.getName() + " | Last name: " + i.getLastName() + "\n";
                for(GreenHouse j: i.getgreenHousesArray()){
                    message+=" - code: " + Integer.toString(j.getCode()) + " | name: " + j.getName() + " | department: " + j.getDepartment() + " | township: " + j.getTownship() + "\n";
                }
            }
            counter++;
        }
        if (foundId) {
            JOptionPane.showMessageDialog(null,message);
        }else{
            JOptionPane.showMessageDialog(null,"The id entered has not been found in the list of producers...");
        }
        
    }
    
    public void searchProducerListLabors(ArrayList <Producer> producersArray){
        int id;
        id = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID you want to search..."));
        boolean foundId = false;
        String message = "";
        int counter = 1;
        
        for(Producer i: producersArray){
            if (i.getId() == id) {
                foundId = true;
                
                message = "Producer(+), Nursery(-), Process(*), Labor (~)\n\n Producer " + counter + ": \n";
                message+="+id: " + Integer.toString(i.getId()) + " | Name: " + i.getName() + " | Last name: " + i.getLastName() + "\n";
                for(GreenHouse j: i.getgreenHousesArray()){
                    message+=" - code: " + Integer.toString(j.getCode()) + " | name: " + j.getName() + " | department: " + j.getDepartment() + " | township: " + j.getTownship() + "\n";
                    for(Process k: j.getProcessesArray()){
                        message+="  * id: " + Integer.toString(k.getId()) + " | name: " + k.getName() + " | hours: " + Integer.toString(k.getHours()) + " | cost: " + Integer.toString(k.getCost()) + " | total: " + Integer.toString(k.getTotal()) + " | percent: " + Float.toString(k.getPercent()) + "\n";
//                        for(Labor l: k.getLaborsArray()){
//                            message+="   ~ id: " + Integer.toString(l.getId()) + " | type: " + l.getType() + " | dateOfRealization: " + Integer.toString(l.getDateOfRealization()[0]) + "/" + Integer.toString(l.getDateOfRealization()[1]) + "/" + Integer.toString(l.getDateOfRealization()[2]) + " | description: " + l.getDescription() + "\n";
//                        }
                    }
                }
            }
            counter++;
        }
        if (foundId) {
            JOptionPane.showMessageDialog(null,message);
        }else{
            JOptionPane.showMessageDialog(null,"The id entered has not been found in the list of producers...");
        }
    }
    

    
}
