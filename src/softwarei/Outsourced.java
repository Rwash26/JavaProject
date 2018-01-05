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
public class Outsourced extends Part {
    public Outsourced (int partID, String name, int InStock, double price, int min, int max, String companyName){
        super(partID, name, InStock, price, min, max, companyName);
    }
    
    private String companyName;
    
    public void setCompanyName(String sCN){
        
        companyName = sCN;
    }
    
    public String getCompanyName(){
        return companyName;
    }
    
}
