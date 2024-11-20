
/**
 * Décrivez votre classe pion ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pion extends Robot {
    private static final int MAX_POSITION = 11;

    public Pion(String name, int initialX, int initialY, String colourBody, World world) {
        super(name, initialX, initialY, colourBody, world);
        world.addRobot(this, initialX, initialY); // Automatically add to the world
    }

    @Override
    public void avancer() {
        if (yPosition < MAX_POSITION) yPosition++;
        canvasRobot.drawRobot(xPosition, yPosition);
        try {
                    Thread.sleep(50); // Slow down movements for visibility
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    }
}