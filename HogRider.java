public class HogRider {
    private int time = 1500;
    private String name;
    private int damage;
    private int health;
    private int happiness;

    // Constructor to initialize the HogRider
    public HogRider(String name) {
        this.name = name;
        this.damage = 67;
        this.health = 120;
        this.happiness = 60;
    }

    // Display HogRider info
    public void displayHogRiderInfo() {
        System.out.println();
        delay();
        System.out.println("\n--- HogRider Info ---");
        System.out.println("HogRider Name: " + name);
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

    // Method to check if the HogRider dies due to low happiness
    private void checkHappiness() {
        if (this.happiness < 0) {
            this.health = 0; // Set health to 0 if happiness drops below 0
            System.out.println(name + " has become too unhappy and has died!");
        }
    }

    public void chargeAttack() {
        System.out.println(name + " charges forward with his big hog, dealing " + damage + " damage to the dummy!");
        delay();
        System.out.println(name + " lost 10 health while charging.");
        delay();
        System.out.println(name + " feels happy after a successful attack!");
        this.happiness += 10;
        this.health -= 10;
        checkHappiness();
    }

    public void rideAround() {
        System.out.println(name + " is riding around on his hog!");
        delay();
        System.out.println(name + " lost 15 health while riding.");
        delay();
        System.out.println(name + " feels excited after riding around!");
        this.happiness += 15;
        this.health -= 15;
        checkHappiness();
    }

    public void rest() {
        System.out.println(name + " is resting to regain health.");
        delay();
        System.out.println(name + " regained 20 health while resting.");
        this.health += 20;
        checkHappiness();
    }

    public void doNothing() {
        System.out.println(name + " is doing nothing right now.");
        delay();
        System.out.println(name + " feels bored.");
        this.happiness -= 10;
        checkHappiness();
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