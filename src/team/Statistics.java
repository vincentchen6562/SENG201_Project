package src.team;

import java.util.ArrayList;

public class Statistics {
    private int offence;
    private int defence;
    private int agility;
    private int overallStat;

    public Statistics(int offence, int defence, int agility){
        this.offence = offence;
        this.defence = defence;
        this.agility = agility;
        this.overallStat = offence + defence + agility;
    }

    public int getOffence(){
        return offence;
    }

    public int getDefence(){
        return defence;
    }

    public int getAgility(){
        return agility;
    }
    
    public ArrayList<Integer> getStatList(){
    	ArrayList<Integer> statList = new ArrayList<Integer>();
    	statList.add(getOffence());
    	statList.add(getDefence());
    	statList.add(getAgility());
    	return statList;
    	
    }

    public int overallStat(){
        return overallStat;
    }

    public void updateOverallStat(){
        overallStat = offence + defence + agility;
    }

    public void alterStat(String stat, int amount){
        if (stat == "offence"){
            offence += amount;
        }
        else if (stat == "defence"){
            defence += amount;
        }
        else if (stat == "agility"){
            agility += amount;
        }
        updateOverallStat();
    }

    public void setStat(String stat, int value){
        if (stat == "offence"){
            offence = value;
        }
        else if (stat == "defence"){
            defence = value;
        }
        else if (stat == "agility"){
            agility = value;
        }
        updateOverallStat();
    }
}



