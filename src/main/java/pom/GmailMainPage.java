package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailMainPage extends BasePage{

    public GmailMainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[role=\"navigation\"] > div > div > [role=\"button\"]")
    private WebElement redactarBtn;

    @FindBy(css = "[role=\"button\"][aria-label*=\"Francisco\"]")
    private WebElement userProfileBtn;

    public boolean btnRedactarIsPresent(){
        waitElementToBeVisible(redactarBtn);
        return redactarBtn.isDisplayed();
    }

    public String getLoggedEmail(){
        return userProfileBtn.getAttribute("aria-label");
    }
}
