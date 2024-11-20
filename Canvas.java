import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;
import java.lang.Object.*;
import java.lang.NumberFormatException.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.ArrayList;
/**
 * Canvas is a class to allow for simple graphical drawing on a canvas.
 * This is a modification of the general purpose Canvas, specially made for the Robot project. 
 *
 * @author: Bruce Quig
 * @author: Michael Kölling (mik)
 * @author: Patrick Girard for adaptation to the robot project
 *
 * @version 2021.08
 *
public class Canvas
{
    // Note: The implementation of this class (specifically the handling of
    // shape identity and colors) is slightly more complex than necessary. This
    // is done on purpose to keep the interface and instance fields of the
    // shape objects in this project clean and simple for educational purposes.

    private static Canvas canvasSingleton;
    private JPanel drawingArea;

    /**
     * Factory method to get the canvas singleton object.
     *
    public static Canvas getCanvas()
    {
        if(canvasSingleton == null) {
            canvasSingleton = new Canvas("Robots", 600, 600, 
                                         Color.white);
        }
        canvasSingleton.setVisible(true);
        return canvasSingleton;
    }

    //  ----- instance part -----

    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D graphic;
    private Color backgroundColor;
    private Image canvasImage;
    private List<Object> objects;
    private HashMap<Object, ShapeDescription> shapes;
    
    /**
     * Create a Canvas.
     * @param title    title to appear in Canvas Frame
     * @param width    the desired width for the canvas
     * @param height   the desired height for the canvas
     * @param bgColor the desired background color of the canvas
     *
    private Canvas(String title, int width, int height, Color bgColor)
    {
        frame = new JFrame();
        canvas = new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle(title);
        frame.setLocation(30, 30);
        canvas.setPreferredSize(new Dimension(width, height));
        backgroundColor = bgColor;
        frame.pack();
        objects = new ArrayList<Object>();
        shapes = new HashMap<Object, ShapeDescription>();
    }

    /**
     * Set the canvas visibility and brings canvas to the front of screen
     * when made visible. This method can also be used to bring an already
     * visible canvas to the front of other windows.
     * @param visible  boolean value representing the desired visibility of
     * the canvas (true or false) 
     *
    public void setVisible(boolean visible)
    {
        if(graphic == null) {
            // first time: instantiate the offscreen image and fill it with
            // the background color
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            graphic = (Graphics2D)canvasImage.getGraphics();
            graphic.setColor(backgroundColor);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.black);
        }
        frame.setVisible(visible);
    }

    /**
     * Draw a given shape onto the canvas.
     * @param  referenceObject  an object to define identity for this shape
     * @param  colour           the colour of the shape
     * @param  shape            the shape object to be drawn on the canvas
     *
     // Note: this is a slightly backwards way of maintaining the shape
     // objects. It is carefully designed to keep the visible shape interfaces
     // in this project clean and simple for educational purposes.
    public void draw(Object referenceObject, Colour colour, Shape shape)
    {
        objects.remove(referenceObject);   // just in case it was already there
        objects.add(referenceObject);      // add at the end
        shapes.put(referenceObject, new ShapeDescription(shape, colour));
        redraw();
    }
 
    /**
     * Erase a given shape's from the screen.
     * @param  referenceObject  the shape object to be erased 
     *
    public void erase(Object referenceObject)
    {
        objects.remove(referenceObject);   // just in case it was already there
        shapes.remove(referenceObject);
        redraw();
    }

    /**
     * Set the foreground color of the Canvas.
     * @param  newColor   the new color for the foreground of the Canvas 
     *
    public void setForegroundColour(Colour colour)
    {
        switch(colour) {
            case RED     : graphic.setColor(new Color(235, 25, 25));
                            break;
            case BLACK   : graphic.setColor(Color.black);
                            break;
            case BLUE    : graphic.setColor(new Color(30, 75, 220));
                            break;
            case YELLOW  : graphic.setColor(new Color(255, 230, 0));
                            break;
            case GREEN   : graphic.setColor(new Color(80, 160, 60));
                            break;
            case MAGENTA : graphic.setColor(Color.magenta);
                            break;
            case WHITE   : graphic.setColor(Color.white);
                            break;
            case PURPLE  : graphic.setColor(new Color(138, 43, 226));
                            break;
        }

        // if(colorString.equals("red")) {
            // graphic.setColor(new Color(235, 25, 25));
        // }
        // else if(colorString.equals("black")) {
            // graphic.setColor(Color.black);
        // }
        // else if(colorString.equals("blue")) {
            // graphic.setColor(new Color(30, 75, 220));
        // }
        // else if(colorString.equals("yellow")) {
            // graphic.setColor(new Color(255, 230, 0));
        // }
        // else if(colorString.equals("green")) {
            // graphic.setColor(new Color(80, 160, 60));
        // }
        // else if(colorString.equals("magenta")) {
            // graphic.setColor(Color.magenta);
        // }
        // else if(colorString.equals("white")) {
            // graphic.setColor(Color.white);
        // }
        // else if(colorString.equals("purple")) {
            // graphic.setColor(new Color(138, 43, 226));
        // }
        // else {
            // graphic.setColor(Color.black);
        // }
    }

    /**
     * Wait for a specified number of milliseconds before finishing.
     * This provides an easy way to specify a small delay which can be
     * used when producing animations.
     * @param  milliseconds  the number 
     *
    public void wait(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        } 
        catch (Exception e)
        {
            // ignoring exception at the moment
        }
    }

    /**
     * Redraw ell shapes currently on the Canvas.
     *
    private void redraw()
    {
        erase();
        for(Object shape : objects) {
            shapes.get(shape).draw(graphic);
        }
        canvas.repaint();
    }
       
    /**
     * Erase the whole canvas. (Does not repaint.)
     *
    private void erase()
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        Dimension size = canvas.getSize();
        graphic.fill(new Rectangle(0, 0, size.width, size.height));
        graphic.setColor(original);
    }

    public void gameOver(){
        erase();
        graphic.drawString("GAME OVER", canvas.getSize().width/2-20, canvas.getSize().height/2+10);
        canvas.repaint();
    }

    /************************************************************************
     * Inner class CanvasPane - the actual canvas component contained in the
     * Canvas frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     *
    private class CanvasPane extends JPanel
    {
        public void paint(Graphics g)
        {
            g.drawImage(canvasImage, 0, 0, null);
        }
    }
    
    /************************************************************************
     * Inner class CanvasPane - the actual canvas component contained in the
     * Canvas frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     *
    private class ShapeDescription
    {
        private Shape shape;
        private Colour colour;

        public ShapeDescription(Shape shape, Colour colour)
        {
            this.shape = shape;
            this.colour = colour;
        }

        public void draw(Graphics2D graphic)
        {
            setForegroundColour(colour);
            graphic.fill(shape);
        }
    }
    // Method to fill a rectangle on the canvas (representing the robot)
    public void fillRectangle(int x, int y, int width, int height) {
        Graphics g = drawingArea.getGraphics();
        if (g != null) {
            g.fillRect(x, y, width, height);
            g.dispose(); // Dispose of the graphics context after use to free resources
        }
    }

}
/**
import java.awt.*;
import javax.swing.*;

public class Canvas {
    private static Canvas canvasSingleton;
    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D graphic;
    private Color backgroundColor;
    private Image canvasImage;

    // Factory method to get the canvas instance
    public static Canvas getCanvas() {
        if (canvasSingleton == null) {
            canvasSingleton = new Canvas("Robot World", 600, 600, Color.white);
        }
        return canvasSingleton;
    }

    private Canvas(String title, int width, int height, Color bgColor) {
        frame = new JFrame();
        canvas = new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle(title);
        canvas.setPreferredSize(new Dimension(width, height));
        backgroundColor = bgColor;
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure window closes on exit
        canvasImage = canvas.createImage(width, height);
        graphic = (Graphics2D) canvasImage.getGraphics();
        graphic.setColor(backgroundColor);
        graphic.fillRect(0, 0, width, height);
        graphic.setColor(Color.black);
    }

    // Method to set the visibility of the JFrame
    public void setVisible(boolean visible) {
        frame.setVisible(visible);  // Set JFrame visibility
    }

    // Draw a robot on the canvas
    public void draw(Robot robot, String colorString) {
        Color color = Color.decode(colorString); // Converts color name to Color object
        graphic.setColor(color);
        graphic.fill(new java.awt.Rectangle(robot.getXPosition() * 50, robot.getYPosition() * 50, 50, 50));
        canvas.repaint();
    }

    // Erase the robot from its previous position
    public void erase(Robot robot) {
        graphic.setColor(backgroundColor);
        graphic.fill(new java.awt.Rectangle(robot.getXPosition() * 50, robot.getYPosition() * 50, 50, 50));
        canvas.repaint();
    }

    // Optional game over visual feedback
    public void gameOver() {
        graphic.setColor(Color.RED);
        graphic.drawString("GAME OVER", 250, 300);
        canvas.repaint();
    }

    private class CanvasPane extends JPanel {
        public void paint(Graphics g) {
            g.drawImage(canvasImage, 0, 0, null);
        }
    }
}*/

import java.awt.*;
import java.util.*;
import javax.swing.JPanel;
import javax.swing.JFrame;

/**
 * Canvas is a class to allow for simple graphical drawing on a canvas.
 * This is a modification of the general purpose Canvas, specially made for the LOGO project.
 */
public class Canvas {
    private static Canvas canvasSingleton;

    /**
     * Factory method to get the canvas singleton object.
     */
    public static Canvas getCanvas() {
        if (canvasSingleton == null) {
            canvasSingleton = new Canvas("World of Robot", 600, 600, Color.white);
        }
        canvasSingleton.setVisible(true);
        return canvasSingleton;
    }

    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D graphic;
    private Color backgroundColor;
    private Image canvasImage;
    private List<Object> objects;
    //private List<Object> referenceObjects;
    private HashMap<Object, ShapeDescription> shapes;

    private CanvasRobot canvasRobot; // Assuming each robot has a CanvasRobot

    public CanvasRobot getCanvasRobot() {
        return canvasRobot;
    }

    private Canvas(String title, int width, int height, Color bgColor) {
        frame = new JFrame();
        canvas = new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle(title);
        frame.setLocation(30, 30);
        canvas.setPreferredSize(new Dimension(width, height));
        backgroundColor = bgColor;
        frame.pack();
        objects = new ArrayList<>();
        shapes = new HashMap<>();
    }

    public void setVisible(boolean visible) {
        if (graphic == null) {
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            graphic = (Graphics2D) canvasImage.getGraphics();
            graphic.setColor(backgroundColor);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.black);
        }
        frame.setVisible(visible);
    }

    public void setBackgroundColor(Color color) {
    // Assuming you have a method to get the drawing area or graphics context
    //drawingArea.setBackground(color); // Set the background color
    redraw(); // Trigger a redraw to update the canvas
    }

    public void draw(Object referenceObject, Colour color, Shape shape) {
        objects.remove(referenceObject);
        objects.add(referenceObject);
        shapes.put(referenceObject, new ShapeDescription(shape, color));
        redraw();
    }

    public void erase(Object referenceObject) {
        objects.remove(referenceObject);
        shapes.remove(referenceObject);
        redraw();
    }

    public void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void redraw() {
        erase();
        for (Object shape : objects) {
            shapes.get(shape).draw(graphic);
        }
        canvas.repaint();
    }

    private void erase() {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        Dimension size = canvas.getSize();
        graphic.fill(new Rectangle(0, 0, size.width, size.height));
        graphic.setColor(original);
    }

    private class CanvasPane extends JPanel {
        
        private static Canvas canvasSingleton;
        private Color backgroundColor;
        
        public void paint(Graphics g) {
            g.drawImage(canvasImage, 0, 0, null);
        }

        // Method to set the background color
        public void setBackgroundColor(Color color) {
            this.backgroundColor = color;
            repaint(); // Repaint the canvas with the new background color
        }

    // Override the paintComponent method to fill the background color
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(backgroundColor);
            g.fillRect(0, 0, getWidth(), getHeight()); // Fill the background with the selected color
        }
    }

    private class ShapeDescription {
        private Shape shape;
        private Colour color;


       public ShapeDescription(Shape shape, Colour color)
        {
            this.shape = shape;
            this.color = color;
        }
        
        
        public void draw(Graphics2D graphic)
        {
            graphic.setColor(color.getAWTColor());
            graphic.fill(shape);
        }


    }

    public void gameOver() {
        graphic.setColor(Color.RED);
        graphic.drawString("GAME OVER", 250, 300);
        canvas.repaint();
    }

}