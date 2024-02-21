package models;

import Interfaces.ChangeListener;
import gameEngines.JsonWriter;
import utils.OptionChecker;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private ChangeListener changeListener;
    private int x;
    private int y;
    private String currentLocation;
    private List<String> playerInventory = new ArrayList<>();
    private int health;

    public Player() {}

    public void setChangeListener(ChangeListener listener) {
        this.changeListener = listener;
    }

    // Methods
    public void addItemToInventory(String item) {
        if (!OptionChecker.itemAlreadyPresent(playerInventory, item)) {
            playerInventory.add(item);
            JsonWriter.modifyLocation(currentLocation,item,false);
            if (changeListener != null) {
                changeListener.onInventoryChange(playerInventory);
            }
        } else {
            System.out.println("You already have this item");
        }

    }

    public void removeItemFromInventory(String item) {
        if(!OptionChecker.itemAlreadyPresent(playerInventory, item)) {
            System.out.println("You cant drop an item you dont have silly");
        } else {
            playerInventory.remove(item);
            JsonWriter.modifyLocation(currentLocation,item,true);
            if (changeListener != null) {
                changeListener.onInventoryChange(playerInventory);
            }
        }
    }

    // Getters and Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
        if (changeListener != null) {
            changeListener.onLocationChanged(currentLocation);
        }
    }

    public List<String> getPlayerInventory() {
        return playerInventory;
    }

    public void setPlayerInventory(List<String> playerInventory) {
        this.playerInventory = playerInventory;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}