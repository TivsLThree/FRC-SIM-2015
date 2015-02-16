package frc.sim;

import java.awt.Graphics2D;
import java.awt.Image;

public class Button extends Entity {
    
    public Image drawImage;
    public Image pressedImage;
    public boolean visible = true;
    
    public Button(int x, int y, String imagePath) {
        super(x, y, imagePath);
        drawImage = image;
        pressedImage = Util.toImage(getClass(), imagePath);
    }
    
    public Button(int x, int y, String imagePath1, String imagePath2) {
        super(x, y, imagePath1);
        drawImage = image;
        pressedImage = Util.toImage(getClass(), imagePath2);
    }
    
    @Override
    public void draw(Graphics2D g) {
        if (visible) {
            g.drawImage(drawImage, x, y, null);
        }
    }
    
    @Override
    public void mouseEnter() {
        super.mouseEnter();
        drawImage = pressedImage;
    }
    
    @Override
    public void mouseLeave() {
        super.mouseEnter();
        drawImage = image;
    }
}
