package PS0;

import static  org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.*;


/**
 * JUnit tests for RulesOf6005. Goes through the methods
 * hasFeature, testComputeGrade, and testExtendedDueDate
 *
 */
import PS0.RulesOf6005;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
public class RulesOf6005Test {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Tests the hasFeature method of RulesOf6005. 
     */
	@Test
	public void testHasFeature() {
		assertTrue(RulesOf6005.hasFeature("QUIZZES"));
		assertFalse(RulesOf6005.hasFeature("quuuuuiiizes"));
		assertFalse(RulesOf6005.hasFeature("Laptops not required"));
		assertTrue(RulesOf6005.hasFeature("code review"));
	}
	
	
	/**
	 * Tests the computeGrade method of RulesOf6005.
	 */
	@Test
	public void testComputeGrade(){
		assertEquals(100, RulesOf6005.computeGrade(100, 100, 100, 100));
		assertEquals(0, RulesOf6005.computeGrade(0, 0, 0, 0));
		assertEquals(47, RulesOf6005.computeGrade(60, 40, 50, 37));
	}
	
	
	/**
	 * Tests the extendDeadline method of Rules of6005.
	 */
	@Test
	public void testExtendDeadline(){
        Calendar duedate = new GregorianCalendar();
        duedate.clear();
        duedate.set(2011, 8, 9, 23, 59, 59);
        Calendar twoDaysAfter = new GregorianCalendar();
        twoDaysAfter.clear();
        twoDaysAfter.set(2011, 8, 11, 23, 59, 59);
        Calendar extended = RulesOf6005.extendDeadline(4, 2, duedate);
        assertEquals(extended.get(Calendar.YEAR), twoDaysAfter.get((Calendar.YEAR)));
        assertEquals(extended.get(Calendar.MONTH), twoDaysAfter.get((Calendar.MONTH)));
        assertEquals(extended.get(Calendar.DATE), twoDaysAfter.get((Calendar.DATE)));
        assertEquals(extended.get(Calendar.HOUR), twoDaysAfter.get((Calendar.HOUR)));
        assertEquals(extended.get(Calendar.MINUTE), twoDaysAfter.get((Calendar.MINUTE)));
        assertEquals(extended.get(Calendar.SECOND), twoDaysAfter.get((Calendar.SECOND)));
        
        duedate = new GregorianCalendar();
        duedate.clear();
        duedate.set(2011, 8, 9, 23, 59, 59);
        Calendar threeDaysAfter = new GregorianCalendar();
        threeDaysAfter.clear();
        threeDaysAfter.set(2011, 8, 12, 23, 59, 59);
        extended = RulesOf6005.extendDeadline(4, 5, duedate);
        assertEquals(extended.get(Calendar.YEAR), threeDaysAfter.get((Calendar.YEAR)));
        assertEquals(extended.get(Calendar.MONTH), threeDaysAfter.get((Calendar.MONTH)));
        assertEquals(extended.get(Calendar.DATE), threeDaysAfter.get((Calendar.DATE)));
        assertEquals(extended.get(Calendar.HOUR), threeDaysAfter.get((Calendar.HOUR)));
        assertEquals(extended.get(Calendar.MINUTE), threeDaysAfter.get((Calendar.MINUTE)));
        assertEquals(extended.get(Calendar.SECOND), threeDaysAfter.get((Calendar.SECOND)));
	}

    /**
     * Test of main method, of class RulesOf6005.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        RulesOf6005.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
