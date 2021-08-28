package com.checkinsystem.admin.user;

import com.checkinsystem.Employee.dao.EmployeeJpaDao;
import com.checkinsystem.Employee.Employee;
import com.checkinsystem.Privilege.Privilege;
import com.checkinsystem.Privilege.dao.PrivilegeJpaDao;
import com.checkinsystem.Common.Controller.Controller;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class UserAdminPanel extends VBox{
    
    private final Label titleLabel=new Label("Administration of user");
    private TableView<Employee> employeeTableView=new TableView<>();
    private ObservableList<Employee> employees=null;
    
    private TextField usernameInput= new TextField();
    private PasswordField passwordInput=new PasswordField();
    private TextField nameInput= new TextField();
    private TextField surnameInput=new TextField();
    private ChoiceBox<Privilege> privilegeSelector= new ChoiceBox();
    
    private Button addEmployeeButton= new Button("Add");
    private Button deleteEmployeeButton= new Button("Delete");
    
    
    public UserAdminPanel(){
        titleLabel.setFont(new Font("Arial",20));
        setSpacing(5);
        setPadding(new Insets(10));
        loadTableItems();
        
        List<Employee> employeeList=new EmployeeJpaDao().getAll();
        employees=FXCollections.observableArrayList(employeeList);
        employeeTableView.setItems(employees);
        
        TableColumn<Employee,String> usernameColumn= new TableColumn<>("Username");
        usernameColumn.setMinWidth(150);
        usernameColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("username"));
        
         TableColumn<Employee,String> nameColumn= new TableColumn<>("Name");
        nameColumn.setMinWidth(150);
        nameColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("name"));
        
         TableColumn<Employee,String> surnameColumn= new TableColumn<>("Surname");
        surnameColumn.setMinWidth(150);
        surnameColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("surname"));
        
         TableColumn<Employee,String> privilegeColumn= new TableColumn<>("Privilege");
        privilegeColumn.setMinWidth(150);
        privilegeColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("idPrivilege"));
        
        employeeTableView.getColumns().addAll(usernameColumn, nameColumn,surnameColumn,privilegeColumn);
        getChildren().addAll(titleLabel,employeeTableView,getUserCreationForm());
        
    }
    
    private HBox getUserCreationForm(){
        HBox hBox=new HBox();
        hBox.setSpacing(5);
        
        usernameInput.setMaxWidth(120);
        usernameInput.setPromptText("Username..");
        passwordInput.setMaxWidth(120);
        passwordInput.setPromptText("Password..");
        nameInput.setMaxWidth(120);
        nameInput.setPromptText("Name..");
        surnameInput.setMaxWidth(120);
        surnameInput.setPromptText("Surname..");
        
        PrivilegeJpaDao privilegeJpaDao=new PrivilegeJpaDao();
        List<Privilege>privileges= privilegeJpaDao.getAll();
ObservableList<Privilege> observablePrivileges=FXCollections.observableArrayList(privileges);
privilegeSelector.setItems(observablePrivileges) ;  

        privilegeSelector.setMaxWidth(100);
        
        addEmployeeButton.setOnAction(this::insertOrUpdateEmployee);
        deleteEmployeeButton.setOnAction(this::removeEmployee);
        
        hBox.getChildren().addAll(usernameInput,passwordInput,nameInput,surnameInput
                ,privilegeSelector,addEmployeeButton,deleteEmployeeButton);
        return hBox;
    }
    
    private void insertOrUpdateEmployee(ActionEvent e){
        String username=usernameInput.getText();
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
        if(employee.getId()!=null){
            employeeJpaDao.update(employee);
        }else{
            employeeJpaDao.save(employee);
        }
        clearInputs();
        loadTableItems();
    }
    
   private void removeEmployee(ActionEvent event){
       Employee employee=employeeTableView.getSelectionModel().getSelectedItem();
       
       if(employee!=null){
            EmployeeJpaDao employeeJpaDao=new EmployeeJpaDao();
            employeeJpaDao.delete(employee);
        }
        loadTableItems();
    }
    
    private void loadTableItems(){
        employees=FXCollections.observableArrayList(new EmployeeJpaDao().getAll());
        employees.remove(Controller.instance().getLoggedEmployee());
        employeeTableView.setItems(employees);
    }
    
    private void clearInputs(){
        usernameInput.clear();
        passwordInput.clear();
        nameInput.clear();
        surnameInput.clear();
    }
}
