package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Joshua Murphy (Jmmurphy), Connor Pepin (connorpepin), Kebron Zike
// (kebronZike)

// -------------------------------------------------------------------------

/**
 * Implements the sorting functions so you can
 * sort and reagganrge the list based on either
 * the Covid Fatality Rate or by the alphabetically
 * 
 * 
 * @author Joshua Murphy (jmmurphy)
 * @author Connor Pepin (connorpepin)
 * @author Kebron Zike (kebronZike)
 * @version 2021.11.17
 *
 */
public class CovidCalc {
    public LinkedList<State> allStates;

    /**
     * Constructor for the CovidCalc class
     */
    public CovidCalc(LinkedList<State> states) {
        allStates = states;
    }


    /**
     * Takes an unsorted list of races and sorts them
     * based on their alphabetically by state
     * 
     * @param unsortedList
     *            the list you want sorted
     * @return
     * @return the list after it has been sorted
     */
    public void sortAlpha() {
        for (int i = 0; i < allStates.size(); i++) {
            allStates.get(i).sortAlpha();
        }
    }


    /**
     * Takes an unsorted list of races and sorts them
     * based on their CFR
     * 
     * @param unsortedList
     *            the list you want sorted
     * @return the list after it has been sorted
     */
    public void sortByCFR() {
        for (int i = 0; i < allStates.size(); i++) {
            allStates.get(i).sortCFR();
        }
    }


    /**
     * Turns the sorted data into a string
     * 
     * @return
     *         a string of all the data
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < allStates.size(); i++) {
            str.append(allStates.get(i).getStateName() + "\n");
            sortAlpha();
            str.append(allStates.get(i).toString());
            str.append("=====\n");
            sortByCFR();
            str.append(allStates.get(i).toString());
            str.append("=====\n");
        }
        return str.toString();
    }


    /**
     * This gets the state in the linked list of states
     * 
     * @param index
     *            the index of the state trying to be found
     * @return
     *         the state trying to be found
     */
    public LinkedList<State> getState() {
        return allStates;
    }

}
