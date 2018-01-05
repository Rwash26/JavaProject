/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarei;

import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Callback;

/**
 *
 * @author reggie.washington
 */
public class Inventory extends SoftwareI {
        
    private static ObservableList<Product> products = FXCollections.observableArrayList();
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Part> filteredParts = FXCollections.observableArrayList();
    private static ObservableList<Part> product1Parts = FXCollections.observableArrayList();
    private static ObservableList<Part> product2Parts = FXCollections.observableArrayList();
    private static ObservableList<Part> product3Parts = FXCollections.observableArrayList();
    
    private static boolean addedParts = false;
    private static boolean addedProducts = false;
    
    public static ObservableList<Part> getParts(){
        if(!addedParts){
        allParts.add(new Inhouse(0,"Part 1", 6, 5, 20, 5, "Machine 1"));
        allParts.add(new Inhouse(0, "Part 2", 7, 10, 100, 10, "Machine 2"));
        allParts.add(new Inhouse(0, "Pie 1", 7, 10, 100, 20, "Machine 3"));
        addedParts = true;}
        return allParts;
    }
    
    
    
    public static ObservableList<Product> getProducts(){
        if(!addedProducts){
     //   product1Parts.add(new Inhouse(0, "Chicken 1", 7, 10, 500, 10));
     //   product2Parts.add(new Inhouse(0, "Steak 1", 4, 9, 100, 1));
     //   product3Parts.add(new Inhouse(0, "Fish 1", 8, 13, 100, 1));
        products.add(new Product(0, "Product 1", 6, 5, 100, 5, product1Parts));
        products.add(new Product(0, "Product 2", 7, 10, 100, 10, product2Parts));
        products.add(new Product(0, "Fish 2", 3, 6, 200, 9, product3Parts));
        
        addedProducts = true;}
        return products;
    }
    
    public static ObservableList<Part> getFilter(){
     filteredParts.addAll(allParts); 
     return filteredParts;
    }
    
    public Inventory(){
        
    }
    
    public static ObservableList<Part> getPartData(){
        return allParts;
    }
    
  
    //Mutators
    public void addProduct(Product name){
        products.add(name);
        
        
    };
    
    public boolean removeProduct(int rp){
        
        products.remove(rp);
        return true;
        
    };
    
    public int lookupProduct(int productID){
        
        return productID;
        
    };
    
    public void updateProduct(int productID){
        
        
    };
    
    public void addPart(Part name){
        
       allParts.add(name);
        
    };
    
    public boolean deletePart(int partID){
        
       allParts.remove(partID);
       return true;
    };
    
//Did not use method    
    public int lookupPart(int partID){
        
        return partID;
    };

//Did not use method    
    public void updatePart(String part,boolean empty){      
  //          super.updatePart(part, empty);
   //         setText(part);
        
    };
    

}
