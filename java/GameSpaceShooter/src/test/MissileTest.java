package test;

import model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MissileTest {

    private static final int X = Game.SCREEN_WIDTH / 2;
    private static final int Y = 60;
    private Missile m;

    @Before
    public void runBefore() {
        m = new Missile(X, Y);
    }

    @Test
    public void testUpdate() {
        final int NUM_UPDATES = 6;

        m.move();
        assertEquals(X, m.getX());
        assertEquals(Y + Missile.SPEED_Y, m.getY());

        for(int count = 1; count < NUM_UPDATES; count++) {
            m.move();
        }

        assertEquals(X, m.getX());
        assertEquals(Y + NUM_UPDATES * Missile.SPEED_Y, m.getY());
    }
}
