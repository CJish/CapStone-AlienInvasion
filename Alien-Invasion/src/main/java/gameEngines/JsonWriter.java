package gameEngines;

import com.google.gson.Gson;
import models.Player;

import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter {
    final static String PLAYER_FILE_PATH = "./static/player.json";
    private static final Gson gson = new Gson();
    public static void writePlayerToFile(Player player) {
        try (FileWriter writer = new FileWriter(PLAYER_FILE_PATH)) {
            gson.toJson(player, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
