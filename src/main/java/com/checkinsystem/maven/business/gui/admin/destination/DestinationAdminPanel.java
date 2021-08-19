/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.checkinsystem.maven.business.gui.admin.destination;

import com.checkinsystem.maven.business.dao.DestinationJpaDao;
import com.checkinsystem.maven.business.entity.Destination;
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
public class DestinationAdminPanel extends VBox {
    private final Label titleLabel=new Label("Administration of destination");
    private TableView<Destination> destinationTableView=new TableView<>();
    private ObservableList<Destination> destinations=null;
    
    public DestinationAdminPanel(){
        titleLabel.setFont(new Font("Arial",20));
        setSpacing(5);
        setPadding(new Insets(10));
        List<Destination> userList=new DestinationJpaDao().getAll();
        destinations=FXCollections.observableArrayList(userList);
        destinationTableView.setItems(destinations);
        
        TableColumn<Destination,String> destinationColumn= new TableColumn<>("Destination");
        destinationColumn.setMinWidth(150);
         destinationColumn.setCellValueFactory(new PropertyValueFactory<Destination,String>("destination"));
        
         TableColumn<Destination,String> numberOfDaysColumn= new TableColumn<>("Number od days");
        numberOfDaysColumn.setMinWidth(150);
        numberOfDaysColumn.setCellValueFactory(new PropertyValueFactory<Destination,String>("numberOfDays"));
        
         TableColumn<Destination,String> codeColumn= new TableColumn<>("Code");
        codeColumn.setMinWidth(150);
        codeColumn.setCellValueFactory(new PropertyValueFactory<Destination,String>("code"));
        
         TableColumn<Destination,String> priceColumn= new TableColumn<>("Price");
        priceColumn.setMinWidth(150);
        priceColumn.setCellValueFactory(new PropertyValueFactory<Destination,String>("price"));
        
        destinationTableView.getColumns().addAll(destinationColumn, numberOfDaysColumn,codeColumn,priceColumn);
        getChildren().addAll(titleLabel,destinationTableView);
}
}
