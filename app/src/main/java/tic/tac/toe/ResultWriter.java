package tic.tac.toe;
import java.io.FileWriter;

public class ResultWriter {
    Statistic statistic; // Assuming Statistic is a class that holds game statistics
    private String filePath;
    private FileWriter fileWriter;
    private int tieCount;
    private int xWinCount;
    private int oWinCount;

    public ResultWriter(String filePath, Statistic statistic) {
        this.statistic = statistic;
        this.filePath = filePath;
        try {
            this.fileWriter = new FileWriter(filePath, false); // false to overwrite the file
        } catch (Exception e) {
            System.out.println("Error initializing ResultWriter: " + e.getMessage());
        }
    }

    public void writeResult() {
        this.tieCount = statistic.getTieCount();
        this.xWinCount = statistic.getXWinCount();
        this.oWinCount = statistic.getOWinCount();
        try {
            fileWriter.write("Game Results:\n");
            fileWriter.write("X Wins: " + xWinCount + "\n");
            fileWriter.write("O Wins: " + oWinCount + "\n");
            fileWriter.write("Ties: " + tieCount + "\n");
            fileWriter.write("-------------------------\n");
            fileWriter.flush();
        } catch (Exception e) {
            System.out.println("Error writing results: " + e.getMessage());
        } finally {
            try {
                fileWriter.close();
            } catch (Exception e) {
                System.out.println("Error closing FileWriter: " + e.getMessage());
            }
        }
    }
}
