
package com.checkinsystem.admin.gui;

import com.checkinsystem.Common.Controller.Controller;
import com.checkinsystem.admin.destination.DestinationAdminPanel;
import com.checkinsystem.admin.user.UserAdminPanel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class AdminView extends BorderPane{
    private final ToggleButton employeeButton=new ToggleButton("Employees");
    private final ToggleButton destinationButton=new ToggleButton("Destination");
    private Button logoutButton=new Button("Logout");
    
    private UserAdminPanel userAdminPanel;
    private DestinationAdminPanel destinationAdminPanel;
    
    public AdminView(){
        userAdminPanel=new UserAdminPanel();
        setCenter(userAdminPanel);
               
        ToggleGroup toggleGroup=new ToggleGroup();
        employeeButton.setToggleGroup(toggleGroup);
        employeeButton.setSelected(true);
        employeeButton.setOnAction(this::onEmployeeButtonClick);
        destinationButton.setToggleGroup(toggleGroup);
        destinationButton.setOnAction(this::onDestinationButtonClick);
        
        HBox mainMenuBox=new HBox();
        mainMenuBox.setSpacing(5);
        mainMenuBox.setPadding(new Insets(10));
        mainMenuBox.getChildren().addAll(employeeButton,destinationButton);
        
        logoutButton.setText("Logout("+Controller.instance().getLoggedEmployee()+")");
        logoutButton.setOnAction(Controller.instance().getEventBus().getLogoutEvent());
        HBox logoutBox=new HBox(logoutButton);
        logoutBox.setAlignment(Pos.CENTER);
        logoutBox.setPadding(new Insets(10));
        
        GridPane topPane=new GridPane();
        topPane.add(mainMenuBox,0,0);
        topPane.add(logoutBox,1,0);
        
        setTop(topPane);
    }
    
    private void onEmployeeButtonClick(ActionEvent e){
        userAdminPanel=new UserAdminPanel();
        setCenter(userAdminPanel);
    }
    
    private void onDestinationButtonClick(ActionEvent e){
        destinationAdminPanel=new DestinationAdminPanel();
        setCenter(destinationAdminPanel);
    }
    public UserAdminPanel getUserAdminPanel(){
        return userAdminPanel;
    }

    private void setUserAdminPanel(UserAdminPanel userAdminPanel) {
    this.userAdminPanel=userAdminPanel;
    }
    
    public DestinationAdminPanel getDestinationAdminPanel(){
        return destinationAdminPanel;
    }
    
    public void setDestinationAdminPanel(DestinationAdminPanel destinationAdminPanel){
        this.destinationAdminPanel=destinationAdminPanel;
    }
    
}
