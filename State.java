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
 * This represents the state class it is made up of the state name and a
 * linkedlist of races, with geters for the state name and for the linkelist of
 * races, it contains an equals and toString method aswell
 * 
 * @author Joshua Murphy (jmmurphy)
 * @author Connor Pepin (connorpepin)
 * @author Kebron Zike (kebronZike)
 * @version 2021.11.15
 */
public class State {
    private LinkedList<Race> races;
    private String stateName;

    /**
     * this is the constructor for the state class, it takes in a String for the
     * name of the state, and a LinkedList of races
     * 
     * @param name
     *            the name of the state
     * @param race
     *            the linked list of races
     */
    public State(String name, LinkedList<Race> race) {
        races = race;
        stateName = name;
    }


    /**
     * Gets and returns the linked list of races
     * 
     * @return LinkedList<Race>
     *         a linked list of races
     */
    public LinkedList<Race> getRaces() {
        return races;
        // index param for a specific spot in the linkedlist needs review
    }


    /**
     * this will get the name of a state
     * 
     * @return String
     *         the state name
     */
    public String getStateName() {
        return stateName;
    }


    /**
     * this will return the states information in a string format
     * 
     * @return String
     *         a string of the state information
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < races.size(); i++) {
            str.append(races.get(i).toString() + "\n");
        }
        return str.toString();
    }


    /**
     * this will check to see if two state objects are equal by comparing their
     * state names as well as the linked list of races they contain for
     * equivalence
     * 
     * @param Object
     *            obj
     *            the object being passed for equals
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(this.getClass())) {
            State state1 = (State)obj;
            if (this.getStateName().equals(state1.getStateName()) && this
                .getRaces().equals(state1.getRaces())) {
                return true;
            }
        }
        return false;
    }


    /**
     * this will sort the linkedlist of races by alphabetically
     */
    public void sortAlpha() {
        CompareAlpha alpha = new CompareAlpha();
        races.sortList(alpha);
    }


    /**
     * this will sort the linkedlist of races by CFR
     */
    public void sortCFR() {
        CompareCFR cfr = new CompareCFR();
        races.sortList(cfr);
    }

}
