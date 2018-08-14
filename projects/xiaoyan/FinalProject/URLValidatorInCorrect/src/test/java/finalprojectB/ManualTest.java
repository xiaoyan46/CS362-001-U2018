package finalprojectB;
import java.util.Random;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;
//import junit.framework.TestCase;

// This class is all about manual testing
// 01 to 10 are good


public class ManualTest {

// using default urlvalidator
// just put a good url in it and see what happen    
@Test(timeout = 4000)
    public void test01()  throws Throwable
    {
    UrlValidator the_thing = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
    assertEquals(true, the_thing.isValid("http://www.amazon.com"));
    }

@Test(timeout = 4000)
    public void test02()  throws Throwable
    {
      
    }    

@Test(timeout = 4000)
    public void test03()  throws Throwable
    {
        
    }

@Test(timeout = 4000)
    public void test04()  throws Throwable
    {
        
    }

@Test(timeout = 4000)
    public void test05()  throws Throwable
    {
        
    }

@Test(timeout = 4000)
    public void test06()  throws Throwable
    {
        
    }

@Test(timeout = 4000)
    public void test07()  throws Throwable
    {
        
    }

@Test(timeout = 4000)
    public void test08()  throws Throwable
    {
        
    }        

@Test(timeout = 4000)
    public void test09()  throws Throwable
    {
        
    }

@Test(timeout = 4000)
    public void test10()  throws Throwable
    {
        
    }


}