
/**
 * Décrivez votre classe Roi ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Roi extends Robot {
    private static final int MAX_POSITION = 11; // Taille maximale du plateau

    public Roi(String name, int initialX, int initialY, String colourBody, World world) {
        super(name, initialX, initialY, colourBody, world);
        world.addRobot(this, initialX, initialY); // Ajouter automatiquement le Roi au monde
    }

    @Override
    public void avancer() {
        // Définir les déplacements possibles du Roi : 1 case dans n'importe quelle direction
        int[][] possibleMoves = {
            {1, 0},   // Droite
            {-1, 0},  // Gauche
            {0, 1},   // Haut
            {0, -1},  // Bas
            {1, 1},   // Diagonale haut droite
            {-1, -1}, // Diagonale bas gauche
            {1, -1},  // Diagonale bas droite
            {-1, 1}   // Diagonale haut gauche
        };

        boolean moveDone = false; // Indique si le mouvement a été effectué
        while (!moveDone) {
            // Choisir un mouvement aléatoire
            int[] move = possibleMoves[(int) (Math.random() * possibleMoves.length)];

            // Calculer la nouvelle position
            int newX = xPosition + move[0];
            int newY = yPosition + move[1];

            // Vérifier que la nouvelle position est dans les limites du plateau et qu'elle n'est pas occupée
            if (newX >= 0 && newX <= MAX_POSITION && newY >= 0 && newY <= MAX_POSITION 
                && !world.isPositionOccupied(newX, newY)) {
                // Appliquer la nouvelle position si elle est valide
                xPosition = newX;
                yPosition = newY;

                // Dessiner le Roi à la nouvelle position
                canvasRobot.drawRobot(xPosition, yPosition);

                // Ajouter un délai pour ralentir le mouvement (500 ms ici)
                try {
                    Thread.sleep(50); // Pause de 500ms pour rendre le mouvement visible
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Le mouvement est validé, on sort de la boucle
                moveDone = true;
            } else {
                // Si la position est hors limite ou occupée, essayer un autre mouvement
                System.out.println("Le Roi ne peut pas se déplacer ici, réessai.");
            }
        }
    }
}
