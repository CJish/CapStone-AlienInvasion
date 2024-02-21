package Interfaces;

import java.util.List;

public interface ChangeListener {
    void onLocationChanged(String newLocation);

    void onInventoryChange(List<String> inventory);
}
