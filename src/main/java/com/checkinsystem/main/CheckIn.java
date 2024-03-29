package com.checkinsystem.main;

import com.checkinsystem.Common.Controller.Controller;
import com.checkinsystem.Common.gui.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class CheckIn extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        Controller.instance().setPrimaryStage(primaryStage);
        LoginView loginView=new LoginView();
        Controller.instance().setLoginView(loginView);
        Scene scene=new Scene(loginView, 600,180);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login View");
        primaryStage.show();
      
    }

    public static void main(String[] args) {
       launch();
       /*UserJpaDao userJpaDao=new UserJpaDao();
       User logovaniUser= userJpaDao.login("amila.hasovic","amila1234");
       System.out.println("Učitani user: " + logovaniUser);*/
       
    }

}