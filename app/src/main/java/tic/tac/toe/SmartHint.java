package tic.tac.toe;

public class SmartHint {
    TTTclass game;
    String[] number; // board cells

    public SmartHint(TTTclass game) {
        this.game = game;
        this.number = game.number; // Initialize with the current game board
    }
    
    // Returns all available moves (not taken by x or o)
    public String smartHint() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\tAvailable moves: ");
        for (int i = 0; i < 9; i++) {
            if (!number[i].equals("x") && !number[i].equals("o")) {
                sb.append(number[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }

    // If the two cells are occupied by the same player, returns the index of the third cell
    public int getWinningCell(String player, String[] board) {
        int[][] winningCombinations = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6}             // Diagonals
        };

        for (int[] combination : winningCombinations) {
            if (board[combination[0]].equals(player) && board[combination[1]].equals(player) && board[combination[2]].matches("\\d+")) {
                return combination[2]; // Return the index of the empty cell
            } else if (board[combination[0]].equals(player) && board[combination[2]].equals(player) && board[combination[1]].matches("\\d+")) {
                return combination[1]; // Return the index of the empty cell
            } else if (board[combination[1]].equals(player) && board[combination[2]].equals(player) && board[combination[0]].matches("\\d+")) {
                return combination[0]; // Return the index of the empty cell
            }
        }
        return -1; // No winning cell found
    }
}
