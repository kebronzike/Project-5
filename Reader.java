package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Joshua Murphy (Jmmurphy), Connor Pepin (connorpepin), Kebron Zike
// (kebronZike)

// -------------------------------------------------------------------------

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * this is the reader class, it will take in a file and create a covidcalc
 * instance in order to intiate the program
 * 
 * @author Joshua Murphy (jmmurphy)
 * @author Connor Pepin (connorpepin)
 * @author Kebron Zike (kebronZike)
 * @version 2021.11.17
 *
 */

public class Reader {

    private Scanner filereader;
    private LinkedList<Race>[] races;
    public static final int STARTING_INDEX = 1;
    public static final int FINAL_INDEX = 6;

    /**
     * the constructor for the covidreader class
     * 
     * @param theFileName
     *            the file name
     * @throws FileNotFoundException
     *             will throw when a file is not found
     */
    public Reader(String theFileName) throws FileNotFoundException {
        races = readFiles(theFileName);
        CovidCalc calc = new CovidCalc(races);
        calc.toString();

    }


    /**
     * this method will be responsible for reading the data from the spread
     * sheet of cases for states and its races
     * 
     * @param filename
     *            the filename
     * @return LinkedList<Race> races
     * @throws FileNotFoundException
     */
    public LinkedList<Race>[] readFiles(String fileName)

        throws FileNotFoundException {
        filereader = new Scanner(new File((fileName)));
        filereader.nextLine();
        while (filereader.hasNextLine()) {
            String readline = filereader.nextLine();
            String[] readNext = readline.split(",");
            for (int index = STARTING_INDEX; index <= readNext.length
                - FINAL_INDEX; index++) {
                String deaths = readNext[5 + index];
                String cases = readNext[index];

            }

        }
        filereader.close();

        return races;

    }

}
