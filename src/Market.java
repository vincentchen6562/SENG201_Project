import java.util.ArrayList;

public class Market {
    private ArrayList<Item> allItems;
    private ArrayList<Athlete> allAthletes;

    public void generateItemShop(Difficulty difficulty, int seasonNumber) {
        // potentially need a stream function to generate items
    }

    public void generateAthleteShop(Difficulty difficulty, int seasonNumber) {
        // use a similar method as above to generate athlete objects
    }

    public void removeAthlete(Athlete athlete) {
        allAthletes.remove(athlete);
    }

    public void removeItem(Item item) {
        allItems.remove(item);
    }
    
}


