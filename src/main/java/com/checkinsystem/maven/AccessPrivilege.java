package com.checkinsystem.maven;

import com.checkinsystem.Privilege.Privilege;
import com.checkinsystem.admin.gui.AdminView;
import com.checkinsystem.Employee.gui.EmployeeView;
import javafx.scene.layout.Pane;

public enum AccessPrivilege {
    ADMIN(1,"admin", new AdminView()),
    EMPLOYEE(2,"user", new EmployeeView());
    
    private final int id;
    private final String name;
    private final Pane layoutPane;
   
    
    private AccessPrivilege(int id, String name, Pane layoutPane){
        this.id=id;
        this.name=name;
        this.layoutPane=layoutPane;
    }
    
    public Pane getLayoutPane(){
        return layoutPane;
    }
    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public static Pane getLayout(Privilege privilege){
        AccessPrivilege[] accessPrivileges=AccessPrivilege.values();
        for(AccessPrivilege accessPrivilege: accessPrivileges){
            if(accessPrivilege.id==privilege.getId()){
                return accessPrivilege.layoutPane;
            }
        }
        return new EmployeeView();
    }
}
