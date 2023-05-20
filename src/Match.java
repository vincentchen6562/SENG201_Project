package src;
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

    public Match(int totalScore, int reward, int points) {
        scoreTotal = totalScore;
        priceMoney = reward;
        pointsWorth = points; //difference you win by from match // this indicates how much points a match is worth depending on the stats of the
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

        while(names.size() < 4) {
            String name = generateOpponentTeamName();

            if(names.contains(name)){
            } else {
                names.add(name);
            }
            
        }

        return names;
    }

    // public static void main(String[] args) {
    //     Match match1 = new Match(10, 500, 6);
    //     System.out.println(match1.getOpponentTNames());
    // }


}
