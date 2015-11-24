package utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SmartDate {
	
	public static String defaultFormatPattern = "yyyy-MM-dd";
	
	
	private java.util.Date value;
	private String formatPattern=null;
	
	
	public SmartDate(){      
		value = new java.util.Date();  ///zero-arg will default to the current date-time
		formatPattern = defaultFormatPattern;
	}
	
	
	public SmartDate(String pattern) throws Exception{
		this();
		this.setFormatPattern(pattern);
	}
        
        public SmartDate(String pattern, String valuestr) throws Exception{
          this(pattern);
          this.setValueFromString(valuestr);
        }
	
	
	public void setFormatPattern(String pttrn) throws Exception{
		String test = null;
		try
		{
			SimpleDateFormat testFormatter = new SimpleDateFormat(pttrn);
			test = testFormatter.format(new java.util.Date());
		}
		catch(Exception x){
			throw x;
		}
		this.formatPattern = pttrn;   
	}
	
	public java.util.Date getValue(){
		return this.value;
	}
	
	public java.sql.Date getSqlDate(){
		if(this.value == null)
			return null;
		return new java.sql.Date(this.value.getTime());
	}
	
	public java.util.Date setValue(java.util.Date nval){
		java.util.Date lastval = this.value;
		this.value = nval;
		return  lastval;
	}
	
	public void setValueFromString(String datestr) throws Exception{
		Date test = null;
		try{
			SimpleDateFormat testFormatter = new SimpleDateFormat(this.formatPattern);
			test = testFormatter.parse(datestr);
		   }
		catch(ParseException px){
			throw new Exception("SmartDate.setValueFromString() was unable to parse the date string argument "+datestr+" using its pattern "+this.formatPattern+". Does it match the pattern?");
		}
	   if(test != null)
		   this.setValue(test);
	}
	
	public String getUnformattedStr(){
		if(this.value == null)
			return "SmartDate: (null)";
		else
			return this.value.toString();
	}
	
	
	public String toString(){
		if(this.value == null)
			return "SmartDate: (null)";
		if(this.formatPattern == null)
			 return this.value.toString();
		String formattedStr=null;
		try{
			 SimpleDateFormat formatter = new SimpleDateFormat(this.formatPattern);
			 formattedStr = formatter.format(this.value);
		   }
		catch(Exception x){
			formattedStr = this.value.toString();  ///unformatted
		}
		return formattedStr;
		
	}

        
    int compareTo(SmartDate regDate2) {
      if(regDate2 == null)
          return 1;
      return getValue().compareTo(regDate2.getValue());
    }
    
}
