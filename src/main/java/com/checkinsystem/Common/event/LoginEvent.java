package com.checkinsystem.Common.event;

import com.checkinsystem.Common.Constants.Constants;
import com.checkinsystem.Common.Controller.Controller;

import com.checkinsystem.Privilege.Privilege;
import com.checkinsystem.Employee.Employee;
import com.checkinsystem.Common.gui.LoginView;
import com.checkinsystem.Employee.dao.EmployeeJpaDao;
import com.checkinsystem.admin.gui.AdminView;
import com.checkinsystem.Employee.gui.EmployeeView;
import com.checkinsystem.main.AccessPrivilege;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import org.apache.commons.codec.digest.DigestUtils;

public class LoginEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        LoginView loginView = Controller.instance().getLoginView();
        String username = loginView.getUsername();
        String password = DigestUtils.md5Hex(loginView.getPassword());
        if (username.isEmpty() || password.isEmpty()) {
            loginView.setLoginMessage(Constants.EMPTY_LOGIN_FIELDS_MESSAGE);
            return;
        }

        EmployeeJpaDao employeeJpaDao = new EmployeeJpaDao();
        Employee employee = employeeJpaDao.login(username, password);
        Controller.instance().setLoggedEmployee(employee);
        if (employee == null) {
            loginView.setLoginMessage(Constants.BAD_USERNAME_AND_PASSWORD_COMBINATION);
            return;
        }
        Controller.instance().setLoggedEmployee(employee);
        Privilege employeePrivilege = employee.getIdPrivilege();
        BorderPane view;
        if ("admin".equals(employeePrivilege.getName())) {
            view = new AdminView();
            Controller.instance().setAdminView((AdminView) view);
            Controller.instance().getPrimaryStage().setTitle("Admin panel from user: " + employee.getName());
        } else if (AccessPrivilege.EMPLOYEE.getId() == employeePrivilege.getId()) {
            view = new EmployeeView();
            Controller.instance().setEmployeeView((EmployeeView) view);
            Controller.instance().getPrimaryStage().setTitle("Employee panel from user: " + employee.getName());
        } else {
            view = new EmployeeView();
            Controller.instance().setEmployeeView((EmployeeView) view);
            Controller.instance().getPrimaryStage().setTitle("Employee panel from user: " + employee.getName());
        }

        Scene scene = new Scene(view, 650, 300);
        Controller.instance().getPrimaryStage().setScene(scene);
    }

}
