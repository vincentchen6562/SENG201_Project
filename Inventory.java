import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> itemList;
    private int bank; // the amount of money the player currently holds

    public Inventory(int size, int initial_bank) { // size of inventory could depend on the difficulty
        itemList = new ArrayList<Item>(size);
        bank = initial_bank;
    }

    public int getNumberOfItems() {
        return itemList.size();
    }

    public ArrayList<Item> getAllItems() {
        return itemList;
    }

    public void addItem(Item item) { // need to add exception: cannot item when inventory is full
        itemList.add(item);
    }

    public int getBank() {
        return bank;
    }

}

// could potentially require parameters (getName) that specify the type of the
// desired
// item