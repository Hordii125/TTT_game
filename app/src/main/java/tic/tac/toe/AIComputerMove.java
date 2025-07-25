package tic.tac.toe;

public class AIComputerMove {
    private TTTclass game;
    private String[] number;
    private MakeMove makeMove;
    private SmartHint smartHint;

    public AIComputerMove(TTTclass game, String[] number, MakeMove makeMove, SmartHint smartHint) {
        this.smartHint = smartHint;
        this.makeMove = makeMove;
        this.game = game;
        this.number = number;
    }

    // Handles move for AI
    public boolean makeAIMove(String aiPlayer) {
         
        for (int i = 0; i < number.length; i++) {

        // If the AI can win in the next move, it places its symbol in the winning cell
        if (smartHint.getWinningCell(aiPlayer, number) != -1) {
        int winningCell = smartHint.getWinningCell(aiPlayer, number);
        makeMove.makeMove(aiPlayer, winningCell + 1); // AI places its symbol in the winning cell
        return true;
        }

        // If AI can block the opponent from winning in the next move, it places its symbol in the blocking cell
        String opponent = aiPlayer.equals("x") ? "o" : "x";
        if (smartHint.getWinningCell(opponent, number) != -1) {
            int blockingCell = smartHint.getWinningCell(opponent, number); // Get the blocking cell index
            makeMove.makeMove(aiPlayer, blockingCell + 1); // AI places its symbol in the blocking cell
            return true;    
        }

        // If all cells are empty, AI makes the move to a random corner corners
        // If its a first move
        if (makeMove.getAmountOfFilledCells() <= 2) {
            if (i == 0 || i == 2 || i == 6 || i == 8) {
                if (number[i].equals(String.valueOf(i + 1))) {
                    makeMove.makeMove(aiPlayer, i + 1); // Place AI's symbol in the corner
                    return true;
                }
            }
        }

        // If its a second move and the center is empty place AI's symbol in the center
        if (makeMove.getAmountOfFilledCells() <= 4 && makeMove.getAmountOfFilledCells() > 2) {
            if (i == 4 && number[i].equals(String.valueOf(i + 1))) {
                makeMove.makeMove(aiPlayer, i + 1); // Place AI's symbol in the center
                return true;
            }
        }
        }

        // If nothing works, AI places its symbol in the random available cell
        for (int i = 0; i < number.length; i++) {
            if (number[i].matches("\\d+")) { // Check if the cell is available
                makeMove.makeMove(aiPlayer, i + 1); // Update the move
                return true;
            }
        }
        System.out.println("\n\tNo available moves left for AI.");
        return false; // No valid moves available
    }
}