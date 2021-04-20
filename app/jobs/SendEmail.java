/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobs;

import java.util.TimerTask;
import org.apache.commons.mail.SimpleEmail;
import play.libs.Mail;

/**
 *
 * @author berdem
 */
public class SendEmail extends TimerTask{
    
    String from = "sender@gmail.com";
    String to;
    String fullname;
    String subject = fullname + "'s Birthday!";
    String message = "This is an Alert to remind you " + fullname + "'s birthday!";
    
    public SendEmail(String to, String fullname){
        this.to = to;
        this.fullname = fullname;
    }
    
    public void run(){
        SimpleEmail sendEmail = new SimpleEmail();
        try{
            sendEmail.setFrom(from);
            sendEmail.addTo(to);
            sendEmail.setSubject(subject);
            sendEmail.setMsg(message);
            Mail.send(sendEmail);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
