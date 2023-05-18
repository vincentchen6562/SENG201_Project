package src.team;

public class Athlete extends Statistics {
    private String name;
    private String nickName = "";
    private String position;
    private int stamina;
    private boolean isInjured;
    private int athleteSalary; // this needs to be zero for the initial

    public Athlete(String name, String position, int stamina, boolean isInjured, int offence, int defence, int agility,
            int price) {
        super(offence, defence, agility);
        this.name = name;
        this.position = position;
        this.stamina = stamina;
        this.isInjured = isInjured;
        athleteSalary = price;

    }

    public String getFullName() {
        return name + " " + nickName + "";
    }

    public String getPosition() {
        return position;
    }

    public int getStamina() {
        return stamina;
    }

    public void changeStamina(int amount) {
        stamina += amount;
    }

    public void setIsInjured(boolean state) { // need to set a random chance of this occurring
        isInjured = state;
    }

    public int getPrice() {
        return athleteSalary;
    }

    public void setNickName(String name) { // this allows the player to give an athlete a nickname
        nickName = name;
    }

    public boolean getIfInjured() {
        return isInjured;
    }

    // public void train(Athlete athlete, String stat, int days) {
    // for (int i = 0; i < days; i++) {
    // Athlete = super.alterStat(stat, 10);
    // }
    // }
}
