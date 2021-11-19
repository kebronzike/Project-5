/**
 * 
 */
package prj5;

import student.TestCase;

//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- Joshua Murphy (Jmmurphy), Connor Pepin (connorpepin), Kebron Zike
//(kebronZike)

//-------------------------------------------------------------------------


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
    
    LinkedList<Race> list1;
    LinkedList<Race> list2;
    LinkedList<Race> list3;
    LinkedList<Race> list4;

    
    
    /**
     * Set up is ran before every test method
     */
    public void setUp()
    {
        race1 = new Race(RaceEnum.ASIAN, "1", "3", "Alabama");
        
        race2 = new Race(RaceEnum.WHITE, "1", "2", "California");
        
        race3 = new Race(RaceEnum.BLACK, "1", "1", "Texas");
        
        race4 = new Race(RaceEnum.LATINX, "2", "1", "Virginia");
        
        
        calc = new CovidCalc(unsortedStates);
        
        
        list1 = new LinkedList<Race>();
        
        list2 = new LinkedList<Race>();
        
        list3 = new LinkedList<Race>();
        
        list4 = new LinkedList<Race>();
        
        
        
        
        
        
    }
    
    
    //-----------------TEST METHODS-------------------
    
    
    /**
     * Tests the sort by alpha method
     */
    public void testSortByAlpha()
    {
        list4.add(race4);
        list3.add(race3);
        list2.add(race2);
        list1.add(race1);
        
        
        @SuppressWarnings("unchecked")
        LinkedList<Race>[] unsortedArray = new LinkedList[4];
        
        //set up the array
        unsortedArray[0] = list4;
        unsortedArray[1] = list3;
        unsortedArray[2] = list2;
        unsortedArray[3] = list1;
        
        
        LinkedList<Race>[] sortedArray = calc.sortByAlpha(unsortedArray);
        
        assertEquals("{Race: ASIAN Cases: 1 Deaths: 3 State: Alabama}", sortedArray[0].toString());
        assertEquals("{Race: WHITE Cases: 1 Deaths: 2 State: California}", sortedArray[1].toString());
        assertEquals("{Race: BLACK Cases: 1 Deaths: 1 State: Texas}", sortedArray[2].toString());
        assertEquals("{Race: LATINX Cases: 2 Deaths: 1 State: Virginia}", sortedArray[3].toString());
    }
    
    
    
    
    
    /**
     * Tests the sort by CFR method
     */
    public void testSortByCFR()
    {
        //Set up an unsorted list
        @SuppressWarnings({ "unchecked", "rawtypes" })
        LinkedList<Race> unsortedList = new LinkedList();
        
        //add the races in reverse order
        unsortedList.add(race4);
        unsortedList.add(race3);
        unsortedList.add(race2);
        unsortedList.add(race1);
        
        
        //sort the list
        LinkedList<Race> sorted = calc.sortByCFR(unsortedList);
        
        //the order should be race 4, race 3, race 2, race 1
        assertEquals("{Race: ASIAN Cases: 1 Deaths: 3 State: Alabama, "
            + "Race: WHITE Cases: 1 Deaths: 2 State: California, "
            + "Race: BLACK Cases: 1 Deaths: 1 State: Texas, "
            + "Race: LATINX Cases: 2 Deaths: 1 State: Virginia}", 
            sorted.toString());
        
    }
    
    
    
    
}
