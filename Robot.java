import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;
import java.lang.Object.*;
import java.lang.NumberFormatException.*; 
import java.util.ArrayList;

public abstract class Robot {
    protected String name;
    protected int xPosition;
    protected int yPosition;
    protected CanvasRobot canvasRobot;
    protected World world;  // Reference to the world

    public Robot(String name, int initialX, int initialY, String colourBody, World world) {
        this.name = name;
        this.xPosition = initialX;
        this.yPosition = initialY;
        this.canvasRobot = new CanvasRobot(colourBody);
        this.canvasRobot.drawRobot(xPosition, yPosition);
        this.world = world; // Store the reference to the world
        world.addRobot(this, initialX, initialY);
    }

    public String getName() {
        return this.name;
    }

    public int getX() {
        return this.xPosition;
    }

    public void setX(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getY() {
        return this.yPosition;
    }

    public void setY(int yPosition) {
        this.yPosition = yPosition;
    }
    
    // Getter pour récupérer l'instance du monde
    public World getWorld() {
        return this.world;
    }

    public CanvasRobot getCanvasRobot() {
        return canvasRobot; 
    }

    public void draw() {
        canvasRobot.drawRobot(xPosition, yPosition); // Redraw robot at new position
    }

    // Each specific robot will implement its own move method.
    public abstract void avancer();

    // Check if the next position is valid and not occupied by another robot
    protected boolean canMoveTo(int newX, int newY) {
        return world.isValidPosition(newX, newY) && !world.isPositionOccupied(newX, newY);
    }
}
/**
 * Write a description of class Robot here.
 *
 * @author 
 * @version 
 *

public abstract class Robot {
    protected String name;
    protected int xPosition;
    protected int yPosition;
    protected CanvasRobot canvasRobot;

    public Robot(String name, int initialX, int initialY, String colourBody, World world) {
        this.name = name;
        this.xPosition = initialX;
        this.yPosition = initialY;
        this.canvasRobot = new CanvasRobot(colourBody);
        this.canvasRobot.drawRobot(xPosition, yPosition);
        world.addRobot(this, initialX, initialY);
    }

    public String getName() {
        return this.name;
    }

    public int getX() {
        return this.xPosition;
    }

    public void setX(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getY() {
        return this.yPosition;
    }

    public void setY(int yPosition) {
        this.yPosition = yPosition;
    }
    
    public CanvasRobot getCanvasRobot() {
        return canvasRobot; 
    }

    public void draw() {
    // Assuming getCanvasRobot() returns the CanvasRobot object that is drawing the robot
    CanvasRobot canvasRobot = getCanvasRobot();
    canvasRobot.drawRobot(xPosition, yPosition); // Redraw robot at new position
    }

    // Each specific robot will implement its own move method.
    public abstract void avancer();
}*/
/*
public class Robot {
    private String name;
    private int xPosition;
    private int yPosition;
    private String type;

    private static final int MIN_POSITION = 0;
    private static final int MAX_POSITION = 11;
    private CanvasRobot canvasRobot;

    public Robot(String name, String type, String colourBody, int initialX, int initialY) {
        this.name = name;
        this.type = type;
        this.xPosition = initialX;  // Position initiale donnée par le monde
        this.yPosition = initialY;
        this.canvasRobot = new CanvasRobot(colourBody);
        this.canvasRobot.drawRobot(xPosition, yPosition);
    }

    public void move() {
        switch (type) {
            case "Reine":
                moveReine();
                break;
            case "Roi":
                moveRoi();
                break;
            case "Cavalier":
                moveCavalier();
                break;
            case "Tour":
                moveTour();
                break;
            case "Fou":
                moveFou();
                break;
            case "Pion":
                movePion();
                break;
            default:
                break;
        }
        canvasRobot.drawRobot(xPosition, yPosition);
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getXPosition() {
        return xPosition;
    }
    
    // Setter for xPosition
    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }
    // Setter for xPosition
    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }
    // Mouvements spécifiques pour chaque type
    private void moveReine() {
        // Mouvement de la Reine: comme une tour + fou
        if (xPosition < MAX_POSITION) xPosition++;
        if (yPosition < MAX_POSITION) yPosition++;
    }

    private void moveRoi() {
        // Mouvement du Roi: une case dans toutes les directions
        xPosition = Math.min(MAX_POSITION, xPosition + 1);
        yPosition = Math.min(MAX_POSITION, yPosition + 1);
    }

    private void moveCavalier() {
        // Mouvement du Cavalier: en L
        xPosition = (xPosition + 2 <= MAX_POSITION) ? xPosition + 2 : xPosition;
        yPosition = (yPosition + 1 <= MAX_POSITION) ? yPosition + 1 : yPosition;
    }

    private void moveTour() {
        // Mouvement de la Tour: en ligne droite
        if (xPosition < MAX_POSITION) xPosition++;
    }

    private void moveFou() {
        // Mouvement du Fou: diagonale
        if (xPosition < MAX_POSITION && yPosition < MAX_POSITION) {
            xPosition++;
            yPosition++;
        }
    }

    private void movePion() {
        // Mouvement du Pion: vers l'avant uniquement
        if (yPosition < MAX_POSITION) yPosition++;
    }
}*/