package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EbayProductPage extends BasePage{
    public EbayProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "span[itemprop=\"price\"]")
    private WebElement price;

    public String getPrice(){
        waitElementToBeVisible(price);
        return price.getText();
    }


}
