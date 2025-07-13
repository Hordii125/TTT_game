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
}
