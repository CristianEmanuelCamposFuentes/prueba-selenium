package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;



public class SecondTest extends BaseTest {
    HomePage homePage;
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testWikipedia() {
        homePage = new HomePage(driver, "https://www.wikipedia.com");
        homePage.setSearchInput("Selenium");

        homePage.clickOnOptions();

        softAssert.assertEquals(homePage.getMainHeaderText(), "Seleniuro de cinc");
//        homePage.clickOnSearch();
        softAssert.assertAll();
    }
}
