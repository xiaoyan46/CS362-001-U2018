package calendar;
import java.util.Calendar;
import java.util.Random;
import org.junit.Test;
import java.util.Random;
import calendar.Appt;
import calendar.CalDay;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import java.util.*;
import java.io.*;
import java.lang.reflect.*;
import static org.junit.Assert.*;

/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {
	 private static final long TestTimeout = 60 * 500 * 1;

//clean up !
  @Before
    public void setUp() {
         File testfile = new File("new_file.xml");
         testfile.delete();
    }

//clean up !
  @After
    public void tearDown() {
         File testfile = new File("new_file.xml");
         testfile.delete();
    }

// The core of the test
  @Test
    public void randomtest()  throws Throwable  {

		long startTime = Calendar.getInstance().getTimeInMillis();
        long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

     	System.out.println("Start testing...");


	    for (int iteration = 0; elapsed < TestTimeout; iteration++) {
			  try{
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////// randon generation for all necessary datas ///////////////////////////////////////////////////
				 long randomseed =System.currentTimeMillis(); //10
 				 Random random = new Random(randomseed);

				 //random the autosave setting   50% by 50%
				 boolean save_flag=ValuesGenerator.getBoolean(.50f, random);

				 //random min,hr,year for the start
 				 int start_day=ValuesGenerator.getRandomIntBetween(random, 0, 32);
 				 int start_month=ValuesGenerator.getRandomIntBetween(random, 0, 13);
 				 int start_year=ValuesGenerator.getRandomIntBetween(random, 2048, 2049);

				 //random min,hr,year for the end
 				 int end_day=ValuesGenerator.getRandomIntBetween(random, 0, 32);
 				 int end_month=ValuesGenerator.getRandomIntBetween(random, 0, 13);
 				 int end_year=ValuesGenerator.getRandomIntBetween(random, 2049, 2050);

				 //random number of appointments
				 int number_of_appts=ValuesGenerator.getRandomIntBetween(random, 0, 10);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////

				 //setup the random firstday and lastday with the corresponding day/month/year information
				 DataHandler the_big_day = new DataHandler("new_file.xml", save_flag);
				 GregorianCalendar firstday = new GregorianCalendar(start_year, start_month, start_day);
				 GregorianCalendar lastday = new GregorianCalendar(end_year, end_month, end_day);

				 //random number of appointments with random recurrence
				 while(number_of_appts > 0){
					//each appointment is at a random time
					int appt_hr=ValuesGenerator.getRandomIntBetween(random, -1, 24);
					int appt_min=ValuesGenerator.getRandomIntBetween(random, -1, 60);
					int appt_day=ValuesGenerator.getRandomIntBetween(random, 0, 32);
					int appt_month=ValuesGenerator.getRandomIntBetween(random, 0, 13);
					int appt_year=ValuesGenerator.getRandomIntBetween(random, 2018, 2020);

					Appt the_appt_object = new Appt(appt_hr, appt_min, appt_day, appt_month, appt_year, "W", "W1", "W1@google.com");

					//recurrence

					int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
					int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
					int recur=ApptRandomTest.RandomSelectRecur(random);
					int recurIncrement = ValuesGenerator.RandInt(random);
					int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
					the_appt_object.setRecurrence(recurDays, recur, recurIncrement, recurNumber);

				 	the_appt_object.setValid();

					//only save 50% of the appointments

					if(ValuesGenerator.getBoolean(.50f, random)) {
				 		the_big_day.saveAppt(the_appt_object);
					}

					//delete 50% of the appointments
					if(ValuesGenerator.getBoolean(.50f, random)) {
						the_big_day.deleteAppt(the_appt_object);
					}
					number_of_appts--;
			 	 }

				 //getApptRange test
				 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
				 calDays = (LinkedList<CalDay>) the_big_day.getApptRange(firstday, lastday);

				 // things below are exact the same as the example
				 //show elapsed time
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				 if(iteration!=0)
					 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
	 			}catch(DateOutOfRangeException e){

	 			}
			 }
			 System.out.println("Done testing...");
		 }
}