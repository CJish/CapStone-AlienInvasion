package gameEngines;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.FileNotFoundException;

public class GameTextJSONParser {
    public static void jsonReader() {
        String path = "./static/storyText.json";

        try {
            // Create a Gson instance
            Gson gson = new Gson();

            // Read JSON data from the file into a JsonObject
            JsonObject jsonObject = gson.fromJson(new FileReader(path), JsonObject.class);

            // Access specific properties in the JSON object
            String story = jsonObject.getAsJsonObject("Story").getAsJsonObject("Scene 1").get("Story").getAsString();

            System.out.println(story);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}