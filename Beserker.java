public class Beserker implements Character {
    private int time = 1500;
    private String name;
    private int damage;
    private int health;
    private int happiness;

    // Constructor to initialize the Beserker
    public Beserker(String name) {
        this.name = name;
        this.damage = 90;
        this.health = 200;
        this.happiness = 100;
    }

    @Override
    public void displayInfo() {
        System.out.println("\n--- Beserker Info ---");
        System.out.println("Name: " + name);
        System.out.println("Damage: " + damage);
        delay();
        System.out.println("Health: " + health);
        System.out.println("Happiness: " + happiness);
        delay();
    }

    @Override
    public void attack() {
        System.out.println(name + " unleashes a furious attack, dealing " + damage + " damage!");
        delay();
        System.out.println(name + " loses 15 health due to the reckless attack.");
        this.health -= 15;
        this.happiness += 10;
        checkHappiness();
    }

    @Override
    public void move() {
        System.out.println(name + " charges forward with unstoppable rage!");
        delay();
        System.out.println(name + " stumbles slightly, losing 20 health.");
        this.health -= 20;
        this.happiness += 15;
        checkHappiness();
    }

    @Override
    public void rest() {
        System.out.println(name + " is meditating to regain health.");
        delay();
        System.out.println(name + " regains 25 health.");
        this.health += 25;
        checkHappiness();
    }

    @Override
    public void doNothing() {
        System.out.println(name + " is standing still, trying to calm the rage.");
        delay();
        System.out.println(name + " feels restless and loses happiness.");
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
            System.out.println(name + " has succumbed to despair and has died!");
        }
    }

    // Method to introduce a delay
    private void delay() {
        try {
            Thread.sleep(time); // Delay for the specified time (1500 ms = 1.5 seconds)
        } catch (InterruptedException e) {
            System.err.println("Delay interrupted: " + e.getMessage());
        }
    }
}
