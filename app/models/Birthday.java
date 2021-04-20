/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import play.db.jpa.Model;
import play.mvc.Scope;

/**
 *
 * @author berdem
 */
@Entity
public class Birthday extends Model {

    public static List<Birthday> findall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String fullname;
    public Date birthday;
    public String email;
    
    public Birthday(String fullname, Date birthday, String email) {
        this.fullname = fullname;
        this.birthday = birthday;
        this.email = email;
    }  
}
