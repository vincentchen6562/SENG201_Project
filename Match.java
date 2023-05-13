public class Match {
    private int scoreTotal;
    private int priceMoney;
    private int pointsWorth; 
    private int playerScore;
    private int opponentScore;

    public Match(int totalScore, int reward, int points) {
        scoreTotal = totalScore;
        priceMoney = reward;
        pointsWorth = points;
    }

    public int getTotalScore() {
        return scoreTotal;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void incrementPlayerScore(int score) {
        playerScore += score;
    }

    public int getOppScore() {
        return opponentScore;
    }

    public void incrementOppScore(int score) {
        opponentScore += score;
    }

    public String resultMessage() {
        if(playerScore > opponentScore) {
            return "Congratulations, you have won the game!";
        } else {
            return "Better luck next time!";
        }
    }

}

