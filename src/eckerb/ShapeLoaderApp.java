/*
 * Course: CS1021 - 051
 * Winter 2018-2019
 * Lab 7 - Shapes Revisited
 * Name: Brendan Ecker
 * Created: 1/24/2018
 */

package eckerb;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javafx.application.Application;

/**
 * This class takes lab 4 with shapes,
 * then reads a file with specific text
 * in it and draws what the file specified.
 */
public class ShapeLoaderApp extends Application {
    private Scanner in;
    private static WinPlotterFX plotter = new WinPlotterFX();
    private ArrayList<Shape> shapes = new ArrayList<>();
    private FileChooser chooser = new FileChooser();


    public static void main(String[] args) {
        launch(args);
    }

    /**
     * This method make a file cfhooser and
     * takes the file and tries to read it
     * then reads the text and reads what
     * shapes are specifies and draws them.
     * Then sets stage and shows it.
     *
     * @param stage The main stage that
     *              everything is set.
     */
    public void start(Stage stage) {
        try {
            chooser.setTitle("File Chooser");
            in = new Scanner(chooser.showOpenDialog(stage));
        } catch (IOException e) {
            Alert ioException = new Alert(Alert.AlertType.ERROR);
            ioException.setTitle("IOException");
            ioException.setHeaderText("Something went wrong with the file.");
            ioException.setContentText("Something went wrong!");
            ioException.showAndWait();
        }
        try {
            initWinPlotter(plotter);
            readShapes();
            drawShapes();
            plotter.showPlotter();
        } catch (InputMismatchException e) {
            Alert inputMismatch = new Alert(Alert.AlertType.ERROR);
            inputMismatch.setTitle("Something went wrong.");
            inputMismatch.setHeaderText("Input mismatch Exception");
            inputMismatch.setContentText("There is is something wrong with" +
                    " setting up the window.");
            inputMismatch.showAndWait();
        } finally {
            in.close();
        }
}

    /**
     * This takes some of the text from
     * the file sets the title, width and
     * height, and the background color.
     *
     * @param plotter The WinPlottterFx
     *                that is being used
     *                to display everything.
     */
    private void initWinPlotter(WinPlotterFX plotter) {
        plotter.setWindowTitle(in.nextLine());
        plotter.setWindowSize(in.nextInt(), in.nextInt());
        in.nextLine();
        Color background = stringToColor(in.nextLine());
        plotter.setBackgroundColor(background.getRed(),
                background.getGreen(), background.getBlue());
    }

    /**
     * Reads through the text file and
     * then uses parse shape to create
     * a new shape and adds it to an
     * array list of shapes.
     */
    private void readShapes() {
        Shape newShape;
        shapes = new ArrayList<>();
        while (in.hasNextLine()) {
            try {
                newShape = parseShape(in.nextLine());
                shapes.add(newShape);
            } catch (NoSuchElementException e) {
                System.out.println("There is something wrong with one of your Shapes.");
            }
        }
    }

    /**
     * Takes the shapes from the array list and uses
     * the draw methods of the shape class and draws
     * it on the WinPlotter.
     */
    private void drawShapes() {
        for (int i = 0; i < shapes.size(); i++) {
            Shape draw = shapes.get(i);
            draw.draw(plotter);
        }
    }

    /**
     * Takes a line of text from the text file and
     * determines what type of shape it is and creates
     * a new shape of that type and adds it to the
     * array list.
     *
     * @param line The line of the text text
     *             document that has the shape.
     * @return The shape that is specified
     * in the line of text.
     */
    private static Shape parseShape(String line) {
        Shape newShape = null;
        int xCoord;
        int yCoord;
        Color color;
        int radius;
        int width;
        int height;
        String name;
        Scanner lineIn = new Scanner(line);
        String shapeText = lineIn.next();
        switch (shapeText) {

            case "P:":
                xCoord = lineIn.nextInt();
                yCoord = lineIn.nextInt();
                color = stringToColor(lineIn.next());
                newShape = new Point(xCoord, yCoord, color);
                break;

            case "C:":
                xCoord = lineIn.nextInt();
                yCoord = lineIn.nextInt();
                color = stringToColor(lineIn.next());
                radius = lineIn.nextInt();
                newShape = new Circle(xCoord, yCoord, radius, color);
                break;


            case "T:":
                xCoord = lineIn.nextInt();
                yCoord = lineIn.nextInt();
                color = stringToColor(lineIn.next());
                width = lineIn.nextInt();
                height = lineIn.nextInt();
                newShape = new Triangle(xCoord, yCoord, width, height, color);
                break;

            case "R:":
                xCoord = lineIn.nextInt();
                yCoord = lineIn.nextInt();
                color = stringToColor(lineIn.next());
                width = lineIn.nextInt();
                height = lineIn.nextInt();
                newShape = new Rectangle(xCoord, yCoord, width, height, color);
                break;


            case "LT:":
                xCoord = lineIn.nextInt();
                yCoord = lineIn.nextInt();
                color = stringToColor(lineIn.next());
                width = lineIn.nextInt();
                height = lineIn.nextInt();
                name = lineIn.nextLine();
                newShape = new LabeledTriangle(xCoord, yCoord, width, height, color, name);
                break;

            case "LR:":
                xCoord = lineIn.nextInt();
                yCoord = lineIn.nextInt();
                color = stringToColor(lineIn.next());
                width = lineIn.nextInt();
                height = lineIn.nextInt();
                name = lineIn.nextLine();
                newShape = new LabeledRectangle(xCoord, yCoord, width, height, color, name);
                break;
        }
        return newShape;
    }

    /**
     * Changes a hex color code into the color
     * associated with that hex color code.
     *
     * @param colorCode The hex color code in a string.
     * @return The color that is associated
     * with the hex color code.
     * @throws InputMismatchException When there is no hex color code
     *                                to turn into a color.
     */
    private static Color stringToColor(String colorCode) throws InputMismatchException {
        String error = "Your color was not in a hex triplet code!";
        try {
            if (colorCode.length() == 7) {
                return Color.web(colorCode);
            } else {
                throw new InputMismatchException(error);
            }
        } catch (InputMismatchException e) {
            Alert mismatchException = new Alert(Alert.AlertType.ERROR);
            mismatchException.setTitle("Input Mismatch Exception");
            mismatchException.setHeaderText("Input Mismatch Exception");
            mismatchException.setContentText(error);
            mismatchException.showAndWait();
        }
        return null;
    }

}
