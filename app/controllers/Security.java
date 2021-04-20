/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.*;
import models.User;
import static play.mvc.Controller.redirect;
import play.mvc.Scope;

/**
 *
 * @author berdem
 */
public class Security extends Secure.Security {
	
    static boolean authenticate(String username, String password) {
        User user = User.find("byEmail", username).first();
        if(user == null || user.password.compareTo(password) != 0){
            return false;
        }
        return true;
    }
    
    
    public static void signup(String email, String password){
        User user = User.find("byEmail", email).first();
        Map <String, String> param = new HashMap <String, String> ();
        if(user != null){
            Scope.Flash.current().put("signupError", "error test");
            redirect("Secure.login", param);
        }
        new User(email, password, 0).save();
        Scope.Flash.current().put("signupSuccess", "success test");
        redirect("Secure.login", param);
        

    }
    
    public static void logout(){
        Map <String, String> param = new HashMap <String, String> ();
        redirect("Secure.logout", param);
    }
    
}
