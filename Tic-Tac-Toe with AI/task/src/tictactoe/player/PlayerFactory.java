package tictactoe.player;

public class PlayerFactory {
    public static AbstractPlayer getPlayer(String type, char[] map, char c) {
        switch (type) {
            case "user":
                return new HumanPlayer(map);
            case "easy":
                return new EasyPlayer(map);
            case "medium":
                return new MediumPlayer(map, c);
            case "hard":
                return new HardPlayer(map, c);
            default:
                return null;
        }
    }
}
