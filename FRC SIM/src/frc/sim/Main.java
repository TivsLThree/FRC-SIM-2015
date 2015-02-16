package frc.sim;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main extends JFrame {

    public static Main self;
    public static List<Team> teams = new ArrayList<>();
    
    public Main() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setTitle("FRC Simulator 2015");
        setResizable(false);
        add(new Board());
        addMouseListener(new MouseClickTracker());
        setVisible(true);
        self = this;
    }
    
    public static void main(String[] args) {
        new Main();
    }
 
    public enum Type {
        PROGRAMMING,
        MECHANICAL,
        ELECTRICAL,
        PR,
        MENTOR,
        NONE;
    }    
}
