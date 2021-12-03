// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Joshua Murphy (Jmmurphy), Connor Pepin (connorpepin), Kebron Zike
// (kebronZike)

// -------------------------------------------------------------------------

package prj5;

import java.awt.Color;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

/**
 * this class will create the window for Project 5, it contains multiple helper
 * methods that will sort the data, alphabetically, by CFR, it also has methods
 * that create the graphs to display the COVID data as well a add headers and
 * labels to the graph
 * 
 * @author Kebron Zike (KebronZike)
 * @author Joshua Murphy (jmmurphy)
 *
 */
public class CovidWindow {
    private Button cfrSort;
    private Button quit;
    private Button prev;
    private Window window;
    private CovidCalc calculator;
    private Button alphaSort;
    private Button[] stateButtons;

    /**
     * constructor for the window
     * 
     * The window is optimized for full screen
     * 
     * @param calc
     *            is the ethnicity calculator data passed
     *            through
     */
    public CovidWindow(CovidCalc calc) {
        calculator = calc;
        window = new Window();
        prev = null;
        // this will create the sort by CFR button
        cfrSort = new Button("Sort by CFR");
        cfrSort.onClick(this, "sortingByCFR");
        // this will create the sort alpha button
        alphaSort = new Button("Sort by Alpha");
        alphaSort.onClick(this, "sortingByAlpha");
        // this will create the quit button
        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        window.addButton(alphaSort, WindowSide.NORTH);
        window.addButton(quit, WindowSide.NORTH);
        window.addButton(cfrSort, WindowSide.NORTH);
        // this for loop will create state buttons based off the array of state
        // buttons
        stateButtons = new Button[calculator.getState().size()];
        for (int i = 0; i < calculator.getState().size(); i++) {
            stateButtons[i] = new Button("Represent " + calculator.getState()
                .get(i).getStateName());
            stateButtons[i].onClick(this, "updateState");
            window.addButton(stateButtons[i], WindowSide.SOUTH);
        }
    }


    /**
     * this will update the window with new information
     * 
     * @param button
     *            represents the button to update window
     */
    private void update(Button button) {
        window.removeAllShapes();
        displayState(button);
        headerDisplay(button);
    }


    /**
     * this will quit the program
     * 
     * @param button
     *            represents the quit button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * this method will go through each state and return a double of the largest
     * CFR out of all the races, the for loop goes through all the races in the
     * state and checks through for the largest CFR
     * 
     * @param state
     *            the state being checked for largest CFR
     * @return double of the greatest CFR
     */
    private double greatestCFR(State state) {
        double greatestCFR = 0;
        for (int i = 0; i < state.getRaces().size(); i++) {
            double temp = state.getRaces().get(i).calculateCFR();
            if (greatestCFR < temp) {
                greatestCFR = temp;
            }
        }
        return greatestCFR;
    }


    /**
     * this will sort the data by alphabetically by race
     * 
     * @param button
     *            represents the sort alpha button
     */
    public void sortingByAlpha(Button button) {
        State state = createStateButton(prev);
        state.sortAlpha();
        update(prev);
    }


    /**
     * this will sort the data by CFR (Case Fatality Ratio)
     * 
     * @param button
     *            represents the sort by CFR button
     */
    public void sortingByCFR(Button button) {
        State state = createStateButton(prev);
        state.sortByCFR();
        update(prev);
    }


    /**
     * this will update the information to switch State
     * 
     * @param button
     *            state being switched
     */
    public void updateState(Button button) {
        prev = button;
        update(button);
    }


    /**
     * this will display the information of cases of COVID for a state by
     * creating a bar graph and sizing them so that they are graphed
     * appropriately. It creates a height and width, with x and y vertices so
     * that the bars can be created and then added to the window
     * 
     * @param button
     *            this will represent the button for displayState
     */
    private void displayState(Button button) {
        State state = createStateButton(button);
        int totalStates = state.getRaces().size();
        // creates the double to hold the largest CFR
        double greatestCFR = greatestCFR(state);
        for (int i = 0; i < state.getRaces().size(); i++) {
            double sizing = state.getRaces().get(i).calculateCFR()
                / greatestCFR;
            int vertHeight = (int)(((window.getHeight() / 2) * (sizing)));
            int vertX = (window.getWidth() / state.getRaces().size() * (i + 1))
                - (window.getWidth() / 10);
            int vertY = (int)(((window.getHeight() / 2) - (window.getHeight()
                / 3)) + ((window.getHeight() / 2) * (1 - sizing)));
            int vertWidth = (window.getWidth() / (state.getRaces().size()
                * 10));
            if (sizing < 1) {
                vertY++;
            }
            if (sizing > 0) {
                window.addShape(new Shape(vertX, vertY, vertWidth, vertHeight,
                    Color.BLUE));
            }
            else {
                TextShape naText = new TextShape(vertX, vertY + vertHeight,
                    "NA", Color.BLACK, 60 / totalStates);
                naText.setY(naText.getY() - naText.getHeight());
                window.addShape(naText);
            }
            stateLabels(state.getRaces().get(i), vertX, vertY + vertHeight,
                totalStates);
        }

    }


    /**
     * this will add the header information into the window, it will say the
     * state name followed by cases fatality ratios by race
     * 
     * @param button
     *            this button represents
     */
    private void headerDisplay(Button button) {
        State state = createStateButton(button);
        String name = state.getStateName() + " Cases Fatality Ratios by Race";
        TextShape head = new TextShape((window.getWidth() / 2), (window
            .getHeight() / 10), (name), Color.BLACK, 20);
        head.setX(head.getX() - (head.getWidth() / 2));
        window.addShape(head);
    }


    /**
     * this will label state graph information and display the text information
     * that comes with it, this would be the race name, followed by the CFR
     * percentage
     * 
     * @param race
     *            this represents the race of the inputed in the state labels
     *            method
     * @param x
     *            this will represent the x coordinate of the vertical bar
     * @param y
     *            this will represent the y coordinate of the vertical bar
     * @param sizing
     *            this will effect the sizing of the font of the labels
     */
    private void stateLabels(Race race, int x, int y, int sizing) {
        // this will get the race name
        String raceName = race.getRace();
        // this will create the font sizing
        int font = 50 / sizing;
        StringBuilder str = new StringBuilder();
        // this create the text labels and add them to the window
        TextShape verticalText = new TextShape(x, y, raceName, Color.BLACK,
            font);
        verticalText.setX(verticalText.getX() - (verticalText.getWidth() / 4));
        verticalText.setY(verticalText.getY() + verticalText.getHeight());
        window.addShape(verticalText);
        // this will add the CFR percentages to the labels of each race
        if (race.calculateCFR() != -1) {
            if (((race.calculateCFR() % 1) < 0.05)) {
                int cfr = (int)race.calculateCFR();
                str.append(cfr + "%");
            }
            else {
                str.append(String.format("%.1f", race.calculateCFR()) + "%");
            }

            TextShape cfr = new TextShape(verticalText.getX(), verticalText
                .getY(), str.toString(), Color.BLACK, font);
            cfr.setY(cfr.getY() + (cfr.getHeight()));

            window.addShape(cfr);
        }
    }


    /**
     * this will create a button for the correct state, and then return that
     * state if it is successfull, or return null if it is not.
     * 
     * @param button
     *            the state button being created
     * @return the state, or null
     */
    private State createStateButton(Button button) {
        for (int i = 0; i < stateButtons.length; i++) {
            if (button.equals(stateButtons[i])) {
                return calculator.getState().get(i);
            }
        }
        return null;
    }

}
