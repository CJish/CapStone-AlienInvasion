package utils;

import client.TitleScreen;
import models.Player;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UtilFunctions {
    private static final String commandFilepath = "./static/commandCenterMap.txt";
    private static final Scanner scan = new Scanner(System.in);

    public static void quitGame() {
        System.out.println("Are you sure you want to quit?");
        String userInput = scan.nextLine().trim();

        if (userInput.equals("yes")) {
            System.exit(0);
        } else {
            return;
        }
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

    public static void displayHelp() {
        System.out.println("Interactable: " + "computer, north-door, west-door, note, trashcan, table, slime, goo, board, blank-board, none, north, south, east, west");
        System.out.println("Actions: " + "help, look, get, go, drop, examine, inspect, interact, analyze, move, travel, proceed, walk, run, journey, release, let-go, discard, abandon, unload, deposit, view, pick-up, grab, take, fetch, acquire, obtain, talk, speak, chat, converse, communicate, discuss, dialogue, map, show");
    }


    public static void showMap() {
        TitleScreen.displayAsciiArt(commandFilepath);
    }

    public static void displayCharacterStatus(Player player) {
        LocalTime currentTime = LocalTime.now();

        // Display character status
        System.out.println("Character Status:");
        System.out.println(" Health: " + player.getHealth());
        System.out.println(" Location: " + player.getCurrentLocation());

        System.out.println(" Inventory: ");
        for(String item : player.getPlayerInventory()) {
            System.out.println(item);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = currentTime.format(formatter);
        System.out.println(" Time: " + formattedTime);


        // Display current location
        System.out.println("Coordinates: (" + player.getX() + ", " + player.getY() + ")");
    }

    private static void doClear() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static void clear() {
        try {
           doClear();
        } catch (IOException | InterruptedException e) {
            // Handle the exceptions here
            e.printStackTrace(); // or any other appropriate action
        }
    }
}
