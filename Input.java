// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Joshua Murphy (Jmmurphy), Connor Pepin (connorpepin), Kebron Zike
// (kebronZike)

// -------------------------------------------------------------------------

package prj5;

import java.io.FileNotFoundException;

/**
 * This class runs the project
 * 
 * @author Joshua Murphy (jmmurphy)
 * @author Connor Pepin (connorpepin)
 * @author Kebron Zike (kebronZike)
 * @version 2021.11.15
 */
public class Input {
    public static void main(String[] args) throws FileNotFoundException {
        @SuppressWarnings("unused")
        Reader project = new Reader("Cases_and_Deaths_CRDT_NEW.csv");
    }
}
