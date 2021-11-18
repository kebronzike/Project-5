package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {

    private Scanner filereader;
    private LinkedList<Race> races;
    private String deaths;
    private String cases;

    /**
     * the constructor for the covidreader class
     * 
     * @param theFileName
     * @throws FileNotFoundException
     */
    public Reader(String theFileName) throws FileNotFoundException {
        races = new LinkedList<>();
        races = readFiles(theFileName);

    }


    /**
     * this method will be responsible for reading the data from the spread
     * sheet of cases for states and races
     * 
     * @param filename
     * @return
     * @throws FileNotFoundException
     */
    public LinkedList<Race> readFiles(String fileName)
        throws FileNotFoundException {
        filereader = new Scanner(new File((fileName)));
        filereader.nextLine();
        while (filereader.hasNextLine()) {
            String readline = filereader.nextLine();
            String[] readNext = readline.split(",");
            for (int index = 1; index <= readNext.length - 6; index++) {
                deaths = readNext[5 + index];
                cases = readNext[index];
                races.add(new Race(RaceEnum.values()[index - 6], cases, deaths,
                    readNext[0]));

            }

        }
        filereader.close();

        return races;

    }

}
