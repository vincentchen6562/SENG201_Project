package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Match;
import src.team.Athlete;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MatchTest {
    private Match match;

    @BeforeEach
    public void setUp() {
        match = new Match(100, 500, 50);
    }

    @Test
    public void testGetTotalScore() {
        int totalScore = match.getTotalScore();
        Assertions.assertEquals(100, totalScore);
    }

    @Test
    public void testGetPlayerScore() {
        int playerScore = match.getPlayerScore();
        Assertions.assertEquals(0, playerScore);
    }

    @Test
    public void testIncrementPlayerScore() {
        match.incrementPlayerScore(50);
        int playerScore = match.getPlayerScore();
        Assertions.assertEquals(50, playerScore);
    }

    @Test
    public void testGetOppScore() {
        int oppScore = match.getOppScore();
        Assertions.assertEquals(0, oppScore);
    }

    @Test
    public void testGetReward() {
        int reward = match.getReward();
        Assertions.assertEquals(500, reward);
    }

    @Test
    public void testGetValue() {
        int value = match.getValue();
        Assertions.assertEquals(50, value);
    }

    @Test
    public void testIncrementOppScore() {
        match.incrementOppScore(30);
        int oppScore = match.getOppScore();
        Assertions.assertEquals(30, oppScore);
    }

    @Test
    public void testResultMessage_Win() {
        match.incrementPlayerScore(60);
        String result = match.resultMessage();
        Assertions.assertEquals("Congratulations, you have won the game!", result);
    }

    @Test
    public void testResultMessage_Loss() {
        match.incrementOppScore(60);
        String result = match.resultMessage();
        Assertions.assertEquals("Better luck next time!", result);
    }

    @Test
    public void testGenerateOpponentTeamName() {
        ArrayList<String> nameList = new ArrayList<>(Arrays.asList("Team A", "Team B", "Team C", "Team D"));
        File file = new File("OpponentTName.txt");
        try (PrintStream out = new PrintStream(file)) {
            for (String name : nameList) {
                out.println(name);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String opponentTeamName = match.generateOpponentTeamName();
        Assertions.assertFalse(nameList.contains(opponentTeamName));

        // Clean up the file
        file.delete();
    }

    @Test
    public void testGetOpponentTNames() {
        ArrayList<String> nameList = new ArrayList<>(Arrays.asList("Team A", "Team B", "Team C", "Team D"));
        File file = new File("OpponentTName.txt");
        try (PrintStream out = new PrintStream(file)) {
            for (String name : nameList) {
                out.println(name);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> opponentTeamNames = match.getOpponentTNames();
        Assertions.assertEquals(4, opponentTeamNames.size());
        for (String name : opponentTeamNames) {
            Assertions.assertFalse(nameList.contains(name));
        }

        // Clean up the file
        file.delete();
    }
    
    @Test
    public void testGenerateOpponentAthletes() {
        List<String> athleteList = Arrays.asList(
                "Athlete A,80,70,90,80,Forward",
                "Athlete B,70,80,85,90,Guard",
                "Athlete C,90,60,70,85,Center"
        );
        File file = new File("OpponentAthletes.txt");
        try (PrintStream out = new PrintStream(file)) {
            for (String athlete : athleteList) {
                out.println(athlete);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        match.generateOpponentAthletes();
        ArrayList<Athlete> opponentAthletes = match.getOpponentAthletes();
        Assertions.assertEquals(5, opponentAthletes.size());

        // Clean up the file
        file.delete();
    }

    @Test
    public void testGetOpponentAthletes() {
        List<String> athleteList = Arrays.asList(
                "Athlete A,80,70,90,80,Forward",
                "Athlete B,70,80,85,90,Guard",
                "Athlete C,90,60,70,85,Center"
        );
        File file = new File("OpponentAthletes.txt");
        try (PrintStream out = new PrintStream(file)) {
            for (String athlete : athleteList) {
                out.println(athlete);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<Athlete> opponentAthletes = match.getOpponentAthletes();
        Assertions.assertEquals(5, opponentAthletes.size());

        // Clean up the file
        file.delete();
    }
}



