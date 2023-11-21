package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

import java.time.Duration;
import java.util.List;

public class SecondTest{
    WebDriver driver = null;
    HomePage homePage;
    SoftAssert softAssert = new SoftAssert();
    @BeforeTest
    public void beforeTest(){
        String driverPath = "D:\\workspace\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        homePage = new HomePage(driver, "https://www.wikipedia.org/");
    }

    @Test
    public void testWikipedia(){
        // Espera
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        homePage.setSearchInput("Selenium");

        homePage.clickOnOptions();

        softAssert.assertEquals(homePage.getMainHeaderText(),"Equipo de Copa Davis de Argentina");

        // Analizando lista
        List<WebElement> playersList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector(".references > li")));

        // Comprueba si la lista es de 5 elementos
        softAssert.assertEquals(playersList.size(),5);

        // Comprueba si el titulo esta desplegado
//        softAssert.assertTrue(headerTitle.isDisplayed());

        softAssert.assertAll();

        driver.close();
    }
}
