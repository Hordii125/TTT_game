package tic.tac.toe;

public class TTTclass {
    public String[] number = new String[9]; // board cells

    // Constructor that initializes the board with numbers 1–9
    public TTTclass() {
        for (int i = 0; i < 9; i++) {
            number[i] = String.valueOf(i + 1);
        }
    }

    // Method to reset the board for a new game
    public void resetBoard() {
        for (int i = 0; i < 9; i++) {
            number[i] = String.valueOf(i + 1);
        }
    }
}
