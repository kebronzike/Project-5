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

    private Scanner filereader;
    private LinkedList<Race> states;
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
    public LinkedList<Race> readFiles(String fileName)

        throws FileNotFoundException {
        filereader = new Scanner(new File((fileName)));
        String[] stateNames = filereader.nextLine().split(", *");
        for (int i = 1; i < stateNames.length; i++) {
            String[] names = stateNames[i].split("_");
            stateNames[i] = names[1];
        }
        while (filereader.hasNextLine()) {
            LinkedList<Race> race = new LinkedList<Race>();
            String scan = filereader.nextLine();
            String[] raceData = scan.split(", *");
           
                
            }
            
        }
        filereader.close();
        return state;
    }

}
