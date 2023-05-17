package src.items;

public class Bank {
	private int money;
	
	public Bank() {
	}
	
    public int getBank() {
        return money;
    }
    
    public void pay(int amount) {
        money -= amount;
    }

    public void receive(int amount) {
        money += amount;
    }
}
