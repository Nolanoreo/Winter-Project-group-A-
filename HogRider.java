import java.lang.Thread;

/**
 * Represents a Hog Rider character with attributes such as name, damage,
 * health, and happiness. This character can perform actions like attacking,
 * moving, resting, and doing nothing. Certain actions modify the character's
 * health and happiness, and extremely low happiness can result in death.
 */
public class HogRider implements Character {

    /** Time delay in milliseconds for simulating action pauses. */
    private int time = 1500;

    /** The name of the Hog Rider. */
    private String name;

    /** The damage dealt by the Hog Rider when attacking. */
    private int damage;

    /** The current health of the Hog Rider. */
    private int health;

    /** The current happiness level of the Hog Rider. */
    private int happiness;

    /**
     * Constructs a new Hog Rider with a specified name and default stats.
     *
     * @param name the name of the Hog Rider
     */
    public HogRider(String name) {
        this.name = name;
        this.damage = 67;
        this.health = 120;
        this.happiness = 60;
    }

    /**
     * Displays detailed information about the Hog Rider,
     * including name, damage, health, and happiness.
     */
    @Override
    public void displayInfo() {
        delay();
        System.out.println("\n--- HogRider Info ---");
        System.out.println("Name: " + name);
        System.out.println("Damage: " + damage);
        delay();
        System.out.println("Health: " + health);
        System.out.println("Happiness: " + happiness);
        delay();
    }

    /**
     * Performs an attack action, showing a message and updating stats.
     * The Hog Rider takes self-inflicted damage and gains happiness.
     */
    @Override
    public void attack() {
        delay();
        System.out.println(name + " charges forward with his big hog, dealing " + damage + " damage!");
        System.out.println("HogRider got hurt from the charge and loses 30 health...");
        delay();
        this.health -= 30;
        this.happiness += 10;
        checkHappiness();
    }

    /**
     * Performs a movement action. Movement causes the Hog Rider to fall and lose health,
     * but increases happiness.
     */
    @Override
    public void move() {
        delay();
        System.out.println(name + " is riding around on his hog!");
        System.out.println("The hog slipped and the rider fell off...");
        delay();
        this.health -= 15;
        this.happiness += 15;
        checkHappiness();
    }

    /**
     * Allows the Hog Rider to rest, restoring health.
     */
    @Override
    public void rest() {
        System.out.println(name + " is resting to regain health.");
        delay();
        this.health += 20;
        checkHappiness();
    }

    /**
     * Performs no action. Happiness decreases due to boredom.
     */
    @Override
    public void doNothing() {
        System.out.println(name + " is doing nothing right now.");
        System.out.println("The Hog Rider is getting bored...");
        delay();
        this.happiness -= 10;
        checkHappiness();
    }

    /**
     * Retrieves the current health of the Hog Rider.
     *
     * @return the health value
     */
    @Override
    public int getHealth() {
        return health;
    }

    /**
     * Retrieves the name of the Hog Rider.
     *
     * @return the character's name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Checks the happiness level and sets health to zero if happiness
     * drops below zero, resulting in the character's death.
     */
    private void checkHappiness() {
        if (this.happiness < 0) {
            this.health = 0;
            System.out.println(name + " has become too unhappy and has died!");
        }
    }

    /**
     * Pauses execution for a short period to simulate real-time action delays.
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
