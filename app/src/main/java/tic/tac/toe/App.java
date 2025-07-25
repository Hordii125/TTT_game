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
        AIComputerMove aiComputerMove = new AIComputerMove(game, game.number, makeMove, smartHint); // Initialize AIComputerMove
        ChooseYourGameMode chooseYourGameMode = new ChooseYourGameMode(game, makeMove, winTie, smartHint, 
                                                                        statistic, resultWriter, display, aiComputerMove);
        Scanner input = new Scanner(System.in);

        boolean keepPlaying = true; // Variable to control the game loop

        // Game loop
        while (chooseYourGameMode.isKeepPlayingApp()) {
            winTie.resetResult(); // Reset the win/tie result for a new game
            game.resetBoard(); // Reset the board for a new game
            makeMove.resetAmountOfFilledCells(); // Reset the filled cells count
            chooseYourGameMode.chooseGameMode(); // Start the game mode selection
            System.out.println(display.DisplayBoard(game.number)); // Display the final board state
        }
        input.close(); // Close the scanner
        resultWriter.writeResult(); // Write results to file
        System.out.println("\n\tGame Over! Here are the final statistics:");
        statistic.showStatistic(); // Show statistics
        System.out.println("\n\tThank you for playing Tic Tac Toe!");
        System.out.println("\tGoodbye!");
    }
}
