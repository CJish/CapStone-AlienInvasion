package app;

import client.*;
import gameEngines.JsonWriter;
import gui.EndGameDisplay;
import gui.MainDisplay;
import gui.components.MessagesPanel;
import models.Player;
import gameEngines.TextParser;
import utils.DisplayMethodsGUI;
import utils.EndGameCriteria;
import utils.UtilFunctions;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Scanner;



public class AlienInvasionApp  {
    private final TextParser textParser = new TextParser();
    private final Player player = new Player();
    private final MainDisplay mainDisplay = new MainDisplay();
    private boolean isGame = true;

    public void run() throws IOException {
        initialize(); // THIS SHOULD NOT MOVE
        UtilFunctions.clear();
        Scanner scan = new Scanner(System.in);
        TitleScreen.displayAsciiArt("./static/title.txt");

        mainDisplay.showMainDisplay(player); // THIS SHOWS THE GUI

        if (NewGame.gameStart()) {
            UtilFunctions.clear();

            while (isGame) {
                AlienInvasionIntro.clearConsolePause(1000);
                UtilFunctions.displayCharacterStatus(player);
                System.out.println("What's your next move Commander?");
                System.out.print("> ");
                String userInput = scan.nextLine().trim();
                textParser.textParser(userInput, player);
                if (EndGameCriteria.isDroppedGas()) {
                    setGame(false);
                }
            }
        }
    }


    public void initialize() {
        player.setX(16); // player's starting location
        player.setY(6); // player's starting location
        player.setCurrentLocation("Command Center");
        player.setHealth(100);
        player.setPlayerWon(false);
        JsonWriter.resetLocationsJSON();
    }

    public void buttonClicked(KeyEvent k) {}

    public boolean isGame() {
        return isGame;
    }

    public void setGame(boolean game) {
        isGame = game;
    }
}