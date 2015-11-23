/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.services;

/**
 *
 * @author ouvre
 */
public class RegistrationException extends Exception{

    public RegistrationException() {
    }

    public RegistrationException(String message) {
        super(message);
    }

    public RegistrationException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegistrationException(Throwable cause) {
        super(cause);
    }
    
}
