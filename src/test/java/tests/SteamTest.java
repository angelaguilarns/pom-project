package tests;

import components.NavigationBar;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import settings.BaseTest;

public class SteamTest extends BaseTest {

    NavigationBar navigationBar;
    @BeforeTest
    public void setUp(){
        navigationBar = new NavigationBar(driver);
        navigationBar.writeTextOnSearchInput("Testing nav bar before test");
        navigationBar.cleanTextOnSearchInput();
    }

    @Test
    public void validateSuggestedGames(){
        String gameToSearch = "slug";
        navigationBar.writeTextOnSearchInput(gameToSearch);
        int foundedGames = navigationBar.getSuggestedGames().size();
        Assert.assertTrue(foundedGames>=4);
        System.out.println("There are "+foundedGames+" displayed games");

        for (String game : navigationBar.getSuggestedGames()){
            Assert.assertTrue(game.toLowerCase().contains(gameToSearch));
            System.out.println(game+" contain the word "+gameToSearch);
        }
    }

}
