package test;

import model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AsteroidTest {

    private static final int X = Game.SCREEN_WIDTH / 2;
    private static final int Y = 50;
    private Asteroid asteroid;

    @Before
    public void runBefore() {
        asteroid = new Asteroid(X, Y);
    }

    @Test
    public void testUpdate() {
        final int NUM_UPDATES = 8;

        asteroid.move();
        assertEquals(Y + Asteroid.SPEED_Y, asteroid.getY());

        for(int count = 1; count < NUM_UPDATES; count++) {
            asteroid.move();
        }

        assertEquals(Y + NUM_UPDATES * Asteroid.SPEED_Y, asteroid.getY());
    }

    @Test
    public void testCollideWith() {
        Missile m = new Missile(0, 0);
        assertFalse(asteroid.hitWith(m));

        m = new Missile(asteroid.getX(), asteroid.getY());
        assertTrue(asteroid.hitWith(m));

        m = new Missile(asteroid.getX() + Asteroid.WIDTH / 2 + Missile.WIDTH / 2, asteroid.getY());
        assertFalse(asteroid.hitWith(m));

        m = new Missile(asteroid.getX() + Asteroid.WIDTH / 2 + Missile.WIDTH / 2 + 1, asteroid.getY());
        assertFalse(asteroid.hitWith(m));

        m = new Missile(asteroid.getX() - Asteroid.WIDTH / 2 - Missile.WIDTH / 2, asteroid.getY());
        assertFalse(asteroid.hitWith(m));

        m = new Missile(asteroid.getX() - Asteroid.WIDTH / 2 - Missile.WIDTH / 2 - 1, asteroid.getY());
        assertFalse(asteroid.hitWith(m));

        m = new Missile(asteroid.getX(), asteroid.getY() + Asteroid.HEIGHT / 2 + Missile.HEIGHT / 2);
        assertTrue(asteroid.hitWith(m));

        m = new Missile(asteroid.getX(), asteroid.getY() + Asteroid.HEIGHT / 2 + Missile.HEIGHT / 2 + 1);
        assertFalse(asteroid.hitWith(m));
    }

}
