package gameEngines;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import json.NPCDialogue;
import models.Npc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Set;

public class TalkNPC {
    public static String handleTalkWithNpc(String npcName) {
        Npc npc = JsonReader.returnNpc(npcName);
        if(npc != null) {
            // We can randomize this later
            System.out.println(npc.getDialogue().get(0));
            return npc.getDialogue().get(0);
        } else {
            System.out.println("No npc with that name here");
            return "not found";
        }
    }
}