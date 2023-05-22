package src;

public class Difficulty {
    private String difficulty; // difficulty is displayed as a string - "Normal" and "Hard"

    public Difficulty(String newDifficulty) {
        difficulty = newDifficulty;
    }

    public String getDifficulty() {
        return difficulty;
    }
}