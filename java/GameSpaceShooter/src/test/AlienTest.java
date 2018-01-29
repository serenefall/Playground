package test;

import model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlienTest {

    private static final int X = Game.SCREEN_WIDTH / 2;
    private static final int Y = 50;
    private Alien alien;

    @Before
    public void runBefore() {
        alien = new Alien(X, Y);
    }

    @Test
    public void testUpdate() {
        final int NUM_UPDATES = 8;

        alien.move();
        assertEquals(Y + Alien.SPEED_Y, alien.getY());

        for(int count = 1; count < NUM_UPDATES; count++) {
            alien.move();
        }

        assertEquals(Y + NUM_UPDATES * Alien.SPEED_Y, alien.getY());
    }

    @Test
    public void testCollideWith() {
        Missile m = new Missile(0, 0);
        assertFalse(alien.hitWith(m));

        m = new Missile(alien.getX(), alien.getY());
        assertTrue(alien.hitWith(m));

        m = new Missile(alien.getX() + Alien.WIDTH / 2 + Missile.WIDTH / 2, alien.getY());
        assertFalse(alien.hitWith(m));

        m = new Missile(alien.getX() + Alien.WIDTH / 2 + Missile.WIDTH / 2 + 1, alien.getY());
        assertFalse(alien.hitWith(m));

        m = new Missile(alien.getX() - Alien.WIDTH / 2 - Missile.WIDTH / 2, alien.getY());
        assertFalse(alien.hitWith(m));

        m = new Missile(alien.getX() - Alien.WIDTH / 2 - Missile.WIDTH / 2 - 1, alien.getY());
        assertFalse(alien.hitWith(m));

        m = new Missile(alien.getX(), alien.getY() + Alien.HEIGHT / 2 + Missile.HEIGHT / 2);
        assertFalse(alien.hitWith(m));

        m = new Missile(alien.getX(), alien.getY() + Alien.HEIGHT / 2 + Missile.HEIGHT / 2 + 1);
        assertFalse(alien.hitWith(m));
    }

}
