package tic.tac.toe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartHintTest {
    @Test
    public void testGetWinningCell() {
        TTTclass game = new TTTclass();
        MakeMove makeMove = new MakeMove(game, game.number);
        SmartHint smartHint = new SmartHint(game);
        game.number[0] = "x"; // Simulate player 'x' has made
        game.number[1] = "x"; // Simulate player 'x' has made
        game.number[2] = "3"; // Simulate cell 3 is available
        game.number[3] = "4"; // Simulate cell 4 is available
        game.number[4] = "5"; // Simulate cell 5 is available
        game.number[5] = "6"; // Simulate cell 6 is available
        game.number[6] = "7"; // Simulate cell 7 is available
        game.number[7] = "8"; // Simulate cell 8 is available
        game.number[8] = "9"; // Simulate cell 9 is available

        int winningCell = smartHint.getWinningCell("x", game.number);
        assertEquals(2, winningCell);
    }

    @Test
    public void testGetBlockingCell() {
        TTTclass game = new TTTclass();
        MakeMove makeMove = new MakeMove(game, game.number);
        SmartHint smartHint = new SmartHint(game);
        game.number[0] = "x"; // Simulate player 'x' has made
        game.number[1] = "x"; // Simulate player 'x' has made
        game.number[2] = "3"; // Simulate cell 3 is available
        game.number[3] = "4"; // Simulate cell 4 is available
        game.number[4] = "5"; // Simulate cell 5 is available
        game.number[5] = "6"; // Simulate cell 6 is available
        game.number[6] = "7"; // Simulate cell 7 is available
        game.number[7] = "8"; // Simulate cell 8 is available
        game.number[8] = "9"; // Simulate cell 9 is available

        int blockingCell = smartHint.getWinningCell("x", game.number);
        assertEquals(2, blockingCell); // AI should block player 'x' at cell
    }
}
