package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(Secure.class)
public class Application extends Controller {
    
    public static void userPage() {
        String username = Scope.Session.current().get("username");
        List <Birthday> birthdays = Birthday.find("byEmail", username).fetch();
        User user = User.find("byEmail", username).first();
        render(birthdays, user);
    }
}