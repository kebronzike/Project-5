package prj5;

import java.util.Comparator;

public class CompareCFR implements Comparator<Race> {

    @Override
    public int compare(Race o1, Race o2) {
        if (o1.calculateCFR() > o2.calculateCFR()) {
            return -1;
        }
        else if (o1.calculateCFR() < o2.calculateCFR()) {
            return 1;
        }
        else {
            return 0;
        }
    }

}
