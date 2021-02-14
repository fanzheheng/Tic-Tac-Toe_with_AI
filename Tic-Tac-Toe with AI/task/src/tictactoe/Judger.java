package tictactoe;

public class Judger {
    final static int[][] winConditions = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };

    public static Character judge(char[] map) {
        for (int[] winCondition : winConditions) {
            if (map[winCondition[0]] != ' ' && map[winCondition[0]] == map[winCondition[1]] && map[winCondition[0]] == map[winCondition[2]]) {
                return map[winCondition[0]];
            }
        }
        return null;
    }
}
