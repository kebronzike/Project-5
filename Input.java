package prj5;

import java.io.FileNotFoundException;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Joshua Murphy (Jmmurphy)

// -------------------------------------------------------------------------
/**
 * This class runs the project
 * 
 * @author Joshua Murphy (jmmurphy)
 * @author Connor Pepin (connorpepin)
 * @author Kebron Zike (kebronZike)
 * @version 2021.11.15
 */
public class Input {
    @SuppressWarnings("unused")
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 1) {
            Reader state = new Reader(args[0]);
        }
        else {
            Reader state = new Reader(
                "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        }
    }
}
