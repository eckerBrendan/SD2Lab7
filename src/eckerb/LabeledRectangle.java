/*
 * CS1021 - 051
 * Winter 2018-2019
 * Lab 4 - Inheritance with Shapes
 * Name: Brendan Ecker
 * Created: 12/13/2018
 */
package eckerb;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.scene.paint.Color;

/**
 * Draws a Rectangle with text inside it.
 * With the bottom left corner in a desired x,y coordinate.
 */
public class LabeledRectangle extends eckerb.Rectangle {
    private final String name;

    /**
     * Constructor
     *
     * @param x         The desired x coordinate of the bottom left corner.
     * @param y         The desired y coordinate of the bottom left corner.
     * @param width      The width length of the rectangle.
     * @param height    The height length of the rectangle.
     * @param color     The color of the rectangle and text.
     * @param name      The name of who the rectangle is for.
     */
    public LabeledRectangle(double x, double y, double width, double height, Color color, String name) {
        super(x, y, width, height, color);
        this.name = name;
    }

    /**
     * Draws a rectangle with text inside it.
     * @param plotter   A WinPlotterFX that was created in the
     *                  ShapeCreatorApp.
     */
    @Override
    public void draw(WinPlotterFX plotter) {
        super.draw(plotter);
        plotter.printAt(x , y + (height/2), name);
    }
}
