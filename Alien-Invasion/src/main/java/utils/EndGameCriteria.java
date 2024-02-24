package utils;

import app.AlienInvasionApp;
import models.Player;

import java.util.List;

public class EndGameCriteria {

    public static String dropGas(Player player){
        String canDropGas = "I won... but died";
        String canDropGasAndLive = "I win... and lived!";
        List<String> inventory = player.getPlayerInventory();
        String location = player.getCurrentLocation();

        if (inventory.contains("vial-of-toxic-gas")&& inventory.contains("protective-vent-cover") && inventory.contains("gas-mask") && location.equals("Oxygen Vent Room")) {

            return canDropGas;
        }
        else if (inventory.contains("vial-of-toxic-gas")&& inventory.contains("protective-vent-cover") && location.equals("Oxygen Vent Room")) {

            return canDropGasAndLive;
        }
        return "false";
    };

    public static boolean canGoVentRoom(Player player) {
        boolean hasKeyCard = false;
        List<String> inventory = player.getPlayerInventory();

        if (inventory.contains("key-card")) {
            hasKeyCard = true;
        }

        return hasKeyCard;
    }

    public static boolean getVentCover(Player player, boolean hasDrill) {
        boolean hasVentCover = false;
        List<String> inventory = player.getPlayerInventory();

        if (inventory.contains("power-drill")) {
            hasVentCover = true;
        }

        return hasVentCover;
    }

    public static void poisonTheShip(String liveOrDie, Player player) {
        if (liveOrDie.equals("I won... but died")) {
            player.setHealth(0);
            System.out.println("You drop the poisonous gas into the vent hole, and the ship rapidly fogs with gas. You choke on the toxic fumes and fall down with all of the Aliens. You've won, but at what cost.");
        }
        else {
            System.out.println("You dump the poisonous gas into the vent hole, and the ship rapidly fogs with gas. The aliens all die");

        }
    }
}