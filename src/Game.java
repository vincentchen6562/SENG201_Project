package src;

import src.team.*;
import src.items.*;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    private int weekNumber;
    private int currentWeek = 1;
    private Team team;
    private Bank bank;
    private Difficulty difficulty;
    private Match match;
    private int points;
    private Item coach;
    private int numWins;
    private int numLoss;

    
    /**
     * Constructs a Game object.
     *
     * @param weekNumber  The total number of weeks in the game.
     * @param team        The team object representing the player's team.
     * @param bank        The bank object representing the player's financial status.
     * @param difficulty  The difficulty level of the game.
     */
    public Game(int weekNumber, Team team, Bank bank, Difficulty difficulty) {
        this.weekNumber = weekNumber;
        this.team = team;
        this.bank = bank;
        this.difficulty = difficulty;
        this.points = 0;
    }

    /**
     * Sets the current week number.
     *
     * @param week The week number to set.
     */
    public void setWeekN(int week) {
        weekNumber = week;
    }

    /**
     * Increments the current week number.
     */
    public void incrementWeek() {
        currentWeek += 1;
    }

    /**
     * Returns the total number of weeks in the game.
     *
     * @return The total number of weeks in the game.
     */
    public int getWeek() {
        return weekNumber;
    }

    /**
     * Returns the current week number.
     *
     * @return The current week number.
     */
    public int getCurrentWeek() {
        return currentWeek;
    }

    /**
     * Returns the bank object representing the player's financial status.
     *
     * @return The bank object representing the player's financial status.
     */
    public Bank getBank() {
        return bank;
    }

    /**
     * Returns the team object representing the player's team.
     *
     * @return The team object representing the player's team.
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Returns the match object representing the current match.
     *
     * @return The match object representing the current match.
     */
    public Match getMatch() {
        return match;
    }

    /**
     * Alters the points by the specified amount.
     *
     * @param amount The amount to alter the points by.
     */
    public void alterPoints(int amount) {
        points += amount;
    }

    /**
     * Returns the current points.
     *
     * @return The current points.
     */
    public int getPoints() {
        return points;
    }

    /**
     * Sets the coach item.
     *
     * @param coach The coach item to set.
     */
    public void setCoach(Item coach) {
    	if (this.coach != null) {
    		removeCoach();
    	}
        this.coach = coach;
    	String boostType = coach.getBoostType();

        for (Athlete athlete: getTeam().getEquippedAthletes()) {
        	if (boostType.equals("Offence")){
            	athlete.alterStat("Offence", coach.getBoost());
        	} else if (boostType.equals("Defence")) {
        		athlete.alterStat("Defence", coach.getBoost());
        	} else if (boostType.equals("Agility")) {
        		athlete.alterStat("Agility", coach.getBoost());
        	} else if (boostType.equals("All")) {
        		athlete.alterStat("All", coach.getBoost());
	        }
	    }
        
        if (getTeam().getExcessAthlete() != null) {
	    	if (boostType.equals("Offence")){
	        	getTeam().getExcessAthlete().alterStat("Offence", coach.getBoost());
	    	} else if (boostType.equals("Defence")) {
	    		getTeam().getExcessAthlete().alterStat("Defence", coach.getBoost());
	    	} else if (boostType.equals("Agility")) {
	    		getTeam().getExcessAthlete().alterStat("Agility", coach.getBoost());
	    	} else if (boostType.equals("All")) {
	    		getTeam().getExcessAthlete().alterStat("All", coach.getBoost());
	    	}
        }
    }
    /**
     * sets coach to null
     * removes appropriate amount of points from each athlete
     */
    public void removeCoach() {
    	String boostType = coach.getBoostType();

        for (Athlete athlete: getTeam().getEquippedAthletes()) {
        	if (boostType.equals("Offence")){
            	athlete.alterStat("Offence", -coach.getBoost());
        	} else if (boostType.equals("Defence")) {
        		athlete.alterStat("Defence", -coach.getBoost());
        	} else if (boostType.equals("Agility")) {
        		athlete.alterStat("Agility", -coach.getBoost());
        	} else if (boostType.equals("All")) {
        		athlete.alterStat("All", -coach.getBoost());
	        }
	    }
        
        if (getTeam().getExcessAthlete() != null) {
	    	if (boostType.equals("Offence")){
	        	getTeam().getExcessAthlete().alterStat("Offence", -coach.getBoost());
	    	} else if (boostType.equals("Defence")) {
	    		getTeam().getExcessAthlete().alterStat("Defence", -coach.getBoost());
	    	} else if (boostType.equals("Agility")) {
	    		getTeam().getExcessAthlete().alterStat("Agility", -coach.getBoost());
	    	} else if (boostType.equals("All")) {
	    		getTeam().getExcessAthlete().alterStat("All", -coach.getBoost());
	    	}
        }
    }
    /**
     * Returns the coach item.
     *
     * @return The coach item.
     */
    public Item getCoach() {
        return coach;
    }

    /**
     * Returns the Difficulty object representing the game difficulty.
     *
     * @return The Difficulty object representing the game difficulty.
     */
    public Difficulty getDifficultyObject() {
        return difficulty;
    }

    /**
     * Generates a reward pool based on the game difficulty.
     *
     * @param difficulty The game difficulty.
     * @return An ArrayList of integers representing the reward pool.
     */
    public ArrayList<Integer> generateRewardPool(Difficulty difficulty) {
        ArrayList<Integer> rewardPool = new ArrayList<>();
        Random rng = new Random();

        int randInt = 0;

        while (rewardPool.size() < 4) {

            if (difficulty.getDifficulty() == "Hard") {
                randInt = rng.nextInt(100, 600);
            } else {
                randInt = rng.nextInt(500, 1000);
            }

            rewardPool.add(randInt);
        }

        return rewardPool;
    }

    /**
     * Prints the result of a match based on the player's score and the opponent's score.
     *
     * @param playerScore   The player's score.
     * @param opponentScore The opponent's score.
     * @return A string representing the match result.
     */
    public String printResult(int playerScore, int opponentScore) {

        String msg = new String();
        if (playerScore > opponentScore) {
            msg = "YOU WON!";
        } else {
            if (playerScore == opponentScore) {
                msg = "DRAW";
            } else {
                msg = "YOU LOST!";
            }
        }

        return msg;
    }

    /**
     * Increments the number of wins.
     */
    public void incrementWins() {
        numWins += 1;
    }

    /**
     * Returns the number of wins.
     *
     * @return The number of wins.
     */
    public int getWins() {
        return numWins;
    }

    /**
     * Increments the number of losses.
     */
    public void incrementLoss() {
        numLoss += 1;
    }

    /**
     * Returns the number of losses.
     *
     * @return The number of losses.
     */
    public int getLosses() {
        return numLoss;
    }

}

// TODO:
// - Need to update the UML diagram (classes added: Item, Coach, Equipment)
// - Need to restructure the packages since it is assessed
// - Need to comment properly (for Javadoc and final assessment), this includes
// the GUI classes, REMEMBER: no commented out code
// JUnit testing
// Javadoc
// Difficulty/week scaling prices and difficulty of matches
// do README
// populate item and athlete lists more
// DONE

// - fix up the money below zero and still training problem in the rest page
// - properly implement stamina
