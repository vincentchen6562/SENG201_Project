package src;

import src.pages.*;

/**
 * Represents the game environment for managing different pages and launching the game.
 */
public class GameEnvironment {
    private Game game;

    /**
     * Sets the game object.
     *
     * @param game the game object to set
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Retrieves the game object.
     *
     * @return the game object
     */
    public Game getGame() {
        return this.game;
    }

    /**
     * Launches the setup page.
     */
    public void launchSetupPage() {
        SetupPage setupPage = new SetupPage(this);
    }

    /**
     * Closes the setup page and launches the game page.
     *
     * @param setupPage the setup page to close
     */
    public void closeSetupPage(SetupPage setupPage) {
        setupPage.closeWindow();
        launchGamePage();
    }

    /**
     * Launches the game page.
     */
    public void launchGamePage() {
        GamePage gamePage = new GamePage(this);
    }

    /**
     * Closes the game page.
     *
     * @param mainPage the game page to close
     */
    public void closeGamePage(GamePage mainPage) {
        mainPage.closeWindow();
    }

    /**
     * Launches the market choice page.
     */
    public void launchMarketChoicePage() {
        MarketChoicePage marketChoicePage = new MarketChoicePage(this);
    }

    /**
     * Closes the market choice page and launches the game page.
     *
     * @param marketChoicePage the market choice page to close
     */
    public void closeMarketChoicePage(MarketChoicePage marketChoicePage) {
        marketChoicePage.closeWindow();
        launchGamePage();
    }

    /**
     * Launches the item market page.
     */
    public void launchItemMarketPage() {
        ItemMarketPage itemMarketPage = new ItemMarketPage(this);
    }

    /**
     * Closes the item market page and launches the market choice page.
     *
     * @param itemMarketPage the item market page to close
     */
    public void closeItemMarketPage(ItemMarketPage itemMarketPage) {
        itemMarketPage.closeWindow();
        launchMarketChoicePage();
    }

    /**
     * Launches the athlete market page.
     */
    public void launchAthleteMarketPage() {
        AthleteMarketPage athleteMarketPage = new AthleteMarketPage(this);
    }

    /**
     * Closes the athlete market page and launches the market choice page.
     *
     * @param athleteMarketPage the athlete market page to close
     */
    public void closeAthleteMarketPage(AthleteMarketPage athleteMarketPage) {
        athleteMarketPage.closeWindow();
        launchMarketChoicePage();
    }

    /**
     * Launches the rest page.
     */
    public void launchRestPage() {
        RestPage restPage = new RestPage(this);
    }

    /**
     * Closes the rest page and launches the game page.
     *
     * @param restPage the rest page to close
     */
    public void closeRestPage(RestPage restPage) {
        restPage.closeWindow();
        launchGamePage();
    }

    /**
     * Launches the stadium page.
     */
    public void launchStadiumPage() {
        StadiumPage stadiumPage = new StadiumPage(this);
    }

    /**
     * Closes the stadium page and launches the game page.
     *
     * @param stadiumPage the stadium page to close
     */
    public void closeStadiumPage(StadiumPage stadiumPage) {
    	stadiumPage.closeWindow();
    	launchGamePage();
    }
    
	/**
	 * Launches the team page.
	 */
    public void launchTeamPage() {
    	TeamPage teamPage = new TeamPage(this);
    }
    
	/**
	 * Closes the team page and launches the game page.
	 * @param teamPage the team page to close
	 */
    public void closeTeamPage(TeamPage teamPage) {
    	teamPage.closeWindow();
    	launchGamePage();
    }
    
	/**
	 * launches the match page
	 * @param oppTeamName the opponent team name for the match
	 * @param reward the reward for winning the match
	 */
    public void launchMatchPage(String oppTeamName, int reward) {
    	MatchPage newMatch = new MatchPage(this, oppTeamName, reward); // TODO maybe pass a stadium object
    }
    
	/**
	 * Closes the match patch and launches the gamepage 
	 * unless the current week is greater than the total weeks set by the user
	 * @param matchPage the match page to be closed
	 */
    public void closeMatchPage(MatchPage matchPage) {
    	matchPage.closeWindow();
    	int currentWeek = this.getGame().getCurrentWeek();
    	int totalWeek = this.getGame().getWeek();
    	if (currentWeek <= totalWeek) {
    		launchGamePage();
    	} else {
    		launchGameOverPage();
    	}
    	
    }
    /**
	 * launches the game over page
	 */
    public void launchGameOverPage() {
    	GameOverPage gameOver = new GameOverPage(this);
    }
    /**
	 * GameEnvironment's main method; runs the setupPage to initialize the game
	 * @param args the command line arguments
	 */
    public static void main(String [] args) {
    	GameEnvironment game = new GameEnvironment();
    	game.launchSetupPage();
    }
    
}
