/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwarei;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static softwarei.Part.partCounter;
import static softwarei.Product.productCounter;

/**
 *
 * @author reggie.washington
 */
public class SoftwareI extends Application {
    
    private ObservableList<Part> productParts = FXCollections.observableArrayList();
    
 //   double productPartPrice = Part.getPrice();
    
    public TableView<Part> table1 = new TableView<>();
    public Button search1 = new Button("Search");
    public TextField search1Field = new TextField();
    
    public Text partTitle = new Text("");
    
    public Button search2 = new Button("Search");
    public TextField search2Field = new TextField();
    public TableView<Product> table2 = new TableView<>();
    
    public TextField IDField = new TextField("Auto Gen - Disabled");
   
    public TextField partNameField = new TextField();
    public TextField partInvField = new TextField();
    public TextField partPCField = new TextField();
    public TextField partMaxField = new TextField();
    public TextField partMinField = new TextField();
    public TextField partCNField = new TextField();
    
    Part selectedItem;
    Product selectedItem2;
    
    public Text addProductTitle = new Text("");
    public Button addProductSearch = new Button("Search");
    public TextField addProductSearchField = new TextField();
    public TableView addProductTable1 = new TableView();    
    
    public TableView addProductTable2 = new TableView();
    
    public TextField productIDField1 = new TextField("Auto Gen - Disabled");
    public TextField productNameField1 = new TextField();
    public TextField productInvField1 = new TextField();
    public TextField productPCField1 = new TextField();
    public TextField productMaxField1 = new TextField();
    public TextField productMinField1 = new TextField();
   
   
    @Override
    public void start(Stage primaryStage) throws Exception {
       
        //Layout1        
        GridPane grid = new GridPane();
        GridPane grid1 = new GridPane();
        GridPane grid2 = new GridPane();
        grid.setPadding(new Insets(10,20,10,20));
        grid1.setPadding(new Insets(10,20,10,20));
        grid2.setPadding(new Insets(10,20,10,20));
        grid.setVgap(20);
        grid.setHgap(10);
        grid1.setHgap(20);
        grid1.setVgap(10);
        grid2.setHgap(20);
        grid2.setVgap(10);
        grid2.setGridLinesVisible(false);
        grid1.setGridLinesVisible(false);
        Scene scene1 = new Scene(grid, 800, 400);
        
        //Add Part Layout2
        GridPane partGrid = new GridPane();
        GridPane partGrid1 = new GridPane();
        partGrid.setPadding(new Insets(10,20,10,20));
        partGrid1.setPadding(new Insets(10,20,10,20));
        partGrid1.setHgap(20.0);
        partGrid1.setVgap(10.0);
        Scene scene2 = new Scene(partGrid, 400, 300);
   
        //Add Product Layout 4
        GridPane productAddGrid = new GridPane();
        
        GridPane productAddGrid1 = new GridPane();
        productAddGrid.setPadding(new Insets(10,20,10,20));
        productAddGrid1.setPadding(new Insets(10,20,10,20));
        productAddGrid1.setHgap(20.0);
        productAddGrid1.setVgap(10.0);
        productAddGrid.setVgap(10.0);
        Scene scene4 = new Scene(productAddGrid, 800, 500);
        
       //Modify Product Layout 5
        
       //Top Grid
        Text projectTitle = new Text("Inventory Management System");
        projectTitle.setFont(Font.font("Tahoma",FontWeight.NORMAL, 10));
        GridPane.setConstraints(projectTitle, 0, 0);
        
       //Left Panel        
        Text partsTitle = new Text("Parts       ");
        GridPane.setConstraints(partsTitle, 0, 1);
        GridPane.setConstraints(search1, 1, 1);
        search1.setOnAction(e ->{ 
            searchParts();
         });
        GridPane.setConstraints(search1Field, 2, 1);
  
            
        //Left table
        GridPane.setRowIndex(table1, 3);
        GridPane.setColumnSpan(table1, 3);
        
        TableColumn<Part, Integer> partID = new TableColumn<>("Part ID");
        partID.setCellValueFactory(
                new PropertyValueFactory<Part, Integer>("partID"));
        
        TableColumn<Part, String> partName = new TableColumn<>("Part Name");
        partName.setCellValueFactory(
                new PropertyValueFactory<Part, String>("name"));
        
        TableColumn<Part, Integer> inventoryLevel = new TableColumn<>("Inventory Level");
        inventoryLevel.setCellValueFactory(
            new PropertyValueFactory<Part, Integer>("InStock"));
        
        TableColumn<Part, Double> ppu = new TableColumn<>("Price/Cost per Unit");
        ppu.setCellValueFactory(
            new PropertyValueFactory<Part, Double>("price"));  
        table1.getColumns().addAll(partID, partName, inventoryLevel, ppu);
        table1.setItems(Inventory.getParts());
        
        Button add1 = new Button("Add");
        GridPane.setConstraints(add1, 0, 5);
        GridPane.setHalignment(add1, HPos.RIGHT);
        add1.setOnAction(e -> {
            primaryStage.setScene(scene2);
            partTitle.setText("Add Part    ");
                });        
        Button modify1 = new Button("Modify");
        
        modify1.setOnAction(e -> {
            primaryStage.setScene(scene2);
            selectedItem = table1.getSelectionModel().getSelectedItem();
            setModifyItems(selectedItem);
            partTitle.setText("Modify Part    ");
           
        });
        GridPane.setConstraints(modify1, 1, 5);
        GridPane.setHalignment(modify1, HPos.RIGHT);
       
        Button delete1 = new Button("Delete");
        GridPane.setConstraints(delete1, 2, 5);
        
        delete1.setOnAction(e -> {
            Alert deleteAlert = new Alert(AlertType.CONFIRMATION, "Are you sure ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            deleteAlert.showAndWait();

            if (deleteAlert.getResult() == ButtonType.YES) {
                
                Part selectedItem = table1.getSelectionModel().getSelectedItem();
                table1.getItems().remove(selectedItem);
            }
            });
            

       //Right Panel  
       Text productsTitle = new Text("Products      ");
       GridPane.setConstraints(productsTitle, 0, 1);
       GridPane.setConstraints(search2, 1, 1);
       search2.setOnAction(e ->{
           searchProducts();
       });
       GridPane.setConstraints(search2Field, 2, 1);
       GridPane.setRowIndex(table2, 3);
       GridPane.setColumnSpan(table2, 3);
 
       //Right Table
        TableColumn<Product, Integer> productID = new TableColumn<>("Product ID");
        productID.setCellValueFactory(
                new PropertyValueFactory<Product, Integer>("productID"));
        TableColumn<Product, String> productName = new TableColumn<>("Product Name");
        productName.setCellValueFactory(
                new PropertyValueFactory<Product, String>("name"));
        TableColumn<Product, Integer> inventoryLevel2 = new TableColumn<>("Inventory Level");
        inventoryLevel2.setCellValueFactory(
                new PropertyValueFactory<Product, Integer>("inStock"));
        TableColumn<Product, Double> ppu2 = new TableColumn<>("Price per Unit");
        ppu2.setCellValueFactory(
                new PropertyValueFactory<Product, Double>("price"));
                
        table2.getColumns().addAll(productID, productName, inventoryLevel2, ppu2);
        table2.setItems(Inventory.getProducts());        
      
        Button add2 = new Button("Add");
        GridPane.setConstraints(add2, 0, 5);
        GridPane.setHalignment(add2, HPos.RIGHT);
        add2.setOnAction(e -> {
            primaryStage.setScene(scene4);
            addProductTitle.setText("Add Product       ");
                }); 
        
        Button modify2 = new Button("Modify");
        modify2.setOnAction(e -> {
            primaryStage.setScene(scene4);
            selectedItem2 = table2.getSelectionModel().getSelectedItem();
            setModifyProduct(selectedItem2);
            addProductTitle.setText("Modify Product       ");
        });
        
        
        GridPane.setConstraints(modify2, 1, 5);
        GridPane.setHalignment(modify2, HPos.RIGHT);
   
        Button delete2 = new Button("Delete");
        GridPane.setConstraints(delete2, 2, 5);
        delete2.setOnAction(e -> {
            Alert deleteAlert = new Alert(AlertType.CONFIRMATION, "Are you sure ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            deleteAlert.showAndWait();
            if (deleteAlert.getResult() == ButtonType.YES){
            Product selectedItem = table2.getSelectionModel().getSelectedItem();
            table2.getItems().remove(selectedItem);
            }
        });
       
       //Bottom Exit        
        Button exit = new Button("Exit");
        exit.setOnAction(e -> Platform.exit());
        HBox hbExit = new HBox();
        hbExit.setAlignment(Pos.BOTTOM_RIGHT);
        hbExit.getChildren().add(exit);
        
        HBox hbox1 = new HBox();
        hbox1.setSpacing(20.0);
        VBox vbox = new VBox();
        vbox.getChildren().addAll(projectTitle, hbox1, hbExit);
        hbox1.getChildren().addAll(grid1, grid2);
        grid.getChildren().addAll(vbox);
        grid1.getChildren().addAll(partsTitle, search1, search1Field, table1, add1, modify1, delete1);
        grid2.getChildren().addAll(productsTitle, search2, search2Field, table2, add2, modify2, delete2);

        //Add Part screen  
        //Top Hbox
        ToggleGroup radio1group = new ToggleGroup();
        partTitle.setFont(Font.font("Tahoma",FontWeight.NORMAL, 10));
        GridPane.setConstraints(partTitle, 0, 0);
        RadioButton inHouse = new RadioButton();
        inHouse.setToggleGroup(radio1group);
        inHouse.setText("In-House");
        GridPane.setConstraints(inHouse, 0, 1);
        RadioButton outsource = new RadioButton();
        outsource.setToggleGroup(radio1group);
        outsource.setText("Outsourced");
        GridPane.setConstraints(outsource, 0, 2);
        
        //Middle Box
        Text partID1 = new Text("ID");
        
        GridPane.setConstraints(partID1, 0, 0);
        GridPane.setConstraints(IDField, 1, 0);
        IDField.setDisable(true);
        Text partName1 = new Text("Name");
        
        GridPane.setConstraints(partName1, 0, 1);
        GridPane.setConstraints(partNameField, 1, 1);
        Text partInv1 = new Text("Inv");
        
        GridPane.setConstraints(partInv1, 0, 2);
        GridPane.setConstraints(partInvField, 1, 2);
        Text partPC1 = new Text("Price/Cost");
        
        GridPane.setConstraints(partPC1, 0, 3);
        GridPane.setConstraints(partPCField, 1, 3);
        Text partMax1 = new Text("Max");
        
        GridPane.setConstraints(partMax1, 0, 4);
        GridPane.setConstraints(partMaxField, 1, 4);
        Text partMin1 = new Text("Min");
        
        GridPane.setConstraints(partMin1, 2, 4);
        GridPane.setConstraints(partMinField, 3, 4);
        Text partCN1 = new Text("Company Name");
        
        //Radio Toggle
        radio1group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            @Override   
            public void changed(ObservableValue<? extends Toggle> ov,
                    Toggle old_toggle, Toggle new_toggle) {
                //Has selection
                if (radio1group.getSelectedToggle() == outsource){
                    partCN1.setText("Company Name");
                    
                }else if(radio1group.getSelectedToggle() == inHouse){
                    partCN1.setText("Machine ID");
                
                }else if(radio1group.getSelectedToggle() == null){
                      Alert ErrorAlert1 = new Alert(AlertType.CONFIRMATION, "Selct inhouse or outsource", ButtonType.OK);
                       ErrorAlert1.showAndWait();
                        if (ErrorAlert1.getResult() == ButtonType.OK){
                            ErrorAlert1.close();
                        }          
                }
            }
        });
        
       
        GridPane.setConstraints(partCN1, 0, 5);
        GridPane.setConstraints(partCNField, 1, 5);
        
        //Bottom Hbox
        Button save1 = new Button("Save");
        save1.setOnAction(e -> {
            if(radio1group.getSelectedToggle() == inHouse){
                int intID = Part.partCounter;
                String valueName = partNameField.getText();
                String valueInv = partInvField.getText();
                int intInv = Integer.parseInt(valueInv);
                String valuePC = partPCField.getText();
                double doublePC = Double.parseDouble(valuePC);
                String valueMax = partMaxField.getText();
                int intMax = Integer.parseInt(valueMax);
                String valueMin = partMinField.getText();
                int intMin = Integer.parseInt(valueMin);
                String valueCN = partCNField.getText();
                
                if(radio1group.getSelectedToggle() == null){
                      Alert ErrorAlert1 = new Alert(AlertType.CONFIRMATION, "Selct inhouse or outsource", ButtonType.OK);
                       ErrorAlert1.showAndWait();
                        if (ErrorAlert1.getResult() == ButtonType.OK){
                            ErrorAlert1.close();
                        }          
                }else if(intInv > intMax){
                    Alert ErrorAlert1 = new Alert(AlertType.CONFIRMATION, "Inventory value greater than maximum value.", ButtonType.OK);
                        ErrorAlert1.showAndWait();
                        if (ErrorAlert1.getResult() == ButtonType.OK){
                            ErrorAlert1.close();
                        }                    
                }else if(intInv < intMin){
                     Alert ErrorAlert2 = new Alert(AlertType.CONFIRMATION, "Inventory value less than minimum value.", ButtonType.OK);
                        ErrorAlert2.showAndWait();
                        if (ErrorAlert2.getResult() == ButtonType.OK){
                            ErrorAlert2.close();
                        }                   
                }else if(intMax < intMin){
                     Alert ErrorAlert3 = new Alert(AlertType.CONFIRMATION, "Maximum less than minimum", ButtonType.OK);
                        ErrorAlert3.showAndWait();
                        if (ErrorAlert3.getResult() == ButtonType.OK){
                            ErrorAlert3.close();
                        } 
                }else{
                Inhouse tempPart = new Inhouse(intID, valueName, intInv, doublePC, intMax, intMin, valueCN);
                tempPart.setPartID(intID);
                Inventory.getParts().add(tempPart);
                if(selectedItem != null){
                    Inventory.getParts().remove(selectedItem);
                } 
                
                primaryStage.setScene(scene1);}
            }else {
                int intID = Part.partCounter;
                String valueName = partNameField.getText();
                String valueInv = partInvField.getText();
                int intInv = Integer.parseInt(valueInv);
                String valuePC = partPCField.getText();
                double doublePC = Double.parseDouble(valuePC);
                String valueMax = partMaxField.getText();
                int intMax = Integer.parseInt(valueMax);
                String valueMin = partMinField.getText();
                int intMin = Integer.parseInt(valueMin);
                String valueCN = partCNField.getText();
               
                if(radio1group.getSelectedToggle() == null){
                      Alert ErrorAlert1 = new Alert(AlertType.CONFIRMATION, "Selct inhouse or outsource", ButtonType.OK);
                       ErrorAlert1.showAndWait();
                        if (ErrorAlert1.getResult() == ButtonType.OK){
                            ErrorAlert1.close();
                        }          
                }else if(intInv > intMax){
                    Alert ErrorAlert1 = new Alert(AlertType.CONFIRMATION, "Inventory value greater than maximum value.", ButtonType.OK);
                        ErrorAlert1.showAndWait();
                        if (ErrorAlert1.getResult() == ButtonType.OK){
                            ErrorAlert1.close();
                        }                    
                }else if(intInv < intMin){
                     Alert ErrorAlert2 = new Alert(AlertType.CONFIRMATION, "Inventory value less than minimum value.", ButtonType.OK);
                        ErrorAlert2.showAndWait();
                        if (ErrorAlert2.getResult() == ButtonType.OK){
                            ErrorAlert2.close();
                        }                   
                }else if(intMax < intMin){
                     Alert ErrorAlert3 = new Alert(AlertType.CONFIRMATION, "Maximum less than minimum", ButtonType.OK);
                        ErrorAlert3.showAndWait();
                        if (ErrorAlert3.getResult() == ButtonType.OK){
                            ErrorAlert3.close();
                        } 
                }else{
                    Outsourced tempPart = new Outsourced(intID, valueName, intInv, doublePC, intMax, intMin, valueCN);
                    tempPart.setPartID(intID);
                    Inventory.getParts().add(tempPart);
                
                    if(selectedItem != null){
                    Inventory.getParts().remove(selectedItem);
                    }
                    
                    primaryStage.setScene(scene1);
                   
                }
      
            }
        });
        Button cancel1 = new Button("Cancel");
        cancel1.setOnAction(e -> {
                Alert cancelAlert = new Alert(AlertType.CONFIRMATION, "Are you sure ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
                cancelAlert.showAndWait();
                if (cancelAlert.getResult() == ButtonType.YES){
                    clearFields();
                    primaryStage.setScene(scene1);
                }
        });
        
        HBox partBox1 = new HBox();
        HBox partBox3 = new HBox();
        partBox1.setSpacing(20.0);
        partBox3.setSpacing(20.0);
        partBox1.getChildren().addAll(partTitle, inHouse, outsource);
        partBox3.getChildren().addAll(save1, cancel1);
        VBox vbox1 = new VBox();
        
        vbox1.getChildren().addAll(partBox1,partGrid1,partBox3);
        partGrid.getChildren().addAll(vbox1);
        partGrid1.getChildren().addAll(partID1, IDField, partName1, partNameField, partInv1, partInvField, partPC1, partPCField, partMax1, partMaxField, partMin1, partMinField, partCN1, partCNField);
 
    //Add Product Screen
        
        GridPane.setConstraints(addProductTitle, 0, 0);        
        HBox productSearch = new HBox(20, addProductSearch, addProductSearchField);
        GridPane.setConstraints(productSearch, 1, 0);
        
        Text productID1 = new Text("ID");

        GridPane.setConstraints(productID1, 0, 0);
        GridPane.setConstraints(productIDField1, 1, 0);
        productIDField1.setDisable(true);
        Text productName1 = new Text("Name");

        GridPane.setConstraints(productName1, 0, 1);
        GridPane.setConstraints(productNameField1, 1, 1);
        Text productInv1 = new Text("Inv");
        
        GridPane.setConstraints(productInv1, 0, 2);
        GridPane.setConstraints(productInvField1, 1, 2);
        Text productPC1 = new Text("Price/Cost");
        
        GridPane.setConstraints(productPC1, 0, 3);
        GridPane.setConstraints(productPCField1, 1, 3);
        Text productMax1 = new Text("Max");
        
        GridPane.setConstraints(productMax1, 0, 4);
        GridPane.setConstraints(productMaxField1, 1, 4);
        Text productMin1 = new Text("Min");
        
        GridPane.setConstraints(productMin1, 2, 4);
        GridPane.setConstraints(productMinField1, 3, 4);
        
          
        TableColumn<Part, Integer> addProductID = new TableColumn<>("Part ID");
        addProductID.setCellValueFactory(
                new PropertyValueFactory<Part, Integer>("partID"));
        
        TableColumn<Part, String> addProductName = new TableColumn<>("Part Name");
        addProductName.setCellValueFactory(
                new PropertyValueFactory<Part, String>("name"));
        
        TableColumn<Part, Integer> addInventoryLevel1 = new TableColumn<>("Inventory Level");
        addInventoryLevel1.setCellValueFactory(
            new PropertyValueFactory<Part, Integer>("InStock"));
        
        TableColumn<Part, Double> ppuProduct = new TableColumn<>("Price/Cost per Unit");
         ppuProduct.setCellValueFactory(
            new PropertyValueFactory<Part, Double>("price"));  
       
        addProductTable1.getColumns().addAll(addProductID, addProductName, addInventoryLevel1, ppuProduct);
        addProductTable1.setItems(Inventory.getParts()); 
        GridPane.setConstraints(addProductTable1, 1, 1);
        
        //Search button in add Product
        addProductSearch.setOnAction(e -> {
            searchParts2();
        });
        
        Button addProductButton = new Button("Add");
        //Add Part to Product
        addProductButton.setOnAction(e -> {
            Part selectedPart = (Part) addProductTable1.getSelectionModel().getSelectedItem();
            productParts.add(selectedPart);
            addProductTable2.setItems(productParts);
           });
        
        TableColumn<Part, Integer> addProductID2 = new TableColumn<>("Part ID");
        addProductID2.setCellValueFactory(
                new PropertyValueFactory<Part, Integer>("partID"));
        
        TableColumn<Part, String> addProductName2 = new TableColumn<>("Part Name");
        addProductName2.setCellValueFactory(
                new PropertyValueFactory<Part, String>("name"));
        
        TableColumn<Part, Integer> addInventoryLevel2 = new TableColumn<>("Inventory Level");
        addInventoryLevel2.setCellValueFactory(
            new PropertyValueFactory<Part, Integer>("InStock"));
        
        TableColumn<Part, Double> ppuProduct2 = new TableColumn<>("Price/Cost per Unit");
         ppuProduct2.setCellValueFactory(
            new PropertyValueFactory<Part, Double>("price"));
        
        addProductTable2.getColumns().addAll(addProductID2, addProductName2, addInventoryLevel2, ppuProduct2);
        addProductTable2.setItems(productParts);
        GridPane.setConstraints(addProductTable2, 1, 3);
        
        GridPane.setConstraints(addProductButton, 1, 2);
        GridPane.setHalignment(addProductButton, HPos.RIGHT);
        Button addProductDeleteButton = new Button("Delete");
       
        addProductDeleteButton.setOnAction(e -> {
            Alert deleteAlert = new Alert(AlertType.CONFIRMATION, "Are you sure ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            deleteAlert.showAndWait();
            if (deleteAlert.getResult() == ButtonType.YES){
             Part selectedItem = (Part) addProductTable2.getSelectionModel().getSelectedItem();
                if(productParts.isEmpty()){
                System.out.println("Product must have at least one Part");
            }else{addProductTable2.getItems().remove(selectedItem);
            }
            }
            
        });
    
        
        //Add new Product
        Button addProductSaveButton = new Button("Save");
        addProductSaveButton.setOnAction(e -> {
                int intID = Product.productCounter;
                String valueName = productNameField1.getText();
                if(productNameField1.getText().trim().equals("")){
                     Alert ErrorAlert1 = new Alert(AlertType.CONFIRMATION, "Name field is empty", ButtonType.OK);
                        ErrorAlert1.showAndWait();
                        if (ErrorAlert1.getResult() == ButtonType.OK){
                            ErrorAlert1.close();
                        }
                }
                String valueInv = productInvField1.getText();
                int intInv = Integer.parseInt(valueInv);
                String valuePC = productPCField1.getText();
                if(productPCField1.getText().isEmpty()){
                       Alert ErrorAlert2 = new Alert(AlertType.CONFIRMATION, "Price field is empty", ButtonType.OK);
                        ErrorAlert2.showAndWait();
                        if (ErrorAlert2.getResult() == ButtonType.OK){
                            ErrorAlert2.close();
                        }
                }
                double doublePC = Double.parseDouble(valuePC);
                String valueMax = productMaxField1.getText();
                int intMax = Integer.parseInt(valueMax);
                String valueMin = productMinField1.getText();
                int intMin = Integer.parseInt(valueMin);
                
                if(intInv > intMax){
                     Alert ErrorAlert3 = new Alert(AlertType.CONFIRMATION, "Inventory value greater than maximum value.", ButtonType.OK);
                        ErrorAlert3.showAndWait();
                        if (ErrorAlert3.getResult() == ButtonType.OK){
                            ErrorAlert3.close();
                        }
                }else if(intInv < intMin){
                     Alert ErrorAlert3 = new Alert(AlertType.CONFIRMATION, "Inventory value less than minimum value.", ButtonType.OK);
                        ErrorAlert3.showAndWait();
                        if (ErrorAlert3.getResult() == ButtonType.OK){
                            ErrorAlert3.close();
                        }
                }else if(intMax < intMin){
                    Alert ErrorAlert4 = new Alert(AlertType.CONFIRMATION, "Maximum less than minimum", ButtonType.OK);
                        ErrorAlert4.showAndWait();
                        if (ErrorAlert4.getResult() == ButtonType.OK){
                            ErrorAlert4.close();
                        }
                }else if(productParts.isEmpty()){
                    Alert ErrorAlert5 = new Alert(AlertType.CONFIRMATION, "Product must have at least one Part", ButtonType.OK);
                        ErrorAlert5.showAndWait();
                        if (ErrorAlert5.getResult() == ButtonType.OK){
                            ErrorAlert5.close();
                        }                    
                }else if(doublePC < getAssociatedPrice()){
                    Alert ErrorAlert6 = new Alert(AlertType.CONFIRMATION, "Product price cannot be less than parts.", ButtonType.OK);
                        ErrorAlert6.showAndWait();
                        if (ErrorAlert6.getResult() == ButtonType.OK){
                            ErrorAlert6.close();
                        }
                }else{
                    Product tempProduct = new Product(intID, valueName, intInv, doublePC, intMax, intMin, productParts);
                    tempProduct.setProductID(intID);
                    Inventory.getProducts().add(tempProduct);
                        if(selectedItem2 != null){
                        Inventory.getProducts().remove(selectedItem2); 
                        
                        }
                        primaryStage.setScene(scene1);
                        clearFields2();
                    }
                
        });
        
        Button addProductCancelButton = new Button("Cancel");
        addProductCancelButton.setOnAction(e -> {
            Alert cancelAlert = new Alert(AlertType.CONFIRMATION, "Are you sure ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            cancelAlert.showAndWait();
            if (cancelAlert.getResult() == ButtonType.YES){
            primaryStage.setScene(scene1);
            clearFields2();
            }
            });
        
        GridPane.setConstraints(productAddGrid1, 0, 1);
        
        GridPane.setConstraints(addProductDeleteButton, 1, 4);
        GridPane.setHalignment(addProductDeleteButton, HPos.RIGHT);
        
        HBox addProductGroup1 = new HBox(10, addProductSaveButton, addProductCancelButton);
        addProductGroup1.setAlignment(Pos.BOTTOM_RIGHT);
        GridPane.setConstraints(addProductGroup1, 1, 5);        
        
        productAddGrid.getChildren().addAll(addProductTitle, productSearch , productAddGrid1, addProductTable1, addProductTable2, addProductButton, addProductDeleteButton, addProductGroup1);
        productAddGrid1.getChildren().addAll(productID1, productIDField1, productName1, productNameField1, productInv1, productInvField1, productPC1, productPCField1, productMax1, productMaxField1, productMin1, productMinField1);
                
        primaryStage.setScene(scene1);                     
        primaryStage.setTitle("Project I");
        primaryStage.show();

    }
    
    private void clearFields(){
        
        partNameField.clear();
        partInvField.clear();
        partPCField.clear();
        partMaxField.clear();
        partMinField.clear();
        partCNField.clear();
        
    }
    
     private void clearFields2(){
        productIDField1.clear();
        productNameField1.clear();
        productInvField1.clear();
        productPCField1.clear();
        productMaxField1.clear();
        productMinField1.clear();
        
    }
    
    private void initialize(){
        
        
    }
    
    private void searchParts(){
            String searchPart = search1Field.getText();
            FilteredList<Part> filteredPart = searchParts(searchPart);
            SortedList<Part> sortedPart = new SortedList<>(filteredPart);
            sortedPart.comparatorProperty().bind(table1.comparatorProperty());
            table1.setItems(sortedPart);
    }
    
    private void searchParts2(){
            String searchPart2 = addProductSearchField.getText();
            FilteredList<Part> filteredPart2 = searchParts2(searchPart2);
            SortedList<Part> sortedPart2 = new SortedList<>(filteredPart2);
            sortedPart2.comparatorProperty().bind(addProductTable1.comparatorProperty());
            addProductTable1.setItems(sortedPart2);
    }
    
    private void searchProducts(){            
            String searchProduct = search2Field.getText();
            FilteredList<Product> filteredProduct = searchProducts(searchProduct);
            SortedList<Product> sortedProduct = new SortedList<>(filteredProduct);
            sortedProduct.comparatorProperty().bind(table2.comparatorProperty());
            table2.setItems(sortedProduct);
    }
    
    public FilteredList<Part> searchParts(String g){
        return Inventory.getParts().filtered(p -> p.getName().toLowerCase().contains(g.toLowerCase()));
        } 
    
    public FilteredList<Product> searchProducts(String g){    
        return Inventory.getProducts().filtered(p -> p.getName().toLowerCase().contains(g.toLowerCase()));
    }
    
    public FilteredList<Part> searchParts2(String g){
        return Inventory.getParts().filtered(p -> p.getName().toLowerCase().contains(g.toLowerCase()));
    }
    
    public void setModifyItems(Part p){
        int partID = p.getPartID();
        IDField.setText(partID+"");
        String partName = p.getName();
        partNameField.setText(partName);
        int partInv = p.getInStock();
        partInvField.setText(partInv+"");
        double partPC = p.getPrice();
        partPCField.setText(partPC+"");
        int partMax = p.getMax();
        partMaxField.setText(partMax+"");
        int partMin = p.getMin();
        partMinField.setText(partMin+"");
        String machineID = p.getNameOrID();
        partCNField.setText(machineID+"");
    }
  
    
    public void setModifyProduct(Product p){        
        int productID = p.getProductID();
        productIDField1.setText(productID+"");
        String productName = p.getName();
        productNameField1.setText(productName);
        int productInv = p.getInStock();
        productInvField1.setText(productInv+"");
        double productPC = p.getPrice();
        productPCField1.setText(productPC+"");
        int productMax = p.getMax();
        productMaxField1.setText(productMax+"");
        int productMin = p.getMin();
        productMinField1.setText(productMin+"");   
        productParts = p.getAssociatedParts();
        addProductTable2.setItems(productParts);
    } 
    
    public double getAssociatedPrice(){
       double sum = 0;
        for(int i = 0; i < productParts.size(); i++){
           sum = sum + productParts.get(i).getPrice();
        }
        return sum;
    }
    
    
   
    /**
     * @param args the command5 line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
        
        
    }
    
}
