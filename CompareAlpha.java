package prj5;

import java.util.Comparator;

public class CompareAlpha implements Comparator<Race>{

    @Override
    public int compare(Race o1, Race o2) {
        if (o1.getRace().compareTo(o2.getRace()) < 0) {
            return -1;
        }
        else if (o1.getRace().compareTo(o2.getRace()) > 0) {
            return 1;
        }
        else {
            return 0;
        }
    }

}
