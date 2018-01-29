package test;

import model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class SpaceShipTest {
    private static final int X = Game.SCREEN_WIDTH / 2;
    private SpaceShip s;

    @Before
    public void runBefore() {
        s = new SpaceShip();
    }

    @Test
    public void testConstructor() {
        assertEquals(X, s.getX());
    }

    @Test
    public void testMoveRightOnce() {
        s.directions("right");
        s.move();
        assertEquals(X + SpaceShip.SPEED_X, s.getX());
    }

    @Test
    public void testMoveLeftOnce() {
        s.directions("left");
        s.move();
        assertEquals(X - SpaceShip.SPEED_X, s.getX());
    }

    @Test
    public void testMoveRightMany() {
        s.directions("right");
        final int NUM_UPDATES = (Game.SCREEN_WIDTH / 4) / SpaceShip.SPEED_X;

        for (int count = 0; count < NUM_UPDATES; count++) {
            s.move();
        }

        assertEquals(X + NUM_UPDATES * SpaceShip.SPEED_X, s.getX());
    }

    @Test
    public void testMoveLeftMany() {
        final int NUM_UPDATES = (Game.SCREEN_WIDTH / 4) / SpaceShip.SPEED_X;

        s.directions("left");

        for (int count = 0; count < NUM_UPDATES; count++) {
            s.move();
        }

        assertEquals(X - NUM_UPDATES * SpaceShip.SPEED_X, s.getX());
    }

    @Test
    public void testLeftBoundary() {
        s.directions("left");
        while (s.getX() > 0)
            s.move();

        assertEquals(0, s.getX());

        s.move();
        assertEquals(0, s.getX());
    }

    @Test
    public void testRightBoundary() {
        s.directions("right");
        while (s.getX() < Game.SCREEN_WIDTH)
            s.move();

        assertEquals(Game.SCREEN_WIDTH, s.getX());

        s.move();
        assertEquals(Game.SCREEN_WIDTH, s.getX());
    }
}

