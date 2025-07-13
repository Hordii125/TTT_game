package tic.tac.toe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TTTtest {
    private final TTTclass game = new TTTclass();

    @Test 
    public void testResetBoard() {

        //change the board to a specific state
        for (int i = 0; i < 9; i++) {
            game.number[i] = "X";
        }

        game.resetBoard();
        for (int i = 0; i < 9; i++) {
            assertEquals(String.valueOf(i + 1), game.number[i]);
        }
    }
}
