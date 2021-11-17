/**
 * 
 */
package prj5;

import java.lang.reflect.Array;

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

    
   
    LinkedList<Race>[] unsortedStates;
    LinkedList<Race>[] sortedStates;
    
    
    
    /**
     * Constructor for the CovidCalc class
     */
    public CovidCalc(LinkedList<Race>[] states)
    {
        this.unsortedStates = states;
    }
    
    
    
    
    /**
     * Takes an unsorted list of races and sorts them
     * based on their alphabetically by state
     * 
     * @param unsortedList the list you want sorted
     * @return the list after it has been sorted
     */
    @SuppressWarnings("unchecked")
    public void sortByAlpha(LinkedList<Race>[] unsortedArray)
    {
        //make a blank array the length of the unsorted one
        LinkedList<Race>[] newArray = new LinkedList[unsortedArray.length];
        
        
        for (int i = 0; i < unsortedArray.length - 1; i++)
        {
            for (int j = 0; j < unsortedArray.length; j++)
            {
                if (unsortedArray[i].compareTo(unsortedArray[j]) > 0)
                {
                    
                }
            }
        }
        
        
        //Set our sorted states field to our now sorted array
        this.sortedStates = newArray;
        
        
    }
    
    
    
    
    /**
     * Takes an unsorted list of races and sorts them
     * based on their CFR
     * 
     * @param unsortedList the list you want sorted
     * @return the list after it has been sorted
     */
    public LinkedList<Race> sortByCFR(LinkedList<Race> unsortedList)
    {
        
        
        LinkedList<Race> newList = new LinkedList<Race>();
        
        
        
        
        
        
        return newList;
        
    }
    
    
    
    
    
    
    /**
     * Takes the deaths and cases of a race
     * and calulates the CFR
     * 
     * 
     * @param deaths the number of deaths
     * @param cases the number of cases
     * @return the Covid Fatality Ratio
     */
    private int calculateCFR(int deaths, int cases)
    {
        
        return (deaths/cases)*100;
        
    }
    
    
    
}
