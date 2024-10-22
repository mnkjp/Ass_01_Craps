import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean playAgain;

        do {
            playAgain = playGame();
        } while (playAgain);

        System.out.println("Thank you for playing!");
    }

    private static boolean playGame() {
        int sum = rollDice();
        System.out.println("You rolled: " + sum);

        if (sum == 2 || sum == 3 || sum == 12) {
            System.out.println("Craps! You crapped out.");
            return askToPlayAgain();
        } else if (sum == 7 || sum == 11) {
            System.out.println("Natural! You win!");
            return askToPlayAgain();
        } else {
            System.out.println("The point is: " + sum);
            return continuePlaying(sum);
        }
    }

    private static int rollDice() {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        int sum = die1 + die2;

        System.out.println("Die 1: " + die1 + ", Die 2: " + die2 + ", Sum: " + sum);
        return sum;
    }

    private static boolean continuePlaying(int point) {
        while (true) {
            int sum = rollDice();
            System.out.println("Trying for point...");

            if (sum == point) {
                System.out.println("Made point! You win!");
                return askToPlayAgain();
            } else if (sum == 7) {
                System.out.println("Got a seven! You lose.");
                return askToPlayAgain();
            }
        }
    }

    private static boolean askToPlayAgain() {
        System.out.print("Do you want to play again? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();

        return response.equals("yes");
    }
}