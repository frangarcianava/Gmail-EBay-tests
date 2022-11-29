package tests;

import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.EbayMainPage;

public class EbayTest extends BaseTest {
    @Test(priority = 1, description = "Validate that the product searched is the same of the one showed in the results.")
    public void validateProductSearched(){
        log.info("Opening EBay main page...");
        ebayMainPage = new EbayMainPage(myDriver.getDriver());
        ebayResultsPage = ebayMainPage.searchForProduct();

        log.info("Validating that is the correct product...");
        Assert.assertEquals(ebayResultsPage.getProductSearched(), Constants.PRODUCT, "The product doesn't match with the one searched.");
    }

    @Test(priority = 2, description = "Outputting the first product price...")
    public void outputItemPrice(){
        log.info("Opening first product...");
        ebayProductPage = ebayResultsPage.getPriceOfFirstProduct();

        log.info("Printing the price of the first product...");
        System.out.println("The price of the product: "+ ebayProductPage.getPrice());
    }
}
