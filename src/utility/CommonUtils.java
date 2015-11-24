package utility;
    

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;








public class CommonUtils {
	
	public static boolean isNullOrEmptyString(String s){
		if(s == null)
			return true;
		s.trim();
		return (s.isEmpty());
	}
	
           
        
	public static boolean isInvalidId(Object identifier){
		if(identifier == null)
			return true;
		if(! (   (identifier instanceof Long) || (identifier instanceof Integer)  ))	
                         return true;
                if(identifier instanceof Long){
                  long longval = ((Long)identifier).longValue();
                 return (longval < 1L);
                }
               if(identifier instanceof Integer){
                   int intval = ((Integer)identifier).intValue();
                  return (intval < 1);
               }
            return false;   //not an Integer or Long   
	}
        
     public static boolean isNonIntegral(Object o){
       if(o == null)
           return true;
       return (!(o instanceof Long || o instanceof Integer));
     }   
        
    public static boolean isNaN(Object o){
      if(o == null)
          return true;
      return (!(o instanceof Number));
    }   
        
      public static boolean isValidAndOfType(Object candidate, Class type){
         if(candidate == null)
               return false;
         return (type.isInstance(candidate));
      }
      
      
	
	public static boolean anyEmptyString(List<String> list){
		if(list == null)
			 return true;
		if(list.isEmpty())
			return false;
		for(String str:list){    
			if( CommonUtils.isNullOrEmptyString(str))
				  return true;
		   }//end loop iteration...
		return false;
	}
	
	
	public static Collection toDistinctCollection(Collection original){
		Collection retval;
		if(original == null)
			 return null;
		retval = new ArrayList();
		HashSet unifier = new HashSet();
		unifier.addAll(original);
		retval.addAll(unifier);
		return retval;
	}
	
	
	public static boolean isNullOrEmptyCollection(Collection c){
		return (c == null || c.isEmpty());
	}
	
		public static boolean isNullOrEmptyMap(Map m){
		return (m == null || m.isEmpty());
	}
	
	
	public static boolean isNullOrEmptyArray(Object[] array){
		if(array == null)
			return true;
		return (array.length == 0);
	}
	
	public static void nullFilter(Object o, String msg) throws Exception{
			 String xmessage = (msg == null)? ("Object "+o+" is null."):msg;
			 if(o == null) 
		          throw new Exception(xmessage);
	}
	
	
	
	public static java.sql.Timestamp getCurrentTimestamp(){
		return new java.sql.Timestamp(getCurrentEpochTimeMillis());
	}
	
	
	
	public static long getCurrentEpochTimeMillis(){
		
		return new java.util.Date().getTime();
	}
	
	
	
	
	   
	public static boolean stringContainsPattern(String subject,String regexPttrn) throws Exception{
		if(regexPttrn == null)
			  throw new Exception("a null regex pattern was passed in the call to CommonUtils.stringContainsPattern()");
		if(subject == null)
			  throw new Exception("a subject String was not provided in the call to CommonUtils.stringContainsPattern(). First argument was null!");
		Pattern p = null;
		Matcher m = null;
		try{
			p = Pattern.compile(regexPttrn);
			if(p == null)
				throw new Exception("java.util.regex.Pattern compilation failed for pattern "+regexPttrn);
		   }
		catch(Exception x){ throw new Exception("Unable to compile the Regex pattern "+regexPttrn+" inside body of CommonUtils.stringContainsPattern()",x);}
		  m = p.matcher(subject);
		  return m.find();
	}//method
	
	
	public static boolean validateStringAgainstPattern(String subject,String pattern) throws Exception{
		boolean valid=false;
	    try{
	    	 valid = subject.matches(pattern);  
	       }
	    catch(Exception x){ throw new Exception(x);}
	    return valid;
	}
	
	
	public static boolean valueInRange(String value,String[] range){
		 if(range == null || range.length == 0)
			  return false;
		 for(String rarg:range){
			 if(rarg == null && value == null)
				   return true;
			 if(rarg.equals(value))
				  return true;
		 }
	  return false; 
	}
	
	
	public static boolean valueInRange(Object value,Object[] range){
		if(value == null)
			return false;
		if(range == null || range.length == 0)
			return false;
		List rangeList = Arrays.asList(range);
		return rangeList.contains(value);
	}
		
	
 public static boolean valueInRange(Number value,Number[] range){
		if(range == null || range.length == 0)
			  return false;
		 for(Number narg:range){
			 if(narg == null && value == null)
				   return true;
			 if(narg.equals(value))
				  return true;
		 }
	  return false; 
	}
	
	   
	public static void putCommonValueToMapKeys(Object common,List<String> keys,Map m){
		if(m == null || keys == null || keys.size() == 0)
			return;
		for(String key:keys){
			m.put(key, common);
		}
	}
	
	   
	 public static String readReqParamString(String paramName,HttpServletRequest req,boolean required) throws Exception{
		  String paramVal= req.getParameter(paramName);
		  if(required && isNullOrEmptyString(paramVal))
			    throw new Exception("There was a Required Parameter missing from the Request: "+paramName);
		 return paramVal;
	  }
	  
	  
	  public static Integer readReqParamInt(String paramName,HttpServletRequest req,boolean required) throws Exception{
		  String paramVal = req.getParameter(paramName);
		  Integer rcvr=null;
		  try{
			    rcvr = new Integer(paramVal);  
		     }
		  catch(Exception x){
			    if(required)
			    	throw new Exception("A Required parameter was either missing, null, or invalid on the Request: "+paramName+": "+paramVal);
			  }
		   if(rcvr == null && required)
			   throw new Exception("A Required parameter was missing from the request: "+paramName);
		   return rcvr;
	  }


       public static boolean isNullOrEmptySB(StringBuffer sb){
          return (sb == null || (sb.length() == 0));
       }
	
	public static java.sql.Date utilDatetoSqlDate(java.util.Date indt){
		if(indt == null)
			return null;
		return new java.sql.Date(indt.getTime());
	}
	
	
	public static java.util.Date sqlDateToUtilDate(java.sql.Date indt){
		if(indt == null)
			return null;
		return new java.util.Date(indt.getTime());
	}
	
	public static boolean nullFilterLot(Object... objects) {
		for(Object o:objects){
			if(o == null)
				return true;
		}//end loop
	 return false;
	}
        
        
       public static <T> T[] arrayMaker(T... ts){
         List<T> asList= (List<T>)Arrays.asList(ts);
         return (T[]) asList.toArray(ts);
       } 
        
        
        
        public static Map<String,Object> mapCopyAllBut(Map<String,Object> srcMap,String... lvouts){
          if(srcMap == null)
                return null;
          HashMap<String,Object> retval = new HashMap<String,Object>();
          if(srcMap.isEmpty())
              return retval;
          for(String key: srcMap.keySet()){
             if(key == null)
                  continue;
             if(CommonUtils.valueInRange(key,lvouts))
                  continue;
             Object srcVal = srcMap.get(key);
             retval.put(key.toString(), srcVal);
          }///end iteration. Populated.
        return retval;
       }//method

    public static List<String> parseStringSequence(String paramName,String csvSequence) throws RequestParameterException{
        if(CommonUtils.isNullOrEmptyString(csvSequence))
               throw new RequestParameterException("null or empty "+paramName+" parameter value detected");
        csvSequence = csvSequence.trim();
        String[] pieces = csvSequence.split(",");
        if(CommonUtils.isNullOrEmptyArray(pieces))
              throw new RequestParameterException("Improper CSV syntax used for param '"+paramName+"': '"+csvSequence+"'. Each term should be separated by 1 comma (,) without spaces");
        return (List<String>)Arrays.asList(pieces);
    }

    
    public static Long extractLongParam(HttpServletRequest request, String name, boolean mandatory) throws RequestParameterException{
        String paramVal = request.getParameter(name);
        if(CommonUtils.isNullOrEmptyString(paramVal)){
           if(mandatory)
               throw new RequestParameterException("the required param "+name+" was missing.");
           else
               return null;
        }
        Long longval = null;
        try{
              longval = Long.parseLong(paramVal);
           }
        catch(Exception x){
           longval = null;
        }
        
      if(mandatory && (longval == null))
                    throw new RequestParameterException("The "+name+" value "+paramVal+" is invalid.");
      return longval;
        
    }
    
    
   
    public static Integer extractIntParam(HttpServletRequest request, String name, boolean mandatory) throws RequestParameterException{
        String paramVal = request.getParameter(name);
        if(CommonUtils.isNullOrEmptyString(paramVal)){
           if(mandatory)
               throw new RequestParameterException("the required param "+name+" was missing.");
           else
               return null;
        }
        Integer ntval = null;
        try{
              ntval = Integer.parseInt(paramVal);
           }
        catch(Exception x){
           ntval = null;
        }
        
      if(mandatory && (ntval == null))
                    throw new RequestParameterException("The "+name+" value "+paramVal+" is invalid.");
      return ntval;
        
    }

    
    
    public static String joinArrayValues(String[] arrayVals, String delimiter) {
       if(isNullOrEmptyArray(arrayVals))
             return "";
       String retval = "";
       boolean gotFirst=false;
       for(String val:arrayVals){
           if(gotFirst)
                 retval+=delimiter;
           retval+=val;
       }
      return retval;
    }

    
    
    
   
	

}
