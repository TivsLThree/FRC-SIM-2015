package frc.sim;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
    
    public static State state = null;
    public static Board self;
    Image background;
    Timer timer;
    
    public Board() {
        timer = new Timer(25, this);
        timer.start();
        state = new CreateTeamState();
        background = Util.toImage(getClass(), "background.png");
        self = this;
    }
    
    @Override
    public void paint(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.drawImage(background, 0, 0, null);
        state.draw(g);
        state.tick();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
