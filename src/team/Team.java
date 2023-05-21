package src.team;

import java.util.ArrayList;

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
    
    public void setAthlete(int index) {
    	Athlete swappedAthlete = equippedAthletes.get(index);
    	equippedAthletes.set(index, excessAthlete);
    	excessAthlete = swappedAthlete;
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
    
}   
