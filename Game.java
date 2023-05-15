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
// - Need to add price to Athlete. Potential solutions: add athlete into item class, update the Athlete class


// IDEAS
// - Could win the game by assigning the athletes a number and opposing athletes with
//   with the same number compete against each other.
// - Point System:
//   * The number associated with the athletes indicate the order of importance deemed
//     by the player. If the most important player (i.e. player 1) wins, the team gains
//     5 points; for the second player, this decreases to 4 points and so on. The total
//     number of points is therefore 15 (for 5 athletes in a team). 
// - Winning a matchup:
//   * To win a mathup, an athlete must have a combined offensive and defensive stats
//     higher than that of their opponent. If this stat is the same however, stamina
//     determines the winner. (could make the statiscs scale lower to increase the
//     chance of this occurring)