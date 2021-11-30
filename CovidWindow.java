package prj5;

import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

public class CovidWindow {

    
    private Button[] stateButtons;
    private Button quit;
    private Button sortAlpha;
    private Button sortCFR;
    private Window window;
    private CovidCalc calc;
    
    public CovidWindow(CovidCalc data) {
        //Initiallizes window and CovidCalc objects
        window = new Window("Covid Display");
        calc = data;
        // Adding all the buttons to window
        int buttonSize = calc.getState().size();
        stateButtons = new Button[buttonSize];
        for(int i = 0; i < buttonSize; i++) {
        stateButtons[i] = new Button("Reprsents " + calc.getState().get(i).getStateName());
        window.addButton(stateButtons[i], WindowSide.SOUTH);
        stateButtons[i].onClick(this);
        }
        
        sortAlpha = new Button("Sort By Alpha");
        window.addButton(sortAlpha, WindowSide.NORTH);
        sortAlpha.onClick(this);
        
        quit = new Button("Quit");
        window.addButton(quit, WindowSide.NORTH);
        quit.onClick(this);
        
        sortCFR = new Button("Sort By CFR");
        window.addButton(sortCFR, WindowSide.NORTH);
        sortCFR.onClick(this);
    }
    
    
    /**
     * This method closes the window
     * 
     * @param button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }
    
}
