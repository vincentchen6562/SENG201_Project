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

    public int overallStat(){
        return overallStat;
    }

    public void updateOverallStat(){
        overallStat = offence + defence + agility;
    }

    public void alterStat(String stat, int amount){
        if (stat == "offence"){
            this.offence = amount;
        }
        else if (stat == "defence"){
            this.defence = amount;
        }
        else if (stat == "agility"){
            this.agility = amount;
        }
        updateOverallStat();
    }
}



