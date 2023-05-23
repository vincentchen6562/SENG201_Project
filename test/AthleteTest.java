package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.items.Item;
import src.team.Athlete;

import java.util.ArrayList;

public class AthleteTest {

    private Athlete athlete;

    @BeforeEach
    public void setUp() {
        athlete = new Athlete("John Doe", "Forward", 100, false, 10, 5, 8, 1000);
    }

    @Test
    public void testGetFullName() {
        String fullName = athlete.getFullName();
        Assertions.assertEquals("John Doe ", fullName);
    }

    @Test
    public void testGetPosition() {
        String position = athlete.getPosition();
        Assertions.assertEquals("Forward", position);
    }

    @Test
    public void testGetStamina() {
        int stamina = athlete.getStamina();
        Assertions.assertEquals(100, stamina);
    }

    @Test
    public void testChangeStamina() {
        athlete.changeStamina(-20);
        int stamina = athlete.getStamina();
        Assertions.assertEquals(80, stamina);
    }

    @Test
    public void testSetIsInjured() {
        athlete.setIsInjured(true);
        boolean isInjured = athlete.getIsInjured();
        Assertions.assertTrue(isInjured);
    }

    @Test
    public void testGetIsInjured() {
        boolean isInjured = athlete.getIsInjured();
        Assertions.assertFalse(isInjured);
    }

    @Test
    public void testSetNickName() {
        athlete.setNickName("JD");
        String fullName = athlete.getFullName();
        Assertions.assertEquals("John Doe JD", fullName);
    }

    @Test
    public void testGetValue() {
        int value = athlete.getValue();
        Assertions.assertEquals(1000, value);
    }
    
    @Test
    public void testGetMaxStamina() {
    	int maxStamina = athlete.getMaxStamina();
    	Assertions.assertEquals(100, maxStamina);
    }
    
}

