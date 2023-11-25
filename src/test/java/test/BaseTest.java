package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    WebDriver driver = null;

    @BeforeTest
    public void beforeTest() {
        String driverPath = "D:\\workspace\\chromedriver-win64\\chromedriver.exe";
        // Agregar a la propiedad de sistema la ruta al
        // ejecutable de chromedriver
        System.setProperty("webdriver.chrome.driver", driverPath);
        // Ahora si setear el driver
        driver = new ChromeDriver();
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }
}
