import java.util.*;

public class Inventory {
    private int numberOfItems;
    private int money;
    private ArrayList<Item> itemList;

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public int getItemBoost() {
        return equipment.boost;
    }

    public void setMoney(int amount) {
        money = amount;
    }

    public int getMoney() {
        return money;
    }

}

// could potentially require parameters (getName) that specify the type of the
// desired
// item