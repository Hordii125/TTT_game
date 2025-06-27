package tic.tac.toe;

public class TTTclass {
    // Variables used for the game
    private String[] number = new String[9]; // board cells
    private int amountOfFilledCells = 0; // counter for filled cells
    private String wt = ""; // winner symbol

    // Constructor that initializes the board with numbers 1–9
    public TTTclass() {
        for (int i = 0; i < 9; i++) {
            number[i] = String.valueOf(i + 1);
        }
    }

    // Displays the current board
    public String display() {
        StringBuilder board = new StringBuilder("\n");
        for (int i = 0; i < 9; i += 3) {
            board.append(String.format("%10s%10s%10s\n\n\n", number[i], number[i + 1], number[i + 2]));
        }
        return board.toString();
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

    // Handles move for player
    public boolean makeMove(String playerSymbol, int cell) {
        // If input is invalid or cell is already taken
        if (cell < 1 || cell > 9 || !(playerSymbol.equals("x") || playerSymbol.equals("o"))) return false;
        if (number[cell - 1].equals("x") || number[cell - 1].equals("o")) return false;

        number[cell - 1] = playerSymbol;
        amountOfFilledCells++;
        return true;
    }

    // Determines if someone won or it's a tie
    public boolean winTie() {
        int[][] winComb = {
            {0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}
        };

        for (int[] combo : winComb) {
            if (number[combo[0]].equals(number[combo[1]]) && number[combo[1]].equals(number[combo[2]])) {
                System.out.println("\n\tGame Over! Player '" + number[combo[0]] + "' won.");
                System.out.println("\n\tWinning combination: " + combo[0] + ", " + combo[1] + ", " + combo[2]);
                wt = number[combo[0]];
                return true;
            }
        }

        if (amountOfFilledCells == 9) {
            System.out.println("\n\tGame Over! It's a Tie.");
            wt = "tie";
            return true;
        }

        return false;
    }

    // Returns game result: x, o, or tie
    public String getResult() {
        return wt;
    }
}
