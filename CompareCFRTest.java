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
 * This tests all methods in the compareCFR class
 * 
 * @author Joshua Murphy (jmmurphy)
 * @author Connor Pepin (connorpepin)
 * @author Kebron Zike (kebronZike)
 * @version 2021.11.15
 * 
 */
public class CompareCFRTest extends student.TestCase {

    private CompareCFR test1;
    private Race a;
    private Race b;
    private Race c;

    /**
     * this will set up the test methods
     */
    public void setUp() {
        test1 = new CompareCFR();
        a = new Race("a", "10000", "1000");
        b = new Race("b", "10000", "10000");
        c = new Race("c", "10000", "200");
    }


    /**
     * this will test the CompareAlpha compare method
     */
    public void testCompareAlpha() {
        assertEquals(test1.compare(a, b), 1);
        assertEquals(test1.compare(b, a), -1);
        assertEquals(test1.compare(c, c), 1);
    }
}
