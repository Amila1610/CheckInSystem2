
package com.checkinsystem.maven.business.gui.admin;

import com.checkinsystem.maven.business.controller.Controller;
import com.checkinsystem.maven.business.gui.admin.destination.DestinationAdminPanel;
import com.checkinsystem.maven.business.gui.admin.userAdmin.UserAdminPanel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;

public class AdminView extends BorderPane{
    private ToggleButton userButton=new ToggleButton("Users");
    private ToggleButton destinationButton=new ToggleButton("Destination");
    private ToggleButton logoutButton=new ToggleButton("Logout");
    
    private UserAdminPanel userAdminPanel;
    private DestinationAdminPanel destinationAdminPanel;
    
    public AdminView(){
        userAdminPanel=new UserAdminPanel();
        setCenter(userAdminPanel);
        
        ToggleGroup toggleGroup=new ToggleGroup();
        userButton.setToggleGroup(toggleGroup);
        userButton.setSelected(true);
        userButton.setOnAction(this::onUserButtonClick);
        destinationButton.setToggleGroup(toggleGroup);
        destinationButton.setOnAction(this::onDestinationButtonClick);
        
        HBox mainMenuBox=new HBox();
        mainMenuBox.setSpacing(5);
        mainMenuBox.setPadding(new Insets(10));
        mainMenuBox.getChildren().addAll(userButton,destinationButton);
        
        logoutButton.setText("Logout("+Controller.instance().getLoggedUser()+")");
        HBox logoutBox=new HBox(logoutButton);
        logoutBox.setAlignment(Pos.CENTER);
        logoutBox.setPadding(new Insets(10));
        
        GridPane topPane=new GridPane();
        topPane.add(mainMenuBox,0,0);
        topPane.add(logoutBox,1,0);
        
        setTop(topPane);
    }
    
    private void onUserButtonClick(ActionEvent e){
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
