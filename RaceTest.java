// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Joshua Murphy (Jmmurphy), Connor Pepin (connorpepin), Kebron Zike
// (kebronZike)

// -------------------------------------------------------------------------

package prj5;

/**
 * this is the testing class for the race class
 * 
 * @author Joshua Murphy (jmmurphy)
 * @author Connor Pepin (connorpepin)
 * @author Kebron Zike (kebronZike)
 * @version 2021.11.17
 *
 */
public class RaceTest extends student.TestCase {
    private Race tester;

    /**
     * this will set up the test methods for the race class
     */
    public void setUp() {
        tester = new Race("black", "10", "10");
    }


    /**
     * this will test the get race class
     */
    @SuppressWarnings("static-access")
    public void testgetRace() {
        assertEquals(tester.getRace(), "black");
    }


    /**
     * this will test the getdeaths method
     */
    public void testgetDeaths() {
        assertEquals(tester.getDeaths(), 10, 0.01);
    }


    /**
     * this will test the getCasess method
     */
    public void testgetCases() {
        assertEquals(tester.getCases(), 10, 0.01);
    }


    /**
     * this will test the equals method for race
     */
    @SuppressWarnings("static-access")
    public void testEquals() {
        Race empty = null;
        assertFalse(tester.equals(empty));
        Race test1 = new Race("black", "4", "3");
        assertFalse(tester.equals(test1));
        Race test2 = new Race("black", "10", "3");
        assertFalse(tester.equals(test2));
        @SuppressWarnings("unused")
        Race test3 = new Race("black", "10", "10");
        assertFalse(tester.equals(test1));
        Race copy = new Race("black", "10", "10");
        assertTrue(tester.equals(copy));
        assertTrue(tester.equals(tester));
    }


    /**
     * this will test the calculateCFR method
     */
    public void testcalculateCFR() {
        Race temp = new Race("black", "-1", "10");
        Race temp2 = new Race("black", "10", "-1");
        assertEquals(temp.calculateCFR(), -1, 0.01);
        assertEquals(temp2.calculateCFR(), -1, 0.01);
        assertEquals(tester.calculateCFR(), 100.0, 0.01);
    }


    /**
     * this will test the toString method
     */
    public void testtoString() {
        assertEquals(tester.toString(), "black: 10 cases, 100% CFR");
    }

}
