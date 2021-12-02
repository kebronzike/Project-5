package prj5;

import java.awt.Color;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

public class CovidWindow {

    private Button[] stateButton;
    private Button quit;
    private Button sortAlpha;
    private Button sortCFR;
    private Window window;
    private CovidCalc calc;

    public CovidWindow(CovidCalc data) {
        // Initiallizes window and CovidCalc objects
        window = new Window("Covid Display");
        calc = data;
        // Adding all the buttons to window
        int buttonSize = calc.getState().size();
        stateButton = new Button[buttonSize];
        for (int i = 0; i < buttonSize; i++) {
            stateButton[i] = new Button("Reprsents " + calc.getState().get(i)
                .getStateName());
            window.addButton(stateButton[i], WindowSide.SOUTH);
            stateButton[i].onClick(this);
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
     * this will update the window when new commands are made in the program
     * 
     * @param button
     *            this will be used to update the window
     */
    private void update(Button button) {
        window.removeAllShapes();
        stateGUI(button);
        textDisplay(button);
    }


    /**
     * this will Display the text information
     * 
     * @param button
     *            this represents the state button
     */
    private void textDisplay(Button button) {
        State state = stateButton(button);
        String statenames = state.getStateName() + "CFR's by Race";
        TextShape head = new TextShape((window.getWidth() / 2), (window
            .getHeight() / 20), (statenames), Color.blue, 14);
        head.setX(head.getX() - (head.getWidth() / 2));
        window.addShape(head);
    }


    /**
     * this will get a state button depending on the state name
     * 
     * @param button
     *            button for the state
     * @return
     *         the state
     */
    private State stateButton(Button button) {
        for (int i = 0; i < stateButton.length; i++) {
            if (button.equals(stateButton[i])) {
                return calc.getState().get(i);
            }
        }
        return null;
    }


    /**
     * 
     * @param button
     */
    private void stateGUI(Button button) {
        State temp = stateButton(button);
        double highestCFR = greatestCFR(temp);
        int numberofstates = temp.getRaces().size();
        for (int i = 0; i < temp.getRaces().size(); i++) {
            double ratio = temp.getRaces().get(i).calculateCFR() / highestCFR;
            int vertY = (int)(((window.getHeight() / 2) - (window.getHeight()
                / 3)) + ((window.getHeight() / 2) * (1 - ratio)));
            int vertX = (window.getWidth() / temp.getRaces().size() * (i + 1))
                - (window.getWidth() / 10);
            int vertHeight = (int)(((window.getHeight() / 2) * (ratio)));
            int vertWidth = (window.getWidth() / (temp.getRaces().size() * 10));
            if (ratio < 1) {
                vertY++;
            }
            if (ratio > 0) {
                window.addShape(new Shape(vertX, vertY, vertWidth, vertHeight,
                    Color.BLUE));
            }
            else {
                TextShape naText = new TextShape(vertX, vertY + vertHeight,
                    "NA", Color.BLACK, 80 / numberofstates);
                naText.setY(naText.getY() - naText.getHeight());
                window.addShape(naText);
            }
            textState(temp.getRaces().get(i), vertX, vertY + vertHeight,
                numberofstates);
        }

    }


    private void textState(Race race, int vertX, int vertY, int size) {
        StringBuilder str = new StringBuilder();
        String racename = race.getRace();
        int font = 100 / size;
        int xvert = vertX;
        int yvert = vertY;
        TextShape vertBar = new TextShape(vertX, vertY, racename, Color.BLUE,
            font);
        vertBar.setY(vertBar.getY() + vertBar.getHeight());
        vertBar.setX(vertBar.getX() - vertBar.getWidth() / 4);
        window.addShape(vertBar);
        if(race.calculateCFR() != -1) {
            if((race.calculateCFR() % 1) < 0.05) {
                int cfrRatio = (int)race.calculateCFR();
                str.append( cfrRatio + "%");
            }
            else {
                
            }
        }
    }


    /**
     * this will get the greatest CFR in a state
     * 
     * @param state
     *            the state being checked
     * @return
     *         the highest cfr percent
     */
    private double greatestCFR(State state) {
        double cFR = 0;
        for (int i = 0; i < state.getRaces().size(); i++) {
            double temp = state.getRaces().get(i).calculateCFR();
            if (cFR < temp) {
                cFR = temp;
            }
        }
        return cFR;
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
