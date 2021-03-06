package finalprojectB;
import java.util.Random;
import java.util.Arrays;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;





public class RandomTest {

/////////////////////////////////////////////////////////////////////////////////////
	
    // getRandomIntBetween
    public static int getRandomIntBetween(Random random, int min, int max) {
		
		long range       = (long)max - (long)min + 1;
		long fraction    = (long)(range * random.nextDouble());
	    int randomNumber = (int)(fraction + min); 
		return randomNumber;
	}

    // good Scheme
    public   String good_Scheme(int select){

              String the_string;

              switch(select){

              case 1: the_string = "http://"; break;
              case 2: the_string = "ftp://"; break;
              case 3: the_string = "https://"; break; // "h3t://"
              case 4: the_string = "http://"; break;
              default : the_string = "http://"; break;

          }
          return the_string;
       }

    // bad  Scheme
    public   String bad_Scheme(int select){
              String the_string;

              switch(select){

              case 1: the_string = "3ht://"; break;
              case 2: the_string = "ftp://"; break;
              case 3: the_string = "http:"; break; 
              case 4: the_string = "://"; break;
              default : the_string = "://"; break;

          }
          return the_string;

       }

    // good Authority
    public   String good_Authority(int select){
              String the_string;

              switch(select){

              case 1: the_string = "www.google.com"; break;
              case 2: the_string = "www.go.com"; break;
              case 3: the_string = "www.go.com"; break;
              case 4: the_string = "www.website.com"; break;
              case 5: the_string = "255.255.255.255"; break; // "255.255.255.255"
              case 6: the_string = "yahoo.com"; break;
              default : the_string = "www.google.com"; break;

          }
          return the_string;

       }

    // bad  Authority
    public   String bad_Authority(int select){
              String the_string;

              switch(select){

              case 1: the_string = "aaa"; break;
              case 2: the_string = "go.a"; break;
              case 3: the_string = ".1.2.3.4"; break;
              case 4: the_string = "go.1aa"; break;
              case 5: the_string = ""; break; 
              case 6: the_string = ""; break;
              default : the_string = ""; break;

          }
          return the_string;

       }

    // good Port
    public   String good_Port(int select){
              String the_string;

              switch(select){

              case 1: the_string = ":25"; break;
              case 2: the_string = ":12345"; break;
              case 3: the_string = ""; break;
              case 4: the_string = ""; break;
              default : the_string = ""; break;

          }
          return the_string;

       }

    // bad  Port
    public   String bad_Port(int select){
              String the_string;

              switch(select){

              case 1: the_string = ":-1"; break;
              case 2: the_string = ":65636"; break;
              case 3: the_string = ":65a"; break;
              case 4: the_string = ":65a"; break;
              default : the_string = ":65a"; break;


          }
          return the_string;

       }

    // good Path
    public   String good_Path(int select){
              String the_string;

              switch(select){

              case 1: the_string = ""; break;
              case 2: the_string = "/test/"; break;
              case 3: the_string = "/test/"; break;
              case 4: the_string = "/test/"; break;
              case 5: the_string = ""; break;
              case 6: the_string = "/test1/file/"; break;
              default : the_string = ""; break;

          }
          return the_string;

       }

    // bad  Path
    public   String bad_Path(int select){
              String the_string;

              switch(select){

              case 1: the_string = "/../"; break;
              case 2: the_string = "/../"; break;
              case 3: the_string = "/.."; break;
              case 4: the_string = "/.."; break;
              case 5: the_string = "/..//file"; break;
              case 6: the_string = "/..//file"; break;
              default : the_string = "/../"; break;

          }
          return the_string;

       }


/////////////////////////////////////////////////////////////////////////////////////
	private static final long TestTimeout = 15 * 500 * 1;
//	private static final long TestTimeout = 1 * 500 * 1;
    	
    @Test
	  public void randomtest_good_cases()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
 		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
 		 System.out.println("Start testing the good cases...");
         // lmao, same setup as the example


 		try{
 			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis(); //10
				Random random = new Random(randomseed);		

                int first = RandomTest.getRandomIntBetween(random,1,4);
                int second = RandomTest.getRandomIntBetween(random,1,6);
                int third = RandomTest.getRandomIntBetween(random,1,6);
                int fourth = RandomTest.getRandomIntBetween(random,1,4);


                String one = good_Scheme(first);
                String two = good_Authority(second);
                String three = good_Path(third);
                String four = good_Port(fourth);

                // good string !
                String good_string = one + two + three + four;

                // creat an UrlValidator object
                // with null,null,UrlValidator.ALLOW_ALL_SCHEMES
                // assert equals to true

                UrlValidator the_thing = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES);
                assertEquals(true, the_thing.isValid(good_string));
                //System.out.println(the_thing.isValid(good_string));

				//show elapsed time
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);

			   	if((iteration%10000)==0 && iteration!=0 ){
				System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout 
                                    + " is " + one + two + three + four + " is it really valid ? " + the_thing.isValid(good_string));
                }
			}
		}catch(NullPointerException e){
		}
		System.out.println("Done testing the good cases...");
 	}




   @Test
	  public void randomtest_bad_cases()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
 		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
 		 System.out.println("Start testing the bad cases...");
         // lmao, same setup as the example


 		try{
 			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis(); //10
				Random random = new Random(randomseed);		

                int first = RandomTest.getRandomIntBetween(random,1,4);
                int second = RandomTest.getRandomIntBetween(random,1,6);
                int third = RandomTest.getRandomIntBetween(random,1,6);
                int fourth = RandomTest.getRandomIntBetween(random,1,4);


                String one = bad_Scheme(first);
                String two = bad_Authority(second);
                String three = bad_Path(third);
                String four = bad_Port(fourth);

                // good string !
                String good_string = one + two + three + four;

                // creat an UrlValidator object
                // with null,null,UrlValidator.ALLOW_ALL_SCHEMES
                // assert equals to true

                UrlValidator the_thing = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES);
                assertEquals(false, the_thing.isValid(good_string));
                //System.out.println(the_thing.isValid(good_string));

				//show elapsed time
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);

			   	if((iteration%10000)==0 && iteration!=0 ){
				System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout 
                                    + " is " + one + two + three + four + " is it really invalid ? " + the_thing.isValid(good_string));
                }
			}
		}catch(NullPointerException e){
		}
		System.out.println("Done testing the bad cases...");
 	}









}