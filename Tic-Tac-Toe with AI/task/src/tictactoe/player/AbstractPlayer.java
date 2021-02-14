package tictactoe.player;

public abstract class AbstractPlayer implements Player {
    char[] map;

    public AbstractPlayer(char[] map) {
        this.map = map;
    }

    public abstract int getMove();
}
