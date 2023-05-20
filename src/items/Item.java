package src.items;

public abstract class Item {
	String itemType;
    protected String itemName;
    protected int itemBoost;
    String boostType;
    protected int itemPrice;

    public abstract int getPrice();

    public Item(String name, int boost, int price) {
        itemName = name;
        itemBoost = boost;
        itemPrice = price;
    }

    public String getName() {
        return itemName;
    }

    public int getBoost() {
        return itemBoost;
    }

    public void info() {
        System.out.println("This is " + itemName + " and it costs " + itemPrice + "." + "\n" + "This gives " + itemBoost
                + " boost.");
    }

    // public static void main(String[] args) {
    // Item steve = new Coach("Steve Johnson", 60, 4000);
    // steve.info();
    // }
}
