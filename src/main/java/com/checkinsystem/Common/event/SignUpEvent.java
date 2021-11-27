
package com.checkinsystem.Common.event;

import com.checkinsystem.Common.Controller.Controller;
import com.checkinsystem.Common.SignUpView;
import com.checkinsystem.Common.gui.LoginView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SignUpEvent implements EventHandler<ActionEvent>{

       @Override
    public void handle(ActionEvent event) {
        //Controller.instance().setSignUpView(signUpView);
        SignUpView signUpView = new SignUpView();
        Controller.instance().setSignUpView(signUpView);
        Scene scene = new Scene(signUpView, 300, 200);
        
        Stage s=new Stage();
        s.setTitle("Registration panel");
        s.setScene(scene);
        s.show();
       // Controller.instance().getPrimaryStage().setScene(scene);
    }
        /*Controller.instance().setLoggedEmployee(null);
        LoginView loginView = new LoginView();
        Controller.instance().setLoginView(loginView);
        Scene scene = new Scene(loginView, 650, 180);
        Controller.instance().getPrimaryStage().setScene(scene);*/
    }
