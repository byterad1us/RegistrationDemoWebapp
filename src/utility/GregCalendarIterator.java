/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utility;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author bsisk
 */
public class GregCalendarIterator {

    private GregorianCalendar calendar;
    private long startEpoch;
    private int interval;
    private GregorianCalendar lateLimit;
    private java.util.Date prevDate;

    public GregCalendarIterator(){
       calendar = new GregorianCalendar();  //is now set to the current time
       startEpoch = calendar.getTimeInMillis();
       interval= Calendar.DAY_OF_YEAR;  ///the default
       this.lateLimit = null;
       this.prevDate= calendar.getTime();
    }

    public GregCalendarIterator(java.util.Date instant,int interval){
      this();
      this.calendar.setTime(instant);
      startEpoch= instant.getTime();
      this.interval = interval;
      this.prevDate=this.calendar.getTime();
    }   

    public void setInterval(int unit){
      this.interval = unit;
    }

    public Calendar getCalendarMember(){
      return this.calendar;
    }

    
    public void init(java.util.Date inst){
      this.calendar.setTime(inst);
      this.prevDate= inst;
    }
    
    
    public void init(long inst){
      this.calendar.setTimeInMillis(inst);
      this.prevDate = new java.util.Date(inst);
    }

    public void setLatest(java.util.Date latest){
      this.lateLimit= new GregorianCalendar();
      this.lateLimit.setTime(latest);
     
    }


    public java.util.Date peekNextUtilDate(){
       Calendar peekAhead = new GregorianCalendar();
       peekAhead.setTime(this.calendar.getTime());  ///initialize it to this Iterator's time
       peekAhead.add(interval, 1);   ///only mutate the copy, not this.calendar
       return peekAhead.getTime();
    }

    public java.util.Date nextAsDate() throws Exception{
            java.util.Date retval = this.calendar.getTime();
            this.prevDate= retval;//store the date before advancing, for later use
            this.calendar.add(interval,1);  //we make sure to advance it AFTER we have saved present value in retval. Advanced for next time
            return retval;
    }


    public long nextAsEpoch() throws Exception{
      java.util.Date nextDate= this.nextAsDate();
      return nextDate.getTime();
    }

    public boolean hasNext(){   
       return ( this.lateLimit == null ||(!(this.calendar.getTime().after(this.lateLimit.getTime()))));  ///true if there is no upper limit or if it is later than the next value
    }


    public boolean candidateInCurrentInterval(java.util.Date candt){
      System.out.println("Comparing this: "+this.prevDate+" to candidate: "+candt);
      if(candt == null)
            return false;
      Calendar lastThis= new GregorianCalendar();
      lastThis.setTime(this.prevDate);
      Calendar candCalendar = new GregorianCalendar();
      candCalendar.setTime(candt);
      if(! (candCalendar.get(Calendar.YEAR) == lastThis.get(Calendar.YEAR)))
                    return false;
      System.out.println("this's month is "+lastThis.get(Calendar.MONTH)+" and candidates is: "+candCalendar.get(Calendar.MONTH));
      if(!(candCalendar.get(Calendar.MONTH) == lastThis.get(Calendar.MONTH)))
                    return false;
       System.out.println("this's doy is: "+lastThis.get(Calendar.DAY_OF_YEAR)+ " and candidates is:"+candCalendar.get(Calendar.DAY_OF_YEAR));
       if(!(candCalendar.get(Calendar.DAY_OF_YEAR) == lastThis.get(Calendar.DAY_OF_YEAR)))
                    return false;   
       if(this.interval == Calendar.HOUR_OF_DAY){
            if(!(candCalendar.get(Calendar.HOUR_OF_DAY) == lastThis.get(Calendar.HOUR_OF_DAY)))
                    return false;       
       }
      ///otherwise, in either case:
      return true;
    }
    

}
