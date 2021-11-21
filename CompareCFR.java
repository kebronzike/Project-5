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
 * Compares races by CFR value
 * 
 * @author Joshua Murphy (jmmurphy)
 * @author Connor Pepin (connorpepin)
 * @author Kebron Zike (kebronZike)
 * @version 2021.11.15
 * 
 */
public class CompareCFR implements Comparator<Race> {

    /**
     * This compares races by CFR values
     * 
     * @param o1
     *            the first race being compared
     * @param o2
     *            the second race being compared
     */
    @Override
    public int compare(Race o1, Race o2) {
        if (o1.calculateCFR() > o2.calculateCFR()) {
            return -1;
        }
        else {
            return 1;
        }
    }
}
