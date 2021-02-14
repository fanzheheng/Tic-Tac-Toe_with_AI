package tictactoe;

import tictactoe.player.Player;
import tictactoe.player.PlayerFactory;

import java.util.Scanner;

public class Game {
    private static char[] map = new char[9];
    private static int steps;

    public static boolean isCurrentX() {
        return currentX;
    }

    private static boolean currentX;

    static Player playerX;
    static Player playerO;

    public static void start() {
        Scanner scanner;
        String[] commands;
        while (true) {
            System.out.println("Input command:");
            scanner = new Scanner(System.in);
            commands = scanner.nextLine().split(" ");
            if(commands.length == 0) {
                System.out.println("Bad parameters!");
                continue;
            } else {
                if (commands[0].equals("start")) {
                    if(commands.length < 3) {
                        System.out.println("Bad parameters!");
                        continue;
                    } else {
                        playerX = PlayerFactory.getPlayer(commands[1], map, 'X');
                        playerO = PlayerFactory.getPlayer(commands[2], map, 'O');
                        if (playerX == null || playerO == null) {
                            System.out.println("Bad parameters!");
                            continue;
                        }
                    }
                } else if (commands[0].equals("exit")) {
                    break;
                } else {
                    System.out.println("Bad parameters!");
                    continue;
                }
            }

            // 初始化对局信息
            steps = 0;
            currentX = true;

            // 初始化地图
            for(int i = 0; i < 9; i++) {
                map[i] = ' ';
            }

            // 输出地图信息
            printMap();

            // 对局开始
            while (steps < 9) {
                int move = currentX ? playerX.getMove() : playerO.getMove();
                map[move] = currentX ? 'X' : 'O';
                steps++;
                printMap();
                currentX = !currentX;
                if(printStatus()) {
                    break;
                }
            }
        }
        scanner.close();
    }

    public static char[] getMap() {
        return map;
    }

    private static void printMap() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(map[3 * i + j]);
                System.out.print(' ');
            }
            System.out.println('|');
        }
        System.out.println("---------");
    }



    private static boolean printStatus() {
        Character c = Judger.judge(map);
        if(c != null) {
            System.out.println(c + " wins");
            return true;
        }
        if(steps == 9) {
            System.out.println("Draw");
            return true;
        } else {
            System.out.println("Game not finished");
            return false;
        }
    }
}
