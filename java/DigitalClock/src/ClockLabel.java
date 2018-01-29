import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Display the time and date in specific format on the clock
 */

public class ClockLabel extends JLabel implements ActionListener {

    private SimpleDateFormat sdformat;

    ClockLabel(String type) {

        setForeground(Color.yellow);

        switch (type) {
            case "time":
                sdformat = new SimpleDateFormat("hh:mm:ss a");
                setFont(new Font("sans-serif", Font.PLAIN, 42));
                setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case "date":
                sdformat = new SimpleDateFormat("MMMM dd, yyyy           EEE");
                setFont(new Font("sans-serif", Font.PLAIN, 16));
                setHorizontalAlignment(SwingConstants.CENTER);
                break;
            default:
                sdformat = new SimpleDateFormat();
                break;
        }

        Timer t = new Timer(500, this);
        t.start();
    }

    public void actionPerformed(ActionEvent ae) {
        setText(sdformat.format(new Date()));
    }
}
