/**
 * Décrivez votre classe Cavalier ici.
 *
 * @author Alogbo Toundé
 * @version 15/10/2024
 *

public class Cavalier extends Robot {
    private static final int MAX_POSITION = 11;

    public Cavalier(String name, int initialX, int initialY, String colourBody, World world) {
        super(name, initialX, initialY, colourBody, world);
        world.addRobot(this, initialX, initialY); // Automatically add to the world
    }

    // Method to move the knight in an L-shape once with a delay
    private void moveCavalierWithDelay() {
        int[][] possibleMoves = {
            {2, 1}, {2, -1},  // 2 steps in x, 1 step in y (East or West)
            {-2, 1}, {-2, -1}, // 2 steps in x, 1 step in y (West)
            {1, 2}, {1, -2},  // 1 step in x, 2 steps in y (North or South)
            {-1, 2}, {-1, -2} // 1 step in x, 2 steps in y (South)
        };

        // Choose a random L-move from the list
        int[] move = possibleMoves[(int) (Math.random() * possibleMoves.length)];

        // Get current position
        int currentX = getX();
        int currentY = getY();

        // Update the knight's position with the new move
        int newX = currentX + move[0];
        int newY = currentY + move[1];

        // Ensure the new position is within bounds
        if (newX >= 0 && newX <= MAX_POSITION && newY >= 0 && newY <= MAX_POSITION) {
            // Set new position using the setters
            setX(newX);
            setY(newY);

            // Redraw the knight at the new position
            canvasRobot.drawRobot(getX(), getY());

            // Add a delay to make the movement observable
            try {
                Thread.sleep(1000);  // 1 second delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Move out of bounds, Cavalier stays in position.");
        }
    }
    
    public void slowMoveKnight() {
        // Randomly decide whether to move 2 steps horizontally and 1 vertically, or 1 step horizontally and 2 vertically
        if (Math.random() < 0.5) {
            // Move 2 steps horizontally, then 1 step vertically
            slowMoveHorizontalKnight(2);  // Move 2 horizontally
            slowMoveVerticalKnight(1);    // Move 1 vertically
        } else {
            // Move 1 step horizontally, then 2 steps vertically
            slowMoveHorizontalKnight(1);  // Move 1 horizontally
            slowMoveVerticalKnight(2);    // Move 2 vertically
        }
    }

    // Move horizontally by a fixed amount (1 or 2)
    public void slowMoveHorizontalKnight(int steps) {
        int delta = (Math.random() < 0.5) ? -1 : 1; // Randomly move left (-1) or right (+1)

        for (int i = 0; i < steps; i++) {
            xPosition += delta;
            draw();
            try {
                Thread.sleep(500); // Add delay to slow down movement
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Move vertically by a fixed amount (1 or 2)
    public void slowMoveVerticalKnight(int steps) {
        int delta = (Math.random() < 0.5) ? -1 : 1; // Randomly move up (-1) or down (+1)

        for (int i = 0; i < steps; i++) {
            yPosition += delta;
            draw();
            try {
                Thread.sleep(500); // Add delay to slow down movement
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
        
    @Override
    public void avancer() {
        // Perform one L-shape movement with delays
        slowMoveKnight();  // First and Second L-move
    }
}

public class Cavalier extends Robot {
    private static final int MAX_POSITION = 11;

    public Cavalier(String name, int initialX, int initialY, String colourBody, World world) {
        super(name, initialX, initialY, colourBody, world);
        world.addRobot(this, initialX, initialY); // Automatically add to the world
    }

    // Méthode pour choisir et effectuer un déplacement aléatoire en forme de L
    private void moveCavalierWithDelay() {
        int[][] possibleMoves = {
            {2, 1}, {2, -1},  // 2 steps in x, 1 step in y (East or West)
            {-2, 1}, {-2, -1}, // 2 steps in x, 1 step in y (West)
            {1, 2}, {1, -2},  // 1 step in x, 2 steps in y (North or South)
            {-1, 2}, {-1, -2} // 1 step in x, 2 steps in y (South)
        };

        boolean validMove = false;

        while (!validMove) {
            // Choisir un déplacement L aléatoire
            int[] move = possibleMoves[(int) (Math.random() * possibleMoves.length)];

            // Position actuelle
            int currentX = getX();
            int currentY = getY();

            // Calculer la nouvelle position
            int newX = currentX + move[0];
            int newY = currentY + move[1];

            // Vérifier si la nouvelle position est valide (dans les limites du monde)
            if (newX >= 0 && newX <= MAX_POSITION && newY >= 0 && newY <= MAX_POSITION) {
                // Mettre à jour la position du Cavalier
                setX(newX);
                setY(newY);

                // Redessiner le Cavalier à la nouvelle position
                canvasRobot.drawRobot(getX(), getY());

                // Déplacer validé
                validMove = true;
                
                try {
                    Thread.sleep(500); // Slow down movements for visibility
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Effectue un mouvement L aléatoire
    public void slowMoveKnight() {
        moveCavalierWithDelay();
    }

    // Méthode override avancer() pour effectuer un mouvement
    @Override
    public void avancer() {
        //moveCavalierWithDelay();
        slowMoveKnight();  // Effectuer le mouvement en L avec validation
    }
}
*/
/**
 * Décrivez votre classe Cavalier ici.
 *
 * @author Alogbo Toundé
 * @version 15/10/2024
 */

public class Cavalier extends Robot {
    private static final int MAX_POSITION = 11;

    public Cavalier(String name, int initialX, int initialY, String colourBody, World world) {
        super(name, initialX, initialY, colourBody, world);
        world.addRobot(this, initialX, initialY); // Automatically add the Cavalier to the world
    }

    // Method to move the knight in an L-shape with a delay
    private void moveCavalierWithDelay() {
        int[][] possibleMoves = {
            {2, 1}, {2, -1},  // 2 steps in x, 1 step in y (East or West)
            {-2, 1}, {-2, -1}, // 2 steps in x, 1 step in y (West)
            {1, 2}, {1, -2},  // 1 step in x, 2 steps in y (North or South)
            {-1, 2}, {-1, -2} // 1 step in x, 2 steps in y (South)
        };

        // Choose a random L-move from the list
        int[] move = possibleMoves[(int) (Math.random() * possibleMoves.length)];

        // Get current position
        int x = this.getX();
        int y = this.getY();

        // Calculate the new position
        int newX = x + move[0];
        int newY = y + move[1];

        // Check if the new position is within bounds and not occupied
        if (!world.isValidPosition(newX, newY)) {
            System.out.println("Move out of bounds, Cavalier stays in position.");
            return;
        } else if (world.isPositionOccupied(newX, newY)) {
            System.out.println("Position already occupied, Cavalier stays in position.");
            return;
        } else {
            // Update the position of the Cavalier
            setX(newX);
            setY(newY);

            // Redraw the Cavalier at the new position
            canvasRobot.drawRobot(getX(), getY());
        }

        // Add a delay to make the movement observable
        try {
            Thread.sleep(1000);  // 1 second delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method to decide and perform an L-shape movement with delay
    public void slowMoveKnight() {
        moveCavalierWithDelay(); // Perform the L-move
    }

    // Move horizontally by a fixed amount (1 or 2 steps)
    public void slowMoveHorizontalKnight(int steps) {
        int delta = (Math.random() < 0.5) ? -1 : 1; // Randomly move left (-1) or right (+1)

        for (int i = 0; i < steps; i++) {
            xPosition += delta;
            draw();  // Draw after each small move
            try {
                Thread.sleep(200); // Add delay to slow down movement
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Move vertically by a fixed amount (1 or 2 steps)
    public void slowMoveVerticalKnight(int steps) {
        int delta = (Math.random() < 0.5) ? -1 : 1; // Randomly move up (-1) or down (+1)

        for (int i = 0; i < steps; i++) {
            yPosition += delta;
            draw();  // Draw after each small move
            try {
                Thread.sleep(200); // Add delay to slow down movement
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void avancer() {
        slowMoveKnight();  // Perform one L-move with delay
    }
}
