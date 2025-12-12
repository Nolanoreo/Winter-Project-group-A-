import java.lang.Thread;

/**
 * Represents a Dart Goblin character with moderate damage, low health,
 * and agile behavior. The Dart Goblin can attack, move, rest, or do nothing.
 * These actions modify the goblin's health and happiness, and if happiness
 * drops below zero, the character dies.
 */
public class DartGoblin implements Character {

    /** Time delay in milliseconds to simulate action pacing. */
    private int time = 1500;

    /** The name of the Dart Goblin. */
    private String name;

    /** The damage dealt by the Dart Goblin when attacking. */
    private int damage;

    /** The current health of the Dart Goblin. */
    private int health;

    /** The current happiness level of the Dart Goblin. */
    private int happiness;

    /**
     * Constructs a new Dart Goblin with a specified name and default attributes.
     *
     * @param name the name of the Dart Goblin
     */
    public DartGoblin(String name) {
        this.name = name;
        this.damage = 50;
        this.health = 100;
        this.happiness = 50;
    }

    /**
     * Displays information about the Dart Goblin, including name, damage,
     * health, and happiness.
     */
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

    /**
     * Performs an attack by blowing a dart. The Dart Goblin deals damage
     * but loses some health due to exertion. Happiness increases slightly.
     */
    @Override
    public void attack() {
        System.out.println(name + " blows a dart causing " + damage + " damage to the target dummy!");
        System.out.println("The attack took some energy...");
        delay();
        this.health -= 20;
        this.happiness += 5;
        checkHappiness();
    }

    /**
     * Moves the Dart Goblin swiftly. Movement can cause injury if the goblin trips,
     * but happiness increases due to activity.
     */
    @Override
    public void move() {
        System.out.println(name + " is running around swiftly!");
        System.out.println("The Dart Goblin tripped on a pebble and hurt himself...");
        delay();
        this.health -= 15;
        this.happiness += 10;
        checkHappiness();
    }

    /**
     * Allows the Dart Goblin to rest, regaining a small amount of health.
     */
    @Override
    public void rest() {
        System.out.println(name + " is sleeping to regain health.");
        delay();
        this.health += 15;
        checkHappiness();
    }

    /**
     * Performs no action. Happiness decreases due to boredom.
     */
    @Override
    public void doNothing() {
        System.out.println(name + " is doing nothing right now.");
        System.out.println("The Dart Goblin is getting bored...");
        delay();
        this.happiness -= 10;
        checkHappiness();
    }

    /**
     * Retrieves the current health of the Dart Goblin.
     *
     * @return the goblin's health
     */
    @Override
    public int getHealth() {
        return health;
    }

    /**
     * Retrieves the name of the Dart Goblin.
     *
     * @return the goblin's name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Checks the happiness level and determines whether the Dart Goblin
     * should die due to extreme unhappiness.
     */
    private void checkHappiness() {
        if (this.happiness < 0) {
            this.health = 0;
            System.out.println(name + " has become too unhappy and has died!");
        }
    }

    /**
     * Introduces a timed delay to simulate real-time action pacing.
     * Prints an error message if the delay is interrupted.
     */
    private void delay() {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.err.println("Delay interrupted: " + e.getMessage());
        }
    }
}
