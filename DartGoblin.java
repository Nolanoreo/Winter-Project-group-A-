import java.lang.Thread;

public class DartGoblin {
    private int time = 1500;
    private String name;
    private int damage;
    private int health;
    private int happiness;

    // Constructor to initialize the DartGoblin with health
    public DartGoblin(String name) {
        this.name = name;
        this.damage = 50;
        this.health = 100;
        this.happiness = 50;
    }

    // Getter for health
    public void displayDartGoblinInfo() {
        System.out.println();
        delay();
        System.out.println("\n--- DartGoblin Info ---");
        System.out.println("DartGoblin Name: " + name);
        System.out.println("Damage: " + damage);
        delay(); 
        System.out.println("Health: " + health);
        System.out.println("Happiness: " + happiness);
        delay();
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getHappiness() {
        return happiness;
    }

   // Method to check if the DartGoblin dies due to low happiness
   private void checkHappiness() {
    if (this.happiness < 0) {
        this.health = 0; // Set health to 0 if happiness drops below 0
        System.out.println(name + " has become too unhappy and has died!");
    }
}

public void blowDart() {
    System.out.println(name + " blows a dart causing " + damage + " damage to the dummy!");
    delay(); // Add delay
    System.out.println(name + " lost 5 health while blowing the dart.");
    delay(); // Add delay
    System.out.println(name + " feels happy after hitting the target!");
    this.happiness += 5;
    this.health -= 5;
    checkHappiness(); // Check happiness after modifying it
}

public void runAround() {
    System.out.println(name + " is running around swiftly!");
    delay(); // Add delay
    System.out.println(name + " lost 10 health while running. He tripped on a rock :( ");
    delay(); // Add delay
    System.out.println(name + " feels excited after running around!");
    this.happiness += 10;
    this.health -= 10;
    checkHappiness(); // Check happiness after modifying it
}

public void sleep() {
    System.out.println(name + " is sleeping to regain health.");
    delay(); // Add delay
    System.out.println(name + " regained 15 health while sleeping.");
    this.health += 10;
    checkHappiness(); // Check happiness after modifying it
}

public void doNoting() {
    System.out.println(name + " is doing nothing right now.");
    delay(); // Add delay
    System.out.println(name + " feels bored.");
    this.happiness -= 10;
    checkHappiness(); // Check happiness after modifying it
}

// Method to introduce a delay
private void delay() {
    try {
        Thread.sleep(time); // Delay for the specified time (1000 ms = 1 second)
    } catch (InterruptedException e) {
        System.err.println("Delay interrupted: " + e.getMessage());
    }
}
}