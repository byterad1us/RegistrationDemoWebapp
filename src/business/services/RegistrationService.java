/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.services;

import form.beans.UserData;
import org.apache.commons.lang.StringUtils;

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
    
}
