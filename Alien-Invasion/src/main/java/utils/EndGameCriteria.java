package utils;

import app.AlienInvasionApp;
import com.sun.tools.javac.Main;
import gui.MainDisplay;
import models.Player;

import java.util.List;

public class EndGameCriteria {
    private static boolean droppedGas = false;

    public static String dropGas(Player player){
        String canDropGas = "I won... but died";
        String canDropGasAndLive = "I win... and lived!";
        List<String> inventory = player.getPlayerInventory();
        String location = player.getCurrentLocation();

        if (inventory.contains("toxic-gas")&& inventory.contains("vent-cover") && inventory.contains("gas-mask") && location.equals("Oxygen Vent Room")) {

            return canDropGas;
        }
        else if (inventory.contains("toxic-gas")&& inventory.contains("vent-cover") && location.equals("Oxygen Vent Room")) {

            return canDropGasAndLive;
        }
        return "false";
    }

    public static void poisonTheShip(String liveOrDie, Player player, MainDisplay mainDisplay) {
        if (liveOrDie.equals("I won... but died")) {
            player.setHealth(0);
            System.out.println("You drop the poisonous gas into the vent hole, and the ship rapidly fogs with gas. You choke on the toxic fumes and fall down with all of the Aliens. You've won, but at what cost.");
            setDroppedGas(true);
            player.setPlayerWon(true);
            mainDisplay.showEndGameDisplay();
        }
        else {
            System.out.println("You dump the poisonous gas into the vent hole, and the ship rapidly fogs with gas. The aliens all die");
            setDroppedGas(true);
            player.setPlayerWon(true);
            mainDisplay.showEndGameDisplay();
        }
    }

    public static boolean isDroppedGas() {
        return droppedGas;
    }

    public static void setDroppedGas(boolean droppedGas) {
        EndGameCriteria.droppedGas = droppedGas;
    }
}