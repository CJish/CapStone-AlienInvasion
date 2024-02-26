package gameEngines;

import client.*;
import com.sun.tools.javac.Main;
import gui.MainDisplay;
import json.SynonymsJson;
import models.Item;
import models.Location;
import models.Player;
import utils.EndGameCriteria;
import utils.UtilFunctions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextParser {
    private final MainDisplay mainDisplay;

    public TextParser() {
        this.mainDisplay = new MainDisplay();
    }

    public TextParser(MainDisplay mainDisplay) {
        this.mainDisplay = mainDisplay;
    }

    public void textParser(String userInput, Player player) {

        String[] cmd = userInput.split("\\s+");
        List<String> commands = new ArrayList<>(Arrays.asList(cmd));

        String verb = JsonReader.readVerbJson(commands);
        String noun = JsonReader.readNounJson(commands);

        if (cmd.length > 1 && noun != null) {
            if (userInput.trim().equalsIgnoreCase("display inventory")) {
                System.out.println(player.getPlayerInventory());
            } else if (verb != null) {
                if (SynonymsJson.goSynonyms(verb)) {
                    UtilFunctions.movePosition(noun, player);
                    Location location = JsonReader.getLocationByAxis(player.getX(), player.getY());
                    if (location != null) {
                        player.setCurrentLocation(location.getLocation());
                        PlayerLocation.displayCurrentLocation(location.getLocation());
                    } else {
                        PlayerLocation.displayCurrentLocation(player.getCurrentLocation());
                    }
                } else if (SynonymsJson.getSynonyms(verb)) {
                    player.addItemToInventory(noun);
                } else if (SynonymsJson.dropSynonyms(verb)) {
                    if (!EndGameCriteria.dropGas(player).equals("false")) { // checks to see if the player can end the game
                        EndGameCriteria.poisonTheShip(EndGameCriteria.dropGas(player), player, mainDisplay);
                    }
                    player.removeItemFromInventory(noun);
                } else if (SynonymsJson.examineSynonyms(verb)) {
                    Item item = JsonReader.readItemDescription(noun);
                    if (item != null) {
                        System.out.println(item.getName() + ": ");
                        System.out.println(item.getDescription());
                    }
                } else if (SynonymsJson.talkSynonyms(verb)) {
                    TalkNPC.handleTalkWithNpc(noun);
                } else {
                    System.out.println("Sorry that was a invalid action");
                }
            }
        } else if (cmd.length == 1) {
            switch (cmd[0]) {
                case "quit":
                case "q":
                    UtilFunctions.quitGame();
                    break;
                case "help":
                case "h":
                    UtilFunctions.displayHelp();
                    break;
                case "map":
                    UtilFunctions.showMap();
                    break;
                default:
                    System.out.println("Sorry that was an unrecognizable command.");
            }
        } else {
            System.out.println("Sorry that was an unrecognizable text length.");
        }
    }


    public MainDisplay getMainDisplay() {
        return mainDisplay;
    }
}