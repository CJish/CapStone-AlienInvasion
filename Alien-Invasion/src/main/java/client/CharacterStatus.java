package client;

import models.Player;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;

public class CharacterStatus {
    public void displayCharacterStatus(Player player) {
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
}