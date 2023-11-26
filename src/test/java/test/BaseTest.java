package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.HomePage;

public class BaseTest {
    // Protected cada variable que voy a heredar
    protected WebDriver driver = null;

    HomePage homePage;

    @BeforeTest
    public void beforeTest() {
        String driverPath = "D:\\workspace\\chromedriver-win64\\chromedriver.exe";
        // Agregar a la propiedad de sistema la ruta al
        // ejecutable de chromedriver
        System.setProperty("webdriver.chrome.driver", driverPath);
        // Ahora si setear el driver antes de cada prueba
        driver = new ChromeDriver();
    }

    @AfterTest
    public void afterTest() {
        // De todas formas, se recomienda quit() en lugar de close(),
        // para cerrar completamente el navegador y liberar recursos
        if (driver != null){
            driver.close();
        }
    }

    //METODO PARA OBTENER EL HOMEPAGE
    public HomePage getHomePage(String url) {
        return new HomePage(driver, url);
    }
}
