package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import settings.BasePage;

public class GamePage extends BasePage {
    @FindBy(css = ".apphub_AppName")
    private WebElement gameTittle;

    @FindBy(xpath = "//div[@class='details_block'][1]")
    private WebElement gameDetailsBox;

    public void validateGameTittleOnPage(String gameSearch){
        waitElementToAppear(gameTittle);
        validateText(gameTittle.getText(), gameSearch.toLowerCase());
        System.out.println("You are on page of game: "+gameSearch.toUpperCase());
    }

    public void scrollToGameDetails(){
        scrollToElement(gameDetailsBox);
    }

    public void validateGameDetails(String expectedDetails){
        String templateNoRelease = gameDetailsBox.getText().substring(0,gameDetailsBox.getText().length()-26);
        System.out.println("You are expecting following Game Details:\n"+templateNoRelease);
        validateText(expectedDetails,templateNoRelease);
    }

    public GamePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
