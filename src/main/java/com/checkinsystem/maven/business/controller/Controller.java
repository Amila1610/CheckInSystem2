package com.checkinsystem.maven.business.controller;

import com.checkinsystem.maven.business.controller.event.EventBus;
import com.checkinsystem.maven.business.entity.User;
import com.checkinsystem.maven.business.gui.LoginView;
import com.checkinsystem.maven.business.gui.admin.AdminView;
import com.checkinsystem.maven.business.gui.user.UserView;
import javafx.stage.Stage;

public class Controller {
    private final EventBus eventBus=new EventBus();
    private Stage primaryStage;
    private LoginView loginView;
    private AdminView adminView;
    private UserView userView;
    
    private User loggedUser;
    
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

    public UserView getUserView() {
        return userView;
    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }
    
    
    private static Controller INSTANCE=null;
    
    public static Controller instance(){
        if(INSTANCE == null){
            INSTANCE=new Controller();
        }
        return INSTANCE;
    }
}
