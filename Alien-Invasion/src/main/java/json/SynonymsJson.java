package json;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class SynonymsJson {
    public static boolean getSynonyms(String userInput){
        boolean isSynonym = false;
        String path = "./static/getSynonyms.json";

        try {
            Gson gson = new Gson();

            JsonArray jsonArray = gson.fromJson(new FileReader(path), JsonArray.class);

            for (JsonElement element : jsonArray) {
                if (element.isJsonPrimitive()) {
                    String synonym = element.getAsString();
//                    System.out.println(synonym);
                    if (userInput.equalsIgnoreCase(synonym)) {
                        isSynonym = true;
                        break;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return isSynonym;
    }
    public static boolean examineSynonyms(String userInput){
        boolean isSynonym = false;
        String path = "./static/examineSynonyms.json";

        try {
            Gson gson = new Gson();

            JsonArray jsonArray = gson.fromJson(new FileReader(path), JsonArray.class);

            for (JsonElement element : jsonArray) {
                if (element.isJsonPrimitive()) {
                    String synonym = element.getAsString();
//                    System.out.println(synonym);
                    if (userInput.equalsIgnoreCase(synonym)) {
                        isSynonym = true;
                        break;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return isSynonym;
    }
    public static boolean goSynonyms(String userInput){
        boolean isSynonym = false;
        String path = "./static/goSynonyms.json";

        try {
            Gson gson = new Gson();

            JsonArray jsonArray = gson.fromJson(new FileReader(path), JsonArray.class);

            for (JsonElement element : jsonArray) {
                if (element.isJsonPrimitive()) {
                    String synonym = element.getAsString();
//                    System.out.println(synonym);
                    if (userInput.equalsIgnoreCase(synonym)) {
                        isSynonym = true;
                        break;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return isSynonym;
    }
    public static boolean dropSynonyms(String userInput){
        boolean isSynonym = false;
        String path = "./static/dropSynonyms.json";

        try {
            Gson gson = new Gson();

            JsonArray jsonArray = gson.fromJson(new FileReader(path), JsonArray.class);

            for (JsonElement element : jsonArray) {
                if (element.isJsonPrimitive()) {
                    String synonym = element.getAsString();
//                    System.out.println(synonym);
                    if (userInput.equalsIgnoreCase(synonym)) {
                        isSynonym = true;
                        break;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return isSynonym;
    }
    public static boolean talkSynonyms(String userInput){
        boolean isSynonym = false;
        String path = "./static/talkSynonyms.json";

        try {
            Gson gson = new Gson();

            JsonArray jsonArray = gson.fromJson(new FileReader(path), JsonArray.class);

            for (JsonElement element : jsonArray) {
                if (element.isJsonPrimitive()) {
                    String synonym = element.getAsString();
//                    System.out.println(synonym);
                    if (userInput.equalsIgnoreCase(synonym)) {
                        isSynonym = true;
                        break;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return isSynonym;
    }
}