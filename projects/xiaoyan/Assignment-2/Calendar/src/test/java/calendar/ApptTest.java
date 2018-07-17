/** A JUnit test class to test the class ApptTest. */
//
// question how to test int[]
//

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt0.setValid();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals(0, appt0.getRecurIncrement());
      assertEquals("Birthday Party",appt0.getTitle());
      assertTrue(!appt0.getValid());
      
  }

 // test 01, test the setValid pre-conditon handling abality 
 // and the corresponding get functions.
 // use appt1
 @Test(timeout = 4000)
 public void test01()  throws Throwable  {
      Appt appt1 = new Appt(1, 1, 1, 1, 1, "BBB", "XD", "a@a.com");  
      appt1.setValid();
      assertEquals(1, appt1.getStartHour());
      assertEquals(1, appt1.getStartMinute());
      assertEquals(1, appt1.getStartDay());
      assertEquals(1, appt1.getStartMonth());
      assertEquals(1, appt1.getStartYear());

      assertEquals("BBB", appt1.getTitle());
      assertEquals("XD",appt1.getDescription());
      assertEquals("a@a.com",appt1.getEmailAddress()); 
      assertTrue(appt1.getValid());    
  }

  // test 02, test the isOn 
  // use appt1
  @Test(timeout = 4000)
  public void test02()  throws  Throwable   {
    Appt appt1 = new Appt(1, 1, 1, 1, 1, "BBB", "XD", "a@a.com");  
    appt1.setValid();
    assertTrue(appt1.isOn(1,1,1) );
    assertFalse(appt1.isOn(2,2,2) );
  }

  // test 03, test the setRecurrence with array
  // use appt1 
  @Test(timeout = 4000)
  public void test03()  throws  Throwable   {
    Appt appt1 = new Appt(1, 1, 1, 1, 1, "BBB", "XD", "a@a.com");  
    appt1.setValid();
    int[] test={2,3,4};
    appt1.setRecurrence(test,2,2,2);
    assertEquals( 2 , appt1.getRecurNumber() );
    assertEquals( 2 , appt1.getRecurBy()     );
//    assertEquals( {2,3,4} , appt1.getRecurDays() );
    assertEquals( 2 , appt1.getRecurIncrement() );
    assertTrue(appt1.isRecurring() ); 
  }

  // test 03, test the setRecurrence with null
  // use appt1 
  @Test(timeout = 4000)
  public void test04()  throws  Throwable   {
    Appt appt1 = new Appt(1, 1, 1, 1, 1, "BBB", "XD", "a@a.com");  
    appt1.setValid();
//    int[] test={null};
    appt1.setRecurrence(null,2,2,2);
    assertEquals( 2 , appt1.getRecurNumber() );
    assertEquals( 2 , appt1.getRecurBy()     );
//    assertEquals( null , appt1.getRecurDays() );
    assertEquals( 2 , appt1.getRecurIncrement() );
    assertTrue(appt1.isRecurring() ); 
  }

 // test the setValid pre-conditon handling abality 
 // and the corresponding get functions.
 // use appt1
 // int startHour, int startMinute, 
 // int startDay, int startMonth, int startYear,
 // String title, String description, String emailAddress
 // hr too high
 @Test(timeout = 4000)
 public void test05()  throws Throwable  {
      Appt appt1 = new Appt(41, 1, 1, 1, 1, "BBB", "XD", "a@a.com");  
      appt1.setValid();
      assertFalse(appt1.getValid());    
  }

 // test the setValid pre-conditon handling abality 
 // and the corresponding get functions.
 // use appt1
 // int startHour, int startMinute, 
 // int startDay, int startMonth, int startYear,
 // String title, String description, String emailAddress
 // hr to low
 @Test(timeout = 4000)
 public void test06()  throws Throwable  {
      Appt appt1 = new Appt(-1, 1, 1, 1, 1, "BBB", "XD", "a@a.com");  
      appt1.setValid();
      assertFalse(appt1.getValid());    
  }

 // test the setValid pre-conditon handling abality 
 // and the corresponding get functions.
 // use appt1
 // int startHour, int startMinute, 
 // int startDay, int startMonth, int startYear,
 // String title, String description, String emailAddress
 // min to high
 @Test(timeout = 4000)
 public void test07()  throws Throwable  {
      Appt appt1 = new Appt(1, 100, 1, 1, 1, "BBB", "XD", "a@a.com");  
      appt1.setValid();
      assertFalse(appt1.getValid());    
  }

 // test the setValid pre-conditon handling abality 
 // and the corresponding get functions.
 // use appt1
 // int startHour, int startMinute, 
 // int startDay, int startMonth, int startYear,
 // String title, String description, String emailAddress
 // min to low
 @Test(timeout = 4000)
 public void test08()  throws Throwable  {
      Appt appt1 = new Appt(1, -1, 1, 1, 1, "BBB", "XD", "a@a.com");  
      appt1.setValid();
      assertFalse(appt1.getValid());    
  }

 // test the setValid pre-conditon handling abality 
 // and the corresponding get functions.
 // use appt1
 // int startHour, int startMinute, 
 // int startDay, int startMonth, int startYear,
 // String title, String description, String emailAddress
 // day to high
 @Test(timeout = 4000)
 public void test09()  throws Throwable  {
      Appt appt1 = new Appt(1, 1, 100, 1, 1, "BBB", "XD", "a@a.com");  
      appt1.setValid();
      assertFalse(appt1.getValid());    
  }

// test the setValid pre-conditon handling abality 
 // and the corresponding get functions.
 // use appt1
 // int startHour, int startMinute, 
 // int startDay, int startMonth, int startYear,
 // String title, String description, String emailAddress
 // day to low
 @Test(timeout = 4000)
 public void test10()  throws Throwable  {
      Appt appt1 = new Appt(1, 1, -1, 1, 1, "BBB", "XD", "a@a.com");  
      appt1.setValid();
      assertFalse(appt1.getValid());    
  }

// test the setValid pre-conditon handling abality 
 // and the corresponding get functions.
 // use appt1
 // int startHour, int startMinute, 
 // int startDay, int startMonth, int startYear,
 // String title, String description, String emailAddress
 // month to high
 @Test(timeout = 4000)
 public void test11()  throws Throwable  {
      Appt appt1 = new Appt(1, 1, 1, 100, 1, "BBB", "XD", "a@a.com");  
      appt1.setValid();
      assertFalse(appt1.getValid());    
  }

// test the setValid pre-conditon handling abality 
 // and the corresponding get functions.
 // use appt1
 // int startHour, int startMinute, 
 // int startDay, int startMonth, int startYear,
 // String title, String description, String emailAddress
 // month to low
 @Test(timeout = 4000)
 public void test12()  throws Throwable  {
      Appt appt1 = new Appt(1, 1, 1, -1, 1, "BBB", "XD", "a@a.com");  
      appt1.setValid();
      assertFalse(appt1.getValid());    
  }

// test the setValid pre-conditon handling abality 
 // and the corresponding get functions.
 // use appt1
 // int startHour, int startMinute, 
 // int startDay, int startMonth, int startYear,
 // String title, String description, String emailAddress
 // year to low
 @Test(timeout = 4000)
 public void test13()  throws Throwable  {
      Appt appt1 = new Appt(1, 1, 1, 1, 0, "BBB", "XD", "a@a.com");  
      appt1.setValid();
      assertFalse(appt1.getValid());    
  }

// good email
@Test(timeout = 4000)
 public void test14()  throws Throwable  {
      Appt appt1 = new Appt(1, 1, 1, 1, 1, "BBB", "XD", "a@a.com");  
      appt1.setValid();
      String a = appt1.getEmailAddress();
      assertEquals( "a@a.com" ,a );    
  }

// bad  emsil(missing)
@Test(timeout = 4000)
 public void test15()  throws Throwable  {
      Appt appt1 = new Appt(1, 1, 1, 1, 1, "BBB", "XD", null);  
      appt1.setValid();
      String a = appt1.getEmailAddress();
      assertEquals( "" ,a );    
  }

// good title
@Test(timeout = 4000)
 public void test16()  throws Throwable  {
      Appt appt1 = new Appt(1, 1, 1, 1, 1, "BBB", "XD", "a@a.com");  
      appt1.setValid();
      String a = appt1.getTitle();
      assertEquals( "BBB" ,a );      
  }

// bad  title(missing)
@Test(timeout = 4000)
 public void test17()  throws Throwable  {
      Appt appt1 = new Appt(1, 1, 1, 1, 1, null, "XD", "a@a.com");  
      appt1.setValid();
      String a = appt1.getTitle();
      assertEquals( "" ,a );      
  }

// good description
@Test(timeout = 4000)
 public void test18()  throws Throwable  {
      Appt appt1 = new Appt(1, 1, 1, 1, 1, "BBB", "XD", "a@a.com");  
      appt1.setValid();
      String a = appt1.getDescription();
      assertEquals( "XD" ,a );     
  }

// bad  description(missing)
@Test(timeout = 4000)
 public void test19()  throws Throwable  {
      Appt appt1 = new Appt(1, 1, 1, 1, 1, "BBB", null, "a@a.com");  
      appt1.setValid();
      String a = appt1.getDescription();
      assertEquals( "" ,a );     
  }

// good hasTimeSet
@Test(timeout = 4000)
 public void test20()  throws Throwable  {
      Appt appt1 = new Appt(1, 1, 1, 1, 1, "BBB", "XD", "a@a.com");  
      appt1.setValid();
      assertTrue(appt1.hasTimeSet());
 }

// bad hasTimeSet
@Test(timeout = 4000)
 public void test21()  throws Throwable  {
      Appt appt1 = new Appt(1, 1, 1, "BBB", "XD", "a@a.com");  
      appt1.setValid();
      assertFalse(appt1.hasTimeSet());
 }

// toString with yes min and yes hr (am)
@Test(timeout = 4000)
 public void test22()  throws Throwable  {
      Appt appt1 = new Appt(1, 1, 1, 1, 1, "BBB", "XD", "a@a.com");  
      appt1.setValid();
      String ab = appt1.toString();
      assertEquals( "\t1/1/1 at 1:1am ,BBB, XD\n" , ab );
 }


// toString with no min and no hr
@Test(timeout = 4000)
 public void test23()  throws Throwable  {
      Appt appt1 = new Appt(1, 1, 1, "BBB", "XD", "a@a.com");  
      appt1.setValid();
      String ab = appt1.toString();
      assertEquals( "\t1/1/1 at -1:-1am ,BBB, XD\n" , ab );
 }

// toString with yes min and yes hr (pm)
@Test(timeout = 4000)
 public void test24()  throws Throwable  {
      Appt appt1 = new Appt(13, 1, 1, 1, 1, "BBB", "XD", "a@a.com");  
      appt1.setValid();
      String ab = appt1.toString();
      assertEquals( "\t1/1/1 at 1:1pm ,BBB, XD\n" , ab );
 }



}
