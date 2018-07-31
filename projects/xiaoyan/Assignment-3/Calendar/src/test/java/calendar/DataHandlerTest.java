
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;


import org.junit.After;

import org.junit.AfterClass;

import org.junit.Before;

import org.junit.BeforeClass;

import java.io.*;



public class DataHandlerTest{

//clean up

  @Before

  public void setUp() {

      File testfile = new File("new_file.xml");

      testfile.delete();

  }



  //clean up 

  @After

  public void tearDown() {

      File testfile = new File("new_file.xml");

      testfile.delete();

  }

// start at the botton, since the save function looks easy to work with

  // save(dummy) 
  @Test(timeout = 4000)

  public void test00()  throws Throwable  {

      DataHandler one = new DataHandler();

      assertTrue(one.save());

  }

  // save(with an good appointnment)  
  @Test(timeout = 4000)

  public void test01()  throws Throwable  {

  GregorianCalendar day = new GregorianCalendar(2018, 0, 10);
  CalDay the_day = new CalDay(day);
  Appt first = new Appt(7, 7, 2018, "first", "first.", "a@gmail.com");
  the_day.addAppt(first);
  DataHandler data_1 = new DataHandler("new_file.xml");
  assertTrue(data_1.saveAppt(first));

  }

  // save(with an bad appointnment (1) )  
  @Test(timeout = 4000)

  public void test02()  throws Throwable  {

  GregorianCalendar day = new GregorianCalendar(2018, 0, 10);
  CalDay the_day = new CalDay(day);
  Appt first = new Appt(-7, 7, 2018, "first", "first.", "a@gmail.com");
  the_day.addAppt(first);
  DataHandler data_1 = new DataHandler("new_file.xml");
  assertTrue(data_1.saveAppt(first));

  }

  // save(with an bad appointnment (2) )  
  @Test(timeout = 4000)

  public void test03()  throws Throwable  {

  GregorianCalendar day = new GregorianCalendar(2018, 0, 10);
  CalDay the_day = new CalDay(day);
  Appt first = new Appt(7, -7, 2018, "first", "first.", "a@gmail.com");
  the_day.addAppt(first);
  DataHandler data_1 = new DataHandler("new_file.xml");
  assertTrue(data_1.saveAppt(first));

  }

  // save(with an bad appointnment (3) )  

  @Test(timeout = 4000)

  public void test04()  throws Throwable  {

  GregorianCalendar day = new GregorianCalendar(2018, 0, 10);
  CalDay the_day = new CalDay(day);
  Appt first = new Appt(7, 7, -2018, "first", "first.", "a@gmail.com");
  the_day.addAppt(first);
  DataHandler data_1 = new DataHandler("new_file.xml");
  assertTrue(data_1.saveAppt(first));

  }

  // save(with an good appointnment  ) 
  @Test(timeout = 4000)

  public void test05()  throws Throwable  {

  GregorianCalendar day = new GregorianCalendar(2018, 0, 10);
  CalDay the_day = new CalDay(day);
  Appt first = new Appt(7, 7, 2018, "first", "first.", "a@gmail.com");
  the_day.addAppt(first);
  DataHandler data_1 = new DataHandler("new_file.xml",false);
  assertTrue(data_1.saveAppt(first));

  }

    // save(with an bad appointnment  )  
  @Test(timeout = 4000)

  public void test06()  throws Throwable  {

  GregorianCalendar day = new GregorianCalendar(2018, 0, 10);
  CalDay the_day = new CalDay(day);
  Appt first = new Appt(-7, 7, 2018, "first", "first.", "a@gmail.com");
  the_day.addAppt(first);
  DataHandler data_1 = new DataHandler("new_file.xml",false);
  assertTrue(data_1.saveAppt(first));

  }

    // save(with recurring )  no auto save
  @Test(timeout = 4000)

  public void test07()  throws Throwable  {

  GregorianCalendar day = new GregorianCalendar(2018, 0, 10);
  CalDay the_day = new CalDay(day);
  Appt first = new Appt(7, 7, 2018, "first", "first.", "a@gmail.com");
  int[] arr = {2, 3, 5};
  first.setRecurrence(arr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
  the_day.addAppt(first);
  DataHandler data_1 = new DataHandler("new_file.xml",false);
  assertTrue(data_1.saveAppt(first));

  }

  // delete(with an good appointnment)  
  @Test(timeout = 4000)

  public void test08()  throws Throwable  {

  GregorianCalendar day = new GregorianCalendar(2018, 0, 10);
  CalDay the_day = new CalDay(day);
  Appt first = new Appt(7, 7, 2018, "first", "first.", "a@gmail.com");
  the_day.addAppt(first);
  DataHandler data_1 = new DataHandler("new_file.xml");
  data_1.saveAppt(first);
  assertTrue(data_1.deleteAppt(first));

  }

    // delet(with recurring )  no auto save
  @Test(timeout = 4000)

  public void test09()  throws Throwable  {

  GregorianCalendar day = new GregorianCalendar(2018, 0, 10);
  CalDay the_day = new CalDay(day);
  Appt first = new Appt(7, 7, 2018, "first", "first.", "a@gmail.com");
  int[] arr = {2, 3, 5};
  first.setRecurrence(arr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
  the_day.addAppt(first);
  DataHandler data_1 = new DataHandler("new_file.xml");
  data_1.saveAppt(first);
  assertTrue(data_1.saveAppt(first));

  }

    // delet(with recurring )  with auto save
  @Test(timeout = 4000)

  public void test10()  throws Throwable  {

  GregorianCalendar day = new GregorianCalendar(2018, 0, 10);
  CalDay the_day = new CalDay(day);
  Appt first = new Appt(7, 7, 2018, "first", "first.", "a@gmail.com");
  int[] arr = {2, 3, 5};
  first.setRecurrence(arr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
  the_day.addAppt(first);
  DataHandler data_1 = new DataHandler("new_file.xml",false);
  data_1.saveAppt(first);
  assertTrue(data_1.saveAppt(first));

  }


    // delet(bad appt )  no auto save
  @Test(timeout = 4000)

  public void test11()  throws Throwable  {

  GregorianCalendar day = new GregorianCalendar(2018, 0, 10);
  CalDay the_day = new CalDay(day);
  Appt first = new Appt(-7, 7, 2018, "first", "first.", "a@gmail.com");
  int[] arr = {1, 3, 5};
  first.setRecurrence(arr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
  the_day.addAppt(first);
  DataHandler data_1 = new DataHandler("new_file.xml");
  data_1.saveAppt(first);
  assertTrue(data_1.saveAppt(first));

  }
 
    //get range - first day is after last day

    @Test(timeout = 4000)

    public void test12()  throws Throwable  {

        DataHandler day = new DataHandler("new_file.xml");

        GregorianCalendar firstday = new GregorianCalendar(2018, 1, 1);

        GregorianCalendar secondday = new GregorianCalendar(2018, 10, 20);

        Appt one = new Appt(8, 10, 1, 5, 2100, "a", "a", "a@gmail.com");

        int[] arr = {1,3,5};

        one.setRecurrence(arr, Appt.RECUR_BY_YEARLY, 2, Appt.RECUR_NUMBER_FOREVER);

        one.setValid();

        day.saveAppt(one);

        LinkedList<CalDay> calDays = new LinkedList<CalDay>();

        calDays = (LinkedList<CalDay>) day.getApptRange(firstday, secondday);

        int number = 0;

        for (int i = 0; i < calDays.size(); i++) {

            LinkedList<Appt>  appts = calDays.get(i).getAppts();

            for(int j = 0; j < appts.size(); j++) {

                number++;

            }

        }

        assertEquals(0, number);

    }



    //get range - first day is before start

    @Test(timeout = 4000)

    public void test13()  throws Throwable  {

        DataHandler day = new DataHandler("new_file.xml");

        GregorianCalendar firstday = new GregorianCalendar(2018, 1, 1);

        GregorianCalendar secondday = new GregorianCalendar(2100, 10, 20);

        Appt one = new Appt(8, 10, 1, 5, 2000, "Meeting", "This is a meeting", "work@gmail.com");

        int[] arr = {1,2,3,5};

        one.setRecurrence(arr, Appt.RECUR_BY_YEARLY, 2, Appt.RECUR_NUMBER_FOREVER);

        one.setValid();

        day.saveAppt(one);

        LinkedList<CalDay> calDays = new LinkedList<CalDay>();

        calDays = (LinkedList<CalDay>) day.getApptRange(firstday, secondday);

        int number = 0;

        for (int i = 0; i < calDays.size(); i++) {

            LinkedList<Appt>  appts = calDays.get(i).getAppts();

            for(int j = 0; j < appts.size(); j++) {

                number++;

            }

        }

        assertEquals(83, number);

    }



    //get range - undefine reccur

    @Test(timeout = 4000)

    public void test14()  throws Throwable  {

        DataHandler day = new DataHandler("new_file.xml");

        GregorianCalendar firstday = new GregorianCalendar(2018, 0, 1);

        GregorianCalendar secondday = new GregorianCalendar(2018, 3, 1);

        Appt one = new Appt(5, 5, 1, 1, 2018, "a", "a", "a@yahoo.com");

        int[] arr = {};

        one.setRecurrence(arr, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);

        one.setValid();

        day.saveAppt(one);

        LinkedList<CalDay> calDays = new LinkedList<CalDay>();

        calDays = (LinkedList<CalDay>) day.getApptRange(firstday, secondday);

        int number = 0;

        for (int i = 0; i < calDays.size(); i++) {

            LinkedList<Appt>  appts = calDays.get(i).getAppts();

            for(int j = 0; j < appts.size(); j++) {

                number++;

            }

        }

        assertEquals(13, number);

    }



    //get range - reccur outside the range

    @Test(timeout = 4000)

    public void test15()  throws Throwable  {

        DataHandler day = new DataHandler("new_file.xml");

        GregorianCalendar firstday = new GregorianCalendar(2018, 1, 1);

        GregorianCalendar secondday = new GregorianCalendar(2018, 10, 20);

        Appt one = new Appt(8, 10, 1, 5, 2000, "a", "a", "a@gmail.com");

        int[] arr = {1000, 2000, 3000};

        one.setRecurrence(arr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);

        one.setValid();

        day.saveAppt(one);

        LinkedList<CalDay> calDays = new LinkedList<CalDay>();

        calDays = (LinkedList<CalDay>) day.getApptRange(firstday, secondday);

        int number = 0;

        for (int i = 0; i < calDays.size(); i++) {

            LinkedList<Appt>  appts = calDays.get(i).getAppts();

            for(int j = 0; j < appts.size(); j++) {

                number++;

            }

        }

        assertEquals(0, number);

    }



    //get range - with reccur

    @Test(timeout = 4000)

    public void test16()  throws Throwable  {

        DataHandler day = new DataHandler("new_file.xml");

        GregorianCalendar firstday = new GregorianCalendar(2018, 2, 1);

        GregorianCalendar secondday = new GregorianCalendar(2019, 12, 20);

        Appt one = new Appt(8, 10, 2, 5, 2000, "a", "a", "a@gmail.com");

        int[] arr = {1, 2, 3, 4,5};

        one.setRecurrence(arr, Appt.RECUR_BY_MONTHLY, 2, Appt.RECUR_NUMBER_FOREVER);

        one.setValid();

        day.saveAppt(one);

        LinkedList<CalDay> calDays = new LinkedList<CalDay>();

        calDays = (LinkedList<CalDay>) day.getApptRange(firstday, secondday);

        int number = 0;

        for (int i = 0; i < calDays.size(); i++) {

            LinkedList<Appt>  appts = calDays.get(i).getAppts();

            for(int j = 0; j < appts.size(); j++) {

                number++;

            }

        }

        assertEquals(23, number);

    }



    //get range - no appointments

    @Test(timeout = 4000)

    public void test17()  throws Throwable  {

        DataHandler day = new DataHandler("new_file.xml");

        GregorianCalendar firstday = new GregorianCalendar(2028, 1, 1);

        GregorianCalendar secondday = new GregorianCalendar(2029, 10, 20);

        LinkedList<CalDay> calDays = new LinkedList<CalDay>();

        calDays = (LinkedList<CalDay>) day.getApptRange(firstday, secondday);

        int number = 0;

        for (int i = 0; i < calDays.size(); i++) {

            LinkedList<Appt>  appts = calDays.get(i).getAppts();

            for(int j = 0; j < appts.size(); j++) {

                number++;

            }

        }

        assertEquals(0, number);

    }



    //get  range - reccur once

    @Test(timeout = 4000)

    public void test18()  throws Throwable  {

        DataHandler day = new DataHandler("new_file.xml");

        GregorianCalendar firstday = new GregorianCalendar(2020, 2, 1);

        GregorianCalendar secondday = new GregorianCalendar(2020, 3, 1);

        Appt one = new Appt(5, 5, 1, 3, 2020, "a", "a.", "a@yahoo.com");

        int[] arr = {1};

        one.setRecurrence(arr, Appt.RECUR_BY_WEEKLY, 1, 1);

        one.setValid();

        day.saveAppt(one);

        LinkedList<CalDay> calDays = new LinkedList<CalDay>();

        calDays = (LinkedList<CalDay>) day.getApptRange(firstday, secondday);

        int number = 0;

        for (int i = 0; i < calDays.size(); i++) {

            LinkedList<Appt>  appts = calDays.get(i).getAppts();

            for(int j = 0; j < appts.size(); j++) {

                number++;

            }

        }

        assertEquals(2, number);

    }




    //save autosave yes   deleted file

    @Test(timeout = 4000)

    public void test19()  throws Throwable  {

        DataHandler zero = new DataHandler("calendar_test.xml");

        GregorianCalendar firstday = new GregorianCalendar(2020, 0, 1);

        GregorianCalendar lastday = new GregorianCalendar(2020, 1, 1);

        Appt appt_zero = new Appt(5, 5, 1, 1, 2020, "w", "w", "w.com");

        appt_zero.setValid();

        zero.saveAppt(appt_zero);

        File testfile = new File("calendar_test.xml");

        assertTrue(testfile.delete());

    }



    //deleteAppt  autosave off file should still be here

    @Test(timeout = 4000)

    public void test20()  throws Throwable  {

        DataHandler zero = new DataHandler("calendar_test.xml", false);

        GregorianCalendar firstday = new GregorianCalendar(2020, 0, 1);

        GregorianCalendar lastday = new GregorianCalendar(2020, 1, 1);

        Appt appt_zero = new Appt(5, 5, 1, 1, 2020, "w", "w", "w.com");

        appt_zero.setValid();

        zero.saveAppt(appt_zero);

        zero.deleteAppt(appt_zero);

        File testfile = new File("calendar_test.xml");

        assertFalse(testfile.delete());

    }



    //deleteAppt autosave yes  deleted file

    @Test(timeout = 4000)

    public void test21()  throws Throwable  {

        DataHandler zero = new DataHandler("calendar_test.xml");

        GregorianCalendar firstday = new GregorianCalendar(2020, 0, 1);

        GregorianCalendar lastday = new GregorianCalendar(2020, 1, 1);

        Appt appt_zero = new Appt(5, 5, 1, 1, 2020, "w", "w", "w.com");

        appt_zero.setValid();

        zero.saveAppt(appt_zero);

        zero.deleteAppt(appt_zero);

        File testfile = new File("calendar_test.xml");

        assertTrue(testfile.delete());

    }



    //get range - reccur bad day

    @Test(timeout = 4000)

    public void test22()  throws Throwable  {

        DataHandler zero = new DataHandler("calendar_test.xml");

        GregorianCalendar firstday = new GregorianCalendar(2020, 0, 1);

        GregorianCalendar lastday = new GregorianCalendar(2020, 1, 1);

        Appt appt_zero = new Appt(5, 5, 1, 1, 2020, "w", "w", "w.com");

        int[] recurDaysArr = {7};

        appt_zero.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, 100);

        appt_zero.setValid();

        zero.saveAppt(appt_zero);

        LinkedList<CalDay> calDays = new LinkedList<CalDay>();

        calDays = (LinkedList<CalDay>) zero.getApptRange(firstday, lastday);

        int number = 0;

        for (int i = 0; i < calDays.size(); i++) {

            LinkedList<Appt>  appts = calDays.get(i).getAppts();

            for(int j = 0; j < appts.size(); j++) {

                number++;

            }

        }

        assertEquals(5, number);

    }



    //xmlElement is null

    @Test(timeout = 4000)

    public void test23()  throws Throwable  {

        DataHandler zero = new DataHandler("calendar_test.xml");

        GregorianCalendar firstday = new GregorianCalendar(2020, 0, 1);

        GregorianCalendar lastday = new GregorianCalendar(2020, 1, 1);

        Appt appt_zero = new Appt(5, 5, 1, 1, 2020, "w", "w", "w.com");

        appt_zero.setValid();

        zero.saveAppt(appt_zero);

        zero.deleteAppt(appt_zero);

        assertNull(appt_zero.getXmlElement());

    }



    //getApptRange exception !

    @Test(expected = AssertionError.class)

    public void test24()  throws Throwable  {

        DataHandler zero = new DataHandler("calendar_test.xml");

        GregorianCalendar firstday = new GregorianCalendar(2020, 0, 1);

        GregorianCalendar lastday = new GregorianCalendar(2020, 1, 1);

        LinkedList<CalDay> calDays = new LinkedList<CalDay>();

        calDays = (LinkedList<CalDay>) zero.getApptRange(firstday, lastday);

        fail();

    }



    //getNextApptOccurrence - looking for null

    @Test(timeout = 4000)

    public void test25()  throws Throwable  {

        DataHandler zero = new DataHandler("calendar_test.xml");

        GregorianCalendar firstday = new GregorianCalendar(2020, 1, 1);

        GregorianCalendar lastday = new GregorianCalendar(2049, 10, 20);

        Appt appt_zero = new Appt(8, 10, 1, 5, 2000, "w", "w", "w.com");

        appt_zero.setValid();

        zero.saveAppt(appt_zero);

        LinkedList<CalDay> calDays = new LinkedList<CalDay>();

        calDays = (LinkedList<CalDay>) zero.getApptRange(firstday, lastday);

        int number = 0;

        for (int i = 0; i < calDays.size(); i++) {

            LinkedList<Appt>  appts = calDays.get(i).getAppts();

            for(int j = 0; j < appts.size(); j++) {

                number++;

            }

        }

        assertEquals(96, number);

    }



    //get range - recur day

    @Test(timeout = 4000)

    public void test26()  throws Throwable  {

        DataHandler zero = new DataHandler("calendar_test.xml");

        GregorianCalendar firstday = new GregorianCalendar(2020, 0, 1);

        GregorianCalendar lastday = new GregorianCalendar(2020, 1, 1);

        Appt appt_zero = new Appt(5, 5, 1, 1, 2020, "w", "w", "w.com");

        int[] recurDaysArr = {6};

        appt_zero.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, 100);

        appt_zero.setValid();

        zero.saveAppt(appt_zero);

        LinkedList<CalDay> calDays = new LinkedList<CalDay>();

        calDays = (LinkedList<CalDay>) zero.getApptRange(firstday, lastday);

        int number = 0;

        for (int i = 0; i < calDays.size(); i++) {

            LinkedList<Appt>  appts = calDays.get(i).getAppts();

            for(int j = 0; j < appts.size(); j++) {

                number++;

            }

        }

        assertEquals(11, number);

    }








}