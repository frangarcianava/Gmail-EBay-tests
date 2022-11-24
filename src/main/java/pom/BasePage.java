package pom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage
{
    private final WebDriver driver;
    private final WebDriverWait wait;
    protected static Logger log = LogManager.getLogger();

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.driver = driver;
    }

    protected WebDriverWait getWait(){
        return wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    void waitElementToBeVisible(WebElement webElement){
        getWait().until(ExpectedConditions.visibilityOf(webElement));
    }

    void waitElementToBeClickable(WebElement webElement){
        getWait().until(ExpectedConditions.elementToBeClickable(webElement));
    }

    void completeField(WebElement field, String text){
        waitElementToBeVisible(field);
        log.info("Sending "+ text);
        field.sendKeys(text);
    }

    void clickOnElement(WebElement webElement){
        waitElementToBeClickable(webElement);
        log.info("Clicking on "+webElement.getText());
        webElement.click();
    }

    public void dispose() {
        if (driver != null) {
            driver.quit();
        }
    }

}
