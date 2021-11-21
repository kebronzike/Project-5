package prj5;

public class Race implements Comparable<Race> {
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
    public int getDeaths() {
        if (fatalities == "NA") {
            return -1;
        }
        return Integer.parseInt(fatalities);
    }


    /**
     * this will get the total cases for a race
     * 
     * @return String of cases
     */
    public int getCases() {
        if (fatalities == "NA") {
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
        str.append(getCases() + " cases, ");
        str.append(getDeaths() + " deaths, ");
        str.append(calculateCFR() + "% CFR");
        return str.toString();
    }


    @Override
    public int compareTo(Race o) {
        return 0;
    }
}
