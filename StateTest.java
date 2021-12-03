package prj5;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Joshua Murphy (Jmmurphy), Connor Pepin (connorpepin), Kebron Zike
// (kebronZike)

// -------------------------------------------------------------------------

/**
 * Test class for the State class
 * 
 * @author Joshua Murphy (jmmurphy)
 * @author Connor Pepin (connorpepin)
 * @author Kebron Zike (kebronZike)
 * @version 2021.11.15
 */
public class StateTest extends student.TestCase {

    private State name;
    private State test1;
    private State copy;
    private State noName;
    private LinkedList<Race> races;
    private LinkedList<Race> empty;

    /**
     * this will set up the test methods
     */
    public void setUp() {
        races = new LinkedList<Race>();
        Race a = new Race("black", "2", "7");
        races.add(a);
        races.add(new Race("asian", "4", "4"));
        races.add(new Race("white", "6", "5"));
        races.add(new Race("latinx", "2", "8"));
        races.add(new Race("other", "10", "100"));
        noName = new State("na", races);
        test1 = new State("Virginia", races);
        copy = new State("Virginia", races);
        name = new State("Virginia", empty);

    }


    /**
     * this will tests the get Races method
     */
    public void testgetRaces() {
        assertEquals(test1.getRaces(), races);
    }


    /**
     * this will test the getStateName method
     */
    public void testgetStateName() {
        assertEquals(test1.getStateName(), "Virginia");
    }


    /**
     * this will test the toString method
     */
    public void testtoString() {
        assertEquals(test1.toString(), "black: 2 cases, 350% CFR\r\n"
            + "asian: 4 cases, 100% CFR\r\n" + "white: 6 cases, 83.3% CFR\r\n"
            + "latinx: 2 cases, 400% CFR\r\n" + "other: 10 cases, 1000% CFR\r\n"
            + "");
    }


    /**
     * this will test the sort alpha and cfr methods
     */
    public void testsortAlphaCFR() {
        test1.sortAlpha();
        assertEquals(test1.toString(), "asian: 4 cases, 100% CFR\r\n"
            + "black: 2 cases, 350% CFR\r\n" + "latinx: 2 cases, 400% CFR\r\n"
            + "other: 10 cases, 1000% CFR\r\n" + "white: 6 cases, 83.3% CFR\r\n"
            + "");
        test1.sortByCFR();
        assertEquals(test1.toString(), "black: 2 cases, 350% CFR\r\n"
            + "latinx: 2 cases, 400% CFR\r\n" + "other: 10 cases, 1000% CFR\r\n"
            + "asian: 4 cases, 100% CFR\r\n" + "white: 6 cases, 83.3% CFR\r\n"
            + "");
    }


    /**
     * this will test the Equals method
     */
    public void testEquals() {
        State empty = null;
        assertTrue(test1.equals(test1));
        assertFalse(test1.equals(empty));
        assertFalse(test1.equals(name));
        assertTrue(test1.equals(copy));
        assertFalse(test1.equals(noName));

    }

}
