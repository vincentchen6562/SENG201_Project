package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.items.Item;
import src.team.Athlete;
import src.team.Team;

import java.util.ArrayList;
import java.util.Arrays;

public class TeamTest {

    private Team team;
    private Athlete athlete1;
    private Athlete athlete2;
    private Athlete athlete3;
    private Athlete athlete4;
    private Athlete athlete5;
    private Athlete excessAthlete;

    @BeforeEach
    public void setUp() {
        athlete1 = new Athlete("John Doe", "Forward", 100, false, 10, 5, 8, 1000);
        athlete2 = new Athlete("Jane Smith", "Midfielder", 90, false, 8, 6, 7, 900);
        athlete3 = new Athlete("Mike Johnson", "Defender", 80, false, 6, 8, 5, 800);
        athlete4 = new Athlete("Sarah Davis", "Goalkeeper", 70, false, 4, 10, 3, 700);
        athlete5 = new Athlete("Alex Brown", "Forward", 95, false, 9, 7, 9, 950);
        excessAthlete = new Athlete("Tom Wilson", "Defender", 75, false, 7, 7, 6, 750);
        ArrayList<Athlete> athletes = new ArrayList<>(Arrays.asList(athlete1, athlete2, athlete3, athlete4, athlete5));
        team = new Team("Test Team", athletes);
    }

    @Test
    public void testGetTeamName() {
        String teamName = team.getTeamName();
        Assertions.assertEquals("Test Team", teamName);
    }

    @Test
    public void testSetTeamName() {
        team.setTeamName("New Team");
        String teamName = team.getTeamName();
        Assertions.assertEquals("New Team", teamName);
    }

    @Test
    public void testAddAthlete() {
        team.addAthlete(excessAthlete);
        ArrayList<Athlete> equippedAthletes = team.getEquippedAthletes();
        Assertions.assertEquals(5, equippedAthletes.size());
        Assertions.assertFalse(equippedAthletes.contains(excessAthlete));
    }

    @Test
    public void testSetAthlete() {
        team.setAthlete(0, 4);
        ArrayList<Athlete> equippedAthletes = team.getEquippedAthletes();
        Assertions.assertEquals(athlete5, equippedAthletes.get(0));
        Assertions.assertEquals(athlete1, equippedAthletes.get(4));
    }

    @Test
    public void testSetAthleteWithExcessAthlete() {
        team.addAthlete(excessAthlete);
        team.setAthlete(0, 5);
        ArrayList<Athlete> equippedAthletes = team.getEquippedAthletes();
        Assertions.assertEquals(5, equippedAthletes.size());
        Assertions.assertEquals(excessAthlete, equippedAthletes.get(0));
    }

    @Test
    public void testGetEquippedAthletes() {
        ArrayList<Athlete> equippedAthletes = team.getEquippedAthletes();
        Assertions.assertEquals(5, equippedAthletes.size());
        Assertions.assertTrue(equippedAthletes.contains(athlete1));
        Assertions.assertTrue(equippedAthletes.contains(athlete2));
        Assertions.assertTrue(equippedAthletes.contains(athlete3));
        Assertions.assertTrue(equippedAthletes.contains(athlete4));
        Assertions.assertTrue(equippedAthletes.contains(athlete5));
    }

    @Test
    public void testGetExcessAthlete() {
        Athlete excessAthlete = team.getExcessAthlete();
        Assertions.assertNull(excessAthlete);
    }

    @Test
    public void testRemoveExcessAthlete() {
        team.addAthlete(excessAthlete);
        team.removeExcessAthlete();
        Athlete excessAthlete = team.getExcessAthlete();
        Assertions.assertNull(excessAthlete);
    }

    @Test
    public void testGetStatTotal() {
        int statTotal = team.getStatTotal();
        Assertions.assertEquals(105, statTotal);
    }

    @Test
    public void testContainsAthlete() {
        Assertions.assertTrue(team.containsAthlete(athlete1));
        Assertions.assertFalse(team.containsAthlete(excessAthlete));
    }
}
