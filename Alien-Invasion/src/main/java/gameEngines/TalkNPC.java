package gameEngines;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import json.NPCDialogue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Set;

public class TalkNPC {

    public static String interactNPC(String userInput){
        String message = "That is not something you can talk to.";
        String path = "./static/dialogue.json";

        try {
            Gson gson = new Gson();

            JsonObject jsonObject = gson.fromJson(new FileReader(path),  JsonObject.class);

            Set<String> npc = jsonObject.keySet();

            for (String c : npc){
                if(userInput.equalsIgnoreCase(c)){
                    message = "You are talking to " + c;
                    NPCDialogue.randDialogue(c);
                    break;
                }
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return message;
    }
}