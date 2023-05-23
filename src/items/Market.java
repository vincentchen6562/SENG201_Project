package src.items;

import src.*;
import src.team.*;
import src.items.*;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Random;

/**
 * The Market class represents a market where items and athletes can be
 * generated and obtained.
 */
public class Market {
    private ArrayList<Item> itemsInMarket;
    private ArrayList<Athlete> athletesInMarket;

    /**
     * Constructs a Market object.
     */
    public Market() {

    }

    /**
     * Generates the item shop in the market.
     *
     * @param difficulty   the difficulty level of the game
     * @param seasonNumber the current season number
     */
    public void generateItemShop(Difficulty difficulty, int seasonNumber) {
        try {
        	
        	InputStream in = getClass().getResourceAsStream("/src/items/ItemList.txt"); 
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            
            Scanner scanner = new Scanner(reader);
            scanner.useDelimiter(",");
            ArrayList<String> idList = new ArrayList<>();
            
            String line;
            while ((line = reader.readLine()) != null) {
                // Process the line
            	idList.add(line);
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
                    if (boostType.equals("All")) {
                        typeMultiplier = 3;
                    }
                    int price = itemBoost * typeMultiplier * 150;
                    Item newItem = new Item(type, name, itemBoost, boostType, price);
                    allItems.add(newItem);
                }
            }

            ArrayList<Item> itemsInShop = new ArrayList<Item>();

            while (itemsInShop.size() < 5) {
                Random rng = new Random();
                int randInt = rng.nextInt(1, 19);
                Item item = allItems.get(randInt);

                if (!itemsInShop.contains(item)) {
                    itemsInShop.add(item);
                }
            }

            itemsInMarket = itemsInShop;
            reader.close();
            scanner.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Generates the athlete shop in the market.
     *
     * @param difficulty   the difficulty level of the game
     * @param seasonNumber the current season number
     * @param environment  the game environment
     */
    public void generateAthleteShop(Difficulty difficulty, int seasonNumber, GameEnvironment environment) {
        try {
        	
        	InputStream in = getClass().getResourceAsStream("/src/team/AthleteList.txt"); 
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            
            Scanner scanner = new Scanner(reader);
            scanner.useDelimiter(",");
            ArrayList<String> idList = new ArrayList<>();
            
            String line;
            while ((line = reader.readLine()) != null) {
                // Process the line
            	idList.add(line);
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

                if (!athletesInShop.contains(athlete)) {
                    athletesInShop.add(athlete);
                }
            }

            athletesInMarket = athletesInShop;
            reader.close();
            scanner.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Gets the athletes available in the market.
     *
     * @param environment the game environment
     * @return the list of athletes in the market
     */
    public ArrayList<Athlete> getAthletes(GameEnvironment environment) {
        Difficulty difficulty = new Difficulty("Normal");
        generateAthleteShop(difficulty, 1, environment);
        return athletesInMarket;
    }

    /**
     * Gets the items available in the market.
     *
     * @return the list of items in the market
     */
    public ArrayList<Item> getItems() {
        Difficulty difficulty = new Difficulty("normal");
        generateItemShop(difficulty, 1);
        return itemsInMarket;
    }

}
