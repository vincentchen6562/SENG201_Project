import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> itemList;
    private int bank; // the amount of money the player currently holds

    public Inventory(Difficulty difficulty) { // the starting amount of money depends on the difficulty
        itemList = new ArrayList<Item>();
        if (difficulty.getDifficulty() == "Hard") {
            bank = 1000;
        } else {
            bank = 5000;
        }
    }

    public int getNumberOfItems() {
        return itemList.size();
    }

    public ArrayList<String> getAllItems() { // returns the given given parameter of all of the items in the list
        ArrayList<String> allItemNames = new ArrayList<String>();
        for (Item item : itemList) {
            allItemNames.add(item.getName());
        }
        return allItemNames;
    }

    public void addItem(Item item) { // need to add exception: cannot add the same item more than once
        if(itemList.contains(item)) {
            System.out.println("Item has already been added");
        } else {
            itemList.add(item);
        }
       
    }

    public int getBank() {
        return bank;
    }

    public void pay(int amount) {
        bank -= amount;
    }

    public void receive(int amount) {
        bank += amount;
    }

//     public static void main(String[] args) {
//         Difficulty diff = new Difficulty("Hard");
//         Inventory inventory = new Inventory(diff);
//         Item Steve = new Coach("Steve Johnson", 60, 4000);
//         inventory.addItem(Steve);
//         System.out.println("The inventory currently has items " + inventory.getAllItems() + 
//         ". and inventory currently has " + inventory.getNumberOfItems() + " items");
//     }

}