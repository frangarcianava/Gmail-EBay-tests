package tests;

import driver.MyDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import pom.GmailLoginPage;
import pom.GmailMainPage;

public class BaseTest {
//    - Navigate to gmail.com page
//- Login using valid credentials
//- Verify success login by user profile icon in top right corner

    protected static MyDriver myDriver;
    protected static Logger log = LogManager.getLogger();
    protected static GmailLoginPage gmailLoginPage;
    protected static GmailMainPage gmailMainPage;

    @Parameters({"browser"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String browser) {
        log.info("Setting Up the driver...");
        myDriver = new MyDriver(browser);
        gmailLoginPage = new GmailLoginPage(myDriver.getDriver());
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        log.info("Closing the session...");
        gmailMainPage.dispose();
        myDriver.getDriver().quit();
    }
}
