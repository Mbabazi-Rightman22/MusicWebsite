/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import domain.User;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.primefaces.model.file.UploadedFile;



/**
 *
 * @author HP
 */
@ManagedBean(name="UsrM")
public class UserModel {
    private String url = "http://192.168.43.14:8081/BlueMusic/webresources/users";
   
    public UserModel() {
    }
    
    private User user=new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    public List<User> getAll(){
        GenericType<List<User>> list=new GenericType<List<User>>(){};
     List<User> users = ClientBuilder.newClient().target(url).request(MediaType.APPLICATION_JSON).get(list);
      
      if(!users.isEmpty()){
          System.out.println("result");
      }
      return  users;
    }
    
    public String create(){
     ClientBuilder.newClient().target(url).request().post(Entity.json(user));
     return "login.xhtml";
    }
     public String update(int id){
     ClientBuilder.newClient().target(url+"/"+id).request().put(Entity.json(user));
     return "userList.xhtml";
    }
      public String delete(int id){
     ClientBuilder.newClient().target(url+"/"+id).request().delete(User.class);
     return "userList.xhtml";
    }
      
       
}
