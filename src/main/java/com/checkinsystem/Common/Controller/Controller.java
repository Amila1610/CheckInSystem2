package com.checkinsystem.Common.Controller;

import com.checkinsystem.Common.event.EventBus;
import com.checkinsystem.Employee.Employee;
import com.checkinsystem.Common.gui.LoginView;
import com.checkinsystem.Destination.Destination;
import com.checkinsystem.admin.gui.AdminView;
import com.checkinsystem.Employee.gui.EmployeeView;
import javafx.stage.Stage;

public class Controller {
    private final EventBus eventBus=new EventBus();
    private Stage primaryStage;
    private LoginView loginView;
    private AdminView adminView;
    private EmployeeView employeeView;
    
    private Employee loggedEmployee;
    private Destination selectedDestination;
    
    private Controller(){
        super();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    public EventBus getEventBus(){
        return eventBus;
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }

    public AdminView getAdminView() {
        return adminView;
    }

    public void setAdminView(AdminView adminView) {
        this.adminView = adminView;
    }

    public EmployeeView getEmployeeView() {
        return employeeView;
    }

    public void setEmployeeView(EmployeeView employeeView) {
        this.employeeView = employeeView;
    }

    public Employee getLoggedEmployee() {
        return loggedEmployee;
    }

    public void setLoggedEmployee(Employee loggedEmployee) {
        this.loggedEmployee = loggedEmployee;
    }
    
    public Destination getSelectedDestination() {
        return selectedDestination;
    }

    public void setSelectedDestination(Destination selectedDestination) {
        this.selectedDestination = selectedDestination;
    }
    private static Controller INSTANCE=null;
    
    public static Controller instance(){
        if(INSTANCE == null){
            INSTANCE=new Controller();
        }
        return INSTANCE;
    }
}
