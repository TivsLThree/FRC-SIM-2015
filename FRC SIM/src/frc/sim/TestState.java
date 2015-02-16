package frc.sim;

import java.awt.Graphics2D;

public class TestState extends State {
    
    public Team testTeam;
    
    public TestState() {
        entities.add(new Button(10, 10, "test.png", "test2.png") {
           @Override
           public void clicked() {
               System.out.println("Custom button is custom");
           }
        });
        testTeam = Team.generateTeam();
        Main.teams.add(testTeam);
    }
    
    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        for (Person p : testTeam.members) {
            p.draw(g);
        }
    }
}
