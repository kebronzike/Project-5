// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Joshua Murphy (Jmmurphy), Connor Pepin (connorpepin), Kebron Zike
// (kebronZike)

// -------------------------------------------------------------------------

package prj5;

/**
 * this is the Race class, it takes in a name, cases, and deaths and has
 * multiple methods
 * 
 * @author Joshua Murphy (jmmurphy)
 * @author Connor Pepin (connorpepin)
 * @author Kebron Zike (kebronZike)
 * @version 2021.11.15
 */
public class Race {
    private String raceName;
    private String fatalities;
    private String totalcases;

    /**
     * this is the constructor for races, this will create a race that is made
     * up of races, deaths, and cases
     * 
     * @param races
     *            the race
     * @param deaths
     *            the deaths for the race
     * @param cases
     *            the cases for the race
     */
    public Race(String name, String cases, String deaths) {
        raceName = name;
        fatalities = deaths;
        totalcases = cases;

    }


    /**
     * this will get the race
     * 
     * @return the race
     */
    public String getRace() {
        return raceName;
    }


    /**
     * this will return the deaths for the race
     * 
     * @return String deaths
     */
    public double getDeaths() {
        if (fatalities.equals("NA")) {
            return -1;
        }
        return Integer.parseInt(fatalities);
    }


    /**
     * this will get the total cases for a race
     * 
     * @return String of cases
     */
    public double getCases() {
        if (totalcases.equals("NA")) {
            return -1;
        }
        return Integer.parseInt(totalcases);
    }


    /**
     * this will compare two races to see whether or not they are equivalent
     * 
     * @return boolean true/false
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(this.getClass())) {
            Race race1 = (Race)obj;
            if (this.raceName.equals(race1.getRace()) && Integer.parseInt(
                totalcases) == race1.getCases() && Integer.parseInt(
                    fatalities) == race1.getDeaths()) {
                return true;
            }
        }
        return false;
    }


    /**
     * Takes the deaths and cases of a race
     * and calulates the CFR
     * 
     * 
     * @param deaths
     *            the number of deaths
     * @param cases
     *            the number of cases
     * @return the Covid Fatality Ratio
     */
    public double calculateCFR() {
        if (getCases() == -1 || getDeaths() == -1) {
            return -1;
        }
        return (getDeaths() / getCases()) * 100;
    }


    /**
     * this will return the race information in a String format
     * 
     * @return String race info
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(raceName + ": ");
        str.append((int)getCases() + " cases, ");
        if (((calculateCFR() % 1) < 0.05)) {
            str.append((int)calculateCFR() + "% CFR");
        }
        else {
            str.append(String.format("%.1f", calculateCFR()) + "% CFR");
        }
        return str.toString();
    }
}
