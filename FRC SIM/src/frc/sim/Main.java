package frc.sim;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main extends JFrame {

    public static Main self;
    
    public Main() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setTitle("FRC SIM");
        add(new Board());
        addMouseListener(new MouseClickTracker());
        setVisible(true);
        self = this;
    }
    
    public static void main(String[] args) {
        new Main();
    }
    
}
