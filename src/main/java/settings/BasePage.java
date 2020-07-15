package settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

abstract public class BasePage {

    private static final int TIMEOUT = 5;

    protected WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, TIMEOUT);
        actions = new Actions(this.driver);
    }

    public void waitForElementToAppear(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementBeClickable(WebElement element){ wait.until(ExpectedConditions.elementToBeClickable(element)); }

    public void click(WebElement element) {
        this.waitForElementToAppear(element);
        this.waitForElementBeClickable(element);
        element.click();
    }

    public void writeInInput(WebElement element, String message){
        this.waitForElementToAppear(element);
        element.sendKeys(message);
    }

    public void hoverElement(WebElement element){
        this.waitForElementToAppear(element);
        actions.moveToElement(element).perform();
    }

    //A list with the expected conditions that we can use for explicit waits
    //https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html

    public boolean isTextPresentOnElement(WebElement element, String text){
        this.waitForElementToAppear(element);
        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void waitForElementsToAppear(List<WebElement> elements){
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public boolean elementAttributeIs(WebElement element, String attribute, String value){
        this.waitForElementToAppear(element);
        return wait.until(ExpectedConditions.attributeContains(element, attribute, value));
    }

    //HomeWork
    /*
    * Create a function that accepts like a parameter retry value and a WebElement
    * This function will retry to click the WebElement the integer assigned to value.
    *
    * Example -> retryClick(fancyButtonElement, 3)
    *
    * */

    public void retryClickElement(WebElement element, int times){
        boolean flag = false;
        for (int i=0; i<times; i++){
            try {
                waitForElementToAppear(element);
                element.click();
                flag = true;
                break;
            }catch (Exception e){
                System.out.println("Element not found. Retrying click on element: "+element);
            }
        }
        Assert.assertTrue(flag,"Element '"+element+"' was never found.");
    }

}

