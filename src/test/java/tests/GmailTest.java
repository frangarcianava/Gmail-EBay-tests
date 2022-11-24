package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pom.GmailLoginPage;

public class GmailTest extends BaseTest{

    @Test(description = "Verify success on login")
    public void validateGmailSuccessfulLogin(){
        gmailMainPage = gmailLoginPage.goToMainPage();

        log.info("Checking if the main page is opened...");
        Assert.assertTrue(gmailMainPage.btnRedactarIsPresent(), "The user is not on the main page.");

        log.info("Checking if the user is correctly logged...");
        Assert.assertTrue(gmailMainPage.getLoggedEmail().contains(GmailLoginPage.EMAIL), "The user logged is not correct.");
    }

}
