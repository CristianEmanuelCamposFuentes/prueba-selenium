package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;


public class SecondTest {
    WebDriver driver = null;
    HomePage homePage;
    SoftAssert softAssert = new SoftAssert();

    @BeforeTest
    public void beforeTest() {
        String driverPath = "D:\\workspace\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        homePage = new HomePage(driver, "https://www.wikipedia.org/");
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }

    @Test
    public void testWikipedia() {

        homePage.setSearchInput("Selenium");

        homePage.clickOnOptions();

        softAssert.assertEquals(homePage.getMainHeaderText(), "Seleniuro de cinc");

//        homePage.clickOnSearch();

        softAssert.assertAll();

//        driver.close();
    }
}
