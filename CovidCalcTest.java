/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * Tests for the Covid Calculator
 * 
 * @author Joshua Murphy (jmmurphy)
 * @author Connor Pepin (connorpepin)
 * @author Kebron Zike (kebronZike)
 * @version 2021.11.17
 *
 */
public class CovidCalcTest extends TestCase {

    private CovidCalc calc;
    
    
    //CFR of 200
    private Race race1;
    
    //CFR of 150
    private Race race2;
    
    //CFR of 100
    private Race race3;
    
    //CFR of 50
    private Race race4;
    
    
    private LinkedList<Race>[] unsortedStates;
    
    

    
    
    /**
     * Set up is ran before every test method
     */
    public void setUp()
    {
        race1 = new Race(RaceEnum.ASIAN, "1", "3", "Virginia");
        
        race2 = new Race(RaceEnum.WHITE, "1", "2", "Virginia");
        
        race3 = new Race(RaceEnum.BLACK, "1", "1", "Virginia");
        
        race4 = new Race(RaceEnum.LATINX, "2", "1", "Virginia");
        
        calc = new CovidCalc(unsortedStates);
    }
    
    
    //-----------------TEST METHODS-------------------
    
    
    
    /**
     * Tests the sort by CFR method
     */
    public void testSortByCFR()
    {
        //Set up an unsorted list
        LinkedList<Race> unsortedList = new LinkedList();
        
        //add the races in reverse order
        unsortedList.add(race4);
        unsortedList.add(race3);
        unsortedList.add(race2);
        unsortedList.add(race1);
        
        
        //sort the list
        LinkedList<Race> sorted = calc.sortByCFR(unsortedList);
        
        //the order should be race 4, race 3, race 2, race 1
        assertEquals("{Race: ASIAN Cases: 1 Deaths: 3 State: Virginia, "
            + "Race: WHITE Cases: 1 Deaths: 2 State: Virginia, "
            + "Race: BLACK Cases: 1 Deaths: 1 State: Virginia, "
            + "Race: LATINX Cases: 2 Deaths: 1 State: Virginia}", 
            sorted.toString());
        
    }
    
    
    
    
}
