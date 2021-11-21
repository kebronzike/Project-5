package prj5;

import java.util.Comparator;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Joshua Murphy (Jmmurphy), Connor Pepin (connorpepin), Kebron Zike
// (kebronZike)

// -------------------------------------------------------------------------
/**
 * Stores the data for the project
 * 
 * @author Joshua Murphy (jmmurphy)
 * @author Connor Pepin (connorpepin)
 * @author Kebron Zike (kebronZike)
 * @version 2021.11.15
 * 
 */
public class CompareAlpha implements Comparator<Race> {

    /**
     * Thia compares race objects by alpha
     * 
     * @param o1
     *            the first race getting compared
     * @param o2
     *            the second race getting compared
     */
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
