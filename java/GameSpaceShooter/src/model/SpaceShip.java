package model;

import java.awt.*;

public class SpaceShip extends Target {

    public static final int SPEED_X = 1;
    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;
    private static final int START_X = Game.SCREEN_WIDTH/2;
    private static final int START_Y = Game.SCREEN_HEIGHT - 20;
    private static final Color COLOR = new Color(255, 200, 00);

    private int direction;

    // Constructor
    // Put a SpaceShip at location (START_X, START_Y)
    public SpaceShip(){
        super(START_X, START_Y, WIDTH, HEIGHT);
        direction = 0;
    }

    // Render the SpaceShip
    @Override
    public void render(Graphics g) {
        g.setColor(COLOR);
        g.fillRect(getX() - WIDTH / 2, getY() - HEIGHT / 2, WIDTH, HEIGHT);
        Polygon shipWing = createShipWing();
        g.fillPolygon(shipWing);
    }

    // Render the wings of the SpaceShip
    private Polygon createShipWing() {
        Polygon tankFront = new Polygon();

        tankFront.addPoint(x + WIDTH / 2, START_Y + HEIGHT / 2);
        tankFront.addPoint(x + WIDTH, START_Y);
        tankFront.addPoint(x + WIDTH / 2, START_Y - HEIGHT / 2);
        tankFront.addPoint(x - WIDTH / 2, START_Y + HEIGHT / 2);
        tankFront.addPoint(x - WIDTH, START_Y);
        tankFront.addPoint(x - WIDTH / 2, START_Y - HEIGHT / 2);

        return tankFront;
    }

    public void directions(String d) {
        switch (d){
            case "left":
                direction = 1;
                break;
            case "right":
                direction = 2;
                break;
            default:
        }

        handleBoundary();
    }

    // Move the SpaceShip to four directions
    @Override
    public void move() {
        switch (direction){
            case 1:
                x = x - SPEED_X;
                break;
            case 2:
                x = x + SPEED_X;
                break;
            default:
        }

        handleBoundary();
    }

    // Handle the boundary of SpaceShip
    // modifies: this
    // effects: Spaceship will stay within the screen
    private void handleBoundary() {
        if (x < 0)
            x = 0;
        else if (x > Game.SCREEN_WIDTH)
            x = Game.SCREEN_WIDTH;
    }
}
