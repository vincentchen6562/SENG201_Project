package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.team.Statistics;

import java.util.ArrayList;

public class StatisticsTest {

    private Statistics statistics;

    @BeforeEach
    public void setUp() {
        statistics = new Statistics(10, 5, 8);
    }

    @Test
    public void testGetOffence() {
        int offence = statistics.getOffence();
        Assertions.assertEquals(10, offence);
    }

    @Test
    public void testGetDefence() {
        int defence = statistics.getDefence();
        Assertions.assertEquals(5, defence);
    }

    @Test
    public void testGetAgility() {
        int agility = statistics.getAgility();
        Assertions.assertEquals(8, agility);
    }

    @Test
    public void testGetOverallStat() {
        int overallStat = statistics.getOverallStat();
        Assertions.assertEquals(23, overallStat);
    }

    @Test
    public void testGetStatList() {
        ArrayList<Integer> statList = statistics.getStatList();
        Assertions.assertEquals(3, statList.size());
        Assertions.assertEquals(10, statList.get(0));
        Assertions.assertEquals(5, statList.get(1));
        Assertions.assertEquals(8, statList.get(2));
    }

    @Test
    public void testAlterStatOffence() {
        statistics.alterStat("Offence", 2);
        int offence = statistics.getOffence();
        Assertions.assertEquals(12, offence);

        int overallStat = statistics.getOverallStat();
        Assertions.assertEquals(25, overallStat);
    }

    @Test
    public void testAlterStatDefence() {
        statistics.alterStat("Defence", -3);
        int defence = statistics.getDefence();
        Assertions.assertEquals(2, defence);

        int overallStat = statistics.getOverallStat();
        Assertions.assertEquals(20, overallStat);
    }

    @Test
    public void testAlterStatAgility() {
        statistics.alterStat("Agility", 1);
        int agility = statistics.getAgility();
        Assertions.assertEquals(9, agility);

        int overallStat = statistics.getOverallStat();
        Assertions.assertEquals(24, overallStat);
    }

    @Test
    public void testAlterStatAll() {
        statistics.alterStat("All", -5);
        int offence = statistics.getOffence();
        int defence = statistics.getDefence();
        int agility = statistics.getAgility();

        Assertions.assertEquals(5, offence);
        Assertions.assertEquals(0, defence);
        Assertions.assertEquals(3, agility);

        int overallStat = statistics.getOverallStat();
        Assertions.assertEquals(8, overallStat);
    }

    @Test
    public void testSetStatOffence() {
        statistics.setStat("Offence", 15);
        int offence = statistics.getOffence();
        Assertions.assertEquals(15, offence);

        int overallStat = statistics.getOverallStat();
        Assertions.assertEquals(28, overallStat);
    }

    @Test
    public void testSetStatDefence() {
        statistics.setStat("Defence", 3);
        int defence = statistics.getDefence();
        Assertions.assertEquals(3, defence);

        int overallStat = statistics.getOverallStat();
        Assertions.assertEquals(21, overallStat);
    }

    @Test
    public void testSetStatAgility() {
        statistics.setStat("Agility", 10);
        int agility = statistics.getAgility();
        Assertions.assertEquals(10, agility);

        int overallStat = statistics.getOverallStat();
        Assertions.assertEquals(25, overallStat);
    }
}
