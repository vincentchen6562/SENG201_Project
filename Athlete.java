// import java.util.ArrayList;

public class Athlete extends Statistics {
    private String name;
    private String nickName;
    private String position;
    private int stamina;
    private boolean isInjured;
    private int athleteSalary; // this needs to be zero for the initial 



    public Athlete(String name, String nickName, String position, int stamina, boolean isInjured, int offence, int defence, int agility, int price){
        super(offence, defence, agility);
        this.name = name;
        this.nickName = nickName;
        this.position = position;
        this.stamina = stamina;
        this.isInjured = isInjured;
        athleteSalary = price;

    }

    public String getFullName(){
        return name + nickName;
    }

    public String getPosition(){
        return position;
    }

    public int getStamina(){
        return stamina;
    }

    public void changeStamina(int amount){
        stamina += amount;
    }

    public void setIsInjured(boolean state){
        isInjured = state;
    }

    public int getPrice() {
        return athleteSalary;
    }
}
