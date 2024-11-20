/**
 * Décrivez votre classe Reine ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Reine extends Robot {
    private static final int MAX_POSITION = 11;

    public Reine(String name, int initialX, int initialY, String colourBody, World world) {
        super(name, initialX, initialY, colourBody, world);
    }

    @Override
    public void avancer() {
        if (xPosition < MAX_POSITION && yPosition < MAX_POSITION) {
            xPosition++;
            yPosition++;
            canvasRobot.drawRobot(xPosition, yPosition);
            try {
                Thread.sleep(50); // Slow down movement for visibility
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}