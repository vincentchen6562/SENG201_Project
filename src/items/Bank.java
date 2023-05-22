package src.items;

/**
 * The Bank class represents a bank account used for managing money.
 */
public class Bank {
    private int money;

    /**
     * Constructs a Bank object with the specified starting money.
     *
     * @param startingMoney the starting money for the bank account
     */
    public Bank(int startingMoney) {
        this.money = startingMoney;
    }

    /**
     * Retrieves the current amount of money in the bank account.
     *
     * @return the current amount of money
     */
    public int getMoney() {
        return money;
    }

    /**
     * Increases or decreases the amount of money in the bank account by the specified amount.
     *
     * @param amount the amount of money to be added (positive) or subtracted (negative)
     */
    public void alterMoney(int amount) {
        money += amount;
    }

    /**
     * Decreases the amount of money in the bank account by the specified amount.
     *
     * @param amount the amount of money to be subtracted
     */
    public void decreaseMoney(int amount) {
        money -= amount;
    }
}
