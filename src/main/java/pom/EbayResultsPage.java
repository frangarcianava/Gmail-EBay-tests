package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class EbayResultsPage extends BasePage{
    public EbayResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h1 > span:nth-child(2)")
    private WebElement productSearched;

    @FindBy(css = "ul > [class*=\"s-item\"] [class=\"s-item__link\"]")
    private List<WebElement> listOfProducts;

    public String getProductSearched(){
        return productSearched.getText();
    }

    public EbayProductPage getPriceOfFirstProduct(){
        switchBetweenTabs();
        return new EbayProductPage(getDriver());
    }

    public void switchBetweenTabs(){
        String originalWindow = getDriver().getWindowHandle();
        clickOnElement(listOfProducts.get(0));

        getWait().until(numberOfWindowsToBe(2));
        for (String windowHandle : getDriver().getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }






}
