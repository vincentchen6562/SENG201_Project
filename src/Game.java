package src;

import src.team.*;
import src.items.*;

public class Game {
    private int weekNumber;
    private int currentWeek = 1;
    private Team team;
    private Bank bank;
    private Difficulty difficulty;
    private Match match;
    private int points;
    private Item coach;

    public Game(int weekNumber, Team team, Bank bank, Difficulty difficulty) {
        this.weekNumber = weekNumber;
        this.team = team;
        this.bank = bank;
        this.difficulty = difficulty;
        this.points = 0;
    }

    public void setWeekN(int week) {
        weekNumber = week;
    }

    public void incrementWeek() {
        currentWeek += 1;
    }

    public int getWeek() {
        return weekNumber;
    }

    public int getCurrentWeek() {
        return currentWeek;
    }

    public Bank getBank() {
        return bank;
    }

    public Team getTeam() {
        return team;
    }

    public Match getMatch() {
        return match;
    }

    public void alterPoints(int amount) {
        points += amount;
    }

    public int getPoints() {
        return points;
    }

    public void setCoach(Item coach) {
        this.coach = coach;
    }

    public Item getCoach() {
        return coach;
    }

    public Difficulty getDifficultyObject() {
        return difficulty;
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
// Difficulty/week scaling prices and difficulty of matches
// do README
// DONE
