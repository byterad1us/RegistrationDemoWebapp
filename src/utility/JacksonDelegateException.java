package utility;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bsisk
 */


public class JacksonDelegateException extends Exception{
    
    public JacksonDelegateException(){
      super();
    }

    public JacksonDelegateException(String message){
        super(message);
    }

    public JacksonDelegateException(Exception x){
        super(x);
    }
    
    public JacksonDelegateException(String msg,Throwable cause){
      super(msg,cause);
    }

}
