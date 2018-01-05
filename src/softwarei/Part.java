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
public abstract class Part{
    
    private int partID, InStock, min, max;
    
    private String name;
    
    private String nameOrID;
    
    private static double price;
     
    public static int partCounter = 1;
    
    
    public Part(int partID, String name, int InStock, double price, int max, int min, String nameOrID){
        this.partID = partCounter;
        partCounter++;
        this.name = name;
        this.price = price;
        this.InStock = InStock;
        this.max = max;
        this.min = min;
        this.nameOrID = nameOrID;
        
    }

    public String getNameOrID() {
        return nameOrID;
    }

    public void setNameOrID(String nameOrID) {
        this.nameOrID = nameOrID;
    }
  

    //Mutators
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setPrice(double price){
        
        this.price = price;
        
    }
      
    public void setInStock(int InStock){
        
        this.InStock = InStock;
        
    }
    
    public void setMin(int min){
        
        this.min = min;
        
    }
      
    public void setMax(int max){
        
        this.max = max;
        
    }
      
    public void setPartID(int partID){
        
        this.partID = partID;
        
    }
    
    
    //Accessors
    public String getName(){
        return name;
    }
   
    public double getPrice(){
        return  price;
    }

    public int getInStock(){
        return InStock;
    }

    public int getMin(){
        return min;
    }

    public int getMax(){
        return max;
    }
  
    public int getPartID(){
        return partID;
    }
    
}
