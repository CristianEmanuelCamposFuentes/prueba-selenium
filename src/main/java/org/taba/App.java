package org.taba;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws InterruptedException {
        // Agregar a la propiedad de sistema la ruta al
        // ejecutable de chromedriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\crist\\IdeaProjects\\PruebaSelenium\\src\\main\\resources\\drivers\\chromedriver.exe");

        // Inicializar el navegador
        WebDriver driver = new ChromeDriver();

        // Abrir pagina de Google
        driver.get("https://www.google.com");

        // Maximizar el navegador
        driver.manage().window().maximize();

        Thread.sleep(2000);
        // Cerrar el navegador
        driver.close();
    }
}