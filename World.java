/*import java.util.List;
import java.util.ArrayList;

public class World {
    private List<Robot> robots;
    private Canvas canvas;
    private int size;

    public World(int size) {
        this.size = size;
        robots = new ArrayList<>();
        canvas = Canvas.getCanvas();
        canvas.setVisible(true);
    }

    public void addRobot(Robot robot, int x, int y) {
        if (isValidPosition(x, y) && !isPositionOccupied(x, y)) {
            robot.setX(x); // Set robot's position
            robot.setY(y); // Set robot's position
            robots.add(robot);
            try {
                Thread.sleep(500); // Delay to simulate movement
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid or occupied position (" + x + ", " + y + ").");
        }
    }

    // Check if the position is valid within world bounds
    public static boolean isValidPosition(int x, int y) {
        return x >= 0 && y >= 0; // Assuming (0, 0) is the minimum valid position
    }

    // Check if a position is occupied by any robot
    private boolean isPositionOccupied(int x, int y) {
        for (Robot robot : robots) {
            if (robot.getX() == x && robot.getY() == y) {
                return true;
            }
        }
        return false;
    }

    // Move a robot by its name
    public void moveRobot(String robotName) {
        for (Robot robot : robots) {
            if (robot.getName().equals(robotName)) {
                robot.avancer();
                checkGameOver(robot);
                return;
            }
        }
        System.out.println("Robot not found: " + robotName);
    }

    // Check for collisions or out-of-bounds conditions
    private void checkGameOver(Robot currentRobot) {
        // Check if the current robot's new position overlaps with any other robot's position
        for (Robot otherRobot : robots) {
            if (currentRobot != otherRobot && 
                currentRobot.getX() == otherRobot.getX() && 
                currentRobot.getY() == otherRobot.getY()) {
                System.out.println("Collision! Game Over.");
                canvas.gameOver();
                return;
            }
        }

    // Check if the robot is out of bounds
    if (currentRobot.getX() < 0 || currentRobot.getY() < 0 || 
        currentRobot.getX() >= size || currentRobot.getY() >= size) {
        System.out.println("Out of bounds! Game Over.");
        canvas.gameOver();
    }

    }
    public void moveAllRobots() {
        for (int turn = 0; turn < 10; turn++) { // Loop for 10 turns
            for (Robot robot : robots) {
                robot.avancer();
                try {
                    Thread.sleep(500); // Slow down movements for visibility
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                checkGameOver(robot);
            }
        }
    }

}*/

/*
import java.awt.Color; // Import the Color class
import java.util.List;
import java.util.ArrayList;

public class World {
    private List<Robot> robots;
    private Canvas canvas;
    private int size;
    private String name; // Added name field

    public World(int size, String name) { // Added name parameter
        this.size = size;
        this.name = name; // Set the name
        robots = new ArrayList<>();
        canvas = Canvas.getCanvas();
        canvas.setVisible(true);
    }
    
   /* public World(int size) {
        this.size = size;
        robots = new ArrayList<>();
        canvas = Canvas.getCanvas();
        canvas.setVisible(true);
    }*

    // Method to set the background color of the world
    public void setWorldColor(Color color) {
        canvas.setBackgroundColor(color); // Assuming Canvas has this method
    }
    
    // Method to find a robot at a specific position
    private Robot searchRobotAtPosition(int x, int y) {
        for (Robot robot : robots) {
            if (robot.getX() == x && robot.getY() == y) {
                return robot; // Return the robot at the given coordinates
            }
        }
        return null; // No robot found at the position
    }
    
    public boolean isPositionOccupied(int X, int Y) {
    // Retourne true si la case d'arrivée est occupée, sinon false
    Robot robot = this.searchRobotAtPosition(X,Y);
    if (robot != null) {
        System.out.println(this.name + " : La case est occupée par " + robot.getName());
        return true;
    }
    System.out.println(this.name + " : La case est libre, let's go");
    return false;
    }



    public void addRobot(Robot robot, int x, int y) {
        if (isValidPosition(x, y) && !isPositionOccupied(x, y)) {
            robot.setX(x); // Set robot's position
            robot.setY(y); // Set robot's position
            robots.add(robot);
            try {
                Thread.sleep(500); // Delay to simulate movement
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid or occupied position (" + x + ", " + y + ").");
        }
    }

    // Check if the position is valid within world bounds
    public static boolean isValidPosition(int x, int y) {
        return x >= 0 && y >= 0; // Assuming (0, 0) is the minimum valid position
    }
    

    /* Check if a position is occupied by any robot
    private boolean isPositionOccupied(int x, int y) {
        for (Robot robot : robots) {
            if (robot.getX() == x && robot.getY() == y) {
                return true;
            }
        }
        return false;
    }*

    // Move a robot by its name
    public void moveRobot(String robotName) {
        for (Robot robot : robots) {
            if (robot.getName().equals(robotName)) {
                robot.avancer();
                checkGameOver(robot);
                return;
            }
        }
        System.out.println("Robot not found: " + robotName);
    }

    // Check for collisions or out-of-bounds conditions
    private void checkGameOver(Robot currentRobot) {
        // Check if the current robot's new position overlaps with any other robot's position
        for (Robot otherRobot : robots) {
            if (currentRobot != otherRobot && 
                currentRobot.getX() == otherRobot.getX() && 
                currentRobot.getY() == otherRobot.getY()) {
                System.out.println("Collision! Game Over.");
                canvas.gameOver();
                return;
            }
        }

        // Check if the robot is out of bounds
        if (currentRobot.getX() < 0 || currentRobot.getY() < 0 || 
            currentRobot.getX() >= size || currentRobot.getY() >= size) {
            System.out.println("Out of bounds! Game Over.");
            canvas.gameOver();
        }
    }

    // Move all robots for 10 turns
    public void moveAllRobots() {
        for (int turn = 0; turn < 10; turn++) { // Loop for 10 turns
            for (Robot robot : robots) {
                robot.avancer();
                try {
                    Thread.sleep(500); // Slow down movements for visibility
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                checkGameOver(robot);
            }
        }
    }
}*/
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

public class World {
    private List<Robot> robots;
    private Canvas canvas;
    private String name; // Added name field
    private int size;

    // Constructor to initialize the world with a given size
    public World(int size) {
        this.size = size;
        this.name = name; // Set the name
        robots = new ArrayList<>();
        canvas = Canvas.getCanvas();
        canvas.setVisible(true);
    }

    // Method to set the background color of the world
    //public void setWorldColor(Color color) {
    //    canvas.setBackgroundColor(color); // Assuming Canvas has this method
    //}

    // Method to check if a position is occupied by another robot
    //public boolean isPositionOccupied(int x, int y) {
        //return searchRobotAtPosition(x, y) != null;
    //}

    public boolean isPositionOccupied(int X, int Y){
        //Retourne true si la case d'arrivée est occupée, sinon false
        Robot robot = this.searchRobotAtPosition(X,Y);
        if (robot != null){
            System.out.println(this.name+" : La case est occupée par "+robot.getName());
            return true;
        }
        System.out.println(this.name+" : La case est libre, let's go");
        return false;
    }
    // Method to find a robot at a specific position
    private Robot searchRobotAtPosition(int x, int y) {
        for (Robot robot : robots) {
            if (robot.getX() == x && robot.getY() == y) {
                return robot; // Return the robot at the given coordinates
            }
        }
        return null; // No robot found at the position
    }

    // Method to add a robot to the world at a specific position
    public void addRobot(Robot robot, int x, int y) {
        if (isValidPosition(x, y) && !isPositionOccupied(x, y)) {
            robot.setX(x); // Set robot's position
            robot.setY(y); // Set robot's position
            robots.add(robot); // Add the robot to the list
            robot.draw(); // Draw the robot at its position
        } else {
            System.out.println("Invalid or occupied position (" + x + ", " + y + ").");
        }
    }

    // Check if the position is valid within world bounds
    public boolean isValidPosition(int x, int y) {
        return x >= 0 && y >= 0 && x < size && y < size; // Ensure position is within the world bounds
    }

    // Move a robot by its name
    public void moveRobot(String robotName) {
        for (Robot robot : robots) {
            if (robot.getName().equals(robotName)) {
                int oldX = robot.getX();
                int oldY = robot.getY();
                
                robot.avancer(); // Move the robot

                // Check if the new position is occupied by another robot
                if (isPositionOccupied(robot.getX(), robot.getY())) {
                    System.out.println("Collision detected! Reverting move.");
                    // Revert the move if there's a collision
                    robot.setX(oldX);
                    robot.setY(oldY);
                    robot.draw(); // Redraw the robot in its previous position
                } else {
                    checkOutOfBounds(robot); // Check if robot is out of bounds
                }
                return;
            }
        }
        System.out.println("Robot not found: " + robotName);
    }

    private void checkOutOfBounds(Robot currentRobot) {
    if (!isValidPosition(currentRobot.getX(), currentRobot.getY())) {
        System.out.println("Robot " + currentRobot.getName() + " is out of bounds! Resetting position.");
        // Handle the reset or removal of the robot
        currentRobot.setX(0); // Example: Reset to starting position (can be changed)
        currentRobot.setY(0);
        currentRobot.draw(); // Redraw at the new position
    }
}


    public void moveAllRobots() {
    for (int turn = 0; turn < 10; turn++) { // Loop for 10 turns
        for (Robot robot : robots) {
            int oldX = robot.getX();
            int oldY = robot.getY();
            
            robot.avancer(); // Move the robot
            
            // Check if the new position is occupied by another robot
            if (isPositionOccupied(robot.getX(), robot.getY())) {
                System.out.println("Collision detected! Reverting move.");
                // Revert the move if there's a collision
                robot.setX(oldX);
                robot.setY(oldY);
                robot.draw(); // Redraw the robot in its previous position
            } else {
                checkOutOfBounds(robot); // Check if robot is out of bounds
            }

            try {
                Thread.sleep(500); // Slow down movements for visibility
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

}