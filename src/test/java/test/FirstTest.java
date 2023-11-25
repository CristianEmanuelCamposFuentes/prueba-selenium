package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FirstTest {

    // Inicializar la instancia del navegador
    WebDriver driver = null;

    @Test
    public void testWiki() {
        driver.manage().window().maximize();

        // Vamo a guglea
        driver.navigate().to("https://www.wikipedia.com");

        // Esto hace referencia a los elementos Web, esto es para la barra de busqueda
        WebElement searchInput = driver.findElement(By.id("searchInput"));

        // La lleno con la palabra a buscar
        searchInput.sendKeys("Selenium");

        // Ahora agrego el WebElement que es el boton de busqueda
        // Como no tiene ID en este caso, no funciona
//        WebElement searchButton = driver.findElement(By.id("searchButton"));
//        searchButton.click();

        // Con selector CSS
//        WebElement searchButton = driver.findElement(By.cssSelector("#search-form > fieldset > button"));
//        searchButton.click();

        // Con Xpath
        WebElement searchButton = driver.findElement(By.xpath("//*[@id='search-form']/fieldset/button"));
        searchButton.click();

        WebElement footerLink = driver.findElement(By.cssSelector("#mw-normal-catlinks > ul > li:nth-child(1) > a"));

        Assert.assertTrue(footerLink.isDisplayed());
        Assert.assertEquals(footerLink.getText(), "Pruebas de software");

        // Listas de elementos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        List<WebElement> menuSelenium_list =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("vector-toc-list")));

        Assert.assertTrue(!menuSelenium_list.isEmpty());

        Assert.assertEquals(menuSelenium_list.size(), 9);
    }
}
