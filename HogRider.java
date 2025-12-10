import java.lang.Thread;

public class HogRider implements Character {
    private int time = 1500;
    private String name;
    private int damage;
    private int health;
    private int happiness;

    public HogRider(String name) {
        this.name = name;
        this.damage = 67;
        this.health = 120;
        this.happiness = 60;
    }

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

    @Override
    public void move() {
        delay();
        System.out.println(name + " is riding around on his hog!");
        System.out.println("the hog slipped and the rider fell off...");
        delay();
        this.health -= 15;
        this.happiness += 15;
        checkHappiness();
    }

    @Override
    public void rest() {
        System.out.println(name + " is resting to regain health.");
        delay();
        this.health += 20;
        checkHappiness();
    }

    @Override
    public void doNothing() {
        System.out.println(name + " is doing nothing right now.");
        System.out.println("the hog rider is getting bored...");
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

    private void delay() {
        try {
            Thread.sleep(time); // Delay for the specified time (1000 ms = 1 second)
        } catch (InterruptedException e) {
            System.err.println("Delay interrupted: " + e.getMessage());
        }
    }
}