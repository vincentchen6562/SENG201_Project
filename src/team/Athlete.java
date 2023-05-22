package src.team;

import java.util.ArrayList;

import src.items.Item;

public class Athlete extends Statistics {
    private String name;
    private String nickName = "";
    private String position;
    private int stamina;
    private int maxStamina;
    private boolean isInjured;
    private int value;
    private ArrayList<Item> equippedItems;

    public Athlete(String name, String position, int stamina, boolean isInjured, int offence, int defence,
            int agility, int price) {
        super(offence, defence, agility);
        this.name = name;
        this.position = position;
        this.stamina = stamina;
        this.maxStamina = stamina;
        this.isInjured = isInjured;
        this.value = price;
        this.equippedItems = new ArrayList<Item>();
    }

    public String getFullName() {
        return name + " " + nickName + "";
    }

    public String getPosition() {
        return position;
    }

    public int getStamina() {
        return stamina;
    }

    public void changeStamina(int amount) {
        stamina += amount;
    }

    public void setIsInjured(boolean state) { // need to set a random chance of this occurring
        isInjured = state;
    }

    public void setNickName(String name) { // this allows the player to give an athlete a nickname
        nickName = name;
    }

    public boolean getIsInjured() {
        return isInjured;
    }

    public int getValue() {
        return value;
    }
    
    public int getMaxStamina() {
    	return maxStamina;
    }
    
    public void equipItem(Item item) {
    	equippedItems.add(item);
    	String boostType = item.getBoostType();
    	if (boostType.equals("Offence")){
        	alterStat("Offence", item.getBoost());
    	} else if (boostType.equals("Defence")) {
    		alterStat("Defence", item.getBoost());
    	} else if (boostType.equals("Agility")) {
    		alterStat("Agility", item.getBoost());
    	} else if (boostType.equals("All")) {
    		alterStat("All", item.getBoost());
    	}
    }
    
    public ArrayList<Item> getEquippedItems(){
    	return equippedItems;
    }

    // public void train(Athlete athlete, String stat, int days) {
    // for (int i = 0; i < days; i++) {
    // Athlete = super.alterStat(stat, 10);
    // }
    // }
}
