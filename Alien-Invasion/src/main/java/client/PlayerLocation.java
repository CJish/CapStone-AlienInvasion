package client;

import gameEngines.JsonReader;
import models.Location;

// nested functions within class for encapsulation purposes
// also to ensure class has full control over how data is accessed/modified
public class PlayerLocation {


    public static void displayCurrentLocation(String locationName) {
        Location currentLocation = JsonReader.getLocationByName(locationName);
        if (currentLocation != null) {
            System.out.println(currentLocation.getDescription());
            System.out.println("items in this location: ");
            if (currentLocation.getItems().size() >= 1) {
                for (int i = 0; i < currentLocation.getItems().size(); i++) {
                    System.out.print(currentLocation.getItems().get(i));
                    if (i < currentLocation.getItems().size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            } else {
                System.out.println("There is nothing useful here \n");
            }
        }
    }

    public static void displayCurrentLocation(int x, int y) {
        Location currentLocation = JsonReader.getLocationByAxis(x, y);
        if (currentLocation != null) {
            System.out.println("** Current Location: " + currentLocation.getLocation() + " **");
            System.out.println("description: " + currentLocation.getDescription());
            System.out.println("coordinates: (" + currentLocation.getX() + ", " + currentLocation.getY() + ")");
        } else {
            System.out.println("No data found for current location");
        }
    }
}