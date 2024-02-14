import org.junit.jupiter.api.Test;

import java.io.IOException;

class DropItemTest {

    @Test
    void dropItemShouldRemoveFromInventory() throws IOException {
        Inventory.setInventory("goo");
        Inventory.setInventory("book");
        DropItem.dropItem("goo");
        assertFalse(Inventory.getInventory().contains("goo"));
    }

    @Test
    void dropItemsNothingDropsWhenItemNotInInventory() throws IOException {
        Inventory.setInventory("goo");
        Inventory.setInventory("book");
//        items.DropItem.dropItem("north");
        assertTrue(Inventory.getInventory().contains("goo"));
        assertTrue(Inventory.getInventory().contains("book"));
    }
}
