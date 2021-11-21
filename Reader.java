package prj5;

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
    private LinkedList<State> states;
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
        states = readFiles(theFileName);
        CovidCalc calc = new CovidCalc(states);
        System.out.print(calc.toString());
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
    public LinkedList<State> readFiles(String fileName)
        throws FileNotFoundException {
        LinkedList<State> states = new LinkedList<State>();
        Scanner reader = new Scanner(new File(fileName));
        String[] stateNames = reader.nextLine().split(", *");

        for (int i = 1; i < stateNames.length; i++) {
            String[] str = stateNames[i].split("_");
            stateNames[i] = str[1];
        }

        while (reader.hasNextLine()) {
            LinkedList<Race> race = new LinkedList<Race>();
            String str = reader.nextLine();
            String[] division = str.split(", *");

            for (int i = 1; i < (division.length / 2) + 1; i++) {
                int index = 0;
                for (int j = i; j < division.length; j++) {
                    if (stateNames[i].equals(stateNames[j])) {
                        index = j;
                    }
                }
                Race race1 = new Race(stateNames[i], division[i],
                    division[index]);
                    race.add(race1);
            }
            states.add(new State(division[0], race));
        }
        return states;
    }
}
