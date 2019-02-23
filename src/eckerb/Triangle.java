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
 * Draws a triangle with a specified base and height.
 * The bottom left corner is at a desired x,y coordinate.
 */
public class Triangle extends eckerb.Shape {
    protected double base;
    protected double height;

    /**
     * Constructor.
     *
     * @param x      The desired x coordinate of the bottom left corner.
     * @param y      The desired y coordinate of the bottom left corner.
     * @param base   The base length of the triangle.
     * @param height The height of the triangle.
     * @param color  The color of the triangle.
     */
    public Triangle(double x, double y, double base, double height, Color color) {
        super(x, y, color);
        try {
            if (base > 0 && height >= 0) {
                this.base = base;
                this.height = height;
            } else {
                throw new IllegalArgumentException("");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("A triangle has one or more unrealistic dimension(s).");
        }
    }

    /**
     * Draws a triangle where the bottom left corner is at a x,y coordinate.
     *
     * @param plotter A WinPlotterFX that was created in the
     *                ShapeCreatorApp.
     */
    @Override
    public void draw(WinPlotterFX plotter) {
        setPenColor(plotter);
        plotter.moveTo(x, y);
        plotter.drawTo(x + base, y);
        plotter.moveTo(x + (base / 2), y + height);
        plotter.drawTo(x, y);
        plotter.moveTo(x + (base / 2), y + height);
        plotter.drawTo(x + base, y);
    }
}
