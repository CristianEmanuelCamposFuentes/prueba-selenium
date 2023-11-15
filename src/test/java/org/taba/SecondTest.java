package org.taba;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

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
//        driver.manage().window().maximize();
        // Ya seteado el driver, comenzamos a utilizarlo. Navegar a Wikipedia
        driver.navigate().to("https://www.wikipedia.org/");

        WebElement searchInput = wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//*[@id=\"searchInput\"]"))));
        WebElement footerLink = driver.findElement(By.cssSelector("#www-wikipedia-org > div.footer > div:nth-child(1) > div > div:nth-child(3) > a > span"));

        // Escribir en el input
        searchInput.sendKeys("Seleccion Argentina");

        softAssert.assertEquals(footerLink.getText(), "Puedes apoyar nuestro trabajo con una donación.");

        driver.close();
    }
}
