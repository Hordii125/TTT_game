package tic.tac.toe;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MakeMoveTest {
    private final TTTclass game = new TTTclass();
    private final MakeMove makeMove = new MakeMove(game, game.number);

    @Test
    public void testMakeMove() {
        // Simulate a move by player 'X'
        makeMove.makeMove("x", 1);
        assertEquals("x", game.number[0]);
        assertEquals(1, makeMove.getAmountOfFilledCells());
    }

    @Test
    public void testResetAmountOfFilledCells() {
        makeMove.setAmountOfFilledCells(5); // Set filled cells to 5
        makeMove.resetAmountOfFilledCells();
        assertEquals(0, makeMove.getAmountOfFilledCells());
    }
}
