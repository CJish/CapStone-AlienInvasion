package items;

import client.Movement;
import json.ItemsJSON;

import java.io.IOException;
import java.util.ArrayList;

public class DropItem {
    public static void dropItem(String userInput){
        try {
            ArrayList<Integer> currentCoordinates = new ArrayList<>();
            Inventory.getInventory().remove(userInput.trim());
            ItemsJSON.setCoordinates(currentCoordinates, userInput);
            System.out.println("You dropped " + userInput + " at coordinates " + currentCoordinates);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
