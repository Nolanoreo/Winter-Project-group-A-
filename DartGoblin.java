import java.lang.Thread;

public class DartGoblin implements Character {
    private int time = 1500;
    private String name;
    private int damage;
    private int health;
    private int happiness;

    public DartGoblin(String name) {
        this.name = name;
        this.damage = 50;
        this.health = 100;
        this.happiness = 50;
    }

    @Override
    public void displayInfo() {
        System.out.println("\n--- DartGoblin Info ---");
        System.out.println("Name: " + name);
        System.out.println("Damage: " + damage);
        delay();
        System.out.println("Health: " + health);
        System.out.println("Happiness: " + happiness);
        delay();
    }

    @Override
    public void attack() {
        System.out.println(name + " blows a dart causing " + damage + " damage to the target dummy!");
        System.out.println("the attack took some energy...");
        delay();
        this.health -= 20;
        this.happiness += 5;
        checkHappiness();
    }

    @Override
    public void move() {
        System.out.println(name + " is running around swiftly!");
        System.out.println("the dart goblin triped on a pebble and hurt himself...");
        delay();
        this.health -= 15;
        this.happiness += 10;
        checkHappiness();
    }

    @Override
    public void rest() {
        System.out.println(name + " is sleeping to regain health.");
        delay();
        this.health += 15;
        checkHappiness();
    }

    @Override
    public void doNothing() {
        System.out.println(name + " is doing nothing right now.");
        System.out.println("the dart goblin is getting bored...");
        delay();
        this.happiness -= 10;
        checkHappiness();
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public String getName() {
        return name;
    }

    private void checkHappiness() {
        if (this.happiness < 0) {
            this.health = 0;
            System.out.println(name + " has become too unhappy and has died!");
        }
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