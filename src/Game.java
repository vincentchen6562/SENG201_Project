package src;

public class Game {
    private int seasonNumber;
    private int weekNumber;

    public Game(int seasonNumber, int weekNumber) {
        this.seasonNumber = seasonNumber;
        this.weekNumber = weekNumber;
       
    }

    public void setSeason(int seasonNum) { 
        seasonNumber = seasonNum;
    }

    public void incrementSeason() {
        seasonNumber += 1;
    }

    public int getSeason() {
        return seasonNumber;
    }

    public void setWeekN(int week) {
        weekNumber = week;
    }

    public void incrementWeek() {
        weekNumber += 1;
    }

    public int getWeek() {
        return weekNumber;
    }
    

    

}

// TODO:
// - Need to update the UML diagram (classes added: Item, Coach, Equipment)
// - Need to implement behaviors in this class's run function when a certain
// button (a GameEnvironment class is needed to store the logic of the game)
// is clicked, e.g. when the player purchases an athlete, the Team class adds an
// athlete, the athlete is removed from the market, the bank variable in
// inventory
// is accordingly decreased.
// - Need to restructure the packages since it is assessed
// - Need to comment properly (for Javadoc and final assessment), this includes
// the GUI classes, REMEMBER: no commented out code
// JUnit testing
// Javadoc
// DONE
