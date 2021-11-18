package prj5;

//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- Joshua Murphy (Jmmurphy), Connor Pepin (connorpepin), Kebron Zike
//(kebronZike)

//-------------------------------------------------------------------------
/**
* This class creates race objects that store the 
* the covid cases and deaths
* 
* @author Joshua Murphy (jmmurphy)
* @author Connor Pepin (connorpepin)
* @author Kebron Zike (kebronZike)
* @version 2021.11.15
* 
*/
public class Race {
    private RaceEnum enumrace;
    private String fatalities;
    private String totalcases;
    private String homestate;

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
    public Race(RaceEnum races, String cases, String deaths, String state) {
        enumrace = races;
        fatalities = deaths;
        totalcases = cases;
        homestate = state;
    }


    /**
     * this will get the state of a race
     * 
     * @return the state
     */
    public String getState() {
        return homestate;
    }


    /**
     * this will get the race
     * 
     * @return the race
     */
    public RaceEnum getRace() {
        return enumrace;
    }


    /**
     * this will return the deaths for the race
     * 
     * @return String deaths
     */
    public String getDeaths() {
        return fatalities;
    }


    /**
     * this will get the total cases for a race
     * 
     * @return String of cases
     */
    public String getCases() {
        return totalcases;
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
            if (this.enumrace.equals(race1.getRace()) && this.totalcases.equals(
                race1.getCases()) && this.fatalities.equals(race1.getDeaths())
                && this.homestate.equals(race1.getState())) {
                return true;
            }
        }
        return false;
    }


    /**
     * this will return the race information in a String format
     * 
     * @return String race info
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Race: ");
        str.append(enumrace);
        str.append(" Cases: ");
        str.append(totalcases);
        str.append(" Deaths: ");
        str.append(fatalities);
        str.append("State: ");
        str.append(homestate);
        return str.toString();
    }

}
