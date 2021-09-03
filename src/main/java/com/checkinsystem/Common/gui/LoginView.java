package com.checkinsystem.Common.gui;


import com.checkinsystem.Common.Controller.Controller;
import com.checkinsystem.Common.event.EventBus;
import java.util.Optional;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class LoginView extends GridPane{
    private final Label usernameLabel=new Label("Username: ");
    private final TextField usernameField= new TextField();
    private final Label passwordLabel=new Label("Password: ");
    private final PasswordField passwordField=new PasswordField();
    private final Button loginButton=new Button("Sign in");
    private final Label messageLabel=new Label("");
    
    
    public LoginView(){
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(10,10,10,10));
        setAlignment(Pos.CENTER);
    
    usernameField.setText("amila.hasovic");
    passwordField.setText("amila1234");
    add(usernameLabel,0,0);
    add(usernameField,1,0);
    add(passwordLabel,0,1);
    add(passwordField,1,1);
    
    FlowPane buttonFlowPane= new FlowPane();
    buttonFlowPane.setAlignment(Pos.CENTER_RIGHT);
    buttonFlowPane.getChildren().addAll(loginButton);
    add(buttonFlowPane,1,2);
    add(messageLabel,1,3);
    
    EventBus eventBus=Controller.instance().getEventBus();
    loginButton.setOnAction(eventBus.getLoginEvent());
    //loginButton.setMnemonic(KeyEvent.);
    //cancelButton.setOnAction(eventBus.getCancelEvent());

    }

    public String getUsername(){
        return usernameField.getText();
    }
    
    public String getPassword(){
      return passwordField.getText();  
    }
    
    public void setLoginMessage(String message){
        if(message !=null && !message.isEmpty()){
            messageLabel.setText(message);
        }
    }
    }
