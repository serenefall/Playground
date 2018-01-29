package model;

import java.awt.*;

/*
 * An abstract class to represent all moving targets including the SpaceShip controlled
 * by player, Missiles fired by player, and Aliens and Asteroids.
 */

public abstract class Target {

    protected int x;
    protected int y;
    protected int w;
    protected int h;

    public Target (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    // Render the targets
    // modifies: g
    // effect: render the targets on the Graphics object g
    public abstract void render (Graphics g);

    // Move the targets to default direction
    // modifies: this
    // effect: move the targets on the screen to default direction
    public abstract void move ();

    // Check whether two targets hit with each other
    // effects: if two targets hit with each other, return true
    public boolean hitWith(Target another) {
        Rectangle thisBoundary = new Rectangle(getX() - getW()/2, getY() - getH()/2, getW(), getH());
        Rectangle anotherBoundary = new Rectangle(another.getX() - another.getW()/2,
                another.getY() - another.getH()/2, another.getW(), another.getH());
        return thisBoundary.intersects(anotherBoundary);
    }

}
