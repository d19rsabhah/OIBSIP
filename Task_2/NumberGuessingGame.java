import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static int generatedNumber;
    private static int attempts;
    private static final int MAX_ATTEMPTS = 5;
    private static int score;
    private static int rounds;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("\nWelcome to the Number Guessing Game!");

        do {
            generatedNumber = random.nextInt(100) + 1;
            attempts = 0;
            System.out.println("You can try for 5 times in each round !");
            System.out.println("\nRound " + (rounds + 1));
            System.out.println("Guess the number between 1 and 100.");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");

                try {
                    int userGuess = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character

                    if (userGuess < 1 || userGuess > 100) {
                        System.out.println("Your entered number is out of range!");
                        continue;
                    }

                    attempts++;

                    if (userGuess == generatedNumber) {
                        System.out.println("Congratulations! You guessed the number!");
                        score += MAX_ATTEMPTS - attempts + 1;
                        System.out.println("Score: " + score);
                        break;
                    } else if (userGuess < generatedNumber) {
                        System.out.println("Too low! Try a higher number.");
                    } else {
                        System.out.println("Too high! Try a lower number.");
                    }
                } catch (java.util.InputMismatchException ex) {
                    System.out.println("Please enter a valid number!");
                    scanner.nextLine();  // Clear the invalid input
                }
            }

            if (attempts >= MAX_ATTEMPTS) {
                System.out.println("Out of attempts. The number was: " + generatedNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();

            if (playAgain.equals("yes")) {
                rounds++;
            } else {
                break;
            }

        } while (true);

        System.out.println("Thanks for playing! Your final score: " + score);
        scanner.close();
    }
}
