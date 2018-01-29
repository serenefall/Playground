package ui;

import model.Game;

import java.util.Observable;
import java.util.Observer;

// Notify when missiles hit the Aliens or Asteroids
public class HitObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if (arg == Game.ENEMY_HIT)
            System.out.println("Hit!");
    }
}