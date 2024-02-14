package gameEngines;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Location;

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
}