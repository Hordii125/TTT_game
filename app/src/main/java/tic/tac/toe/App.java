package tic.tac.toe;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TTTclass game = new TTTclass();
        MakeMove makeMove = new MakeMove(game, game.number); // Initialize MakeMove with the game instance
        WinTie winTie = new WinTie(game, makeMove); 
        SmartHint smartHint = new SmartHint(game);
        Statistic statistic = new Statistic(winTie); // Assuming Statistic is a class that handles game statistics
        ResultWriter resultWriter = new ResultWriter("results.txt", statistic); // Assuming this is the correct class name
        Display display = new Display(game); // Assuming Display is a class that handles board display
        Scanner input = new Scanner(System.in);
        String lastPlayerWon = statistic.getLastPlayerWin(); // Get the last player who won
        String currentPlayer = "x"; // to satrt with x 
        boolean keepPlaying = true; 
        

        System.out.println("\n\n\n");
        System.out.println("        Welcome to Tic Tac Toe!");
        System.out.println("         Player vs Player Mode");

        // Game loop
        while (keepPlaying) {
            winTie.resetResult(); // Reset the win/tie result for a new game
            game.resetBoard(); // Reset the board for a new game
            makeMove.resetAmountOfFilledCells(); // Reset the filled cells count
            while (!winTie.winTie()) {
                System.out.println("\n\tCurrent Player: " + currentPlayer);
                System.out.println("\n\tCurrent Board:");
                System.out.println(display.DisplayBoard(game.number));
                System.out.println(smartHint.smartHint());
                System.out.print("\n\tPlayer '" + currentPlayer + "', enter a value from 1 to 9: ");

                String raw = input.next();
                try {
                    int move = Integer.parseInt(raw); // convert input to integer
                    if (!makeMove.makeMove(currentPlayer, move)) {
                        System.out.println("\n\tInvalid move. Try again!");
                        continue;
                    }
                    
                    currentPlayer = currentPlayer.equals("x") ? "o" : "x"; // Switch player

                } catch (NumberFormatException e) {
                    System.out.println("\n\tPlease enter a valid number!");
                }
                
            }
                statistic.resultCheckForCounters();
                statistic.getLastPlayerWon(); // Update the last player who won
                statistic.showStatistic(); // Show statistics after each round
                lastPlayerWon = statistic.getLastPlayerWon(); // Update the last player who won 
            
            currentPlayer = lastPlayerWon.equals("x") ? "o" : "x";
            System.out.println(display.DisplayBoard(game.number)); // Display the final board state

            System.out.println("\n\tDo you want to continue playing? (yes/no)");
            boolean validResponse = false;
            while(!validResponse) {
                String response = input.next();
                if (response.equalsIgnoreCase("yes")) {
                    keepPlaying = true;
                    validResponse = true;
                } else if (response.equalsIgnoreCase("no")) {
                    keepPlaying = false;
                    validResponse = true;
                } else {
                    System.out.println("\n\tInvalid response. Please enter 'yes' or 'no'.");
                }
            }

        }
        input.close(); // Close the scanner
        resultWriter.writeResult(); // Write results to file
        System.out.println("\n\tGame Over! Here are the final statistics:");
        statistic.showStatistic(); // Show statistics
        System.out.println("\n\tThank you for playing Tic Tac Toe!");
        System.out.println("\tGoodbye!");
    }
}
