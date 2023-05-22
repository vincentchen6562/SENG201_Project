package src.items;

import src.team.*;

/**
 * The Item class represents an item in the game.
 */
public class Item {
    String itemType;
    protected String itemName;
    protected int itemBoost;
    private String boostType;
    protected int itemPrice;

    /**
     * Constructs an Item object.
     *
     * @param itemType the type of the item
     * @param name the name of the item
     * @param boost the boost value of the item
     * @param boostType the type of boost provided by the item
     * @param price the price of the item
     * @param isCoach indicates if the item is a coach item
     */
    public Item(String itemType, String name, int boost, String boostType, int price, Boolean isCoach) {
        this.itemType = itemType;
        this.itemName = name;
        this.itemBoost = boost;
        this.boostType = boostType;
        this.itemPrice = price;
    }

    /**
     * Retrieves the name of the item.
     *
     * @return the name of the item
     */
    public String getName() {
        return itemName;
    }

    /**
     * Retrieves the type of the item.
     *
     * @return the type of the item
     */
    public String getType() {
        return itemType;
    }

    /**
     * Retrieves the boost value of the item.
     *
     * @return the boost value of the item
     */
    public int getBoost() {
        return itemBoost;
    }

    /**
     * Sets the boost type of the item.
     *
     * @param boostType the boost type to be set
     */
    public void setBoostType(String boostType) {
        this.boostType = boostType;
    }

    /**
     * Retrieves the boost type of the item.
     *
     * @return the boost type of the item
     */
    public String getBoostType() {
        return boostType;
    }

    /**
     * Retrieves the cost of the item.
     *
     * @return the cost of the item
     */
    public int getCost() {
        return itemPrice;
    }

    /**
     * Retrieves the information about the item.
     *
     * @return the information about the item
     */
    public String info() {
        return new String("This is " + itemName + " and it costs " + itemPrice + "." + "\n" + "This gives " + itemBoost
                + " boost.");
    }

    /**
     * Checks if the item is a coach item.
     *
     * @return true if the item is a coach item, false otherwise
     */
    public Boolean getIsCoach() {
        if (itemType.equals("Coach")) {
            return true;
        } else {
            return false;
        }
    }
}
