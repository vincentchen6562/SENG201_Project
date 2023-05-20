package src;
import src.pages.*;

public class GameEnvironment {
	
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
    
    public static void main(String [] args) {
    	GameEnvironment game = new GameEnvironment();
    	game.launchSetupPage();
    }
    
}
