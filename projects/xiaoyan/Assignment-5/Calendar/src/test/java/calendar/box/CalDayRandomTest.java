package calendar;
import org.junit.Test;
import java.util.Calendar;
import java.util.Random;
import calendar.Appt;
import calendar.CalDay;
import java.util.*;
import static org.junit.Assert.*;



public class CalDayRandomTest {

	/**

	 * Generate Random Tests that tests CalDay Class.

	 */



	private static final long TestTimeout = 15 * 500 * 1;



	@Test

	  public void randomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
 		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
 		 System.out.println("Start testing...");
         // lmao, same setup as the example


 		try{
 			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis(); //10
				Random random = new Random(randomseed);		

		  		int startHour=ValuesGenerator.getRandomIntBetween(random, -1, 24);
		  		int startMinute=ValuesGenerator.getRandomIntBetween(random, -1, 60);
		  		int startDay=ValuesGenerator.getRandomIntBetween(random, 0, 32);
		  		int startMonth=ValuesGenerator.getRandomIntBetween(random, 0, 13);
		  		int startYear=ValuesGenerator.getRandomIntBetween(random, -100, 2018);
          // still the same as the example 


          // doing real things that makes real differences, all of the things are the same, besides the starthour and startMinute
		  		GregorianCalendar someday = new GregorianCalendar(startYear, startMonth, startDay);
	      		CalDay the_day = new CalDay(someday);

	      		Appt zero = new Appt(startHour, startMinute, startDay, startMonth, startYear, "M0", "This is zero", "m0@gmail.com");

		  		startHour=ValuesGenerator.getRandomIntBetween(random, -1, 24);
		  		startMinute=ValuesGenerator.getRandomIntBetween(random, -1, 60);
		  		Appt one = new Appt(startHour, startMinute, startDay, startMonth, startYear, "M1", "This is one", "m1@gmail.com");

		  		startHour=ValuesGenerator.getRandomIntBetween(random, -1, 24);
		  		startMinute=ValuesGenerator.getRandomIntBetween(random, -1, 60);
		  		Appt two = new Appt(startHour, startMinute, startDay, startMonth, startYear, "M2", "This is two", "m2@gmail.com");

		  		zero.setValid();
		  		one.setValid();
		  		two.setValid();
		  		the_day.addAppt(zero);
	      		the_day.addAppt(one);
		  		the_day.addAppt(two);


				//show elapsed time
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			   	if((iteration%10000)==0 && iteration!=0 )
				System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			}
		}catch(NullPointerException e){
		}
		System.out.println("Done testing...");
 	}


	
}
