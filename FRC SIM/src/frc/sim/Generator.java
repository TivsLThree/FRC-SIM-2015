package frc.sim;

import java.util.Random;

public class Generator {

    static String[] nouns = {"Labratory", "Bacon", "Bolt", "Volt", "Swamp",
        "Evolution", "Atom", "Robots", "Electricity", "Garage", "Pirate", "Pros"};
    static String[] adj = {"Energetic", "Exploding", "Black", "Flaming", "Fallicious",
        "Glorious", "Imaginary", "Octo", "Bizarre", "Six", "Automatic"};

    public static String genName() {
        String name = "";
        if (Math.random() > 0.5) {
            name = nouns[new Random().nextInt(nouns.length - 1)];
        } else {
            name = adj[new Random().nextInt(adj.length - 1)];
        }
        name = name + " " + nouns[new Random().nextInt(nouns.length - 1)];;
        return name;
    }
}