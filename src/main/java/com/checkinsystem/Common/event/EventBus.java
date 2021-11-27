package com.checkinsystem.Common.event;

public class EventBus {
    private final LoginEvent loginEvent=new LoginEvent();
    private final LogoutEvent logoutEvent=new LogoutEvent();
    private final SignUpEvent signUpEvent=new SignUpEvent();
    
    public LoginEvent getLoginEvent(){
        return loginEvent;
    }
    
    public LogoutEvent getLogoutEvent(){
        return logoutEvent;
    }
    
    public SignUpEvent getSignUpEvent(){
        return signUpEvent;
    }

}
