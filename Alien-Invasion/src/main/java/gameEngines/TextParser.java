package gameEngines;

import client.*;
import json.SynonymsJson;
import models.Item;
import models.Location;
import models.Player;
import utils.UtilFunctions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextParser {
    public static void textParser(String userInput, Player player) {

        String[] cmd = userInput.split("\\s+");
        List<String> commands = new ArrayList<>(Arrays.asList(cmd));

        String verb = JsonReader.readVerbJson(commands);

        if (cmd.length > 1) {
            if (userInput.trim().equalsIgnoreCase("display inventory")) {
                System.out.println(player.getPlayerInventory());
            } else if (verb != null) {
                if (SynonymsJson.goSynonyms(verb)) {
                    UtilFunctions.movePosition(cmd[1], player);
                    Location location = JsonReader.getLocationByAxis(player.getX(), player.getY());
                    if (location != null) {
                        player.setCurrentLocation(location.getLocation());
                        PlayerLocation.displayCurrentLocation(location.getLocation());
                    } else {
                        PlayerLocation.displayCurrentLocation(player.getCurrentLocation());
                    }
                } else if (SynonymsJson.getSynonyms(verb)) {
                    player.addItemToInventory(cmd[1]);
                } else if (SynonymsJson.dropSynonyms(verb)) {
                    player.removeItemFromInventory(cmd[1]);
                } else if (SynonymsJson.examineSynonyms(verb)) {
                    Item item = JsonReader.readItemDescription(cmd[1]);
                    if (item != null) {
                        System.out.println(item.getName() + ": ");
                        System.out.println(item.getDescription());
                    }
                } else if (SynonymsJson.talkSynonyms(verb)) {
                    TalkNPC.interactNPC(cmd[1]);
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

}