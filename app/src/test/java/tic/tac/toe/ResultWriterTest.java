package tic.tac.toe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.nio.file.Files;

public class ResultWriterTest {
    @Test
    public void testWriteResultMethod() throws IOException {
    // Arrange
    TTTclass game = new TTTclass();
    MakeMove makeMove = new MakeMove(game, game.number);
    WinTie winTie = new WinTie(game, makeMove);
    Statistic statistic = new Statistic(winTie);

    // Simulate a win
    game.number[0] = "x";
    game.number[1] = "x";
    game.number[2] = "x"; // winning row
    makeMove.setAmountOfFilledCells(3);
    winTie.winTie(); // triggers win
    statistic.resultCheckForCounters(); // count the win

    // Temp file path
    File tempFile = File.createTempFile("result_test", ".txt");
    ResultWriter writer = new ResultWriter(tempFile.getAbsolutePath(), statistic);

    // Act
    writer.writeResult();

    // Assert
    String output = Files.readString(tempFile.toPath());
    assertTrue(output.contains("X Wins: 1"));
    assertTrue(output.contains("O Wins: 0"));
    assertTrue(output.contains("Ties: 0"));
    assertTrue(output.contains("-------------------------"));

    // Clean up
    tempFile.delete();
    }
}
