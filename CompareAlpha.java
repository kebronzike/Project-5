// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Joshua Murphy (Jmmurphy), Connor Pepin (connorpepin), Kebron Zike
// (kebronZike)

// -------------------------------------------------------------------------

package prj5;

import java.util.Comparator;

/**
 * this will create the CompareAlpha class
 * 
 * @author Joshua Murphy (jmmurphy)
 * @author Kebron Zike (kebronZike)
 * @version 2021.11.20
 */
public class CompareAlpha implements Comparator<Race> {

    @Override
    public int compare(Race o1, Race o2) {
        if (o1.getRace().compareTo(o2.getRace()) < 0) {
            return -1;
        }
        else if (o1.getRace().compareTo(o2.getRace()) > 0) {
            return 1;
        }
        else {
            return 0;
        }
    }

}
