package tic.tac.toe;

import java.util.Scanner;

public class ChooseYourGameMode {
    private TTTclass game;
    private MakeMove makeMove;
    private WinTie winTie;
    private SmartHint smartHint;
    private Statistic statistic;
    private ResultWriter resultWriter;
    private Display display;
    private AIComputerMove aiComputerMove;
    private String currentPlayer;
    private String lastPlayerWon;

    boolean keepPlaying = true; // Control variable for the game loop

    boolean keepPlayingApp = true; // Control variable for the app loop
    

    Scanner input = new Scanner(System.in);

    public ChooseYourGameMode(TTTclass game, MakeMove makeMove, WinTie winTie, SmartHint smartHint, 
                              Statistic statistic, ResultWriter resultWriter, Display display, 
                              AIComputerMove aiComputerMove) {
        this.game = game;
        this.makeMove = makeMove;
        this.winTie = winTie;
        this.smartHint = smartHint;
        this.statistic = statistic;
        this.resultWriter = resultWriter;
        this.display = display;
        this.aiComputerMove = aiComputerMove;
        this.currentPlayer = "";
        this.lastPlayerWon = statistic.getLastPlayerWin(); // Get the last player who won
    }

    public void chooseGameMode() {
        System.out.println("\n\n\n");
        System.out.println("        Welcome to Tic Tac Toe!");
        System.out.println("         Choose your game mode:");
        System.out.println("         1. Player vs AI");
        System.out.println("         2. Player vs Player");
        System.out.println("         3. AI vs Player");
        System.out.println("         4. Exit the game");

        System.out.print("         Please select an option (1-4): ");
        
        int choice = input.nextInt();
        
        switch (choice) {
            case 1:
                // Player vs AI mode
                System.out.println("\n\tYou chose Player vs AI mode.");
                resetGame(); // Reset the game state before starting a new game

                // Reset keepPlaying to true for the game loop
                resetKeepPlaying();
                
                // Set the current player to "x" for the player
                setCurrentPlayer("x");
                
            while (keepPlaying) {
                
                resetGame(); // Reset the game state before starting a new round
                System.out.println("\n\tStarting a new round and player with \"" + currentPlayer + "\" symbol will start first.");

                while (!winTie.winTie()) {
                    System.out.println("\n\t----------------------------------");
                    System.out.println(display.DisplayBoard(game.number));
                    System.out.println(smartHint.smartHint());

                    

                    if (currentPlayer.equals("x")) {
                        System.out.print("\n\tEnter your move (1-9): ");
                        // Player's turn
                        boolean validMove = false;
                        while (!validMove) {
                            String inputValue = input.next();
                            int move = Integer.parseInt(inputValue); // Convert input to zero-based index
                            validMove = makeMove.makeMove(currentPlayer, move); // Make move for player
                            if (!validMove) {
                                System.out.print("\n\tInvalid move. Please enter a value from 1 to 9 that is not already taken: ");
                            }
                        }
                    } else if (currentPlayer.equals("o")) {
                        aiComputerMove.makeAIMove(currentPlayer); // AI makes its move
                    } else {
                        System.out.println("\n\tInvalid player symbol. Please check the game logic.");
                    }

                    currentPlayer = currentPlayer.equals("x") ? "o" : "x";

                }
                System.out.println("\n\t----------------------------------");
                System.out.println(display.DisplayBoard(game.number));
                statistic.resultCheckForCounters();
                statistic.getLastPlayerWon(); // Update the last player who won
                statistic.showStatistic(); // Show statistics after each round
                lastPlayerWon = statistic.getLastPlayerWon(); // Update the last player who won
                setCurrentPlayer(lastPlayerWon);


                System.out.println("\n\tDo you want to continue playing with the current game mode? (yes/no)");
                boolean validResponse = false;
                while(!validResponse) {
                    String response = input.next();
                    if (response.equalsIgnoreCase("yes")) {
                        keepPlaying = true;
                        validResponse = true;
                        
                    } else if (response.equalsIgnoreCase("no")) {
                        keepPlaying = false;
                        validResponse = true;
                        System.out.println("\n\tThank you for playing! Exiting current game mode.");
                    } else {
                        System.out.println("\n\tInvalid response. Please enter 'yes' or 'no'.");
                    }
                }
            }
                
                break;
            case 2:
                System.out.println("You chose Player vs Player mode.");
                resetGame(); // Reset the game state before starting a new game

                // Reset keepPlaying to true for the game loop
                resetKeepPlaying();

                // Choose which player starts
                System.out.print("\n\tEnter the symbol for Player 1 (x or o): ");
                String player1Symbol = input.next();
                while (!player1Symbol.equals("x") && !player1Symbol.equals("o")) {
                    System.out.print("\n\tInvalid symbol. Please enter 'x' or 'o': ");
                    player1Symbol = input.next();
                }
                String player2Symbol = player1Symbol.equals("x") ? "o" : "x"; // Assign the opposite symbol to Player 2
                setCurrentPlayer(player1Symbol);

                while (keepPlaying) {

                    resetGame(); // Reset the game state before starting a new round
                    System.out.println("\n\tStarting a new round and player with \"" + getCurrentPlayer() + "\" symbol will start first.");

                    while (!winTie.winTie()) {
                        System.out.println("\n\t----------------------------------");
                        System.out.println(display.DisplayBoard(game.number));
                        System.out.println(smartHint.smartHint());
                        System.out.print("\n\tPlayer " + (currentPlayer.equals(player1Symbol) ? "1" : "2") + ", enter your move (1-9): ");
                        boolean validMove = false;
                        while (!validMove) {
                            String inputValue = input.next();
                            int move = Integer.parseInt(inputValue); // Convert input to zero-based index
                            validMove = makeMove.makeMove(currentPlayer, move); // Make move for player
                            if (!validMove) {
                                System.out.print("\n\tInvalid move. Please enter a value from 1 to 9 that is not already taken: ");
                            }
                        }
                        currentPlayer = currentPlayer.equals(player1Symbol) ? player2Symbol : player1Symbol; // Switch players
                    }
                    System.out.println("\n\t----------------------------------");
                    System.out.println(display.DisplayBoard(game.number));
                    statistic.resultCheckForCounters();
                    statistic.getLastPlayerWon(); // Update the last player who won
                    statistic.showStatistic(); // Show statistics after each round
                    lastPlayerWon = statistic.getLastPlayerWon(); // Update the last player who won
                    setCurrentPlayer(lastPlayerWon);    
                    System.out.println("\n\tDo you want to continue playing with the current game mode? (yes/no)");
                    boolean validResponse = false;
                    while(!validResponse) {
                        String response = input.next();
                        if (response.equalsIgnoreCase("yes")) {     
                            keepPlaying = true;
                            validResponse = true;

                        } else if (response.equalsIgnoreCase("no")) {
                            keepPlaying = false;
                            validResponse = true;
                            System.out.println("\n\tThank you for playing! Exiting current game mode.");
                        } else {
                            System.out.println("\n\tInvalid response. Please enter 'yes' or 'no'.");
                        }
                    }
                }
                break;
            case 3:
                System.out.println("You chose AI vs Player mode.");
                resetGame(); // Reset the game state before starting a new game

                // Reset keepPlaying to true for the game loop
                resetKeepPlaying();
                
                // Set the current player to "o" for AI
                setCurrentPlayer("o");
                
            while (keepPlaying) {

                resetGame(); // Reset the game state before starting a new round
                System.out.println("\n\tStarting a new round and player with \"" + currentPlayer + "\" symbol will start first.");

                while (!winTie.winTie()) {
                    System.out.println("\n\t----------------------------------");
                    System.out.println(display.DisplayBoard(game.number));
                    System.out.println(smartHint.smartHint());

                    

                    if (currentPlayer.equals("x")) {
                        System.out.print("\n\tEnter your move (1-9): ");
                        // Player's turn
                        boolean validMove = false;
                        while (!validMove) {
                            String inputValue = input.next();
                            int move = Integer.parseInt(inputValue); // Convert input to zero-based index
                            validMove = makeMove.makeMove(currentPlayer, move); // Make move for player
                            if (!validMove) {
                                System.out.print("\n\tInvalid move. Please enter a value from 1 to 9 that is not already taken: ");
                            }
                        }
                    } else if (currentPlayer.equals("o")) {
                        aiComputerMove.makeAIMove(currentPlayer); // AI makes its move
                    } else {
                        System.out.println("\n\tInvalid player symbol. Please check the game logic.");
                    }

                    currentPlayer = currentPlayer.equals("x") ? "o" : "x";

                }
                System.out.println("\n\t----------------------------------");
                System.out.println(display.DisplayBoard(game.number));
                statistic.resultCheckForCounters();
                statistic.getLastPlayerWon(); // Update the last player who won
                statistic.showStatistic(); // Show statistics after each round
                lastPlayerWon = statistic.getLastPlayerWon(); // Update the last player who won
                setCurrentPlayer(lastPlayerWon);


                System.out.println("\n\tDo you want to continue playing with the current game mode? (yes/no)");
                boolean validResponse = false;
                while(!validResponse) {
                    String response = input.next();
                    if (response.equalsIgnoreCase("yes")) {
                        keepPlaying = true;
                        validResponse = true;
                        
                    } else if (response.equalsIgnoreCase("no")) {
                        keepPlaying = false;
                        validResponse = true;
                        System.out.println("\n\tThank you for playing! Exiting current game mode.");
                    } else {
                        System.out.println("\n\tInvalid response. Please enter 'yes' or 'no'.");
                    }
                }
            }
                
                break;

            case 4:
                // Exit the game
                System.out.println("Exiting the game. Thank you for playing!");
                keepPlayingApp = false; // Set keepPlayingApp to false to exit the game loop
                if (keepPlayingApp) {
                    System.out.println("\n\tThe variable keepPlayingApp is set to true, but the game mode selection will not continue.");
                } else {
                    System.out.println("\n\tThe variable keepPlayingApp is set to false, exiting the game.");
                }
                break;
            default:
                System.out.println("Invalid choice. Please select a valid game mode.");
                chooseGameMode(); // Recursively call to re-prompt the user
                break;
        }
    }

    public void resetGame() {
        game.resetBoard();
        makeMove.resetAmountOfFilledCells();
        winTie.resetResult();
        statistic.resultCheckForCounters();
        lastPlayerWon = statistic.getLastPlayerWon();
        currentPlayer = lastPlayerWon.equals("x") ? "o" : "x";
    }

    public void resetKeepPlaying() {
        this.keepPlaying = true;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public String getLastPlayerWon() {
        return lastPlayerWon;
    }

    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean isKeepPlayingApp() {
        return keepPlayingApp;
    }
    
}
