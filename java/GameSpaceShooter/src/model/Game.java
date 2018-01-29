package model;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.*;

public class Game extends Observable{

    public static final Integer ENEMY_HIT = 1;

    public static final int SCREEN_WIDTH = 400;
    public static final int SCREEN_HEIGHT = 800;
    public static final Random RND = new Random();

    private List<Target> targets;
    private SpaceShip spaceShip;
    private boolean isGameOver;
    private int score;

    // Constructor
    public Game() {
        targets = new ArrayList<Target>();
        initializeGame();
        resetGame();
    }

    // Initialize the game
    // modifies: this
    // effects: set the game in the starting status with an empty screen,
    //          Spaceship in the center.
    private void initializeGame() {
        targets.clear();
        spaceShip = new SpaceShip();
        targets.add(spaceShip);
    }

    // Reset the game
    // modifies: this
    // effects: restart the game with 0 score and false isGameOver
    private void resetGame() {
        isGameOver = false;
        score = 0;

        setChanged();
        notifyObservers();
    }

    // Updates the game on clock tick
    // modifies: this
    // effects: update the status of Spaceship, Aliens, Asteroids, and Missiles
    public void update() {
        moveTargets();
        removeMissile();
        releaseAliens();
        releaseAsteroids();
        checkHits();
        checkGameOver();
    }

    // Respond to key events
    // modifies: this
    // effects: move the spaceship, fire missiles, exit the game, and restart
    //          the game when it is over with different key events
    public void keyEvents(int keyCode){
        switch (keyCode){
            case KeyEvent.VK_KP_LEFT:
            case KeyEvent.VK_LEFT:
                spaceShip.directions("left");
                break;
            case KeyEvent.VK_KP_RIGHT:
            case KeyEvent.VK_RIGHT:
                spaceShip.directions("right");
                break;
            case KeyEvent.VK_SPACE:
                fireMissile();
                break;
            case KeyEvent.VK_R:
                if (isGameOver) resetGame();
                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
            default:
        }
    }

    // Render the game
    // modifies: this
    // effects: render the game with Spaceship, Aliens and Asteroids
    public void render(Graphics g){
        for (Target t: targets){
            t.render(g);
        }
    }

    // Move the targets
    // modifies: this
    // effects: move all the targets on the screen to next position
    private void moveTargets() {
        for (Target t: targets){
            t.move();
        }
    }

    // Release Aliens
    // modifies: this
    // effects: randomly release Aliens from top of the screen at random positions
    public void releaseAliens() {
        if (RND.nextInt(180)<1){
            Alien a = new Alien(RND.nextInt(SCREEN_WIDTH), 10);
            targets.add(a);
        }
    }

    // Release Asteroids
    // modifies: this
    // effects: randomly release Asteroids from top of the screen at random positions
    public void releaseAsteroids() {
        if (RND.nextInt(180)<1){
            Asteroid a = new Asteroid(RND.nextInt(SCREEN_WIDTH), 10);
            targets.add(a);
        }
    }

    // Fire missiles
    // modifies: this
    // effects: fire a missile from SpaceShip
    public void fireMissile(){
        Missile m = new Missile(spaceShip.getX(), spaceShip.getY());
        targets.add(m);
    }

    // Remove missiles missing the Aliens or Asteroids
    // modifies: this
    // effects: remove missiles out of the top of the screen.
    public void removeMissile(){
        Iterator<Target> it = targets.iterator();
        while (it.hasNext()){
            Target next = it.next();
            if (next.getY() < 0) {
                it.remove();
            }
        }
    }


    // Check collisions between Spaceship, Aliens, Asteroids and Missiles
    // modifies: this
    // effects: remove Aliens and Asteroids hit by Missiles that will be removed as well,
    //          set isGameOver to true if SpaceShip is hit
    public void checkHits(){
        List<Target> hitToRemove = new ArrayList<Target>();
        for (Target t : targets){
            if (t instanceof Alien || t instanceof Asteroid){
                checkEnemyHit(t, hitToRemove);
            } else if (t instanceof SpaceShip){
                checkSpaceShipHit((SpaceShip) t);
            }
        }

        targets.removeAll(hitToRemove);
    }

    // Check whether a missile hit an alien or asteroid
    // modifies: this, hitToRemove
    // effects: if a missile hit an alien or asteroid, remove both the missile and
    //          the alien or asteroid, and increment the score
    private void checkEnemyHit(Target a, List<Target> hitToRemove) {
        for (Target t: targets){
            if (t instanceof Missile) {
                if (a.hitWith(t)) {
                    hitToRemove.add(a);
                    hitToRemove.add(t);
                    score++;

                    setChanged();
                    notifyObservers(Game.ENEMY_HIT);
                }
            }
        }
    }

    // Check whether the spaceship is hit by an alien or an asteroid
    // modifies: this
    // effects: if the spaceship is hit by aliens or asteroids, the game is over
    private void checkSpaceShipHit(SpaceShip s) {
        for (Target t: targets){
            if (t instanceof Alien || t instanceof Asteroid) {
                if (s.hitWith(t)) {
                    isGameOver = true;
                }
            }
        }
    }

    // Check whether the game is over
    // modifies: this
    // effects: if an alien or an asteroid hit the bottom (the Earth),
    //          the game is over, and the game is initialized
    public void checkGameOver(){
        for (Target t: targets){
            if (t instanceof Alien || t instanceof Asteroid) {
                if (t.getY() > SCREEN_HEIGHT){
                    isGameOver = true;
                }
            }
        }

        if (isGameOver) {
            initializeGame();
        }
    }

    // Check whether the game is over, return true if it is.
    public boolean isGameOver(){
        return isGameOver;
    }

    public int getScore(){
        return score;
    }

    public SpaceShip getSpaceShip(){
        return spaceShip;
    }

    public List<Target> getTargets(){
        return targets;
    }

}
