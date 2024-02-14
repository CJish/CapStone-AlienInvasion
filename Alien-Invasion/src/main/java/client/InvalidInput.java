package client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Set;

public class InvalidInput {
//    public static String[] validInputWords = {"look", "around", "observe", "inspect", "approach", "interact", "computer", "examine", "door", "read",
//            "note", "check", "trashcan", "table", "inspect", "slime", "goo", "open", "take", "attack", "hit", "use", "interact", "discard",
//            "throw", "inventory", "items", "unlock", "analyze", "help", "go", "north", "south", "east", "west", "map"};
//

    private static boolean isValid = false;

    public static boolean checkValidInput(String word) {
        String path = "./static/items.json";
        String[] userInput = word.toLowerCase().split(" ");

        isValid = false;
        try {
            Gson gson = new Gson();

            // Read JSON data from the file into a JsonObject
            JsonObject jsonObject = gson.fromJson(new FileReader(path), JsonObject.class);

            JsonObject locationObject = jsonObject.getAsJsonObject("location");
            // Need to update this based on player location in room
            JsonObject commandObject = locationObject.getAsJsonObject("Command Center");
            JsonObject items = commandObject.getAsJsonObject("items");

            JsonPrimitive availableCommands = commandObject.getAsJsonPrimitive("available commands");

            Set<String> entrySet = items.keySet();
            String[] validCommands = availableCommands.getAsString().toLowerCase().strip().split(",");

            boolean validFirstWord = false;
            for (String command : validCommands) {
                if (userInput[0].equalsIgnoreCase(command.strip())) {
                    validFirstWord = true;
//                    System.out.println("valid First");
                    break;
                }
            }
            if (validFirstWord) {
                for (String valid : entrySet) {
                    if (userInput[1].equalsIgnoreCase(valid) || userInput[1].equalsIgnoreCase("general") ||
                            userInput[1].equalsIgnoreCase("robot")) {
                        isValid = true;
//                        System.out.println("valid  second");
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (!isValid) {
            System.out.println("The entered text is invalid, please type 'help' if you would like to know a list of valid commands.");
        }
        return isValid;
    }

}
