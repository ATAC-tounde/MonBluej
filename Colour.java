import java.awt.Color;
/**
 * Enumeration class Colour: this class constrains the colours to be used in Canvas
 * Warning: it is written in the british form (colour) to not confuse with the Color class
 * from the 2D package
 * 
 * @author Patrick Girard
 * @version 2021.08
 */
public enum Colour {
    

    RED(Color.RED),
    BLUE(Color.BLUE),
    GREEN(Color.GREEN),
    BLACK(Color.BLACK),
    YELLOW(Color.YELLOW),
    MAGENTA(Color.MAGENTA),
    WHITE(Color.WHITE),
    PURPLE(new Color(138, 43, 226));
    
    private final Color awtColor;

    Colour(Color awtColor) {
        this.awtColor = awtColor;
    }

    public Color getAWTColor() {
        return this.awtColor;
    }
 }

