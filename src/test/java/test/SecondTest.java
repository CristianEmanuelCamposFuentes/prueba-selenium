package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;


public class SecondTest extends BaseTest {
    WebDriver driver = null;
    HomePage homePage;
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testWikipedia() {

        homePage.setSearchInput("Selenium");

        homePage.clickOnOptions();

        softAssert.assertEquals(homePage.getMainHeaderText(), "Seleniuro de cinc");
//        homePage.clickOnSearch();
        softAssert.assertAll();
    }
}
