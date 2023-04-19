import java.util.*;

public class Inventory {
    private int numberOfItems;
    private int money;
    private ArrayList<Coach> coachList;

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public String getCoachName() { // could potentially require parameters that specify the name of the desired
                                   // item
        return coach.getName();
    }

    public int getEquipmentBoost() {
        return equipment.boost;
    }

    public void setMoney(int amount) {
        money = amount;
    }

    public int getMoney() {
        return money;
    }

}
