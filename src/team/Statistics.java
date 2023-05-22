package src.team;

import java.util.ArrayList;

/**
 * Represents the statistics of an athlete, including offence, defence, agility, and overall stat.
 */
public class Statistics {
    private int offence;
    private int defence;
    private int agility;
    private int overallStat;

    /**
     * Creates a new instance of the Statistics class with the specified offensive, defensive, and agility stats.
     *
     * @param offence  the offensive stat of the athlete
     * @param defence  the defensive stat of the athlete
     * @param agility  the agility stat of the athlete
     */
    public Statistics(int offence, int defence, int agility) {
        this.offence = offence;
        this.defence = defence;
        this.agility = agility;
        this.overallStat = offence + defence + agility;
    }

    /**
     * Gets the offensive stat of the athlete.
     *
     * @return the offensive stat
     */
    public int getOffence() {
        return offence;
    }

    /**
     * Gets the defensive stat of the athlete.
     *
     * @return the defensive stat
     */
    public int getDefence() {
        return defence;
    }

    /**
     * Gets the agility stat of the athlete.
     *
     * @return the agility stat
     */
    public int getAgility() {
        return agility;
    }

    /**
     * Gets the overall stat of the athlete.
     *
     * @return the overall stat
     */
    public int getOverallStat() {
        return overallStat;
    }

    /**
     * Gets a list of the athlete's offensive, defensive, and agility stats.
     *
     * @return an ArrayList containing the offensive, defensive, and agility stats in that order
     */
    public ArrayList<Integer> getStatList() {
        ArrayList<Integer> statList = new ArrayList<Integer>();
        statList.add(getOffence());
        statList.add(getDefence());
        statList.add(getAgility());
        return statList;
    }

    /**
     * Calculates and returns the overall stat of the athlete.
     *
     * @return the overall stat
     */
    public int overallStat() {
        return overallStat;
    }

    /**
     * Updates the overall stat of the athlete based on the current offensive, defensive, and agility stats.
     */
    public void updateOverallStat() {
        overallStat = offence + defence + agility;
    }

    /**
     * Alters the specified stat of the athlete by the given amount.
     *
     * @param stat   the stat to alter ("Offence", "Defence", "Agility", or "All")
     * @param amount the amount by which to alter the stat
     */
    public void alterStat(String stat, int amount) {
        if (stat.equals("Offence")) {
            this.offence += amount;
        } else if (stat.equals("Defence")) {
            this.defence += amount;
        } else if (stat.equals("Agility")) {
            this.agility += amount;
        } else if (stat.equals("All")) {
            this.offence += amount;
            this.defence += amount;
            this.agility += amount;
        }
        updateOverallStat();
    }

    /**
     * Sets the specified stat of the athlete to the given value.
     *
     * @param stat  the stat to set ("Offence", "Defence", or "Agility")
     * @param value the value to set for the stat
     */
    public void setStat(String stat, int value) {
        if (stat == "Offence") {
            offence = value;
        } else if (stat == "Defence") {
            defence = value;
        } else if (stat == "Agility") {
            agility = value;
        }
        updateOverallStat();
    }
}
