import json.ItemsJSON;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GetItemsTest {

    @Test
    void isItemInteractactableShouldReturnTrue() {
        String getNote = "get note";
        GetItems.isItemInteractable(getNote);
//        System.out.println(items.GetItems.getInventory());
        String getGoo = "get goo";
        GetItems.isItemInteractable(getGoo);
        assertTrue(GetItems.isItemInteractable(getGoo));

//        System.out.println(items.GetItems.getInventory());
    }

    @Test
    void isItemInteractableShouldReturnFalse() {
        String getNothing = "get north";
        assertFalse(GetItems.isItemInteractable(getNothing));
    }

    @Test
    void isItemInteractactableShouldReturnTrueIfCoordinatesAre5000() {
        String getNote = "get note";
//        System.out.println(client.Movement.getX_Axis());
//        System.out.println(client.Movement.getY_Axis());
//        System.out.println(json.ItemsJSON.getCoordinates("note"));
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(5000);
        expected.add(5000);
        GetItems.isItemInteractable(getNote);
        System.out.println(Inventory.getInventory());
        assertEquals(expected, ItemsJSON.getCoordinates("note"));
//        System.out.println(items.GetItems.getInventory());
    }
}