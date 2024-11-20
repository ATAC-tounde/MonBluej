import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Random;

public class CanvasRobot {
    static private Canvas canvas = Canvas.getCanvas();
    static private Random randomGenerator;
    static private ArrayList<CanvasRobot> canvasRobotList = new ArrayList<>();
    static private boolean gameOver = false;

    private boolean redrawable;
    private int x;
    private int y;
    static private Colour colourHead = Colour.RED;
    private Colour colourBody = Colour.BLUE;
    static private Colour colourLeg = Colour.BLACK;
    static private Colour colourEye = Colour.GREEN;

    private Integer corps;
    private Integer brasG;
    private Integer brasD;
    private Integer jambeG;
    private Integer jambeD;
    private Integer tete;
    private Integer oeilD;
    private Integer oeilG;

    public CanvasRobot(String colourBody) {
        if (randomGenerator == null) randomGenerator = new Random();
        corps = randomGenerator.nextInt();
        brasG = randomGenerator.nextInt();
        brasD = randomGenerator.nextInt();
        jambeG = randomGenerator.nextInt();
        jambeD = randomGenerator.nextInt();
        tete = randomGenerator.nextInt();
        oeilD = randomGenerator.nextInt();
        oeilG = randomGenerator.nextInt();

        this.colourBody = valueOf(colourBody);
        redrawable = false;
        canvasRobotList.add(this);
    }

    public void drawRobot(int x, int y) {
        if (!gameOver) {
            int xp = x * 50;
            int yp = y * 50;
            canvas.draw(brasG, colourLeg, new Rectangle(xp, yp + 15, 8, 10));
            canvas.draw(brasD, colourLeg, new Rectangle(xp + 31 + 2, yp + 15, 8, 10));
            canvas.draw(jambeG, colourLeg, new Rectangle(xp + 10, yp + 40, 8, 10));
            canvas.draw(jambeD, colourLeg, new Rectangle(xp + 31 - 8, yp + 40, 8, 10));
            canvas.draw(tete, colourHead, new Rectangle(xp + 14, yp, 13, 26));
            canvas.draw(oeilG, colourEye, new Ellipse2D.Double(xp + 16, yp + 2, 4, 4));
            canvas.draw(oeilD, colourEye, new Ellipse2D.Double(xp + 21, yp + 2, 4, 4));
            canvas.draw(corps, colourBody, new Rectangle(xp + 5, yp + 10, 31, 30));
            this.x = x;
            this.y = y;
            redrawable = true;

            if (outOfCanvas()) gameOver();
            if (collision()) gameOver();
        }
    }

    public void setColourBody(String colourBody) {
        this.colourBody = valueOf(colourBody);
        if (redrawable) drawRobot(this.x, this.y);
    }


    public String getColourBody() {
        return colourBody.toString();
    }

    private static Colour valueOf(String colour) {
        try {
            return Colour.valueOf(colour.toUpperCase());
        } catch (Exception e) {
            return Colour.BLUE;
        }
    }

    private boolean collision() {
        for (CanvasRobot c : canvasRobotList) {
            if ((c != this) && (x == c.x) && (y == c.y) && (c.redrawable)) {
                return true;
            }
        }
        return false;
    }

    private boolean outOfCanvas() {
        return x < 0 || y < 0 || x > 11 || y > 11;
    }

    private static void gameOver() {
        gameOver = true;
        canvas.gameOver();
    }
}