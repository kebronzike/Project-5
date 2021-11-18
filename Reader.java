package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- Joshua Murphy (Jmmurphy), Connor Pepin (connorpepin), Kebron Zike
//(kebronZike)

//-------------------------------------------------------------------------
/**
* This class reads the data
* 
* @author Joshua Murphy (jmmurphy)
* @author Connor Pepin (connorpepin)
* @author Kebron Zike (kebronZike)
* @version 2021.11.15
* 
*/
public class Reader {

    private Scanner filereader;
    private LinkedList<Race> races;
    private String deaths;
    private String cases;
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
        races = new LinkedList<>();
        races = readFiles(theFileName);

    }


    /**
     * this method will be responsible for reading the data from the spread
     * sheet of cases for states and its races
     * 
     * @param filename
     *            the filename
     * @return LinkedList<Race> races
     *            the list of all the races for a certain state
     * @throws FileNotFoundException
     */
    public LinkedList<Race> readFiles(String fileName)
        throws FileNotFoundException {
        filereader = new Scanner(new File((fileName)));
        filereader.nextLine();
        while (filereader.hasNextLine()) {
            String readline = filereader.nextLine();
            String[] readNext = readline.split(",");
            for (int index = STARTING_INDEX; index <= readNext.length
                - FINAL_INDEX; index++) {
                deaths = readNext[5 + index];
                cases = readNext[index];
                races.add(new Race(RaceEnum.values()[index - FINAL_INDEX],
                    cases, deaths, readNext[0]));

            }

        }
        filereader.close();

        return races;

    }

}
