/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.GregorianCalendar; 
import java.util.*;


public class CalDayTest{

  // CalDay good
  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
    GregorianCalendar ab = new GregorianCalendar(2018, 7, 8);
    CalDay bc = new CalDay(ab);
    assertTrue(bc.isValid());
  }

  // CalDay bad
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
    CalDay bc = new CalDay();
    assertFalse(bc.isValid());
  }

  // toString good 1 appt
  @Test(timeout = 4000)
  public void test02()  throws Throwable  {

      GregorianCalendar a_day = new GregorianCalendar(2018, 7, 10);
      // the gregorianCalendar month starts at 0, and there is a plus 1 in the 
      // to string, so saving 7 here means 9 in the real world.

      CalDay day = new CalDay(a_day);

      String what = day.toString();

      String compare = "\t --- 9/10/2018 --- \n --- -------- Appointments ------------ --- \n\n";

      assertTrue(what.equals(compare));
    
  }

  // toString bad 1 appt
  @Test(timeout = 4000)
  public void test03()  throws Throwable  {

      CalDay day = new CalDay();

      String what = day.toString();

      String compare = "\t --- 9/10/2018 --- \n --- -------- Appointments ------------ --- \n\n";

      assertFalse(what.equals(compare));    
  }

  // getFullInfomrationApp  good
  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
  GregorianCalendar day = new GregorianCalendar(2018, 0, 10);

      CalDay the_day = new CalDay(day);

      Appt first = new Appt(7, 7, 2018, "first", "first.", "a@gmail.com");

      Appt second = new Appt(0, 10, 7, 7, 2018, "second", "second.", "b@gmail.com");

      Appt third = new Appt(20, 10, 7, 7, 2018, "third", "third.", "c@gmail.com");

      the_day.addAppt(first);

      the_day.addAppt(second);

      the_day.addAppt(third);

      String string_out = the_day.getFullInfomrationApp(the_day);

      assertEquals("1-10-2018 \n\tfirst first. \n\t12:10AM second second. \n\t8:10PM third third. ", string_out);
  }

  // get size
  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
  GregorianCalendar day = new GregorianCalendar(2018, 0, 10);

      CalDay the_day = new CalDay(day);

      Appt first = new Appt(7, 7, 2018, "first", "first.", "a@a.com");

      Appt second = new Appt(0, 10, 7, 7, 2018, "second", "second.", "b@b.com");

      Appt third = new Appt(20, 10, 7, 7, 2018, "third", "third.", "c@c.com");

      the_day.addAppt(first);

      the_day.addAppt(second);

      the_day.addAppt(third);

      String string_out = the_day.getFullInfomrationApp(the_day);
    assertEquals( 3 , the_day.getSizeAppts() );
  }

  //toString - valid - with two appointments (wrong order)

  @Test(timeout = 4000)

  public void test06()  throws Throwable  {

      GregorianCalendar a_day = new GregorianCalendar(2018, 2, 10);

      CalDay the_day = new CalDay(a_day);

      Appt first = new Appt(11, 1, 7, 6, 2018, "M2", "meeting2", "a@a.com");

      Appt second = new Appt(1, 1, 7, 6, 2018, "M1", "meeting1", "b@b.com");

      the_day.addAppt(first);

      the_day.addAppt(second);

      String the_string = the_day.toString();

      assertNotEquals("\t --- 4/10/2018 --- \n --- -------- Appointments ------------ --- \n" + "\t6/7/2018 at 8:5am ,M1, meeting1 \n" + "\t6/7/2018 at 10:5am ,M2, meeting2\n \n", the_string);

  }


  //no appointment !
  @Test(timeout = 4000)

  public void test07()  throws Throwable  {

      GregorianCalendar no_day = new GregorianCalendar(2018, 5, 10);

      CalDay day_no = new CalDay(no_day);

      String words = day_no.toString();

      assertEquals("\t --- 7/10/2018 --- \n --- -------- Appointments ------------ --- \n\n", words);

  }

  
  //toString with five appointments

  @Test(timeout = 4000)

  public void test08()  throws Throwable  {

      GregorianCalendar a_day = new GregorianCalendar(2020, 5, 10);

      CalDay day_zero = new CalDay(a_day);

      Appt one = new Appt(10, 5, 7, 6, 2020, "M1", "1", "1@gmail.com");

      Appt two = new Appt(8, 5, 7, 6, 2020, "M2", "2", "2@gmail.com");

      Appt three = new Appt(14, 5, 7, 6, 2020, "M3", "3", "3@gmail.com");

      Appt four = new Appt(14, 5, 7, 6, 2020, "M4", "4", "4@gmail.com");

      Appt five = new Appt(23, 5, 7, 6, 2020, "M5", "5", "5k@gmail.com");

      day_zero.addAppt(one);

      day_zero.addAppt(two);

      day_zero.addAppt(three);

      day_zero.addAppt(four);

      day_zero.addAppt(five);

      String words = day_zero.toString();

      assertEquals("\t --- 7/10/2020 --- \n --- -------- Appointments ------------ --- \n" + "\t6/7/2020 at 8:5am ,M2, 2\n" + " \t6/7/2020 at 10:5am ,M1, 1\n" + " \t6/7/2020 at 2:5pm ,M3, 3\n" + " \t6/7/2020 at 2:5pm ,M4, 4\n" + " \t6/7/2020 at 11:5pm ,M5, 5\n" + " \n", words);

  }

















}
