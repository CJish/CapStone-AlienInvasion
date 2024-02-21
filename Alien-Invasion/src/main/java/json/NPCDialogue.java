package json;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class NPCDialogue {
    public static void randDialogue(String userIn) {
        String path = "./static/dialogue.json";
        Gson gson = new Gson();
        ArrayList<String> arrayList = new ArrayList<>();

        try (Reader reader = new FileReader(path)) {
            JsonObject jsonObject = gson.fromJson(new FileReader(path), JsonObject.class);

            Set<String> npc = jsonObject.keySet();

            JsonArray generalArray = jsonObject.getAsJsonArray(userIn);
            if (generalArray != null) {
                for (int i = 0; i < generalArray.size(); i++) {
                    String dialog = generalArray.get(i).getAsString();
                    arrayList.add(dialog);
                }
            }
            rand(arrayList);
        } catch (IOException e) {
            System.err.println("Error loading location data: " + e.getMessage());
        } catch (JsonSyntaxException e) {
            System.err.println("Error parsing JSON data: " + e.getMessage());
        }
    }

    private static void rand(ArrayList<String> arrayList) {
        double rand = (Math.random() * (arrayList.size() - 1));
        int randNum = (int) Math.round(rand);
        System.out.println(arrayList.get(randNum));
    }
}