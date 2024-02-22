package gameEngines;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import gameEngines.supportengine.Nouns;
import models.Item;
import models.Location;
import models.Npc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class JsonReader {
   private final static Gson gson = new Gson(); // create a Gson instance for JSON parsing
    final static String filePath = "./static/gameLocations.json";

    public static Location getLocationByName(String locationName) {
        try (Reader reader = new FileReader(filePath)) { // try to read JSON data from file
            Type locationListType = new TypeToken<List<Location>>() {
            }.getType();
            List<Location> locations = gson.fromJson(reader, locationListType); // parse JSON data
            for (Location location : locations) {
                if(location.getLocation().equalsIgnoreCase(locationName)) {
                    return location;
                }
            }
            return null;
        } catch (IOException e) { // handle input output errors
            e.printStackTrace();
            return null;
        }
    }

    public static Location getLocationByAxis(int x, int y) {
        try (Reader reader = new FileReader(filePath)) { // try to read JSON data from file
            Type locationListType = new TypeToken<List<Location>>() {
            }.getType();
            List<Location> locations = gson.fromJson(reader, locationListType); // parse JSON data
            for (Location location : locations) {
                if(location.getX() == x && location.getY() == y) {
                    return location;
                }
            }
            return null;
        } catch (IOException e) { // handle input output errors
            e.printStackTrace();
            return null;
        }
    }

    public static Item readItemDescription(String myItem) {
        try {
            Type itemListType = new TypeToken<List<Item>>() {}.getType();
            List<Item> itemList = gson.fromJson(new FileReader("./static/items.json"), itemListType);

            for (Item item : itemList) {
                if (item.getName().trim().equalsIgnoreCase(myItem.trim())) {
                    return item;
                }
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Returns the targeted npc by name
    public static Npc returnNpc(String npcName) {
        try {
            Type npcListType = new TypeToken<List<Npc>>() {}.getType();
            List<Npc> itemList = gson.fromJson(new FileReader("./static/npc.json"), npcListType);

            for (Npc npc : itemList) {
                if (npc.getName().trim().equalsIgnoreCase(npcName.trim())) {
                    return npc;
                }
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String readVerbJson(List<String> userInput) {
        try {
            String myVerb = "";
            String[] verbs = new String[]{"go", "talk", "get", "look", "fire", "inventory", "drop", "help", "quit", "cheat", "mute", "unmute"};
            Gson gson = new Gson();
            JsonObject json = gson.fromJson(new FileReader("./static/Verbs.json"), JsonObject.class);

            int topIter = 0;
            int iter = 0;
            while (myVerb.equals("") && topIter < verbs.length * userInput.size()) {
                if (iter == verbs.length) {
                    iter = 0;
                }
                String verb = json.get(verbs[iter]).getAsString();
                String[] synonyms = verb.split(" ");
                for (String synonym : synonyms) {
                    if (userInput.contains(synonym.toLowerCase())) {
                        myVerb = verbs[iter];
                        break;
                    }
                }
                iter++;
                topIter++;
            }
            if (myVerb.equals("")) {
                return null;
            }
            else {
                return myVerb;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String readNounJson(List<String> userInput) {
        try {
            Nouns nouns = gson.fromJson(new FileReader("static/Nouns.json"), Nouns.class);
            for (String word : userInput) {
                if (nouns.getNouns().contains(word.toLowerCase().trim())) {
                    return word;
                }
            }
            return null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}