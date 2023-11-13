package org.taba;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

    // Inicializar la instancia del navegador
    WebDriver driver = null;

    @Test
    public void testWiki(){
        String driverPath = "D:\\workspace\\chromedriver-win64\\chromedriver.exe";
        // Agregar a la propiedad de sistema la ruta al
        // ejecutable de chromedriver
        System.setProperty("webdriver.chrome.driver", driverPath);
        // Ahora si setear el driver
        driver = new ChromeDriver();

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


//        driver.close();
        WebElement footerLink = driver.findElement(By.cssSelector("#mw-normal-catlinks > ul > li:nth-child(1) > a"));

        Assert.assertTrue(footerLink.isDisplayed());
        Assert.assertEquals(footerLink.getText(), "Pruebas de software");

        // Listas de elementos
        List<WebElement> menuSelenium_list = driver.findElements(By.className("vector-toc-list"));
        Assert.assertTrue(!menuSelenium_list.isEmpty());
    }
}
