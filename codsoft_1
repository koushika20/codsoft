import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        String playAgain;

        do {
            totalScore += playGame(scanner, random);
            System.out.println("Your current score is: " + totalScore);
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next();
        } while (playAgain.equalsIgnoreCase("y"));

        System.out.println("Thank you for playing!");
        scanner.close();
    }

    private static int playGame(Scanner scanner, Random random) {
        int attempts = 10;
        int numberToGuess = random.nextInt(100) + 1;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");

        while (attempts > 0) {
            System.out.print("You have " + attempts + " attempts left. Enter your guess: ");
            int guess = scanner.nextInt();

            if (guess == numberToGuess) {
                System.out.println("Congratulations! You've guessed the number!");
                score++;
                break;
            } else if (guess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("Too low!");
            }

            attempts--;
        }

        if (attempts == 0) {
            System.out.println("Sorry! You've run out of attempts. The number was " + numberToGuess + ".");
        }

        return score;
    }
}
