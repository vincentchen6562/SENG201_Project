package src.team;

import java.util.ArrayList;
import java.util.Collections;

public class Team {
    private String teamName;
    private ArrayList<Athlete> equippedAthletes; // need to build a relationship between team and inventory: create a bank class
    private Athlete excessAthlete;

    public Team(String teamName, ArrayList<Athlete> athletes){
        this.teamName = teamName;
        this.equippedAthletes = athletes;
    }

    public String getTeamName(){
        return teamName;
    }

    public void setTeamName(String teamName){
        this.teamName = teamName;
    }

    public void addAthlete(Athlete athlete){
    	if (equippedAthletes.size() < 5) {
            equippedAthletes.add(athlete);
    	} else if (excessAthlete == null) {
    		excessAthlete = athlete;
    	} else {
    		// team full warning
    	}
    }
    
    public void setAthlete(int selectedIndex, int currentIndex) {
    	if (currentIndex > 4) {
        	Athlete swappedAthlete = equippedAthletes.get(selectedIndex);
        	equippedAthletes.set(selectedIndex, excessAthlete);
        	excessAthlete = swappedAthlete;
    	} else {
    		Collections.swap(equippedAthletes, selectedIndex, currentIndex);
    	}

    }

    public ArrayList<Athlete> getEquippedAthletes(){
        return equippedAthletes;
    }
    
    public Athlete getExcessAthlete(){
    	return excessAthlete;
    }
    
    public int getStatTotal() {
    	int statTotal = 0;
    	for (Athlete athlete: equippedAthletes) {
    		statTotal += athlete.getOverallStat();
    	}
    	
    	return statTotal;
    }
    
    public Boolean containsAthlete(Athlete athlete) {
    	if (equippedAthletes.contains(athlete) || excessAthlete == athlete) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
}   
