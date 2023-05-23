package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.items.Item;
import src.team.Athlete;
import src.Difficulty;
import src.GameEnvironment;

import java.util.ArrayList;
import src.items.*;

public class MarketTest {
    @Test
    public void testGenerateItemShop() {
        Market market = new Market();
        Difficulty difficulty = new Difficulty("Normal");
        int seasonNumber = 1;
        market.generateItemShop(difficulty, seasonNumber);
        ArrayList<Item> items = market.getItems();
        Assertions.assertEquals(5, items.size());
    }

    @Test
    public void testGenerateAthleteShop() {
        Market market = new Market();
        Difficulty difficulty = new Difficulty("Normal");
        int seasonNumber = 1;
        GameEnvironment environment = new GameEnvironment();
        market.generateAthleteShop(difficulty, seasonNumber, environment);
        ArrayList<Athlete> athletes = market.getAthletes(environment);
        Assertions.assertEquals(5, athletes.size());
    }

    @Test
    public void testGetItems() {
        Market market = new Market();
        ArrayList<Item> items = market.getItems();
        Assertions.assertNotNull(items);
    }

    @Test
    public void testGetAthletes() {
        Market market = new Market();
        GameEnvironment environment = new GameEnvironment();
        ArrayList<Athlete> athletes = market.getAthletes(environment);
        Assertions.assertNotNull(athletes);
    }
}

