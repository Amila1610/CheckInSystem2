package com.checkinsystem.maven.business.gui.admin.userAdmin;

import com.checkinsystem.maven.business.dao.UserJpaDao;
import com.checkinsystem.maven.business.entity.User;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class UserAdminPanel extends VBox{
    
    private final Label titleLabel=new Label("Administration of user");
    private TableView<User> userTableView=new TableView<>();
    private ObservableList<User> users=null;
    
    public UserAdminPanel(){
        titleLabel.setFont(new Font("Arial",20));
        setSpacing(5);
        setPadding(new Insets(10));
        List<User> userList=new UserJpaDao().getAll();
        users=FXCollections.observableArrayList(userList);
        userTableView.setItems(users);
        
        TableColumn<User,String> usernameColumn= new TableColumn<>("Username");
        usernameColumn.setMinWidth(150);
        usernameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("username"));
        
         TableColumn<User,String> nameColumn= new TableColumn<>("Name");
        nameColumn.setMinWidth(150);
        nameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("name"));
        
         TableColumn<User,String> surnameColumn= new TableColumn<>("Surname");
        surnameColumn.setMinWidth(150);
        surnameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("surname"));
        
         TableColumn<User,String> privilegeColumn= new TableColumn<>("Privilege");
        privilegeColumn.setMinWidth(150);
        privilegeColumn.setCellValueFactory(new PropertyValueFactory<User,String>("idPrivilege"));
        
        userTableView.getColumns().addAll(usernameColumn, nameColumn,surnameColumn,privilegeColumn);
        getChildren().addAll(titleLabel,userTableView);
    }
    
}
