/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP
 */
@ManagedBean
@SessionScoped
public class Login {
    private static final long serailVersionUID = 1094801825228386363L;
    private String msg;
    private String pwd;
    private String email;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
  /*  public String validateUser(){
     boolean valid 
             
           if(valid){
             HttpSession session = SessionUtils.getSession();
             session.setAttribute("username",email);
             return "";
           } else{
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Incorrect username or password"));
             return "login";
           }
    }
}*/
}