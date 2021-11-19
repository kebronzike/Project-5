/**
 * 
 */
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
        
        int size = unsortedList.size();
        
        
        
        
        
        for (int i = 0; i < size; i++)
        {
            //get initial value for largest CFR
            int largestCFR = calculateCFR(unsortedList.get(0));
            
            int index = 0;
            
            
            //loop through the unsorted list and find the largest CFR
            for (int j = 1; j < unsortedList.size(); j++)
            {
                int potential = calculateCFR(unsortedList.get(j));
                
                //if a larger CFR is found then set that to largest
                if (largestCFR < potential)
                {
                    //store the index this largest is at
                    index = j;
                    
                    //set the new largest
                    largestCFR = potential;
                }
            }
            
            
            //add the largest value to the new list
            newList.add(unsortedList.get(index));
            
            //remove that Race object from the unsortedList
            unsortedList.remove(index);
        }
        
        
        
        
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
    private int calculateCFR(Race race)
    {
        
        return (race.getDeaths() / race.getCases()) * 100;
        
    }
    
    
    
    
    
}
