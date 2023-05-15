import java.util.ArrayList;

public class Market {
    private ArrayList<Item> itemsInMarket;
    private ArrayList<Athlete> athletesInMarket;

    public void generateItemShop(Difficulty difficulty, int seasonNumber) {
        // TODO: potentially need a stream function to generate items
    }

    public void generateAthleteShop(Difficulty difficulty, int seasonNumber) {
        // TODO: use a similar method as above to generate athlete objects
    }

    public void recruitAthlete(Athlete athlete) { // needs to include 3-5 athletes
        athletesInMarket.remove(athlete); // when running an instance of a game, the athlete needs to added to the team
    } 

    public void getitem(Item item) {
        itemsInMarket.remove(item); // same idea as the above method concerning the addition of items in the inventory
    }

}
