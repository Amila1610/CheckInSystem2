
package com.checkinsystem.Employee.gui;

import com.checkinsystem.Employee.EmployeePanel;
import com.checkinsystem.Common.Controller.Controller;
import com.checkinsystem.Passenger.PassengerPanel;
import com.checkinsystem.admin.destination.DestinationAdminPanel;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class EmployeeView extends BorderPane{
    private Button logoutButton=new Button("Logout");
    private final ToggleButton destinationButton=new ToggleButton("Destination");
    private final ToggleButton passengerButton=new ToggleButton("Passenger");
    
    private EmployeePanel employeePanel;
    private PassengerPanel passengerPanel;
    
    public EmployeeView(){
        employeePanel=new EmployeePanel();
        setCenter(employeePanel);
        
          ToggleGroup toggleGroup=new ToggleGroup();
        destinationButton.setToggleGroup(toggleGroup);
        destinationButton.setSelected(true);
        destinationButton.setOnAction(this::onDestinationButtonClick);
        passengerButton.setToggleGroup(toggleGroup);
        passengerButton.setOnAction(this::onPassengerButtonClick);
        
        HBox mainMenuBox=new HBox();
        mainMenuBox.setSpacing(5);
        mainMenuBox.setPadding(new Insets(10));
        mainMenuBox.getChildren().addAll(destinationButton,passengerButton);
        
    logoutButton.setText("Logout");
        logoutButton.setOnAction(Controller.instance().getEventBus().getLogoutEvent());
        HBox logoutBox=new HBox(logoutButton);
        logoutBox.setAlignment(Pos.CENTER);
        logoutBox.setPadding(new Insets(10));
        
        GridPane topPane=new GridPane();
        topPane.add(mainMenuBox,0,0);
        topPane.add(logoutBox,1,0);
        
        setTop(topPane);
}
    public EmployeePanel getEmployeePanel(){
        return employeePanel;
    }

    private void setEmployeePanel(EmployeePanel employeePanel) {
    this.employeePanel=employeePanel;
    }

    private void onDestinationButtonClick(ActionEvent event) {
    employeePanel=new EmployeePanel();
        setCenter(employeePanel);}

    private void onPassengerButtonClick(ActionEvent event) {
    passengerPanel= new PassengerPanel();
    setCenter(passengerPanel);
    }
    
     public PassengerPanel getPassengerPanel(){
        return passengerPanel;
    }

    private void setPassengerPanel(PassengerPanel passengerPanel) {
    this.passengerPanel=passengerPanel;
    }
}
