/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarei;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author reggie.washington
 */
public class Inhouse extends Part {
    public Inhouse (int partID, String name, int InStock, double price, int min, int max, String machineID){
        super(partID, name, InStock, price, min, max, machineID);
    }
    
    private int machineID;
    
    public void setMachineID(int sMID){
        
        machineID = sMID;
    }
    
    public int getMachineID(){
        return machineID;
    }
    
}
