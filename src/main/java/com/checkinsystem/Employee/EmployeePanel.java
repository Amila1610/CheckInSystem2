/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.checkinsystem.Employee;

import com.checkinsystem.Destination.Destination;
import com.checkinsystem.Destination.dao.DestinationJpaDao;
import com.checkinsystem.Employee.dao.EmployeeJpaDao;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author AMILA
 */
public class EmployeePanel extends VBox{
    private final Label titleLabel=new Label("Administration of destination");
    private TableView<Destination> destinationTableView=new TableView<>();
    private ObservableList<Destination> destinations=null;
    
    public EmployeePanel(){
        titleLabel.setFont(new Font("Arial",20));
        setSpacing(5);
        setPadding(new Insets(10));
        List<Destination> destinationList=new DestinationJpaDao().getAll();
        destinations=FXCollections.observableArrayList(destinationList);
        destinationTableView.setItems(destinations);
    
        
     TableColumn<Destination,String> destinationColumn= new TableColumn<>("Destination");
        destinationColumn.setMinWidth(150);
         destinationColumn.setCellValueFactory(new PropertyValueFactory<Destination,String>("destination"));
         
        TableColumn<Destination,String> numOfDaysColumn= new TableColumn<>("Number of days");
        numOfDaysColumn.setMinWidth(150);
        numOfDaysColumn.setCellValueFactory(new PropertyValueFactory<Destination,String>("numberOfDays"));
         
        TableColumn<Destination,String> codeColumn= new TableColumn<>("Code");
        codeColumn.setMinWidth(150);
        codeColumn.setCellValueFactory(new PropertyValueFactory<Destination,String>("code"));
         
         destinationTableView.getColumns().addAll(destinationColumn,numOfDaysColumn,codeColumn);
        getChildren().addAll(titleLabel,destinationTableView);
      
    }
    
}
    
