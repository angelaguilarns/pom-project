package settings;

import settings.DriverSetup;
import components.NavigationBar;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void suitSetup(){
        driver = new DriverSetup("chrome",false).getDriver();
        driver.get("https://store.steampowered.com/");
    }

    @AfterSuite
    public void suiteTearDown(){
        driver.close();
        driver.quit();
    }
}
