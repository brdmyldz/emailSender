/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobs;

import java.util.*;
import models.*;
import static org.joda.time.format.ISODateTimeFormat.date;
import play.jobs.*;


/**
 *
 * @author berdem
 */
/** Fire at 12am every day **/
@On("0 0 0 * * ?")
public class EmailScheduler extends Job {
    
    public void doJob() {
        List<Birthday> birthdayList = Birthday.findall();
        
        for(int i = 0; i < birthdayList.size(); ++i){
            Birthday bdObj = birthdayList.get(i);
            Date birthday = bdObj.birthday;
            String email = bdObj.email;
            Integer alert = User.find("byEmail", email).first();
            
            Calendar birthdayCal = Calendar.getInstance();
            birthdayCal.setTime(birthday);
            birthdayCal.add(Calendar.HOUR, -1 * alert);
            Date alertDate = birthdayCal.getTime();
            
            Date currentDate = new Date();
            Calendar currentCal = Calendar.getInstance();
            currentCal.setTime(currentDate);
            currentCal.add(Calendar.DATE, 1);
            Date nextDay = currentCal.getTime();
            
            if(alertDate.before(nextDay)){
                String fullname = bdObj.fullname;
                
                //Now create the time and schedule it
                Timer timer = new Timer();

                //Use this if you want to execute it once
                timer.schedule(new SendEmail(email, fullname), alertDate);
                bdObj.delete();
            }  
        }
    }  
}