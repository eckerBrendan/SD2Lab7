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
 * The LabeledTriangle class draws a triangle with text inside it.
 */
public class LabeledTriangle extends eckerb.Triangle {
    private final String name;

    /**
     * Constructor
     *
     * @param x         The desired x coordinate of the bottom left corner.
     * @param y         The desired y coordinate of the bottom left corner.
     * @param base      The base length of the triangle.
     * @param height    The height length of the triangle.
     * @param color     The color of the triangle and text.
     * @param name      The name of who the triangle is for.
     */
    public LabeledTriangle(double x, double y, double base, double height, Color color, String name) {
        super(x, y, base, height, color);
        this.name = name;
    }

    /**
     * Draws a triangle with text inside it.
     * @param plotter   A WinPlotterFX object that was
     *                  created in ShapeCreatorApp.
     */
    @Override
    public void draw(WinPlotterFX plotter) {
        super.draw(plotter);
        plotter.printAt(x + (base / 3.2), y + (height / 3), name);
    }
}
