package tictactoe.player;

import tictactoe.Judger;

public class MediumPlayer extends EasyPlayer {
    Character chess;
    Character opchess;

    public MediumPlayer(char[] map, char c) {
        super(map);
        chess = c;
        opchess = c == 'X' ? 'O' : 'X';
    }

    @Override
    public int getMove() {
        System.out.println("Making move level \"medium\"");
        char[] newMap = map.clone();
        Integer position = tryMove(newMap, chess);
        if (position != null) return position;
        position = tryMove(newMap, opchess);
        if (position != null) return position;
        return super.randomMove();
    }

    private Integer tryMove(char[] newMap, Character chess) {
        for(int i = 0; i < 9; i++) {
            if(newMap[i] == ' ') {
                newMap[i] = chess;
                if(chess.equals(Judger.judge(newMap))) {
                   return i;
                }
                newMap[i] = ' ';
            }
        }
        return null;
    }
}
