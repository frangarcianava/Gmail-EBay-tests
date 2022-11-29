package tests;

import driver.MyDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import pom.*;

public class BaseTest {

    protected static MyDriver myDriver;
    protected static Logger log = LogManager.getLogger();
    protected static GmailLoginPage gmailLoginPage;
    protected static GmailMainPage gmailMainPage;
    protected static EbayMainPage ebayMainPage;
    protected static EbayResultsPage ebayResultsPage;
    protected static EbayProductPage ebayProductPage;

    @Parameters({"browser","url"})
    @BeforeClass(alwaysRun = true)
    public void setUp(String browser, String url) {
        log.info("Setting Up the driver...");
        myDriver = new MyDriver(browser, url);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        log.info("Closing the session...");
        myDriver.getDriver().quit();
    }
}
