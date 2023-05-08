public class Coach extends Item {
    private int coachSalary;

    public Coach(String name, int boost, int salary) {
        super(name, boost, salary);
    }

    public int getPrice() {
        return coachSalary;
    }

}

// idea: maybe add interface for the stats of the athlete
// and this vairiable can be related to the stats