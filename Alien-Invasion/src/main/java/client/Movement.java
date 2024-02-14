package client;

import models.Player;

import java.util.Scanner;

public class Movement {
    //methods
    public static void processCommand(String command, Player player) {
            movePosition(command, player);
    }

    public static void movePosition(String direction, Player player) {
        int x = player.getX();
        int y = player.getY();
        switch (direction.toLowerCase()) {
            case "north":
                player.setY(y + 1);
                break;
            case "south":
                player.setY(y - 1);
                break;
            case "east":
                player.setX(x + 1);
                break;
            case "west":
                player.setX(x - 1);
                break;
            default:
                System.out.println("Invalid direction!");
        }
    }
}
