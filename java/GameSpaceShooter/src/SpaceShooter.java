
import model.Game;
import ui.GamePanel;
import ui.HitObserver;
import ui.InfoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*
 * The main window to start the game, including the game panel and the score panel
 */
public class SpaceShooter extends JFrame{

    private static final int INTERVAL = 10;
    private Game game;
    private GamePanel gamePanel;
    private InfoPanel infoPanel;
    private Timer timer;

    public SpaceShooter(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        game = new Game();
        gamePanel = new GamePanel(game);
        infoPanel = new InfoPanel(game);

        HitObserver hitObs = new HitObserver();
        game.addObserver(hitObs);
        game.addObserver(infoPanel);

        add(gamePanel);
        add(infoPanel, BorderLayout.SOUTH);
        addKeyListener(new KeyHandler());
        pack();
        showOnScreen();
        setVisible(true);
        setTimer();
        timer.start();
    }

    // Start a new game
    public static void main(String[] args) {
	    new SpaceShooter();
    }

    // Set a timer to update the game in INTERVAL milliseconds
    private void setTimer(){
        timer = new Timer(INTERVAL, ae -> {
            game.update();
            gamePanel.repaint();
            infoPanel.update();
        });
    }

    // Show the game frames on the center of the screen
    private void showOnScreen(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - getWidth()) / 2, (screen.height - getHeight()) / 2);
    }

    // Key handler
    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            game.keyEvents(e.getKeyCode());
        }
    }
}
