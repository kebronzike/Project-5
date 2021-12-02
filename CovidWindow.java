package prj5;

import java.awt.Color;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

/**
 * Creates and operates the window on which the data for each
 * states ethnicity is displayed
 * 
 * @author Luke Hylton (lnhylton) Shane Ervin (shaneerv13)
 *         Jacob Albright (jacobalbright77)
 * 
 * @version 04.28.2021
 */
public class CovidWindow {
    private Window window;
    private CovidCalc ethnicityCalculator;
    private Button sortByAlpha;
    private Button sortByCFR;
    private Button quit;
    private Button lastButton;
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
        ethnicityCalculator = calc;
        window = new Window();
        lastButton = null;

        sortByAlpha = new Button("Sort by Alpha");
        sortByAlpha.onClick(this, "clickedSortAlpha");

        sortByCFR = new Button("Sort by CFR");
        sortByCFR.onClick(this, "clickedSortCFR");

        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");

        window.addButton(sortByAlpha, WindowSide.NORTH);
        window.addButton(quit, WindowSide.NORTH);
        window.addButton(sortByCFR, WindowSide.NORTH);

        stateButtons = new Button[ethnicityCalculator.getState().size()];
        for (int i = 0; i < ethnicityCalculator.getState().size(); i++) {
            stateButtons[i] = new Button("Represent " + ethnicityCalculator
                .getState().get(i).getStateName());
            stateButtons[i].onClick(this, "clickedState");
            window.addButton(stateButtons[i], WindowSide.SOUTH);
        }
    }


    /**
     * Exits the window
     * 
     * @param button
     *            is the quit button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * sorts ethnicity data by alphabetical order
     * 
     * @param button
     *            is the alpha button
     */
    public void clickedSortAlpha(Button button) {
        State state = getStateForButton(lastButton);
        state.sortAlpha();
        update(lastButton);
    }


    /**
     * sorts data by CFR
     * 
     * @param button
     *            is the CFR button
     */
    public void clickedSortCFR(Button button) {
        State state = getStateForButton(lastButton);
        state.sortCFR();
        update(lastButton);
    }


    /**
     * switches data to the clicked states data
     * 
     * @param button
     *            is the state clicked
     */
    public void clickedState(Button button) {
        lastButton = button;
        update(button);
    }


    /**
     * refreshes the window with the new images
     * 
     * @param button
     *            tells the window to refresh
     */
    private void update(Button button) {
        window.removeAllShapes();
        displayState(button);
        displayText(button);
    }


    /**
     * displays the data for the state
     * 
     * @param button
     *            is the states button
     */
    private void displayState(Button button) {
        State state = getStateForButton(button);
        double largeCFR = getLargestCFR(state);
        int numState = state.getRaces().size();

        for (int i = 0; i < state.getRaces().size(); i++) {
            double sizeRatio = state.getRaces().get(i).calculateCFR()
                / largeCFR;
            int barHeight = (int)(((window.getHeight() / 2) * (sizeRatio)));
            int barX = (window.getWidth() / state.getRaces().size()
                * (i + 1)) - (window.getWidth() / 10);
            int barY = (int)(((window.getHeight() / 2) - (window.getHeight()
                / 3)) + ((window.getHeight() / 2) * (1 - sizeRatio)));
            int barWidth = (window.getWidth() / (state.getRaces()
                .size() * 10));
            if (sizeRatio < 1) {
                barY++;
            }
            if (sizeRatio > 0) {
                window.addShape(new Shape(barX, barY, barWidth, barHeight,
                    Color.BLUE));
            }
            else {
                TextShape naText = new TextShape(barX, barY + barHeight, "NA",
                    Color.BLACK, 80 / numState);
                naText.setY(naText.getY() - naText.getHeight());
                window.addShape(naText);
            }
            displayStateText(state.getRaces().get(i), barX, barY
                + barHeight, numState);
        }

    }


    /**
     * displays the header
     * 
     * @param button
     *            is the states button so it can
     *            read the states name
     */
    private void displayText(Button button) {
        State state = getStateForButton(button);
        String name = state.getStateName() + " Cases Fatality Ratios by Race";
        TextShape header = new TextShape((window.getWidth() / 2), (window
            .getHeight() / 20), (name), Color.BLACK, 14);
        header.setX(header.getX() - (header.getWidth() / 2));
        window.addShape(header);
    }


    /**
     * displays the text for the state
     * 
     * @param ethnit
     *            is the states ethnicity data
     * @param xVal
     *            location of the bar
     * @param yVal
     *            location of the bar
     * @param numEth
     *            effects the font size of the bar
     */
    private void displayStateText(
        Race ethnit,
        int xVal,
        int yVal,
        int numEth) {
        int xLocal = xVal;
        int yLocal = yVal;
        StringBuilder build = new StringBuilder();
        String ethnicityName = ethnit.getRace();
        int fontSize = 80 / numEth;

        TextShape barName = new TextShape(xLocal, yLocal, ethnicityName,
            Color.BLACK, fontSize);
        barName.setX(barName.getX() - (barName.getWidth() / 4));
        barName.setY(barName.getY() + barName.getHeight());
        window.addShape(barName);

        if (ethnit.calculateCFR() != -1) {
            if (((ethnit.calculateCFR() % 1) < 0.05)) {
                int cfr = (int)ethnit.calculateCFR();
                build.append(cfr + "%");
            }
            else {
                build.append(String.format("%.1f", ethnit.calculateCFR()) + "%");
            }

            TextShape cfrString = new TextShape(barName.getX(), barName.getY(),
                build.toString(), Color.BLACK, fontSize);
            cfrString.setY(cfrString.getY() + (2 * cfrString.getHeight()));

            window.addShape(cfrString);
        }
    }


    /**
     * returns the state for the correct button
     * 
     * @param button
     *            the state trying to be accessed
     * @return the state being accessed
     */
    private State getStateForButton(Button button) {
        for (int i = 0; i < stateButtons.length; i++) {
            if (button.equals(stateButtons[i])) {
                return ethnicityCalculator.getState().get(i);
            }
        }
        return null;
    }


    /**
     * gets the largest CFR
     * 
     * @param state
     *            the state being passed through
     * @return the double for the highest CFR in that state
     */
    private double getLargestCFR(State state) {
        double largestCFR = 0;
        for (int i = 0; i < state.getRaces().size(); i++) {
            double tempCFR = state.getRaces().get(i).calculateCFR();
            if (largestCFR < tempCFR) {
                largestCFR = tempCFR;
            }
        }
        return largestCFR;
    }
}
