package prj5;

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
        assertEquals(tester.getDeaths(), 10);
    }


    /**
     * this will test the getCasess method
     */
    public void testgetCases() {
        assertEquals(tester.getCases(), 10);
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
     * this will test the compareTo method
     */
    public void testcompareTo() {

        Race test1 = new Race(RaceEnum.ASIAN, "10", "10", "Virginia");
        Race test2 = new Race(RaceEnum.WHITE, "10", "10", "Virginia");
        System.out.print(test2.getRace().toString());
        assertEquals(tester.compareTo(tester), 0);
        assertEquals(test1.compareTo(tester), -1);
        assertEquals(tester.compareTo(test1), 1);

    }


    /**
     * this will test the toString method
     */
    public void testtoString() {
        assertEquals(tester.toString(),
            "Race: BLACK Cases: 10 Deaths: 10 State: Virginia");
    }

}
