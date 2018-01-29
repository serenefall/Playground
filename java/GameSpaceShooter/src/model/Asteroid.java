package model;

import java.awt.*;

public class Asteroid extends Target {

    public static final int SPEED_Y = 1;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 9;
    private static final Color COLOR = new Color(120, 80, 20);

    public Asteroid(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(COLOR);
        g.fillOval(getX() - WIDTH / 2, getY() - HEIGHT / 2, WIDTH, HEIGHT);
    }

    @Override
    public void move() {
        y += SPEED_Y;
    }


}

