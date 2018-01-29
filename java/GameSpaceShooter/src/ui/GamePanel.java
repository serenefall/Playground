package ui;

import model.Game;

import javax.swing.*;
import java.awt.*;

/*
 * Build the panel for this game
 */
public class GamePanel extends JPanel {

    private static final String OVER = "Game Over! Earth Was Hit!";
    private static final String REPLAY = "Press R to Replay";
    private static final String EXIT = "Press ESC to Exit";

    private Game game;

    // Constructs a game panel
    // effects:  set size and background colour of the panel,
    public GamePanel(Game g) {
        setPreferredSize(new Dimension(Game.SCREEN_WIDTH, Game.SCREEN_HEIGHT));
        setBackground(Color.BLACK);
        game = g;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        renderGame(g);
        if (game.isGameOver()) {
            gameOver(g);
        }
    }

    // Draws the game
    // modifies: g
    // effects:  render the game onto the Graphics object g
    private void renderGame(Graphics g) {
        game.render(g);
    }

    // Draws the "game over" message, replay and exit instructions
    // modifies: g
    // effects:  draws "game over", replay and exit instructions onto g
    private void gameOver(Graphics g) {
        g.setColor(new Color( 255, 255, 255));
        g.setFont(new Font("Arial", Font.BOLD, 20));
        FontMetrics fm = g.getFontMetrics();
        centreString(OVER, g, fm, Game.SCREEN_HEIGHT / 2);
        centreString(REPLAY, g, fm, Game.SCREEN_HEIGHT / 2 + 50);
        centreString(EXIT, g, fm, Game.SCREEN_HEIGHT / 2 + 100);
    }

    // Centres a string on the screen
    // modifies: g
    // effects:  put the string in the centre horizontally onto g at vertical position y
    private void centreString(String str, Graphics g, FontMetrics fm, int y) {
        int width = fm.stringWidth(str);
        g.drawString(str, (Game.SCREEN_WIDTH - width) / 2, y);
    }
}