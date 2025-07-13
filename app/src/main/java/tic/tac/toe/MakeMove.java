package tic.tac.toe;

public class MakeMove {
    private TTTclass game;
    private int amountOfFilledCells = 0; // counter for filled cells
    String [] number;

    public MakeMove(TTTclass game, String[] number) {
        this.number = number;
        this.game = game;
        
    }

    // Handles move for player
    public boolean makeMove(String currentPlayer, int cell) {
        if (cell < 1 || cell > 9) {
            System.out.println("\n\tInvalid cell number. Please choose a number between 1 and 9.");
            return false;
        }

        int index = cell - 1; // Convert to zero-based index
        if (!number[index].equals(String.valueOf(cell))) {
            System.out.println("\n\tCell already filled. Choose another cell.");
            return false;
        }

        number[index] = currentPlayer; // Place the player's symbol in the chosen cell
        amountOfFilledCells++; // Increment the filled cells count
        return true;
    }

    public int getAmountOfFilledCells() {
        return amountOfFilledCells;
    }

    public void setAmountOfFilledCells(int amountOfFilledCells) {
        this.amountOfFilledCells = amountOfFilledCells; // Set the filled cells count
    }

    public void resetAmountOfFilledCells() {
        amountOfFilledCells = 0; // Reset the filled cells count for a new game
    }
}
