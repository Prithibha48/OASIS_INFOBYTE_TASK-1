package Number_Game;


import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 50;
        int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int maxAttempts = 5;
        int attempts = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess the number between " + lowerBound + " and " + upperBound);

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == targetNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                score += maxAttempts - attempts + 1;
                System.out.println("Your score: " + score);

                System.out.print("Do you want to play again? (yes/no): ");
                String playAgain = scanner.next().toLowerCase();
                if (playAgain.equals("yes")) {
                    targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
                    attempts = 0;
                    System.out.println("New game started. Guess the number between " + lowerBound + " and " + upperBound);
                } else {
                    System.out.println("Thanks for playing. Goodbye!");
                    break;
                }
            } else {
                String hint = (userGuess < targetNumber) ? "Higher" : "Lower";
                System.out.println("Incorrect! Try again. Hint: " + hint);
            }
        }

        if (attempts == maxAttempts) {
            System.out.println("Sorry, you've reached the maximum attempts. The correct number was: " + targetNumber);
        }

        scanner.close();
    }
}
