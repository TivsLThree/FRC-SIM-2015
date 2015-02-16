package frc.sim;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseClickTracker implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent m) {
        if (Board.state != null) {
            Board.state.clicked(m);
            Point p = Board.self.getLocationOnScreen();
            int mouseX = m.getXOnScreen() - p.x; 
            int mouseY = m.getYOnScreen() - p.y;
            for (Entity e : Board.state.entities) {
                if (e.box().contains(mouseX, mouseY)) {
                    e.clicked(m);
                    return;
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }  
}
