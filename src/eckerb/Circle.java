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
 * A class that draws a circle with the center being at
 * a desired x,y coordinate.
 */
public class Circle extends eckerb.Shape {
    private double radius;

    /**
     * Constructor
     *
     * @param x      The x coordinate that the center of the circle will be at.
     * @param y      The y coordinate that the center of the circle will be at.
     * @param radius The radius of the circle.
     * @param color  The color of the circle.
     */
    public Circle(double x, double y, double radius, Color color){
        super(x, y, color);
        try {if(radius > 0) {
            this.radius = radius;
        } else{
            throw new IllegalArgumentException("");
        }
        } catch (IllegalArgumentException e) {
            System.out.println("The circle has an unrealistic radius.");
        }
    }

    /**
     * Draws a thin circle at a desired center point.
     *
     * @param plotter A WinPlotterFX that was created in the
     *                ShapeCreatorApp
     */
    @Override
    public void draw(WinPlotterFX plotter) {
        setPenColor(plotter);
        plotter.moveTo(x + radius, y);
        for (int i = 0; i < 360; i++) {
            plotter.drawTo(x + radius * Math.cos(Math.toRadians(i)), y + radius * Math.sin(Math.toRadians(i)));
        }
    }
}

