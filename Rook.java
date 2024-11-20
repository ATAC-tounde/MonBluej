/**
 * Décrivez votre classe Tour ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 *
public class Tour extends Robot {
    private static final int MAX_POSITION = 11;

    public Tour(String name, int initialX, int initialY, String colourBody, World world) {
        super(name, initialX, initialY, colourBody,world);
        world.addRobot(this, initialX, initialY); // Automatically add to the world
    }
    
    @Override
    public void avancer() {
        if (xPosition < MAX_POSITION) {
            xPosition++;
            canvasRobot.drawRobot(xPosition, yPosition);
            try {
                Thread.sleep(50); // Slow down movement for visibility
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}*/
import java.util.Random;

public class Rook extends Robot {

    private static final int MAX_POSITION = 11;
    private static final int MIN_POSITION = 0;
    private Random random = new Random();

    public Rook(String name, int initialX, int initialY, String colourBody, World world) {
        super(name, initialX, initialY, colourBody, world);
    }

    public void avancer() {
        try {
            moveRandom();
        } catch (InterruptedException e) {
            System.out.println("Le déplacement a été interrompu.");
        }
    }

    // Méthode pour choisir une direction aléatoire et déplacer d'une case
    public void moveRandom() throws InterruptedException {
        int direction = random.nextInt(4); // nb entre 0 et 3
        int cases = random.nextInt(10) + 1; // nb de cases à déplacer de 1 à 10

        switch (direction) {
            case 0:
                moveNorth(cases);
                break;
            case 1:
                moveSouth(cases);
                break;
            case 2:
                moveEast(cases);
                break;
            case 3:
                moveWest(cases);
                break;
        }
    }

    // Méthode pour avancer de plusieurs cases vers le sud
public void moveSouth(int cases) throws InterruptedException {
    if (cases > 0) {
        for (int i = 0; i < cases; i++) {
            if (getY() < MAX_POSITION) {
                if (!getWorld().isPositionOccupied(getX(), getY() + 1)) { // Vérifie si la position est libre
                    setY(getY() + 1);
                    getCanvasRobot().drawRobot(getX(), getY());
                    Thread.sleep(200);
                } else {
                    System.out.println(getName() + " ne peut pas avancer, position occupée à (" + getX() + ", " + (getY() + 1) + ").");
                    break;
                }
            } else {
                System.out.println(getName() + " ne peut pas avancer, en dehors de l'échiquier.");
                break;
            }
        }
    } else {
        System.out.println("Le nombre de pas doit être positif.");
    }
}


    // Méthode pour avancer de plusieurs cases vers le nord
public void moveNorth(int cases) throws InterruptedException {
    if (cases > 0) {
        for (int i = 0; i < cases; i++) {
            if (getY() > 0) {
                if (!getWorld().isPositionOccupied(getX(), getY() - 1)) { // Vérifie si la position est libre
                    setY(getY() - 1);
                    getCanvasRobot().drawRobot(getX(), getY());
                    Thread.sleep(200);
                } else {
                    System.out.println(getName() + " ne peut pas avancer, position occupée à (" + getX() + ", " + (getY() - 1) + ").");
                    break;
                }
            } else {
                System.out.println(getName() + " ne peut pas avancer, en dehors de l'échiquier.");
                break;
            }
        }
    } else {
        System.out.println("Le nombre de pas doit être positif.");
    }
}


    // Méthode pour avancer de plusieurs cases vers l'est
public void moveEast(int cases) throws InterruptedException {
    if (cases > 0) {
        for (int i = 0; i < cases; i++) {
            if (getX() < MAX_POSITION) {
                if (!getWorld().isPositionOccupied(getX() + 1, getY())) { // Vérifie si la position est libre
                    setX(getX() + 1);
                    getCanvasRobot().drawRobot(getX(), getY());
                    Thread.sleep(200);
                } else {
                    System.out.println(getName() + " ne peut pas avancer, position occupée à (" + (getX() + 1) + ", " + getY() + ").");
                    break;
                }
            } else {
                System.out.println(getName() + " ne peut pas avancer, en dehors de l'échiquier.");
                break;
            }
        }
    } else {
        System.out.println("Le nombre de pas doit être positif.");
    }
}

// Méthode pour avancer de plusieurs cases vers l'ouest
public void moveWest(int cases) throws InterruptedException {
    if (cases > 0) {
        for (int i = 0; i < cases; i++) {
            if (getX() > 0) {
                if (!getWorld().isPositionOccupied(getX() - 1, getY())) { // Vérifie si la position est libre
                    setX(getX() - 1);
                    getCanvasRobot().drawRobot(getX(), getY());
                    Thread.sleep(200);
                } else {
                    System.out.println(getName() + " ne peut pas avancer, position occupée à (" + (getX() - 1) + ", " + getY() + ").");
                    break;
                }
            } else {
                System.out.println(getName() + " ne peut pas aller vers l'ouest, en dehors de l'échiquier.");
                break;
            }
        }
    } else {
        System.out.println("Le nombre de pas doit être positif.");
    }
}
}
