package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.*;

public class DifficultyTest {

    @Test
    public void testGetDifficulty() {
        Difficulty difficulty = new Difficulty("Easy");
        String level = difficulty.getDifficulty();
        Assertions.assertEquals("Easy", level);
    }
}
