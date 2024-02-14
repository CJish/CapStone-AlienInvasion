package gameEngines;

import com.google.gson.Gson;
import models.Location;
import models.Player;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonWriter {
    final static String PLAYER_FILE_PATH = "./static/player.json";
    private static final String UNEDITED_JSON_FILE = "./static/gameLocationsOriginal.json";
    private static final String EDITED_JSON_FILE = "./static/gameLocations.json";
    private static final Gson gson = new Gson();

    public static void modifyLocation(String locationName, String item, boolean add) {
        try {
            // Read the JSON file and deserialize it into a Location array
            Location[] locations;
            try (FileReader reader = new FileReader(EDITED_JSON_FILE)) {
                locations = gson.fromJson(reader, Location[].class);
            }

            // Find the location to modify
            for (Location location : locations) {
                if (location.getLocation().equalsIgnoreCase(locationName)) {
                    // Modify the items list
                    String formattedItem = item.trim(); // Trim whitespace
                    if (add) {
                        // Ignore case when checking for duplicates
                        if (!containsIgnoreCase(location.getItems(), formattedItem)) {
                            location.getItems().add(formattedItem);
                        }
                    } else {
                        location.getItems().removeIf(existingItem -> existingItem.trim().equalsIgnoreCase(formattedItem));
                    }
                    break; // No need to continue searching
                }
            }

            // Write the modified locations back to the JSON file
            try (FileWriter writer = new FileWriter(EDITED_JSON_FILE)) {
                gson.toJson(locations, writer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void resetLocationsJSON() {
        try {
            // Read the unedited JSON file
            Location[] uneditedLocations;
            try (FileReader reader = new FileReader(UNEDITED_JSON_FILE)) {
                uneditedLocations = gson.fromJson(reader, Location[].class);
            }

            // Write the unedited locations back to the edited JSON file
            try (FileWriter writer = new FileWriter(EDITED_JSON_FILE)) {
                gson.toJson(uneditedLocations, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static boolean containsIgnoreCase(List<String> list, String item) {
        for (String listItem : list) {
            if (listItem.trim().equalsIgnoreCase(item)) {
                return true;
            }
        }
        return false;
    }
}
