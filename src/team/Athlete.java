package src.team;

import java.util.ArrayList;

import src.items.Item;
/**
 * The Athlete class represents a player in the team. It extends the Statistics class and provides methods and attributes
 * for managing the athlete's information, such as name, position, stamina, injuries, value, and equipped items.
 */
public class Athlete extends Statistics {
    private String name;
    private String nickName = "";
    private String position;
    private int stamina;
    private int maxStamina;
    private boolean isInjured;
    private int value;
    private ArrayList<Item> equippedItems;

    /**
     * Constructs an Athlete object.
     *
     * @param name       The name of the athlete.
     * @param position   The position of the athlete.
     * @param stamina    The current stamina of the athlete.
     * @param isInjured  The injury status of the athlete.
     * @param offence    The offensive statistic of the athlete.
     * @param defence    The defensive statistic of the athlete.
     * @param agility    The agility statistic of the athlete.
     * @param price      The value of the athlete.
     */
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

      /**
   * Returns the full name of the athlete, including their nickname (if any).
   *
   * @return The full name of the athlete.
   */
    public String getFullName() {
        return name + " " + nickName + "";
    }

    /**
     * Returns the position of the athlete.
     *
     * @return The position of the athlete.
     */
    public String getPosition() {
        return position;
    }

    /**
     * Returns the current stamina of the athlete.
     *
     * @return The current stamina of the athlete.
     */
    public int getStamina() {
        return stamina;
    }

    /**
     * Modifies the stamina of the athlete by the specified amount.
     *
     * @param amount The amount to change the stamina by.
     */
    public void changeStamina(int amount) {
        stamina += amount;
    }

    /**
     * Sets the injury status of the athlete.
     *
     * @param state The injury status to set.
     */
    public void setIsInjured(boolean state) { // need to set a random chance of this occurring
        isInjured = state;
    }

    /**
     * Returns the injury status of the athlete.
     *
     * @return The injury status of the athlete.
     */
    public boolean getIsInjured() {
        return isInjured;
    }
  /**
   * Sets the nickname of the athlete.
   *
   * @param name The nickname to set.
   */
    public void setNickName(String name) { // this allows the player to give an athlete a nickname
        nickName = name;
    }

  /**
   * Returns the value of the athlete.
   *
   * @return The value of the athlete.
   */
    public int getValue() {
        return value;
    }
    
    /**
     * Returns the maximum stamina of the athlete.
     *
     * @return The maximum stamina of the athlete.
     */
    public int getMaxStamina() {
    	return maxStamina;
    }
    
    /**
   * Equips the specified item to the athlete.
   *
   * @param item The item to be equipped.
   */
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
    
  /**
   * Returns the list of items equipped by the athlete.
   *
   * @return The list of items equipped by the athlete.
   */
    public ArrayList<Item> getEquippedItems(){
    	return equippedItems;
    }

    // public void train(Athlete athlete, String stat, int days) {
    // for (int i = 0; i < days; i++) {
    // Athlete = super.alterStat(stat, 10);
    // }
    // }
}
