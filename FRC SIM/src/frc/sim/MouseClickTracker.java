package frc.sim;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseClickTracker implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent m) {
        if (Board.state != null) {
            for (Entity e : Board.state.entities) {
                Point p = Board.self.getLocationOnScreen();
                int mouseX = m.getXOnScreen() - p.x; 
                int mouseY = m.getYOnScreen() - p.y;
                System.out.println("Click at " + mouseX + " " + mouseY);
                if (e.box().contains(mouseX, mouseY)) {
                    e.clicked();
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
