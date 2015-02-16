package frc.sim;

import java.util.Random;

public class Generator {

    static String[] nouns = {"Labratory", "Bacon", "Bolt", "Volt", "Swamp",
        "Evolution", "Atom", "Robots", "Electricity", "Garage", "Pirate", "Pros"};
    static String[] adj = {"Energetic", "Exploding", "Black", "Flaming", "Fallicious",
        "Glorious", "Imaginary", "Octo", "Bizarre", "Six", "Automatic"};

    public static String genTeamName() {
        String name = "";
        if (Math.random() > 0.5) {
            name = nouns[new Random().nextInt(nouns.length - 1)];
        } else {
            name = adj[new Random().nextInt(adj.length - 1)];
        }
        name = name + " " + nouns[new Random().nextInt(nouns.length - 1)];
        System.out.println(genName());
        return name;
    }
    static String[] first = {"Taylor", "Jacob", "Levi", "Ryan", "Kevin", "Garry", "Bob",
        "Felicia", "Jonathon", "Michael", "Robert", "Sean", "Spencer", "David", "Richard",
        "Brian", "George", "Nathan", "Henry", "Adolf", "Larry", "Morris", "Marry", "Jordan",
        "Dean"

    };
    static String[] last = {"Taylor", "Shavell", "Hitler", "Smalls", "Little", "Jordan", "Adams",
        "Ryce", "Abel", "Stoff", "Fisher", "Smith", "Doe", "Whitten", "Parsons", "Ali", "Marceli",
        "Pollack", "Williams", "Johnston", "Williamson", "Parker", "Spencer", "Kamen", "Nickson",
        "Bisque", "Levy", "Mikel", "Jarkerb"

    };

    public static String genName() {
        String name = "";
        name = first[new Random().nextInt(first.length - 1)];
        name = name + " " + last[new Random().nextInt(last.length - 1)];
        return name;
    }
}
