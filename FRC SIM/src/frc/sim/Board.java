package frc.sim;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
    
    public static State state = null;
    public static Board self;
    Timer timer;
    
    public Board() {
        timer = new Timer(25, this);
        timer.start();
        state = new TestState();
        this.self = this;
    }
    
    @Override
    public void paint(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        state.draw(g);
        state.tick();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
