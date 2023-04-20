public abstract class Item {
    protected String itemName;
    protected int itemBoost;
    protected int itemPrice;

    public abstract int getPrice();

    public Item(String name, int boost, int price) {
        name = itemName;
        boost = itemBoost;
        price = itemPrice;
    }

    public String getName() {
        return itemName;
    }

    public int getBoost() {
        return itemBoost;
    }

    public void info() {
        System.out.println("This is " + itemName + " and it costs " + itemPrice + ".");
    }

    public static void main(String[] args) {
        Item steve = new Coach("Steve Johnson", 60, 4000);
        steve.info();
    }
}
