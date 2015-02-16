package frc.sim;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CreateTeamState extends State {
    
    public Team t;
    
    public CreateTeamState() {
        int number = Integer.parseInt(JOptionPane.showInputDialog(null, "Please type your team's number."));
        String name = JOptionPane.showInputDialog(null, "Please type your team's name.");
        String[] colorString = JOptionPane.showInputDialog(null, "Please put your team color's RGB values like so: 'red green blue'").split(" ");
        Color color = new Color(Integer.parseInt(colorString[0]), Integer.parseInt(colorString[1]), Integer.parseInt(colorString[2]));
        setupTeam(name, number, color);
        entities.add(new Button(200, 400, "buttons/redo.png") {
            @Override
            public void clicked(MouseEvent m) {
                setupTeam(name, number, color);
            }
        });
        
        entities.add(new Button(600 - 64, 400, "buttons/confirm.png") {            
            @Override
            public void clicked(MouseEvent m) {
                Main.team = t;
                Board.state = new BuildSeasonState();
            }
        });
    }
    
    public void setupTeam(String name, int number, Color color) {
        t = new Team(name, number, color);
        List<Person> people = new ArrayList<>();
        for (int y=1; y < 3; y++) { //1 and 2
            for (int x=1; x < 7; x++ ) {
                Person p = Person.generatePerson(t);
                p.x = x * 120;
                p.y = y * 120;
                people.add(p);
            }
        }
        t.members = people;
    }
    
    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        for (Person p : t.members) {
            p.drawWithData(g);
        }
    }
}
