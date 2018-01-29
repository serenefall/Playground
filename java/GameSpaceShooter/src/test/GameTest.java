package test;

import model.*;
import org.junit.Before;
import org.junit.Test;

import java.awt.event.KeyEvent;
import java.util.List;

import static org.junit.Assert.*;

public class GameTest {

    private Game game;

    @Before
    public void runBefore() {
        game = new Game();
    }

    @Test
    public void testConstructor() {
        SpaceShip t = game.getSpaceShip();
        assertEquals(Game.SCREEN_WIDTH / 2, t.getX());
        List<Target> sprites = game.getTargets();
        assertEquals(1, sprites.size());
    }

    @Test
    public void testUpdate() {
        SpaceShip s = game.getSpaceShip();
        assertEquals(Game.SCREEN_WIDTH / 2, s.getX());
        game.update();
        assertEquals(Game.SCREEN_WIDTH / 2, s.getX());
        game.update();
        assertEquals(Game.SCREEN_WIDTH / 2, s.getX());
    }

    @Test
    public void testNonKeyPadKeyEvent() {
        SpaceShip t = game.getSpaceShip();
        game.keyEvents(KeyEvent.VK_LEFT);
        game.update();
        assertEquals(Game.SCREEN_WIDTH / 2 - SpaceShip.SPEED_X, t.getX());
        game.update();
        assertEquals(Game.SCREEN_WIDTH / 2 - 2 * SpaceShip.SPEED_X, t.getX());
        game.keyEvents(KeyEvent.VK_RIGHT);
        game.update();
        assertEquals(Game.SCREEN_WIDTH / 2 - SpaceShip.SPEED_X, t.getX());
        game.update();
        assertEquals(Game.SCREEN_WIDTH / 2, t.getX());
    }

    @Test
    public void testKeyPadKeyEvent() {
        SpaceShip t = game.getSpaceShip();
        game.keyEvents(KeyEvent.VK_KP_LEFT);
        game.update();
        assertEquals(Game.SCREEN_WIDTH / 2 - SpaceShip.SPEED_X, t.getX());
        game.update();
        assertEquals(Game.SCREEN_WIDTH / 2 - 2 * SpaceShip.SPEED_X, t.getX());
        game.keyEvents(KeyEvent.VK_KP_RIGHT);
        game.update();
        assertEquals(Game.SCREEN_WIDTH / 2 - SpaceShip.SPEED_X, t.getX());
        game.update();
        assertEquals(Game.SCREEN_WIDTH / 2, t.getX());
    }

    @Test
    public void testSpaceKeyEvent() {
        game.keyEvents(KeyEvent.VK_SPACE);
        assertTrue(game.getTargets().size() >= 2);  // SpaceShip + 1 missile + unspecified # of invaders
        game.keyEvents(KeyEvent.VK_SPACE);
        game.keyEvents(KeyEvent.VK_SPACE);
        assertTrue(game.getTargets().size() >= 4);  // SpaceShip + 3 missiles + unspecified # of invaders
    }

}
