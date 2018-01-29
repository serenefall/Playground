import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Add a favorite quote to the bottom of the clock
 */
public class QuoteLabel extends JLabel implements ActionListener {

    private String QUOTE;

    QuoteLabel(String quote) {
        QUOTE = quote;
        setForeground(Color.green);
        setFont(new Font("sans-serif", Font.PLAIN, 18));
        setHorizontalAlignment(SwingConstants.CENTER);
        Timer t = new Timer(2500, this);
        t.start();
    }

    public void actionPerformed(ActionEvent ae) {
        setText(QUOTE);
    }
}
