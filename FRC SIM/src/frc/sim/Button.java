package frc.sim;

import java.awt.Graphics2D;
import java.awt.Image;

public class Button extends Entity {
    
    public Image drawImage;
    public Image pressedImage;
    
    public Button(int x, int y, String imagePath1, String imagePath2) {
        super(x, y, imagePath1);
        drawImage = image;
        pressedImage = Util.toImage(getClass(), imagePath2);
    }
    
    @Override
    public void draw(Graphics2D g) {
        g.drawImage(drawImage, x, y, null);
    }
    
    @Override
    public void mouseEnter() {
        drawImage = pressedImage;
    }
    
    @Override
    public void mouseLeave() {
        drawImage = image;
    }
}
