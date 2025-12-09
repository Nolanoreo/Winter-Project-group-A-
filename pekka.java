public class pekka implements Character {
    private int time = 1500;
    private String name;
    private int damage;
    private int health;
    private int happiness;

    // Constructor to initialize the Pekka
    public pekka(String name) {
        this.name = name;
        this.damage = 120;
        this.health = 250;
        this.happiness = 30;
    }

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

    @Override
    public void attack() {
        System.out.println(name + " swings its massive sword, dealing " + damage + " damage!");
        delay();
        System.out.println(name + " loses 20 health due to the heavy attack.");
        this.health -= 20;
        this.happiness += 10;
        checkHappiness();
    }

    @Override
    public void move() {
        System.out.println(name + " stomps forward with heavy steps!");
        delay();
        System.out.println(name + " loses 15 health due to the strain.");
        this.health -= 15;
        this.happiness += 5;
        checkHappiness();
    }

    @Override
    public void rest() {
        System.out.println(name + " powers down to regain energy.");
        delay();
        System.out.println(name + " regains 30 health.");
        this.health += 30;
        checkHappiness();
    }

    @Override
    public void doNothing() {
        System.out.println(name + " stands still, waiting for the next command.");
        delay();
        System.out.println(name + " feels bored and loses happiness.");
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
            System.out.println(name + " has become too unhappy and has shut down!");
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
