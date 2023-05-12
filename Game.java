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


// TODO
// - Need to determine how the player can win or lose a game
// - Need to update the UML diagram (classes added: Item, Coach, Equipment)
// - Need to add price to Athlete. Potential solution: add athlete into item class?

