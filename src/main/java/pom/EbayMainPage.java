package pom;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EbayMainPage extends BasePage{
    public EbayMainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gh-ac")
    private WebElement searchField;

    @FindBy(id = "gh-btn")
    private WebElement searchBtn;

    public EbayResultsPage searchForProduct(){
        completeField(searchField, Constants.PRODUCT);
        clickOnElement(searchBtn);
        return new EbayResultsPage(getDriver());
    }
}
