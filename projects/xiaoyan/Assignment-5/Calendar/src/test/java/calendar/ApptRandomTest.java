package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur 
        }	
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur 
        }	
   /**
     * Generate Random Tests that tests Appt Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");
		 
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				
				 int startHour=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 String emailAddress="xyz@gmail.com";

				 //Construct a new Appointment object with the initial data	 
				 //Construct a new Appointment object with the initial data	 
		         Appt appt = new Appt(startHour,
		                  startMinute ,
		                  startDay ,
		                  startMonth ,
		                  startYear ,
		                  title,
		                 description,
		                 emailAddress);

			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);						   
						}
					   else if (methodName.equals("setRecurrence")){
						   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);

				// random the description
				int flag_one = ValuesGenerator.getRandomIntBetween(random, 0, 1);
				if( flag_one==1 ){
					recurDays = null;
				}

						   int recur=ApptRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						}				
				}
				
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
		}catch(NullPointerException e){
			
		}
	 
		 System.out.println("Done testing...");
	 }


	


@Test
public void randomtest_lmao()  throws Throwable  {

     // Same setup as the example
	 long startTime = Calendar.getInstance().getTimeInMillis();
	 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

	 System.out.println("Start testing...");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
				Random random = new Random(randomseed);

				 int startHour=ValuesGenerator.getRandomIntBetween(random, 1, 23);
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, 1, 59);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 28);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 10);
				 int startYear=ValuesGenerator.getRandomIntBetween(random, 1000, 2018);
				 String title="lmao";
				 String description="reallylmao";
				 String emailAddress="myaddress@.com";
				 // the above variavle decleratoin is the same as the example


				 //Construct a new Appointment object with the initial data
				 //Construct a new Appointment object with the initial data

				// random the description
				int flag_one = ValuesGenerator.getRandomIntBetween(random, 0, 1);
				if( flag_one==1 ){
					description = null;
				}

				

				 Appt appt = new Appt(startHour,startMinute ,startDay , startMonth ,startYear ,title,description, emailAddress);


				 appt.setValid();
				// so the setValid() sets the variable valid to either true or false

				//Check isOn for new appointment

				appt.isOn(startDay, startMonth, startYear);
				//Get new dates and check
				int on_day=ValuesGenerator.getRandomIntBetween(random, 0, 28);
				int on_month=ValuesGenerator.getRandomIntBetween(random, 1, 10);
				int on_year=ValuesGenerator.getRandomIntBetween(random, 1000, 2018);
				appt.isOn(on_month, on_day, on_year);


				// checking time
				// includes bad month,day,start_hour,start_min,start_years.
				boolean check;

				if (startMonth < 1 || startMonth > 12) 
					check = false;
				else if (startHour < 0 || startHour > 23) 
					check = false;
				else if (startMinute < 0 || startMinute > 59)
					check = false;
				else if (startYear <= 0)
					check = false;
				else {
					// some of the months has more days, some of them has less
					int NumDaysInMonth = CalendarUtil.NumDaysInMonth(startYear, startMonth - 1);

					if (startDay < 1 || startDay > NumDaysInMonth)
						check = false;
					else
						check = true;
				}
				assertEquals(appt.getValid(), check); // like always, assertequal !

        		String half = "am";
				if( startHour >11 ){ half = "pm"; }
				
       			int printableHour = startHour;
        		if (printableHour > 11)
       			  {
            		printableHour -= 12;
        		  }
        		if (printableHour == 0)
        		  {
            		printableHour = 12;
        		  }
                String represntationApp= printableHour +":"+ startMinute + half;

				if(description == null){ description = ""; }

				String compare_string = "\t"+startMonth+"/"+startDay+"/"+startYear + " at " + represntationApp
				                        + " ," + title +", "+ description + "\n";
				String the_real_string = appt.toString();

				boolean flag_four = !appt.getValid();

				if(flag_four){ compare_string = "\tThis appointment is not valid"; }

					assertEquals( compare_string , the_real_string);
					assertTrue( appt.hasTimeSet() );

				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			     if((iteration%10000)==0 && iteration!=0 )
			     System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			}

		}catch(NullPointerException e){

		}
			System.out.println("Done testing...");
	 }


//    for NO_TIME at start min and start hr
@Test
public void randomtest_lmao_xd()  throws Throwable  {

     // Same setup as the example
	 long startTime = Calendar.getInstance().getTimeInMillis();
	 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

	 System.out.println("Start testing...");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
				Random random = new Random(randomseed);

				 int startHour=ValuesGenerator.getRandomIntBetween(random, 1, 23);
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, 1, 59);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 28);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 10);
				 int startYear=ValuesGenerator.getRandomIntBetween(random, 1000, 2018);
				 String title="lmao";
				 String description="reallylmao";
				 String emailAddress="myaddress@.com";
				 // the above variavle decleratoin is the same as the example


				 //Construct a new Appointment object with the initial data
				 //Construct a new Appointment object with the initial data

				 Appt appt = new Appt(startDay , startMonth ,startYear ,title,description, emailAddress);


				 appt.setValid();
				// so the setValid() sets the variable valid to either true or false

				assertFalse( appt.hasTimeSet() );
	
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			     if((iteration%10000)==0 && iteration!=0 )
			     System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			}

		}catch(NullPointerException e){

		}
			System.out.println("Done testing...");
	 }





	
}
