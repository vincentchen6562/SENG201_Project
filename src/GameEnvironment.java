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
    
    public void launchMarketPage() {
    	MarketPage marketPage = new MarketPage(this);
    }
    
    public void closeMarketPage(MarketPage marketPage) {
    	marketPage.closeWindow();
    	launchGamePage();
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
    
    public static void main(String [] args) {
    	GameEnvironment game = new GameEnvironment();
    	game.launchSetupPage();
    }
    
}
