package settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver,WaitingTimeSetup.getWaitForElement());
        actions = new Actions(this.driver);
    }

    public void waitElementToAppear(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementToClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void enterText(WebElement element, String text){
        waitElementToAppear(element);
        element.sendKeys(text);
    }
}
