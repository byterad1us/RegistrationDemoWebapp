/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import utility.CommonUtils;
import utility.SmartDate;
import utility.UserRegistrationComparator;
import form.beans.UserData;
import form.beans.UserRegistration;

/**
 *
 * @author ouvre
 */
public class RegistrationService {
    
    public RegistrationService(){}
    
    
    private void validateUserData(UserData ud) throws ValidationException{
        if(StringUtils.isBlank(ud.getFirstName()))
            throw new ValidationException("Must provide firstName");
        if(StringUtils.isBlank(ud.getLastName()))
            throw new ValidationException("Must provide lastName");
        if(StringUtils.isBlank(ud.getAddress1()) && (StringUtils.isBlank(ud.getAddress2())))
            throw new ValidationException("Must provide an address");
        if(StringUtils.isBlank(ud.getCity()))
            throw new ValidationException("Must provide a city");
        if(StringUtils.isBlank(ud.getState()))
            throw new ValidationException("Must provide a state");
        if(ud.getState().length() > 3)
            throw new ValidationException("You must use the 2-3 letter State abbreviation");
        if(StringUtils.isBlank(ud.getCountry()))
            throw new ValidationException("Must provide a country");
    
    }
    
    public String registerNewUser(UserData data) throws Exception{
        if(data == null)
            throw new RegistrationException("the POSTED UserData could not be read.");
        validateUserData(data);
        /** 
         * here, you would save the UserData object to Some DB, 
         * if you owned a DBMS on the web. I Dont currently have or  pay for a server-hosted DB of my own. 
         * Why would I?
         */
        return generateRandomUserId(data.getFirstName());
    }

    
    private String generateRandomUserId(String base) {
        return "user-"+base+System.currentTimeMillis();
    }

   public List<UserRegistration> getDateSortedRegisteredUsers(UserData sessionUser, int resultsLimit) throws Exception{
        /** Here, we must Code-Around connecting to a DB with some DAO or Delegate,
         *  Because THERE IS NO DATABASE!!  NO DB SERVER HAS BEEN PROVIDED.  ONCE A REAL DB IS PROVIDED,
         *  CODE CAN BE WRITTEN TO QUERY IT FOR REAL DATA.
         */
       //TEMPORARY STANDIN CODE, BECAUSE NO DB HAS BEEN PROVIDED, AND I DONT OWN A DB SERVER
       Map<String,String[]> defaultUserData = new HashMap<String,String[]>();
       defaultUserData.put("first_name",CommonUtils.arrayMaker("Homer"));
       defaultUserData.put("last_name",CommonUtils.arrayMaker("Simpson"));
       defaultUserData.put("address1",CommonUtils.arrayMaker("433 Evergreen Terrace"));
       defaultUserData.put("address2", null);
       defaultUserData.put("city",CommonUtils.arrayMaker("Springfield"));
       defaultUserData.put("state",CommonUtils.arrayMaker("IL"));
       defaultUserData.put("zip",CommonUtils.arrayMaker("90921"));
       defaultUserData.put("country",CommonUtils.arrayMaker("USA"));
       
       UserData ud = new UserData(defaultUserData);
       
       List<UserRegistration> registrations = new ArrayList<UserRegistration>();
       registrations.add(new UserRegistration(ud, new SmartDate("yyyy-MM-dd","2013-01-20")));
       defaultUserData.put("first_name",CommonUtils.arrayMaker("Marge"));
       UserData ud2 = new UserData(defaultUserData);
       registrations.add(new UserRegistration(ud2,new SmartDate("yyyy-MM-dd","2015-10-04")));
       defaultUserData.put("first_name", CommonUtils.arrayMaker("Lisa"));
       UserData ud3 = new UserData(defaultUserData);
       registrations.add(new UserRegistration(ud3, new SmartDate("yyyy-MM-dd","2014-07-09")));
       if(sessionUser != null)
           registrations.add(new UserRegistration(sessionUser,new SmartDate("yyyy-MM-dd")));
       
       Collections.sort(registrations, new UserRegistrationComparator());
       return registrations;
    }
    
}
