package src.team;

import java.util.ArrayList;

public class Team {
    private String teamName;
    private ArrayList<Athlete> members; // need to build a relationship between team and inventory: create a bank class

    public Team(String teamName, ArrayList<Athlete> members){
        this.teamName = teamName;
        this.members = members;
    }

    public String getTeamName(){
        return teamName;
    }

    public void setTeamName(String teamName){
        this.teamName = teamName;
    }

    public void addAthlete(Athlete athlete){
        members.add(athlete);
        
    }

    public ArrayList<Athlete> viewTeam(){
        return members;
    }
    
}   
