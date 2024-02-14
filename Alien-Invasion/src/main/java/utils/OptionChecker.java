package utils;

import java.util.List;

public class OptionChecker {
    public static boolean itemAlreadyPresent(List<String> inventory,String itemToAdd) {
        for(String item : inventory) {
            if(item.equalsIgnoreCase(itemToAdd)) {
                return true;
            }
        }
        return false;
    }
}
