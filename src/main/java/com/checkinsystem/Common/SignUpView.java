/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.checkinsystem.Common;

import com.checkinsystem.Common.Controller.Controller;
import com.checkinsystem.Common.gui.LoginView;
import com.checkinsystem.Employee.Employee;
import com.checkinsystem.Employee.dao.EmployeeJpaDao;
import com.checkinsystem.Employee.gui.EmployeeView;
import com.checkinsystem.Privilege.Privilege;
import com.checkinsystem.main.AccessPrivilege;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author AMILA
 */
public class SignUpView extends GridPane{
     Label usernameLabel=new Label("Username:");
        TextField usernameField= new TextField();
        Label passwordLabel=new Label("Password: ");
        PasswordField passwordField=new PasswordField();
        Label nameLabel=new Label("Name:");
        TextField nameField= new TextField();
        Label surnameLabel=new Label("Surname:");
        TextField surnameField= new TextField();
        //Label privilege1=new Label("Set privilege:");
        
        //ChoiceBox<Privilege> privilegeSelector= new ChoiceBox();
        Button loginButton=new Button("Save");
        
        
        public SignUpView(){
         
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(10,10,10,10));
        setAlignment(Pos.CENTER);
        
        add(usernameLabel,0,0);
        add(usernameField,1,0);
        add(passwordLabel,0,1);
        add(passwordField,1,1);
        add(nameLabel,0,2);
        add(nameField,1,2);
        add(surnameLabel,0,3);
        add(surnameField,1,3);
        add(loginButton,1,5);
        //gp.add(privilege1,0,4);
        //gp.add(privilegeSelector,1,4);
        
       // privilegeSelector.setMaxWidth(160);
        
        
        loginButton.setOnAction(this::onSaveClick);
        
        }
        private void onSaveClick(ActionEvent event) {
        String username=usernameField.getText();
        EmployeeJpaDao employeeJpaDao=new EmployeeJpaDao();
        Employee employee=employeeJpaDao.findByUsername(username);
        if(employee==null){
            employee=new Employee();
        }  
        
        employee.setUsername(usernameField.getText());
        employee.setPassword(passwordField.getText());
        employee.setName(nameField.getText());
        employee.setSurname(surnameField.getText());
        employee.setIdPrivilege(new Privilege(3,"user"));
        
        if(employee.getUsername().isEmpty()||employee.getPassword().isEmpty()||employee.getName().isEmpty()
                ||employee.getSurname().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!!!");
            alert.setContentText("All fields must be filled!!");
            alert.show();
            return;
        }
        
        if(employee.getId()==null){
            employeeJpaDao.save(employee);
            
        }  
        
         clearInputs();
               
        }
        
         private void clearInputs(){
        usernameField.clear();
        passwordField.clear();
        nameField.clear();
        surnameField.clear();
        return;
       
    }
         
        
             
             
            // Controller.instance().setLoggedEmployee(null);
        //LoginView loginView = new LoginView();
        //Controller.instance().setLoginView(loginView);
        //Scene scene = new Scene(loginView, 650, 180);
       // Controller.instance().getPrimaryStage().setScene(scene);
         
}
