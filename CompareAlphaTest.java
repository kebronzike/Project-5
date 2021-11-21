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
* This class tests the compareAlpha class
* 
* @author Joshua Murphy (jmmurphy)
* @author Connor Pepin (connorpepin)
* @author Kebron Zike (kebronZike)
* @version 2021.11.15
* 
*/
public class CompareAlphaTest extends student.TestCase {

    private CompareAlpha test1;
    private Race a;
    private Race b;
    private Race c;

    /**
     * this will set up the test methods
     */
    public void setUp() {
        test1 = new CompareAlpha();
        a = new Race("a", "10", "10");
        b = new Race("b", "10", "10");
        c = new Race("c", "10", "10");
    }


    /**
     * this will test the CompareAlpha compare method
     */
    public void testCompareAlpha() {
        assertEquals(test1.compare(a, b), -1);
        assertEquals(test1.compare(c, b), 1);
        assertEquals(test1.compare(a, a), 1);
    }

}
