public class Equipment extends Item {
    private int price;

    public Equipment(String name, int boost, int price) {
        super(name, boost, price);
    }

    public int getPrice() {
        return price;
    }

}
