package frc.sim;

import frc.sim.Main.Type;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Person extends Entity {
    
    public String name = "Bob";
    public Type role = Type.NONE;
    public Type preferredRole = Type.NONE;
    public double skill = 1.0;
    public double likability = 1.0;
    public int yearsInFRC = 0;
    public Team team = null;
    
    public Person(String name, Team team) {
        super(0, 0, "head.png");
        this.name = name;
        this.team = team;
    }
    
    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        Color oldColor = g.getColor();
        g.setColor(team.color);
        g.fillRect(x + (image.getWidth(null) / 2) - 2, y + image.getHeight(null) - 1, 3, 10);
        g.setColor(oldColor);
        g.drawRect(x + (image.getWidth(null) / 2) - 2, y + image.getHeight(null) - 1, 3, 10);
        if (mouseIn) {
            Util.drawCentered(g, name, x + (image.getWidth(null) / 2), y - 15);
        } else if (Board.state instanceof BuildSeasonState && ((BuildSeasonState) Board.state).selected == this) {
            Util.drawCentered(g, name, x + (image.getWidth(null) / 2), y - 15);
        }
    }
    
    @Override
    public Rectangle box() {
        return new Rectangle(x, y, image.getWidth(null) - 1, image.getHeight(null) + 9);
    }
    
    public void drawWithData(Graphics2D g) {
        draw(g);
        Util.drawCentered(g, name, x + (image.getWidth(null) / 2), y - 75);
        Util.drawCentered(g, (role != Type.MENTOR && role != Type.NONE ? "Preferred Role: " : "") + preferredRole.string(), x + (image.getWidth(null) / 2), y - 60);
        Util.drawCentered(g, "Skill: " + skill, x + (image.getWidth(null) / 2), y - 45);
        Util.drawCentered(g, "Likability: " + likability, x + (image.getWidth(null) / 2), y - 30);
        if (role != Type.MENTOR) Util.drawCentered(g, "Years in FRC: " + yearsInFRC, x + (image.getWidth(null) / 2), y - 15);
    }
    
    public static Person generatePerson(Team team) {
        String name = "Bob";
        //TODO random name
        Person p = new Person(name, team);
        if (Util.randomInt(1, 3) == 1) {
            switch (Util.randomInt(1, 4)) {
                case 1:
                    p.preferredRole = Type.PROGRAMMING;
                    break;
                case 2:
                    p.preferredRole = Type.MECHANICAL;
                    break;
                case 3:
                    p.preferredRole = Type.ELECTRICAL;
                    break;
                case 4:
                    p.preferredRole = Type.PR;
                    break;
            }
        }
        if (Util.randomInt(1, 20) == 1) { //The chance of making a GENIUS          
            p.skill = ((double)Util.randomInt(15, 20)) / 10; //Geniuses are very skilled
            p.likability = ((double)Util.randomInt(0, 10)) / 10; //Geniuses may not be very likable
        } else {
            p.skill = ((double)Util.randomInt(8, 13)) / 10;
            p.likability = ((double)Util.randomInt(7, 15)) / 10;
        }
        p.yearsInFRC = Util.randomInt(1, 5);
        if (p.yearsInFRC == 5) {
            p.role = Type.MENTOR;
            p.preferredRole = Type.MENTOR;
        }
        return p;
    }
}
