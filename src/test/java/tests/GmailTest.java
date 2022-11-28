package tests;

import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GmailTest extends BaseTest{

    @Test(priority = 1, description = "Verify error messages with invalid credentials")
    public void validateUsernameError(){
        log.info("Validate result with incorrect email");
        Assert.assertTrue(gmailLoginPage.fillIncorrectEmail(), "The email is correct and this negative case cannot be validated.");
    }

    @Test(priority = 2, description = "Verify error when password is incorrect")
    public void validatePasswordError(){
        log.info("Validate result with incorrect password");
        myDriver.getDriver().navigate().refresh();

        gmailLoginPage.fillCorrectEmail();
        Assert.assertTrue(gmailLoginPage.fillIncorrectPassword(), "The password is correct and this negative case cannot be validated.");
    }

    @Test(priority = 3, description = "Verify success on login")
    public void validateUserIsLoggedCorrectly(){
        log.info("Validating that user is logged correctly...");

        gmailMainPage = gmailLoginPage.fillCorrectPassword();
        Assert.assertTrue(gmailMainPage.btnRedactarIsPresent(), "The user is not on the main page.");
        Assert.assertTrue(gmailMainPage.getLoggedEmail().contains(Constants.EMAIL), "The user logged is not correct.");
    }

}
