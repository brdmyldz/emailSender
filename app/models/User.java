/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


import javax.persistence.*;
import play.db.jpa.Model;

/**
 *
 * @author berdem
 */
@Entity
public class User extends Model {
    
    public String email;
    public String password;
    public Integer alertTime;
    
    public User(String email, String password, Integer alertTime) {
        this.email = email;
        this.password = password;
        this.alertTime = alertTime;
    }
}
