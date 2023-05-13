import java.awt.EventQueue;

import javax.swing.JFrame;

public class Game {
    private int seasonNumber;
    private int weekNumber;
    private JFrame frame;

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
// - Need to determine how the player can win or lose a game
// - Need to update the UML diagram (classes added: Item, Coach, Equipment)
// - Need to implement behaviours in this class's run function when a certain
// button
// is clicked, e.g. when the player purchases an athlete, the Team class adds an
// athlete, the athlete is removed from the market, the bank variable in
// inventory
// is accordingly decreased.

// DONE
