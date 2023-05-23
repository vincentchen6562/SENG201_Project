package src.items;

import src.*;
import java.util.ArrayList;

/**
 * The Inventory class represents a collection of items.
 */
public class Inventory {
    private ArrayList<Item> itemList;

    /**
     * Constructs an Inventory object.
     *
     * @param difficulty the difficulty level that determines the starting amount of
     *                   money
     */
    public Inventory(Difficulty difficulty) {
        itemList = new ArrayList<Item>();
    }

    /**
     * Retrieves the number of items in the inventory.
     *
     * @return the number of items in the inventory
     */
    public int getNumberOfItems() {
        return itemList.size();
    }

    /**
     * Retrieves the names of all the items in the inventory.
     *
     * @return a list of names of all the items in the inventory
     */
    public ArrayList<String> getAllItems() {
        ArrayList<String> allItemNames = new ArrayList<String>();
        for (Item item : itemList) {
            allItemNames.add(item.getName());
        }
        return allItemNames;
    }

    /**
     * Adds an item to the inventory.
     *
     * @param item the item to be added
     */
    public void addItem(Item item) {
        if (itemList.contains(item)) {
            System.out.println("Item has already been added");
        } else {
            itemList.add(item);
        }
    }
}
