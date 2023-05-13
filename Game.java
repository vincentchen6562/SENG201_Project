import java.awt.EventQueue;

import javax.swing.JFrame;

public class Game {
    private int seasonNumber;
    private int weekNumber;
    private JFrame frame;

    public Game(int seasonNumber, int weekNumber) {
        initialize();
        this.seasonNumber = seasonNumber;
        this.weekNumber = weekNumber;
    }

    public void setSeason(int seasonNum) {
        seasonNumber = seasonNum;
    }

    public void incrementSeason() {
        seasonNumber += 1;
    }

    public int getSeason() {
        return seasonNumber;
    }

    public void setWeekN(int week) {
        weekNumber = week;
    }

    public void incrementWeek() {
        weekNumber += 1;
    }

    public int getWeek() {
        return weekNumber;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Game window = new Game(0, 0);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

// TODO
// - Need to determine how the player can win or lose a game
// - Need to update the UML diagram (classes added: Item, Coach, Equipment)
// - Need to add price to Athlete. Potential solution: add athlete into item
// class?
