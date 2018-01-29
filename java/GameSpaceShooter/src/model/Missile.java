package model;

import java.awt.*;

public class Missile extends Target {

    public static final int SPEED_Y = -20;
    public static final int WIDTH = 4;
    public static final int HEIGHT = 20;
    private static final Color COLOR = new Color(255, 255, 255);

    // Constructor
    // Missiles will be fired from the location (x, y)
    public Missile(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(COLOR);
        g.fillOval(getX() - WIDTH/2, getY() - HEIGHT/2, WIDTH, HEIGHT);
    }

    // Missiles will move towards the top of the screen
    @Override
    public void move() {
        y = y + SPEED_Y;
    }

}
