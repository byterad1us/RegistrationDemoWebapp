/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

/**
 *
 * @author prime
 */
public class HttpRequestParseingException extends Exception {

    public HttpRequestParseingException(String msg) {
        super(msg);
    }
    
    
    public HttpRequestParseingException(Throwable cause, String msg){
         super(msg,cause);
    }
    
    public HttpRequestParseingException(){
      super();
    }
    
}
