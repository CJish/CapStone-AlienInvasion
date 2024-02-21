package json;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ItemsJSON {
    private static String path = "./static/items.json";

    public static String getDescription(String item) {

        String description = "That item does not exist";

        try {
            Gson gson = new Gson();
            // Read JSON data from the file into a JsonObject
            JsonObject jsonObject = gson.fromJson(new FileReader(path), JsonObject.class);

            // This can remain the same
            JsonObject locationObject = jsonObject.getAsJsonObject("location");

            // We will want to generate this dynamically based on actual player location
            // client.PlayerLocation.getLocationName()
            JsonObject commandObject = locationObject.getAsJsonObject("Command Center");

            // This might be able to remain static... depends on how we want to separate inter-actables
            JsonObject itemsObject = commandObject.getAsJsonObject("items");

            // TODO Need to update the remaining items to get what we need
            // This will need to be dynamic based on whatever player has input
            JsonObject specificItemObject = itemsObject.getAsJsonObject(item);

            description = specificItemObject.get("description").getAsString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return description;
    }

    public static ArrayList<Integer> getCoordinates(String item) {
        ArrayList<Integer> coordinates = new ArrayList<>();

        try {
            Gson gson = new Gson();
            // Read JSON data from the file into a JsonObject
            JsonObject jsonObject = gson.fromJson(new FileReader(path), JsonObject.class);

            // This can remain the same
            JsonObject locationObject = jsonObject.getAsJsonObject("location");

            // We will want to generate this dynamically based on actual player location
            // client.PlayerLocation.getLocationName()
            JsonObject commandObject = locationObject.getAsJsonObject("Command Center");

            // This might be able to remain static... depends on how we want to separate inter-actables
            JsonObject itemsObject = commandObject.getAsJsonObject("items");

            // TODO Need to update the remaining items to be at where we need them
            // This will need to be dynamic based on whatever player has input
            JsonObject specificItemObject = itemsObject.getAsJsonObject(item);

//            description = specificItemObject.get("description").getAsString();

            String coord = specificItemObject.get("coordinates").getAsString().trim();
            System.out.println(coord);

            if (!coord.equals("null")) {
                String[] coords = coord.split(",");

                for (String i : coords) {
                    int c = Integer.parseInt(i.trim());
                    coordinates.add(c);
                }
            }
//            else {
//                coordinates = null;
//            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return coordinates;
    }

    public static void setCoordinates(ArrayList<Integer> coordinates, String item) throws IOException {

        try {
            Gson gson = new Gson();
            // Read JSON data from the file into a JsonObject
            JsonObject jsonObject = gson.fromJson(new FileReader(path), JsonObject.class);

            // This can remain the same
            JsonObject locationObject = jsonObject.getAsJsonObject("location");

            // We will want to generate this dynamically based on actual player location
            // client.PlayerLocation.getLocationName()
            JsonObject commandObject = locationObject.getAsJsonObject("Command Center");

            // This might be able to remain static... depends on how we want to separate inter-actables
            JsonObject itemsObject = commandObject.getAsJsonObject("items");

            // TODO Need to update the remaining items to get what we need
            // This will need to be dynamic based on whatever player has input
            JsonObject specificItemObject = itemsObject.getAsJsonObject(item);

//            description = specificItemObject.get("description").getAsString();

            String coords = String.valueOf(coordinates).replace("[", "").replace("]", "").strip();
//            System.out.println(coords);

            specificItemObject.addProperty("coordinates", coords);

            String updatedJson = new Gson().toJson(jsonObject);

            try (FileWriter writer = new FileWriter(path)) {
                writer.write(updatedJson);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void setCoordinatesToNull(String item) {

        try {
            Gson gson = new Gson();
            // Read JSON data from the file into a JsonObject
            JsonObject jsonObject = gson.fromJson(new FileReader(path), JsonObject.class);

            // This can remain the same
            JsonObject locationObject = jsonObject.getAsJsonObject("location");

            // We will want to generate this dynamically based on actual player location
            // client.PlayerLocation.getLocationName()
            JsonObject commandObject = locationObject.getAsJsonObject("Command Center");

            // This might be able to remain static... depends on how we want to separate inter-actables
            JsonObject itemsObject = commandObject.getAsJsonObject("items");

            // TODO Need to update the remaining items to get what we need
            // This will need to be dynamic based on whatever player has input
            JsonObject specificItemObject = itemsObject.getAsJsonObject(item);

//            description = specificItemObject.get("description").getAsString();

            specificItemObject.addProperty("coordinates", (String) null);

            String updatedJson = new Gson().toJson(jsonObject);

            try (FileWriter writer = new FileWriter(path)) {
                writer.write(updatedJson);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
