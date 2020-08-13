package settings;

import components.NavBar;
import org.testng.annotations.*;
import settings.DriverSetup;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

abstract public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    @org.testng.annotations.Parameters(value = {"browser"})
    public void suitSetup(String browser) throws MalformedURLException {
        this.driver = new DriverSetup("chrome", false, true).getDriver();
        this.driver.get("https://store.steampowered.com/");
        System.out.println("Browser from beforesiote "+browser);
        System.out.println("Running before test");

    }

    @AfterSuite
    public void suitTearDown(){
        this.driver.close();
        this.driver.quit();
    }

}
