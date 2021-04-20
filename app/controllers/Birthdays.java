/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.text.SimpleDateFormat;
import java.util.*;
import models.*;
import play.mvc.*;

/**
 *
 * @author berdem
 */
public class Birthdays extends Controller {
    
    public static void addBirthday(String fullname, Date birthday){
        String email = Scope.Session.current().get("username");
        Map <String, String> param = new HashMap <String, String> ();
        new Birthday(fullname, birthday, email).save();
        Scope.Flash.current().put("birthdaySuccess", "Birthday Alert Added!");
        redirect("Application.userPage", param);
    }
    
    public static void changeBirthday(Integer alert){
        Map <String, String> param = new HashMap <String, String> ();
        String email = Scope.Session.current().get("username");
        User user = User.find("byEmail", email).first();
        user.delete();
        new User(user.email, user.password, alert).save();
        Scope.Flash.current().put("alertSuccess", "Alert Changed!");
        redirect("Application.userPage", param);
    }
}
