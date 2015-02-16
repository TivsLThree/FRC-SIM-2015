package frc.sim;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Team {
    
    public String name = "Those Guys Without A Name";
    public int number = 0;
    public Color color = new Color(0, 0, 0);
    public List<Person> members = new ArrayList<>();
    public int age = 0;
    public double popularity = 0;
    
    public Team(String name, int number, Color color) {
        this.name = name;
        this.number = number;
        this.color = color;
    }
    
    public double getSkill() {
        double skillSum = 0;
        for (Person p : members) {
            skillSum += p.skill;
        }
        return skillSum / members.size();
    }
    
    public static Team generateTeam() {
        int number = 1;
        do {
            number = Util.randomInt(10, 5000);
        } while (isNumberTaken(number));
        
        Team t = new Team(Generator.genName(), number, new Color(Util.randomInt(0, 255), Util.randomInt(0, 255),Util.randomInt(0, 255)));               
        List<Person> members = new ArrayList<>();
        for (int i=0; i < Util.randomInt(10, (int) 25); i++) {
            members.add(Person.generatePerson(t));
        }   
        
        t.popularity = Util.randomInt(-5, 15) / 10;
        t.members = members;       
        t.age = Util.randomInt(0, 10); 
        return t;
    }
    
    public static boolean isNumberTaken(int i) {
        for (Team t : Main.teams) {
            if (t.number == i) {
                return true;
            }
        }
        return false;
    }
}

