package Crud;

import Controller.Controller;
import Model.Producer;
import View.ProducerRegistry;
import java.util.ArrayList;

public class Crud {
    ProducerRegistry view = new ProducerRegistry();
    public static ArrayList <Producer> producersArray = new ArrayList<>();
    
    public void start(){
        Controller theController = new Controller(producersArray, view);
        theController.startController();
        view.setVisible(true);
    }
}
