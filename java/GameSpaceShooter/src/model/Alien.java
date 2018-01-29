package model;

import java.awt.Color;
import java.awt.Graphics;

public class Alien extends Target{

    public static final int SPEED_Y = 1;
    public static final int WIDTH = 40;
    public static final int HEIGHT = 20;
    public static final int S_ANGLE = -30;
    public static final int ARC_ANGLE = 240;
    private static final Color COLOR = new Color(20, 80, 220);
    private static final int SHAKE = 1;

    public Alien(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(COLOR);
        g.fillArc(getX() - WIDTH/2, getY() - HEIGHT/2, WIDTH, HEIGHT, S_ANGLE, ARC_ANGLE);
    }

    // Move Aliens in a zig-zag route
    @Override
    public void move() {
        x += Game.RND.nextInt(20 * SHAKE + 1) - 10 * SHAKE;
        y += SPEED_Y;

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
