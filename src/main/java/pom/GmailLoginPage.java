package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailLoginPage extends BasePage{

    public GmailLoginPage(WebDriver driver) {
        super(driver);
    }

    public static final String EMAIL = "franciscogarcianava93@gmail.com";
    public static final String PASSWORD = "Fran0000.";

    @FindBy(id="identifierId")
    private WebElement emailField;

    @FindBy(css = "input[type=\"password\"]")
    private WebElement passwordField;

    @Step("Login with valid credentials")
    public GmailMainPage goToMainPage(){
        log.info("Filling Email");
        fillEmail();

        log.info("Filling password");
        fillPassword();

        return new GmailMainPage(getDriver());
    }

    public void fillEmail(){
        completeField(emailField, EMAIL);
        emailField.sendKeys(Keys.ENTER);
    }

    public void fillPassword(){
        completeField(passwordField, PASSWORD);
        passwordField.sendKeys(Keys.ENTER);
    }
}
