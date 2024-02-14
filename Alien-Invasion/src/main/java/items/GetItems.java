package items;

import client.Movement;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import json.ItemsJSON;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class GetItems {

    public static boolean isItemInteractable(String userInput) {
        String path = "./static/items.json";
        boolean isItem = false;
        String[] input = userInput.trim().split(" ");

        String message = "That is not something you can pickup...";
        try {
            Gson gson = new Gson();
            // Read JSON data from the file into a JsonObject
            JsonObject jsonObject = gson.fromJson(new FileReader(path), JsonObject.class);
            JsonObject locationObject = jsonObject.getAsJsonObject("location");
            JsonObject commandObject = locationObject.getAsJsonObject("Command Center");
            JsonObject itemsObject = commandObject.getAsJsonObject("items");
            Set<Map.Entry<String, JsonElement>> entrySet = itemsObject.entrySet();
            ArrayList<Integer> currentCoordinates = new ArrayList<>();
            for (Map.Entry<String, JsonElement> entry : entrySet) {
                String itemName = entry.getKey();
                if (itemName.equalsIgnoreCase(input[1]) && !itemName.equalsIgnoreCase("north")
                        && !itemName.equalsIgnoreCase("south")
                        && !itemName.equalsIgnoreCase("east")
                        && !itemName.equalsIgnoreCase("west")) {
//                       System.out.println(currentCoordinates);
//                       System.out.println(json.ItemsJSON.getCoordinates(input[1]));
//                       if (json.ItemsJSON.getCoordinates(input[1])) { //== currentCoordinates
//                           System.out.println(currentCoordinates);
                    ArrayList<Integer> newCoords = new ArrayList<>();
                    newCoords.add(5000);
                    newCoords.add(5000);
//                           System.out.println("IT should work");
                    isItem = true;
                    Inventory.setInventory(input[1]);
                    message = ("You have added " + itemName +  " into your inventory");
                    ItemsJSON.setCoordinates(newCoords,input[1]);
                    break;
                }
            }System.out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return isItem;

    }
}
