/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

/**
 *
 * @author prime
 */
public class RequestParameterException extends Exception {

    public RequestParameterException(String string) {
          super(string);
    }
    
    
    public RequestParameterException(Throwable cause){
        super(cause);
    }
    
    
    public RequestParameterException(String msg,Throwable cause){
         super(msg,cause);
    }
    
}
