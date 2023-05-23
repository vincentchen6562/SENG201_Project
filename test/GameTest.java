package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Difficulty;
import src.Game;
import src.items.*;
import src.team.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameTest {

    private Game game;
    private Team team;
    private Bank bank;
    private Difficulty difficulty;

    @BeforeEach
    public void setup() {
        // Create a new instance of Game for each test
        team = new Team("Team A", new ArrayList<>());
        bank = new Bank(0);
        difficulty = new Difficulty("Easy");
        game = new Game(10, team, bank, difficulty);
    }

    @Test
    public void testGetWeek() {
        int week = game.getWeek();
        Assertions.assertEquals(10, week);
    }

    @Test
    public void testGetCurrentWeek() {
        int currentWeek = game.getCurrentWeek();
        Assertions.assertEquals(1, currentWeek);
    }

    @Test
    public void testGetBank() {
        Bank gameBank = game.getBank();
        Assertions.assertEquals(bank, gameBank);
    }

    @Test
    public void testGetTeam() {
        Team gameTeam = game.getTeam();
        Assertions.assertEquals(team, gameTeam);
    }

    @Test
    public void testGetDifficultyObject() {
        Difficulty gameDifficulty = game.getDifficultyObject();
        Assertions.assertEquals(difficulty, gameDifficulty);
    }

    @Test
    public void testIncrementWeek() {
        game.incrementWeek();
        int currentWeek = game.getCurrentWeek();
        Assertions.assertEquals(2, currentWeek);
    }

    @Test
    public void testAlterPoints() {
        game.alterPoints(100);
        int points = game.getPoints();
        Assertions.assertEquals(100, points);
    }

    @Test
    public void testSetAndGetCoach() {
        Item coach = new Item("Coach", "Jenkins", 5, "Offence", 0);
        game.setCoach(coach);
        Item gameCoach = game.getCoach();
        Assertions.assertEquals(coach, gameCoach);
    }

    @Test
    public void testRemoveCoach() {
        Item coach = new Item("Coach", "Jenkins", 5, "Offence", 0);
        game.setCoach(coach);
        game.removeCoach();
        Assertions.assertNull(game.getCoach());
    }

    @Test
    public void testGenerateRewardPool() {
        Difficulty difficulty = new Difficulty("Hard");
        ArrayList<Integer> rewardPool = game.generateRewardPool(difficulty);

        // Verify that the reward pool has 4 elements
        Assertions.assertEquals(4, rewardPool.size());

        // Verify that each element is within the specified range for "Hard" difficulty
        for (int reward : rewardPool) {
            Assertions.assertTrue(reward >= 100 && reward <= 600);
        }
    }

    @Test
    public void testPrintResult_Win() {
        String result = game.printResult(10, 5);
        Assertions.assertEquals("YOU WON!", result);
    }

    @Test
    public void testPrintResult_Draw() {
        String result = game.printResult(10, 10);
        Assertions.assertEquals("DRAW", result);
    }

    @Test
    public void testPrintResult_Loss() {
        String result = game.printResult(5, 10);
        Assertions.assertEquals("YOU LOST!", result);
    }

    @Test
    public void testIncrementWins() {
        game.incrementWins();
        int wins = game.getWins();
        Assertions.assertEquals(1, wins);
    }

    @Test
    public void testIncrementLoss() {
        game.incrementLoss();
        int losses = game.getLosses();
        Assertions.assertEquals(1, losses);
    }
}
