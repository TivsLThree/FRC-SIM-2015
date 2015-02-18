package frc.sim;

import frc.sim.Main.Type;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.Timer;

public class BuildSeasonState extends State {

    public Day[] days = new Day[]{Day.SATURDAY, Day.SUNDAY, Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.THURSDAY, Day.FRIDAY};
    public Day day = Day.SATURDAY;
    public int week = 1;
    public Person selected = null;
    public Timer timer;
    public double teleCode = 0;
    public double autoCode = 0;
    public boolean pause = true;

    public BuildSeasonState() {
        int seperation = 130;
        int start = 10;
        timer = new Timer(2000, (ActionEvent e) -> {
            if (!pause) {
                int index = 0;
                for (Day d : days) {
                    if (day == d) {
                        break;
                    }
                    index++;
                }
                if ((index + 1) < days.length) {
                    daily();
                    day = days[index + 1];
                } else {
                    week++;
                    if (week != 6) {
                        day = Day.SATURDAY;
                    } else {
                        //TODO go to CompetitionState
                    }
                }
            }
        });

        timer.start();

        entities.add(new Button(start, 50, "buttons/button-3.png") {
            @Override
            public void clicked(MouseEvent m) {
                if (selected != null && selected.role != Type.MENTOR) {
                    selected.role = Type.PROGRAMMING;
                }
            }

            @Override
            public void tick() {
                super.tick();
                if (selected == null) {
                    visible = false;
                } else {
                    visible = true;
                }
            }
        });
        entities.add(new Button(start + seperation, 50, "buttons/mechanical.png") {
            @Override
            public void clicked(MouseEvent m) {
                if (selected != null && selected.role != Type.MENTOR) {
                    selected.role = Type.MECHANICAL;
                }
            }

            @Override
            public void tick() {
                super.tick();
                if (selected == null) {
                    visible = false;
                } else {
                    visible = true;
                }
            }
        });
        entities.add(new Button(start + (seperation * 2), 50, "buttons/electrical.png") {
            @Override
            public void clicked(MouseEvent m) {
                if (selected != null && selected.role != Type.MENTOR) {
                    selected.role = Type.ELECTRICAL;
                }
            }

            @Override
            public void tick() {
                super.tick();
                if (selected == null) {
                    visible = false;
                } else {
                    visible = true;
                }
            }
        });
        entities.add(new Button(start + (seperation * 3), 50, "buttons/pr.png") {
            @Override
            public void clicked(MouseEvent m) {
                if (selected != null && selected.role != Type.MENTOR) {
                    selected.role = Type.PR;
                }
            }

            @Override
            public void tick() {
                super.tick();
                if (selected == null) {
                    visible = false;
                } else {
                    visible = true;
                }
            }
        });
        entities.add(new Button(650, 10, "buttons/unpause.png") {

            @Override
            public void clicked(MouseEvent m) {
                pause = false;

            }

            @Override
            public void tick() {
                super.tick();
                visible = pause;

            }
        });
        entities.add(new Button(650, 50, "buttons/pause.png") {

            @Override
            public void clicked(MouseEvent m) {
                pause = true;

            }

            @Override
            public void tick() {
                super.tick();
                visible = !pause;
            }
        });
        entities.add(new Button(200, 500, "buttons/button-3.png") {
            @Override
            public void clicked(MouseEvent m) {
                if (selected != null) {
                    selected.project = 1;
                }

            }

            @Override
            public void tick() {
                super.tick();
                visible = selected != null && selected.role == Type.PROGRAMMING;
            }
        });
        entities.add(new Button(400, 500, "buttons/button-3.png") {
            @Override
            public void clicked(MouseEvent m) {
                if (selected != null) {
                    selected.project = 2;
                }

            }

            @Override
            public void tick() {
                super.tick();
                visible = selected != null && selected.role == Type.PROGRAMMING;
            }
        });
    }

    @Override

    public void draw(Graphics2D g) {
        super.draw(g);
        Color oldColor = g.getColor();
        g.drawString(day.toString() + ", Week " + week, 10, 20);
        for (Person p : Main.team.members) {
            p.draw(g);
            p.tick();
        }
        drawMemberStats(g);
        drawCode(g, oldColor);
        drawTeamStats(g);
        if (selected != null) {
            Rectangle r = selected.box();

            g.setColor(Color.GREEN);

            g.drawRect(r.x, r.y, r.width, r.height);
            g.setColor(oldColor);
        }
    }

    @Override
    public void clicked(MouseEvent m) {
        Point point = Board.self.getLocationOnScreen();
        int mouseX = m.getXOnScreen() - point.x;
        int mouseY = m.getYOnScreen() - point.y;
        for (Person p : Main.team.members) {
            if (p.box().contains(mouseX, mouseY)) {
                System.out.println("Selected a dude");
                selected = p;

                return;
            }
        }
    }

    public enum Day {

        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY;
    }

    public void daily() {
        doCode();
        System.out.println(teleCode);
    }

    public void drawTeamStats(Graphics2D g) {
        g.drawString("Programmers: " + countMembers(Type.PROGRAMMING), Main.self.getWidth() - 125, Main.self.getHeight() - 130);
        g.drawString("Mechanics: " + countMembers(Type.MECHANICAL), Main.self.getWidth() - 125, Main.self.getHeight() - 145);
        g.drawString("Public Relations: " + countMembers(Type.PR), Main.self.getWidth() - 125, Main.self.getHeight() - 160);
        g.drawString("Mentors: " + countMembers(Type.MENTOR), Main.self.getWidth() - 125, Main.self.getHeight() - 185);
    }

    public void drawMemberStats(Graphics2D g) {

        if (selected != null) {
            g.drawString("Name: " + selected.name, Main.self.getWidth() - 150, Main.self.getHeight() - 115);
            g.drawString("Likability: " + selected.likability, Main.self.getWidth() - 150, Main.self.getHeight() - 100);
            g.drawString("Skill: " + selected.skill, Main.self.getWidth() - 150, Main.self.getHeight() - 85);
            g.drawString("Preferred Role: " + selected.preferredRole, Main.self.getWidth() - 150, Main.self.getHeight() - 70);
            g.drawString("Role: " + selected.role, Main.self.getWidth() - 150, Main.self.getHeight() - 55);

        }
    }

    public void drawCode(Graphics2D g, Color oldColor) {

        g.setColor(Color.getHSBColor(200, 100, 100));
        g.fillRect(1, Main.self.getHeight() - 50, (int) teleCode * 3, 10);
        g.setColor(Color.RED);
        g.fillRect(1, Main.self.getHeight() - 75, (int) autoCode * 3, 10);
        g.setColor(oldColor);
    }

    public void doCode() {
        for (Person p : Main.team.members) {
            if (p.role == Type.PROGRAMMING && p.project == 1) {
                teleCode += (p.preferredRole != Type.PROGRAMMING && p.preferredRole != Type.NONE) ? (1 * p.skill * 0.9) : (1 * p.skill);
            } else if (p.role == Type.PROGRAMMING && p.project == 2) {
                autoCode += (p.preferredRole != Type.PROGRAMMING && p.preferredRole != Type.NONE) ? (1 * p.skill * 0.9) : (1 * p.skill);
            }
        }
    }

    public int countMembers(Type type) {
        int members = 0;
        for (Person p : Main.team.members) {
            if (p.role == type) {
                members++;
            }
        }
        return members;
    }
}
