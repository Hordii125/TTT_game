package tic.tac.toe;

import java.io.IOException;

public class TTTapp {
    public static void main(String[] args) throws IOException {
        TTTclass game = new TTTclass();
        System.out.println("\n\n\n");
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.printf("%50s\n\n\n", "Player vs Player Mode");

        // Display the initial game board
        game.display();

        // Variables to control the game loop
        String result = "";
        boolean finished = false;

        // Game loop for player vs player mode
        while (!finished) {
            game.smartHint();
            game.enterValuePlayer1();  // Player x
            game.display();
            finished = game.winTie();
            if (finished) break;
            game.smartHint();
            game.enterValuePlayer2();  // Player o
            game.display();
            finished = game.winTie();
        }
    }
}
