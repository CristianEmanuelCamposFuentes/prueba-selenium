package org.taba;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class SecondTest {
    WebDriver driver = null;

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testWikipedia(){
        String driverPath = "D:\\workspace\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();

        // Espera
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Ya seteado el driver, comenzamos a utilizarlo. Navegar a Wikipedia
        driver.navigate().to("https://www.wikipedia.org/");

        WebElement searchInput = wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//*[@id=\"searchInput\"]"))));

        // Escribir en el input
        searchInput.sendKeys("Seleccion Argentina");



        // Elegir una opcion de la lista
        WebElement listOption = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#typeahead-suggestions > div > a:nth-child(6) > div.suggestion-text > h3")));
        listOption.click();

        WebElement headerTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#firstHeading > span")));
        softAssert.assertEquals(headerTitle.getText(),"Equipo de Copa Davis de Argentina");

        // Analizando lista
        List<WebElement> playersList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector(".references > li")));

        // Comprueba si la lista es de 5 elementos
        softAssert.assertEquals(playersList.size(),5);

        // Comprueba si el titulo esta desplegado
        softAssert.assertTrue(headerTitle.isDisplayed());

        softAssert.assertAll();

        driver.close();
    }
}
