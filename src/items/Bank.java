package src.items;

public class Bank {
    private int money;

    public Bank(int startingMoney) {
        this.money = startingMoney;
    }

    public int getMoney() {
        return money;
    }

    public void alterMoney(int amount) {
        money += amount;
    }

    public void decreaseMoney(int amount) {
        money -= amount;
    }
}
