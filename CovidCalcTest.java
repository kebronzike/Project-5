package prj5;

import student.TestCase;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Joshua Murphy (Jmmurphy), Connor Pepin (connorpepin), Kebron Zike
// (kebronZike)

// -------------------------------------------------------------------------

/**
 * Tests for the Covid Calculator
 * 
 * @author Joshua Murphy (jmmurphy)
 * @author Connor Pepin (connorpepin)
 * @author Kebron Zike (kebronZike)
 * @version 2021.11.17
 *
 */
public class CovidCalcTest extends TestCase {
    private CovidCalc calc;
    private LinkedList<Race> races;
    private LinkedList<Race> races2;
    private LinkedList<State> states;
    private State VA;
    private State DC;

    /**
     * this will setUp the test methods
     */
    public void setUp() {
        races = new LinkedList<Race>();
        races2 = new LinkedList<Race>();
        races2.add(new Race("black", "4000", "800"));
        races2.add(new Race("asian", "5000", "80"));

        races.add(new Race("black", "2000", "7"));
        races.add(new Race("asian", "400", "4"));

        VA = new State("VA", races);
        DC = new State("DC", races2);
        states = new LinkedList<State>();
        states.add(DC);
        states.add(VA);
        calc = new CovidCalc(states);
    }


    /**
     * tests toString
     */
    public void testToString() {
        System.out.print(calc.toString());
        assertEquals(calc.toString(), "DC\r\n"
            + "asian: 5000 cases, 1.6% CFR\r\n"
            + "black: 4000 cases, 20% CFR\r\n" + "=====\r\n"
            + "black: 4000 cases, 20% CFR\r\n"
            + "asian: 5000 cases, 1.6% CFR\r\n" + "=====\r\n" + "VA\r\n"
            + "asian: 400 cases, 1% CFR\r\n" + "black: 2000 cases, 0.4% CFR\r\n"
            + "=====\r\n" + "asian: 400 cases, 1% CFR\r\n"
            + "black: 2000 cases, 0.4% CFR\r\n" + "=====\r\n" + "");
    }


    /**
     * Tests the getState method
     */
    public void testGetState() {
        assertEquals(states, calc.getState());
    }


    /**
     * Tests the sortAlpha method
     */
    public void testSortAlpha() {
        LinkedList<State> aSortStates = new LinkedList<State>();
        LinkedList<Race> sortARaces = new LinkedList<Race>();
        sortARaces.add(new Race("black", "4000", "800"));
        sortARaces.add(new Race("white", "5000", "80"));
        sortARaces.add(new Race("asian", "5000", "80"));
        State newStates = new State("new", sortARaces);
        aSortStates.add(newStates);
        CovidCalc calc = new CovidCalc(aSortStates);

        calc.sortAlpha();
        assertEquals(aSortStates, "asian: 5000 cases, 1.6% CFR\r\n"
            + "black: 4000 cases, 20% CFR\r\n" +"");
    }

}
