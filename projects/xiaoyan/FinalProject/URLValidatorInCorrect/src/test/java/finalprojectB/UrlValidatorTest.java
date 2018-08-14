/* Check line 280 bug is there*/
package finalprojectB;

import junit.framework.TestCase;
import java.util.Random;
import static org.junit.Assert.*;
import java.util.Arrays;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!

public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   public void testManualTest(){

      UrlValidator urlVal = new UrlValidator();
      System.out.println("Default");                  //always false

      System.out.println("http://www.google.com");
      System.out.println(urlVal.isValid("http://www.google.com"));

      System.out.println("https://www.google.com");
      System.out.println(urlVal.isValid("https://www.google.com"));

      System.out.println("ftp://www.google.com");
      System.out.println(urlVal.isValid("ftp://www.google.com"));

      System.out.println("http://www.google.com:80");
      System.out.println(urlVal.isValid("http://www.google.com:80"));

      System.out.println("http://www.hello.com/test");
      System.out.println(urlVal.isValid("http://www.hello.com/test"));

      System.out.println("http://255.255.255.255");
      System.out.println(urlVal.isValid("http://255.255.255.255"));

      System.out.println("http://web.engr.oregonstate.edu/~singhg/Classes/winter2018/ECE471/");
      System.out.println(urlVal.isValid("http://web.engr.oregonstate.edu/~singhg/Classes/winter2018/ECE471/"));

      UrlValidator urlVal2 = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

      System.out.println("using ALLOW_ALL_SCHEMES");        //does not allow anything beside http. works fine

      System.out.println("http://www.google.com");
      System.out.println(urlVal2.isValid("http://www.google.com"));


      //System.out.println("https://www.google.com");
      //System.out.println(urlVal2.isValid("https://www.google.com"));

      //System.out.println("ftp://www.google.com");
      //System.out.println(urlVal2.isValid("ftp://www.google.com"));

      System.out.println("http://www.google.com:80");
      System.out.println(urlVal2.isValid("http://www.google.com:80"));

      System.out.println("http://www.hello.com/test");
      System.out.println(urlVal2.isValid("http://www.hello.com/test"));

      System.out.println("http://255.255.255.255");
      System.out.println(urlVal2.isValid("http://255.255.255.255"));

      //this should be valid, results was false therefore it proves a bug that we cannot use ~
      System.out.println("http://web.engr.oregonstate.edu/~singhg/Classes/winter2018/ECE471/");
      System.out.println(urlVal2.isValid("http://web.engr.oregonstate.edu/~singhg/Classes/winter2018/ECE471/"));

      System.out.println("http://www.google.com/test1?action=viewtrue");
      System.out.println(urlVal2.isValid("http://www.google.com/test1?action=viewtrue"));

      System.out.println("http://goole.org/test/595.edu");
      System.out.println(urlVal2.isValid("http://goole.org/test/595.edu"));

      System.out.println("http://goole.org/علي/595");
      System.out.println(urlVal2.isValid("http://goole.org/علي"));

      System.out.println("http://https.org/test?action=print");
      System.out.println(urlVal2.isValid("http://https.org/test?action=print"));

      System.out.println("http://");
      System.out.println(urlVal2.isValid("http:"));

      System.out.println("null");
      System.out.println(urlVal.isValid(null));

      System.out.println( ":50//www.amazon.com");
     	System.out.println(urlVal.isValid(":50//www.amazon.com"));

      System.out.println("With SCHEMES");
      String[] schemes = {"http", "https", "http://"};
      UrlValidator urlVal3 = new UrlValidator(schemes);
      System.out.println("http");
      System.out.println(urlVal3.isValid("http"));

      System.out.println("https");
      System.out.println(urlVal3.isValid("https"));

// This prove a bug. this should be false and it outputs true
      System.out.println("http://");
      System.out.println(urlVal3.isValid("http://"));

      System.out.println("allow two slashes");
      UrlValidator urlVal4 = new UrlValidator(UrlValidator.ALLOW_2_SLASHES);
      System.out.println("http://hellow.com//test");
      System.out.println(urlVal3.isValid("http://hellow.com//test"));

      System.out.println("http://yesyes.org//test?action=save");
      System.out.println(urlVal3.isValid("http://yesyes.org//test?action=save"));

      System.out.println("http://yudodis//~seven?hello");
      System.out.println(urlVal3.isValid("http://yudodis//~seven?hello"));

      System.out.println("NO_FRAGMENTS");
      UrlValidator urlVal5 = new UrlValidator(schemes, UrlValidator.NO_FRAGMENTS);
      //this should be true but was false
      System.out.println("http://www.google.com");
      System.out.println(urlVal.isValid("http://www.google.com"));

      System.out.println("http://www.google.com/#");
      System.out.println(urlVal.isValid("http://www.google.com/#"));
}

   // changing scheme
   public void testYourFirstPartition(){
	 //You can use this function to implement your First Partition testing
       System.out.println("start the first partition test");

       UrlValidator urlVal = new UrlValidator(null);

       String url = "http://www.google.com"; // just a normal url
       System.out.println(url);
       System.out.println("should be good");      
       System.out.println(urlVal.isValid(url));

       url = "https:////www.google.com"; // scheme too long, but should  be good !
       System.out.println(url);
       System.out.println("should be bad");
       System.out.println(urlVal.isValid(url));

       url = "ftp:////www.google.com"; // scheme too short, but should still be good!
       System.out.println(url);
       System.out.println("should be good");
       System.out.println(urlVal.isValid(url));

       url = "hhttppss:////www.google.com"; // scheme too long, should be bad !
       System.out.println(url);
       System.out.println("should be bad");
       System.out.println(urlVal.isValid(url));

       url = "aa:////www.google.com"; // the scheme is too short, should be bad !
       System.out.println(url);
       System.out.println("should be bad");
       System.out.println(urlVal.isValid(url));

       System.out.println("end the first partition test");
   }

   // changing authority
   public void testYourSecondPartition(){
       System.out.println("start the second partition test");
	//You can use this function to implement your Second Partition testing

      UrlValidator urlVal = new UrlValidator(null);
      String url = "0.0.0.0"; // just a normal url
       System.out.println(url);
       System.out.println("should be good");
       System.out.println(urlVal.isValid(url));

      url = "https://255.255.255.255"; // scheme too long, but should  be good !
       System.out.println(url);
       System.out.println("should be good");
       System.out.println(urlVal.isValid(url));

      url = "https://0.0.0.0"; // scheme too short, but should still be good!
       System.out.println(url);
       System.out.println("should be good");
       System.out.println(urlVal.isValid(url));

      url = "hhttppss://255.255.255.255.255.255"; // scheme too long, should be bad !
       System.out.println(url);
       System.out.println("should be bad");
       System.out.println(urlVal.isValid(url));

      url = "https://-1.-1.-1.-1"; // the scheme is too short, should be bad !
       System.out.println(url);
       System.out.println("should be bad");
       System.out.println(urlVal.isValid(url));

       System.out.println("end the second partition test");
   }
   //You need to create more test cases for your Partitions if you need to

   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }



}
