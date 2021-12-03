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
 * this will test the Covid calc class
 * 
 * @author Joshua Murphy (jmmurphy)
 * @author Kebron Zike (kebronZike)
 * @version 2021.11.20
 */
public class CovidCalcTest extends student.TestCase {
    private State dc;
    private State va;
    private LinkedList<Race> races;
    private LinkedList<Race> races2;
    private LinkedList<State> states;
    private CovidCalc test;

    /**
     * this will setUp the test methods
     */
    public void setUp() {
        races = new LinkedList<Race>();
        races2 = new LinkedList<Race>();
        races2.add(new Race("black", "4000", "800"));
        races2.add(new Race("asian", "5000", "80"));
        races2.add(new Race("white", "99000", "500"));
        races2.add(new Race("latinx", "200", "80"));
        races2.add(new Race("other", "1000", "134"));

        races.add(new Race("black", "2000", "7"));
        races.add(new Race("asian", "400", "4"));
        races.add(new Race("white", "6000", "5"));
        races.add(new Race("latinx", "200", "8"));
        races.add(new Race("other", "100", "10"));
        va = new State("Virginia", races);
        dc = new State("DC", races2);
        states = new LinkedList<State>();
        states.add(dc);
        states.add(va);
        test = new CovidCalc(states);

    }


    /**
     * this will test the toString method
     */
    public void testtoString() {
        assertEquals(test.toString(), "DC\r\n"
            + "asian: 5000 cases, 1.6% CFR\r\n"
            + "black: 4000 cases, 20% CFR\r\n"
            + "latinx: 200 cases, 40% CFR\r\n"
            + "other: 1000 cases, 13.4% CFR\r\n"
            + "white: 99000 cases, 0.5% CFR\r\n" + "=====\r\n"
            + "black: 4000 cases, 20% CFR\r\n"
            + "latinx: 200 cases, 40% CFR\r\n"
            + "other: 1000 cases, 13.4% CFR\r\n"
            + "asian: 5000 cases, 1.6% CFR\r\n"
            + "white: 99000 cases, 0.5% CFR\r\n" + "=====\r\n" + "Virginia\r\n"
            + "asian: 400 cases, 1% CFR\r\n" + "latinx: 200 cases, 4% CFR\r\n"
            + "black: 2000 cases, 0.4% CFR\r\n"
            + "other: 100 cases, 10% CFR\r\n"
            + "white: 6000 cases, 0.1% CFR\r\n" + "=====\r\n"
            + "latinx: 200 cases, 4% CFR\r\n" + "asian: 400 cases, 1% CFR\r\n"
            + "other: 100 cases, 10% CFR\r\n"
            + "black: 2000 cases, 0.4% CFR\r\n"
            + "white: 6000 cases, 0.1% CFR\r\n" + "=====\r\n");
    }


    /**
     * this will test the sort by Alpha method
     */
    public void testsortByAlpha() {
        test.sortByAlpha();
        assertEquals(test.toString(), "DC\r\n"
            + "asian: 5000 cases, 1.6% CFR\r\n"
            + "black: 4000 cases, 20% CFR\r\n"
            + "latinx: 200 cases, 40% CFR\r\n"
            + "other: 1000 cases, 13.4% CFR\r\n"
            + "white: 99000 cases, 0.5% CFR\r\n" + "=====\r\n"
            + "black: 4000 cases, 20% CFR\r\n"
            + "latinx: 200 cases, 40% CFR\r\n"
            + "other: 1000 cases, 13.4% CFR\r\n"
            + "asian: 5000 cases, 1.6% CFR\r\n"
            + "white: 99000 cases, 0.5% CFR\r\n" + "=====\r\n" + "Virginia\r\n"
            + "asian: 400 cases, 1% CFR\r\n" + "latinx: 200 cases, 4% CFR\r\n"
            + "black: 2000 cases, 0.4% CFR\r\n"
            + "other: 100 cases, 10% CFR\r\n"
            + "white: 6000 cases, 0.1% CFR\r\n" + "=====\r\n"
            + "latinx: 200 cases, 4% CFR\r\n" + "asian: 400 cases, 1% CFR\r\n"
            + "other: 100 cases, 10% CFR\r\n"
            + "black: 2000 cases, 0.4% CFR\r\n"
            + "white: 6000 cases, 0.1% CFR\r\n" + "=====\r\n");
    }


    /**
     * this will test the sort by CFR method
     */
    public void testsortByCFR() {
        test.sortByCFR();
        assertEquals(test.toString(), "DC\r\n"
            + "asian: 5000 cases, 1.6% CFR\r\n"
            + "black: 4000 cases, 20% CFR\r\n"
            + "latinx: 200 cases, 40% CFR\r\n"
            + "other: 1000 cases, 13.4% CFR\r\n"
            + "white: 99000 cases, 0.5% CFR\r\n" + "=====\r\n"
            + "black: 4000 cases, 20% CFR\r\n"
            + "latinx: 200 cases, 40% CFR\r\n"
            + "other: 1000 cases, 13.4% CFR\r\n"
            + "asian: 5000 cases, 1.6% CFR\r\n"
            + "white: 99000 cases, 0.5% CFR\r\n" + "=====\r\n" + "Virginia\r\n"
            + "asian: 400 cases, 1% CFR\r\n" + "latinx: 200 cases, 4% CFR\r\n"
            + "black: 2000 cases, 0.4% CFR\r\n"
            + "other: 100 cases, 10% CFR\r\n"
            + "white: 6000 cases, 0.1% CFR\r\n" + "=====\r\n"
            + "latinx: 200 cases, 4% CFR\r\n" + "asian: 400 cases, 1% CFR\r\n"
            + "other: 100 cases, 10% CFR\r\n"
            + "black: 2000 cases, 0.4% CFR\r\n"
            + "white: 6000 cases, 0.1% CFR\r\n" + "=====\r\n");
    }


    /**
     * this will test the getState method
     */
    public void testgetState() {
        assertEquals(test.getState(), states);
    }

}
