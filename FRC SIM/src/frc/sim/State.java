package frc.sim;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class State extends Entity {
 
    public List<Entity> entities = new ArrayList<>();
    
    public State() {
        super(0, 0);
    }
    
    @Override
    public void tick() {
        for (Entity e : entities) {
            e.tick();
        }
    }
    
    @Override
    public void draw(Graphics2D g) {
        for (Entity e : entities) {
            e.draw(g);
        }
    }
    
}
