package gameEngines;

import client.*;
import items.DropItem;
import items.ExamineItems;
import items.GetItems;
import json.SynonymsJson;
import models.Location;
import models.Player;

public class TextParser {

    public static void textParser(String userInput, Player player) {

        String[] cmd = userInput.split(" ");

        if (cmd.length > 1) {
            if (userInput.trim().equalsIgnoreCase("display inventory")) {
                System.out.println(player.getPlayerInventory());
            } else if (InvalidInput.checkValidInput(userInput)) {
                if (SynonymsJson.goSynonyms(cmd[0])) {
                    Movement.processCommand(cmd[1], player);
                    Location location = JsonReader.getLocationByAxis(player.getX(), player.getY());
                    if(location != null) {
                        player.setCurrentLocation(location.getLocation());
                        PlayerLocation.displayCurrentLocation(location.getLocation());
                    } else {
                        PlayerLocation.displayCurrentLocation(player.getCurrentLocation());
                    }
                } else if (SynonymsJson.getSynonyms(cmd[0])) {
                    GetItems.isItemInteractable(userInput);
                } else if (SynonymsJson.dropSynonyms(cmd[0])) {
                    DropItem.dropItem(cmd[1]);
                } else if (SynonymsJson.examineSynonyms(cmd[0])) {
                    ExamineItems.examine(userInput);
                } else if (SynonymsJson.talkSynonyms(cmd[0])){
                    TalkNPC.interactNPC(cmd[1]);
                } else {
                    System.out.println("Sorry that was a invalid action");
                }
            }
        } else if (cmd.length == 1) {
            switch (cmd[0]) {
                case "quit":
                case "q":
                    QuitGame.quitGame();
                    break;
                case "help":
                case "h":
                    Help.displayHelp();
                    break;
                case "map":
                    Map.showMap();
                    break;
                default:
                    System.out.println("Sorry that was an unrecognizable command.");
            }
        } else {
            System.out.println("Sorry that was an unrecognizable text length.");
        }
    }
}