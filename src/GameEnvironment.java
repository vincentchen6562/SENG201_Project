package src;
import src.pages.*;

public class GameEnvironment {
	
    public void launchSetupPage() {
    	SetupPage setupPage = new SetupPage(this);
    }
    
    public void closeSetupPage(SetupPage setupWindow) {
    	setupWindow.closeWindow();
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
    
    
    
    public static void main(String [] args) {
    	GameEnvironment game = new GameEnvironment();
    	game.launchSetupPage();
    }
    
}
