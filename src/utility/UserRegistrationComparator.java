/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import form.beans.UserRegistration;
import java.util.Comparator;

/**
 *
 * @author ouvre
 */
public class UserRegistrationComparator implements Comparator<UserRegistration>{

    @Override
    public int compare(UserRegistration o1, UserRegistration o2) {
        if(o1 == o2)
            return 0;
        if(o1 == null)
             return 1;
        if(o2 == null)
            return -1;
        SmartDate regDate1 = o1.getRegDate();
        SmartDate regDate2 = o2.getRegDate();
        if(regDate1 == null)
            return 1;
        return -1 * regDate1.compareTo(regDate2);
    }
    
}
