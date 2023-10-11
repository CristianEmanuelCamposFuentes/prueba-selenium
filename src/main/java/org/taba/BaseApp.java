package org.taba;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseApp {
    // El WebDriver es la instancia del navegador donde usamos Selenium
    // Objeto estatico para el driver
    protected static WebDriver driver;
    // Objeto estatico para el wait que gestiona las esperas
    protected static WebDriverWait wait;
    // El objeto Actions realiza las acciones de interaccion del teclado y el mouse
    protected static Actions actions;

    // Bloque estatico para el drive para todas las instancias futuras de otras clases de pagina
    // Le agrego una espera de 10seg
    static {
        // A futuro va a servir para personalizar configuraciones de datos(perfil, extensiones, etc)
        ChromeOptions chromeOptions = new ChromeOptions();
        // Setear navegador
        driver = new ChromeDriver(chromeOptions);
        // Setear espera
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Setear acciones
        actions = new Actions(driver);

    }

    public BaseApp(WebDriver driver) {
        BaseApp.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void navigateTo(String url){
        // get() carga una pagina web nueva en la ventana del navegador actual
        driver.get(url);
    }

    public static void closeBrowser(){
        driver.quit();
    }

    public void initializeDriver() {
        // Agregar a la propiedad de sistema la ruta al
        // ejecutable de chromedriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\crist\\IdeaProjects\\PruebaSelenium\\src\\main\\resources\\drivers\\chromedriver.exe");
        // Inicializar el navegador
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}