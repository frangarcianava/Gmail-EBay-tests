package pom;

import constants.Constants;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailLoginPage extends BasePage{

    public GmailLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="identifierId")
    private WebElement emailField;

    @FindBy(css = "input[type=\"password\"]")
    private WebElement passwordField;

    @FindBy(css = "[role=\"presentation\"] [aria-live=\"assertive\"] > div > span")
    private WebElement invalidPasswordMessage;

    @FindBy(css = "div > h1")
    private WebElement couldnSignInTitle;

    public void fillCorrectEmail(){
        log.info("Filling Email");

        completeField(emailField, Constants.EMAIL);
        emailField.sendKeys(Keys.ENTER);
    }

    public GmailMainPage fillCorrectPassword(){
        log.info("Filling password");

        completeField(passwordField, Constants.PASSWORD);
        passwordField.sendKeys(Keys.ENTER);
        return new GmailMainPage(getDriver());
    }

    public boolean fillIncorrectEmail() {
        log.info("Filling Email");

        completeField(emailField, Constants.WRONGEMAIL);
        emailField.sendKeys(Keys.ENTER);

        return couldnSignInTitle.isDisplayed();
    }

    public boolean fillIncorrectPassword(){
        log.info("Filling password");
        completeField(passwordField, Constants.WRONGPASSWORD);
        passwordField.sendKeys(Keys.ENTER);

        return invalidPasswordMessage.isDisplayed();
    }
}
