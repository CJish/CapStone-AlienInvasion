package app;

import client.*;
import gameEngines.JsonWriter;
import models.Player;
import gameEngines.TextParser;
import utils.UtilFunctions;

import java.util.Scanner;

public class AlienInvasionApp {
    private final Player player = new Player();
    private boolean isGame = true;

    public void run() {
        initialize();
        UtilFunctions.clear();
        Scanner scan = new Scanner(System.in);
        TitleScreen.displayAsciiArt("./static/title.txt");

        if (NewGame.gameStart()) {
            UtilFunctions.clear();
            while (isGame()) {
                AlienInvasionIntro.clearConsolePause(1000);
                UtilFunctions.displayCharacterStatus(player);
                System.out.println("What's your next move Commander?");
                System.out.print("> ");
                String userInput = scan.nextLine().trim();
                TextParser.textParser(userInput, player);
            }
        }
    }

    public void initialize() {
        player.setX(0);
        player.setY(0);
        player.setCurrentLocation("Command Center");
        player.setHealth(100);
        JsonWriter.resetLocationsJSON();
    }

    public boolean isGame() {
        return isGame;
    }

    public void setGame(boolean game) {
        isGame = game;
    }
}