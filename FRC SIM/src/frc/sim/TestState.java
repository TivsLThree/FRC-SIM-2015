package frc.sim;

public class TestState extends State {
    
    public TestState() {
        entities.add(new Button(10, 10, "test.png", "test2.png") {
           @Override
           public void clicked() {
               System.out.println("Custom button is custom");
           }
        });
    }    
}
