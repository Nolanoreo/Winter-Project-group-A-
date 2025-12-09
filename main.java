import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Updated pets and probabilities to include Pekka
        String[] pets = {"Dart Goblin 50%", "HogRider 35%", "Beserker 14%", "Pekka 1%"};
        int[] probabilities = {50, 35, 14, 1}; // Probabilities for each pet
        int rerolls = 3;
        String chosenPet = "";

        System.out.println("Welcome to the game!");
        System.out.println("You will roll for a random character. You have up to 3 rerolls.");

        // Rerolling system
        do {
            chosenPet = rollPet(random, pets, probabilities);
            System.out.println("You rolled: " + chosenPet);

            if (rerolls > 0) {
                String response = "";

                // Input validation loop
                while (true) {
                    System.out.print("Do you want to reroll? (yes/no): ");
                    response = scanner.nextLine().toLowerCase();

                    if (response.equals("yes") || response.equals("no")) {
                        break; // Valid input
                    }

                    System.out.println("Please enter ONLY 'yes' or 'no'.");
                }

                if (response.equals("no")) {
                    break; // User is satisfied with the pet
                }

                rerolls--; // Decrease reroll count
            } else {
                System.out.println("No rerolls left.");
                break;
            }
        } while (true);

        System.out.println("Your final character is: " + chosenPet);

        // Assign the chosen pet to the game
        Character character;
        switch (chosenPet) {
            case "Dart Goblin 50%":
                character = new DartGoblin("Sneaky Goblin");
                break;
            case "HogRider 35%":
                character = new HogRider("Fearless Rider");
                break;
            case "Beserker 14%":
                character = new Beserker("Raging Warrior");
                break;
            case "Pekka 1%":
                character = new pekka("Mighty Pekka");
                break;
            default:
                System.out.println("Error: Invalid pet selection.");
                scanner.close();
                return;
        }

        System.out.println("\nYou have chosen: " + character.getName());
        character.displayInfo();

        // Game loop for interacting with the pet
        while (character.getHealth() > 0) {
            System.out.println("\nWhat should your character do?");
            System.out.println("1. Attack");
            System.out.println("2. Move");
            System.out.println("3. Rest");
            System.out.println("4. Do Nothing");
            System.out.println("5. Exit Game");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline character

            switch (choice) {
                case 1:
                    character.attack();
                    break;
                case 2:
                    character.move();
                    break; 
                case 3:
                    character.rest();
                    break;
                case 4:
                    character.doNothing();
                    break;
                case 5:
                    System.out.println("Exiting the game. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            // Display updated character info
            character.displayInfo();

            // Check if the character has died
            if (character.getHealth() <= 0) {
                System.out.println("\n" + character.getName() + " has died. Game over!");
                break;
            }
        }

        scanner.close();
    }

    // Method to roll a pet based on probabilities
    private static String rollPet(Random random, String[] pets, int[] probabilities) {
        int roll = random.nextInt(100) + 1; // Random number between 1 and 100
        int cumulative = 0;

        for (int i = 0; i < pets.length; i++) {
            cumulative += probabilities[i];
            if (roll <= cumulative) {
                return pets[i];
            }
        }
        return ""; // Fallback (shouldn't happen if probabilities are correct)
    }
}