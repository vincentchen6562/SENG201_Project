package src;

import src.pages.*;

public class GameEnvironment {
	private Game game;
	private StadiumPage stadium;
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	public Game getGame() {
		return this.game;
	}
	
    public void launchSetupPage() {
    	SetupPage setupPage = new SetupPage(this);
    }
    
    public void closeSetupPage(SetupPage setupPage) {
    	setupPage.closeWindow();
    	launchGamePage();
    }
    
    public void launchGamePage() {
    	GamePage gamePage = new GamePage(this);
    }
    
    public void closeGamePage(GamePage mainPage) {
    	mainPage.closeWindow();
    }
    
    public void launchMarketChoicePage() {
    	MarketChoicePage marketChoicePage = new MarketChoicePage(this);
    }
    
    public void closeMarketChoicePage(MarketChoicePage marketChoicePage) {
    	marketChoicePage.closeWindow();
    	launchGamePage();
    }
    
    public void launchItemMarketPage() {
    	ItemMarketPage itemMarketPage = new ItemMarketPage(this);
    }
    
    public void closeItemMarketPage(ItemMarketPage itemMarketPage) {
    	itemMarketPage.closeWindow();
    	launchMarketChoicePage();
    }
    
    public void launchAthleteMarketPage() {
    	AthleteMarketPage athleteMarketPage = new AthleteMarketPage(this);
    }
    
    public void closeAthleteMarketPage(AthleteMarketPage athleteMarketPage) {
    	athleteMarketPage.closeWindow();
    	launchMarketChoicePage();
    }
    
    public void launchRestPage() {
    	RestPage restPage = new RestPage(this); 
    }
    
    public void closeRestPage(RestPage restPage) {
    	restPage.closeWindow();
    	launchGamePage();
    }
    
    public void launchStadiumPage() {
    	StadiumPage stadiumPage = new StadiumPage(this);
    	stadium = stadiumPage; //maybe needs removing
    }
    
    public void closeStadiumPage(StadiumPage stadiumPage) {
    	stadiumPage.closeWindow();
    	launchGamePage();
    }
    
    public void launchTeamPage() {
    	TeamPage teamPage = new TeamPage(this);
    }
    
    public void closeTeamPage(TeamPage teamPage) {
    	teamPage.closeWindow();
    	launchGamePage();
    }
    
    public void launchMatchPage(String oppTeamName) {
    	MatchPage newMatch = new MatchPage(this, oppTeamName); // maybe pass a stadium object
    }
    
    public void closeMatchPage(MatchPage matchPage) {
    	matchPage.closeWindow();
    	launchGamePage();
    }
    
    public static void main(String [] args) {
    	GameEnvironment game = new GameEnvironment();
    	game.launchSetupPage();
    }
    
}
