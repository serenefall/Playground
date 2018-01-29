import javax.swing.*;
import java.awt.*;

/*
 * A simple digital clock to display the time, date and a line of quote.
 */

public class DigitalClock {

    public static void main(String[] args) {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame f = new JFrame("Digital Clock");
        f.setSize(320,180);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(3, 1));
        f.getContentPane().setBackground(Color.black);

        ClockLabel timeLable = new ClockLabel("time");
        ClockLabel dateLable = new ClockLabel("date");
        QuoteLabel qLabel = new QuoteLabel("The Best Time Is Now!");

        f.add(dateLable);
        f.add(timeLable);
        f.add(qLabel);

        f.setVisible(true);
    }
}
