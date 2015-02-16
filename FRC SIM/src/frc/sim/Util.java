package frc.sim;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public class Util {
    
    public static Image toImage(Class c, String s) {
        return new ImageIcon(c.getResource(s)).getImage();
    }

    public static int randomInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
    
    public static void drawCentered(Graphics2D g, String string, int x, int y) {
        int textWidth = g.getFontMetrics().stringWidth(string);
        g.drawString(string, x - (textWidth / 2), y);
    }
}
