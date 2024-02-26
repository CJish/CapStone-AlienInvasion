package models;

import Interfaces.ChangeListener;
import gameEngines.JsonWriter;
import utils.OptionChecker;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<ChangeListener> changeListeners = new ArrayList<>();

    // these are used for the player's current location
    // starting location is set in AlienInvasionApp
    private int x; // player's location
    private int y; // player's location
    private String currentLocation;
    private List<String> playerInventory = new ArrayList<>();
    private int health;
    private boolean playerWon;

    public Player() {
    }

    public void addChangeListener(ChangeListener listener) {
        this.changeListeners.add(listener);
    }

    private void notifyChangeListeners() {
        for (ChangeListener listener : changeListeners) {
            listener.onChange();
        }
    }

    // Methods
    public void addItemToInventory(String item) {
        if (!OptionChecker.itemAlreadyPresent(playerInventory, item)) {
            playerInventory.add(item);
            JsonWriter.modifyLocation(currentLocation, item, false);
            notifyChangeListeners();
        } else {
            System.out.println("You already have this item");
        }

    }

    public void removeItemFromInventory(String item) {
        if (!OptionChecker.itemAlreadyPresent(playerInventory, item)) {
            System.out.println("You cant drop an item you dont have silly");
        } else {
            playerInventory.remove(item);
            JsonWriter.modifyLocation(currentLocation, item, true);
            notifyChangeListeners();
        }
    }

    // Getters and Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        System.out.println(getX() + " " + getY());
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        System.out.println(getX() + " " + getY());
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
            this.currentLocation = currentLocation;
            notifyChangeListeners();
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

    public boolean isPlayerWon() {
        return playerWon;
    }

    public void setPlayerWon(boolean playerWon) {
        this.playerWon = playerWon;
    }
}