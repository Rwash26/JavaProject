/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarei;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author reggie.washington
 */
public class Product {
    
    public static int productCounter = 1;
    
    //Instance variables

    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();
            
    private int productID;
    
    private String name;
    
    private double price;
    
    private int inStock;
    
    private int min;
    
    private int max;
    
    private boolean addedAssociatedParts = false;
    
    public Product(int productID, String name, int inStock, double price, int max, int min, ObservableList <Part> myPart){
        associatedParts = myPart;
        this.productID = productCounter;
        productCounter++;
        this.name = name;
        this.price = price;
        this.inStock = inStock;
        this.min = min;
        this.max = max;
    }
    
    
    //Mutators
    public void setName(String name){
        this.name = name;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public void setInStock(int inStock){
        this.inStock = inStock;
    }
    
    public void setMin(int min){
        this.min = min;
    }
    
    public void setMax(int max){
        this.max = max;
    }
    
    public void addAssociatedPart(Part p){
        associatedParts.add(p);
    }
    
    public boolean removeAssociatedPart(int rAP){
        associatedParts.remove(rAP);
        return true;
    }
    
    public void setProductID(int productID){
        this.productID = productID;
    }            
    
    //Accessors
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public int getInStock(){
        return inStock;
    }
    
    public int getMin(){
        return min;
    }
    
    public int getMax(){
        return max;
    }
    
    public int getProductID(){
        return productID;
    }
    
    public int lookupAssociatedPart(int partID){
        return partID;
    }
    
    public ObservableList<Part> getAssociatedParts(){
        if(!addedAssociatedParts){
        
        addedAssociatedParts = true;}
        return associatedParts;
    }    
    
    public void setAssociatedPrice(double myPrice){
        this.price = myPrice;
    }
    
    public double getAssociatedPrice(){
       double sum = 0;
        for(int i = 0; i < associatedParts.size(); i++){
           sum = sum + associatedParts.get(i).getPrice();
        }
        return sum;
    }
    
   
}
