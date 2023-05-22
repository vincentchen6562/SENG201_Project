package src;

/**
 * Represents the difficulty level of a game.
 */
public class Difficulty {
    private String difficulty;

    /**
     * Creates a new instance of the Difficulty class with the specified difficulty level.
     *
     * @param newDifficulty the difficulty level
     */
    public Difficulty(String newDifficulty) {
        difficulty = newDifficulty;
    }

    /**
     * Gets the difficulty level.
     *
     * @return the difficulty level
     */
    public String getDifficulty() {
        return difficulty;
    }
}
