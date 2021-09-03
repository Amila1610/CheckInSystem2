/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.checkinsystem.admin.destination;

import com.checkinsystem.Common.Controller.Controller;
import com.checkinsystem.Destination.dao.DestinationJpaDao;
import com.checkinsystem.Destination.Destination;
import com.checkinsystem.Employee.Employee;
import com.checkinsystem.Employee.dao.EmployeeJpaDao;
import com.checkinsystem.Privilege.Privilege;
import com.checkinsystem.Privilege.dao.PrivilegeJpaDao;
import java.math.BigDecimal;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author AMILA
 */
public class DestinationAdminPanel extends VBox{
    private final Label titleLabel=new Label("Administration of destination");
    private TableView<Destination> destinationTableView=new TableView<>();
    private ObservableList<Destination> destinations=null;
    
    private TextField destinationInput= new TextField();
    private TextField numberOfDaysInput=new TextField();
    private TextField codeInput= new TextField();
    private TextField priceInput=new TextField();
    
    
    private Button addDestinationButton= new Button("Add");
    private Button deleteDestinationButton= new Button("Delete");
    
    public DestinationAdminPanel(){
        titleLabel.setFont(new Font("Arial",20));
        setSpacing(5);
        setPadding(new Insets(10));
        List<Destination> destinationList=new DestinationJpaDao().getAll();
        destinations=FXCollections.observableArrayList(destinationList);
        destinationTableView.setItems(destinations);
    
        
     TableColumn<Destination,String> destinationColumn= new TableColumn<>("Destination");
        destinationColumn.setMinWidth(150);
         destinationColumn.setCellValueFactory(new PropertyValueFactory<Destination,String>("destination"));
         
        TableColumn<Destination,Integer> numOfDaysColumn= new TableColumn<>("Number of days");
        numOfDaysColumn.setMinWidth(150);
        numOfDaysColumn.setCellValueFactory(new PropertyValueFactory<Destination,Integer>("numberOfDays"));
         
        TableColumn<Destination,String> codeColumn= new TableColumn<>("Code");
        codeColumn.setMinWidth(150);
        codeColumn.setCellValueFactory(new PropertyValueFactory<Destination,String>("code"));
        
       TableColumn<Destination,BigDecimal> priceColumn= new TableColumn<>("Price/KM");
        priceColumn.setMinWidth(150);
        priceColumn.setCellValueFactory(new PropertyValueFactory<Destination,BigDecimal>("price"));
        
         destinationTableView.getColumns().addAll(destinationColumn,numOfDaysColumn,codeColumn,priceColumn);
        getChildren().addAll(titleLabel,destinationTableView, getDestinationCreationForm());
        
}
    private HBox getDestinationCreationForm(){
        HBox hBox=new HBox();
        hBox.setSpacing(5);
        
        destinationInput.setMaxWidth(120);
        destinationInput.setPromptText("New destination..");
        numberOfDaysInput.setMaxWidth(120);
        numberOfDaysInput.setPromptText("Number of days..");
        codeInput.setMaxWidth(120);
        codeInput.setPromptText("Set code..");
        priceInput.setMaxWidth(120);
        priceInput.setPromptText("Price..");
        
        addDestinationButton.setOnAction(this::insertOrUpdateDestination);
        deleteDestinationButton.setOnAction(this::removeDestination);
        
        hBox.getChildren().addAll(destinationInput,numberOfDaysInput,codeInput,priceInput
                ,addDestinationButton,deleteDestinationButton);
        return hBox;
    }

    private void insertOrUpdateDestination(ActionEvent e) {
      String des=destinationInput.getText();
      DestinationJpaDao destinationJpaDao=new DestinationJpaDao();
      Destination destination=destinationJpaDao.findByDestination(des);
      if(destination==null){
          destination=new Destination();
      }
      destination.setDestination(destinationInput.getText());
     
      destination.setNumberOfDays(Integer.parseInt(numberOfDaysInput.getText()));
      destination.setCode(codeInput.getText());
      destination.setPrice(new BigDecimal(priceInput.getText()));
       if(destination.getId()!=null){
            destinationJpaDao.update(destination);
        }else{
            destinationJpaDao.save(destination);
        }
        clearInputs();
        loadTableItems();
    }
    private void removeDestination(ActionEvent event){
       Destination destination=destinationTableView.getSelectionModel().getSelectedItem();
       
       if(destination!=null){
            DestinationJpaDao destinationJpaDao=new DestinationJpaDao();
            destinationJpaDao.delete(destination);
        }
        loadTableItems();
    }
     private void loadTableItems(){
        destinations=FXCollections.observableArrayList(new DestinationJpaDao().getAll());
        destinations.remove(Controller.instance().getSelectedDestination());
        destinationTableView.setItems(destinations);
    }
    
    private void clearInputs(){
        destinationInput.clear();
        numberOfDaysInput.clear();
        codeInput.clear();
        priceInput.clear();
    }
    
   
}
