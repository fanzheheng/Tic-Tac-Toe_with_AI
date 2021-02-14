package tictactoe.player;

import tictactoe.Judger;

public class HardPlayer extends AbstractPlayer {
    Character chess;
    Character opchess;

    int total;
    int move;

    public HardPlayer(char[] map, char c) {
        super(map);
        chess = c;
        opchess = c == 'X' ? 'O' : 'X';
    }

    @Override
    public int getMove() {
        int n = 0;
        for (int i = 0; i < 9; i++) {
            if (map[i] != ' ') {
                n++;
            }
        }
        total = n;
        dfs(map.clone(), chess, n);
        return move;
    }

    private int dfs(char[] map, Character currentChess, int n) {
        int max = -9;
        int score = 0;
        for(int i = 0; i < 9; i++) {
            if (map[i] == ' ') {
                map[i] = currentChess;
                if(currentChess.equals(Judger.judge(map))) {
                    map[i] = ' ';
                    if (n == total) move = i;
                    return 9 - n;
                } else if (n == 8) {
                    map[i] = ' ';
                    if (n == total) move = i;
                    return 0;
                } else {
                    score = -dfs(map, currentChess == 'X' ? 'O' : 'X', n + 1);
                    map[i] = ' ';
                }
                if(score > max) {
                    if (n == total) move = i;
                    max = score;
                }
            }
        }
        return max;
    }
}
