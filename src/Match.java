package src;

import src.team.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class Match {
    private int scoreTotal;
    private int priceMoney;
    private int pointsWorth;
    private int playerScore;
    private int opponentScore;
    private ArrayList<Athlete> opposingAthletes;

    public Match(int totalScore, int reward, int points) {
        scoreTotal = totalScore;
        priceMoney = reward;
        pointsWorth = points; // difference you win by from match // this indicates how much points a match is
                              // worth depending on the stats of the
                              // opponents
    }

    public int getTotalScore() {
        return scoreTotal;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void incrementPlayerScore(int score) {
        playerScore += score;
    }

    public int getOppScore() {
        return opponentScore;
    }

    public int getReward() {
        return priceMoney;
    }

    public int getValue() {
        return pointsWorth;
    }

    public void incrementOppScore(int score) {
        opponentScore += score;
    }

    public String resultMessage() {
        if (playerScore > opponentScore) {
            return "Congratulations, you have won the game!";
        } else {
            return "Better luck next time!";
        }
    }

    public String generateOpponentTeamName() {

        ArrayList<String> nameList = new ArrayList<>();

        try {
            File OppTeamNamesList = new File(
                    "src/OpponentTName.txt");
            Scanner OppTeamNames = new Scanner(OppTeamNamesList);

            while (OppTeamNames.hasNextLine()) {
                nameList.add(OppTeamNames.nextLine());
            }

            OppTeamNames.close();

            Random rng = new Random(); // need to put seed here (e.g. 201) for randomness testing
            int randInt = rng.nextInt(1, 20);
            return nameList.get(randInt);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Random rng = new Random(); // need to put seed here (e.g. 201) for randomness testing
        int randInt = rng.nextInt(1, 20);
        return nameList.get(randInt);
    }

    public ArrayList<String> getOpponentTNames() {
        ArrayList<String> names = new ArrayList<>();

        while (names.size() < 4) {
            String name = generateOpponentTeamName();

            if (names.contains(name)) {
            } else {
                names.add(name);
            }

        }

        return names;
    }

    /*
     * A method that gets the athletes in a text file and put them in an array list
     */
    public void generateOpponentAthletes() {
        try {

            File athleteList = new File(
                    "src/OpponentAthletes.txt");
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

                Athlete newAthlete = new Athlete(name, position, stamina, false, offence, defence, agility,
                        0);

                allAthletes.add(newAthlete);

            }

            ArrayList<Athlete> generatedAthletes = new ArrayList<Athlete>();

            while (generatedAthletes.size() < 5) {
                Random rng = new Random();
                int randInt = rng.nextInt(1, 20);
                Athlete athlete = allAthletes.get(randInt);

                if (generatedAthletes.contains(athlete)) {

                } else {
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

    public ArrayList<String> getOpponentAthletes() {

        generateOpponentAthletes();
        ArrayList<String> athleteNames = new ArrayList<>(20);

        for (Athlete athlete : opposingAthletes) {
            athleteNames.add(athlete.getFullName());
        }

        return athleteNames;
    }

}
