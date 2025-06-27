package tic.tac.toe;

import java.util.Scanner;

public class TTTapp {
    public static void main(String[] args) {
        TTTclass game = new TTTclass();
        Scanner input = new Scanner(System.in);
        String currentPlayer = "x"; // to satrt with x 

        System.out.println("\n\n\n");
        System.out.println("        Welcome to Tic Tac Toe!");
        System.out.println("         Player vs Player Mode");

        // Game loop
        while (!game.winTie()) {
            System.out.println(game.display());
            System.out.println(game.smartHint());
            System.out.print("\n\tPlayer '" + currentPlayer + "', enter a value from 1 to 9: ");

            String raw = input.next();
            try {
                int move = Integer.parseInt(raw); // convert input to integer
                if (!game.makeMove(currentPlayer, move)) {
                    System.out.println("\n\tInvalid move. Try again.");
                    continue;
                }
                currentPlayer = currentPlayer.equals("x") ? "o" : "x"; // switch players
            } catch (NumberFormatException e) {
                System.out.println("\n\tPlease enter a valid number.");
            }
        }

        // Display last result
        System.out.println(game.display());
    }
}
