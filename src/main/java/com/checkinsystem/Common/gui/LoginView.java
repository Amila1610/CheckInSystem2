package com.checkinsystem.Common.gui;

import com.checkinsystem.Common.Controller.Controller;
import com.checkinsystem.Common.event.EventBus;
import com.checkinsystem.Privilege.Privilege;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginView extends GridPane{
    private final Label usernameLabel=new Label("Username: ");
    private final TextField usernameField= new TextField();
    private final Label passwordLabel=new Label("Password: ");
    private final PasswordField passwordField=new PasswordField();
    private final Button loginButton=new Button("Sign in");
    private final Button signUpButton=new Button("Sign Up");
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
    buttonFlowPane.getChildren().addAll(loginButton,signUpButton);
    add(buttonFlowPane,1,2);
    add(messageLabel,1,3);
    
    EventBus eventBus=Controller.instance().getEventBus();
    loginButton.setOnAction(eventBus.getLoginEvent());
    signUpButton.setOnAction(eventBus.getSignUpEvent());
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
    //private void onSignUpButtonClick(ActionEvent e){
        
       /* Label usernameLabel=new Label("Set your username:");
        TextField usernameField= new TextField();
        Label passwordLabel=new Label("Password: ");
        PasswordField passwordField=new PasswordField();
        Label nameLabel=new Label("Set your name:");
        TextField nameField= new TextField();
        Label surnameLabel=new Label("Set your surname:");
        TextField surnameField= new TextField();
        Label privilege1=new Label("Set privilege:");
        
        //ChoiceBox<Privilege> privilegeSelector= new ChoiceBox();
        Button loginButton=new Button("Save");
        //Privilege privilege=new Privilege(2,"user");
        
       // privilegeJpaDao.get(1);
        
       /* Privilege privilege = privilegeJpaDao.get(2);
        
       /* List<Privilege>privileges= privilegeJpaDao.getAll();
        ObservableList<Privilege> observablePrivileges=FXCollections.observableArrayList(privileges);*/
       // privilegeSelector.setItems(observablePrivileges) ;
        
        /*GridPane gp= new GridPane();
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(10,10,10,10));
        gp.setAlignment(Pos.CENTER);
        
        gp.add(usernameLabel,0,0);
        gp.add(usernameField,1,0);
        gp.add(passwordLabel,0,1);
        gp.add(passwordField,1,1);
        gp.add(nameLabel,0,2);
        gp.add(nameField,1,2);
        gp.add(surnameLabel,0,3);
        gp.add(surnameField,1,3);
        gp.add(loginButton,1,5);
        gp.add(privilege1,0,4);
        //gp.add(privilegeSelector,1,4);
        
        privilegeSelector.setMaxWidth(160);
        
        
        loginButton.setOnAction(this::onSaveClick);
        
        Scene signupScene= new Scene(gp,300,200);
        Stage s=new Stage();
        s.setTitle("Registration panel");
        s.setScene(signupScene);
        s.show();
        }
    
        private void onSaveClick(ActionEvent event) {
        
            
        }*/
        /*employee.setUsername(usernameInput.getText());
        employee.setPassword(passwordInput.getText());
        employee.setName(nameInput.getText());
        employee.setSurname(surnameInput.getText());
        employee.setIdPrivilege(privilegeSelector.getSelectionModel().getSelectedItem());
        if(employee.getId()==null){
        employeeJpaDao.save(employee);
        }*/
        /*EmployeeJpaDao employeeJpaDao=new EmployeeJpaDao();
        String username = null;
        Employee employee=employeeJpaDao.findByUsername(username);
        if(employee==null){
        employee=new Employee();
        }if(employee.getId()==null){
        employeeJpaDao.save(employee);
        }*/ 
    /* Label usernameLabel=new Label("Set your username:");
     TextField usernameField= new TextField();
     Label passwordLabel=new Label("Password: ");
     PasswordField passwordField=new PasswordField();
     Label nameLabel=new Label("Set your name:");
     TextField nameField= new TextField();
     Label surnameLabel=new Label("Set your surname:");
     TextField surnameField= new TextField();
     Label privilege=new Label("Set privilege:");
     ChoiceBox<Privilege> privilegeSelector= new ChoiceBox();
     Button loginButton=new Button("Save");
        
     
     PrivilegeJpaDao privilegeJpaDao=new PrivilegeJpaDao();
        List<Privilege>privileges= privilegeJpaDao.getAll();
        ObservableList<Privilege> observablePrivileges=FXCollections.observableArrayList(privileges);
        privilegeSelector.setItems(observablePrivileges) ;

        GridPane gp= new GridPane();
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(10,10,10,10));
        gp.setAlignment(Pos.CENTER);
        
         gp.add(usernameLabel,0,0);
         gp.add(usernameField,1,0);
         gp.add(passwordLabel,0,1);
         gp.add(passwordField,1,1);
         gp.add(nameLabel,0,2);
         gp.add(nameField,1,2);
         gp.add(surnameLabel,0,3);
         gp.add(surnameField,1,3);
         gp.add(loginButton,1,5);
        gp.add(privilege,0,4);
        gp.add(privilegeSelector,1,4);
        
        privilegeSelector.setMaxWidth(120);
        loginButton.setOnAction(this::onSaveClick);
       
        
        Scene signupScene= new Scene(gp,300,200);
        Stage s=new Stage();
        s.setTitle("Registration panel");
        s.setScene(signupScene);
        
        s.show();
        
               
    }
    
    private void onSaveClick(ActionEvent event) {
       /* String username=usernameInput.getText();
        EmployeeJpaDao employeeJpaDao=new EmployeeJpaDao();
        Employee employee=employeeJpaDao.findByUsername(username);
        if(employee==null){
            employee=new Employee();
        }
        employee.setUsername(usernameInput.getText());
        employee.setPassword(passwordInput.getText());
        employee.setName(nameInput.getText());
        employee.setSurname(surnameInput.getText());
        employee.setIdPrivilege(privilegeSelector.getSelectionModel().getSelectedItem());
        if(employee.getId()==null){
            employeeJpaDao.save(employee);
        }*/
        
        
      /*EmployeeJpaDao employeeJpaDao=new EmployeeJpaDao();
        String username = null;
        Employee employee=employeeJpaDao.findByUsername(username);
        if(employee==null){
            employee=new Employee();
        }if(employee.getId()==null){
            employeeJpaDao.save(employee);
        }*/
             
    }

   
