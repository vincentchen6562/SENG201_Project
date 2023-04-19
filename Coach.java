public class Coach {
    private String name;
    private int specialisation; // idea: maybe add interface for the stats of the athlete
                                // and this vairiable can be related to the stats
    private int salary;

    public Coach(String coachName, int price, int boost) {
        name = coachName;
        specialisation = boost;
        salary = price;
    }

    public String getCoachName() {
        return name;
    }

    public int getBoost() {
        return specialisation;
    }

    public int getSalary() {
        return salary;
    }
}
