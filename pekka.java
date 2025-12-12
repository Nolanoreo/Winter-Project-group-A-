/**
 * Represents a Pekka character, a heavily armored warrior with high damage
 * and high health. The Pekka can attack, move, rest, or do nothing. Each action
 * affects health and happiness differently. If happiness drops below zero,
 * the Pekka shuts down.
 */
public class pekka implements Character {

    /** Time delay in milliseconds to simulate action pacing. */
    private int time = 1500;

    /** The name of the Pekka. */
    private String name;

    /** The damage dealt by the Pekka during an attack. */
    private int damage;

    /** The current health of the Pekka. */
    private int health;

    /** The current happiness level of the Pekka. */
    private int happiness;

    /**
     * Constructs a new Pekka with a given name and default attributes.
     *
     * @param name the name of the Pekka
     */
    public pekka(String name) {
        this.name = name;
        this.damage = 120;
        this.health = 250;
        this.happiness = 30;
    }

    /**
     * Displays information about the Pekka, including name, damage,
     * health, and happiness.
     */
    @Override
    public void displayInfo() {
        System.out.println("\n--- Pekka Info ---");
        System.out.println("Name: " + name);
        System.out.println("Damage: " + damage);
        delay();
        System.out.println("Health: " + health);
        System.out.println("Happiness: " + happiness);
        delay();
    }

    /**
     * Performs an attack using the Pekka's massive sword.
     * The Pekka deals heavy damage but loses health due to the effort.
     */
    @Override
    public void attack() {
        System.out.println(name + " swings its massive sword, dealing " + damage + " damage!");
        delay();
        System.out.println(name + " loses 50 health due to the heavy attack.");
        this.health -= 50;
        this.happiness += 10;
        checkHappiness();
    }

    /**
     * Moves the Pekka forward. Movement causes strain on its armor,
     * lowering health but slightly increasing happiness.
     */
    @Override
    public void move() {
        System.out.println(name + " stomps forward with heavy steps!");
        delay();
        System.out.println(name + " loses 35 health due to the strain.");
        this.health -= 35;
        this.happiness += 5;
        checkHappiness();
    }

    /**
     * Allows the Pekka to rest and power down to regain energy.
     */
    @Override
    public void rest() {
        System.out.println(name + " powers down to regain energy.");
        delay();
        System.out.println(name + " regains 50 health.");
        this.health += 50;
        checkHappiness();
    }

    /**
     * Performs no action. The Pekka becomes bored and loses happiness.
     */
    @Override
    public void doNothing() {
        System.out.println(name + " stands still, waiting for the next command.");
        delay();
        System.out.println(name + " feels bored and loses happiness.");
        this.happiness -= 10;
        checkHappiness();
    }

    /**
     * Retrieves the current health of the Pekka.
     *
     * @return the current health value
     */
    @Override
    public int getHealth() {
        return health;
    }

    /**
     * Retrieves the name of the Pekka.
     *
     * @return the Pekka's name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Checks the current happiness level. If happiness falls below zero,
     * the Pekka shuts down and health becomes zero.
     */
    private void checkHappiness() {
        if (this.happiness < 0) {
            this.health = 0;
            System.out.println(name + " has become too unhappy and has shut down!");
        }
    }

    /**
     * Introduces a timed delay to simulate real-time action pacing.
     * Logs an error message if the delay is interrupted.
     */
    private void delay() {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.err.println("Delay interrupted: " + e.getMessage());
        }
    }
}
