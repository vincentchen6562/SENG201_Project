package src;

public class Difficulty {
    private String difficulty; // difficulty is displayed as a string - "Normal" and "Hard"

    public Difficulty(String newDifficulty) {
        difficulty = newDifficulty;
    }

    public String getDifficulty() {
        return difficulty;
    }

    // public static void main(String[] args) {
    //     Difficulty difficulty = new Difficulty("Hard");
    //     System.out.println(difficulty.getDifficulty());
    // }
}