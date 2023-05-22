package src;

import src.team.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

/**
 * The `Match` class represents a match between the player's team and an opponent team.
 * It tracks the scores, rewards, and opponent team information.
 */
public class Match {
    private int scoreTotal;
    private int priceMoney;
    private int pointsWorth;
    private int playerScore;
    private int opponentScore;
    private ArrayList<Athlete> opposingAthletes;

    /**
     * Constructs a `Match` object with the given total score, reward, and points worth.
     *
     * @param totalScore the total score of the match
     * @param reward     the reward amount for winning the match
     * @param points     the points worth of the match based on the opponents' stats
     */
    public Match(int totalScore, int reward, int points) {
        scoreTotal = totalScore;
        priceMoney = reward;
        pointsWorth = points;
    }

    /**
     * Returns the total score of the match.
     *
     * @return the total score of the match
     */
    public int getTotalScore() {
        return scoreTotal;
    }

    /**
     * Returns the player's score in the match.
     *
     * @return the player's score in the match
     */
    public int getPlayerScore() {
        return playerScore;
    }

    /**
     * Increments the player's score by the specified amount.
     *
     * @param score the amount to increment the player's score by
     */
    public void incrementPlayerScore(int score) {
        playerScore += score;
    }

    /**
     * Returns the opponent's score in the match.
     *
     * @return the opponent's score in the match
     */
    public int getOppScore() {
        return opponentScore;
    }

    /**
     * Returns the reward amount for winning the match.
     *
     * @return the reward amount for winning the match
     */
    public int getReward() {
        return priceMoney;
    }

    /**
     * Returns the points worth of the match based on the opponents' stats.
     *
     * @return the points worth of the match
     */
    public int getValue() {
        return pointsWorth;
    }

    /**
     * Increments the opponent's score by the specified amount.
     *
     * @param score the amount to increment the opponent's score by
     */
    public void incrementOppScore(int score) {
        opponentScore += score;
    }

    /**
     * Generates and returns the result message based on the player's and opponent's scores.
     *
     * @return the result message of the match
     */
    public String resultMessage() {
        if (playerScore > opponentScore) {
            return "Congratulations, you have won the game!";
        } else {
            return "Better luck next time!";
        }
    }
    /**
     * Generates a random opponent team name from a list of names.
     *
     * @return a randomly generated opponent team name
     */
    public String generateOpponentTeamName() {
        ArrayList<String> nameList = new ArrayList<>();

        try {
            File OppTeamNamesList = new File("src/OpponentTName.txt");
            Scanner OppTeamNames = new Scanner(OppTeamNamesList);

            while (OppTeamNames.hasNextLine()) {
                nameList.add(OppTeamNames.nextLine());
            }

            OppTeamNames.close();

            Random rng = new Random();
            int randInt = rng.nextInt(1, 20);
            return nameList.get(randInt);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Random rng = new Random();
        int randInt = rng.nextInt(1, 20);
        return nameList.get(randInt);
    }

    /**
     * Generates and returns a list of unique opponent team names.
     *
     * @return a list of unique opponent team names
     */
    public ArrayList<String> getOpponentTNames() {
        ArrayList<String> names = new ArrayList<>();

        while (names.size() < 4) {
            String name = generateOpponentTeamName();

            if (!names.contains(name)) {
                names.add(name);
            }
        }

        return names;
    }

    /**
     * Reads the opponent athletes' information from a text file and generates the opponent athletes.
     */
    public void generateOpponentAthletes() {
        try {
            File athleteList = new File("src/OpponentAthletes.txt");
            Scanner athletes = new Scanner(athleteList);
            athletes.useDelimiter(",");
            ArrayList<String> idList = new ArrayList<>();

            while (athletes.hasNextLine()) {
                idList.add(athletes.nextLine());
            }

            ArrayList<Athlete> allAthletes = new ArrayList<Athlete>();

            for (int i = 0; i < idList.size(); i++) {
                String info = idList.get(i);
                String[] s2 = info.split(",");

                String name = s2[0];
                int offence = Integer.parseInt(s2[1]);
                int defence = Integer.parseInt(s2[2]);
                int agility = Integer.parseInt(s2[3]);
                int stamina = Integer.parseInt(s2[4]);
                String position = s2[5];

                Athlete newAthlete = new Athlete(name, position, stamina, false, offence, defence, agility, 0);

                allAthletes.add(newAthlete);
            }

            ArrayList<Athlete> generatedAthletes = new ArrayList<Athlete>();

            while (generatedAthletes.size() < 5) {
                Random rng = new Random();
                int randInt = rng.nextInt(1, 20);
                Athlete athlete = allAthletes.get(randInt);

                if (!generatedAthletes.contains(athlete)) {
                    generatedAthletes.add(athlete);
                }
            }

            athletes.close();
            opposingAthletes = generatedAthletes;

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Returns the opponent athletes for the match.
     *
     * @return the opponent athletes
     */
    public ArrayList<Athlete> getOpponentAthletes() {
        generateOpponentAthletes();
        return opposingAthletes;
    }
}
