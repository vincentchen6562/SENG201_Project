package src.items;

import src.*;
import src.team.*;
import src.items.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class Market {
    private ArrayList<Item> itemsInMarket;
    private ArrayList<Athlete> athletesInMarket;
    
    public Market(){
    	
    }

    public void generateItemShop(Difficulty difficulty, int seasonNumber) {
    	try {
        	File itemList = new File(
        			"src/items/ItemList.txt");
	        Scanner items = new Scanner(itemList);
	        items.useDelimiter(",");
	        ArrayList<String> idList = new ArrayList<>();
	        while (items.hasNextLine()) {
	        	idList.add(items.nextLine());
	        }
	        
	        ArrayList<Item> allItems = new ArrayList<Item>();
	        
	        for (int i = 0; i < idList.size(); i++) {
	        	String info = idList.get(i);
	        	String[] s2 = info.split(",");
	        	
	        	if (i != 0) {
	        		String type = s2[1];
	        		String name = s2[2];
	        		int itemBoost = Integer.parseInt(s2[3]);
	        		String boostType = s2[4];
	        		
	        		int typeMultiplier = 1;
	        		if (boostType == "All");
	        			typeMultiplier = 3;
	        		int price = itemBoost * typeMultiplier * 150; //TODO * difficulty
	        		Item newItem = new Item(type, name, itemBoost, boostType, price, null);
	        		allItems.add(newItem);
	        	}
	        }
	        
	        
	        ArrayList<Item> itemsInShop = new ArrayList<Item>(); 	  
	        
	        while(itemsInShop.size() < 5) {
	        	 Random rng = new Random();
	        	 int randInt = rng.nextInt(1,19);
	        	 Item item = allItems.get(randInt);
	        	 
	        	 if (!itemsInShop.contains(item)) {
	        		 itemsInShop.add(item);
	        	 }
	        }
	        
	        itemsInMarket = itemsInShop;
	        
	        items.close();
            
    	} catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void generateAthleteShop(Difficulty difficulty, int seasonNumber, GameEnvironment environment) {
        try {

            File athleteList = new File(
                    "src/team/AthleteList.txt");
            Scanner athletes = new Scanner(athleteList);
            athletes.useDelimiter(",");
            ArrayList<String> idList = new ArrayList<>();
            while (athletes.hasNextLine()) {
                idList.add(athletes.nextLine());
            }

            ArrayList<Athlete> allAthletes = new ArrayList<Athlete>();

            for (int i = 0; i < idList.size(); i++) {
                String info = idList.get(i);
                String[] s2 = info.split(",");

                if (i != 0) {
                    String name = s2[1];
                    int offence = Integer.parseInt(s2[2]);
                    int defence = Integer.parseInt(s2[3]);
                    int agility = Integer.parseInt(s2[4]);
                    int stamina = Integer.parseInt(s2[5]);
                    String position = s2[6];
                    int price = Integer.parseInt(s2[7]);

                    Athlete newAthlete = new Athlete(name, position, stamina, false, offence, defence, agility,
                            price);

                    allAthletes.add(newAthlete);
                }
            }

            ArrayList<Athlete> athletesInShop = new ArrayList<Athlete>();

            while (athletesInShop.size() < 5) {
                Random rng = new Random();
                int randInt = rng.nextInt(1, 20);
                Athlete athlete = allAthletes.get(randInt);

                if (!athletesInShop.contains(athlete)) {// && !environment.getGame().getTeam().containsAthlete(athlete)) {
                    athletesInShop.add(athlete);
                }

            }
          
            athletesInMarket = athletesInShop;

//             for (Athlete athlete : athletesInShop) {
//             System.out.println(athlete.getFullName());
//             }

            athletes.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public ArrayList<Athlete> getAthletes(GameEnvironment environment) {
    	Difficulty difficulty = new Difficulty("Normal"); // TODO difficulty proper implementation
    	generateAthleteShop(difficulty, 1, environment); // TODO proper ability to get week/season
        return athletesInMarket;
    }
    
    public ArrayList<Item> getItems(){
    	Difficulty difficulty = new Difficulty("normal");
    	generateItemShop(difficulty, 1);
    	return itemsInMarket;
    }

    public static void main(String[] args) {
        Difficulty difficulty = new Difficulty("Normal");
        Market market = new Market();
        market.generateItemShop(difficulty, 1);
        ArrayList<Item> items = market.getItems();
        for (Item item : items) {
            System.out.println(item.info());
        }
    }

}
