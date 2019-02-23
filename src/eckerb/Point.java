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
 * Class constructor
 */
public class Point extends eckerb.Shape {

    /**
     * COnstructor
     *
     * @param x         The beginning point x coord
     * @param y         The beginning point y coord
     * @param color     The color of the point.
     */
    public Point(double x, double y, Color color) {
        super(x, y, color);

    }

    /**
     * Uses the x and y coordinates to draw the point at a specific position.
     *
     * @param plotter  the plotter that was made in the driver
     */
    @Override
    public void draw(WinPlotterFX plotter) {
        setPenColor(plotter);
        plotter.drawPoint(x-5,y-5);
    }
}
