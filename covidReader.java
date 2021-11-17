package prj5;

import java.util.Scanner;

public class covidReader {

    private Scanner filereader;
    private LinkedList<Race> races;
    /**
     * the minimum amount of states read
     */
    public static final int STATE_MIN = 1;
    /**
     * the maximum amount of states being read in the file
     */
    public static final int STATE_MAX = 6;

    public covidReader(String theFileName) {
        races = readData(theFileName);

    }


    /**
     * this method will be responsible for reading the data from the spread
     * sheet of cases for states and races
     * 
     * @param filename
     * @return
     */
    public LinkedList<Race> readData(String filename) {
        return races;
        
    }

}
