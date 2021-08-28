
package com.checkinsystem.Employee.gui;

import com.checkinsystem.Employee.EmployeePanel;
import com.checkinsystem.Common.Controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class EmployeeView extends BorderPane{
    private Button logoutButton=new Button("Logout");
    private final ToggleButton destinationButton=new ToggleButton("Destination");
    
    private EmployeePanel employeePanel;
    
    public EmployeeView(){
        employeePanel=new EmployeePanel();
        setCenter(employeePanel);
        
        
    logoutButton.setText("Logout("+Controller.instance().getLoggedEmployee()+")");
        logoutButton.setOnAction(Controller.instance().getEventBus().getLogoutEvent());
        HBox logoutBox=new HBox(logoutButton);
        logoutBox.setAlignment(Pos.CENTER);
        logoutBox.setPadding(new Insets(10));
        
        GridPane topPane=new GridPane();
        
        topPane.add(logoutBox,1,0);
        
        setTop(topPane);
}
    public EmployeePanel getEmployeePanel(){
        return employeePanel;
    }

    private void setEmployeePanel(EmployeePanel employeePanel) {
    this.employeePanel=employeePanel;
    }
}
