package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Game;

/*
 * Display the score on this band panel
 */

public class InfoPanel extends JPanel implements Observer{

    private static final String SCORE_TXT = "SCORE: ";
    private static final int LBL_WIDTH = 150;
    private static final int LBL_HEIGHT = 40;
    private Game game;
    private JLabel scoreLable;

    public InfoPanel(Game g){
        game = g;
        setBackground(new Color(190,190,190));
        scoreLable = new JLabel(SCORE_TXT+game.getScore());
        scoreLable.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
        add(scoreLable);
        add(Box.createVerticalStrut(15));
    }

    // update the score panel with real-time data
    public void update(){
        scoreLable.setText(SCORE_TXT+game.getScore());
        repaint();
    }

    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     */
    @Override
    public void update(Observable o, Object arg) {
        update();
    }
}
