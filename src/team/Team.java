package src.team;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a team consisting of athletes.
 */
public class Team {
    private String teamName;
    private ArrayList<Athlete> equippedAthletes;
    private Athlete excessAthlete;

    /**
     * Creates a new instance of the Team class with the specified team name and
     * list of athletes.
     *
     * @param teamName the name of the team
     * @param athletes the list of athletes in the team
     */
    public Team(String teamName, ArrayList<Athlete> athletes) {
        this.teamName = teamName;
        this.equippedAthletes = athletes;
    }

    /**
     * Gets the name of the team.
     *
     * @return the team name
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Sets the name of the team.
     *
     * @param teamName the new team name
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * Adds an athlete to the team. If the team is already full, the excess athlete
     * is stored separately.
     *
     * @param athlete the athlete to add
     */
    public void addAthlete(Athlete athlete) {
        if (equippedAthletes.size() < 5) {
            equippedAthletes.add(athlete);
        } else if (excessAthlete == null) {
            excessAthlete = athlete;
        } else {
            // TODO Team full warning
        }
    }

    /**
     * Sets the athlete at the specified index with the athlete at the current
     * index.
     * If the current index is greater than 4, the excess athlete is swapped.
     *
     * @param selectedIndex the index of the athlete to be set
     * @param currentIndex  the current index of the athlete
     */
    public void setAthlete(int selectedIndex, int currentIndex) {
        if (currentIndex > 4) {
            Athlete swappedAthlete = equippedAthletes.get(selectedIndex);
            equippedAthletes.set(selectedIndex, excessAthlete);
            excessAthlete = swappedAthlete;
        } else {
            Collections.swap(equippedAthletes, selectedIndex, currentIndex);
        }
    }

    /**
     * Gets the list of equipped athletes in the team.
     *
     * @return the list of equipped athletes
     */
    public ArrayList<Athlete> getEquippedAthletes() {
        return equippedAthletes;
    }

    /**
     * Gets the excess athlete
     * which is not part of the main equipped athletes list.
     *
     * @return the excess athlete
     */
    public Athlete getExcessAthlete() {
        return excessAthlete;
    }

    /**
     * sets the excessAthlete to null
     */
    public void removeExcessAthlete() {
        excessAthlete = null;
    }

    /**
     * Calculates and returns the total stat value of all equipped athletes in the
     * team.
     *
     * @return the total stat value of the team
     */
    public int getStatTotal() {
        int statTotal = 0;
        for (Athlete athlete : equippedAthletes) {
            statTotal += athlete.getOverallStat();
        }
        return statTotal;
    }

    /**
     * Checks if the team contains the specified athlete, either in the equipped
     * athletes list or as the excess athlete.
     *
     * @param athlete the athlete to check
     * @return true if the team contains the athlete, false otherwise
     */
    public Boolean containsAthlete(Athlete athlete) {
        if (equippedAthletes.contains(athlete) || excessAthlete == athlete) {
            return true;
        } else {
            return false;
        }
    }

    public int getSFStat() {
        int sfOffence = equippedAthletes.get(1).getOffence();
        int sfDefence = equippedAthletes.get(1).getDefence();
        int sfAgility = equippedAthletes.get(1).getAgility();
        int sfStat = (sfOffence + sfDefence + sfAgility) / 3;
        return sfStat;
    }

    public int getPFStat() {
        return equippedAthletes.get(2).getOffence();
    }

    public int getPGStat() {
        int pgOffence = equippedAthletes.get(3).getOffence();
        int pgAgility = equippedAthletes.get(3).getAgility();
        int pgStat = (pgOffence + pgAgility) / 2;
        return pgStat;
    }

    public int getSGStat() {
        return equippedAthletes.get(4).getOffence();
    }
}
