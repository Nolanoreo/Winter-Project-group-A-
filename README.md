# Winter-Project-group-A-
import java.util.Scanner;
import java.util.Random;

/**
 * Mini Game Center
 * This program lets the user pick from three mini-games:
 * 1) Calculator
 * 2) Password Guessing Game
 * 3) Word Reverser
 * 
 * It demonstrates conditionals, loops, and string manipulation.
 * 
 * Author: Your Name
 * Date: October 2025
 */
public class Main {

    /**
     * Main method that runs the menu and controls the game center.
     * @param args not used
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice = 0;

        // Menu loop continues until the user chooses to quit
        while (choice != 4) {
            printMenu();

            System.out.print("Enter your choice: ");
            while (!scan.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number from 1 to 4.");
                scan.next(); // clear invalid input
            }

            choice = scan.nextInt();
            scan.nextLine(); // clear buffer

            if (choice == 1) {
                double result = calculator(scan);
                System.out.println("Result: " + result);
            } else if (choice == 2) {
                passwordGame(scan);
            } else if (choice == 3) {
                reverseWord(scan);
            } else if (choice == 4) {
                System.out.println("Thanks for playing the Mini Game Center!");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }

        scan.close();
    }

    /**
     * Prints the menu options.
     */
    public static void printMenu() {
        System.out.println("==== MINI GAME CENTER ====");
        System.out.println("1. Calculator");
        System.out.println("2. Password Guessing Game");
        System.out.println("3. Word Reverser");
        System.out.println("4. Quit");
        System.out.println("==========================");
    }