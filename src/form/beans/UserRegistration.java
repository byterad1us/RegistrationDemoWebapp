/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package form.beans;

import utility.SmartDate;

/**
 *
 * @author ouvre
 */
public class UserRegistration {
    
    private UserData user;
    private SmartDate regDate;
    

    public UserRegistration() {
    }

    public UserRegistration(UserData user) {
        this.user = user;
        this.regDate = new SmartDate(); //captures NOW as date
    }
    
    

    public UserRegistration(UserData user, SmartDate regDate) {
        this.user = user;
        this.regDate = regDate;
    }

    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }

    public SmartDate getRegDate() {
        return regDate;
    }

    public void setRegDate(SmartDate regDate) {
        this.regDate = regDate;
    }
    
    
    
}
