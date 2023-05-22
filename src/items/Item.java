package src.items;

public class Item { //abstract add back? removed bc couldnt construct in market
	String itemType;
    protected String itemName;
    protected int itemBoost;
    String boostType;
    protected int itemPrice;
//    public abstract int getPrice();

    public Item(String itemType, String name, int boost, String boostType, int price, Boolean isCoach) {
        this.itemType = itemType;
    	this.itemName = name;
        this.itemBoost = boost;
        this.boostType = boostType;
        this.itemPrice = price;
    }

    public String getName() {
        return itemName;
    }
    
    public String getType() {
    	return itemType;
    }

    public int getBoost() {
        return itemBoost;
    }
    
    public String getBoostType() {
    	return boostType;
    }
    
    public int getCost() {
    	return itemPrice;
    }

    public String info() {
        return new String ("This is " + itemName + " and it costs " + itemPrice + "." + "\n" + "This gives " + itemBoost
                + " boost.");
    }

    public Boolean getIsCoach() {
    	if (itemType == "Coach") {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    // public static void main(String[] args) {
    // Item steve = new Coach("Steve Johnson", 60, 4000);
    // steve.info();
    // }
}
