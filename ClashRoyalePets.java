import java.util.Random;
import java.util.Scanner;

public class ClashRoyalePets {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Pets and their chances
        String[] pets = {"Dart Goblin 50%", "Hog Rider 35%", "Beserker 14%", "Evo P.E.K.K.A 1%"};
        int[] chances = {50, 35, 14, 1};

        int rerolls = 3;
        String pet;

        System.out.println("Welcome to Clash Royale Pets!");
        System.out.println("Roll a random pet. You have 3 rerolls.");

        // --- REROLL LOOP ---
        while (true) {

            pet = getRandomPet(random, pets, chances);
            System.out.println("You rolled: " + pet);

            if (rerolls == 0) {
                System.out.println("No rerolls left.");
                break;
            }

            // Ask user if they want to reroll
            System.out.print("Reroll? (yes/no): ");
            String choice = scanner.nextLine().toLowerCase();

            while (!choice.equals("yes") && !choice.equals("no")) {
                System.out.print("Please type yes or no: ");
                choice = scanner.nextLine().toLowerCase();
            }

            if (choice.equals("no")) {
                break;   // They accept the pet
            }

            rerolls--;   // Use a reroll
        }

        System.out.println("Your final pet is: " + pet);
        scanner.close();
    }


    // --- RANDOM PET METHOD ---
    private static String getRandomPet(Random random, String[] pets, int[] chances) {

        int roll = random.nextInt(100) + 1;   // 1–100
        int sum = 0;

        for (int i = 0; i < pets.length; i++) {
            sum += chances[i];
            if (roll <= sum) {
                return pets[i];
            }
        }

        return "Error"; // Should never happen
    }
}
