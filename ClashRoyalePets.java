import java.util.Random;
import java.util.Scanner;

public class ClashRoyalePets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] pets = {"Dart Goblin", "Hog Rider", "Beserker", "Evo P.E.K.K.A"};
        int[] probabilities = {50, 35, 14, 1};

        int rerolls = 3;
        String pet = "";

        System.out.println("Welcome to Clash Royale Pets!");
        System.out.println("You will roll for a random pet. You have up to 3 rerolls.");

        do {
            pet = rollPet(random, pets, probabilities);
            System.out.println("You rolled: " + pet);

            if (rerolls > 0) {

                String response = "";
                
                // --- INPUT VALIDATION LOOP ---
                while (true) {
                    System.out.print("Do you want to reroll? (yes/no): ");
                    response = scanner.nextLine().toLowerCase();

                    if (response.equals("yes") || response.equals("no")) {
                        break; // input is valid
                    }

                    System.out.println("Please enter ONLY 'yes' or 'no'.");
                }
                // --------------------------------

                if (response.equals("no")) {
                    break;
                }

                rerolls--;

            } else {
                System.out.println("No rerolls left.");
                break;
            }

        } while (true);

        System.out.println("Your final pet is: " + pet);
    }

    private static String rollPet(Random random, String[] pets, int[] probabilities) {
        int roll = random.nextInt(100) + 1;
        int cumulative = 0;

        for (int i = 0; i < pets.length; i++) {
            cumulative += probabilities[i];
            if (roll <= cumulative) {
                return pets[i];
            }
        }
        return "";
    }
}
