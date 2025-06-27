package tic.tac.toe;
import java.io.*;

public class TTTapp {
    public static void main(String[] args) throws IOException {
        TTTclass game = new TTTclass();
        System.out.println("\n\n\n");
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.printf("%50s\n\n\n", "Game starts now!");

        game.display();

        String result = "";
        boolean finished = false;

        while (!finished) {
            game.smartHint();
            game.enterValue();
            game.valueComp();
            game.display();
            finished = game.winTie();
            result = game.getResult();
        }

        FileWriter file = new FileWriter("result.txt", true);
        if (result.equals("")) {
            file.write("Tie\n");
        } else {
            file.write("Winner: " + result + "\n");
        }
        file.close();
    }
}
