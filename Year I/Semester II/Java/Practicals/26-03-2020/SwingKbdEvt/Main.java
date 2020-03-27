
/**
 * Using Swing, write a program which responds to KEY_TYPED event and 
 * updates the status window with message ("Typed character is: X"). 
 * Use adapter class for other two events.
 *
 * @author sudipto@ghosh.pro University of Delhi
 */

/**** Main.java ****/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class KbdAdapter extends KeyAdapter {
    JLabel l;

    KbdAdapter(JLabel l) {
        this.l = l;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        l.setText("Typed character is: " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Pressed character is: " + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Released character is: " + e.getKeyChar());
    }
}

public class Main {
    JLabel l;

    Main() {
        JFrame f = new JFrame("AWT Keyboard");
        l = new JLabel("", SwingConstants.CENTER);
        l.setBounds(15, 20, 250, 30);
        f.addKeyListener(new KbdAdapter(l));
        f.add(l);
        f.setSize(300, 110);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });

    }
}
