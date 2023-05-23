package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.Difficulty;
import src.items.Inventory;
import src.items.Item;

import java.util.ArrayList;

public class InventoryTest {
    private Inventory inventory;

    @BeforeEach
    public void setUp() {
        inventory = new Inventory(null);
    }

    @Test
    public void testGetNumberOfItems_EmptyInventory() {
        int numberOfItems = inventory.getNumberOfItems();
        Assertions.assertEquals(0, numberOfItems);
    }

    @Test
    public void testGetAllItems_EmptyInventory() {
        ArrayList<String> allItems = inventory.getAllItems();
        Assertions.assertEquals(0, allItems.size());
    }

    @Test
    public void testAddItem() {
        Item item = new Item("Equipment", "Sword", 50, "Attack", 150);
        inventory.addItem(item);
        int numberOfItems = inventory.getNumberOfItems();
        ArrayList<String> allItems = inventory.getAllItems();

        Assertions.assertEquals(1, numberOfItems);
        Assertions.assertEquals(1, allItems.size());
        Assertions.assertEquals("Sword", allItems.get(0));
   
    }
    
    @Test
    public void testAddItem_DuplicateItem() {
        Item item = new Item("Equipment", "Sword", 50, "Attack", 150);
        inventory.addItem(item);

        // Attempt to add the same item again
        inventory.addItem(item);
        int numberOfItems = inventory.getNumberOfItems();
        ArrayList<String> allItems = inventory.getAllItems();

        Assertions.assertEquals(1, numberOfItems);
        Assertions.assertEquals(1, allItems.size());
        Assertions.assertEquals("Sword", allItems.get(0));
    }
}

