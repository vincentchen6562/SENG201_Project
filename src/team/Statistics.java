package src.team;

import java.util.ArrayList;

public class Statistics {
    private int offence;
    private int defence;
    private int agility;
    private int overallStat;

    public Statistics(int offence, int defence, int agility) {
        this.offence = offence;
        this.defence = defence;
        this.agility = agility;
        this.overallStat = offence + defence + agility;
    }

    public int getOffence() {
        return offence;
    }

    public int getDefence() {
        return defence;
    }

    public int getAgility() {
        return agility;
    }

    public int getOverallStat() {
        return overallStat;
    }

    public ArrayList<Integer> getStatList() {
        ArrayList<Integer> statList = new ArrayList<Integer>();
        statList.add(getOffence());
        statList.add(getDefence());
        statList.add(getAgility());
        return statList;

    }

    public int overallStat() {
        return overallStat;
    }

    public void updateOverallStat() {
        overallStat = offence + defence + agility;
    }

    public void alterStat(String stat, int amount) {
        if (stat == "Offence") {
        	System.out.print("success");
            this.offence += amount;
        } else if (stat == "Defence") {
        	this.defence += amount;
        } else if (stat == "Agility") {
            this.agility += amount;
        } else if (stat == "All") {
        	this.offence += amount;
        	this.defence += amount;
        	this.agility += amount;
        } else {
        }
        updateOverallStat();
    }

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
