package tic.tac.toe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisplayTest {
    @Test
    public void testDisplayBoard() {
        TTTclass game = new TTTclass();
        Display display = new Display(game);
        game.number[0] = "x";
        game.number[1] = "o";
        game.number[2] = "3";
        game.number[3] = "4";
        game.number[4] = "5";
        game.number[5] = "6";
        game.number[6] = "7";
        game.number[7] = "8";
        game.number[8] = "9";

        String expectedBoard = "\n" +
                String.format("%10s%10s%10s\n\n\n", "x", "o", "3") +
                String.format("%10s%10s%10s\n\n\n", "4", "5", "6") +
                String.format("%10s%10s%10s\n\n\n", "7", "8", "9");
        String actualBoard = display.DisplayBoard(game.number);
        assertEquals(expectedBoard, actualBoard);
    }
}
