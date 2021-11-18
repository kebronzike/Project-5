package prj5;

//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- Joshua Murphy (Jmmurphy), Connor Pepin (connorpepin), Kebron Zike
//(kebronZike)

//-------------------------------------------------------------------------
/**
* Tests the Race Class
* 
* @author Joshua Murphy (jmmurphy)
* @author Connor Pepin (connorpepin)
* @author Kebron Zike (kebronZike)
* @version 2021.11.15
* 
*/
public class RaceTest extends student.TestCase {
    private Race tester;
    private RaceEnum enumrace;

    /**
     * this will set up the test methods for the race class
     */
    public void setUp() {
        tester = new Race(RaceEnum.BLACK, "10", "10", "Virginia");
    }


    /**
     * this will test the get state method
     */
    public void testgetState() {
        assertEquals(tester.getState(), "Virginia");
    }


    /**
     * this will test the get race class
     */
    @SuppressWarnings("static-access")
    public void testgetRace() {
        assertEquals(tester.getRace(), enumrace.BLACK);
    }


    /**
     * this will test the getdeaths method
     */
    public void testgetDeaths() {
        assertEquals(tester.getDeaths(), "10");
    }


    /**
     * this will test the getCasess method
     */
    public void testgetCases() {
        assertEquals(tester.getCases(), "10");
    }


    /**
     * this will test the equals method for race
     */
    @SuppressWarnings("static-access")
    public void testEquals() {
        Race empty = null;
        assertFalse(tester.equals(empty));
        Race test1 = new Race(enumrace.BLACK, "4", "3", "Georgia");
        assertFalse(tester.equals(test1));
        Race test2 = new Race(enumrace.BLACK, "10", "3", "Georgia");
        assertFalse(tester.equals(test2));
        @SuppressWarnings("unused")
        Race test3 = new Race(enumrace.BLACK, "10", "10", "Georgia");
        assertFalse(tester.equals(test1));
        Race copy = new Race(enumrace.BLACK, "10", "10", "Virginia");
        assertTrue(tester.equals(copy));
        assertTrue(tester.equals(tester));
    }


    /**
     * this will test the toString method
     */
    public void testtoString() {
        assertEquals(tester.toString(),
            "Race: BLACK Cases: 10 Deaths: 10 State: Virginia");
    }

}
