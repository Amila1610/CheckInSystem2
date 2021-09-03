/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.checkinsystem.Passenger;

import com.checkinsystem.Destination.Destination;
import com.checkinsystem.Destination.dao.DestinationJpaDao;
import com.checkinsystem.Passenger.dao.PassengerJpaDao;
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
public class PassengerPanel extends VBox{
    private final Label titleLabel=new Label("Administration of passenger");
    private TableView<Passenger> passengerTableView=new TableView<>();
    private ObservableList<Passenger> passengers=null;
    
     public PassengerPanel(){
        titleLabel.setFont(new Font("Arial",20));
        setSpacing(5);
        setPadding(new Insets(10));
        List<Passenger> passengerList=new PassengerJpaDao().getAll();
        passengers=FXCollections.observableArrayList(passengerList);
        passengerTableView.setItems(passengers);
        
         TableColumn<Passenger,String> nameColumn= new TableColumn<>("Name");
        nameColumn.setMinWidth(150);
         nameColumn.setCellValueFactory(new PropertyValueFactory<Passenger,String>("name"));
         
         TableColumn<Passenger,String> surnameColumn= new TableColumn<>("Surname");
         surnameColumn.setMinWidth(150);
         surnameColumn.setCellValueFactory(new PropertyValueFactory<Passenger,String>("surname"));
         
         TableColumn<Passenger,Integer> documentColumn= new TableColumn<>("DocumentId");
         documentColumn.setMinWidth(150);
         documentColumn.setCellValueFactory(new PropertyValueFactory<Passenger,Integer>("document"));
         
         TableColumn<Passenger,String> resColumn= new TableColumn<>("Reservation");
         resColumn.setMinWidth(150);
         resColumn.setCellValueFactory(new PropertyValueFactory<Passenger,String>("id_reservation"));
         
         passengerTableView.getColumns().addAll(nameColumn,surnameColumn,documentColumn, resColumn);
        getChildren().addAll(titleLabel,passengerTableView);
     }
    
}
