package models;

import java.util.ArrayList;
import java.util.List;

public class Location {
   private int x;
   private int y;
   private String location; // location name
   private String description;
   private List<String> items = new ArrayList<>();
   private List<String> characters = new ArrayList<>();

    public Location() {}

    public Location(String location, String description, int xValue, int yValue) {
        this.location = location;
        this.description = description;
        this.x = xValue;
        this.y = yValue;
    }

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }
}
