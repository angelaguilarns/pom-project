package pages;

import org.openqa.selenium.support.FindBys;
import settings.BasePage;

import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(xpath = "//li[.='Popular']")
    private WebElement popularProductsButton;

    @FindBy(xpath = "//li[.='Best Sellers']")
    private WebElement bestSellerProductsButton;

    @FindBy(css = "#developers_list a")
    private List<WebElement> gameDevelopers;

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickPopularProductsButton(){
        this.click(popularProductsButton);
        String is_active = popularProductsButton.getAttribute("class");
        Assert.assertEquals(is_active,"active");
    }

    public void clickBestSellerProductsButton(){
        this.click(bestSellerProductsButton);
        String is_active = bestSellerProductsButton.getAttribute("class");
        Assert.assertEquals(is_active,"active");
    }


}

