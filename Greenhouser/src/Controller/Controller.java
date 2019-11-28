package Controller;

import static Crud.Crud.producersArray;
import Model.GreenHouse;
import Model.Labor;
import Model.Operations;
import Model.Process;
import Model.Producer;
import Model.ProductControl;
import View.ProducerRegistry;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Controller implements ActionListener{
    
    private Producer theProducer;
    private GreenHouse theGreenhouse;
    private Process theProcess;
    private Labor theLabor;
    private ProductControl theProductControl;
//    private WeedPhysicalControl theWeedPhysicalControl;
//    private FertilizerControl theFertilizerControl;
//    private PestControl thePestControl;
//    private FungusControl theFungusControl;
    private ProducerRegistry view;
    private Operations modelOperations = new Operations();
    
    
    public Controller(ArrayList <Producer> producersArray, ProducerRegistry view){
        //this.theProducer = theProducer;
        this.view = view;
        
        //Buttons
        
        //panelPrincipal
        view.btnAddProducerPanelPrincipal.addActionListener(this);
        view.btnSearchProducerPanelPrincipal.addActionListener(this);      
        view.btnDeleteProducerPanelPrincipal.addActionListener(this);
        view.btnExitPanelPrincipal.addActionListener(this);       
                
        //panelAdd        
        view.btnback1.addActionListener(this);
        view.btnAddProducerAddMenu.addActionListener(this);        
        view.btnAddGreenhouseAddMenu.addActionListener(this);        
        view.btnAddProcessAddMenu.addActionListener(this);        
        view.btnAddLaborAddMenu.addActionListener(this);        
                
        //panelAddProducer        
        view.btnback.addActionListener(this);
        view.btnSaveProducerPanelAddProducer.addActionListener(this);        
                
        //panelAddGreenhouse        
        view.btnback2.addActionListener(this);        
        view.btnSaveAddGreenHousePanel.addActionListener(this);        
                
        //panelAddProcess        
        view.btnback3.addActionListener(this);        
        view.btnSaveProcessPanel.addActionListener(this);
                
        //panelAddLabor        
        view.btnback6.addActionListener(this);
        view.btnAddProductControlAddLaborMenu.addActionListener(this);
        view.btnAddWPCAddLabor.addActionListener(this);        
                
        //panelAddControlProduct        
        view.btnback8.addActionListener(this);        
        view.btnSaveControlProductMenu.addActionListener(this);        
                
        //panelAddFertilizerControl        
        view.btnback5.addActionListener(this);       
        view.btnSaveFertilizerControl.addActionListener(this);        
        
        //panelAddPestControl        
        view.btnback4.addActionListener(this);        
        view.btnSavePestControl.addActionListener(this);
                
        //panelAddFungusControl        
        view.btnback9.addActionListener(this);        
        view.btnSaveFungusControl.addActionListener(this);        
                
        //panelAddWPC      
        view.btnback7.addActionListener(this);        
        view.btnSaveWPC.addActionListener(this);        
        
    }
    
    private void setAllInvisible() {                                        
        view.panelPrincipal.setVisible(false);
        view.panelAdd.setVisible(false);
        view.panelAddProducer.setVisible(false);
        view.panelAddGreenhouse.setVisible(false);
        view.panelAddProcess.setVisible(false);
        view.panelAddLabor.setVisible(false);
        view.panelAddControlProduct.setVisible(false);
        view.panelAddFertilizerControl.setVisible(false);
        view.panelAddPestControl.setVisible(false);
        view.panelAddFungusControl.setVisible(false);
        view.panelAddWPC.setVisible(false);
    }
    
    public void startController(){
        view.setTitle("Greenhouser");
        view.setLocationRelativeTo(null);
    }
    
    private void backToPrincipalMenu(){
        setAllInvisible();
        view.panelPrincipal.setVisible(true);
    }
    
    private void cleanFields(){
        view.textFieldIDPD.setText(null);
        view.textFieldNamePD.setText(null);
        view.textFieldLastNamePD.setText(null);
        view.textFieldCodeGH.setText(null);
        view.textFieldNameGH.setText(null);
        view.textFieldDepartmentGH.setText(null);
        view.textFieldTownshipGH.setText(null);
        view.textFieldIdPro.setText(null);
        view.textFieldNamePro.setText(null);
        view.textFieldHoursPro.setText(null);
        view.textFieldCostPro.setText(null);        
        view.textFieldTotalPro.setText(null);        
        view.textFieldPercentPro.setText(null);
        view.txtPeriodLack.setText(null);
        view.txtICA.setText(null);
        view.txtProductName.setText(null);
        view.txtFrequency.setText(null);
        view.txtId.setText(null);
        view.txtType.setText(null);
        view.txtRealizationDay.setText(null);
        view.txtDescription.setText(null);
        view.txtLastApplication.setText(null);
        view.txtICA1.setText(null);
        view.txtProductName1.setText(null);
        view.txtFrequency1.setText(null);
        view.txtId1.setText(null);
        view.txtType1.setText(null);
        view.txtRealizationDay1.setText(null);
        view.txtDescription1.setText(null);
        view.txtPruneFrequency.setText(null);
        view.txtLastPrune.setText(null);
        view.txtNameFungus.setText(null);
        view.txtFrequencyFungus.setText(null);
        view.txtICAFungus.setText(null);
        view.txtLackPeriodFungus.setText(null);
        view.txtICAProductControlFungus.setText(null);
        view.txtProductNameFungus.setText(null);
        view.txtAppFrequencyFungus.setText(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        //panelPrincipal
        if (e.getSource() == view.btnAddProducerPanelPrincipal) {
            setAllInvisible();
            view.panelAdd.setVisible(true);
        }
        
        if (e.getSource() == view.btnSearchProducerPanelPrincipal) {
            try{
                modelOperations.searchProducerListLabors(producersArray);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex + "Error, try again...");
            }
        }
        
        if (e.getSource() == view.btnDeleteProducerPanelPrincipal) {
            try{
                int id;
        
                id = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the producer you want to delete..."));
                modelOperations.deleteProducer(producersArray, id); 
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex + " Please check the input values...");
            }
        }
        
        if (e.getSource() == view.btnExitPanelPrincipal) {
            JOptionPane.showMessageDialog(null,"See you soon...");
            view.setVisible(false); //you can't see me!
            view.dispose(); //Destroy the JFrame object
        }
           
        //panelAdd 
        if (e.getSource() == view.btnback1) {
            backToPrincipalMenu();
        }
        
        if (e.getSource() == view.btnAddProducerAddMenu) {
            setAllInvisible();
            view.panelAddProducer.setVisible(true);
        }
        
        if (e.getSource() == view.btnAddGreenhouseAddMenu) {
            int producerID;
        
            try{
                producerID = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the producer you want to add a Greenhouse..."));
                theProducer = modelOperations.ProducerIsAlreadyOnList(producersArray, producerID);

                if (theProducer != null) {
                    setAllInvisible();
                    view.panelAddGreenhouse.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "The Producer you've enter is not on the list...");
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex + " Please check the input values...");
            }
        }
        
        if (e.getSource() == view.btnAddProcessAddMenu) {
            int producerID, greenHouseCode;

            try{
                producerID = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the producer you want to add a Greenhouse..."));
                theProducer = modelOperations.ProducerIsAlreadyOnList(producersArray, producerID);

                if (theProducer != null) {
                    greenHouseCode = Integer.parseInt(JOptionPane.showInputDialog("Enter the CODE of the Greenhouse you want to add a Process..."));
                    theGreenhouse = modelOperations.GreenhouseIsAlreadyOnList(theProducer.getgreenHousesArray(), greenHouseCode);
                    if (theGreenhouse != null) {
                        setAllInvisible();
                        view.panelAddProcess.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "The Greenhouse you've enter is not on the list...");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "The Producer you've enter is not on the list...");
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex + " Please check the input values...");
            }
        }
        
        if (e.getSource() == view.btnAddLaborAddMenu) {
            setAllInvisible();
            view.panelAddLabor.setVisible(true);
        }        
                
        //panelAddProducer 
        if (e.getSource() == view.btnback) {
            backToPrincipalMenu();
        } 
        
        if (e.getSource() == view.btnSaveProducerPanelAddProducer) {
            int id;
            String name, lastName;

            try{
                id = Integer.parseInt(view.textFieldIDPD.getText());
                name = view.textFieldNamePD.getText();
                lastName = view.textFieldLastNamePD.getText();

                if (modelOperations.ProducerIsAlreadyOnList(producersArray, id) != null) {
                    JOptionPane.showMessageDialog(null,"This Producer is already on the list!...");
                    cleanFields();
                }else{
                    try{
                        modelOperations.addProducer(producersArray, id, name, lastName);
                        cleanFields();
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(null,ex + " Please check the input values...");
                        backToPrincipalMenu();
                    }
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex + " Please check the input values...");
                cleanFields();
            }
        }       
                
        //panelAddGreenhouse 
        if (e.getSource() == view.btnback2) {
            backToPrincipalMenu();
        } 
        
        if (e.getSource() == view.btnSaveAddGreenHousePanel) {
            int code;
            String name, department, township;

            try{
                code = Integer.parseInt(view.textFieldCodeGH.getText());
                name = view.textFieldNameGH.getText();
                department = view.textFieldDepartmentGH.getText();
                township = view.textFieldTownshipGH.getText();

                if (modelOperations.GreenhouseIsAlreadyOnList(theProducer.getgreenHousesArray(), code) != null) {
                    JOptionPane.showMessageDialog(null,"This Greenhouse is already on the list!...");
                    cleanFields();
                }else{
                    try{
                        modelOperations.addGreenHouse(theProducer.getgreenHousesArray(), code, name, department, township);
                        cleanFields();
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(null,ex + " Please check the input values...");
                        backToPrincipalMenu();
                    }
                }

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex + " Please check the input values...");
                cleanFields();
            }
        }       
                
        //panelAddProcess 
        if (e.getSource() == view.btnback3) {
            backToPrincipalMenu();
        }
        
        if (e.getSource() == view.btnSaveProcessPanel) {
            int id, hours, cost, total;
            float percent;
            String name;

            try{
                id = Integer.parseInt(view.textFieldIdPro.getText());
                name = view.textFieldNamePro.getText();
                hours = Integer.parseInt(view.textFieldHoursPro.getText());
                cost = Integer.parseInt(view.textFieldCostPro.getText());
                total = Integer.parseInt(view.textFieldTotalPro.getText());
                percent = Float.parseFloat(view.textFieldPercentPro.getText());

                if (modelOperations.ProcessIsAlreadyOnList(theGreenhouse.getProcessesArray(), id) != null) {
                    JOptionPane.showMessageDialog(null,"This Process is already on the list!...");
                    cleanFields();
                }else{
                    try{
                        modelOperations.addProcess(theGreenhouse.getProcessesArray(), id, name, hours, cost, total, percent);
                        cleanFields();
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(null,ex + "Please check the input values111...");
                        backToPrincipalMenu();
                    }
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex + " Please check the input values222...");
                cleanFields();
            }
        }
                
        //panelAddLabor 
        if (e.getSource() == view.btnback6) {
            backToPrincipalMenu();
        }
        
        if (e.getSource() == view.btnAddProductControlAddLaborMenu) {
            view.chkFertilizerControl.setSelected(false);
            view.chkPestControl.setSelected(false);
            view.chkFungusControl.setSelected(false);
            setAllInvisible();
            view.panelAddControlProduct.setVisible(true);
        }
        
        if (e.getSource() == view.btnAddWPCAddLabor) {
            int producerID, greenHouseCode, processID;

            try{
                producerID = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the producer you want to add a Greenhouse..."));
                theProducer = modelOperations.ProducerIsAlreadyOnList(producersArray, producerID);

                if (theProducer != null) {
                    greenHouseCode = Integer.parseInt(JOptionPane.showInputDialog("Enter the CODE of the Greenhouse you want to add a Process..."));
                    theGreenhouse = modelOperations.GreenhouseIsAlreadyOnList(theProducer.getgreenHousesArray(), greenHouseCode);
                    if (theGreenhouse != null) {
                        processID = Integer.parseInt(JOptionPane.showInputDialog("Enter the CODE of the Process you want to add a W.P.C..."));
                        theProcess = modelOperations.ProcessIsAlreadyOnList(theGreenhouse.getProcessesArray(), processID);
                        if (theProcess != null) {
                            setAllInvisible();
                            view.panelAddWPC.setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(null, "The Process you've enter is not on the list...");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "The Greenhouse you've enter is not on the list...");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "The Producer you've enter is not on the list...");
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex + " Please check the input values...");
            }
        }
          
        //panelAddControlProduct 
        if (e.getSource() == view.btnback8) {
            backToPrincipalMenu();
        }
        
        if (e.getSource() == view.btnSaveControlProductMenu) {
            if (view.chkFertilizerControl.isSelected() || view.chkPestControl.isSelected() || view.chkFungusControl.isSelected()) {
                int producerID, greenHouseCode, processID, ProductControlICA;

                try{
                    producerID = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the producer you want to add a Greenhouse..."));
                    theProducer = modelOperations.ProducerIsAlreadyOnList(producersArray, producerID);

                    if (theProducer != null) {
                        greenHouseCode = Integer.parseInt(JOptionPane.showInputDialog("Enter the CODE of the Greenhouse you want to add a Process..."));
                        theGreenhouse = modelOperations.GreenhouseIsAlreadyOnList(theProducer.getgreenHousesArray(), greenHouseCode);
                        if (theGreenhouse != null) {
                            processID = Integer.parseInt(JOptionPane.showInputDialog("Enter the CODE of the Process you want to add a W.P.C..."));
                            theProcess = modelOperations.ProcessIsAlreadyOnList(theGreenhouse.getProcessesArray(), processID);
                            if (theProcess != null) {
                                theLabor = theProcess.getLabor();
                                ProductControlICA = Integer.parseInt(JOptionPane.showInputDialog("Enter the ICA of the Product Control you want to add a Fertlizar Control..."));
                                theProductControl = modelOperations.ProductControlIsAlreadyOnList(theLabor.getProductControlArray(), ProductControlICA);
                                if (view.chkFertilizerControl.isSelected()) {
                                        setAllInvisible();
                                        view.panelAddFertilizerControl.setVisible(true);
                                }else if (view.chkPestControl.isSelected()) {
                                        setAllInvisible();
                                        view.panelAddPestControl.setVisible(true);
                                }else if (view.chkFungusControl.isSelected()) {
                                        setAllInvisible();
                                        view.panelAddFungusControl.setVisible(true);
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "The Process you've enter is not on the list...");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "The Greenhouse you've enter is not on the list...");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "The Producer you've enter is not on the list...");
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex + " Please check the input values...");
                }
            }else{
                 JOptionPane.showMessageDialog(null, "You have to select at least one option to add a Product Control...");
            }
        }       
                
        //panelAddFertilizerControl  
        if (e.getSource() == view.btnback5) {
            backToPrincipalMenu();
        }
        
        if (e.getSource() == view.btnSaveFertilizerControl) {
            int LastApplication, ICA, applicationFrequencyDays;
            int []date = {1,2,3};
            String productName;

            try{
                LastApplication = Integer.parseInt(view.txtLastApplication.getText());
                ICA = Integer.parseInt(view.txtICA1.getText());
                applicationFrequencyDays = Integer.parseInt(view.txtFrequency1.getText());
                //date[0] = dateOfRealization;
                productName = view.txtProductName1.getText();

                if (theProductControl == null) {
                    theProductControl = new ProductControl(ICA, productName, applicationFrequencyDays);
                    modelOperations.addFertilizerControl(theProductControl.getFertilizerControlArray(), date, ICA, productName, applicationFrequencyDays);
                    theLabor.getProductControlArray().add(theProductControl);
                }else{
                    modelOperations.addFertilizerControl(theProductControl.getFertilizerControlArray(), date, ICA, productName, applicationFrequencyDays);
                }
                cleanFields();
                view.chkFertilizerControl.setSelected(false);
                if (view.chkPestControl.isSelected()) {
                    setAllInvisible();
                    view.panelAddPestControl.setVisible(true);
                }else if (view.chkFungusControl.isSelected()) {
                    setAllInvisible();
                    view.panelAddFungusControl.setVisible(true);
                }

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex + " Please check the input values111...");
                backToPrincipalMenu();
            }
        }
        
        //panelAddPestControl 
        if (e.getSource() == view.btnback4) {
            backToPrincipalMenu();
        }
        
        if (e.getSource() == view.btnSavePestControl) {
            int periodOfLackDays, ICA, applicationFrequencyDays, dateOfRealization;
            int []date = {1,2,3};
            String productName;

            try{
                periodOfLackDays = Integer.parseInt(view.txtPeriodLack.getText());
                ICA = Integer.parseInt(view.txtICA.getText());
                applicationFrequencyDays = Integer.parseInt(view.txtFrequency.getText());
                dateOfRealization = Integer.parseInt(view.txtRealizationDay.getText());
                //date[0] = dateOfRealization;
                productName = view.txtProductName.getText();

                if (theProductControl == null) {
                    theProductControl = new ProductControl(ICA, productName, applicationFrequencyDays);
                    modelOperations.addPestControl(theProductControl.getPestControlArray(), periodOfLackDays, ICA, productName, applicationFrequencyDays);
                    theLabor.getProductControlArray().add(theProductControl);
                }else{
                    modelOperations.addPestControl(theProductControl.getPestControlArray(), periodOfLackDays, ICA, productName, applicationFrequencyDays);
                }
                cleanFields();
                view.chkPestControl.setSelected(false);
                if (view.chkFertilizerControl.isSelected()) {
                    setAllInvisible();
                    view.panelAddFertilizerControl.setVisible(true);
                }else if (view.chkFungusControl.isSelected()) {
                    setAllInvisible();
                    view.panelAddFungusControl.setVisible(true);
                }

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex + " Please check the input values111...");
                backToPrincipalMenu();
            }
        }
                
        //panelAddFungusControl 
        if (e.getSource() == view.btnback9) {
            backToPrincipalMenu();
        }
        
        if (e.getSource() == view.btnSaveFungusControl) {
            int frequency, FugusICA, LackPeriodDays, ICA , applicationFrequencyDays;
            String name, productName;

            try{
                name = view.txtNameFungus.getText();
                frequency = Integer.parseInt(view.txtFrequencyFungus.getText());
                FugusICA = Integer.parseInt(view.txtICAFungus.getText());
                LackPeriodDays = Integer.parseInt(view.txtLackPeriodFungus.getText());
                ICA = Integer.parseInt(view.txtICAProductControlFungus.getText());
                productName = view.txtProductNameFungus.getText();
                applicationFrequencyDays = Integer.parseInt(view.txtAppFrequencyFungus.getText());

                if (theProductControl == null) {
                    theProductControl = new ProductControl(ICA, productName, applicationFrequencyDays);
                    modelOperations.addFungusControl(theProductControl.getFungusControlArray(), name, frequency, FugusICA, LackPeriodDays, ICA, productName, applicationFrequencyDays);
                    theLabor.getProductControlArray().add(theProductControl);
                }else{
                    modelOperations.addFungusControl(theProductControl.getFungusControlArray(), name, frequency, FugusICA, LackPeriodDays, ICA, productName, applicationFrequencyDays);
                }
                cleanFields();
                view.chkFungusControl.setSelected(false);
                if (view.chkFertilizerControl.isSelected()) {
                    setAllInvisible();
                    view.panelAddFertilizerControl.setVisible(true);
                }else if (view.chkPestControl.isSelected()) {
                    setAllInvisible();
                    view.panelAddPestControl.setVisible(true);
                }

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex + " Please check the input values111...");
                backToPrincipalMenu();
            }
        }       
                
        //panelAddWPC   
        if (e.getSource() == view.btnback7) {
            backToPrincipalMenu();
        }
        
        if (e.getSource() == view.btnSaveWPC) {
            int pruneFrequency,lastPrune;

            try{
                pruneFrequency = Integer.parseInt(view.txtPruneFrequency.getText());
                lastPrune = Integer.parseInt(view.txtLastPrune.getText());


                try{
                    modelOperations.addWPC(theProcess.getLabor(), pruneFrequency, lastPrune);

                    cleanFields();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex + " Please check the input values...");
                    backToPrincipalMenu();
                }

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex + " Please check the input values...");
                cleanFields();
            }
        }
    }

    public Producer getTheProducer() {
        return theProducer;
    }

    public void setTheProducer(Producer theProducer) {
        this.theProducer = theProducer;
    }

    public GreenHouse getTheGreenhouse() {
        return theGreenhouse;
    }

    public void setTheGreenhouse(GreenHouse theGreenhouse) {
        this.theGreenhouse = theGreenhouse;
    }

    public Process getTheProcess() {
        return theProcess;
    }

    public void setTheProcess(Process theProcess) {
        this.theProcess = theProcess;
    }

    public Labor getTheLabor() {
        return theLabor;
    }

    public void setTheLabor(Labor theLabor) {
        this.theLabor = theLabor;
    }

    public ProductControl getTheProductControl() {
        return theProductControl;
    }

    public void setTheProductControl(ProductControl theProductControl) {
        this.theProductControl = theProductControl;
    }

    public ProducerRegistry getView() {
        return view;
    }

    public void setView(ProducerRegistry view) {
        this.view = view;
    }

    public Operations getModelOperations() {
        return modelOperations;
    }

    public void setModelOperations(Operations modelOperations) {
        this.modelOperations = modelOperations;
    }

    public static ArrayList<Producer> getProducersArray() {
        return producersArray;
    }
    
}
