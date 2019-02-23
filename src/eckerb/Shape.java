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
 * The Shape class that uses the x,y coordinate
 * to make the shape at a specific point.
 * Uses the color to color the shape.
 */
public abstract class Shape {
    private Color color;
    protected double x;
    protected double y;

    /**
     * Constructor
     *
     * @param x     The x coordinate to start the shape.
     * @param y     The y coordinate to start the shape.
     * @param color The color of the shape.
     */
    public Shape(double x, double y, Color color) {
        this.color = color;
        try {
            if (x > 0 && y > 0) {
                this.x = x;
                this.y = y;
            } else {
                throw new IllegalArgumentException("");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("A Shape has unrealistic x or y coordinate.");
        }
    }

    /**
     * An abstract class that all subclasses need to implement.
     *
     * @param plotter A WinPlotterFX that was created in the
     *                ShapeCreatorApp.
     */
    public abstract void draw(WinPlotterFX plotter);

    /**
     * Set the pen color to a desired color to a WinPlotterFX object.
     *
     * @param plotter A WinPlotterFX that was created in the ShapeCreatorApp.
     */
    public void setPenColor(WinPlotterFX plotter) {
        plotter.setPenColor(color.getRed(), color.getGreen(), color.getBlue());
    }

    /**
     * Sets the desired color to another color.
     *
     * @param color A new desired color that you wish the shape to be.
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
