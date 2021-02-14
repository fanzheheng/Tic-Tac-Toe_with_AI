package tictactoe.player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer extends AbstractPlayer {

    public HumanPlayer(char[] map) {
        super(map);
    }

    @Override
    public int getMove() {
        Scanner scanner;
        int row, col;
        while (true) {
            scanner = new Scanner(System.in);
            System.out.println("Enter the coordinates:");
            try {
                row = scanner.nextInt();
                col = scanner.nextInt();
                if(row < 1 || row > 3 || col < 1 || col > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if(map[3 * row + col - 4] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    return 3 * row + col - 4;
                }
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
            }
        }

    }
}
