package tictactoe.player;

import java.util.Random;

public class EasyPlayer extends AbstractPlayer {
    public EasyPlayer(char[] map) {
        super(map);
    }

    protected int randomMove() {
        Random random = new Random();
        int move;
        do {
            move = random.nextInt(9);
        } while (map[move] != ' ');
        return move;
    }

    @Override
    public int getMove() {
        System.out.println("Making move level \"easy\"");
        return randomMove();
    }
}
